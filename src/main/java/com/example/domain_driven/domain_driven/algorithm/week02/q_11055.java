package com.example.domain_driven.domain_driven.algorithm.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] inputStr = br.readLine().split(" ");
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(inputStr[i - 1]);
        }

        System.out.println(solution(n, arr));

    }

    private static int solution(int n, int[] arr) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = arr[i];  // 먼저 자기 자신으로 초기화 -> 똑같은걸로 비교해야함

            for (int j = 1; j < i; j++) {  // j도 1부터 시작
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]); //비교대상과 dp에 들어있는값
                }
            }
        }

        // 최댓값 찾기
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}