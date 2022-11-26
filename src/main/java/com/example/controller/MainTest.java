package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.util.Base64Util;
import org.springframework.util.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Map;
import java.util.Scanner;

/**
 * @author lyl04
 */
public class MainTest {


    public static final String KEY_MD5 = "MD5";

    public static String encryptAndDencrypt(String value, char secret) {
        byte[] bt = value.getBytes(); // 将需要加密的内容转换为字节数组
        for (int i = 0; i < bt.length; i++) {
            bt[i] = (byte) (bt[i] ^ (int) secret); // 通过异或运算进行加密
        }
        String newresult = new String(bt, 0, bt.length); // 将加密后的字符串保存到 newresult 变量中
        return newresult;
    }


    public static void main(String[] args) throws Exception {
        String test = "{\"projectname\":\"\",\"supportedcompid\":\"\",\"applicantdepartname\":\"部门1\",\"applicantdepartid\":\"88b1312255eb11e9940bb73524c3d1d0\",\"projectid\":\"\",\"supportedcompname\":\"商旅\"}";
        Map<String,Object> map = JSONObject.parseObject(test);
        System.out.println((String) map.get("applicantdepartname"));
    }



}

