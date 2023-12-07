package annotest.cusdefhib;

import java.lang.reflect.Method;

/**
 * 解析注解
 */
public class ParseHibernateAnnotation {

    public static void main(String[] args) {
        // 1. 首先获取 Hero.class 类对象
        Class<Hero> heroClass = Hero.class;
        // 2. 判断本类是否进行了 MyEntity 注解
        MyEntity myEntity = heroClass.getAnnotation(MyEntity.class);
        if (myEntity == null) {
            System.out.println("Hero 类不是实体类");
        } else {
            System.out.println("Hero 类是实体类");
            // 3. 获取注解 MyTable
            MyTable myTable = heroClass.getAnnotation(MyTable.class);
            String tableName = myTable.name();
            System.out.println("其他对应的表名为：" + tableName);
            // 4. 遍历所有的方法，如果某个方法有 MyId 注解，那么就记录为主键方法 primaryKeyMethod
            Method[] methods = heroClass.getMethods();
            Method primaryKeyMethod = null;
            for (Method method : methods) {
                MyId myId = method.getAnnotation(MyId.class);
                if (myId != null) {
                    primaryKeyMethod = method;
                    break;
                }
            }
            // 5. 把主键方法的自增长策略注解 MyGeneratedValue 和对应的字段注解 MyColumn 取出来，并打印
            if (primaryKeyMethod != null) {
                System.out.println("找到主键：" +  method2attribute(primaryKeyMethod.getName()));
                MyGeneratedValue myGeneratedValue = primaryKeyMethod.getAnnotation(MyGeneratedValue.class);
                System.out.println("其自增长策略为：" + myGeneratedValue.strategy());
                MyColumn myColumn = primaryKeyMethod.getAnnotation(MyColumn.class);
                System.out.println( "其对应数据库中的字段为：" + myColumn.value());
            }
            for (Method method : methods) {
                if (method == primaryKeyMethod) {
                    continue;
                }
                MyColumn myColumn = method.getAnnotation(MyColumn.class);
                if (myColumn == null) {
                    continue;
                }
                System.out.format("属性：%s\t对应的数据库字段是:%s%n", method2attribute(method.getName()),myColumn.value());
            }
        }
    }

    private static String method2attribute(String methodName) {
        String result = methodName;
        result = result.replaceFirst("get", "");
        result = result.replaceFirst("is", "");
        if (result.length() <= 1) {
            return result.toLowerCase();
        } else {
            return result.substring(0, 1).toLowerCase() + result.substring(1);
        }
    }
}
