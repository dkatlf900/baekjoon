package org.example.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver15652 {

    /**
     * Q, Silver-15652
     * N과 M(4)
     * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
     * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
     * 같은 수를 여러 번 골라도 된다.
     * 고른 수열은 비내림차순이어야 한다.
     * 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
     *
     * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
     *
     * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
     * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
     * 3 3
     * --->>
     * 1 1 1
     * 1 1 2
     * 1 1 3
     * 1 2 2
     * 1 2 3
     * 1 3 3
     * 2 2 2
     * 2 2 3
     * 2 3 3
     * 3 3 3
     */

    static StringBuilder sb = new StringBuilder();
    static boolean[] visit;
    static int[] arr;

    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] text = br.readLine().split(" ");
        int n = Integer.parseInt(text[0]);
        int m = Integer.parseInt(text[1]);
        visit = new boolean[n+1];
        arr = new int[m];

        calc(n, m, 0);
        System.out.println(sb);
    }

    public void calc(int n, int m, int k) {
        if(m == k) {
            boolean isOk = true;
            String temp = "";
            for(int i=0; i<m; i++) {
                if(arr.length != 1){
                    if(i != 0 && arr[i] < arr[i-1]) {
                        isOk = false;
                        continue;
                    } else if(i ==0 && arr[i] > arr[i+1]){
                        isOk = false;
                        continue;
                    }
                }
                temp += arr[i] + " ";
            }
            if(isOk){
                sb.append(temp).append("\n");
            }
            return;
        }

        for(int i=1; i<=n; i++){
            arr[k] = i;
            calc(n, m, k+1);
        }

    }


}
