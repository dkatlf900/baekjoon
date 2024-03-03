package org.example.silver3;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Silver1929 {

    /**
     * Q, Silver-1929
     * M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
     * 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
     * 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
     *
     * 3 16
     * --->>
     * 3
     * 5
     * 7
     * 11
     * 13
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] text = br.readLine().split(" ");
        int n = Integer.parseInt(text[0]);
        int m = Integer.parseInt(text[1]);
        sieveOfEratosthenes(n,m, bw);

        // TODO 아래방법으로 풀어보니 시간초과가 발생, 그래서 에라토스테네스 체 알고리즘으로 풀이하면 속도가 월등히 빠름.
        // 1과 0은 소수가 아니다.
        /*List<Integer> x = new ArrayList<>();
        x.add(2);
        x.add(3);
        x.add(5);
        x.add(7);
        Set<Integer> set = new HashSet<>();
        for(int i = n; i<=m; i++){
            if(i<10){
                if (x.contains(i)) {
                    bw.write(""+ i);
                    bw.newLine();
                }
            } else {
                if(i % 2 !=0 && i % 3 !=0 && i % 5 !=0 && i % 7 !=0) {
                    double xx = Math.sqrt(i);
                    if(xx == Math.floor(xx)){
                        continue;
                    }
                    if(!set.isEmpty()){
                        boolean isStop = false;
//                        int z = (i / 2) + 1;
                        for(int a : set) {
                            if(i % a == 0){
//                            if(a <=z && i % a == 0){
                                isStop = true;
                                break;
                            }
                        }
                        if(isStop) {
                            continue;
                        }
                    }
//                    double xx = Math.sqrt(i);
                    if(xx != Math.floor(xx)){
                        set.add(i);
                        bw.write(""+ i);
                        bw.newLine();
                    }
                }
            }
        }

        System.out.println("Gggg");
        bw.flush();
        bw.close();*/
    }

    public void sieveOfEratosthenes(int n, int m, BufferedWriter bw) throws IOException {

        /**
         *
         에라토스테네스의 체를 구현하는 방법은 다음과 같습니다:
         1.먼저, 주어진 범위 내에서 소수 여부를 저장할 배열을 준비합니다. 배열의 크기는 소수를 판별하려는 최댓값까지의 숫자입니다.
         2.배열을 초기화합니다. 초기화 단계에서는 모든 숫자를 소수라고 가정하고, 배열의 각 요소를 true로 설정합니다.
         3.0과 1은 소수가 아니므로 false로 설정합니다.
         4.2부터 시작하여 배수를 찾아 해당 숫자를 소수가 아닌 것으로 표시합니다. 이 과정에서 이미 소수가 아닌 것으로 판별된 숫자는 건너뜁니다.
         5.배수를 찾을 때는 해당 숫자의 제곱부터 시작하여 범위 내에서 배수를 찾습니다. 이렇게 하면 중복된 검사를 피할 수 있습니다.
         6.모든 숫자에 대해 위 과정을 반복하면 소수를 찾을 수 있습니다.
         */

        // 소수는 true, 아니면 false
        boolean[] eratos = new boolean[m+1];

        for(int i=2; i<=m; i++){
            eratos[i] = true;
        }

        for(int i=2; i*i<=m; i++) {
            if(eratos[i]){
                for(int k= i*i; k<=m; k+=i){
                    if(eratos[k]){
                        eratos[k] = false;
                    }
                }
            }
        }

        for(int i=n; i<=m; i++){
            if(eratos[i]) {
                bw.write(""+i);
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        System.out.println("ddd");

    }
}
