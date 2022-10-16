package reflection;

/**
 * 获取类的加载器
 *
 * @author: clarity
 * @date: 2022年10月16日 11:13
 */
public class Test_07 {

    public static void main(String[] args) throws ClassNotFoundException {
        // 获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        // 获取系统类加载器的父类加载器 -> 扩展类加载器
        ClassLoader systemClassLoaderParent = systemClassLoader.getParent();
        System.out.println(systemClassLoaderParent);
        // 获取扩展类加载器的父类加载器 -> 引导类加载器（根加载器 C / C++ 语言编写，Java 层面获取不到）
        ClassLoader systemClassLoaderParentParent = systemClassLoaderParent.getParent();
        System.out.println(systemClassLoaderParentParent);
        // 测试当前类是哪个加载器加载的
        ClassLoader classLoader = Class.forName("reflection.Test_07").getClassLoader();
        System.out.println(classLoader);
        // 如何获取系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
        /*
        * E:\JDK\jre\lib\charsets.jar;
        * E:\JDK\jre\lib\deploy.jar;
        * E:\JDK\jre\lib\ext\access-bridge.jar;
        * E:\JDK\jre\lib\ext\cldrdata.jar;
        * E:\JDK\jre\lib\ext\dnsns.jar;
        * E:\JDK\jre\lib\ext\jaccess.jar;
        * E:\JDK\jre\lib\ext\jfxrt.jar;
        * E:\JDK\jre\lib\ext\localedata.jar;
        * E:\JDK\jre\lib\ext\nashorn.jar;
        * E:\JDK\jre\lib\ext\sunec.jar;
        * E:\JDK\jre\lib\ext\sunjce_provider.jar;
        * E:\JDK\jre\lib\ext\sunmscapi.jar;
        * E:\JDK\jre\lib\ext\sunpkcs11.jar;
        * E:\JDK\jre\lib\ext\zipfs.jar;
        * E:\JDK\jre\lib\javaws.jar;
        * E:\JDK\jre\lib\jce.jar;
        * E:\JDK\jre\lib\jfr.jar;
        * E:\JDK\jre\lib\jfxswt.jar;
        * E:\JDK\jre\lib\jsse.jar;
        * E:\JDK\jre\lib\management-agent.jar;
        * E:\JDK\jre\lib\plugin.jar;
        * E:\JDK\jre\lib\resources.jar;
        * E:\JDK\jre\lib\rt.jar; 核心包
        * E:\Code\java\annotation\out\production\annotation; 就是本包代码
        * E:\IntelliJ IDEA 2021.2.3\IntelliJ IDEA 2021.2.3\lib\idea_rt.jar
         */
        // 补充：双亲委派机制，意思是如果你编写的一个包与 Java JDK 自带的包名那么它会去使用自带的包，而表示你的包。
    }

}
