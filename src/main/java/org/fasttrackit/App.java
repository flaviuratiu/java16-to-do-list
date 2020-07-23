package org.fasttrackit;

import org.fasttrackit.config.DatabaseConfiguration;
import org.fasttrackit.persistence.TaskRepository;
import org.fasttrackit.transfer.CreateTaskRequest;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        System.out.println( "Hello World!" );

        TaskRepository taskRepository = new TaskRepository();

        CreateTaskRequest request = new CreateTaskRequest();
        request.setDescription("Learn JDBC");
        request.setDeadline(LocalDate.now().plusWeeks(1));

        taskRepository.createTask(request);
    }
}
