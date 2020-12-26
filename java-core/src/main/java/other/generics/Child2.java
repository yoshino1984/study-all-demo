package other.generics;

/**
 * @author wangxin
 * 2020/4/25 14:59
 * @since
 **/
class Child2 extends Parent<String> {
    @Override
    public void setValue(String value) {
        System.out.println("Child2.setValue called");
        super.setValue(value);
    }

}
