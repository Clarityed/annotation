package reflection;

/**
 * 类加载内存分析
 *
 * @author: clarity
 * @date: 2022年10月14日 17:15
 */
public class Test_05 {

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.m);
    }
    /*
    * 1. 加载到内存，产生一个类对应的 class 对象
    * 2. 链接，链接结束后 m = 0
    * 3. 初始化
    *       <clinit>() {
    *           System.out.println("A 类静态代码块初始化");
    *           m = 300;
    *           m = 100;
    *       }
    * */

}

class A {
    static {
        System.out.println("A 类静态代码块初始化");
        m = 300;
    }

    static int m = 100;

    public A() {
        System.out.println("A 类无参构造初始化");
    }
}