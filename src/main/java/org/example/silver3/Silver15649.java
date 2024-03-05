package org.example.silver3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Silver15649 {

    /**
     * Q, Silver-15649
     * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
     * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
     *
     * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
     * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
     * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
     *
     *
     * 4 4
     * --->>
     * 1 2 3 4
     * 1 2 4 3
     * 1 3 2 4
     * 1 3 4 2
     * 1 4 2 3
     * 1 4 3 2
     * 2 1 3 4
     * 2 1 4 3
     * 2 3 1 4
     * 2 3 4 1
     * 2 4 1 3
     * 2 4 3 1
     * 3 1 2 4
     * 3 1 4 2
     * 3 2 1 4
     * 3 2 4 1
     * 3 4 1 2
     * 3 4 2 1
     * 4 1 2 3
     * 4 1 3 2
     * 4 2 1 3
     * 4 2 3 1
     * 4 3 1 2
     * 4 3 2 1
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] text = br.readLine().split(" ");
        int n = Integer.parseInt(text[0]);
        int m = Integer.parseInt(text[1]);

        List<Integer> list = new ArrayList<>();
        boolean[] temp = new boolean[n];
        calc(list, temp, m, n,0);
    }

    public void calc(List<Integer> list, boolean[] temp, int m, int n, int k) throws IOException {
        // TODO 백트래킹 알고리즘으로 조건이 일치하는것만 탐색과정을 거치면 된다.
        if(m == k){
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<m; i++){
                if(i != m-1) sb.append(list.get(i)).append(" ");
                else sb.append(list.get(i));
            }
            sb.append("\n");
            System.out.print(sb);
            return;
        }

        for(int i=1; i<=n; i++) {
            if(!temp[i-1]){
                temp[i-1] = true;
                list.add(i);
                calc(list, temp, m, n, k+1);
                temp[i-1] = false; // 백트래킹의 핵심 부분이다. 탐색 완료후 이전으로 롤백시키고
                list.remove(k); // 백트래킹의 핵심 부분이다. 기존에 넣어둔 값도 제거하여 초기화. TODO 이부분은 배열로 덮어쓰기를 하는게 더 좋네.
            }
        }

        /*if(!temp[k]) {
            temp[k] = true;
            bw.write(list.get(k) + " ");
            cnt --;
        } else {
            return;
        }

        // 여기서 4개 숫자가 들어왔고 4개를 선택한다면
        for(int i=0; i<list.size(); i++) {
            if(cnt == 0) {
                return;
            } else if(!temp[i]) {
//                temp[i] = true;
//                bw.write(list.get(i) + " ");
                calc(list, temp,bw,cnt, i);
            }
        }*/
    }

}
