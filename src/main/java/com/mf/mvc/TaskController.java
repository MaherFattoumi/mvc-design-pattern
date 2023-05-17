package com.mf.mvc;

import java.util.List;

public class TaskController {
    private List<Task> taskList;
    private TaskView taskView;

    public TaskController(List<Task> taskList, TaskView taskView) {
        this.taskList = taskList;
        this.taskView = taskView;
    }

    public void createTask(String title) {
        Task task = new Task(title);
        taskList.add(task);
    }

    public void markTaskAsCompleted(Task task) {
        task.markAsCompleted();
    }

    public void displayTasks() {
        taskView.displayTasks(taskList);
    }
}



