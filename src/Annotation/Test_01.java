package Annotation;

/**
 * 什么是注解？
 *
 * @author: clarity
 * @date: 2022年09月16日 10:57
 */
// 所以的类不写继承什么类，默认继承 Object 静态类
@SuppressWarnings("all")
public class Test_01 extends Object {

    // 该注解的意思，表示的是重写，还起到了规范和约束的作用
    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public static void test_1() {
        System.out.println("这是一个已经过时的方法！");
    }


    public static void test_2() {
        System.out.println("all");
    }


    public static void main(String[] args) {
        test_1();
    }
}
