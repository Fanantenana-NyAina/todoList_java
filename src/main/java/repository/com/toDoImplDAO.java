package repository.com;

import entity.com.Priorities;
import entity.com.States;
import entity.com.todo;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//controller -> service -> DAO / repository -> Connection
@Repository
public class toDoImplDAO implements DAO {
    DbConnection db = new DbConnection();
    @Override
    public void create(todo toAdd) {
        try {
            PreparedStatement myPs = db.getConnection().prepareStatement("INSERT INTO todolist VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            myPs.setInt(1, toAdd.getId());
            myPs.setString(2, toAdd.getTitle());
            myPs.setString(3, toAdd.getDescription());
            myPs.setObject(4, toAdd.getCreationDate());
            myPs.setObject(5, toAdd.getDeadline());
            myPs.setObject(6, toAdd.getExecutionDate());
            myPs.setString(7, toAdd.getPriority().toString());
            myPs.setString(8, toAdd.getState().toString());

            int inserted = myPs.executeUpdate();

            if (inserted > 0) {
                System.out.println("successfully insert");
            } else {
                System.out.println("insert error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<todo> readAll() {
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
        try {
            PreparedStatement myPs = db.getConnection().prepareStatement("SELECT * FROM todolist WHERE id = ?");
            myPs.setInt(1, id);
            ResultSet myRs = myPs.executeQuery();

            if (myRs.next()) {
                return new todo(
                        myRs.getInt("id"),
                        myRs.getString("title"),
                        myRs.getString("description"),
                        myRs.getObject("creationDate", LocalDateTime.class),
                        myRs.getObject("deadline", LocalDateTime.class),
                        myRs.getObject("execution_date", LocalDateTime.class),
                        Priorities.valueOf(myRs.getString("priority")),
                        States.valueOf(myRs.getString("state"))
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<todo> searchByStates(States state) {
        List<todo> searchResult = new ArrayList<>();
        try {
            PreparedStatement myPs = db.getConnection().prepareStatement("SELECT * FROM todolist WHERE state = ?");
            myPs.setString(1, state.toString());
            ResultSet myRs = myPs.executeQuery();

            while(myRs.next()) {
                todo searched = new todo(
                        myRs.getInt("id"),
                        myRs.getString("title"),
                        myRs.getString("description"),
                        myRs.getObject("creationDate", LocalDateTime.class),
                        myRs.getObject("deadline", LocalDateTime.class),
                        myRs.getObject("execution_date", LocalDateTime.class),
                        Priorities.valueOf(myRs.getString("priority")),
                        States.valueOf(myRs.getString("state"))
                );

                searchResult.add(searched);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return searchResult;
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
