package org.example.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gold13398 {

    /**
     * Q, Gold-13398
     * O(N) 시간복잡도로 풀어야 한다.
     * 카데인 알고리즘이라고 명칭하는듯 하다.
     *
     * n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.
     * 단, 수는 한 개 이상 선택해야 한다.
     * !!!! 또, 수열에서 수를 하나 제거할 수 있다. (제거하지 않아도 된다)
     *
     * 예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자.
     * 여기서 수를 제거하지 않았을 때의 정답은 12+21인 33이 정답이 된다.
     * 만약, -35를 제거한다면, 수열은 10, -4, 3, 1, 5, 6, 12, 21, -1이 되고, 여기서 정답은 10-4+3+1+5+6+12+21인 54가 된다.
     *
     * 첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다.
     * 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.
     * 첫째 줄에 답을 출력한다.
     *
     * 10
     * 10 -4 3 1 5 6 -35 12 21 -1
     * --> 54
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");

        int max = Integer.parseInt(str[0]);

        int[][] dp = new int[n+1][2];
        dp[1][0] = Integer.parseInt(str[0]);
        dp[1][1] = Integer.parseInt(str[0]);

        for(int i=2; i<=n; i++) {
            int temp = Integer.parseInt(str[i-1]);
            dp[i][0] = Math.max(dp[i-1][0] + temp, temp);
            // dp[i-2][0] + temp  --> i-1번 숫자를 제거했을때의 합
            // dp[i-1][1] + temp --> 앞에서 I-1번 숫자를 제거한 합에 대해 더이상 숫자 제거하지 않고 합했을때의 값
            dp[i][1] = Math.max(dp[i-2][0] + temp, dp[i-1][1] + temp);
        }

        for(int i=1; i<=n; i++) {
            for(int j=0; j<2; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);
    }

}
