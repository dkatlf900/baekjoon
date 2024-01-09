package org.example.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@Deprecated
public class Gold2485 {

    /**
     * Q, Gold-2485
     * 예를 들어, 가로수가 (1, 3, 7, 13)의 위치에 있다면 (5, 9, 11)의 위치에 가로수를 더 심으면 모든 가로수들의 간격이 같게 된다.
     * 또한, 가로수가 (2, 6, 12, 18)에 있다면 (4, 8, 10, 14, 16)에 가로수를 더 심어야 한다.
     * 심어져 있는 가로수의 위치가 주어질 때, 모든 가로수가 같은 간격이 되도록 새로 심어야 하는 가로수의 최소수를 구하는 프로그램을 작성하라.
     * 단, 추가되는 나무는 기존의 나무들 사이에만 심을 수 있다.
     *
     * 유클리드 호제법
     * GCD(12,18)=6  , 최대공약수
     * LCM(12,18)=36 , LCM(12,18) = 12*18/GCD(12,18)
     *
     * 4
     * 1
     * 3
     * 7
     * 13
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        long[] arr = new long[x];
        for(int i=0; i<x; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        long temp = 0;
        Set<Long> ss = new HashSet<>();
        for(int i=1; i<x; i++) {
            long k = arr[i] - arr[i-1];
            if( k > temp) {
                System.out.println(" ====@@@@> " + k);
                ss.add(k);
                temp = k;
            }
        }
//        System.out.println(" ====> " + temp);
        System.out.println(" =======> " + ss.toString());
        long min = ss.stream().min(Long::compare).get();
        long start = min;
        for(int i= 0; i<min; i++) {
            if(find(x, arr,start) == 0 ) {
                start--;
                continue;
            }
        }
        System.out.println(" Result ::min =======> " + start);
    }

    public long find(int x, long[] arr, long min) {
        long result = min;
        //그냥 여기서 2씩 합산이라면 0인덱스 부터 2씩합해서 컨테인에 들어오는지 확인해볼가
        for(int i= 1; i<x; i++) {
            if(result < arr[i]){
                if( arr[i] % result != 0) {
                    result = 0;
                    break;
                }

            } else {
                if(result % arr[i] != 0) {
                    result = 0;
                    break;
                }
            }
            /*if(min+arr[i-1] != arr[i]) {
                result = 0;
                break;
            }*/
        }
        return result;
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
