delete from message;
delete from hibernate_sequence;

insert into message(id,text,tag,user_id) values
(1, 'first', 'my-tag', 4),
(2, 'second', 'not-my-tag', 4),
(3, 'third', 'my-tag', 4),
(4, 'forth', 'more', 4);

insert into hibernate_sequence values (40);
