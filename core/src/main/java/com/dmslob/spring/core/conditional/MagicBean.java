package com.dmslob.spring.core.conditional;

import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MagicBean {

    public String getName() {
        return "MagicBean";
    }
}
