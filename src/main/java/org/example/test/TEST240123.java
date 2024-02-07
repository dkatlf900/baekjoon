package org.example.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TEST240123 {

    /**
     * int[] numbers = {10, 40, 30, 20};
     *         int k = 20;
     *
     *  배열의 인접한 차이가 K 이하가 되도록 해야한다. 음수도 상관없음
     *   정답: {10, 30, 40, 20};
     *
     *
     */

    public int movie = 0;
    /*public void swap(int[] array, int i, int j, int k) {
        for(int a = j+1; a < array.length; a++) {
            // J는 이미 차이가 나서 바꿔야 하는것이기때문에 패스
//            int res = array[i];
            int res = Math.abs(array[i] - array[a]);
            if(res <= k) {
                int temp = array[j];
                array[j] = array[a];
                array[a] = temp;
                movie++;
                break;
            }
        }
        System.out.println("==@@@@@@@> array :" + Arrays.toString(array));
    }*/

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

//        System.out.println("==@@@@@@@> array :" + Arrays.toString(array));
    }

    // 하나라도 안맞으면 false
    public boolean cal(int[] array, int k) {
        for (int i = 0; i < array.length - 1; i++) {
            if (Math.abs(array[i] - array[i + 1]) > k) {
                return false;
            }
        }
        return true;
    }


    private int[] swapRecursively(int[] numbers, int k, int index) {
        if (index >= numbers.length - 1) {
            return numbers;
        }

        int diff = Math.abs(numbers[index] - numbers[index + 1]);
        if (diff > k) {
            // Swap 수행
            int temp = numbers[index];
            numbers[index] = numbers[index + 1];
            numbers[index + 1] = temp;
            return swapRecursively(numbers, k, index + 1);
        }

        // 다음 인덱스에 대해 재귀 호출
        return swapRecursively(numbers, k, index + 1);
    }

    private int greedySwap(int[] numbers, int k) {
        int moveCount = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            int diff = Math.abs(numbers[i] - numbers[i + 1]);

            if (diff > k) {
                // Swap 수행
                int temp = numbers[i];
                numbers[i] = numbers[i + 1];
                numbers[i + 1] = temp;
                moveCount++;
            }
        }

        return moveCount;
    }

    private int backtrackingSwap(int[] numbers, int k, int index) {
        if (index == numbers.length - 1) {
            // 종료 조건: 배열 끝까지 탐색 완료
            return 0;
        }

        // 현재 인덱스와 다음 인덱스의 차이가 k보다 크면 스왑을 수행
        int diff = Math.abs(numbers[index] - numbers[index + 1]);
        int moveCount = 0;
        if (diff > k) {
            // Swap 수행
            int temp = numbers[index];
            numbers[index] = numbers[index + 1];
            numbers[index + 1] = temp;
            moveCount = 1;
        }

        // 다음 인덱스로 이동하며 재귀 호출
        return moveCount + backtrackingSwap(numbers, k, index + 1);
    }



    private int minMoves = Integer.MAX_VALUE;

    private void minMoveRecursive(int[] numbers, int k, int moves) {
        if (isSorted(numbers, k)) {
            minMoves = Math.min(minMoves, moves);
            return;
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                swap(numbers, i, j);
                minMoveRecursive(numbers, k, moves + 1);
                swap(numbers, i, j); // 원복
            }
        }
    }

    public void min(int[] numbers, int k, int moves) {
        /*if (cal(numbers, k)) {
            minMoves = Math.min(minMoves, moves);
            return;
        }*/
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                swap(numbers, i, j);
            }
        }
    }

    private boolean isSorted(int[] numbers, int k) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (Math.abs(numbers[i] - numbers[i + 1]) > k) {
                return false;
            }
        }
        return true;
    }

    public void test(int[] numbers, int k) throws IOException {
        System.out.println("==> 초기: " + Arrays.toString(numbers));
//        int[] result = swapRecursively(numbers, k, 0);
//        int result = backtrackingSwap(numbers, k, 0);
        minMoveRecursive(numbers, k, 0);

        System.out.println("==> 정답: " + Arrays.toString(numbers));
//        System.out.println("==> 정답: " + result);
        System.out.println("==> 실제 정답:[4, 7, 5, 8, 6, 3, 2, 1], 정답:2회 이동");


        /*System.out.println("==> 초기:" + Arrays.toString(numbers));
        int[] copyNumbers = Arrays.copyOf(numbers, numbers.length);
        System.out.println("==> 초기222:" + Arrays.toString(copyNumbers));*/

        // 문제. numbers의 중복없이 숫자가 들어있는 배열이다.  swap를 이용해서
        // 서로 인접한 원소의 차이가 k이가 되도록 하려한다 단, swap을 최소한으로 이용해야한다.
        // 스왑횟수를 출력하시오
        // ==> 초기:[3, 7, 2, 8, 6, 4, 5, 1] , K =3
        // ==> 정답:[4, 7, 5, 8, 6, 3, 2, 1], 정답:2회 이동
        /*int move = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            int diff = Math.abs(numbers[i] - numbers[i + 1]);
            if (diff > k) {
                // Swap 수행
                int temp = numbers[i+1];
                numbers[i+1] = numbers[i + 2];
                numbers[i + 2] = temp;
                move++;

                // 인덱스를 처음부터 다시 시작
//                i = -1;
            }
        }

        System.out.println("==> move:" + move);*/



/*
        // 그냥 브루트포스처럼 하나하나 돌려보는건?
        for(int i=0; i<numbers.length-1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
//                System.out.println("========> for: i:"+numbers[i] +"  j:"+numbers[j]);
                int res = Math.abs(numbers[i] - numbers[j]);
                if (res > k) {
                    System.out.println("==> swap: i:"+i +"  j:"+j);
                    System.out.println("========> for: i:"+numbers[i] +"  j:"+numbers[j]);
                    this.swap(copyNumbers, i, j, k);
                    break;
                }
            }
        }*/
//        System.out.println("==> 초기:" + Arrays.toString(numbers));
//        System.out.println("==> 이동횟수:" + movie);
    }
}
