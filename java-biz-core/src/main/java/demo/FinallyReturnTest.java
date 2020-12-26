package demo;

import java.util.Date;

public class FinallyReturnTest {

    private void test1(int i) {
        try {
            System.out.println(1);
            outer(i);
            System.out.println(2);
        } catch (Exception e) {
            System.out.println(3);
        } finally {
            System.out.println(4);
            return;
        }
    }

    private void outer(int i) {
        System.out.println("outer1");
        if (i < 2) {
            System.out.println("outer2");
            return;
        }
        System.out.println("outer3");
    }

    public static void main(String[] args) {
        new FinallyReturnTest().test1(1);
    }
}
