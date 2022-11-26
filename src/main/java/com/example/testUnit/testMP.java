package com.example.testUnit;

import com.example.entity.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author lyl04
 */
public class testMP {
    /***
     *条件构造器 查询操作SelectList
     */
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(System.currentTimeMillis()));
    }
}
