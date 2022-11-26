package com.example.testUnit;

import com.alibaba.fastjson.JSON;
import lombok.Builder;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

public class testTree {

    @Data
    @Builder
    static
    class Menu {
        private Integer id;
        private String name;
        //父级id
        private Integer pid;
        //子节点信息
        private List<Menu> child;

        public Menu(Integer id, String name, Integer pid) {
            this.id = id;
            this.name = name;
            this.pid = pid;
        }

        public Menu(Integer id, String name, Integer pid, List<Menu> child) {
            this.id = id;
            this.name = name;
            this.pid = pid;
            this.child = child;
        }
    }

    private static List<Menu> getTree(Menu menu, List<Menu> menus) {
        return menus.stream().filter(m -> Objects.equals(m.getPid(), menu.getId())).peek(
                m -> m.setChild(getTree(m, menus))
        ).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Menu> menus = Arrays.asList(
                new Menu(1, "根节点", 0),
                new Menu(2, "节点2", 1),
                new Menu(3, "节点3", 1),
                new Menu(4, "节点4", 2),
                new Menu(5, "节点5", 2),
                new Menu(6, "节点6", 3),
                new Menu(7, "节点7", 4),
                new Menu(8, "节点8", 1),
                new Menu(9, "节点9", 1)
        );
        List<Menu> collect = menus.stream().filter(menu -> menu.getPid() == 0).peek(
                menu -> menu.setChild(getTree(menu, menus))
        ).collect(Collectors.toList());
        System.out.println(JSON.toJSON(collect));
    }
}

/*
 * [
 *     {
 *         "name":"根节点",
 *         "pid":0,
 *         "id":1,
 *         "child":[
 *             {
 *                 "name":"节点2",
 *                 "pid":1,
 *                 "id":2,
 *                 "child":[
 *                     {
 *                         "name":"节点4",
 *                         "pid":2,
 *                         "id":4,
 *                         "child":[
 *                             {
 *                                 "name":"节点7",
 *                                 "pid":4,
 *                                 "id":7,
 *                                 "child":[
 *
 *                                 ]
 *                             }
 *                         ]
 *                     },
 *                     {
 *                         "name":"节点5",
 *                         "pid":2,
 *                         "id":5,
 *                         "child":[
 *
 *                         ]
 *                     }
 *                 ]
 *             },
 *             {
 *                 "name":"节点3",
 *                 "pid":1,
 *                 "id":3,
 *                 "child":[
 *                     {
 *                         "name":"节点6",
 *                         "pid":3,
 *                         "id":6,
 *                         "child":[
 *
 *                         ]
 *                     }
 *                 ]
 *             },
 *             {
 *                 "name":"节点8",
 *                 "pid":1,
 *                 "id":8,
 *                 "child":[
 *
 *                 ]
 *             },
 *             {
 *                 "name":"节点9",
 *                 "pid":1,
 *                 "id":9,
 *                 "child":[
 *
 *                 ]
 *             }
 *         ]
 *     }
 * ]
 */
