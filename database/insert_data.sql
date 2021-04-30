INSERT INTO token(code) VALUES("eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjp7InRva2VuQ29kZSI6bnVsbCwibGlzdFJlc3VsdCI6W10sImZ1bGxOYW1lIjoiQ2FvIMSQaW5oIFPhu7kgVuG7uSIsInJvbGVDb2RlcyI6WyJBRE1JTiJdLCJ1c2VyTmFtZSI6InVzZXIyIiwibWVzc2FnZSI6bnVsbCwicGFzc3dvcmQiOiIxMjM0NTY3IiwiY3JlYXRlZERhdGUiOm51bGwsImNyZWF0ZWRCeSI6bnVsbCwibW9kaWZpZWREYXRlIjpudWxsLCJsaXN0UmVxdWVzdCI6W10sIm1vZGlmaWVkQnkiOm51bGwsImlkIjpudWxsfX0.sKuMRalhtEgDIofYqXP592p79z5v3MPtvregkUJ7e_U");
INSERT INTO token(code) VALUES("eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjp7InRva2VuQ29kZSI6bnVsbCwibGlzdFJlc3VsdCI6W10sImZ1bGxOYW1lIjoiQ2FvIMSQaW5oIFPhu7kgVuG7uSIsInJvbGVDb2RlcyI6WyJBRE1JTiJdLCJ1c2VyTmFtZSI6InVzZXIyIiwibWVzc2FnZSI6bnVsbCwicGFzc3dvcmQiOiIxMjM0NTY3IiwiY3JlYXRlZERhdGUiOm51bGwsImNyZWF0ZWRCeSI6bnVsbCwibW9kaWZpZWREYXRlIjpudWxsLCJsaXN0UmVxdWVzdCI6W10sIm1vZGlmaWVkQnkiOm51bGwsImlkIjpudWxsfX0.sKuMRalhtEgDIofYqXP592p79zjfalhsdfjhldkhfdk");

INSERT INTO role(name, code) VALUES("Administrator", "ADMIN");

INSERT INTO user(username, password, fullname, token_id) VALUES("admin", "123456", "Đinh Thị Thùy Linh", 1);
INSERT INTO user(username, password, fullname, token_id) VALUES("user1", "654321", "Cao Đinh Sỹ Vỹ" , 2);

INSERT INTO user_role(userid, roleid) VALUES(1, 1);
INSERT INTO user_role(userid, roleid) VALUES(2, 1);





INSERT INTO role(code, name) VALUES("ADMIN", "Administrator");
INSERT INTO role(code, name) VALUES("STUDENT", "Student");
INSERT INTO role(code, name) VALUES("LECTURER", "Lecturer");


INSERT INTO education_training(username, password, address, token_code, role_code) 
VALUES("admin", "123456", "Hồ Chí Minh", "kjflhaskdfjahsldkfjas", "ADMIN");

INSERT INTO student(username, password, fullname, start_year, id, phone_number, address, token_code, role_code) 
VALUES("student1", "123456", "Student 1", 2019, "19110143", "0975543975", "Quảng Bình", "uierqyonczmbadsd", "STUDENT");
INSERT INTO student(username, password, fullname, start_year, id, phone_number, address, token_code, role_code) 
VALUES("student2", "123456", "Student 2", 2020, "20110143", "0975543976", "Quảng Bình", "eyetyyeruierqyonczdfasdfmbadsd", "STUDENT");

INSERT INTO lecturer(username, password, fullname, id, phone_number, address, token_code, role_code) 
VALUES("lecturer1", "123456", "Lecturer 1", 1, "0875543975", "Hồ Chí Minh", "zsdfasdfcvzcxvzx", "LECTURER");
INSERT INTO lecturer(username, password, fullname, id, phone_number, address, token_code, role_code) 
VALUES("lecturer2", "123456", "Lecturer 2", 2, "0875543976", "Hồ Chí Minh", "vxzcvaefwefwfecs", "LECTURER");


INSERT INTO course(id, name, number_of_credit, fee) 
VALUES("MATH01", "Toán 1", 3, 3000000);
INSERT INTO course(id, name, number_of_credit, fee) 
VALUES("MATH02", "Toán 2", 3, 4000000);




