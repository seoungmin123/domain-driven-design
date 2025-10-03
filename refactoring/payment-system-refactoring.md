# 결제 시스템 리팩토링 과정

## 리팩토링 전 코드 (pay0)

- [PayService.java](../src/main/java/com/example/domain_driven/poly/ex/pay0/PayService.java)
- [KakaoPay.java](../src/main/java/com/example/domain_driven/poly/ex/pay0/KakaoPay.java)
- [NaverPay.java](../src/main/java/com/example/domain_driven/poly/ex/pay0/NaverPay.java)
- [PayMain0.java](../src/main/java/com/example/domain_driven/poly/ex/pay0/PayMain0.java)

## 리팩토링 후 코드 (pay2)

- [Pay.java](../src/main/java/com/example/domain_driven/poly/ex/pay2/Pay.java)
- [PayService.java](../src/main/java/com/example/domain_driven/poly/ex/pay2/PayService.java)
- [PayStore.java](../src/main/java/com/example/domain_driven/poly/ex/pay2/PayStore.java)
- [KakaoPay.java](../src/main/java/com/example/domain_driven/poly/ex/pay2/KakaoPay.java)
- [NaverPay.java](../src/main/java/com/example/domain_driven/poly/ex/pay2/NaverPay.java)
- [NewPay.java](../src/main/java/com/example/domain_driven/poly/ex/pay2/NewPay.java)
- [DefaultPay.java](../src/main/java/com/example/domain_driven/poly/ex/pay2/DefaultPay.java)
- [PayMain1.java](../src/main/java/com/example/domain_driven/poly/ex/pay2/PayMain1.java)
- [PayMain2.java](../src/main/java/com/example/domain_driven/poly/ex/pay2/PayMain2.java)

## 원본 코드의 문제점

### PayService 클래스의 두 가지 주요 문제
1. **강한 결합 (Tight Coupling)**: `new KakaoPay()`, `new NaverPay()` 등 구체적인 클래스를 직접 알고 있어 의존성이 높음
2. **단일 책임 위반**: "결제 수단 선택"과 "결제 실행"이라는 두 가지 책임을 동시에 수행

---

## 리팩토링 단계별 사고 과정

### 1단계: 다형성 적용
- **문제 인식**: PayService가 구체 클래스(KakaoPay, NaverPay)를 직접 의존
- **해결**: `Pay` 인터페이스 생성으로 추상화
- **효과**: 구현체 교체 가능, 확장에 유리

### 2단계: 중복 제거
- **문제 인식**: if-else 분기마다 객체 생성 → pay() 호출 로직 반복
- **해결**: 인터페이스 타입(`Pay`)으로 통일하여 중복 제거

### 3단계: 책임 분리
- **문제 인식**: PayService가 결제 수단 선택 로직까지 담당
- **해결**: 선택 로직을 별도 메서드로 추출

### 4단계: 클래스 분리
- **문제 인식**: 새 결제 수단 추가 시 PayService 수정 필요 (OCP 위반)
- **해결**: `PayStore` 클래스로 결제 수단 선택 로직 완전 분리
- **효과**: PayService는 이제 구체적인 구현체를 전혀 모름 (역할만 의존)

### 5단계: Null Object 패턴 적용
- **문제 인식**: 잘못된 결제 수단 입력 시 null 반환 → NullPointerException 위험
- **해결**: `DefaultPay` 클래스 구현으로 null 대신 기본 동작 객체 반환
- **효과**: null 체크 불필요, 안전한 코드

---

## 최종 결과

### 개선된 구조
- **PayService**: 결제 프로세스 관리만 담당 (단일 책임)
- **PayStore**: 결제 수단 선택 로직 담당 (변경 격리)
- **Pay 인터페이스**: 다형성을 통한 유연한 확장
- **DefaultPay**: Null Object 패턴으로 안전성 확보

### 적용된 원칙
- **OCP (개방-폐쇄 원칙)**: 새 결제 수단 추가 시 PayStore만 수정
- **DIP (의존 역전 원칙)**: 구체 클래스가 아닌 인터페이스 의존
- **SRP (단일 책임 원칙)**: 각 클래스가 하나의 책임만 수행
- **Null Object Pattern**: null 처리의 안전성 확보

### 확장성
`NewPay` 추가 시에도 기존 코드 변경 최소화 (PayStore만 수정)