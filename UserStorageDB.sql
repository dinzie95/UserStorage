create database UserData;
use UserData;
create table UserCredentials(
user_id int NOT NULL auto_increment primary key,
user_name varchar(50) NOT NULL,
email varchar(30) NOT NULL UNIQUE,
pwd varchar(10) NOT NULL,
created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

insert into UserCredentials(user_name,email,pwd) values("Dinithi Amarasinghe", "dinithi@gmail.com","123");
insert into UserCredentials(user_name,email,pwd) values("Sandun Silva", "sandun@gmail.com","1234");
insert into UserCredentials(user_name,email,pwd) values("Sam Smith", "sam@yahoo.com","1555");
insert into UserCredentials(user_name,email,pwd) values("Nimal Shantha", "nimal@yahoo.com","1234abc");
