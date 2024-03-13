package org.example.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Silver11053 {

    /**
     * Q, Silver-11053
     * 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
     *
     * 예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은
     * A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.
     *
     * 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.
     * 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)
     *
     * 첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
     *
     * 6
     * 10 20 10 30 20 50
     * --> 4
     */

    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] k = br.readLine().split(" ");

        int[] arr = new int[n];
        int[] dp = new int[n];
        for(int i=0; i<k.length; i++) {
            arr[i] = Integer.parseInt(k[i]);
            dp[i] = 1;
        }

        // 역으로 for문 돌리는 사고방식을 배움.
        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i] && dp[i] < dp[j]+1) {
//                    System.out.println("j: "+ arr[j] + "  ,,, i :"+ arr[i]);
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 1;
        for(int a : dp){
            max = Math.max(max, a);
        }
        System.out.println(max);
    }
}
