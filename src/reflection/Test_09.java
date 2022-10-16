package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射动态的创建对象
 *
 * @author: clarity
 * @date: 2022年10月16日 14:48
 */
public class Test_09 {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 获得 Class 对象
        Class c1 = Class.forName("reflection.User");

        // 1. 通过 Class 对象使用构造器创建一个对象，这里必须注意该类必须有无参构造
        User user1 = (User) c1.newInstance(); // 本质调用一个无参构造
        System.out.println(user1);

        // 2. 通过获取指定构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class, int.class);
        User user2 = (User) constructor.newInstance("clarity", 0001, 22, 1);
        System.out.println(user2);

        // 3. 通过反射调用普通方法
        User user3 = (User) c1.newInstance();
        // 通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        // invoke 激活的意思
        // （对象，“方法的值”）
        setName.invoke(user3, "clarity3");
        System.out.println(user3.getName());

        // 通过反射操作属性
        User user4 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        // Class reflection.Test_09 can not access a member of class reflection.User with modifiers "private"
        // 报错，发现没有权限访问
        // 不能直接操作私有属性，我们需要关闭程序的安全检测，属性或者方法的 setAccessible(true)
        name.setAccessible(true);
        name.set(user4, "clarity4");
        System.out.println(user4.getName());
    }

}
