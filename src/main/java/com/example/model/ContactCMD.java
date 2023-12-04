package com.example.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ContactCMD {
    private final List<Contact> contactList = new ArrayList<>();
    private final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public void addContact(String[] contactIn) {
        if (contactIn.length >= 3) {
            Matcher m = VALID_EMAIL_ADDRESS_REGEX.matcher(contactIn[2]);
            if (m.find()) {
                Contact contact = new Contact(contactIn[0], contactIn[1], contactIn[2]);
                contactList.add(contact);
                System.out.println("Contact saved successfully!");
            } else {
                System.out.println("email is not valid");
            }
        }
    }
    public List<Contact> getContactList() {
        return contactList;
    }
}
