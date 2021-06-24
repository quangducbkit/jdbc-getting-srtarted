use news_servlet2021;

insert into role(code,name) values('ADMIN','Administrator');
insert into role(code,name) values('USER','User');
insert into user(username,password,fullname,status,roleid) values('admin','123456','admin',1,1);
insert into user(username,password,fullname,status,roleid) values('Jame','123456','Wiliam Jame',1,2);
insert into user(username,password,fullname,status,roleid) values('Cristial','123456','Cristial Ronaldo',1,2);