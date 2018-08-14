/**
 * @Author:
 * @Description:   p38 二维数组的查找
 * @params:
 * @Data: Created in  15:23 2018/5/23
 * @Modified By:
 */
public class FindInSortedMatrix {
    public static boolean findInMatrix(int matrix[][], int rows , int colums , int number){
        boolean found = false;
        if(matrix != null && rows > 0 &&colums > 0 ){
            int row = 0;
            int colum = colums - 1 ;
            while (row < rows && colum >= 0) {
                if(matrix[row][colum]>number){
                    colum--;
                } else if (matrix[row][colum] == number) {
                    found = true;
                    break;
                }else {
                    row++;
                }
            }
        }
        return found;

    }

    public static void Test(String name , int matrix[][],int rows, int colums , int number){
        if (name != null) {
            System.out.println("name------------------------"+name);
        }
        boolean result = findInMatrix(matrix,rows,colums,number);
        System.out.println("result:\t"+result);
    }


    public void Test1(){
        int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Test("Test1:要查找的数在数组中", matrix, 4, 4, 7);
    }

    public void Test2()
    {
        int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Test("Test2:要查找的数不在数组中", matrix, 4, 4, 5);
    }

    void Test3()
    {
        Test("Test3：鲁棒性测试，输入空指针", null, 0, 0, 16);
    }

    public static void main(String[] args) {
        FindInSortedMatrix t = new FindInSortedMatrix();
        t.Test1();
        t.Test2();
        t.Test3();
    }

}
