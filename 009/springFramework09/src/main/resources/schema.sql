drop table if exists authors;
create table authors(	id long not null auto_increment,
						name varchar(32) not null,
                        primary key(id));

drop table if exists genres;
create table genres(id long not null auto_increment,
					title varchar(32) not null,
                    primary key(id));

drop table if exists books;
create table books(	id long not null auto_increment,
					title varchar(32) not null,
					code varchar(32) not null,
                    author_id long,
                    genre_id long,
                    primary key(id),
                    constraint fk_books_authors foreign key(author_id) references authors(id),
                    constraint fk_books_genres foreign key(genre_id) references genres(id));

drop table if exists experiences;
create table experiences(id long not null auto_increment,
                      years int not null,
                      place varchar (32) not null,
                      author_id long,
                      primary key(id),
                      constraint fk_experience_authors foreign key(author_id) references authors(id));


create unique index unicNameAuthor on authors(name);
create unique index unicTitleBook on books(title);
create unique index unicTitleGenre on genres(title);