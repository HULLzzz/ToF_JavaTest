/**
 * @Author:
 * @Description:
 * @params:
 * @Data: Created in  17:03 2018/5/23
 * @Modified By:
 */
public class ReplaceBlank {

    private static int maxLength = 100;

    public static void repalceBlank(String str, int trueLength, int maxLength){
        if (str == null || maxLength <= 0) {
            return;
        }

       char oldString[] = str.toCharArray();
        int numBlank = 0;
        int i = 0;
        while (i < trueLength) {
            if(oldString[i] == ' '){
                numBlank++;
            }
            i++;
        }

        int newLength = trueLength + numBlank*2;

        char newString[] = new char[newLength];
        for (int j = 0 ;j< newLength;j++){
            newString[j] = 0;
        }

        if (newLength > maxLength) {
            return;
        }

        int indexOld = trueLength - 1;
        int indexNew = newLength - 1 ;
        while (indexOld>=0&&indexOld<=indexNew){
            if (oldString[indexOld] == ' ') {
                newString[indexNew]='0';
                indexNew--;
                newString[indexNew] = '2';
                indexNew--;
                newString[indexNew] = '%';
                indexNew--;
            }else {
                newString[indexNew--] = oldString[indexOld];
            }
            indexOld--;
        }
        System.out.println(new String(newString));
    }

    public static void Test(String name , String str){
        if(str == null)
            return;
        if (name != null) {
            System.out.println(name + "=================");
            repalceBlank(str,str.length(),maxLength);
        }
    }

    public void T1(){
        String str = "ab c";
        Test("空格在中间",str);
    }

    public void T2(){
        String str = " abc";
        Test("空格在开头",str);
    }

    public void T3(){
        String str = "     ";
        Test("全是空格",str);
    }



    public static void main(String[] args) {
//        String str = " hello name hehe ";
//        String newStr = str.replace(" ","%20");
//        System.out.println(newStr);
        ReplaceBlank t = new ReplaceBlank();
        t.T1();
        t.T2();
        t.T3();
    }

}
