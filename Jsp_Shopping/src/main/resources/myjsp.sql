USE myjsp;

CREATE TABLE users
(
    id INT PRIMARY KEY,					#用户id
    username VARCHAR(50) NOT NULL,		#用户姓名
    pwd VARCHAR(50) NOT NULL, 			#密码 
    email VARCHAR(100) NOT NULL,		#邮箱 
    phonenumber VARCHAR(20) NOT NULL,	#电话
    grade INT(2) DEFAULT 1
);

INSERT INTO users VALUES(1,'刘宁','719226','mayrzlmayrzl@outlook.com','15927552746',2);

SELECT * FROM users;
DELETE FROM users WHERE id = 3;

CREATE TABLE books
(
    `id` INT AUTO_INCREMENT PRIMARY KEY,	#书的编号 
    `name` VARCHAR(50) NOT NULL,			#书的名字 
    `author` VARCHAR(50) NOT NULL,		#书的作者 
    `publishHouse` VARCHAR(100) NOT NULL,	#出版社 
    `price` INT NOT NULL,					#价格 
    `nums` INT DEFAULT 100 NOT NULL		#库存 
);

DROP TABLE books;

ALTER TABLE books MODIFY name VARCHAR(100);
ALTER TABLE books MODIFY author VARCHAR(100);

INSERT INTO books VALUES(NULL,'java编程思想','Bruce Eckel','机械工业出版社',108,100);
INSERT INTO books VALUES(NULL,'java核心技术','Gray Cornell','机械工业出版社',139,100);
INSERT INTO books VALUES(NULL,'深入理解计算机系统','Randal E.Bryant','机械工业出版社',139,100);
INSERT INTO books VALUES(NULL,'计算机网络','谢希仁','电子工业出版社',39,100);
INSERT INTO books VALUES(NULL,'深入浅出MySql','唐汉明','人民邮电出版社',59,100);
INSERT INTO books VALUES(NULL,'算法','Robert Sedgewick','人民邮电出版社',99,100);
INSERT INTO books VALUES(NULL,'数据结构与算法分析','Mark Allen Weiss','机械工业出版社',35,100);

SELECT * FROM books;

create table orders
(
	id int auto_increment primary key,#订单编号 
    userId int references users(id),#下订单的用户编号constraint
    totalPrice int default 0 not null,#订单总价 
    orderDate datetime default now() not null#订单时间
);

insert into orders values(null,10,1200,now());
select * from orders;

create table ordersItem
(
	id int auto_increment primary key,	#增长的编号 
    ordersId int references orders(id),	#外键,指向orders表的订单号
    bookId int references books(id),	#书号是多少 
    bookNum int default 0 not null		#商品数量 
);
select * from ordersitem;
