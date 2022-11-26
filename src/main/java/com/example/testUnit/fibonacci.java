package com.example.testUnit;

/**
 * 斐波那契数列的两种实现方式
 */
public class fibonacci {
    //递归
    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (n > 2) {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
        return -1;
    }

    //值传递
    public static int fibonacci2(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 0;
        if (n > 2) {
            for (int i = 0; i < n - 2; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(fibonacci(0));
        System.out.println(fibonacci2(0));
    }
}
