package com.example.testUnit;

import java.util.Scanner;

public class drawMachine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int end = Integer.parseInt(str[1]);
        int[] x = new int[n];
        int[] offsetY = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            offsetY[i] = in.nextInt();
        }
        int area = 0;
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            area += (x[i] - a) * Math.abs(b);
            a = x[i];
            b += offsetY[i];
        }
        area += (end - a) * Math.abs(b);
        System.out.println(area);
    }
}

