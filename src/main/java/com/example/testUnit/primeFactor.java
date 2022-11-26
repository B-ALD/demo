package com.example.testUnit;
import java.util.Scanner;

/**
 * 计算一个数的所有质因子，包括重复的
 */
public class primeFactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long num = scanner.nextLong();

        for (long i = 2; i <= num; ++i) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        System.out.println();
    }
}
