package com.ToF.test;

import sun.net.www.HeaderParser;

import javax.management.RuntimeMBeanException;
import javax.naming.directory.InvalidSearchControlsException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author:
 * @Description: 如何得到一个数据流中的中位数
 *
 *
 *      思路：   在数据流中找中位数，数据流来的数据不确定，使用最大堆最小堆，容器中的数据被中间的一个或者两个数据分为左边和右边
 *              左边的数据构造成一个最大堆，右边的数据构造为一个最小堆
 *              就算左右容器内部的数据没有排序，也能根据左边的最大数和右边的最小数来得到中位数
 *              要保证最大堆中的所有数据都小于最小堆，如何保证：将新的数据插入到最大堆中，再将最大堆中的最大数据拿出来插入到最小堆中
 *
 * @params:
 * @Data: Created in  11:14 2018/7/28
 * @Modified By:
 */
public class Test_64_FindMiddleNum {

    public static class Heap<T>{
        //堆中元素存放的集合
        private List<T> data;
        //比较器
        private Comparator<T> cmp;

        //构造函数  param:cmp 比较器对象

        public Heap(Comparator<T> cmp) {
            this.data = new ArrayList<>(64);
            this.cmp = cmp;
        }

        //向上调整堆 param：idx 被上移元素的起始位置
        public void shiftUp(int idx){
            //检查位置是否正确
            if (idx<0||idx>=data.size()){
                throw new IllegalArgumentException(idx + " ");
              }
            //获取开始调整的元素对象
            T intent = data.get(idx);

            //不是根元素，则需要上移
            while (idx>0){
                //找出父元素对象的位置
                int parentIdx = (idx - 1) / 2;
                //获取父元素对象
                T parent = data.get(parentIdx);

                //上移的条件：子节点比父节点，此处定义的大是以比较器的返回值为准
                if (cmp.compare(intent,parent)>0){
                    //父节点下放
                    data.set(idx,parent);
                    idx = parentIdx;
                    //记录父节点下放的位置
                }
                else
                    break;
            }
            //index 此时记录的是最后一个被下放的父节点的位置（也可能是自身）
            //将最开始调整的元素放入index的位置即可
            data.set(idx,intent);
        }

        //向下调整堆
        public void shiftDown(int idx){
            if (idx < 0|| idx>=data.size()){
                throw new IllegalArgumentException(idx + "");
            }
            //获取开始调整的元素对象
            T intent = data.get(idx);
            //获取开始调整的元素对象的左子节点的元素位置
            int leftIdx = idx*2 + 1;
            //如果有左子节点
            while (leftIdx<data.size()){
                T maxChild = data.get(leftIdx);
                //两个子节点中最大节点元素的位置，假定开始的时候为左子节点的位置
                int maxIdx = leftIdx;

                //右节点的位置
                int rightIdx = leftIdx + 1;
                //如果有右节点
                if (rightIdx<data.size()){
                    T rightChild = data.get(rightIdx);
                    //找出两个节点中最大的子节点
                    if (cmp.compare(rightChild,maxChild)>0){
                        maxChild = rightChild;
                        maxIdx = rightIdx;
                    }
                }
                //子节点如果比父节点大，则需要向下调整
                if (cmp.compare(maxChild,intent)>0){
                    data.set(idx,maxChild);
                    idx = maxIdx;
                    leftIdx = idx*2 + 1;
                }
                else
                    break;
            }
            data.set(idx,intent);

        }

        //添加一个元素
        public void add(T item){
            data.add(item);
            //上移完成重构
            shiftUp(data.size()-1);
        }

        //删除堆顶节点 return:堆顶节点
        public T deleteTop(){
            //堆为空，抛出异常
            if (data.isEmpty()){
                throw new RuntimeException("the heap is empty");
            }
            //获取堆顶元素
            T first = data.get(0);
            //删除最后一个元素
            T last = data.remove(data.size() - 1);

            //删除元素后，如果堆为空的情况，说明删除的元素也是堆顶元素
            if (data.size()==0){
                return last;
            }
            else {
                //将删除的元素放入堆顶
                data.set(0,last);
                //自上向下调整堆
                shiftDown(0);
                return first;
            }
        }

        //获取堆顶元素，但不删除 return:堆顶元素
        public T getTop(){
            if (data.isEmpty()){
                throw new RuntimeException("the heap is empty");
            }

            return data.get(0);
        }

        //获取堆的大小
        public int size(){
            return data.size();
        }

        //判断堆是否为空
        public boolean isEmpty(){
            return data.isEmpty();
        }

        //清空堆
        public void clear(){
            data.clear();
        }

        //获取堆中的所有数据
        public List<T> getData(){
            return data;
        }

    }

    //升序比较器
    private static class IncComarator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    //降序比较器
    private static class DescComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    private static class DynamicArray{
        private Heap<Integer> max;
        private Heap<Integer> min;

        public DynamicArray(){
            max = new Heap<>(new IncComarator());
            min = new Heap<>(new DescComparator());
        }

        //插入数据
        public void insert(Integer num){
            //已经有偶数个数据了
            //数据总数是偶数个的时候插入小堆
            if (min.size() + max.size() % 2 == 0){
                //大堆中有数据，且插入的元素比大堆中的元素小
                if (max.size()>0&&num<max.getTop()){
                    //将num插入到大堆中
                    max.add(num);
                    //删除堆顶元素，大堆中的最大元素
                    num = max.deleteTop();
                }

                min.add(num);

            }
            //数据总数是奇数的时候将新数据插入到大堆中
            else {
                //小堆中有元素，且插入的元素比小堆中的元素大
                if (min.size()>0&&num>min.getTop()){
                    min.add(num);
                    num = min.deleteTop();
                }
                max.add(num);
                //将num插入到小堆中，num大于小堆中的最小值，num分到小堆
            }
        }

        public double getMedian(){
            int size = max.size() + min.size();
            if (size == 0){
                throw new RuntimeException("no numbers are avalibale");
            }
            if ((size & 1)== 1){
                return min.getTop();
            }
            else
                return (max.getTop()+min.getTop())/2.0;
        }
    }

    public static void main(String[] args) {
        DynamicArray array = new DynamicArray();
        array.insert(5);
        System.out.println(array.getMedian());

        array.insert(2);
        System.out.println(array.getMedian());

        array.insert(9);
        System.out.println(array.getMedian());

    }
}
