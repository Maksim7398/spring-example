package com.example.config;

import com.example.model.ContactCMD;
import org.springframework.context.annotation.*;
import java.lang.reflect.InvocationTargetException;
@Configuration
@ComponentScan("com.example")
public class AppConfig {
    @Bean
    public ContactCMD contactCMD() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return new ContactCMD();
    }
}
