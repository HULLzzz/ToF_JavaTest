package com.ToF.test;

/**
 * @Author:
 * @Description:
 *              题目：请实现一个函数用来匹配包含‘.’和‘*’的正则表达式。模式中的字符’.’表示任意一个字符，而‘*’表示它前面的字符可以出现任意次（含0次）。
 *                   本题中，匹配是指字符串的所有字符匹配整个模式。
 *                  例如，字符串“aaa”与模式“a.a”和“ab*ac*a”匹配，但与“aa.a”及“ab*a”均不匹配。
 * @params:
 * @Data: Created in  10:35 2018/8/1
 * @Modified By:
 */
public class Test_53_Match {
    public static boolean match(String input,String pattern){
        if (input==null||pattern==null){
            return false;
        }
        return matchCore(input,0,pattern,0);
    }

    private static boolean matchCore(String input, int i, String pattern, int p) {
        //匹配串和模式串都达到队尾，说明匹配成功
        if (i>=input.length()&&p>=pattern.length()){
            return true;
        }
        //模式串达到队尾，匹配失败
        if (i!=input.length()&&p>=pattern.length()){
            return false;
        }
        //模式串未结束，匹配串可能结束也可能未结束


        //p位置的下一个字符中为*号
        if (p+1<pattern.length()&& pattern.charAt(p+1)=='*'){
            //匹配串已经结束
            if (i>=input.length()){
                return matchCore(input,i,pattern,p+2);
            }
            //匹配串还没结束
            else {
                if (pattern.charAt(p)==input.charAt(i)||pattern.charAt(p)=='.'){
                    return
                            //匹配串向后移动一个位置，模式串向后移动两个位置
                    matchCore(input,i+1,pattern,p+2)
                            //匹配串向后移动一个位置，模式串不移动
                            ||matchCore(input,i+1,pattern,p)
                            //匹配串不移动，模式串向后移动两个位置
                            ||matchCore(input,i,pattern,p+2);
                }else {
                    return matchCore(input, i, pattern, p+2);
                }
            }
        }
        //匹配串已经结束
        if (i>=input.length()){
            return false;
        }
        //匹配串还没结束
        else {
            if (input.charAt(i)==pattern.charAt(p)||pattern.charAt(p)=='.'){
                return matchCore(input,i+1,pattern,p+1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(match("", "") + "[" + true + "]");
        System.out.println(match("", ".*") + "[" + false + "]");
        System.out.println(match("", ".") + "[" + false + "]");
        System.out.println(match("", "c*") + "[" + true + "]");
        System.out.println();
    }
}
