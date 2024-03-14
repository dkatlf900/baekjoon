package org.example.gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gold12015 {

    /**
     * Q, Gold-12015
     * LIS nlogn 알고리즘으로 풀어야 한다.
     * 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
     *
     * 예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은
     * A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.
     *
     * 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다.
     * 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000,000)
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
//        Arrays.fill(dp, 1);
        for(int i=0; i<k.length; i++) {
            arr[i] = Integer.parseInt(k[i]);
        }
        dp[0] = arr[0];

        int lis = 1;
        for(int i=1; i<n; i++) {
            // 추가
            if(dp[lis-1] < arr[i]){
                dp[lis] = arr[i];
                lis++;
            } else {
                // lis, 대체
                int low = 0;
                int high = lis;
                while (low < high) {
                    int mid = (low + high) / 2;
                    if(dp[mid] < arr[i]) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
                dp[low] = arr[i];
            }
        }
        System.out.println(lis);

    }
}
