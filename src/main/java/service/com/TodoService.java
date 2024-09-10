package service.com;

import entity.com.States;
import entity.com.todo;
import org.springframework.stereotype.Service;
import repository.com.toDoImplDAO;

import java.util.List;

@Service
public class TodoService {
    private toDoImplDAO dao;

    public TodoService(toDoImplDAO dao) {
        this.dao = dao;
    }

    public List<todo> getAllTodos() {
        return dao.readAll();
    }

    public todo getOneTodo(int searchId) {
        return dao.readOne(searchId);
    }

    public List<todo> getTodoByState(States state) {
        return dao.searchByStates(state);
    }

    public void create(todo toAdd) {
        dao.create(toAdd);
    }
}
