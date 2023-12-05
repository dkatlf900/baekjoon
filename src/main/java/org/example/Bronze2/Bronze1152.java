package org.example.Bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bronze1152 {

    /**
     * Q, Bronze-1152
     * 첫 줄에 영어 대소문자와 공백으로 이루어진 문자열이 주어진다.
     * 이 문자열의 길이는 1,000,000을 넘지 않는다. 단어는 공백 한 개로 구분되며,
     * 공백이 연속해서 나오는 경우는 없다. 또한 문자열은 공백으로 시작하거나 끝날 수 있다.
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine().trim();
        if(text.isEmpty()) {
            System.out.println(0);
            return;
        }

        Long a = Arrays.stream(text.split(" ")).count();
        System.out.println(a);
    }
}
