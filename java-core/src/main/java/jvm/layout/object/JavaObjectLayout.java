package jvm.layout.object;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

public class JavaObjectLayout {

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(Integer.valueOf(1)));
//        System.out.println(ClassLayout.parseClass(JavaObjectModel.class).toPrintable());
        JavaObjectModel javaObjectModel = new JavaObjectModel();
        System.out.println(ClassLayout.parseInstance(javaObjectModel).toPrintable());
//        System.out.println(GraphLayout.parseInstance(javaObjectModel).toPrintable());
        synchronized (javaObjectModel) {
            System.out.println(ClassLayout.parseInstance(javaObjectModel).toPrintable());
//        System.out.println(GraphLayout.parseInstance(javaObjectModel).toPrintable());
        }
//        System.out.println(GraphLayout.parseInstance(javaObjectModel).toPrintable());
        System.out.println(GraphLayout.parseInstance(javaObjectModel).totalSize());
    }
}
