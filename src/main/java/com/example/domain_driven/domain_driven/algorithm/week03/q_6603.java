package com.example.domain_driven.domain_driven.algorithm.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_6603 {
    static int[] numbers;
    static final int LOTTO_COUNT = 6;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());  // 첫번째수가 뒤에 집합 몇개일지 알려주는 수
            if (K == 0) break;

            numbers = new int[K]; // 두번째는 집합 k개

            for (int i = 0; i < K; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            solution();
            sb.append("\n");
        }
        System.out.println(sb); //출력

    }

    private static void solution() {
        selected = new int[LOTTO_COUNT];
        dfs(0,0);
    }

    private static void dfs(int depth, int start) {
        if (depth == LOTTO_COUNT) {
            for(int i = 0; i < LOTTO_COUNT; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            selected[depth] = numbers[i];

            // 재귀 (다음 depth, 다음 인덱스부터 시작)
            dfs(depth + 1, i + 1);
        }

    }
}
