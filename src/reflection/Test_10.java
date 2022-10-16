package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 普通方式与反射的性能对比
 *
 * @author: clarity
 * @date: 2022年10月16日 15:16
 */
public class Test_10 {

    public static void commonMethod() {
        User user = new User();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("commonMethod " + (endTime - startTime) + "ms");
    }

    public static void reflectMethod() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c1 = Class.forName("reflection.User");
        Method getName = c1.getDeclaredMethod("getName", null);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user, null);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("reflectMethod " + (endTime - startTime) + "ms");
    }

    public static void notAccessReflectMethod() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c1 = Class.forName("reflection.User");
        Method getName = c1.getDeclaredMethod("getName", null);
        getName.setAccessible(true);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user, null);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("notAccessReflectMethod " + (endTime - startTime) + "ms");
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        commonMethod();
        reflectMethod();
        notAccessReflectMethod();
    }

}
