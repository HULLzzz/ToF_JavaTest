package com.ToF.test;

/**
 * @Author:
 * @Description:
 *
 *      * 题目：地上有个m行n列的方格。一个机器人从坐标(0,0)的格子开始移动，
 *      * 它每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数
 *      * 位之和大于k的格子。例如，当k为18时，机器人能够进入方格(35,37)，
 *      * 因为3+5+3+7=18.但它不能进入方格(35,38)，因为3+5+3+8=19.
 *      * 请问该机器人能够达到多少格子？
 *      *
 *      * @param threshold 约束值
 *      * @param rows      方格的行数
 *      * @param cols      方格的列数
 *      * @return 最多可走的方格
 * @params:
 * @Data: Created in  13:17 2018/7/27
 * @Modified By:
 */
public class Test_67_MovingRangeOfRobot {
    //参数校验
    public static int movingCount(int threshold,int rows,int cols){
        if (threshold<0||rows<1||cols<1)
            return 0;
        //变量初始化
        boolean[] visited = new boolean[rows*cols];
        for (int i = 0;i<visited.length;i++){
            visited[i] = false;
        }
        return movingCountCore(threshold,rows,cols,0,0,visited);
    }

    /**
     * @Author:
     * @Description: 递归回溯法
     * @params:  rows方格的行数 cols方格的列数 row当前处理的行号 col当前处理的列数 visites访问标记标记数组
     * @return：  最多可走的方格
     * @Data: Created in  8:17 2018/7/28
     * @Modified By:
     *
     */

    private static int movingCountCore(int threshold,int rows,int cols,int row,int col ,boolean[] visited){

        int count = 0;
        if (check(threshold,rows,cols,row,col,visited)){
            visited[row*cols+col] = true;
            count = 1
                    +movingCountCore(threshold,rows,cols,row-1,col,visited)
                    +movingCountCore(threshold,rows,cols,row,col-1,visited)
                    +movingCountCore(threshold,rows,cols,row+1,col,visited)
                    +movingCountCore(threshold,rows,cols,row,col+1,visited);
        }
        return count;

    }


//判断机器人是否能进入下一个方格
    private static boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        return col >= 0&& col<cols
                &&row >=0 && row<rows
                &&!visited[row*cols+col]
                &&(getDigitSum(col)+getDigitSum(row)<=threshold);
    }


    //一个数的数位之和

    private static int getDigitSum(int number) {
        int result = 0;
        while (number > 0){
            result +=(number%10);
            number /= 10;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(movingCount(5,10,10));
    }
}
