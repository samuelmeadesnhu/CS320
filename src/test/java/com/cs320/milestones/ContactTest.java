package com.cs320.milestones;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    void testContact() {
        Contact testContact = new Contact("1231231231", "Timmy", "Tester", "5554443333", "55 Testaroodle Ln");
        assertEquals("1231231231", testContact.getContactID());
        assertEquals("Timmy", testContact.getFirstName());
        assertEquals("Tester", testContact.getLastName());
        assertEquals("5554443333", testContact.getPhone());
        assertEquals("55 Testaroodle Ln", testContact.getAddress());
    }

    @Test
    void testContactIDLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("12312312312", "Timmy", "Tester", "5554443333", "55 Testaroodle Ln"));
    }

    @Test
    void testContactIDNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(null, "Timmy", "Tester", "5554443333", "55 Testaroodle Ln"));
    }

    @Test
    void testFirstNameLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("1231231231", "Timmy Trust", "Tester", "5554443333", "55 Testaroodle Ln"));
    }

    @Test
    void testFirstNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("1231231231", null, "Tester", "5554443333", "55 Testaroodle Ln"));
    }

    @Test
    void testLastNameLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("1231231231", "Timmy", "Tester Tada", "5554443333", "55 Testaroodle Ln"));
    }

    @Test
    void testLastNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("1231231231", "Timmy=", null, "5554443333", "55 Testaroodle Ln"));
    }

    @Test
    void testPhoneLengthOver() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("1231231231", "Timmy", "Tester", "55544433331", "55 Testaroodle Ln"));
    }

    @Test
    void testPhoneLengthUnder() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("1231231231", "Timmy", "Tester", "555444333", "55 Testaroodle Ln"));
    }

    @Test
    void testPhoneLengthNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("1231231231", "Timmy", "Tester", null, "55 Testaroodle Ln"));
    }

    @Test
    void testAddressLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("1231231231", "Timmy", "Tester", "5554443333", "55 Testaroodle Ln11111111111111"));
    }

    @Test
    void testAddressNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("1231231231", "Timmy", "Tester", "5554443333", null));
    }
}