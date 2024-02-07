package org.example.bronze1;

import java.io.*;

public class Bronze9093 {

    /**
     * Q, Bronze-9093
     * 문장이 주어졌을 때, 단어를 모두 뒤집어서 출력하는 프로그램을 작성하시오.
     * 단, 단어의 순서는 바꿀 수 없다. 단어는 영어 알파벳으로만 이루어져 있다.
     *
     * 2
     * I am happy today
     * We want to win the first prize
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = Integer.parseInt(br.readLine());

        for(int i=0; i<x; i++) {
            String[] text = br.readLine().split(" ");
            for(String t : text) {
                if(t.length() == 1) {
                    bw.append(t);
                } else {
                  for(int a = t.length()-1; a>=0; a--) {
                      bw.append(t.charAt(a));
                  }
                }
                bw.append(" ");
            }
            bw.append("\n");
            bw.flush();
        }
    }
}
