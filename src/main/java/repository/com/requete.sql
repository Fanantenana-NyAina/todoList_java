DROP TABLE IF EXISTS  todolist;

CREATE TABLE todolist (
    id INT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    description VARCHAR(100) NOT NULL ,
    creationDate TIMESTAMP NOT NULL ,
    deadline TIMESTAMP NOT NULL ,
    execution_date TIMESTAMP NOT NULL ,
    priority VARCHAR(30) CHECK (priority = 'HIGH' OR priority = 'MEDIUM' OR priority = 'LOW') NOT NULL,
    state VARCHAR(30) CHECK (state = 'DONE' OR state = 'IN_PROGRESS') NOT NULL
);

INSERT INTO todolist (id, title, description, creationDate, deadline, execution_date, priority, state)
VALUES (1, 'Finish Project', 'Complete the project by the end of the month', '2024-09-01 09:00:00', '2024-09-30 23:59:59', '2024-09-10 15:00:00', 'HIGH', 'IN_PROGRESS');

INSERT INTO todolist (id, title, description, creationDate, deadline, execution_date, priority, state)
VALUES (2, 'Team Meeting', 'Weekly sync-up with the team', '2024-09-05 10:00:00', '2024-09-05 11:00:00', '2024-09-05 10:30:00', 'MEDIUM', 'DONE');

INSERT INTO todolist (id, title, description, creationDate, deadline, execution_date, priority, state)
VALUES (3, 'Prepare Presentation', 'Prepare slides for client meeting', '2024-09-07 14:00:00', '2024-09-10 09:00:00', '2024-09-09 17:00:00', 'HIGH', 'DONE');

INSERT INTO todolist (id, title, description, creationDate, deadline, execution_date, priority, state)
VALUES (4, 'Code Review', 'Review code submissions by the team', '2024-09-08 08:00:00', '2024-09-12 17:00:00', '2024-09-11 12:00:00', 'LOW', 'IN_PROGRESS');

INSERT INTO todolist (id, title, description, creationDate, deadline, execution_date, priority, state)
VALUES (5, 'Write Documentation', 'Complete the API documentation', '2024-09-09 11:00:00', '2024-09-15 17:00:00', '2024-09-14 16:00:00', 'MEDIUM', 'DONE');
