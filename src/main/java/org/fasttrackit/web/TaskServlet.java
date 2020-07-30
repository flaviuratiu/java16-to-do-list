package org.fasttrackit.web;

import org.fasttrackit.config.ObjectMapperConfiguration;
import org.fasttrackit.domain.Task;
import org.fasttrackit.service.TaskService;
import org.fasttrackit.transfer.CreateTaskRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {

    private TaskService taskService = new TaskService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateTaskRequest request = ObjectMapperConfiguration.getObjectMapper()
                .readValue(req.getReader(), CreateTaskRequest.class);

        try {
            taskService.createTask(request);
        } catch (SQLException e) {
            resp.sendError(500, e.getMessage());
        }
    }

    // endpoint
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Task> tasks = taskService.getTasks();

            // writing tasks to response as JSON array
            ObjectMapperConfiguration.getObjectMapper().writeValue(resp.getWriter(), tasks);

        } catch (SQLException e) {
            resp.sendError(500, e.getMessage());
        }
    }
}
