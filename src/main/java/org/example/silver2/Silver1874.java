package org.example.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Silver1874 {

    /**
     * 첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다.
     * 둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다.
     * 물론 같은 정수가 두 번 나오는 일은 없다.
     * 확실히 StringBuilder 가 System.out.println 보다 압도적으로 빠르다 한 5배 이상
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt((br.readLine()));

        int[] aa = new int[n+1];
        for(int i=1; i<=n; i++){
            aa[i] = Integer.parseInt((br.readLine()));
        }

        Stack<Integer> ascInt = new Stack<>();
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for(int i=1; i <= n; i++) {
            ascInt.push(i);
//            list.add("+");
            sb.append("+\n");


            while (!ascInt.isEmpty() && ascInt.peek() == aa[cnt]) {
                ascInt.pop();
                list.add("-");
                sb.append("-\n");
                cnt++;
            }
        }

        if(!ascInt.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
//            list.stream().forEach(a -> System.out.println(a));
        }
    }
}
