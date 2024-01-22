package org.example.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Bronze3052 {

    /**
     * Q, Bronze-3052
     * 두 자연수 A와 B가 있을 때, A%B는 A를 B로 나눈 나머지 이다. 예를 들어, 7, 14, 27, 38을 3으로 나눈 나머지는 1, 2, 0, 2이다.
     *
     * 수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다. 그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.
     *
     * 첫째 줄에, 42로 나누었을 때, 서로 다른 나머지가 몇 개 있는지 출력한다.
     * 1
     * 2
     * 3
     * 4
     * 5
     * 6
     * 7
     * 8
     * 9
     * 10
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] x = new int[10];

        for(int i=0; i<10; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }

        Set<Integer> set = new HashSet<>();
        for(int i : x) {
            int a = i % 42;
            set.add(a);
//            System.out.println("===== >> :"+ a);
        }
        System.out.println(set.size());
    }
}
