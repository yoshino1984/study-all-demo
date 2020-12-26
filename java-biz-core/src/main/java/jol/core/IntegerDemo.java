package jol.core;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.util.ObjectUtils;

public class IntegerDemo {

    public static void main(String[] args) {
        Integer integer = 1;
        System.out.println(ClassLayout.parseInstance(integer));
    }
}
