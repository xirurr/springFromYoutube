delete from user_role;
delete from usr;

insert into usr(id,active,password,username,email) values
(4,true,'c4ca4238a0b923820dcc509a6f75849b','1','test@test.test'),
(5,true,'c4ca4238a0b923820dcc509a6f75849b','mike','test@test.test');

insert into user_role(user_id,roles) values
(4,'USER'),(4,'ADMIN'),(5,'USER');

