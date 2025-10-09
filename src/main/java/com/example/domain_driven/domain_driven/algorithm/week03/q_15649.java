package com.example.domain_driven.domain_driven.algorithm.week03;

import java.io.*;
import java.util.*;

public class q_15649 {
    static int n, m;
    static int[] arr;           // 선택한 숫자들을 저장
    static boolean[] isUsed;    // 숫자 사용 여부 체크
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 1~N
        m = Integer.parseInt(st.nextToken()); // 몇개의 배열

        arr = new int[m];           // M개를 선택할 배열 -> m개자리의 배열
        isUsed = new boolean[n + 1]; // 1~N 사용 여부 (인덱스 1부터 사용)

        backtrack(0);
        System.out.print(sb);
    }

    static void backtrack(int depth) {
        // 1. 종료 조건: M개를 모두 선택했을 때
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        // 2. 1부터 N까지 시도
        for (int i = 1; i <= n; i++) {
            // 3. 가지치기: 이미 사용한 숫자는 스킵
            if (isUsed[i]) continue;

            // 4. 선택
            arr[depth] = i;
            isUsed[i] = true;

            // 5. 재귀 탐색
            backtrack(depth + 1);

            // 6. 선택 취소 (백트래킹)
            isUsed[i] = false;
        }
    }
}