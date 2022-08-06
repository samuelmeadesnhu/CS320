package com.cs320.milestones;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AppointmentService {
    // initialize data structure
    Map<String, Appointment> appointmentMap = new HashMap<>();

    // add appointment with generated unique ID
    public void addAppointment(Appointment appointment) {
        if (appointmentMap.containsKey(appointment.getAppointmentID())) {
            throw new IllegalArgumentException("Appointment ID already exists.");
        }
        appointmentMap.put(appointment.getAppointmentID(), appointment);
    }

    // delete appointment from list given appointmentID
    public void deleteAppointment(String appointmentID) {
        appointmentMap.remove(appointmentID);
    }
}
