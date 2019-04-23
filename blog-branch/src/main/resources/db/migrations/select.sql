select *
from userstbl
where username = 'admin';
select *
from userstbl
where activation_code = (select activation_code from userstbl where username = 'admin');
select *
from artcl
where user_id = (select activation_code from userstbl where username = 'admin');
select *
from comment
where user_id = (select activation_code from userstbl where username = 'admin');
select count(*)
from userstbl;