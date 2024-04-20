create table book
(
    id    BIGINT       not null primary key auto_increment,
    title VARCHAR(100) null,
    pages int          null
);

insert into book(title, pages)
values ('book1', 500),
       ('book2', 400),
       ('book3', 559),
       ('book4', 348);
