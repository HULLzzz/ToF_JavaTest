package com.ToF.test;

/**
 * @Author:
 * @Description:  题目：在一个字符流中找到第一个只出现一次的字符
 *                思路：一个字符流中一次来一个字符，可以用一个数据容器来保存字符在字符流中的位置
 *                     为了提高效率使用哈希表作为数据容器，字符对应的ASCII码作为哈希表的键值，将字符流中的字符插入到数据容器中
 *
 * @params:
 * @Data: Created in  16:44 2018/7/31
 * @Modified By:
 */
public class Test_55_FirstAppearOnce {

    public static void main(String[] args) {
        System.out.println(new CharStatistics().firstAppearOnceChar("")); // '\0'
        System.out.println(new CharStatistics().firstAppearOnceChar("g")); // 'g'
        System.out.println(new CharStatistics().firstAppearOnceChar("go")); // 'g'
        System.out.println(new CharStatistics().firstAppearOnceChar("goo")); // 'g'
        System.out.println(new CharStatistics().firstAppearOnceChar("goog")); // '\0'
        System.out.println(new CharStatistics().firstAppearOnceChar("googl")); // l
        System.out.println(new CharStatistics().firstAppearOnceChar("google")); // l
    }
    private static class CharStatistics{
        //出现一次的标识
        private int index = 0;
        private int[] occurrence = new int[256];  //创建一个哈希表，字符的ASCII码作为哈希表的键值

        public CharStatistics(){
            for (int i = 0;i<occurrence.length;i++){
                occurrence[i] = -1;
            }
        }

        private void insert(char ch){
            if (ch>255){
                throw new IllegalArgumentException(ch+"must be ASSIC char");
            }
            //只出现了一次
            if (occurrence[ch] == -1){   //首次出现的时候将value值置为index再次出现的时候判断value值即可，如果不是首次出现将value值置为-2
                occurrence[ch] = index;
            }else {
                occurrence[ch] = -2;
            }
            index++;
        }

        public char firstAppearOnceChar(String data){
            if (data==null){
                throw new IllegalArgumentException(data);
            }
            for (int i = 0;i<data.length();i++){
                insert(data.charAt(i));
            }
            char ch = '\0';
            //用于记录最小的索引，对应的就是第一个不重复的数字
            int minIndex = Integer.MAX_VALUE;
            for (int i = 0; i<occurrence.length;i++){
                if (occurrence[i]>=0&&occurrence[i]<minIndex){
                    ch = (char)i;   //i是对应的插入字符的ASCII码值
                    minIndex = occurrence[i];  //寻找首次出现的只出现一次的字符
                }
            }
            return ch;  //如果没有不重复的字符，返回的char值就是’\0'
        }

    }
}
