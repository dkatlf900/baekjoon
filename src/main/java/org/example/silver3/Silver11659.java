package org.example.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver11659 {

    /**
     * Q, Silver-11659 - 구간 합 구하기 4
     * 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
     * 첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 둘째 줄에는 N개의 수가 주어진다.
     * 수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
     *
     * 총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
     *
     * 5 3
     * 5 4 3 2 1
     * 1 3
     * 2 4
     * 5 5
     * --->>
     * 12
     * 9
     * 1
     */

    static StringBuilder sb = new StringBuilder();

    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] text = br.readLine().split(" ");
        int n = Integer.parseInt(text[0]);
        int m = Integer.parseInt(text[1]);
        int[] arr = new int[n];

        String[] text2 = br.readLine().split(" ");
        arr[0] = Integer.parseInt(text2[0]); // 0번만 예외
        for(int i=1; i<text2.length; i++) {
            // 누적하여 합산을 미리 계산해놓는다.
            arr[i] = arr[i-1] + Integer.parseInt(text2[i]);
        }

        for(int i=0; i<m; i++) {
            String[] text3 = br.readLine().split(" ");
            calc(arr, Integer.parseInt(text3[0]), Integer.parseInt(text3[1]));
        }
        System.out.println(sb);
    }

    public void calc(int[] arr, int start, int end) {
        if(start == 1){
            sb.append(arr[end-1]).append("\n");
        } else if(start == 1 && end == 1){
            sb.append(arr[0]).append("\n");
        } else{
            sb.append(arr[end-1] - arr[start-2]).append("\n");
        }
    }



}
