package Annotation;

import java.lang.annotation.*;

/**
 * 测试元注解
 *
 * @author: clarity
 * @date: 2022年09月16日 11:40
 */
@MyAnnotation
public class Test_02 {

}


// 自定义一个注解
// 一个类只能有一个公共修饰 public
@Target({ElementType.METHOD, ElementType.TYPE})
// 运行时也有效
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface MyAnnotation {

}