package com.example.domain_driven.domain_driven.algorithm.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

//        String[] inputStr = br.readLine().split(" ");
//        int[] P = new int[n+1];  // P[1]부터 사용
//        for (int i = 1; i <= n; i++) {
//            P[i] = Integer.parseInt(inputStr[i-1]);  // 0번째 입력 → P[1]
//        }

        int[] P = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, P));
    }

    private static int solution(int n, int[] P) {
        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) { //기준점이 되는 카드갯수
            for (int j = 1; j <= i; j++) { //마지막으로 구매한 카드갯수
                dp[i] = Math.max(dp[i], dp[i-j] + P[j]);
            }
        }
        return dp[n];
    }
}

//
//i=1 한개팩을 사는 제일 큰 금액
//j=1 i-j -> 0 , 1
//
//i=2 두개팩을 사는 제일 큰 금액
//j=1 i-j -> 1 , 1 한팩한팩씩 살때
//j=2 i-j -> 0 , 2 안사고 두개 살때
//
//목표: 4개 카드를 가장 비싸게 사기
//
//하지만 4개를 사는 방법은:
//        - 3개 + 1개팩
//- 2개 + 2개팩
//- 1개 + 3개팩
//- 0개 + 4개팩
//
//→ 3개, 2개, 1개를 "최대한 비싸게 사는 법"을 먼저 알아야
//  4개를 최대한 비싸게 살 수 있다
//
//
//i 몇개의 카드를 사야하는가 -> 이전 함수를 재활용해야해서 for문
//dp[i] = i개를 사는 모든 방법 중 최댓값
//j = 마지막에 선택할 카드팩 종류 (j개 들어있는 팩)
//dp[i-j] = 나머지 (i-j)개를 사는 최적 방법
//
//


