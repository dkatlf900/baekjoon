package org.example.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gold2436 {

    /**
     * Q, Silver-2436
     * 두 개의 자연수가 주어졌을 때, 이 두 수를 최대공약수와 최소공배수로 하는 두 개의 자연수를 구하는 프로그램을 작성하시오.
     * 첫째 줄에는 입력되는 두 자연수를 최대공약수와 최소공배수로 하는 두 개의 자연수를 크기가 작은 수부터 하나의 공백을 사이에 두고 출력한다.
     * 입력되는 두 자연수를 최대공약수와 최소공배수로 하는 두 개의 자연수 쌍이 여러 개 있는 경우에는 두 자연수의 합이 최소가 되는 두 수를 출력한다.
     *
     * 유클리드 호제법
     * GCD(12,18)=6  , 최대공약수
     * LCM(12,18)=36 , LCM(12,18) = 12*18/GCD(12,18)
     *
     * 6 180 --> 30 36
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] text = br.readLine().split(" ");
        long gcd = Long.parseLong(text[0]); // 최대 공약수
        long lcm = Long.parseLong(text[1]); // 최소 공배수
        // lcm = x1 * x2 / gcd , lcm * gcd = x1 * x2
        // 1048 = x1 * x2
        find(gcd, lcm);
    }


    private void find(long gcd, long lcm) {
        long product = lcm / gcd;  //  lcm을 gcd로 나눈 값으로 서로소로 이루어진 쌍을 구한다.

        long a = 0, b = 0;
        for(long i =1; i*i<=product; i++) {
            if(product % i == 0) { // 약수인지 찾기
                long j = product / i; // i가 약수라면 다른 약수 j를 찾기 ex) 3,4 = 12
                if(gcd(i,j) == 1) { // 서로소가 맞는지 확인 1이 나와야함
                    a = i * gcd;
                    b = j * gcd;
                }
            }
        }
        System.out.println(a + " " + b);
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
