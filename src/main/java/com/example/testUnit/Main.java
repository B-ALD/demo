package com.example.testUnit;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>(n-1);
        for (int i = 0 ;i<n ;i++){
            int key = in.nextInt();
            int val = in.nextInt();
            if (map.containsKey(key)){
                map.put(key,map.get(key)+val);
            }else{
                map.put(key,val);
            }
        }
        map.forEach((k,v)->{
            System.out.println(k+" "+v);
        });
    }
}