package org.example.silver5;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Silver7785 {

    /**
     * Q, Silver-7785
     * 첫째 줄에 로그에 기록된 출입 기록의 수 n이 주어진다. (2 ≤ n ≤ 106) 다음 n개의 줄에는 출입 기록이 순서대로 주어지며,
     * 각 사람의 이름이 주어지고 "enter"나 "leave"가 주어진다. "enter"인 경우는 출근, "leave"인 경우는 퇴근이다.
     * 회사에는 동명이인이 없으며, 대소문자가 다른 경우에는 다른 이름이다. 사람들의 이름은 알파벳 대소문자로 구성된 5글자 이하의 문자열이다.
     *
     * 현재 회사에 있는 사람의 이름을 사전 순의 역순으로 한 줄에 한 명씩 출력한다.
     *
     * 4
     * Baha enter
     * Askar enter
     * Baha leave
     * Artem enter
     * --->
     * Askar
     * Artem
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

//        Map<String, String> map = new TreeMap<>();
        // TODO 알파벳 순서로 정렬 하도록 compare를 @Override 하여 o2를 기준으로 한다.
        Map<String, String> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            map.get(str[0]);
            if(map.containsKey(str[0]) && "leave".equals(str[1])){
                map.remove(str[0]);
            } else {
                map.put(str[0], str[1]);
            }
        }

        // 역순으로 treemap 출력.
        /*for (String key : ((TreeMap<String, String>) map).descendingKeySet()) {
            sb.append(key).append("\n");
        }*/

        map.forEach(((s, s2) -> sb.append(s).append("\n")));

        System.out.println(sb);
    }
}
