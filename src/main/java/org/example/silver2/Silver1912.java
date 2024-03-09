package org.example.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver1912 {

    /**
     * Q, Silver-1912
     * O(N) 시간복잡도로 풀어야 한다.
     * 카데인 알고리즘이라고 명칭하는듯 하다.
     *
     * n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.
     * 단, 수는 한 개 이상 선택해야 한다.
     *
     * 예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자.
     * 여기서 정답은 12+21인 33이 정답이 된다.
     *
     * 첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다.
     * 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.
     * 첫째 줄에 답을 출력한다.
     *
     * 10
     * 2 1 -4 3 4 -4 6 5 -5 1
     * --> 14
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");

        int[] arr = new int[n];
        arr[0] = Integer.parseInt(str[0]);
        int max = Math.max(Integer.MIN_VALUE, arr[0]);

        for(int i=1; i<n; i++) {
            int temp = Integer.parseInt(str[i]);
            if(arr[i-1] + temp > temp) {
                arr[i] = arr[i-1] + temp;
            } else {
                arr[i] = temp;
            }
            max = Math.max(max, arr[i]);
        }

        sb.append(max);
        System.out.println(sb);
    }

}
