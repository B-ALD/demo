package com.example.testUnit;

import java.util.Scanner;

/**
 * @author lyl04
 */
public class stringWildcard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            System.out.println(isTrue(str1, str2));
        }
    }

    public static boolean isTrue(String str1, String str2) {
        if (str1.length() > str2.length()) {
            return false;
        }
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) != '*' && str1.charAt(i) != '?') {
                if (str1.charAt(i) != str2.charAt(j)) {
                    return false;
                } else {
                    i++;
                    j++;
                }
            } else if (str1.charAt(i) == '*' && i != str1.length() - 1) {
                if (str1.length() == str2.length()) {
                    i++;
                    j++;
                } else {
                    i++;
                    while (j < str2.length()) {
                        if (str1.charAt(i) == str2.charAt(j)) {
                            break;
                        } else {
                            j++;
                        }
                    }
                }
            } else if (str1.charAt(i) == '?') {
                i++;
                j++;
            } else if (str1.charAt(i) == '*' && i == str1.length() - 1) {
                return true;
            }
        }
        if (i == str1.charAt (i)) {
            return true;
        }
        return false;
    }

}
