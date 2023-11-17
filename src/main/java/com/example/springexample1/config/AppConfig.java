package com.example.springexample1.config;

import com.example.springexample1.model.Contact;
import com.example.springexample1.model.ContactCMD;
import com.example.springexample1.model.ContactFile;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

@Configuration
public class AppConfig {
    @Bean
    public ContactCMD contact() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return new ContactCMD(Contact.class.getDeclaredConstructor().newInstance());
    }





}
