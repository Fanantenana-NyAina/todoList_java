package controller.com;

import entity.com.States;
import entity.com.todo;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("todos/{id}")
    public todo getOneTodo(@PathVariable(required = true) int id) throws SQLException, ClassNotFoundException {
        return service.getOneTodo(id);
    }

    @GetMapping("/search")
    public List<todo> getTodoByState(@RequestParam(required = true) States state) {
        return service.getTodoByState(state);
    }

    @PostMapping("/todo")
    public void createNewTodo(@RequestBody todo newTodo) {
        service.create(newTodo);
    }

}
