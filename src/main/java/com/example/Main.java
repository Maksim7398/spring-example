package com.example.example;
import com.example.example.config.AppConfig;
import com.example.example.config.AppToFileConfig;

import com.example.example.model.ContactCMD;
import com.example.example.model.ContactFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationContext context2 = new AnnotationConfigApplicationContext(AppToFileConfig.class);
        Scanner scanner = new Scanner(System.in);
        System.out.println("To add a contact, enter\n" +
                "Full name, phone number, email\n" +
                "Separated by commas");
        System.out.println("finish work, click to 'q' ");
        while (true) {
            String[] contactIn = scanner.nextLine().split(",");
            context.getBean(ContactCMD.class).addNewContact(contactIn);
            if (contactIn[0].equals("q")) {
                break;
            }
            switch (contactIn[0]) {
                case ("seeContacts"):
                    context.getBean(ContactCMD.class).getContactList().forEach(System.out::println);
                    continue;
                case ("add contacts from file and view"):
                    context2.getBean(ContactFile.class).addContactFromFile().forEach(System.out::println);
                case (""):
                    System.out.println("you entered an empty value");
            }
        }
    }
}
