package com.example.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.entity.ResultBody;
import com.example.entity.SearchExportVo;
import com.example.entity.User;
import com.example.exception.MyExceptionHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author lyl04
 */
@RestController
public class TestController {

    @GetMapping("/collection2object")
    public ResultBody getUser() {
        User user = new User("111", "222", "333", "444");
        Collection<? extends User> collection = new ArrayList<>();
        List<User> list = (List<User>) collection;
        list.add(user);
        System.out.println(collection);
        List<User> list1 = (List<User>) collection;
        User user1 = list.get(0);
        System.out.println(list);
        System.out.println(user1);
        System.out.println(user1.getAddress());
        if (StringUtils.isEmpty(user.getName())) {
            throw new MyExceptionHandler("-1", "用户姓名不能为空！");
        }
        return ResultBody.success(user1);
    }

    @GetMapping("/modelAttribute")
    public ResultBody getUserById(User user){
        if (user!=null){
            if (user.getId().equalsIgnoreCase("222")){
                return ResultBody.success(getUser());
            }
        }
        return ResultBody.error("cuowu");
    }

    @PostMapping("/listToMap")
    public ResultBody listToMap(@RequestBody SearchExportVo vo){

        return ResultBody.error("cuowu");
    }
}
