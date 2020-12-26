package code.remove;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Inherited
@interface RequestField {

    int order() default 0;
    int maxLength() default 0;
    boolean required() default false;
}
