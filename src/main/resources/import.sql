INSERT INTO users (username, password, role) VALUES ('admin', '$2a$10$Lb1tSRGaF0NNPCivEMDs8.xkx9BRm5/Dgbkn909o44e0JCIdWTljG', 'ROLE_ADMIN');
INSERT INTO users (username, password, role) VALUES ('jdoe', '$2a$10$hVU0SolXjCF8aouJIHU7eeXvMEPjoVuvnDQZ4HJUrHIKF18dBbbIa', 'ROLE_MANAGER');
INSERT INTO users (username, password, role) VALUES ('tom', '$2a$10$BgzEVyT/a6B6cWuwoFpOCuwAyavGT8vkhXSK0yNwtZ4W6.rMCVxey', 'ROLE_EMPLOYEE');
INSERT INTO users (username, password, role) VALUES ('mary', '$2a$10$PAAIaqHlKlGDq02ynW2.X.NXgFQ/D/fT6dvg7u4TUrO/sBBTcNK5W', 'ROLE_EMPLOYEE');
INSERT INTO users (username, password, role) VALUES ('mike', '$2a$10$rrPQz/Ts67ut7RbSyH9qqeHCleH0.xOFUOJ3x52YWfj95qi3D8Oxy', 'ROLE_EMPLOYEE');

INSERT INTO tasks (content, completed, users_id) VALUES ('Buy ink for the printer', 0, 3);
INSERT INTO tasks (content, completed, users_id) VALUES ('Call client X', 0, 4);
INSERT INTO tasks (content, completed, users_id) VALUES ('Fix truck', 0, 3);
INSERT INTO tasks (content, completed, users_id) VALUES ('Send advertisment to TV', 0, 5);