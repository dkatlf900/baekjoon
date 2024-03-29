package org.example.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver1316 {

    /**
     * Q, Silver-1316
     * 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
     * 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만,
     * aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
     *
     *
     * 첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 단어가 들어온다.
     * 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
     *
     * 3
     * happy
     * new
     * year
     * --->3
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        for(int i=0; i<n; i++){
            String x = br.readLine();
            sum += calc(x);
        }
        System.out.println(sum);
    }

    public int calc(String x) {
        String nowStr = "";
        String tempStr ="";

        int res = 1;
        for(int i=0; i<x.length(); i++){
            String str = String.valueOf(x.charAt(i));
            if(i == 0){
                nowStr = str;
                tempStr = str;
            } else if(!nowStr.equals(str) && tempStr.contains(str)){
                return 0;
            }
            nowStr = String.valueOf(x.charAt(i));
            tempStr += nowStr;
        }
        return res;
    }
}
