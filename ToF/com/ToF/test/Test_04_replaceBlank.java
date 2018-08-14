package com.ToF.test;

/**
 * @Author:
 * @Description:请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.“，则输出”We%20are%20happy.“。
 * @params:
 * @Data: Created in  11:27 2018/8/6
 * @Modified By:
 */
public class Test_04_replaceBlank {

    public static int replaceBlank(char[] string,int usedLength){
        //判断输入是否合法
        if (string==null||string.length<usedLength){
            return -1;
        }
        //统计字符数组中的空白字符数
        int whiteCount = 0;
        for (int i = 0;i<usedLength;i++){
            if (string[i]==' '){
                whiteCount++;
            }
        }
        //计算转换后的字符长度是多少
        int targetLength = whiteCount*2+usedLength;
        int tmp = targetLength;
        if (targetLength>string.length){
            return -1;
        }
        //没有空白字符就不用处理
        if (whiteCount==0){
            return usedLength;
        }

        usedLength--; // 从后向前第一个开始处理的字符
        targetLength--; //处理后字符放置的位置

        //字符中有空白字符，一直处理到所有空白字符处理完
        while(usedLength>=0&&usedLength<targetLength){
            if (string[usedLength]==' '){
                string[targetLength--] = '0';
                string[targetLength--] = '2';
                string[targetLength--] = '%';
            }else {
                string[targetLength--] = string[usedLength];
            }
            usedLength--;
        }
        return tmp;
    }
    public static void main(String[] args) {
        char[] string = new char[50];
        string[0] = ' ';
        string[1] = 'e';
        string[2] = ' ';
        string[3] = ' ';
        string[4] = 'r';
        string[5] = 'e';
        string[6] = ' ';
        string[7] = ' ';
        string[8] = 'a';
        string[9] = ' ';
        string[10] = 'p';
        string[11] = ' ';

        int length = replaceBlank(string, 12);
        System.out.println(new String(string, 0, length));
    }


}

