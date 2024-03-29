package org.example.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Silver14425 {

    /**
     * Q, Silver-14425
     * 총 N개의 문자열로 이루어진 집합 S가 주어진다.
     * 입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 것이 총 몇 개인지 구하는 프로그램을 작성하시오.
     *
     * 첫째 줄에 문자열의 개수 N과 M (1 ≤ N ≤ 10,000, 1 ≤ M ≤ 10,000)이 주어진다.
     * 다음 N개의 줄에는 집합 S에 포함되어 있는 문자열들이 주어진다.
     * 다음 M개의 줄에는 검사해야 하는 문자열들이 주어진다.
     * 입력으로 주어지는 문자열은 알파벳 소문자로만 이루어져 있으며, 길이는 500을 넘지 않는다. 집합 S에 같은 문자열이 여러 번 주어지는 경우는 없다.
     *
     *
     * 5 11
     * baekjoononlinejudge
     * startlink
     * codeplus
     * sundaycoding
     * codingsh
     * baekjoon
     * codeplus
     * codeminus
     * startlink
     * starlink
     * sundaycoding
     * codingsh
     * codinghs
     * sondaycoding
     * startrink
     * icerink
     * ----> 4
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] text = br.readLine().split(" ");
        int n = Integer.parseInt(text[0]);
        int m = Integer.parseInt(text[1]);

        Set<String> set = new HashSet<>();
//        Set<String> set2 = new HashSet<>();
        int cnt = 0;
        for(int i =0; i< n+m; i++){
            if(i<n) {
                set.add(br.readLine());
            } else {
                String str = br.readLine();
                // 검증하여 존재하면 중복불가인 set2로 add
                if (set.contains(str)) {
                    cnt++;
//                    set2.add(str);
                }
            }
        }

        System.out.println(cnt);
//        System.out.println(set2.size());
    }
}
