package com.example.example.model;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ContactCMD{
    private final Contact contact;
    private final List<String> contactList = new ArrayList<String>();
    private final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public ContactCMD(Contact contact) {
        this.contact = contact;
    }

    private boolean addContact(String fullname, String phoneNumber, String email) {
        Matcher m = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        if (m.find()) {
            contact.addContact(fullname, phoneNumber, email);
            System.out.println("Contact saved successfully!");
            return true;
        } else {
            System.out.println("email is not valid");

            return false;
        }
    }
    public String addNewContact(String[] contactIn) {
        if (contactIn.length >= 3 && addContact(contactIn[0], contactIn[1], contactIn[2])) {
            contactList.add(contact.toString());
            return contact.toString();
        }
        return "Contact not added";
    }

    public List<String> getContactList() {
        return contactList;
    }
}
