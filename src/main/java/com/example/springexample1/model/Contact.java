package com.example.springexample1.model;

import org.springframework.stereotype.Component;

import java.text.MessageFormat;
@Component
public class Contact implements ViewContact {

    private String fullName;

    private String phoneNumber;

    private String email;

    public Contact(){
        System.out.println("Contact init");
    }

    public Contact(String fullName, String phoneNumber, String email) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    @Override
    public void addContact(String fullname,String phoneNumber,String email){
      setFullName(fullname);
      setPhoneNumber(phoneNumber);
      setEmail(email);
      System.out.println(MessageFormat.format("{0} | {1} | {2}",fullName,phoneNumber,email));
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return fullName + '|' + phoneNumber + '|' + email;
    }


}
