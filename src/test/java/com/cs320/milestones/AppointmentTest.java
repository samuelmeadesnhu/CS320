package com.cs320.milestones;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {
    Date testDate = new Date(2023-1900, 10, 1);

    @Test
    void testAppointment() {
        Appointment testAppointment = new Appointment("1234567890", testDate, "These boots were made for walkin");
        assertEquals("1234567890", testAppointment.getAppointmentID());
        assertEquals(testDate, testAppointment.getAppointmentDate());
        assertEquals("These boots were made for walkin", testAppointment.getDescription());

    }

    @Test
    void testSetAppointmentID() {
        Appointment testAppointment = new Appointment("1234567890", testDate, "These boots were made for walkin");
        assertEquals("1234567890", testAppointment.getAppointmentID());
        testAppointment.setAppointmentID("5353500000");
        assertEquals("5353500000", testAppointment.getAppointmentID());
    }

    @Test
    void testSetAppointmentDate() {
        Appointment testAppointment = new Appointment("1234567890", testDate, "These boots were made for walkin");
        assertEquals(testDate, testAppointment.getAppointmentDate());
        Date testDate2 = new Date(2025 - 1900, 9, 1);
        testAppointment.setAppointmentDate(testDate2);
        assertEquals(testDate2, testAppointment.getAppointmentDate());

    }

    @Test
    void testSetDescription() {
        Appointment testAppointment = new Appointment("1234567890", testDate, "These boots were made for walkin");
        assertEquals("These boots were made for walkin", testAppointment.getDescription());
        testAppointment.setDescription("Christopher Walkin got too many boots");
        assertEquals("Christopher Walkin got too many boots", testAppointment.getDescription());
    }



        @Test
    void testAppointmentIDLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment("12312312312", testDate, "These boots were made for walkin"));
    }

    @Test
    void testAppointmentIDNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment(null, testDate, "These boots were made for walkin"));
    }

    @Test
    void testDatePast() {
        Date pastDate = new Date(2020 - 1900, 1, 1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment("1231231231", pastDate, "These boots were made for walkin"));
    }

    @Test
    void testDescriptionLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment("1231231231", testDate, "These boots were made for walkin - Chritopher Walkin in fact. These boots, his feet, Walkin walkin."));
    }

    @Test
    void testDescriptionNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment("1231231231", testDate, null));
    }

}