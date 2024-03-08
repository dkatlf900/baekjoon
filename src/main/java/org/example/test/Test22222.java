package org.example.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Test22222 {

    /**
     * Q, TEST 1
     *
     * 8
     * 5
     * 1
     * 4
     * 2
     * 6
     * 3
     * -->
     * 3개
     */

    static boolean[] visit;
    static int[] arr;


    public void test() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = getMinMoves(s);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();

    }


    public static int getMinMoves(String s) {
        // Write your code here
        List<Integer> temp = new ArrayList<>();
        String text = String.valueOf(s.charAt(0));
        for(int i=0; i<s.length()-1; i++){
            temp.add(Math.abs(s.charAt(i) - s.charAt(i+1)));
            if(temp.get(i) > 0) {
//                text += s.charAt()
            } else {
//                s.
            }
        }

        return 0;
    }


}
