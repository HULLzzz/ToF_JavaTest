package com.ToF.test;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author:
 * @Description:题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 * @params:
 * @Data: Created in  14:39 2018/8/6
 * @Modified By:
 */
public class Test_07_QueueWithStack {
    public static class MList<T>{
        //插入栈，只用于插入数据
        private Stack<T> stack1 = new Stack<>();
        //弹出栈,只用于弹出数据
        private Stack<T> stack2 = new Stack<>();

        public MList(){ }

        //添加操作，在队列头部插入节点
        public void appendTail(T t){
            stack1.add(t);
        }
        //删除操作，在队列的头部删除节点
        public T deleteHead(){
            //先判断弹出栈是否为空
            //将弹出的数据压入弹出栈内
            if (stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.add(stack1.pop());
                }
            }
            //如果弹出栈中还没有数据，抛出异常
            if (stack2.isEmpty()){
                throw new RuntimeException("No more element");
            }

            //返回弹出栈的栈顶元素，对应的就是队首元素
            return stack2.pop();
        }
    }


    //两个队列实现栈
    public static class StackByQueue{
        private LinkedList<String> queue1;
        private LinkedList<String> queue2;

        public StackByQueue(){
            queue1 = new LinkedList<String>();
            queue2 = new LinkedList<String>();
        }

        public String pop(){
            String re = null;
            if (queue1.size()==0&&queue2.size()==0){
                return null;
            }
            if (queue2.size()==0){
                while (queue1.size()>0){
                    re = queue1.removeFirst();
                    if (queue1.size()!=0){
                        queue2.addLast(re);
                    }
                }
            }else if (queue1.size()==0){
                while (queue2.size()>0){
                    re = queue2.removeFirst();
                    if(queue2.size()!=0){
                        queue1.addLast(re);
                    }
                }
            }
            return re ;
        }

        public String push(String str){
            if (queue1.size()==0&&queue2.size()==0){
                queue1.addLast(str);
            }
            else if (queue1.size()!=0){
                queue1.addLast(str);
            }
            else if(queue2.size()!=0){
                queue2.addLast(str);
            }
            return str;
        }

    }
}
