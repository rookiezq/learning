package com.rookied.learning.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangqiang
 * @date 2021/4/15
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap(16);
        map.put(null,1);
        System.out.println(map.size());
    }
}
