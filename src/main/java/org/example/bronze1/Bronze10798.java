package org.example.bronze1;

import java.io.*;

public class Bronze10798 {

    /**
     * Q, Bronze-10798
     * 총 다섯줄의 입력이 주어진다. 각 줄에는 최소 1개, 최대 15개의 글자들이 빈칸 없이 연속으로 주어진다.
     * 주어지는 글자는 영어 대문자 ‘A’부터 ‘Z’, 영어 소문자 ‘a’부터 ‘z’, 숫자 ‘0’부터 ‘9’ 중 하나이다.
     * 각 줄의 시작과 마지막에 빈칸은 없다.
     *
     * 영석이가 세로로 읽은 순서대로 글자들을 출력한다. 이때, 글자들을 공백 없이 연속해서 출력한다.
     * AABCDD
     * afzz
     * 09121
     * a8EWg6
     * P5h3kx
     *
     * -->> Aa0aPAf985Bz1EhCz2W3D1gkD6x
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] text = new String[5];
        int len = 0;
        for(int i=0; i<5; i++) {
            text[i] = br.readLine();
            len = Math.max(len, text[i].length());
        }

        for(int i=0; i<len; i++) {
            for(int x=0; x<5; x++) {
                if(!(text[x].length()-1 >= i) ){
                    continue;
                }
                bw.append(text[x].charAt(i));
            }
        }
        bw.flush();
    }
}
