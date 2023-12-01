package com.example.example.config;

import com.example.example.model.Contact;
import com.example.example.model.ContactCMD;
import org.springframework.context.annotation.*;
import java.lang.reflect.InvocationTargetException;
@Configuration
@ComponentScan("com.example")
public class AppConfig {
    @Bean
    public Contact contact() {
        return new Contact();
    }
    @Bean
    public ContactCMD contactCMD() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return new ContactCMD(Contact.class.getDeclaredConstructor().newInstance());
    }


}
