package org.example.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver9095 {

    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] x = new int[n];
        for(int i=0; i<n; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }

        for(int k : x) {
            int[]dp = new int[k+1];
            dp[1] = 1;
            if(k>=2) dp[2] = 2;
            if(k>=3) dp[3] = 4;

            for (int i = 4; i <= k; i++) {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
//            System.out.println(Arrays.toString(dp));
            System.out.println(dp[k]);
        }
    }
}
