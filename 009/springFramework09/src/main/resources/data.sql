insert into authors (name) values ('Arthur_Conan_Doyle');
insert into authors (name) values ('Agatha_Christie');
insert into authors (name) values ('Luc_Besson');
insert into authors (name) values ('Christie_Golden');
commit;

insert into genres (title) values ('detective');
insert into genres (title) values ('science fiction novel');
insert into genres (title) values ('adventures');
insert into genres (title) values ('fantasy');
commit;

insert into books (title, code, author_id, genre_id) values ( 'Sherlock Holmes', '978-5-907120-60-0','1','1');
insert into books (title, code, author_id, genre_id) values ( 'Professor Challenger', '978-5-8475-1121-6', '1','1');
insert into books (title, code, author_id, genre_id) values ( 'Murder on the Orient Express', '978-5-04-098115-1','2','1');
insert into books (title, code, author_id, genre_id) values ( 'Ten Little Niggers', ' 978-5-9925-0837-6','2','1');
insert into books (title, code, author_id, genre_id) values ( 'Poirot Investigates', '978-5-04-107820-1','2','2');
insert into books (title, code, author_id, genre_id) values ( 'Arthur and minimoys', '978-90225-43-009','3','3');
insert into books (title, code, author_id, genre_id) values ( 'World of Warcraft', '978-5-17-112285-0','4','4');
commit;

insert into experiences (years, place, author_id) values('25', 'book store','2');
insert into experiences (years, place, author_id) values('2','assistant writer','4');
insert into experiences (years, place, author_id) values('5','navigator','1');
commit;