package org.example.bronze2;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bronze25305 {

    /**
     * Q, Bronze-1152
     * 2022 연세대학교 미래캠퍼스 슬기로운 코딩생활에
     * $N$명의 학생들이 응시했다.
     * 이들 중 점수가 가장 높은
     * $k$명은 상을 받을 것이다. 이 때, 상을 받는 커트라인이 몇 점인지 구하라.
     * 커트라인이란 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수를 말한다.
     *
     * 5 2
     * 100 76 85 93 98
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] text = br.readLine().split(" ");
        int x = Integer.parseInt(text[0]); // 학생수
        int y = Integer.parseInt(text[1]); // 상받는 대상 수

        String[] score = br.readLine().split(" ");
        List<Integer> xx = Arrays.stream(score).mapToInt(Integer::parseInt)
                .boxed()
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());

//        System.out.println("==> "+ xx.toString());
        System.out.println(xx.get(y-1));
    }
}
