package com.mf.mvc;

import java.util.List;

public class TaskView {
    public void displayTasks(List<Task> taskList) {
        System.out.println("Tasks:");
        for (Task task : taskList) {
            System.out.println("- " + task.getTitle() + " (" + task.getStatus() + ")");
        }
    }
}

