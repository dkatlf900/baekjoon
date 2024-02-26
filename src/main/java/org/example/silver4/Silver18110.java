package org.example.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Silver18110 {

    /**
     * Q, Silver-18110
     * 어떤 문제의 난이도는 그 문제를 푼 사람들이 제출한 난이도 의견을 바탕으로 결정한다. 난이도 의견은 그 사용자가 생각한 난이도를 의미하는 정수 하나로 주어진다. solved.ac가 사용자들의 의견을 바탕으로 난이도를 결정하는 방식은 다음과 같다.
     *
     * 아직 아무 의견이 없다면 문제의 난이도는 0으로 결정한다.
     * 의견이 하나 이상 있다면, 문제의 난이도는 모든 사람의 난이도 의견의 30% 절사평균으로 결정한다.
     *제외되는 사람의 수는 위, 아래에서 각각 반올림한다. 25명이 투표한 경우 위, 아래에서 각각 3.75명을 제외해야 하는데, 이 경우 반올림해 4명씩을 제외한다.
     *
     * 마지막으로, 계산된 평균도 정수로 반올림된다. 절사평균이 16.7이었다면 최종 난이도는 17이 된다.
     *
     * 첫 번째 줄에 난이도 의견의 개수 n이 주어진다. (0 ≤ n ≤ 3 × 105)
     * 이후 두 번째 줄부터 1 + n번째 줄까지 사용자들이 제출한 난이도 의견 n개가 한 줄에 하나씩 주어진다. 모든 난이도 의견은 1 이상 30 이하이다.
     *
     * 5
     * 1
     * 5
     * 5
     * 7
     * 8
     * ---> 6
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        if(n==0){
            System.out.println(n);
        } else {
            int a = (int)Math.round(n * 0.15);
            // 절사평균 들어간다.
            for(int i=0; i<n; i++){
                x[i] = Integer.parseInt(br.readLine());
            }
            Double res = Arrays.stream(x).boxed()
                    .sorted().skip(a)
                    .sorted(Comparator.reverseOrder()).skip(a)
                    .mapToDouble(Integer::doubleValue)
                    .average()
                    .getAsDouble()
                    ;
            System.out.println(Math.round(res));
        }
    }

}
