package org.example.silver5;

import java.io.*;
import java.util.*;

public class Silver1427 {

    /**
     * Q, Silver-1427
     * 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
     *
     * 첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
     * 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
     * 2143
     * ---> 4321
     *
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정렬로 역순이든 정배열이든 하고나서 출력만 하면 될듯. 자릿수별로의 숫자이기에 매우 데이터양이 적다.
        int[] x = br.readLine().chars().map(a-> Character.getNumericValue((char)a)).toArray();

        int len = x.length;
        for(int i=0; i<len-1; i++) {
            for(int k=i+1; k<len; k++) {
                if(x[i] < x[k]) {
                    int temp = x[k];
                    x[k] = x[i];
                    x[i] = temp;
                }
            }
        }
        Arrays.stream(x).forEach(a-> System.out.print(a));
    }
}
