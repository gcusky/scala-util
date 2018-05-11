package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by lizhy on 2018/4/17.
 */
public class Demo {
    /**
     * 打印类的信息，包括类的成员函数、成员变量
     * @param obj 对象
     */
    public static void printClassMessage(Object obj) {
        // 要获取类的信息，首先要获取类的类类型
        Class c = obj.getClass();
        // 获取类的全名
        String fullName = c.getName();
        /**
         * Method类：方法对象
         * 一个成员方法就是一个Method对象
         * getMethods()获取的是所有的public的函数，包括父类继承而来的
         * getDeclaredMethods()获取的是所有该类自己声明的方法，不问访问权限
         */
        Method[] ms = c.getMethods(); // c.getDeclaredMethods();
        for (int i = 0; i < ms.length; i++) {
            // 得到方法的返回类型
            Class returnType = ms[i].getReturnType();
            // 得到方法的名称
            String name = ms[i].getName();
            // 获取参数类型
            Class[] paramTypes = ms[i].getParameterTypes();
        }

        /**
         * 成员变量也是对象，Field封装了关于成员变量的操作
         * getFields()获取的是所有的public的成员变量
         * getDeclaredMethods()获取的是所有该类自己声明的成员变量
         */
        Field[] fs = c.getDeclaredFields(); // c.getFields();
        for (int i = 0; i < fs.length; i++) {
            // 得到成员变量的类型
            Class fieldType = fs[i].getType();
            String typeName = fieldType.getName();
            // 得到成员变量的名称
            String fieldName = fs[i].getName();
        }
    }

    /**
     * 打印对象的构造函数的信息
     * @param obj
     */
    public static void printConMessage(Object obj) {
        Class c = obj.getClass();
        /**
         * 构造函数也是对象
         * java.lang.Constructor中封装了构造函数的信息
         */
        Constructor[] cs = c.getDeclaredConstructors();
        for (Constructor constructor : cs) {
            constructor.getName();
            Class[] paramType = constructor.getParameterTypes();
        }
    }
}
