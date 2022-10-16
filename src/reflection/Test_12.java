package reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * 获取注解信息
 *
 * @author: clarity
 * @date: 2022年10月16日 16:05
 */
public class Test_12 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        // 通过反射获得注解
        Class c1 = Class.forName("reflection.Application");
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        // 获得注解的 value 值
        TableClarity tableClarity = (TableClarity) c1.getAnnotation(TableClarity.class);
        String value = tableClarity.value();
        System.out.println(value);

        // 通过反射获得属性的注解值
        Field name = c1.getDeclaredField("name");
        FiledClarity filedClarity = name.getAnnotation(FiledClarity.class);
        System.out.println(filedClarity.columnName());
        System.out.println(filedClarity.type());
        System.out.println(filedClarity.length());

        Field code = c1.getDeclaredField("code");
        FiledClarity filedClarity2 = code.getAnnotation(FiledClarity.class);
        System.out.println(filedClarity2.columnName());
        System.out.println(filedClarity2.type());
        System.out.println(filedClarity2.length());

        Field time = c1.getDeclaredField("time");
        FiledClarity filedClarity3 = time.getAnnotation(FiledClarity.class);
        System.out.println(filedClarity3.columnName());
        System.out.println(filedClarity3.type());
        System.out.println(filedClarity3.length());
    }
}

// 类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableClarity {
    String value();
}

// 属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FiledClarity {
    String columnName();
    String type();
    int length();
}

@TableClarity("db_application")
class Application {
    @FiledClarity(columnName = "a_name", type = "varchar", length = 10)
    private String name;
    @FiledClarity(columnName = "a_code", type = "varchar", length = 10)
    private String code;
    @FiledClarity(columnName = "a_time", type = "int", length = 5)
    private int time;

    public Application(String name, String code, int time) {
        this.name = name;
        this.code = code;
        this.time = time;
    }

    public Application() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Application{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", time=" + time +
                '}';
    }
}