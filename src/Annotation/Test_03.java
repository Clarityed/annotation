package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 *
 * @author: clarity
 * @date: 2022年09月19日 11:28
 */

@MyAnnotation2(MyId = 1, habit = {"编程", "游戏", "漫画", "动漫"})
public class Test_03 {

    @MyAnnotation3("结束注解学习")
    public void test_1() {

    }

}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    // 注解的参数：参数类型 + ();
    // 有默认值可以不用赋值，但是没有默认值一定要在使用注解的时候给它一个值
    String myName() default "clarity";
    int MyId();
    int MyAge() default 23;
    String[] habit();
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3 {
    String value();
}