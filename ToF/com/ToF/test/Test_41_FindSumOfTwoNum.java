package com.ToF.test;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import sun.rmi.log.LogInputStream;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:
 * @Description:面试题41：和为s 的两个数字vs 和为s 的连续正数序列
 * @params:
 * @Data: Created in  9:33 2018/8/3
 * @Modified By:
 */

public class Test_41_FindSumOfTwoNum {
    //题目一：输入一个递增排序的数组和一个数字s，在数组中查找两个数，得它们的和正好是s。
    // 如果有多对数字的和等于s，输出任意一对即可。

    /*
     *思路：我们先在数组中选择两个数字，如果它们的和等于输入的s，我们就找到了要找的两个数字。
     *如果和小于s 呢？我们希望两个数字的和再大一点。由于数组已经排好序了，我们可以考虑选择较小的数字后面的数字。因为排在后面的数字要大一些，那么两个数字的和也要大一些， 就有可能等于输入的数字s 了。
     * 同样， 当两个数字的和大于输入的数字的时候，我们可以选择较大数字前面的数字，因为排在数组前面的数字要小一些。
     * */

    public static List<Integer> findNumWithSum(int[] data,int sum){
        List<Integer> result = new ArrayList<Integer>(2);
        if (data.length<2||data==null)
            return result;

        int ahead = data.length-1;
        int behind = 0;
        long curSum; //统计和，取long是防止结果溢出
        while (behind<ahead){
            curSum = data[behind] + data[ahead];
            if (curSum == sum){
                result.add(data[behind]);
                result.add(data[ahead]);
                break;
            }
            else if (curSum<sum){
                behind++;
            }
            else
                ahead--;
        }
        return result;
    }

    /*
    *题目二：输入一个正数s，打印出所有和为s 的连续正数序列（至少两个数）。
    *thinking:　考虑用两个数small 和big 分别表示序列的最小值和最大值。
                首先把small 初始化为1, big 初始化为2。如果从small 到big 的序列的和大于s，我们可以从序列中去掉较小的值，也就是增大small 的值。如果从small 到big 的序列的和小于s，我们可以增大big，让这个序列包含更多的数字。因为这个序列至少要有两个数字，我们一直增加small 到(1+s)/2 为止。
　　             以求和为9 的所有连续序列为例，我们先把small 初始化为1, big 初始化为2。
                此时介于small 和big 之间的序列是｛1，2}，序列的和为3，小于9，所以我们下一步要让序列包含更多的数字。我们把big 增加1 变成3,此时序列为｛ I, 2，坷。由于序列的和是6，仍然小于9，我们接下来再增加big 变成4，介于small 和big 之间的序列也随之变成｛ l, 2, 3, 4｝。由于列的和10 大于9，我们要删去去序列中的一些数字， 于是我们增加small 变成2，此时得到的序列是｛2, 3, 4｝， 序列的和E好是9。我们找到了第一个和为9 的连续序列，把它打印出来。
                接下来我们再增加big，重复前面的过程，可以找到第二个和为9 的连续序列｛4，5}。
    *
    * */

    public static List<List<Integer>> findContinousSequence(int sum){
        List<List<Integer>> result = new ArrayList<>();
        if (sum<3){
            return result;
        }
        int small = 1;
        int big = 2;
        int middle = (1 + sum)/2;
        int curSum = small+big;
        while (small<middle){
            if (curSum == sum){
                List<Integer> list = new ArrayList<>(2);
                for (int i=small;i<=big;i++){
                    list.add(i);
                }
                result.add(list);
            }
            while(curSum>sum&&small<middle){
                curSum -= small;
                small++;
                if (curSum==sum){
                    List<Integer> list = new ArrayList<>(2);
                    for (int i = small;i<=big;i++){
                        list.add(i);
                    }
                    result.add(list);
                }
            }
            big++;
            curSum+=big;
        }
        return result;
    }




}
