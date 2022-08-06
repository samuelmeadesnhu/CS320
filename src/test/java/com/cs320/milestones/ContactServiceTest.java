package com.cs320.milestones;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    void instantiate() {
        contactService = new ContactService();
    }

    @Test
    // Add new contact to data structure
    void testAddContact() {
        Contact testContact = new Contact("1231231231", "Timmy", "Tester", "5554443333", "55 Testaroodle Ln");
        contactService.addContact(testContact);
        assertEquals(1, contactService.contactMap.size());
    }

    @Test
    // Ensure duplicate contactID throws error
    void testDuplicateContactID() {
        Contact testContact = new Contact("1231231231", "Timmy", "Tester", "5554443333", "55 Testaroodle Ln");
        contactService.addContact(testContact);
        assertEquals(1, contactService.contactMap.size());
        Contact testContact2 = new Contact("1231231231", "Justin", "Smith", "5554443333", "55 Testaroodle Ln");
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.addContact(testContact2));
    }

    @Test
    // Check that contact is added then deleted
    void testDeleteContact() {
        Contact testContact = new Contact("1231231231", "Timmy", "Tester", "5554443333", "55 Testaroodle Ln");
        contactService.addContact(testContact);
        assertEquals(1, contactService.contactMap.size());
        contactService.deleteContact(testContact.getContactID());
        assertEquals(0, contactService.contactMap.size());
    }

    @Test
    // Ensure invalid contacts aren't deleted
    void testDeleteContactInvalidID() {
        Contact testContact = new Contact("1231231231", "Timmy", "Tester", "5554443333", "55 Testaroodle Ln");
        contactService.addContact(testContact);
        assertEquals(1, contactService.contactMap.size());
        contactService.deleteContact("0000000000");
        assertEquals(1, contactService.contactMap.size());
    }

    @Test
    // Ensure contact is successfully updated
    void testUpdateFieldsFirstName() {
        Contact testContact = new Contact("1231231231", "Timmy", "Tester", "5554443333", "55 Testaroodle Ln");
        contactService.addContact(testContact);
        assertEquals(1, contactService.contactMap.size());
        testContact.setFirstName("Jason");
        contactService.updateFields(testContact);
        assertEquals("Jason", contactService.contactMap.get(testContact.getContactID()).getFirstName());
    }

    @Test
    void testUpdateFieldsLastName() {
        Contact testContact = new Contact("1231231231", "Timmy", "Tester", "5554443333", "55 Testaroodle Ln");
        contactService.addContact(testContact);
        assertEquals(1, contactService.contactMap.size());
        testContact.setLastName("Bourne");
        contactService.updateFields(testContact);
        assertEquals("Bourne", contactService.contactMap.get(testContact.getContactID()).getLastName());
    }

    @Test
    void testUpdateFieldsPhone() {
        Contact testContact = new Contact("1231231231", "Timmy", "Tester", "5554443333", "55 Testaroodle Ln");
        contactService.addContact(testContact);
        assertEquals(1, contactService.contactMap.size());
        testContact.setPhone("9998887777");
        contactService.updateFields(testContact);
        assertEquals("9998887777", contactService.contactMap.get(testContact.getContactID()).getPhone());
    }

    @Test
    void testUpdateFieldsAddress() {
        Contact testContact = new Contact("1231231231", "Timmy", "Tester", "5554443333", "55 Testaroodle Ln");
        contactService.addContact(testContact);
        assertEquals(1, contactService.contactMap.size());
        testContact.setAddress("1 Too Many Movies Rd");
        contactService.updateFields(testContact);
        assertEquals("1 Too Many Movies Rd", contactService.contactMap.get(testContact.getContactID()).getAddress());
    }

    @Test
    // Ensure unmapped contacts cannot be updated
    void testUpdateFieldsInvalidContactID() {
        Contact testContact = new Contact("1231231231", "Timmy", "Tester", "5554443333", "55 Testaroodle Ln");
        contactService.addContact(testContact);
        assertEquals(1, contactService.contactMap.size());
        Contact testContact2 = new Contact("1231231230", "Timmy", "Tester", "5554443333", "55 Testaroodle Ln");
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.updateFields(testContact2));
    }
}