package annotest;

import java.lang.annotation.*;

/**
 * 自定义注解（链接数据库的参数）
 */
@Target({ElementType.METHOD, ElementType.TYPE}) // TYPE 表示是用在类或者接口上，METHOD 是方法上
/*
ElementType.TYPE：能修饰类、接口或枚举类型
ElementType.FIELD：能修饰成员变量
ElementType.METHOD：能修饰方法
ElementType.PARAMETER：能修饰参数
ElementType.CONSTRUCTOR：能修饰构造器
ElementType.LOCAL_VARIABLE：能修饰局部变量
ElementType.ANNOTATION_TYPE：能修饰注解
ElementType.PACKAGE：能修饰包
*/
@Retention(RetentionPolicy.RUNTIME)
/*
RetentionPolicy.SOURCE： 注解只在源代码中存在，编译成class之后，就没了。@Override 就是这种注解。
RetentionPolicy.CLASS： 注解在java文件编程成.class文件后，依然存在，但是运行起来后就没了。@Retention的默认值，即当没有显式指定@Retention的时候，就会是这种类型。
RetentionPolicy.RUNTIME： 注解在运行起来之后依然存在，程序可以通过反射获取这些信息，自定义注解@JDBCConfig 就是这样。
*/
@Inherited
/*
@Inherited 表示该注解具有继承性。如例，设计一个DBUtil的子类，其getConnection2方法，可以获取到父类DBUtil上的注解信息。
*/
@Documented
/*
@Documented 如图所示， 在用javadoc命令生成API文档后，DBUtil的文档里会出现该注解说明。
*/
public @interface JDBCConfig {

    String ip();
    int port() default 3306;
    String database();
    String enCoding();
    String username();
    String password();
}
