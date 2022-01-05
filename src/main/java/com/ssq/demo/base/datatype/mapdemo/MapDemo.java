package com.ssq.demo.base.datatype.mapdemo;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-12-16 17:11:50
 * @Description: Map的Key与Value
 *                  所以当Key相同时,value值会被覆盖
 */
public class MapDemo {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("淇", "小上进");
        map.put("淇淇淇", "久久久");
        System.out.println(map);
        map.put("淇","123");
        System.out.println(map);

        Map<String, List<String>> listMap = new HashMap<>();
        listMap.put("轻触", Lists.newArrayList("一","只","情","话"));
        System.out.println(listMap);
        listMap.put("轻触", Lists.newArrayList("情","话"));
        System.out.println(listMap);
    }
}
