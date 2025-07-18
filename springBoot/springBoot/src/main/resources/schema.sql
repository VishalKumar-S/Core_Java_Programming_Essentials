drop table if exists "books";
drop table if exists "author" CASCADE;





 CREATE TABLE "author"(
  "author_id" integer primary key,
  "name" text,
  "age" integer
);


CREATE TABLE "books" (
    "isbn" text primary key,
    "title" text,
    "author_id" integer,
    CONSTRAINT fk_author
    FOREIGN KEY (author_id) REFERENCES author(author_id)
    );




