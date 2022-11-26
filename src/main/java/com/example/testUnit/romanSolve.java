package com.example.testUnit;

import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字解析
 */
public class romanSolve {
    private static final Map<String, Integer> romanMAP = new HashMap<>(7);
    private static final Map<String, String> romanMAP1 = new HashMap<>(7);

    static{
        romanMAP.put("I", 1);
        romanMAP.put("V", 5);
        romanMAP.put("X", 10);
        romanMAP.put("L", 50);
        romanMAP.put("C", 100);
        romanMAP.put("D", 500);
        romanMAP.put("M", 1000);
        romanMAP1.put("aa","aa");
    }
    @Data
    static class ss {
        private String strin;
        Integer s;
    }

    private static int getCharAt(int i, String s ){
        return romanMAP.get(String.valueOf(s.charAt(i)));
    }

    public static int romanToInt(String s) {
        int result = 0;
        for(int i = 0; i < s.length() ;i++){
            if(getCharAt(i,s) < getCharAt(i+1,s)){
                result -= getCharAt(i,s);
            }else {
                result += getCharAt(i,s);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = romanMAP1.get("SSS");
        if (!StringUtils.isEmpty(s)) {
            System.out.println(s);
        }else {
            ss s1 = new ss();
            s1.setStrin(s);
            s1.setS(null);
            System.out.println(s1);
        }
    }
}
