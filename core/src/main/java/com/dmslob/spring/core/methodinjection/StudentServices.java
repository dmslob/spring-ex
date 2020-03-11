package com.dmslob.spring.core.methodinjection;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class StudentServices {

    @Lookup
    public SchoolNotification getNotification() {
        return null;
    }
}
