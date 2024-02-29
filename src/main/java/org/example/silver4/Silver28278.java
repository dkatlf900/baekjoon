package org.example.silver4;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Silver28278 {

    /**
     * Q, Silver-28278
     * 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
     *
     * 명령은 총 다섯 가지이다.
     *
     * 1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
     * 2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
     * 3: 스택에 들어있는 정수의 개수를 출력한다.
     * 4: 스택이 비어있으면 1, 아니면 0을 출력한다.
     * 5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
     *
     *
     * 첫째 줄에 명령의 수 N이 주어진다. (1 ≤ N ≤ 1,000,000)
     * 둘째 줄부터 N개 줄에 명령이 하나씩 주어진다.
     * 출력을 요구하는 명령은 하나 이상 주어진다.
     *
     *
     * 9
     * 4
     * 1 3
     * 1 5
     * 3
     * 2
     * 5
     * 2
     * 2
     * 5
     * ---->
     * 1
     * 2
     * 5
     * 3
     * 3
     * -1
     * -1
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            String[] in = br.readLine().split(" ");
            switch (in[0]) {
                case "1" :
                    // 1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
                    stack.push(Integer.parseInt(in[1]));
                    break;
                case "2" :
                    // 2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
                    if (stack.isEmpty()) {
                        bw.write("-1");
                        bw.newLine();
                    } else {
                        bw.write(stack.pop().toString());
                        bw.newLine();
                    }
                    break;
                case "3" :
                    // 3: 스택에 들어있는 정수의 개수를 출력한다.
                    bw.write(stack.isEmpty() ? "0" : ""+stack.size());
                    bw.newLine();
                    break;
                case "4" :
                    // 4: 스택이 비어있으면 1, 아니면 0을 출력한다.
                    bw.write(stack.isEmpty() ? "1" : "0");
                    bw.newLine();
                    break;
                case "5" :
                    // 5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
                    if (stack.isEmpty()) {
                        bw.write("-1");
                        bw.newLine();
                    } else {
                        bw.write(stack.peek().toString());
                        bw.newLine();
                    }
                    break;
            }
        }
        bw.flush();
    }
}
