package com.example.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ContactFile {
    @Value("${contact.file.location}")
    private String pathFile;

    public List<Contact> addContactFromFile() {
        String everything = "";
        List<Contact> contactList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
            String[] split = everything.split("\n");
            for (int i = 0; i < split.length; i++) {
                String[] cont = split[i].split(",");
                contactList.add(new Contact(cont[0], cont[1], cont[2]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contactList;
    }
}
