update artcl
set text = 'this is a new text';
update artcl
set text = 'this is a new text with condition'
where user_id = (select id from userstbl where username = 'admin');