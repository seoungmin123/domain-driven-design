package com.example.domain_driven.domain_driven.algorithm.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_11055_v2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, arr));
    }

    private static int solution(int n, int[] arr) {
        int[] dp = new int[n]; //각각 수열의 합 저장
        int maxSum = 0;

        //어디서부터 시작하는지 기준점이 되려고
        for (int i = 0; i < n; i++) {  //1 100 2 50 60 3 5 6 7 8
            dp[i] = arr[i];  // 자기 자신으로 초기화
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) { //이전보단 커야하고
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                    //기준점 dp[i]와 비교할 dp[j]+arr[i]
                    //              이미 더한값 + 새로 더할값
                }
            }
            maxSum = Math.max(maxSum, dp[i]);  // 최댓값 갱신
        }
        return maxSum;
    }
}

/*
 * 개선 사항:
 * 1. 배열 인덱스 0부터 사용 (1부터 시작할 필요 없음)
 * 2. 최댓값을 dp 계산 중에 바로 추적 (별도 반복문 제거)
 * 3. 불필요한 공간 제거 (n+1 -> n)
 *
 * 시간복잡도: O(n²) - 동일
 * 공간복잡도: O(n) - 동일
 *
 * 추가 최적화 (고급):
 * - 세그먼트 트리/펜윅 트리 사용 시 O(n log n) 가능
 * - 하지만 n ≤ 1000 정도면 O(n²)로 충분!
 */