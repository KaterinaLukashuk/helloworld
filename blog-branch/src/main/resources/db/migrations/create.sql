-- create database blog2;
--
-- \connect blog2;
--
--
-- CREATE USER admin1 WITH PASSWORD 'admin';
-- grant all privileges on database blog2 to admin1;

create table user_role
(
    id   bigserial    not null primary key,
    role varchar(255) null
);

create table userstbl
(
    id              bigserial    not null primary key,
    activation_code varchar(255) null,
    active          boolean      not null,
    created_at      date         null,
    email           varchar(255) not null,
    password        varchar(255) null,
    username        varchar(255) null unique,
    role_id         bigserial    not null REFERENCES user_role (id) on update cascade
);



-- create table user_role
-- (
--     user_id int not null,
--     roles   varchar(255) null,
--     FOREIGN KEY (user_id)
--         REFERENCES userstbl (id)
--         ON DELETE CASCADE
-- );

create type artcl_status as enum ('PUBLIC', 'DRAFT');

create table artcl
(
    id         bigserial    not null primary key,
    created_at date         null,
    status     artcl_status not null,
    text       text         null, --text
    title      varchar(255) null unique ,
    updated_at date         null,
    user_id    bigserial    not null,
    FOREIGN KEY (user_id)
        REFERENCES userstbl (id)
        ON DELETE CASCADE
    );

create table comment
(
    id         bigserial    not null primary key,
    created_at date         null,
    message    varchar(255) null,
    article_id bigserial    not null,
    user_id    bigserial    not null,
    FOREIGN KEY (user_id)
        REFERENCES userstbl (id)
        ON DELETE CASCADE,
    FOREIGN KEY (article_id)
        REFERENCES artcl (id)
        ON DELETE CASCADE
);



create table tag
(
    tag_id bigserial    not null
        primary key,
    name   varchar(255) null
);

create table article_tag
(
    article_id     bigserial not null REFERENCES artcl (id) ON UPDATE CASCADE ON DELETE CASCADE,
    tag_id bigserial not null REFERENCES tag (tag_id) ON UPDATE CASCADE ON DELETE CASCADE,
    primary key (article_id, tag_id)
);
create unique index USER_ID_INDEX on userstbl (id);
create unique index ARTICLE_ID_INDEX on artcl (id);
create unique index COMMENT_ID_INDEX on comment (id);
create unique index TAG_ID_INDEX on tag (tag_id);
