package com.example.testUnit;

public class SomeClass {
    public static int indexOf(String source, String str) {
        if (source == null || source.length() < 1 || str == null || str.length() < 1) {
            return -1;
        }
        if (str.length() > source.length()) {
            return -1;
        }
        char[] sourceList = source.toCharArray();
        char[] strList = str.toCharArray();
        for (int i = 0; i < source.length(); i++) {
            if (sourceList[i] == strList[0] && source.length()>= str.length()+i){
                int index = 0;
                for (int j =0;j<str.length();j++){
                    if (sourceList[i+j] == strList[j]){
                        index++;
                    } else {
                        break;
                    }
                }
                if (index == str.length()){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(indexOf("abcdabdef","abd"));
    }
}
