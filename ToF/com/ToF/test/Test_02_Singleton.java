package com.ToF.test;

import org.omg.CORBA.PRIVATE_MEMBER;

import javax.swing.*;

/**
 * @Author:
 * @Description:实现Singleton (单例模式）模式——七种实现方式:设计一个类，我们只能生成该类的一个实例
 * @params:
 * @Data: Created in  10:00 2018/8/6
 * @Modified By:
 */
public class Test_02_Singleton {
    //单例模式，饿汉式，线程安全
    //尚未用到此单一实例的时候先实例化

    public static class Singleton{
        //静态变量，直接初始化
        //private 除了类内部，其他地方无法访问该变量 static：确保是静态变量，可以通过类名来调用，不用实例化
        private final static Singleton INSTANCE = new Singleton();
        private Singleton(){}
        public static Singleton getInstance(){
            return INSTANCE;
        }
    }

    //单例模式，懒汉式，线程不安全
    //特点：延迟加载，需要用到此单一实例的时候采取初始化
    //线程不安全：当线程1判断instance==null进行new操作，在new操作之前，线程2判断instance==null，也会执行new操作，在高并发的情况下就可能存在多个实例
    public static class Singleton02{
        private static Singleton02 instance = null;
        private Singleton02(){}
        public static Singleton02 getInstance(){
            if (instance == null){
                instance = new Singleton02();
            }
            return instance;
        }
    }

    //单例模式，懒汉式，线程安全，多线程环境下效率不高
   //考虑线程安全的问题，同步避免多线程的问题
       public static class Singleton03{
        private static Singleton03 instance = null;
        private Singleton03(){ }
        public static synchronized Singleton03 getInstance(){
            if (instance==null){
                instance = new Singleton03();
            }
            return instance;
        }
    }



    //单例模式，懒汉式，变种，线程安全
    public static class Singleton04{
        private static Singleton04 instance = null;
        static {
            instance = new Singleton04();
        }
        private Singleton04(){}
        public static Singleton04 getInstance(){
            return instance;
        }
    }

    //单例模式，使用静态内部类，线程安全（推荐）
    //java静态内部类可以访问其外部的成员的属性和方法，静态内部类只有当被调用的时候才首次被加载
    //利用静态内部类的懒加载方式实现
    public static class Singleton05{
        private final static class SingletonHolder{
            private static final Singleton05 INSTANCE = new Singleton05();
        }
        private Singleton05(){}

        public static Singleton05 getInstance(){
            return SingletonHolder.INSTANCE;
        }
    }

    //静态内部类，使用枚举的方式，线程安全（推荐）
    public enum Singleton06{
        INSTANCE;
        public void whateverMethod(){

        }
    }

    //考虑性能的问题： 静态内部类，使用双重校验锁，线程安全（推荐）
    //
    //每次获取实例的方法都是同步的，这样性能很受影响
    //volatile, 用更低的代价替代同步,同步的代价, 主要由其覆盖范围决定, 如果可以降低同步的覆盖范围, 则可以大幅提升程序性能
    //而volatile的覆盖范围仅仅变量级别的. 因此它的同步代价很低.
    //volatile的语义, 其实是告诉处理器, 不要将我放入工作内存, 请直接在主存操作我.(工作内存详见java内存模型)
    //因此, 当多核或多线程在访问该变量时, 都将直接操作主存, 这从本质上, 做到了变量共享

    public static class Singleton07{
        private volatile static Singleton07 instance = null;
        private Singleton07(){}
        public static Singleton07 getInstance(){
            if (instance == null){
                synchronized (Singleton07.class){
                    if (instance == null){
                        Singleton07 t = new Singleton07();
                        t= instance;
                    }
                }
            }
            return instance;
        }
    }

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance() == Singleton.getInstance());
        System.out.println(Singleton02.getInstance() == Singleton02.getInstance());
        System.out.println(Singleton03.getInstance() == Singleton03.getInstance());
        System.out.println(Singleton04.getInstance() == Singleton04.getInstance());
        System.out.println(Singleton05.getInstance() == Singleton05.getInstance());
        System.out.println(Singleton06.INSTANCE == Singleton06.INSTANCE);
        System.out.println(Singleton07.getInstance() == Singleton07.getInstance());
    }



}
