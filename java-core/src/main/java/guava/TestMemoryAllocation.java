package guava;

/**
 * @author wangxin
 * 2020/10/14 09:01
 * @since
 **/
public class TestMemoryAllocation {
    private static final int MB1 = 1024 *  1024;

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * MB1];
        allocation2 = new byte[2 * MB1];
        allocation3 = new byte[2 * MB1];
        allocation4 = new byte[4 * MB1];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}