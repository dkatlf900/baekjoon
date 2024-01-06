package org.example.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver5347 {

    /**
     * Q, Silver-5347
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
        long t = Long.parseLong(br.readLine());

        for(int i=0; i<t; i++) {
            String[] text = br.readLine().split(" ");
            long a = Long.parseLong(text[0]);
            long b = Long.parseLong(text[1]);

            long gcd = gcd(a,b);
            System.out.println(lcm(a,b,gcd));
        }

    }

    public long lcm(long a, long b, long gcd) {
        return a * b /gcd;
    }

    /**
     * 유클리드 호제법, 최대공약수 구하기
     */
    public long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
