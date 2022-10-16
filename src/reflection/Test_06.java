package reflection;

/**
 * 什么时候会发生类的初始化
 *
 * @author: clarity
 * @date: 2022年10月16日 10:39
 */
public class Test_06 {

    static {
        System.out.println("Main 方法被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // 主动引用，发生类的初始化
        // 当虚拟机启动，先初始化 Main 方法所在的类
        // new 一个类的对象
        // 要注释掉代码，因为如果已经被初始化，加载重复的类就不需要初始化了
        // Son son = new Son();
        // 反射调用
        // Class.forName("reflection.Son");
        // 被动引用，不会发生类的初始化
        // 调用静态变量，子类调用父类的静态变量
        // System.out.println(Son.b);
        // 静态常量 final
        // System.out.println(Son.M);
        // 数组
        // Son[] sons = new Son[2];
    }

}

class Father {
    static int a = 1;

    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father {
    static {
        System.out.println("子类被加载");
        b = 300;
    }
    static int b = 100;
    static final int M = 1;
}