package reflection;

/**
 * 所以类型的 Class 对象
 *
 * @author: clarity
 * @date: 2022年10月14日 16:45
 */
public class Test_04 {

    public static void main(String[] args) {
        Class c1 = Object.class; // 类
        Class c2 = Comparable.class; // 接口
        Class c3 = String.class; // 字符串
        Class c4 = int.class; // 整型
        Class c5 = String[].class; // 一维数组
        Class c6 = int[][].class; // 二维数组
        Class c7 = Override.class; // 注解
        Class c8 = Enum.class; // 枚举
        Class c9 = Integer.class; // 基本数据类型
        Class c10 = void.class; // void
        Class c11 = Class.class; // class

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);
        System.out.println(c10);
        System.out.println(c11);

        // 同一个元素，在同一个类里，维度也相同，那么它们只有一个类对象
        int[] i1 = new int[10];
        int[] i2 = new int[100];
        System.out.println(i1.getClass().hashCode());
        System.out.println(i2.getClass().hashCode());
    }

}
