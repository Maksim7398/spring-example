package com.example.springexample1;

import com.example.springexample1.config.AppConfig;
import com.example.springexample1.config.AppToFileConfig;
import com.example.springexample1.model.Contact;

import com.example.springexample1.model.ContactCMD;
import com.example.springexample1.model.ContactFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationContext context2 = new AnnotationConfigApplicationContext(AppToFileConfig.class);
        Scanner scanner = new Scanner(System.in);
        List<Contact> contacts = new ArrayList<>();
        System.out.println("To add a contact, enter\n" +
                "Full name, phone number, email\n" +
                "Separated by commas");
        System.out.println("finish work, click to 'q' ");

        while (true) {
            String[] contactIn = scanner.nextLine().split(",");

            if (contactIn.length >=3){
                if (context.getBean(ContactCMD.class).addContact(contactIn[0],contactIn[1],contactIn[2]) == true){
                    contacts.add(new Contact(contactIn[0],contactIn[1],contactIn[2]));
                }else {
                    System.out.println("Contact not added");
                }


            }
            else if (contactIn[0].equals("q")){
                break;
            }

            switch (contactIn[0]){
                case ("seeContacts") :  contacts.forEach(System.out::println); continue;
                case ("add contacts from file") :
                   contacts.addAll(context2.getBean(ContactFile.class).addContactFromFile());
                    System.out.println("Contacts  from  the file have been loaded");
                case ("") :
                    System.out.println("you entered an empty value");
            }







        }



    }
}
