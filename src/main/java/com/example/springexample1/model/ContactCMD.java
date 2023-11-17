package com.example.springexample1.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ContactCMD {

    private final   Contact contact;

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public ContactCMD(Contact contact) {
        this.contact = contact;
    }


    public boolean addContact(String fullname,String phoneNumber,String email){
        Matcher m = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        if (m.find()){
            contact.addContact(fullname,phoneNumber,email);
            System.out.println("Contact saved successfully!");
            return true;
        }else {
            System.out.println("email is not valid");
            return false;
        }
    }
}
