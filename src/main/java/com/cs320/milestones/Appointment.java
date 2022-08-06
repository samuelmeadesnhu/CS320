package com.cs320.milestones;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

//@Data
//@NoArgsConstructor
// set Args through lombok
public class Appointment {
    private String appointmentID;
    private Date appointmentDate;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public Appointment(String appointmentID, Date appointmentDate, String description ) {
        // Get current date
        Date curDate = new Date();
        if (appointmentID == null || appointmentID.length() > 10) {
            throw new IllegalArgumentException("Invalid task ID");
        }
        if (appointmentDate == null || appointmentDate.before(curDate)) {
            throw new IllegalArgumentException("Invalid date");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }

        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }
}
