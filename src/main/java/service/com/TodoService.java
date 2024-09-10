package service.com;

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
}
