package org.example.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Bronze2693 {

    /**
     * Q, Bronze-2693
     * 첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고,
     * 배열 A의 원소 10개가 공백으로 구분되어 주어진다.
     * 이 원소는 1보다 크거나 같고, 1,000보다 작거나 같은 자연수이다.
     *
     * 각 테스트 케이스에 대해 한 줄에 하나씩 배열 A에서 3번째 큰 값을 출력한다.
     *
     * 4
     * 1 2 3 4 5 6 7 8 9 1000
     * 338 304 619 95 343 496 489 116 98 127
     * 931 240 986 894 826 640 965 833 136 138
     * 940 955 364 188 133 254 501 122 768 408
     *
     *
     * --->>
     * 8
     * 489
     * 931
     * 768
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            String[] testCase = br.readLine().split(" ");
            int res = Arrays.stream(testCase).mapToInt(Integer::parseInt).boxed().sorted(Comparator.reverseOrder()).skip(2)
                    .findFirst().get();
            System.out.println(res);
        }
    }
}
