package com.dmslob.spring.core.advanced.beans;

import com.dmslob.spring.core.advanced.annotations.InjectRandomInt;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * Simple bean to illustrate the usage of custom {@link InjectRandomInt} annotation
 */
@Component
@Scope("prototype")
public class Player {

    public static final int MIN = 3;
    public static final int MAX = 7;


    @InjectRandomInt(min = MIN, max = MAX)
    private int stamina;

    public int getStamina() {
        return stamina;
    }

    @PreDestroy
    public void destroy() {
        System.out.println(this.toString() + ": I'm out of here");
    }
}
