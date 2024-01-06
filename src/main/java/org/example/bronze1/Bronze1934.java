package org.example.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze1934 {

    /**
     * Q, Bronze-1934
     * 두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.
     *
     * 유클리드 호제법
     * GCD(12,18)=6  , 최대공약수
     * LCM(12,18)=36 , LCM(12,18) = 12*18/GCD(12,18)
     *
     * 3
     * 1 45000
     * 6 10
     * 13 17
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            String[] text = br.readLine().split(" ");
            int a = Integer.parseInt(text[0]);
            int b = Integer.parseInt(text[1]);

            int gcd = gcd(a,b);
            int lcm = lcm(a,b,gcd);
            System.out.println(lcm);
        }
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
