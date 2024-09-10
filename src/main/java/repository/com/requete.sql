CREATE TABLE todolist (
    id INT PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    description VARCHAR(200),
    creationDate TIMESTAMP,
    deadline TIMESTAMP,
    priority VARCHAR(100) CHECK (priority = 'HIGH' OR priority = 'MEDIUM' OR priority = 'LOW'),
    state VARCHAR(100) CHECK (state = 'DONE' OR state = 'IN_PROGRESS')
);

INSERT INTO todolist (id, title, description, creationDate, deadline, priority, state)
VALUES
    (1, 'Finish Report', 'Complete the annual financial report.', '2024-09-10 09:00:00', '2024-09-15 17:00:00', 'HIGH', 'IN_PROGRESS');

INSERT INTO todolist (id, title, description, creationDate, deadline, priority, state)
VALUES
    (2, 'Team Meeting', 'Discuss project milestones and assign new tasks to the team members. This is a crucial meeting to ensure project deadlines are met.', '2024-09-10 10:00:00', '2024-09-10 11:00:00', 'MEDIUM', 'DONE');

INSERT INTO todolist (id, title, description, creationDate, deadline, priority, state)
VALUES
    (3, 'Organize Desk', 'Clean and organize your desk area to improve workspace efficiency.', '2024-09-11 08:30:00', '2024-09-20 17:00:00', 'LOW', 'IN_PROGRESS');

INSERT INTO todolist (id, title, creationDate, deadline, priority, state)
VALUES
    (4, 'Submit Tax Documents', '2024-09-12 14:00:00', '2024-09-30 23:59:59', 'HIGH', 'DONE');

INSERT INTO todolist (id, title, creationDate, deadline, priority)
VALUES
    (5, 'Update Resume', '2024-09-15 09:00:00', '2024-10-01 18:00:00', 'MEDIUM');
