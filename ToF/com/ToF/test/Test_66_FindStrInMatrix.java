package com.ToF.test;

/**
 * @Author:
 * @Description:
 *
 *      * 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 *      * 路径可以从矩阵中任意一格开始，每一步可以在矩阵中间向左、右、上、下移动一格。
 *      * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 *      *
 *
 *       思路：当矩阵中定位了前n个字符的位置后，在第n个格子周围都没有找到第n+1个字符，则退回到n-1个字符重新定位第n个字符
 *
 * @params: matrix 输入的矩阵 rows矩阵行数 cols 矩阵的列数 str 要搜索的字符串
 * @Data: Created in  8:56 2018/7/28
 * @Modified By:
 */
public class Test_66_FindStrInMatrix {
    public static boolean hasPath(char[] matrix,int rows,int cols,char[] str){
        //参数校验
        if (matrix == null || matrix.length != rows*cols || str == null || str.length<1){
            return false;
        }

        //变量初始化
        boolean[] visited = new boolean[rows*cols];
        for (int i = 0;i<visited.length;i++ ){
            visited[i] = false;
        }
        //记录结果的数组
        int[] pathLength = {0};   // 已经处理的字符串的个数
        //以每一个点为起始进行搜索
        for (int i = 0;i<rows;i++){
            for (int j = 0;j<cols;j++){
                if (hasPathCore(matrix,rows,cols,str,visited,i,j,pathLength))
                    return true;
            }
        }
        return false;
    }


    private static boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, boolean[] visited, int row, int col, int[] pathLength) {
        if (pathLength[0] == str.length)
            return true;
        boolean hasPath = false;
        //判断位置是否合法
        if (row >= 0 && row<rows
                && col >=0 && col<cols
                &&matrix[row*cols + col] == str[pathLength[0]]
                && !visited[row*cols + col]){
            visited[row*cols + col] = true;
            pathLength[0]++;

            //按照左上右下进行回溯
            hasPath = hasPathCore(matrix,rows,cols,str,visited,row,col-1,pathLength)
                    ||hasPathCore(matrix,rows,cols,str,visited,row+1,col,pathLength)
                    ||hasPathCore(matrix,rows,cols,str,visited,row,col+1,pathLength)
                    ||hasPathCore(matrix,rows,cols,str,visited,row-1,col,pathLength);

            if (!hasPath){
                pathLength[0]--;
                visited[row*cols + col] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(), 3, 4,
                "ABCCED".toCharArray()) + "[true]");// true
    }
}
