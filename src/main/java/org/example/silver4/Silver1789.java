package org.example.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Silver1789 {

    /**
     * Q, Silver-1789
     * 서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최댓값은 얼마일까?
     * 첫째 줄에 자연수 S(1 ≤ S ≤ 4,294,967,295)가 주어진다.
     * 첫째 줄에 자연수 N의 최댓값을 출력한다.
     *
     * 19는 자연수 19를 의미하는게 아니라 자연수의 갯수가 19개라는 뜻이다. 헷갈리게 되어있음
     * 200
     * ----> 19
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());
        long sum = 0;
        long i = 1;

        // 여기서 +1과 +2의 합이 s를 초과하게 된다면 마지막 수는 그냥 나머지값을 넣어버리는게 좋아보인다.
        while (sum != s) {
            if(sum + (i+i+1) > s){
                long temp = s - sum;
                sum += temp;
                System.out.println(" 마지막 1개 :" + temp);
                continue;
            }
            sum = sum + i;
            System.out.println(" === i: " + i  + " sum: "+sum);
            i++;
        }
        System.out.println(i);

    }
}
