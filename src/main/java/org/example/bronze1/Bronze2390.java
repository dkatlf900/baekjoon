package org.example.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bronze2390 {

    /**
     * Q, Bronze-2390
     * 아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다. 주어지는 키는 100을 넘지 않는 자연수이며,
     * 아홉 난쟁이의 키는 모두 다르며, 가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.
     * 일곱 난쟁이의 키를 오름차순으로 출력한다. 일곱 난쟁이를 찾을 수 없는 경우는 없다.
     *
     * 20
     * 7
     * 23
     * 19
     * 10
     * 15
     * 25
     * 8
     * 13
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] x = new int[9];
        for(int i=0; i<9; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }

        int[] res = Arrays.stream(x).sorted().toArray();

        int sum;
        int a, b;
        for(int i = 0; i <res.length-1; i++) {
            for(int j = i+1; j<res.length; j++) {
                a = i;
                b = j;
                sum = 0;
                for(int r = 0; r <res.length; r++) {
                    if(r != a && r != b){
                        sum += res[r];
                    }
                }
                if(sum == 100) {
                    for(int r = 0; r <res.length; r++) {
                        if(r != a && r != b){
                            System.out.println(res[r]);
                        }
                    }
                    return;
                }
            }
        }
    }
}
