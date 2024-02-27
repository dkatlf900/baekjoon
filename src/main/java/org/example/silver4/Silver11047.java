package org.example.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Silver11047 {

    /**
     * Q, Silver-11047
     * 준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
     *
     * 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
     * 둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
     *
     * 첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.
     *
     * 10 4200
     * 1
     * 5
     * 10
     * 50
     * 100
     * 500
     * 1000
     * 5000
     * 10000
     * 50000
     * ----> 6
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstIn = br.readLine().split(" ");
        int n = Integer.parseInt(firstIn[0]);
        int k = Integer.parseInt(firstIn[1]);

        ArrayList<Integer> money = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp <= k){
                money.add(temp);
            }
        }
        int res = calc(money, k, 0);
        System.out.println(res);
    }

    public int calc(ArrayList<Integer> money, int k, int cnt) {
        int i = money.size()-1;
        while (true) {
            if(k - money.get(i) >= 0 ){
                k = k - money.get(i);
                cnt++;
            }
            if(k < money.get(i)){
                i --;
            }
            if(k == 0) {
                break;
            }
        }
        return cnt;
    }

}
