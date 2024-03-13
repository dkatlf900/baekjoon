package org.example.test;

import java.io.IOException;
import java.util.*;

public class TEST_0311_1 {

    /**
     * 03/11- 1
     */
    public int[] test(int[] deposit) throws IOException {
//        int[] answer = {};
        // [500, 1000, -300, 200, -400, 100, -100]  --> [500, 500]
        // 여기서 0원을 기준으로 양수면 입금, 음수면 출금이고

        // 디큐 구조로 뒤에서부터 빼야하며 남은 배열을 리턴하면 되다.

        Deque<Integer> queue = new LinkedList<>();
        for(int i=0; i<deposit.length; i++) {
            int money = deposit[i];
            if(money > 0){
                // 입금
                queue.offer(money);
            } else {
                // 출금
                poll(queue, money);
            }
        }

        int[] res = new int[queue.size()];
        int index =0;
        while (queue.size() !=0) {
            res[index++] = queue.pollFirst();
        }

        System.out.println(Arrays.toString(deposit));
        return res;
    }

    public void poll(Deque<Integer> queue, int money) {
        // 출금
        int total = Math.abs(money);
        while (total != 0) {
            int temp = queue.peekLast() - total;
            if(temp > 0){
                // 금액이 남았다면 제거하고 다시 넣어준다.
                queue.pollLast();
                queue.addLast(temp);
                total = 0;
            } else {
                // 출금하고도 더 제거해야 한다면
                if(queue.peekLast() >= total){
                    total = queue.pollLast() - total;
                } else {
                    total = total - queue.pollLast();
                }
            }
        }
    }



}
