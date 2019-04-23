alter table userstbl
    add column new_column varchar(30) null;
alter table userstbl
    alter column new_column set data type varchar(50);
update userstbl
set new_column = '123';
alter table userstbl
    alter column new_column set not null;
alter table userstbl
    drop new_column;