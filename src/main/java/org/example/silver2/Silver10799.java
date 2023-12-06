package org.example.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Silver10799 {

    /**
     * 한 줄에 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 공백없이 주어진다. 괄호 문자의 개수는 최대 100,000이다.
     * ex) ()(((()())(())()))(())
     * 출력) 17
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();

        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        for(int i =0; i<text.length(); i++) {
            if('(' == text.charAt(i)) {
                stack.push(i);
            } else {
                if(!stack.isEmpty()&& stack.peek() == i-1) {
                    stack.pop();
                    cnt += stack.size();
                } else {
                    if(!stack.isEmpty()){
                        stack.pop();
                        cnt += 1;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
