package com.mf.mvc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import com.mf.mvc.Task;
import com.mf.mvc.TaskController;
import com.mf.mvc.TaskStatus;
import com.mf.mvc.TaskView;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "mvc-design-pattern-managementApp.feature")
public class MvcDesignPatternTaskSteps {
	private List<Task> taskList;
	private TaskView taskView;
	private TaskController taskController;

	@Given("^an empty task list$")
	public void anEmptyTaskList() {
		taskList = new ArrayList<>();
		taskView = new TaskView();
		taskController = new TaskController(taskList, taskView);
	}

	@When("^I create a task with title \"(.*)\"$")
	public void iCreateATaskWithTitle(String title) {
		taskController.createTask(title);
	}

	@Then("^the task list should contain a task with title \"(.*)\"$")
	public void theTaskListShouldContainATaskWithTitle(String expectedTitle) {
		boolean taskFound = false;
		for (Task task : taskList) {
			if (task.getTitle().equals(expectedTitle)) {
				taskFound = true;
				break;
			}
		}
		assertTrue(taskFound);
	}

	@Given("^a task list with a task titled \"(.*)\"$")
	public void aTaskListWithATaskTitled(String taskTitle) {
		taskList = new ArrayList<>();
		Task task = new Task(taskTitle);
		taskList.add(task);
		taskView = new TaskView();
		taskController = new TaskController(taskList, taskView);
	}

	@When("^I mark the task as completed$")
	public void iMarkTheTaskAsCompleted() {
		taskController.markTaskAsCompleted(taskList.get(0));
	}

	@Then("^the task status should be marked as completed$")
	public void theTaskStatusShouldBeMarkedAsCompleted() {
		assertEquals(TaskStatus.COMPLETED, taskList.get(0).getStatus());
	}
}
