package com.ToF.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author:
 * @Description:题目：在字符串中找出第一个只出现一次的字符。
 * @params:
 * @Data: Created in  9:29 2018/8/11
 * @Modified By:
 */
public class Test_35_firstNotRepeatingChar {
    public static char firstNotRepeatingChar(String s){
        if (s == null || s.length() < 1) {
            throw new IllegalArgumentException("invalid input");
        }
        //定义一个哈希表
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                //map.put(key,value)
                map.put(c,-2);
            }else {
                map.put(c,i);
            }
        }
        //遍历MAP：Map.entrySet() 这个方法返回的是一个Set<Map.Entry<K,V>> Map.Entry里有相应的getKey和getValue方法
        Set<Map.Entry<Character,Integer>> entrySet = map.entrySet();
        //记录只出现一次的字符的索引
        int idx = Integer.MAX_VALUE;
        char result = '\0';

        for (Map.Entry<Character,Integer> entry:entrySet){
            if (entry.getValue() >= 0 && entry.getValue() < idx) {
                idx = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(firstNotRepeatingChar("google")); // l
        System.out.println(firstNotRepeatingChar("aabccdbd")); // '\0'
    }
}
