package com.cs320.milestones;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceTest {
    private  AppointmentService appointmentService;

    @BeforeEach
    void instantiate() {
        appointmentService = new AppointmentService();
    }

    @Test
    // Add new appointment to map
    void testAddAppointment() {
        Date testDate = new Date(2023-1900, 10, 1);
        Appointment testAppointment = new Appointment("1231231231", testDate, "These boots were made for walkin");
        appointmentService.addAppointment(testAppointment);
        assertEquals(1, appointmentService.appointmentMap.size());
    }

    @Test
    // Ensure duplicate contactID throws error
    void testAddDuplicateAppointment() {
        Date testDate = new Date(2023-1900, 10, 1);
        Appointment testAppointment = new Appointment("1231231231", testDate, "These boots were made for walkin");
        appointmentService.addAppointment(testAppointment);
        assertEquals(1, appointmentService.appointmentMap.size());
        Appointment testAppointment2 = new Appointment("1231231231", testDate, "These boots were made for swimmin");
        Assertions.assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment(testAppointment2));
    }

    @Test
    // Check appointment is added THEN deleted
    void testDeleteAppointment() {
        Date testDate = new Date(2023-1900, 10, 1);
        Appointment testAppointment = new Appointment("1231231231", testDate, "These boots were made for walkin");
        appointmentService.addAppointment(testAppointment);
        assertEquals(1, appointmentService.appointmentMap.size());
        appointmentService.deleteAppointment(testAppointment.getAppointmentID());
        assertEquals(0, appointmentService.appointmentMap.size());
    }

    @Test
    // Ensure invalid IDs aren't deleted
    void testDeleteInvalidAppointmentID() {
        Date testDate = new Date(2023-1900, 10, 1);
        Appointment testAppointment = new Appointment("1231231231", testDate, "These boots were made for walkin");
        appointmentService.addAppointment(testAppointment);
        assertEquals(1, appointmentService.appointmentMap.size());
        appointmentService.deleteAppointment("0000001111");
        assertEquals(1, appointmentService.appointmentMap.size());
    }
}