package com.ToF.test;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author:
 * @Description:题目：0, 1, … , n-1 这n个数字排成一个圈圈，从数字0开始每次从圆圏里删除第m个数字。求出这个圈圈里剩下的最后一个数字。
 * @params:
 * @Data: Created in  10:17 2018/8/14
 * @Modified By:
 */
public class Test_46_lastRemaining {
    public static int lastRemaining(int n,int m){
        if (n < 1 || m < 1) {
            return -1;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0;i<n;i++){
            list.add(i);
        }
        //要删除的元素的位置
        int idx = 0;
        //开始计数的位置
        int start = 0;
        while (list.size() > 1) {
            for (int i = 1;i<m;i++){
                idx = (idx+1)%list.size();
            }
            list.remove(idx);
        }
        return list.get(0);
    }

    public static int lastRemaining2(int n ,int m ){
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2;i<=m;i++){
            last = (last+m)%i;
        }
        return last;
    }
    private static void test01() {
        System.out.println(lastRemaining(5, 3)); // 最后余下3
        System.out.println(lastRemaining(5, 2)); // 最后余下2
        System.out.println(lastRemaining(6, 7)); // 最后余下4
        System.out.println(lastRemaining(6, 6)); // 最后余下3
        System.out.println(lastRemaining(0, 0)); // 最后余下-1
    }

    public static void main(String[] args) {
        test01();
    }
}
