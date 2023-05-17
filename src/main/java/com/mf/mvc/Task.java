package com.mf.mvc;

public class Task {
    private String title;
    private TaskStatus status;

    public Task(String title) {
        this.title = title;
        this.status = TaskStatus.PENDING;
    }

    public String getTitle() {
        return title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void markAsCompleted() {
        this.status = TaskStatus.COMPLETED;
    }
}

