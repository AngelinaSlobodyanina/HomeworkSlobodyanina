DROP TABLE IF EXISTS AUTHORS;

CREATE TABLE AUTHORS (
  id   int auto_increment,
  name varchar(255),

  primary key (id)
);

DROP TABLE IF EXISTS BOOKS;

CREATE TABLE BOOKS (
  id    int auto_increment,
  title varchar(255),
  code varchar(40),

  unique (code),
  primary key (id)
);

DROP TABLE IF EXISTS GENRES;

CREATE TABLE GENRES(
  id    int auto_increment,
  title varchar(255),

  primary key (id)
);

DROP TABLE IF EXISTS GENRES_OF_BOOK;

CREATE TABLE GENRES_OF_BOOK (
  id      int auto_increment,
  bookId  int,
  genreId int,

  primary key (id),
  foreign key (genreId) references GENRES (id),
  foreign key (bookId) references BOOKS (id)
);

DROP TABLE IF EXISTS AUTHORS_OF_BOOK;

CREATE TABLE AUTHORS_OF_BOOK (
  id      int auto_increment,
  bookId  int,
  authorId int,

  primary key (id),
  foreign key (authorId) references AUTHORS (id),
  foreign key (bookId) references BOOKS (id)
);
