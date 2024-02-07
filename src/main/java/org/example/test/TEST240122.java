package org.example.test;

import java.io.IOException;
import java.util.*;

public class TEST240122 {

    /**
     * 코딩테스트 시험
     * Q, Bronze-3052
     *
     *--->:[1, 15000]
     * --->:[4, 35000] : 140,000
     * --->:[10, 100000] : 1,000,000
     */

    /**
     * 입력값 〉
     * ["123-4567", "451-2314", "015-1643"]
     * ------------------------
     * , ["111-1111"]
     * ------------------------
     * , ["123-4567"
     * , "000-0022"
     * , "015-1643"
     * , "000-0022"
     * , "111-1111"
     * , "000-0022"
     * , "111-1111"
     * , "111-1111"]
     * ------------------------
     * , 2
     *
     * ------------------------
     * 기댓값 〉 0 은 미경고, 1은 경고표시
     * [0, 1, 0, 1, 1, 0, 1, 1]
     *
     *
     * approved: 연락처
     * spams: 스팸
     * calls: 전화목록
     * k: 이숫자 이후로는 경고표시 안함 하지만 이하라면 경고표시 필요
     *
     *
     * ---
     * 주입받은 데이터
     * // 변경된 예시 입력
     *         int n = 20;
     *         int[][] batteryInfo = {{6, 30000}, {3, 18000}, {4, 28000}, {1, 9500}};
     */
    public void test(String[] approved, String[] spams, String[] calls, int k) throws IOException {

        int[] result = new int[calls.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < calls.length; i++) {
            // 스팸처리
            if(spamContains(spams, calls[i])) {
                result[i] = 1;
            } else if (approvedContains(approved, calls[i])) { // 저장번호 처리
                result[i] = 0;
            } else {
                int callCount = map.getOrDefault(calls[i], 0) + 1; // 1개씩 추가
                map.put(calls[i], callCount);
                if(callCount > k) {
                    result[i] = 0;
                } else {
                    result[i] = 1;
                }
            }
        }
        System.out.println(Arrays.toString(result));
    }


    // 연락처
    public boolean approvedContains(String[] array, String target) {
        for (String arr : array) {
            if (arr.equals(target)) {
                return true;
            }
        }
        return false;
    }

    // 스팸
    public boolean spamContains(String[] array, String target) {
        for (String arr : array) {
            if (arr.equals(target)) {
                return true;
            }
        }
        return false;
    }

}
