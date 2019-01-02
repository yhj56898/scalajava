package com.hj.spring.p1;

import org.springframework.stereotype.Component;

/**
 * @author hejin-Yu
 * @desc
 */

@Component
public class BeanThree {
    public BeanThree() {
        System.out.println("调用无参构造器");
    }
    public BeanThree(String name) {
        System.out.println("调用了有参构造器"+name);
    }
}
