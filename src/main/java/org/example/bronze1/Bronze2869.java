package org.example.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bronze2869 {

    /**
     * Q, Bronze-2869
     * 땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
     * 달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
     * 달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.
     * a b v
     * 2 1 5
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] x = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        long a = x[0];
        long b = x[1];
        long v = x[2];

        long cnt =0;
        /*long day =0;
        while (cnt < v) {
            day++;
            cnt += a;
            if(cnt >= v) {
                break;
            }
            cnt -= b;
        }*/
        // 로직으로 시간을 줄이는게 아니라 이건 수학적 문제풀이였음..
        long day = (v - b - 1) / (a - b) + 1;

        System.out.println(day);
    }
}
