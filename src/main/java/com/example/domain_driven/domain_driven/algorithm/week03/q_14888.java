package com.example.domain_driven.domain_driven.algorithm.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_14888 {
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;

    static int[] numbers;
    static int[] operators;
    static int operatorsNum = 4;
    static int N ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[N]; //숫자
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        operators = new int[operatorsNum]; // + - * / 순서
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < operatorsNum; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        // 백트래킹 시작 (첫 번째 숫자부터 시작)
        dfs(numbers[0], 1);

        System.out.println(maxValue);
        System.out.println(minValue);

    }

    private static void dfs(int result, int depth){
    //첫번쨰 숫자와 뎁스를 넣고

        //1. 모든 숫자를 다 확인 한경우
        if(depth == N){
            maxValue = Math.max(maxValue, result);
            minValue = Math.min(minValue, result);
            return;
        }

        // 4가지 연산자를 각각 시도
        for (int i = 0; i < operatorsNum; i++) {
            if (operators[i] > 0) {
                operators[i]--; // 연산자 사용

                if (i == 0) { // 덧셈
                    dfs(result + numbers[depth], depth + 1);
                } else if (i == 1) { // 뺄셈
                    dfs(result - numbers[depth], depth + 1);
                } else if (i == 2) { // 곱셈
                    dfs(result * numbers[depth], depth + 1);
                } else { // 나눗셈
                    dfs(result / numbers[depth], depth + 1);
                }

                operators[i]++; // 백트래킹: 연산자 복구
            }
        }

    }
}
