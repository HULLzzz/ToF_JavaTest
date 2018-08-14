import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:
 * @Description: 单例模式
 * @params:http://www.cnblogs.com/yangyquin/p/4907388.html
 * @Data: Created in  14:18 2018/5/23
 * @Modified By:
 */

//懒汉式单例
public class Singleton {
    private Singleton(){}    //私有的默认构造方法，因此无法使用构造方法实例化
    private static Singleton single = null;
    public static Singleton getInstance(){      //静态工厂法
        if (single == null) {
            single = new Singleton();
        }
        return  single;
    }


    public static void main(String[] args) {
        Singleton02 single = new Singleton02().getInstance(null);
        System.out.println(single.about());
    }




}

//饿汉式 线程安全
class Singleton01{
    private   Singleton01(){}
    private static final Singleton01 SINGLETON_01 = new Singleton01();
    public static Singleton01 getInstance(){
        return SINGLETON_01;
    }
}

//登记式
class Singleton02{
    private static Map<String , Singleton02> map = new HashMap<String,Singleton02>();
    static {
        Singleton02 single = new Singleton02();
        map.put(single.getClass().getName(),single);
    }
    protected Singleton02(){}
    public static Singleton02 getInstance(String name){
        if(name==null||name==""){
            name = Singleton02.class.getName();
            System.out.println("name-->"+name);
        }
        if (map.get(name) == null) {
            try {
                map.put(name,(Singleton02)Class.forName(name).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return map.get(name);
    }
    public String about(){
        return "hello";
    }
}

