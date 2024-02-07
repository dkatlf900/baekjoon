package org.example.test;

import java.io.IOException;
import java.util.*;

public class TEST_skiltest {

    public void test(String[][] relation) throws IOException {
        System.out.println(relation.length);
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> set3 = new HashSet<>();
        Set<String> set4 = new HashSet<>();

        int count = 0;
        for(String[] req : relation){
            set1.add(req[0]);
            set2.add(req[1]);
            set3.add(req[2]);
            set4.add(req[3]);
        }

        int[] index = new int[4];

        if(relation.length == set1.size()) {
            count++;
            index[0] = 1;
        }
        if(relation.length == set2.size()) {
            count++;
            index[1] = 2;
        }
        if(relation.length == set3.size()) {
            count++;
            index[2] = 3;
        }
        if(relation.length == set4.size()) {
            count++;
            index[3] = 4;
        }
        System.out.println(Arrays.toString(index));






/*
        Map<String, Integer> map = new HashMap<>();




        for(int i=0; i<relation.length; i++) {
            for(int j=0; j<relation[0].length; j++) {
                int count = map.getOrDefault(relation[i][j], 0)+1;
                map.put(relation[i][j], count);
            }
        }

        // Map 데이터 출력
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }*/

//
//
//        if(set.size() == relation.length) {
//
//        }

    }
}
