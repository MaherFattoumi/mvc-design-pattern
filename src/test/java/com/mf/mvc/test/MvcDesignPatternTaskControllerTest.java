package com.mf.mvc.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.mf.mvc.Task;
import com.mf.mvc.TaskController;
import com.mf.mvc.TaskStatus;
import com.mf.mvc.TaskView;

public class MvcDesignPatternTaskControllerTest {

	private List<Task> taskList;
	private TaskViewMock taskView;
	private TaskController taskController;

	@Before
	public void setUp() {
		taskList = new ArrayList<>();
		taskView = new TaskViewMock();
		taskController = new TaskController(taskList, taskView);
	}

	@Test
	public void testCreateTask() {
		taskController.createTask("Buy groceries");

		Assert.assertEquals(1, taskList.size());
		Assert.assertEquals("Buy groceries", taskList.get(0).getTitle());
	}

	@Test
	public void testMarkTaskAsCompleted() {
		Task task = new Task("Buy groceries");
		taskList.add(task);

		taskController.markTaskAsCompleted(task);

		Assert.assertEquals(TaskStatus.COMPLETED, task.getStatus());
	}

	@Test
	public void testDisplayTasks() {
		Task task1 = new Task("Task 1");
		Task task2 = new Task("Task 2");
		taskList.add(task1);
		taskList.add(task2);

		taskController.displayTasks();

		Assert.assertEquals(2, taskView.displayedTasks.size());
		Assert.assertEquals("Task 1", taskView.displayedTasks.get(0).getTitle());
		Assert.assertEquals("Task 2", taskView.displayedTasks.get(1).getTitle());
	}

	private static class TaskViewMock extends TaskView {
		private List<Task> displayedTasks = new ArrayList<>();

		@Override
		public void displayTasks(List<Task> taskList) {
			displayedTasks.addAll(taskList);
		}
	}
}
