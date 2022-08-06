package com.cs320.milestones;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ContactService {
    // initialize data structure
    Map<String, Contact> contactMap = new HashMap<>();

    // add contact with generated unique ID
    public void addContact(Contact contact) {
        if (contactMap.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }
        contactMap.put(contact.getContactID(), contact);
    }
    // delete contact from list given contactID
    public void deleteContact(String contactID) {
        contactMap.remove(contactID);
    }
    // update fields
    public void updateFields(Contact contact) {
        if (!contactMap.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact ID doesn't exists.");
        }
        contactMap.replace(contact.getContactID(), contact);
    }
}
