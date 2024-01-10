package org.example.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Silver7568 {

    /**
     * Q, Silver-7568
     * 위 표에서 C보다 더 큰 덩치의 사람이 없으므로 C는 1등이 된다.
     * 그리고 A, B, D 각각의 덩치보다 큰 사람은 C뿐이므로 이들은 모두 2등이 된다. 그리고 E보다 큰 덩치는 A, B, C, D 이렇게 4명이므로 E의 덩치는 5등이 된다. 위 경우에 3등과 4등은 존재하지 않는다. 여러분은 학생 N명의 몸무게와 키가 담긴 입력을 읽어서 각 사람의 덩치 등수를 계산하여 출력해야 한다.
     *
     * 5
     * 55 185
     * 58 183
     * 88 186
     * 60 175
     * 46 155
     */

    public class Person {
        int weight;
        int height;
        int rank;

        public void rank(int rank){
            this.rank = rank;
        }

        public Person(int w, int h) {
            this.weight = w;
            this.height = h;
            this.rank = 1;
        }
    }

    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Person> person = new ArrayList<>();
        for(int i =0; i<n; i++) {
            String[] a = br.readLine().split(" ");
            person.add(new Person(Integer.parseInt(a[0]), Integer.parseInt(a[1])));
        }

        for(int i =0; i<person.size(); i++) {
            for(int j = 0; j< person.size(); j++) {
                if(person.get(i).weight < person.get(j).weight && person.get(i).height < person.get(j).height) {
                    person.get(i).rank(person.get(i).rank + 1);
                }
            }
        }

        // map으로 Strign으로 변환하여 append처럼 joining을 붙여 원하는 문자열로 생성가능.
        String res = person.stream().map(p -> ""+p.rank).collect(Collectors.joining(" "));
        System.out.println(res);
    }
}
