package org.example.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Bronze1292 {

    /**
     * Q, Bronze-2693
     * 첫째 줄에 구간의 시작과 끝을 나타내는 정수 A, B(1 ≤ A ≤ B ≤ 1,000)가 주어진다.
     * 즉, 수열에서 A번째 숫자부터 B번째 숫자까지 합을 구하면 된다.
     *  1 2 2 3 3 3 4 4 4 4 5 ...
     *
     * 첫 줄에 구간에 속하는 숫자의 합을 출력한다.
     *
     * 3 7
     * --->> 15
     * 4 5 6
     * 1 2 3 4 5 6 7 8 9 10 == 55
     * 15
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // TODO 첫번째 수와 마지막 수를 합했을때 a+b = 홀수이면 중간값을 더하지 않아도 되기에 (a+b) * ((b-a+1) / 2) 를 한다
        // a+b = 짝수의 경우 남은 중간값이 있기에 (a+b) * ((b-a+1) / 2) + 중간값C
        String[] test = br.readLine().split(" ");
        int a = Integer.parseInt(test[0])-1;
        int b = Integer.parseInt(test[1])-1;

        int[] nums = new int[1000];
        int x = 0;
        int i = 1;
        while (x < 1000){
            for (int j = 0; j < i; j++) {
                nums[x] = i;
                x++;
                if (x == 1000) {
                    break;
                }
            }
            i++;
        }

        int sum = 0;
        for(int k = a; k<=b; k++){
            sum += nums[k];
        }
        System.out.println(sum);
    }
}
