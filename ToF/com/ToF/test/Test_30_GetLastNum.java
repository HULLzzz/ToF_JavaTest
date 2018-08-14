package com.ToF.test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:
 * @Description:题目： 输入n个整数，找出其中最小的k个数。
 * @params:
 * @Data: Created in  16:20 2018/8/9
 * @Modified By:
 */
public class Test_30_GetLastNum {
    //大顶堆
    private final static class MaxHeap<T extends Comparable<T>>{
        // 堆中元素存放的集合
        private List<T> items;
        // 用于计数
        private int cursor;

        /**
         * 构造一个椎，始大小是32
         */
        public MaxHeap() {
            this(32);
        }
        //构造指定初始大小的堆
        public MaxHeap(int size){
            items = new ArrayList<>(size);
            cursor = -1;
        }
        //向上调整堆
        public void siftUp(int index){
            T intent = items.get(index);//获取开始调整的元素的对象

            while (index > 0) {
                //如果不是根元素
                //获取父节点对象
                int parentIndex = (index - 1)/2;
                T parent = items.get(parentIndex);
                if (intent.compareTo(parent)>0){
                    //父节点下放
                    items.set(index,parent);
                    //记录父节点的位置
                    index = parentIndex;
                }else {
                    break;
                }
            }
            items.set(index,intent);
        }

        //向下调整堆
        public void siftDown(int index)
        {
            T intent = items.get(index);
            int leftIndex = 2*index+1;

            while (leftIndex < items.size()) {
                T maxChild = items.get(leftIndex);
                int maxIndex = leftIndex;
                int rightIndex = leftIndex + 1;
                if (rightIndex<items.size()){
                    //如果有右子节点
                    T rightChild = items.get(rightIndex);
                    //找出两个子节点中最大的节点
                    if (rightChild.compareTo(maxChild) > 0) {
                        maxChild = rightChild;
                        maxIndex = rightIndex;
                    }
                }
                //如果最大的子节点比父节点大，则需要向下调整
                if (maxChild.compareTo(intent) > 0) {
                    items.set(index,maxChild);
                    index = maxIndex;
                    leftIndex = index * 2 + 1; //找到上移节点的左子节点的位置
                }else {
                    break;
                }
            }
            items.set(index,intent);
        }

        //向堆中添加一个元素
        public void add(T item){
            items.add(item);
            siftUp(items.size()-1);
        }

        //删除堆顶元素，删除idnex位置的元素：将最后的叶子节点的元素赋值给index，进行下沉操作
        public T deleteTop(){
            if (items.isEmpty()) {
              throw new RuntimeException("the heap is empty");
            }
            T maxItem = items.get(0);
            T lastItem = items.remove(items.size()-1);
            //删除之后，如果堆为空，则删除的元素就是堆顶元素
            if (items.isEmpty()){
                return lastItem;
            }
            //将删除的元素放入堆顶，自上向下调整堆
            items.set(0,lastItem);
            siftDown(0);
            return maxItem;
        }
        //获取下一个元素
        public T next(){
            if (cursor >= items.size()) {
                throw new RuntimeException("no more element");
            }
            return items.get(cursor);
        }

        public int size(){
            return items.size();
        }

        public T first(){
            return items.get(0);
        }
        public boolean hasNext(){
            cursor++;
            return cursor<items.size();
        }

        //第二种解法：
        public static void getLeastNumber2(int[] input,int[] output){
            if (input == null || output == null || output.length <= 0 || output.length > input.length) {
                throw new IllegalArgumentException("Invalid args");
            }
            MaxHeap<Integer> maxHeap = new MaxHeap<>(output.length);
            for (int i : input){
                if (maxHeap.size()<output.length){
                    maxHeap.add(i);
                }
                else {
                    int max = maxHeap.first();
                    if (max > i) {
                        maxHeap.deleteTop();
                        maxHeap.add(i);
                    }
                }
            }
            for (int i = 0;maxHeap.hasNext();i++){
                output[i] = maxHeap.next();
            }
        }

        public static void getLeastNumbers1(int[] input,int[] output){
            if (input == null || output == null || output.length <= 0 || output.length > input.length) {
                throw new IllegalArgumentException("invalid args");
            }
            int start = 0;
            int end = input.length - 1 ;
            int index = partition(input,start,end);
            int target = output.length - 1;
            while (index != target) {
                if (index<target){
                    start = index+1;
                }else {
                    end = index - 1;
                }
                index = partition(input,start,end);
            }
            System.arraycopy(input,0,output,0,output.length);
        }
        //分区算法，return: 分区位置

        private static int partition(int[] input, int start, int end) {
            int tmp = input[start];
            while (start < end) {
                while (start < end && input[end] >= tmp) {
                    end--;
                }
                input[start] = input[end];
                while (start < end && input[start] <= tmp) {
                    start++;
                }
                input[end] = input[start];
            }
            input[start] = tmp;
            return start;
        }
        public static void main(String[] args) {
            int[] data = {4, 5, 1, 6, 2, 7, 3, 8};

            int[] output = new int[4];
            getLeastNumbers1(data, output);
            for (int i : output) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }



}
