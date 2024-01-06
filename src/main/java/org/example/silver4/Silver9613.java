package org.example.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Silver9613 {

    /**
     * Q, Silver-9613
     * 양의 정수 n개가 주어졌을 때, 가능한 모든 쌍의 GCD의 합을 구하는 프로그램을 작성하시오.
     *
     * 유클리드 호제법
     * GCD(12,18)=6  , 최대공약수
     * LCM(12,18)=36 , LCM(12,18) = 12*18/GCD(12,18)
     *
     * 3
     * 4 10 20 30 40
     * 3 7 5 12
     * 3 125 15 25
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            String[] text = br.readLine().split(" ");
            List<Integer> list = Arrays.stream(text).skip(1).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
            gcdSum(list);
        }
    }

    public void gcdSum(List<Integer> list) {
        long result = 0;
        while (list.size() > 1) {
            int a = list.get(0);
            for(int i=1; i<list.size(); i++) {
                result += gcd(a, list.get(i));
            }
            list.remove(0);
        }
        System.out.println(result);
    }

    public int lcm(int a, int b, int gcd) {
        return a * b /gcd;
    }

    /**
     * 유클리드 호제법, 최대공약수 구하기
     */
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
