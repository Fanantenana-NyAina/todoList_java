package repository.com;

import entity.com.States;
import entity.com.todo;

import java.util.List;

public interface DAO {
    void create(todo toAdd);
    List<todo> readAll();
    todo readOne (int id);
    todo update (int id, todo toUpdate);
    todo delete (int id);
    List<todo> searchByStates(States state);
}
