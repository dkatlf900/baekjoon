package org.example.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver1010 {

    /**
     * Q, Silver-1010
     * 재원이는 서쪽의 사이트와 동쪽의 사이트를 다리로 연결하려고 한다.
     * (이때 한 사이트에는 최대 한 개의 다리만 연결될 수 있다.) 재원이는 다리를 최대한 많이 지으려고 하기 때문에
     * 서쪽의 사이트 개수만큼 (N개) 다리를 지으려고 한다. 다리끼리는 서로 겹쳐질 수 없다고 할 때 다리를 지을 수 있는 경우의 수를 구하는 프로그램을 작성하라.
     *
     * 입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다.
     * 그 다음 줄부터 각각의 테스트케이스에 대해 강의 서쪽과 동쪽에 있는 사이트의 개수 정수 N, M (0 < N ≤ M < 30)이 주어진다.
     *
     * 3
     * 2 2
     * 1 5
     * 13 29
     * --->
     * 1
     * 5
     * 67863915
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            String[] text = br.readLine().split(" ");
            int a = Integer.parseInt(text[0]);
            int b = Integer.parseInt(text[1]);
            boolean[] visits = new boolean[a];
            this.calc(a, b, 0, visits);
        }
    }

    public void calc(int a, int b, int c, boolean[] visits) {
        // a를 기준으로 b와 매칭할수있는 경우의수를 구해야 한다.
        // 단 a와 b사이에서 다리는 겹쳐질수 없다 즉, a의 거점 개수가 많더라도 첫번째 거점 다리 이후부터 해당 숫자보단 커야한다.
        // 2 -4 는 6가지가 나와야한다.
//        a = 3;
//        b = 5;
//        if(a == b) {
//            System.out.println(" ====>> :" +a +"/" + b +" : " + 1);
//            return;
//        }
        // 문제를 조금 추려서 3개의 거점과 5개의 연결점이 있다고 생각하고 풀어보자.

        // 결국 a지점과 b지점을 한번 열결하고 그다음 a+1번의 지점을 b+1지점부터 연결해야 하는데 이 모든 지점을 연결한게 1회다.
        // 1회라는게 전부다 작업이 되었을때만 의미가 있다.
        // 1-1 /1-2/1-3


        // 2가지 경우의 수는 b-1 의 팩토리얼인데?
        // 재귀함수 같은데
        /*
        = 8개 경우의수가 있다. , 5개 요소중에 3개를 선택한다.
        // 3은 3개 , 2는 3개 1은 3개 이거 방문정보를 넣어서 하는게 좋아보이기도 하네.
        1-1, 2-2, 3-3
        1-1, 2-2, 3-4
        1-1, 2-2, 3-5
        1-1, 2-3, 3-4
        1-1, 2-3, 3-5
        1-1, 2-4, 3-5
        1-2, 2-4, 3-5
        1-3, 2-4, 3-5*/

        visits[c] = true;

        int cnt = 0;
        int visit = 0;
        for(int i=c; i<b; i++){
            if(i >= a) {
                cnt++;
            } else if(i < a){

            }
        }

        int xx = b - a + 1; // 3
//        int cnt = 0;
//        for(int i=0; i<xx; i++) {
        for(int i=a; i<=b; i++) {
            cnt++;
        }
        if(a>1){
//            calc(a-1, b-1);
        }



//        int cnt = 0;
        for(int i=0; i<a; i++) {
            int move = b- a + i;
//            while (true) {
//
//            }
            for(int k=i; k<=move; k++){
                System.out.println((i+1)+"--"+(k+1));
                cnt++;
            }
        }
        System.out.println(" ====>> :" +a +"/" + b +" : " + cnt);
    }
}
