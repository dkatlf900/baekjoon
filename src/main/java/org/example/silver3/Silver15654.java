package org.example.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Silver15654 {

    /**
     * Q, Silver-15654
     * N과 M(5)
     * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
     * N개의 자연수는 모두 다른 수이다.
     * N개의 자연수 중에서 M개를 고른 수열
     *
     * 첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
     * 둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.
     *
     * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
     * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
     *
     *
     * 4 2
     * 9 8 7 1
     * --->>
     * 1 7
     * 1 8
     * 1 9
     * 7 1
     * 7 8
     * 7 9
     * 8 1
     * 8 7
     * 8 9
     * 9 1
     * 9 7
     * 9 8
     */

    static StringBuilder sb = new StringBuilder();
    static boolean[] visit;
    static int[] arr;
    static int[] inArr;

    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] text = br.readLine().split(" ");
        int n = Integer.parseInt(text[0]);
        int m = Integer.parseInt(text[1]);

        String[] input2 = br.readLine().split(" ");
        List<Integer> xx =Arrays.stream(input2).map(Integer::parseInt).sorted().collect(Collectors.toList());
        inArr = new int[n];
        arr = new int[m];
        visit = new boolean[n];
        for(int i=0; i<n; i++){
            inArr[i] = xx.get(i);
        }

        calc(inArr, m, 0);
        System.out.println(sb);
    }

    public void calc(int[] inArr, int m, int k) {
        if(m == k) {
            for(int i=0; i<arr.length; i++){
                sb.append(arr[i]);
                if(i != arr.length-1){
                    sb.append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<inArr.length; i++) {
            if(!visit[i]){
                visit[i] = true;
                arr[k] = inArr[i];
                calc(inArr, m, k+1);
                visit[i] = false;
            }
        }

    }


}
