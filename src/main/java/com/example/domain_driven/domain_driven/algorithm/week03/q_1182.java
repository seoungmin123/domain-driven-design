package com.example.domain_driven.domain_driven.algorithm.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_1182 {
    static int N, S;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 수열을 만들 숫자 갯수
        S = Integer.parseInt(st.nextToken()); // 원하는 합

        arr = new int[N];  //수열로 들어온 숫자 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(0, 0);

        // S가 0인 경우 공집합을 제외해야 함
        if (S == 0) count--;

        System.out.println(count);
    }

    // index: 현재 확인할 원소의 인덱스
    // sum: 현재까지의 부분수열 합
    private static void backtrack(int index, int sum) {
        // 모든 원소를 확인한 경우
        if (index == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        // 현재 원소를 선택하는 경우
        backtrack(index + 1, sum + arr[index]);

        // 현재 원소를 선택하지 않는 경우
        backtrack(index + 1, sum);
    }
}