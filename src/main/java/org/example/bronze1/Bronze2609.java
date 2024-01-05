package org.example.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze2609 {

    /**
     * Q, Bronze-2609
     * 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
     *
     * 유클리드 호제법
     * GCD(12,18)=6  , 최대공약수
     * LCM(12,18)=36 , LCM(12,18) = 12*18/GCD(12,18)
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] text = br.readLine().split(" ");
        int a = Integer.parseInt(text[0]);
        int b = Integer.parseInt(text[1]);

        int gcd = gcd(a,b);
        System.out.println(gcd);
        int lcm = a * b /gcd;
        System.out.println(lcm);
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
