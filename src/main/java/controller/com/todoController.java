package controller.com;

import entity.com.todo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.com.TodoService;

import java.sql.SQLException;
import java.util.List;

@RestController
public class todoController {
    private TodoService service;

    public todoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/todos")
    public List<todo> getAllTodos() throws SQLException, ClassNotFoundException {
        return service.getAllTodos();
    }

    @GetMapping("/error")
    public String error() throws SQLException, ClassNotFoundException {
        return error();
    }
}
