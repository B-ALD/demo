package com.example.testUnit;

import java.util.Scanner;

/**
 * 计算最长数列
 */
public class maxListLength {

    public static Integer test(Integer sum, String s) {
        Integer length = 0;
        String[] s1 = s.split(",");
        for (int i = 0; i <= s1.length-1; i++) {
            int sumCopy = sum;
            int subLength = 0;
            for (int j = i; j <= s1.length - 1; j++) {
                int a = j > i ? Integer.parseInt(s1[j - 1]) : 0;
                int b = Integer.parseInt(s1[j]);
                if (b >= a) {
                    sumCopy -= b;
                    if (sumCopy == 0) {
                        subLength = j - i + 1;
                    }
                } else {
                    break;
                }
            }
            length = Math.max(length, subLength);
        }
        if (length > 1) {
            return length;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            String b = in.next();
            System.out.println(test(a, b));
        }

    }

}
