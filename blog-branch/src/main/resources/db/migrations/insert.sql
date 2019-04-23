

insert into user_role (role)
values ('ADMIN');
insert into user_role (role)
values ('USER');

insert into userstbl (activation_code, active, created_at, email, password, username, role_id)
values (1, true, '11/11/11', 'eml@', 'admin', 'admin',
        (select id from user_role where role = 'ADMIN')),
       (2, true, '12/12/12', 'eml2@', 'admin2', 'admin2',
        (select id from user_role where role = 'ADMIN'));



INSERT INTO artcl (created_at, status, text, title, updated_at, user_id)
VALUES ( '11/11/11', 'PUBLIC', 'text', 'title', '11/11/11',
         (select id from userstbl where username = 'admin')
       ),
       ( CURRENT_DATE, 'PUBLIC', 'texttexttexttexttexttexttexttext', 'title2', CURRENT_DATE,
         (select id from userstbl where username = 'admin2'));

insert into comment (created_at, message, article_id, user_id)
values ( CURRENT_DATE, 'message',
         (select id from artcl where title = 'title'),
         (select id from userstbl where username = 'admin2')),
       ( CURRENT_DATE, 'message2',
         (select id from artcl where title = 'title'),
         (select id from userstbl where username = 'admin2'));

insert into tag(name)
values ( 'tag name'), ('tag name 2');

insert into article_tag
values ((select id from artcl where title = 'title'),
        (select tag_id from tag where name = 'tag name'));