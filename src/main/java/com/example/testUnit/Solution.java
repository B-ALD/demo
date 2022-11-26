package com.example.testUnit;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author lyl04
 * 大数加法
 */
public class Solution {
    static String solve(String s1, String s2) {
        //首先拿到两个字符串的长度
        int length1 = s1.length();
        int length2 = s2.length();
        //确保两个字符串长度相同的情况下且不改变大数的大小
        StringBuilder s1Builder = new StringBuilder(s1);
        StringBuilder s2Builder = new StringBuilder(s2);
        while (length1 > length2) {
            s2Builder.insert(0, "0");
            length2++;
        }
        while (length1 < length2) {
            s1Builder.insert(0, "0");
            length1++;
        }
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        for (int i = length1 - 1; i >= 0; i--) {
            int temp = (s1Builder.charAt(i) - '0' + s2Builder.charAt(i) - '0' + carry);
            ans.append(temp % 10);
            carry = temp / 10;
        }
        if (carry > 0) {
            ans.append(carry).append("0");
        }
        return ans.reverse().toString();
    }

    static String solved(String s, String t) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        int i = s.length()-1, j = t.length()-1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            carry += i >= 0 ? s.charAt(i--) - '0' : 0;
            carry += j >= 0 ? s.charAt(j--) - '0' : 0;
            stack.push(carry % 10);
            carry = carry / 10;
        }
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        System.out.println(solved("2434313545454515", "545135245645155545451546551"));
        //System.out.println("22552211".charAt(4));
    }
}
