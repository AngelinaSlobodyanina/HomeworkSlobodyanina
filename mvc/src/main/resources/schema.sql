drop table if exists authors;
create table authors(	id long not null auto_increment,
						firstname varchar(32) not null,
						lastname varchar(32) not null,
                        primary key(id));
drop table if exists books;
create table books (
  id    long not null auto_increment,
  title varchar(255) not null,
  code varchar(40) not null,
  primary key (id)
);