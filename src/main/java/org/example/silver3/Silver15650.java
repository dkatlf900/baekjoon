package org.example.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Silver15650 {

    /**
     * Q, Silver-15650
     * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
     * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
     * 고른 수열은 오름차순이어야 한다.
     * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
     *
     * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
     * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
     * 4 4
     * --->>
     * 1 2 3 4
     */
    public static boolean[] visit;
    public static int[] arr;
    public static Set<boolean[]> validSet = new HashSet<boolean[]>();

    public static int m;
    public static int n;
    public static StringBuilder sb = new StringBuilder();
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] text = br.readLine().split(" ");
        n = Integer.parseInt(text[0]);
        m = Integer.parseInt(text[1]);

        visit = new boolean[n+1];
        arr = new int[n+1];

        calc(0);
        System.out.println(sb.toString());
    }

    public void calc(int k) {
        if(m == k) {
            boolean[] temp = visit.clone();
            boolean isOk = false;
            for(boolean[] valids : validSet){
                if(Arrays.equals(valids, temp)) {
                    isOk = true;
                    break;
                }
            }

            if(!isOk){
                validSet.add(temp);
                for(int i=1; i<=m; i++) {
                    sb.append(arr[i]).append(" ");
                }
                sb.append("\n");
            }
            return;
        }

        for(int i=1; i<=n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                arr[k+1] = i;
                calc(k+1);
                visit[i] = false;
            }
        }
    }


}
