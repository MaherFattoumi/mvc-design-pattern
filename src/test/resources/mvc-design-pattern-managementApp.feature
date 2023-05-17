Feature: Task Management Application

  Scenario: Create a new task
    Given an empty task list
    When I create a task with title "Buy groceries"
    Then the task list should contain a task with title "Buy groceries"

  Scenario: Complete a task
    Given a task list with a task titled "Buy groceries"
    When I mark the task as completed
    Then the task status should be marked as completed
