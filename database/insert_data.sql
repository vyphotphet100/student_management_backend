INSERT INTO token(code) VALUES("eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjp7InRva2VuQ29kZSI6bnVsbCwibGlzdFJlc3VsdCI6W10sImZ1bGxOYW1lIjoiQ2FvIMSQaW5oIFPhu7kgVuG7uSIsInJvbGVDb2RlcyI6WyJBRE1JTiJdLCJ1c2VyTmFtZSI6InVzZXIyIiwibWVzc2FnZSI6bnVsbCwicGFzc3dvcmQiOiIxMjM0NTY3IiwiY3JlYXRlZERhdGUiOm51bGwsImNyZWF0ZWRCeSI6bnVsbCwibW9kaWZpZWREYXRlIjpudWxsLCJsaXN0UmVxdWVzdCI6W10sIm1vZGlmaWVkQnkiOm51bGwsImlkIjpudWxsfX0.sKuMRalhtEgDIofYqXP592p79z5v3MPtvregkUJ7e_U");
INSERT INTO token(code) VALUES("eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjp7InRva2VuQ29kZSI6bnVsbCwibGlzdFJlc3VsdCI6W10sImZ1bGxOYW1lIjoiQ2FvIMSQaW5oIFPhu7kgVuG7uSIsInJvbGVDb2RlcyI6WyJBRE1JTiJdLCJ1c2VyTmFtZSI6InVzZXIyIiwibWVzc2FnZSI6bnVsbCwicGFzc3dvcmQiOiIxMjM0NTY3IiwiY3JlYXRlZERhdGUiOm51bGwsImNyZWF0ZWRCeSI6bnVsbCwibW9kaWZpZWREYXRlIjpudWxsLCJsaXN0UmVxdWVzdCI6W10sIm1vZGlmaWVkQnkiOm51bGwsImlkIjpudWxsfX0.sKuMRalhtEgDIofYqXP592p79zjfalhsdfjhldkhfdk");

INSERT INTO role(name, code) VALUES("Administrator", "ADMIN");

INSERT INTO user(username, password, fullname, token_id) VALUES("admin", "123456", "Đinh Thị Thùy Linh", 1);
INSERT INTO user(username, password, fullname, token_id) VALUES("user1", "654321", "Cao Đinh Sỹ Vỹ" , 2);

INSERT INTO user_role(userid, roleid) VALUES(1, 1);
INSERT INTO user_role(userid, roleid) VALUES(2, 1);

INSERT INTO score(course_id, student_id, mid_term_score, end_term_score) VALUES(1234, 19110143, 8.9, 9.0);



