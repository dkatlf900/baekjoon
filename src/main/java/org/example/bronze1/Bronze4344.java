package org.example.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bronze4344 {

    /**
     * Q, Bronze-1546
     * 대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.
     *
     * 5
     * 5 50 50 70 80 100
     * 7 100 95 90 80 70 60 50
     * 3 70 90 80
     * 3 70 90 81
     * 9 100 99 98 97 96 95 94 93 91
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        for(int i=0; i<a; i++) {
            String[] num = br.readLine().split(" ");
            int x = Integer.parseInt(num[0]);
            double result = Arrays.stream(num)
                    .skip(1) // 0번 인덱스를 건너띈다.
                    .mapToDouble(Double::parseDouble)
                    .average()
                    .getAsDouble();
//            System.out.println("1.average : " + result);

            Long cnt = Arrays.stream(num)
                    .skip(1)
                    .mapToInt(Integer::parseInt)
                    .filter(score-> score > result)
                    .count();

            System.out.println(String.format("%.3f",(cnt * 100.0) / x)+"%");
        }
    }
}
