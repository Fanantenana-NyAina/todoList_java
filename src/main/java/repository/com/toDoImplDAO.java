package repository.com;

import entity.com.Priorities;
import entity.com.States;
import entity.com.todo;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//controller -> service -> DAO / repository -> Connection
@Repository
public class toDoImplDAO implements DAO {
    @Override
    public void create(todo toAdd) {

    }

    @Override
    public List<todo> readAll() {
        DbConnection db = new DbConnection();
        List<todo> allTodos = new ArrayList<>();

        try (Statement stm = db.getConnection().createStatement()) {
            String sql = "SELECT * FROM todolist";
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                todo toAdd = new todo(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getObject("creationDate", LocalDateTime.class),
                        rs.getObject("deadline", LocalDateTime.class),
                        rs.getObject("execution_date", LocalDateTime.class),
                        Priorities.valueOf(rs.getString("priority")),
                        States.valueOf(rs.getString("state"))
                );
                allTodos.add(toAdd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allTodos;
    }

    @Override
    public todo readOne(int id) {
        return null;
    }

    @Override
    public todo update(int id, todo toUpdate) {
        return null;
    }

    @Override
    public todo delete(int id) {
        return null;
    }
}
