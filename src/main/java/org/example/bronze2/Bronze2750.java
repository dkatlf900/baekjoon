package org.example.bronze2;

import java.io.*;
import java.util.Arrays;

public class Bronze2750 {

    /**
     * Q, Bronze-1152
     * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다.
     * 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
     *
     * 5
     * 5
     * 2
     * 3
     * 4
     * 1
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = Integer.parseInt(br.readLine());
        int[] y = new int[x];
        for(int i=0; i<x; i++) {
            y[i] = Integer.parseInt(br.readLine());
        }

        Arrays.stream(y).sorted().forEach(a->{
            try {
                bw.append(String.valueOf(a)).append("\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        bw.flush();
    }
}
