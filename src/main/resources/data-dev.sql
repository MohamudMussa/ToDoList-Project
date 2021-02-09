INSERT INTO TO_DO_DOMAIN (list_Name) 
VALUES 
('To Do'),
('Shopping'),
('Work'),
('Sport'),
('Shopping'),
('House Items'),
('Work'),
('Hobbies');


INSERT INTO TASK_DOMAIN (name, category, rank, completed, my_To_Do_id) 
VALUES 
('Buy Banana', 'Shopping', 2, false,1),
('Football', 'Sport', 3, true,2),
('Buy Phone', 'Shopping', 2, false,3),
('Clean', 'To Do', 3, true,4),
('Run', 'Work', 2, false,5),
('Finish Report', 'Hobbies', 3, true,6);