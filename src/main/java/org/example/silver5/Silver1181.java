package org.example.silver5;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Silver1181 {

    /**
     * Q, Silver-1181
     * 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
     *
     * 길이가 짧은 것부터
     * 길이가 같으면 사전 순으로
     * 단, 중복된 단어는 하나만 남기고 제거해야 한다.
     *
     * 첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로
     * 이루어진 단어가 한 줄에 하나씩 주어진다.
     * 주어지는 문자열의 길이는 50을 넘지 않는다.
     *
     * 13
     * but
     * i
     * wont
     * hesitate
     * no
     * more
     * no
     * more
     * it
     * cannot
     * wait
     * im
     * yours
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        Map<Integer, Set<String>> res = new HashMap<>();
        for(int i=1; i<=x; i++) {
            String text = br.readLine();
            Set<String> list = res.getOrDefault(text.length(), new HashSet<>());
            list.add(text);
            res.put(text.length(), list);
        }

        res.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(a-> a.getValue().stream()
                        .sorted(String::compareTo)
                        .forEach(b -> {
                            try {
                                bw.append(b).append("\n");
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        })
                );

        bw.flush();
    }
}
