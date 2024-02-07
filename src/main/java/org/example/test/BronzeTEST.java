package org.example.test;

import java.io.IOException;
import java.util.Arrays;

public class BronzeTEST {

    /**
     * Q, Bronze-3052
     * 이거는 못풀었다. 배터리 관련문제 dp
     *--->:[1, 15000]
     * --->:[4, 35000] : 140,000
     * --->:[10, 100000] : 1,000,000
     */
        public int test(int n, int[][] battery) throws IOException {
            Arrays.sort(battery, (a, b) -> a[1] / a[0] - b[1] / b[0]); // 1개당 저렴한 순서로 정렬
//            for (int[] a : battery) {
//                System.out.println("--->" + Arrays.toString(a));
//            }


            int res = 0;
            int sum = 0;
            int minCost = 0;
            int cnt =0;
            for (int i = 0; i < battery.length; i++) {
                while (cnt <= n && cnt + battery[i][0] <= n){
                    if(cnt + battery[i][0] > n) {
                        break;
                    }
                    cnt += battery[i][0];
                    minCost +=battery[i][1];
                    sum = minCost;
                }
                res = Math.min(sum,minCost);
            }

            System.out.println("======:::1: "+ minCost);
            System.out.println("======:::1 res : "+ res);
            System.out.println("======:::2: "+ cnt);

            return minCost;
        }

}
