package org.example.test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Test11111 {

    /**
     * Q, TEST 1
     * 딥브레인 2번문제
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
//    static int cnt;
//    static StringBuilder sb = new StringBuilder();


    public void test() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long t = Long.parseLong(bufferedReader.readLine().trim());

        int dCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> dTemp = new ArrayList<>();

        IntStream.range(0, dCount).forEach(i -> {
            try {
                dTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> d = dTemp.stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        long res = triplets(t, d);

//        bufferedWriter.write(String.valueOf(res));
//        System.out.println(sb);
        System.out.println(res);
//        bufferedWriter.newLine();

//        bufferedReader.close();
//        bufferedWriter.close();

    }

    public int calc(int k, List<Integer> d, long t) {
        if(3 == k) {
            int temp =0;
            boolean isOk = true;
            for(int i=0; i<3; i++){
                if(i==0 && arr[i] > arr[i+1]){
                    isOk = false;
                    continue;
                } else if(i!=0 && arr[i-1] > arr[i]){
                    isOk = false;
                    continue;
                }
                temp += arr[i];
                if(temp > t){
                    isOk = false;
                }
            }

            if(isOk) {
                return 1;
            }
            return 0;
        }

        int count = 0;
        for(int i=0; i<d.size(); i++){
            if(!visit[i]) {
                visit[i] = true;
                arr[k] = d.get(i);
                count += calc(k + 1, d, t);
                visit[i] = false;
            }
        }
        return count;
    }

    private long triplets(long t, List<Integer> d) {
        List<Integer> temp = d.stream().sorted().collect(toList());
        visit = new boolean[d.size()];
        arr = new int[3];
        long cnt = 0;
        cnt = calc(0, temp, t);
        return cnt;
    }


}
