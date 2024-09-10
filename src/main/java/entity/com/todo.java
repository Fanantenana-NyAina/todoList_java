package entity.com;

import java.time.LocalDateTime;

public class todo {
    private int id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime deadline;
    private LocalDateTime executionDate;
    private Priorities priority;
    private States state;

    public todo(int id, String title, String description, LocalDateTime creationDate, LocalDateTime deadline, LocalDateTime executionDate, Priorities priority, States state) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.deadline = deadline;
        this.executionDate = executionDate;
        this.priority = priority;
        this.state = state;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getExecutionDate() {
        return executionDate;
    }

    public int getId() {
        return id;
    }

    public Priorities getPriority() {
        return priority;
    }

    public States getState() {
        return state;
    }

    public String getTitle() {
        return title;
    }
}
