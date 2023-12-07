package org.example.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Silver2751 {

    /**
     * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
     * 둘째 줄부터 N개의 줄에는 수가 주어진다.
     * 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] x = new int[n];
        for(int i=0; i<n; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        Arrays.stream(x).sorted().forEach(a ->
                sb.append(a).append("\n")
        );

        System.out.print(sb.toString());
    }
}
