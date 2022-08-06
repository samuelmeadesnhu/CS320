package com.cs320.milestones;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {
    // initialize data structure
    Map<String, Task> taskMap = new HashMap<>();

    // add task with generated unique ID
    public void addTask(Task task) {
        if (taskMap.containsKey(task.getTaskID())) {
            throw new IllegalArgumentException("Task ID already exists.");
        }
        taskMap.put(task.getTaskID(), task);
    }

    // delete task from list given taskID
    public void deleteTask(String taskID) {
        taskMap.remove(taskID);
    }

    // update fields
    public void updateFields(Task task) {
        if (!taskMap.containsKey(task.getTaskID())) {
            throw new IllegalArgumentException("Task ID doesn't exists.");
        }
        taskMap.replace(task.getTaskID(), task);
    }

}
