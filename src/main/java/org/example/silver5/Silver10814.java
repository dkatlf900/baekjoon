package org.example.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Silver10814 {

    /**
     * 첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)
     * 둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다.
     * 나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고,
     * 이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다.
     * 입력은 가입한 순서로 주어진다.
     */

    public class Member {
        private int age;
        private String name;
        private int sort;

        public Member(int age, String name, int sort) {
            this.age = age;
            this.name = name;
            this.sort = sort;
        }

    }

    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Member> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            String[] str = br.readLine().split(" ");
            list.add(new Member(Integer.parseInt(str[0]), str[1], i));
        }

        list.stream()
                .sorted((a, b) -> a.age == b.age ? Integer.compare(a.sort, b.sort) : Integer.compare(a.age, b.age))
                .forEach(a -> System.out.println(a.age + " " + a.name));
    }
}
