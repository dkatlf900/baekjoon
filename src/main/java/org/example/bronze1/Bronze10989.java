package org.example.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bronze10989 {

    /**
     * Q, Bronze-1546
     * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
     * 10
     * 5
     * 2
     * 3
     * 1
     * 4
     * 2
     * 3
     * 5
     * 1
     * 7
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int a = Integer.parseInt(br.readLine());
        int[] x = new int[a];
        for(int i=0; i<a; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }

        Arrays.stream(x).sorted().forEach(cnt ->
                sb.append(cnt).append("\n")

        );
        System.out.println(sb.toString());
    }
}
