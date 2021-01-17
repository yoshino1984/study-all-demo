package com.cncounter.opcode;

public class TestReplaceAll {
    public static void main(String[] args) {
        String className = TestReplaceAll.class.getName();
        // ___________________________________
        System.out.println(className.replaceAll(".", "_"));
    }
}
