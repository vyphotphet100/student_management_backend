INSERT INTO role(code, name) VALUES("ADMIN", "Administrator");
INSERT INTO role(code, name) VALUES("STUDENT", "Student");
INSERT INTO role(code, name) VALUES("LECTURER", "Lecturer");
INSERT INTO role(code, name) VALUES("DT", "Đại trà");
INSERT INTO role(code, name) VALUES("CLC", "Chất lượng cao");
INSERT INTO role(code, name) VALUES("CNTT", "Công nghệ thông tin");
INSERT INTO role(code, name) VALUES("PDT", "Phòng đào tạo");


INSERT INTO education_training(username, password, address, token_code, role_code) 
VALUES("admin1", "123456", "Thành phố Hồ Chí Minh", "kjflhaskdfjayoiuyiuyiupiouoiyuytidmnfsfdsgdbhsldkfjas", "ADMIN");

INSERT INTO `student` (`id`, `address`, `birthday`, `createdby`, `createddate`, `first_name`, `fullname`, `gender`, `last_name`, `modifiedby`, `modifieddate`, `password`, `phone_number`, `picture`, `start_year`, `token_code`, `username`, `role_code`) VALUES
('19110143', 'Quảng Bình', '2001-04-15 00:00:00', 'admin', '2021-05-10 02:55:25', 'Cao Đinh Sỹ', 'Cao Đinh Sỹ Vỹ', 'Male', 'Vỹ', 'admin', '2021-05-10 02:55:25', '19110143', '0975543975', '/api/file/student/19110143/avatar.png', 2021, 'eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjp7ImJpcnRoZGF5IjoiU3VuIEFwciAxNSAwNzowMDowMCBJQ1QgMjAwMSIsImxhc3ROYW1lIjoiVuG7uSIsInRva2VuQ29kZSI6bnVsbCwibGlzdFJlc3VsdCI6W10sImFkZHJlc3MiOiJRdeG6o25nIELDrG5oIiwiZ2VuZGVyIjoiTWFsZSIsInN0YXJ0WWVhciI6MjAyMSwibWVzc2FnZSI6bnVsbCwicmVnaXN0ZXJJZHMiOltdLCJwaWN0dXJlIjoiXC9hcGlcL2ZpbGVcL3N0dWRlbnRcLzE5MTEwMTQzXC9hdmF0YXIucG5nIiwiYXV0aG9yaXRpZXMiOltdLCJmaXJzdE5hbWUiOiJDYW8gxJBpbmggU-G7uSIsInBhc3N3b3JkIjoiMTkxMTAxNDMiLCJwaG9uZU51bWJlciI6IjA5NzU1NDM5NzUiLCJjcmVhdGVkRGF0ZSI6bnVsbCwiY3JlYXRlZEJ5IjpudWxsLCJyb2xlQ29kZSI6IlNUVURFTlQiLCJodHRwU3RhdHVzIjoiT0siLCJtb2RpZmllZERhdGUiOm51bGwsImxpc3RSZXF1ZXN0IjpbXSwibW9kaWZpZWRCeSI6bnVsbCwiaWQiOiIxOTExMDE0MyIsImZ1bGxuYW1lIjoiQ2FvIMSQaW5oIFPhu7kgVuG7uSIsInVzZXJuYW1lIjoiMTkxMTAxNDMifX0.PXXWDVpAAqr1Ko0pOcd52Aaed2eXz6Aoljy2h8fVkvg', '19110143', 'STUDENT'),
('19110144', 'Quảng Bình', '2001-04-20 00:00:00', 'admin', '2021-05-10 02:57:05', 'Đinh Thị Thùy', 'Đinh Thị Thùy Linh', 'Female', 'Linh', 'admin', '2021-05-10 02:57:05', '19110144', '0987654321', '/api/file/student/19110144/avatar.png', 2021, 'eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjp7ImJpcnRoZGF5IjoiRnJpIEFwciAyMCAwNzowMDowMCBJQ1QgMjAwMSIsImxhc3ROYW1lIjoiTGluaCIsInRva2VuQ29kZSI6bnVsbCwibGlzdFJlc3VsdCI6W10sImFkZHJlc3MiOiJRdeG6o25nIELDrG5oIiwiZ2VuZGVyIjoiRmVtYWxlIiwic3RhcnRZZWFyIjoyMDIxLCJtZXNzYWdlIjpudWxsLCJyZWdpc3RlcklkcyI6W10sInBpY3R1cmUiOiJcL2FwaVwvZmlsZVwvc3R1ZGVudFwvMTkxMTAxNDRcL2F2YXRhci5wbmciLCJhdXRob3JpdGllcyI6W10sImZpcnN0TmFtZSI6IsSQaW5oIFRo4buLIFRow7l5IiwicGFzc3dvcmQiOiIxOTExMDE0NCIsInBob25lTnVtYmVyIjoiMDk4NzY1NDMyMSIsImNyZWF0ZWREYXRlIjpudWxsLCJjcmVhdGVkQnkiOm51bGwsInJvbGVDb2RlIjoiU1RVREVOVCIsImh0dHBTdGF0dXMiOiJPSyIsIm1vZGlmaWVkRGF0ZSI6bnVsbCwibGlzdFJlcXVlc3QiOltdLCJtb2RpZmllZEJ5IjpudWxsLCJpZCI6IjE5MTEwMTQ0IiwiZnVsbG5hbWUiOiLEkGluaCBUaOG7iyBUaMO5eSBMaW5oIiwidXNlcm5hbWUiOiIxOTExMDE0NCJ9fQ.Kbh3CLdJw4mXrPrvi2Uys1YJPQ2Hqs5YLBur5UFSk_E', '19110144', 'STUDENT');

INSERT INTO lecturer(username, password, fullname, id, phone_number, address, token_code, role_code) 
VALUES("lecturer1", "123456", "Lecturer 1", 1, "0875543975", "Hồ Chí Minh", "zsdfasdfcvzutuyruytetrewerytuiyoppuioyiuoyoiucxvzx", "LECTURER");
INSERT INTO lecturer(username, password, fullname, id, phone_number, address, token_code, role_code) 
VALUES("lecturer2", "123456", "Lecturer 2", 2, "0875543976", "Hồ Chí Minh", "vxzcvaefwefmnvcxnvvcxnbvbxfdshfdhrtdhtuetrertdjwfecs", "LECTURER");


INSERT INTO course(id, name, number_of_credit, fee) 
VALUES("MATH01", "Toán 1", 3, 3000000);
INSERT INTO course(id, name, number_of_credit, fee) 
VALUES("MATH02", "Toán 2", 3, 4000000);


INSERT INTO section_class(id, name, course_id, room, lecturer_id, period, description) 
VALUES("MATH02_20_02", "Toán 2 - Nhóm 2", "MATH02", "A3-303", 1, 15, "Đây là Nhóm 2 của môn Toán 2.");
INSERT INTO section_class(id, name, course_id, room, lecturer_id, period, description) 
VALUES("MATH01_20_03", "Toán 1 - Nhóm 3", "MATH01", "A3-304", 2, 15, "Đây là Nhóm 3 của môn Toán 1.");


INSERT INTO register(student_id, section_class_id, midterm_mark, endterm_mark) 
VALUES("19110143", "MATH02_20_02", 9.5, 7.5);
INSERT INTO register(student_id, section_class_id, midterm_mark, endterm_mark) 
VALUES("19110144", "MATH01_20_03", 5.5, 9.5);


INSERT INTO notification(title, short_description, content) 
VALUES("Thông báo 1", "Đây là mô tả ngắn của thông báo 1", "Đây là content của thông báo 1");
INSERT INTO notification(title, short_description, content) 
VALUES("Thông báo 2", "Đây là mô tả ngắn của thông báo 2", "Đây là content của thông báo 2");







