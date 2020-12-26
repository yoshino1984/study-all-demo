package other.generics;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangxin
 * 2020/4/25 14:57
 * @since
 **/
public class GenericsApplication {

    @Test
    public void testChild1() {
        Child1 child1 = new Child1();
        Arrays.stream(child1.getClass().getMethods())
//        Arrays.stream(child1.getClass().getDeclaredMethods())
            .filter(method -> method.getName().equals("setValue"))
            .forEach(method -> {
                try {
                    method.invoke(child1, "test");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        System.out.println(child1.toString());
    }

    @Test
    public void test() {
        Child1 child1 = new Child1();
        List<Child1> list = Lists.newArrayList(child1, child1);
        List<Child1> list2 = new ArrayList<>(list.subList(0, 1));
        child1.setI(2);
        System.out.println(list2.get(0).i);
        Child1[] childs = list.toArray(new Child1[0]);
        System.out.println();
    }

    @Test
    public void testChild2() {
        Child2 child2 = new Child2();
        Arrays.stream(child2.getClass().getMethods())
//        Arrays.stream(child1.getClass().getDeclaredMethods())
            .filter(method -> method.getName().equals("setValue") && !method.isBridge())
            .forEach(method -> {
                try {
                    System.out.println(method.toGenericString());
                    method.invoke(child2, "test");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        System.out.println(child2.toString());
    }
}
