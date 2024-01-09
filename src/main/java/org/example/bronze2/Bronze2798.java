package org.example.bronze2;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bronze2798 {

    /**
     * Q, Bronze-1152
     * 김정인 버전의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다. 그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다. 그런 후에 딜러는 숫자 M을 크게 외친다.
     * 이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다. 블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.
     * N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.
     *
     * 5 21
     * 5 6 7 8 9
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] text = br.readLine().split(" ");
        int x = Integer.parseInt(text[0]); // 카드개수
        int y = Integer.parseInt(text[1]); // 딜러가 제시한 숫자, 근접하게 3장 골라야한다.

        String[] inCards = br.readLine().split(" ");
        int[] cards = new int[x];
        for(int i =0; i<x; i++) {
            cards[i] = Integer.parseInt(inCards[i]);
        }

        int a,b,c =0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<x-2; i++) {
            a = cards[i];
            for(int j= i+1; j<x-1; j++) {
                b = cards[j];
                for(int k = j+1; k <x; k++){
                    c = cards[k];
                    if(a+b+c <= y) {
                        list.add(a+b+c);
                    }
                }
            }
        }
        int res = list.stream().sorted(Comparator.reverseOrder()).findFirst()
                .get();
        System.out.println(res);
    }
}
