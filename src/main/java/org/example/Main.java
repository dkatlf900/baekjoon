package org.example;

import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] x = new int[n];
        for(int i=0; i<n; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }


        for(int k : x) {
            int[]dp = new int[k+1];
            dp[1] = 1;
            if(k>=2) dp[2] = 2;
            if(k>=3) dp[3] = 4;

            for (int i = 4; i <= k; i++) {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
            System.out.println(Arrays.toString(dp));
            System.out.println(dp[k]);
        }
/*
            if(k == 1){
                bw.write(k+"");
                bw.newLine();
                break;
            }*/
//        bw.flush();


//        int[] x = new int[n];


//        System.out.println(dp[n]);
    }
}



/*
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(br.readLine()); // 상근이가 가지고있는 숫자카드 개수 N, ex) 4
        long[] myCardList = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        int M = Integer.parseInt(br.readLine()); // 상근이 카드와 비교해야하는 숫자카드 개수 M, ex) 4
        long[] cardList = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        Map<Long, Integer> cardCount = new HashMap<>();
        for (long card : myCardList) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }

        StringBuilder result = new StringBuilder();
        for (long card : cardList) {
            result.append(cardCount.getOrDefault(card, 0)).append(" ");
        }
        System.out.println(result.toString().trim());
    }
}*/












/*

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b;
        a = scanner.nextInt();
        b = scanner.nextInt();

        while (a < 1) {
            System.out.println("첫 번째 정수를 다시 입력하세요: ");
            a = scanner.nextInt();
        }

        while (b > 10001) {
            System.out.println("두 번째 정수를 다시 입력하세요: ");
            b = scanner.nextInt();
        }
//        double res = (double) a / b;
//        int res2 = a % b;
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.println(a%b);
//        System.out.println("=====>>>> 결과값 : " + res);
    }*/
