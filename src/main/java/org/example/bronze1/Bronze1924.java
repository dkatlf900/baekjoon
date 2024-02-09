package org.example.bronze1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Bronze1924 {

    /**
     * Q, Bronze-1924
     * 오늘은 2007년 1월 1일 월요일이다. 그렇다면 2007년 x월 y일은 무슨 요일일까? 이를 알아내는 프로그램을 작성하시오.
     * 첫째 줄에 빈 칸을 사이에 두고 x(1 ≤ x ≤ 12)와 y(1 ≤ y ≤ 31)이 주어진다. 참고로 2007년에는 1, 3, 5, 7, 8, 10, 12월은 31일까지,
     * 4, 6, 9, 11월은 30일까지, 2월은 28일까지 있다.
     *
     * 첫째 줄에 x월 y일이 무슨 요일인지에 따라 SUN, MON, TUE, WED, THU, FRI, SAT중 하나를 출력한다.
     *
     * 1 1 --> MON
     * 3 14 --> WED
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] text = br.readLine().split(" ");
        int month = Integer.parseInt(text[0]);
        int day = Integer.parseInt(text[1]);

        Map<Integer, Integer> days = new HashMap<>();
        days.put(1,31);
        days.put(2,28);
        days.put(3,31);
        days.put(4,30);
        days.put(5,31);
        days.put(6,30);
        days.put(7,31);
        days.put(8,31);
        days.put(9,30);
        days.put(10,31);
        days.put(11,30);
        days.put(12,31);

        String[] dayText= new String[]{"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int sumDays = day;
        for(int i=1; i<month; i++) {
            if(month != 1) {
                sumDays += days.get(i);
            } else {
                break;
            }
        }
//        System.out.println("---->>> : " + sumDays);
//        System.out.println("---->>> 몫 : " + sumDays % 7);
//        System.out.println("---->>> 요일 : " + dayText[sumDays % 7]);
        System.out.println(dayText[sumDays % 7]);
    }
}
