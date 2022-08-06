package com.cs320.milestones;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    void testTask() {
        Task testTask = new Task("1234567890", "Litigation", "Plant custody battle.");
        assertEquals("1234567890", testTask.getTaskID());
        assertEquals("Litigation", testTask.getName());
        assertEquals("Plant custody battle.", testTask.getDescription());
    }

    @Test
    void testTaskIDLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Task("12345678911", "Litigation", "Plant custody battle."));
    }

    @Test
    void testTaskIDNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(null, "Litigation", "Plant custody battle."));
    }

    @Test
    void testNameLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Task("1234567890", "Litigation Services Inc.", "Plant custody battle."));
    }

    @Test
    void testNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Task("1234567890", null, "Plant custody battle."));
    }

    @Test
    void testDescriptionLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Task("1234567890", "Litigation", "Fighting over the custody of our precious house plants."));
    }

    @Test
    void testDescriptionNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Task("1234567890", "Litigation", null));
    }

}