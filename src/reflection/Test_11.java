package reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 获取泛型信息
 *
 * @author: clarity
 * @date: 2022年10月16日 15:43
 */
public class Test_11 {

    public void getGeneric1(Map<String, User> userMap, List<User> userList) {
        System.out.println("getGeneric1");
    }

    public Map<String, User> getGeneric2() {
        System.out.println("getGeneric2");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Test_11.class.getDeclaredMethod("getGeneric1", Map.class, List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            if (genericParameterType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
        }
        method = Test_11.class.getDeclaredMethod("getGeneric2", null);
        Type genericReturnType = method.getGenericReturnType();
        if (genericReturnType instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
        }
    }

}
