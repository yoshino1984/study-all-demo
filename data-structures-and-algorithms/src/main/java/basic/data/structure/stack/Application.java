package basic.data.structure.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * @author wangxin
 * 2020/5/2 16:44
 * @since
 **/
public class Application {
    public static void main(String[] args) {
        ArrayStack<String> arrayStack = new ArrayStack<>(3);
        IntStream.rangeClosed(1, 4)
            .forEach(i -> System.out.println(arrayStack.push(String.valueOf(i))));
        IntStream.rangeClosed(1, 4)
            .forEach(i -> System.out.println(arrayStack.pop()));

        String s = "{}[]";


    }
}
