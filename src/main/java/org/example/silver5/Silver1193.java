package org.example.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Silver1193 {

    /**
     * Q, Silver-1193
     * 무한히 큰 배열에 다음과 같이 분수들이 적혀있다.
     *
     * 1/1	1/2	1/3	1/4	1/5	…
     * 2/1	2/2	2/3	2/4	…	…
     * 3/1	3/2	3/3	…	…	…
     * 4/1	4/2	…	…	…	…
     * 5/1	…	…	…	…	…
     * …	…	…	…	…	…
     * 이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
     *
     * 첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.
     * 첫째 줄에 분수를 출력한다.
     *
     * 4
     * ---> 3/1
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inNum = Integer.parseInt(br.readLine());

        // 분모 / 분자에 대한 배열을 만들어 둘까 아니면
        int x = 0; // 몇번까지 진행했는지 회수이며 입력받은 횟수만큼 도달하지 않았다면 inNum - x 로 차액만큼 더 진행시켜서 값을 알아내겠다.
        int cnt = 0; // 다음 대각선 그룹으로 넘어간 횟수
        int t = 1;
        int temp = 0;  // 진행해야하는 남은 횟수.
        while (true) {
            if(x + t <= inNum){
                x = x + t;
                t++;
                cnt++;
            } else {
                temp = inNum - x; // 진행해야하는 남은 횟수.
                cnt = temp !=0 ? cnt+1 : cnt;
                break;
            }
        }


//        System.out.println("===>> 1: x:" + x + "-----cnt:"+ cnt);
//        System.out.println("===>> 2 temp : " + temp);
        if(inNum == 1) {
            System.out.println("1/1");
        } else {
            int parent = 1; // 분모
            int son = cnt; // 분자

            // 어차피 남은 횟수만큼 해주고 서로 위치만 변경하면 되기에 횟수만큼 차감부터 해야한다.
            if(temp != 0){
                // 횟수먼저 계산해준다.
                int move = temp -1; // 실제 이동해야할 거리. 1은 본인 위치이기에 이동하지 않는다.
                // 분모는 더하기 , 분자는 빼기로 진행한다.
                parent = parent + move;
                son = son - move;
            } else {
                // temp가 0일때 짝수든 홀수든 애매한 부분이 있네.
                int temp2 = son;
                son = parent;
                parent = temp2;
            }

            // 마지막으로 지그재그의 위치에 따라 뒤집어 분모 분자를 바꿔줘야 한다. 나는 짝수를 고정으로 하였기에 홀수 패턴일때만 뒤집는다.
            if(cnt % 2 !=0) {
                // 홀수
                int temp2 = son;
                son = parent;
                parent = temp2;
            }
            System.out.println(parent + "/" + son);
        }
    }
}
