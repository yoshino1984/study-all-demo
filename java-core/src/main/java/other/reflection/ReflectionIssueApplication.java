package other.reflection;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author wangxin
 * 2020/4/25 14:34
 * @since
 **/
@Slf4j
public class ReflectionIssueApplication {
    private void age(int age) {
        log.info("int age = {}", age);
    }


    private void age(Integer age) {
        log.info("Integer age = {}", age);
    }

    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        getClass().getDeclaredMethod("age", Integer.TYPE).invoke(this, Integer.valueOf("36"));
        getClass().getDeclaredMethod("age", Integer.class).invoke(this, 36);

    }
}
