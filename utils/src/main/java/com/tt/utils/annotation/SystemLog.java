package com.tt.utils.annotation;


import java.lang.annotation.*;

@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {
    String type() default "";
    String value() default "";
}
