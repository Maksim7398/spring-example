package com.example.config;

import com.example.model.ContactFile;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import java.util.Objects;
@Configuration
public class AppToFileConfig {
    @Bean
    public ContactFile contactFile(){
        return new ContactFile();
    }
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){// бин для того чтобы получать данные из ресурсов
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        yamlPropertiesFactoryBean.setResources(new ClassPathResource("application-file.yaml"));
        configurer.setProperties(Objects.requireNonNull(yamlPropertiesFactoryBean.getObject()));

        return configurer;
    }
}
