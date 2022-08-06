package com.cs320.milestones;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {
    private TaskService taskService;

    @BeforeEach
    void instantiate() {
        taskService = new TaskService();
    }

    @Test
    // Test adding a task
    void testAddTask() {
        Task testTask = new Task("1234567890", "Test Task", "This task was meant for testin");
        taskService.addTask(testTask);
        assertEquals(1, taskService.taskMap.size());
    }

    @Test
    // Test trying to add a duplicate task
    void testDuplicateTaskID() {
        Task testTask = new Task("1234567890", "Test Task", "This task was meant for testin");
        taskService.addTask(testTask);
        assertEquals(1, taskService.taskMap.size());
        Task testTask2 = new Task("1234567890", "Duplicate", "This is a dup task");
        Assertions.assertThrows(IllegalArgumentException.class, () -> taskService.addTask(testTask2));

    }
    @Test
        // Check that task is added then deleted
    void testDeleteTask() {
        Task testTask = new Task("1234567890", "Test Task", "This task was meant for testin");
        taskService.addTask(testTask);
        assertEquals(1, taskService.taskMap.size());
        taskService.deleteTask(testTask.getTaskID());
        assertEquals(0, taskService.taskMap.size());
    }

    @Test
        // Ensure invalid tasks aren't deleted
    void testDeleteTaskInvalidID() {
        Task testTask = new Task("1234567890", "Test Task", "This task was meant for testin");
        taskService.addTask(testTask);
        assertEquals(1, taskService.taskMap.size());
        taskService.deleteTask("0000000000");
        assertEquals(1, taskService.taskMap.size());
    }

    @Test
        // Ensure task is successfully updated
    void testUpdateFieldsName() {
        Task testTask = new Task("1234567890", "Test Task", "This task was meant for testin");
        taskService.addTask(testTask);
        assertEquals(1, taskService.taskMap.size());
        testTask.setName("Quiz");
        taskService.updateFields(testTask);
        assertEquals("Quiz", taskService.taskMap.get(testTask.getTaskID()).getName());
    }

    @Test
    void testUpdateFieldsDescription() {
        Task testTask = new Task("1234567890", "Test Task", "This task was meant for testin");
        taskService.addTask(testTask);
        assertEquals(1, taskService.taskMap.size());
        testTask.setDescription("Oddly specific non-specific change");
        taskService.updateFields(testTask);
        assertEquals("Oddly specific non-specific change", taskService.taskMap.get(testTask.getTaskID()).getDescription());
    }

    @Test
        // Ensure unmapped tasks cannot be updated
    void testUpdateFieldsInvalidTaskID() {
        Task testTask = new Task("1234567890", "Test Task", "This task was meant for testin");
        taskService.addTask(testTask);
        assertEquals(1, taskService.taskMap.size());
        Task testTask2 = new Task("1234567899", "Test Task II", "This task was meant for testin again");
        Assertions.assertThrows(IllegalArgumentException.class, () -> taskService.updateFields(testTask2));
    }
}