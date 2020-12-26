package other.generics;

import lombok.Data;

/**
 * @author wangxin
 * 2020/4/25 14:57
 * @since
 **/
@Data
class Child1 extends Parent {
    int i = 1;
    public void setValue(String value) {
        System.out.println("Child1.setValue called");
        super.setValue(value);
    }
}
