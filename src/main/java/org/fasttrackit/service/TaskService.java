package org.fasttrackit.service;

import org.fasttrackit.domain.Task;
import org.fasttrackit.persistence.TaskRepository;
import org.fasttrackit.transfer.CreateTaskRequest;
import org.fasttrackit.transfer.UpdateTaskRequest;

import java.sql.SQLException;
import java.util.List;

public class TaskService {

    private TaskRepository taskRepository = new TaskRepository();

    public void createTask(CreateTaskRequest request) throws SQLException {
        System.out.println("Creating task: " + request);
        taskRepository.createTask(request);
    }

    public List<Task> getTasks() throws SQLException {
        System.out.println("Retrieving tasks.");
        return taskRepository.getTasks();
    }

    public void updateTask(long id, UpdateTaskRequest request) throws SQLException {
        System.out.println("Updating task " + id + ": " + request);
        taskRepository.updateTask(id, request);
    }

    public void deleteTask(long id) throws SQLException {
        System.out.println("Deleting task " + id);
        taskRepository.deleteTask(id);
    }
}
