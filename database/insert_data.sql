INSERT INTO role(code, name) VALUES("ADMIN", "Administrator");
INSERT INTO role(code, name) VALUES("STUDENT", "Student");
INSERT INTO role(code, name) VALUES("LECTURER", "Lecturer");


INSERT INTO education_training(username, password, address, token_code, role_code) 
VALUES("admin", "123456", "Hồ Chí Minh", "kjflhaskdfjayoiuyiuyiupiouoiyuytidmnfsfdsgdbhsldkfjas", "ADMIN");

INSERT INTO student(username, password, fullname, start_year, id, phone_number, address, token_code, role_code) 
VALUES("student1", "123456", "Student 1", 2019, "19110143", "0975543975", "Quảng Bình", "uiermyutruyrfhgdkhgkoiuyyurghnwreqyonczmbadsd", "STUDENT");
INSERT INTO student(username, password, fullname, start_year, id, phone_number, address, token_code, role_code) 
VALUES("student2", "123456", "Student 2", 2020, "20110143", "0975543976", "Quảng Bình", "eyetyyeruierqyonrutyruytruytruytryuczdfasdfmbadsd", "STUDENT");

INSERT INTO lecturer(username, password, fullname, id, phone_number, address, token_code, role_code) 
VALUES("lecturer1", "123456", "Lecturer 1", 1, "0875543975", "Hồ Chí Minh", "zsdfasdfcvzutuyruytetrewerytuiyoppuioyiuoyoiucxvzx", "LECTURER");
INSERT INTO lecturer(username, password, fullname, id, phone_number, address, token_code, role_code) 
VALUES("lecturer2", "123456", "Lecturer 2", 2, "0875543976", "Hồ Chí Minh", "vxzcvaefwefmnvcxnvvcxnbvbxfdshfdhrtdhtuetrertdjwfecs", "LECTURER");


INSERT INTO course(id, name, number_of_credit, fee) 
VALUES("MATH01", "Toán 1", 3, 3000000);
INSERT INTO course(id, name, number_of_credit, fee) 
VALUES("MATH02", "Toán 2", 3, 4000000);


INSERT INTO section_class(id, name, course_id, room, lecturer_id) 
VALUES("MATH02_20_02", "Toán 2 - Nhóm 2", "MATH02", "A3-303", 1);
INSERT INTO section_class(id, name, course_id, room, lecturer_id) 
VALUES("MATH01_20_03", "Toán 1 - Nhóm 3", "MATH01", "A3-304", 2);


INSERT INTO register(student_id, section_class_id, midterm_mark, endterm_mark) 
VALUES("19110143", "MATH02_20_02", 9.5, 7.5);
INSERT INTO register(student_id, section_class_id, midterm_mark, endterm_mark) 
VALUES("20110143", "MATH01_20_03", 5.5, 9.5);


INSERT INTO notification(title, short_description, content) 
VALUES("Thông báo 1", "Đây là mô tả ngắn của thông báo 1", "Đây là content của thông báo 1");
INSERT INTO notification(title, short_description, content) 
VALUES("Thông báo 2", "Đây là mô tả ngắn của thông báo 2", "Đây là content của thông báo 2");







