package bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import static net.bytebuddy.matcher.ElementMatchers.named;

/**
 * @author wangxin
 * 2020/12/16 上午8:38
 * @since
 **/
public class ByteBuddyDemo1 {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String classPath = "bytebuddy.HelloWorld";
        DynamicType.Unloaded<?> dynamicType = new ByteBuddy()
            .subclass(Object.class)
            .name(classPath)
            .method(ElementMatchers.named("toString"))
            .intercept(FixedValue.value("Hello World!"))
            .defineMethod("main", void.class, Modifier.PUBLIC + Modifier.STATIC)
            .withParameter(String[].class, "args")
            .intercept(MethodDelegation.to(H1.class))
            .make();

        String helloWorld = dynamicType
            .load(ByteBuddyDemo1.class.getClassLoader())
            .getLoaded()
            .getDeclaredConstructor()
            .newInstance()
            .toString();

        Class<?> klazz = dynamicType.load(ByteBuddyDemo1.class.getClassLoader())
            .getLoaded();
        klazz.getMethod("main", String[].class).invoke(klazz.getDeclaredConstructor().newInstance(), (Object) new String[]{"hello Word!"});
        outputClazz(dynamicType.getBytes(), classPath, ".class");
    }

    /**
     * 输出字节码到文件目录下
     */
    private static void outputClazz(byte[] bytes, String classPath, String suffix) {
        classPath = classPath.replaceAll("\\.", "/");
        FileOutputStream out = null;
        try {
            String pathName = ByteBuddyDemo1.class.getResource("/").getPath() + classPath + suffix;
            out = new FileOutputStream(new File(pathName));
            System.out.println("类输出路径：" + pathName);
            out.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != out) try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
