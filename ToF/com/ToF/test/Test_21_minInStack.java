package com.ToF.test;

import java.util.Stack;

/**
 * @Author:
 * @Description:题目： 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小素的min 函数。在该栈中，调用min、push 及pop的时间复杂度都是0(1)
 *              思路：利用辅助栈，存放最小值在数据栈中的位置，保证辅助栈的栈顶元素始终是最小值
 *
 * @params:
 * @Data: Created in  16:47 2018/8/8
 * @Modified By:
 */
public class Test_21_minInStack {
    public static class StackWithMin<T extends Comparable<T>>{
        private Stack<T> dataStack;
        private Stack<Integer> minStack;

        //构造函数
        public StackWithMin(){
            //存放插入的数据
            this.dataStack = new Stack<>();
            //存放最小的数据在数据栈中的位置
            this.minStack = new Stack<>();
        }

        //出栈方法
        public T pop(){
            if (dataStack.isEmpty()){
                throw new RuntimeException("the stack is empty");
            }

            minStack.pop();
            return dataStack.pop();

        }

        //元素入栈
        public void push(T t){
            if (t==null){
                throw new RuntimeException("element is null");
            }
            //如果数据栈是空的，直接将元素入栈，同时更新最小数栈中的数据
            if (dataStack.isEmpty()){
                dataStack.push(t);
                minStack.push(0);
            }else {
                //数据栈中有数据
                //获取未插入元素之前数据栈中的最小元素
                T e = dataStack.get(minStack.peek());
                dataStack.push(t);
                //插入的元素比栈中的最小元素小
                if (t.compareTo(e)<0){
                    //将新的最小元素的位置入站栈
                    minStack.push(dataStack.size()-1);
                }else {
                    //插入的元素不比原来的元素要小，复制栈顶元素，将其入栈
                    minStack.push(minStack.peek());
                }
            }
        }

        public T min(){
            if (minStack.isEmpty()){
                throw new RuntimeException("no element in stack");
            }
            //辅助栈的栈顶保存的永远是最小值在数据栈中的位置
            return dataStack.get(minStack.peek());
        }

        public static void main(String[] args) {
            StackWithMin<Integer> stack = new StackWithMin<>();
            stack.push(3);
            System.out.println(stack.min() == 3);
            stack.push(4);
            System.out.println(stack.min() == 3);
            stack.push(2);
            System.out.println(stack.min() == 2);
            stack.push(3);
            System.out.println(stack.min() == 2);
            stack.pop();
            System.out.println(stack.min() == 2);
            stack.pop();
            System.out.println(stack.min() == 3);
            stack.push(0);
            System.out.println(stack.min() == 0);
        }

    }


}
