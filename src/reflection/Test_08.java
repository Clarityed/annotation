package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 获取类的运行时结构
 *
 * @author: clarity
 * @date: 2022年10月16日 11:49
 */
public class Test_08 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("reflection.User");

        // 1. 获得类的名字
        System.out.println(c1.getName()); // 包名 + 类名
        System.out.println(c1.getSimpleName()); // 类名

        System.out.println("--------------------------");

        // 2. 获得类的属性
        Field[] fields = c1.getFields(); // 获取公共属性
        for (Field field : fields) {
            System.out.println("公共属性" + field);
        }
        fields = c1.getDeclaredFields(); // 获取所有属性
        for (Field field : fields) {
            System.out.println("所有属性" + field);
        }
        // 获取指定属性
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        System.out.println("--------------------------");

        // 3. 获得类的方法
        Method[] methods = c1.getMethods(); // 获取公共方法
        for (Method method : methods) {
            System.out.println("公共方法" + method);
        }
        methods = c1.getDeclaredMethods(); // 获取所有方法
        for (Method method : methods) {
            System.out.println("所有方法" + method);
        }
        // 指定方法
        // 与重载相关，方法名相同，但是参数类型和顺序不同，这里就是依据这个进行判断
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);

        System.out.println("--------------------------");

        // 4. 获得构造器的方法
        Constructor[] constructors = c1.getConstructors(); // 获得公共构造器
        for (Constructor constructor : constructors) {
            System.out.println("公共构造器" + constructor);
        }
        constructors = c1.getDeclaredConstructors(); // 获得所有构造器
        for (Constructor constructor : constructors) {
            System.out.println("所有构造器" + constructor);
        }
        // 指定构造器
        Constructor constructor = c1.getConstructor();
        Constructor constructor1 = c1.getConstructor(String.class, int.class, int.class);
        System.out.println(constructor);
        System.out.println(constructor1);
    }

}
