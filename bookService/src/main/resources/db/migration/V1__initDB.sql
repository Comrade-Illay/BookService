CREATE TABLE IF NOT EXISTS authors (
  author_id BIGSERIAL PRIMARY KEY,
  first_name VARCHAR(50),
  middle_name VARCHAR(50),
  last_name VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS publishers (
  publisher_id BIGSERIAL PRIMARY KEY,
  publisher_name VARCHAR(200),
  publisher_address VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS genres (
  genre_id BIGSERIAL PRIMARY KEY,
  genre_name VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS books (
  book_id BIGSERIAL PRIMARY KEY,
  title VARCHAR(200),
  total_pages INTEGER,
  rating NUMERIC(5,2),
  publishing_date TIMESTAMP,
  publisher_id BIGINT,
  FOREIGN KEY (publisher_id) REFERENCES publishers(publisher_id)
);

CREATE TABLE IF NOT EXISTS books_genres (
  book_id BIGINT,
  genre_id BIGINT,
  PRIMARY KEY (book_id, genre_id),
  CONSTRAINT fk_book FOREIGN KEY (book_id) REFERENCES books(book_id) ON DELETE CASCADE,
  CONSTRAINT fk_genre FOREIGN KEY (genre_id) REFERENCES genres(genre_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS books_authors(
  book_id BIGINT,
  author_id BIGINT,
  PRIMARY KEY (book_id, author_id),
  CONSTRAINT fk_book FOREIGN KEY (book_id) REFERENCES books(book_id) ON DELETE CASCADE,
  CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES authors(author_id) ON DELETE CASCADE
);

INSERT INTO authors (author_id, first_name, middle_name, last_name)
VALUES(1, 'Nick', 'Anderson', 'Smith');
INSERT INTO authors (author_id, first_name, middle_name, last_name)
VALUES(2, 'Mark', 'Delano', 'McArtur');
INSERT INTO authors (author_id, first_name, middle_name, last_name)
VALUES(3, 'Ashley', '', 'Nickel');
INSERT INTO authors (author_id, first_name, middle_name, last_name)
VALUES(4, 'Connor', '', 'Evans');
INSERT INTO authors (author_id, first_name, middle_name, last_name)
VALUES(5, 'John', 'Adam', 'Taylor');

INSERT INTO publishers (publisher_id, publisher_name, publisher_address)
VALUES(1, 'Publisher agency', 'Apple st. 1');
INSERT INTO publishers (publisher_id, publisher_name, publisher_address)
VALUES(2, 'City publishers', 'Middle st. 27');
INSERT INTO publishers (publisher_id, publisher_name, publisher_address)
VALUES(3, 'Authors agency', 'Marble av. 58');

INSERT INTO genres (genre_id, genre_name)
VALUES(1, 'Fantasy');
INSERT INTO genres (genre_id, genre_name)
VALUES(2, 'Science fiction');
INSERT INTO genres (genre_id, genre_name)
VALUES(3, 'Drama');
INSERT INTO genres (genre_id, genre_name)
VALUES(4, 'Mystery');
INSERT INTO genres (genre_id, genre_name)
VALUES(5, 'Romance');

INSERT INTO books ( book_id, title, total_pages, rating, publishing_date, publisher_id)
VALUES(1, 'Book of grudges', 544, 8.45, '2018-02-18', 1);
INSERT INTO books ( book_id, title, total_pages, rating, publishing_date, publisher_id)
VALUES(2, 'Big Ocean', 55, 8.00, '2018-02-18', 1);
INSERT INTO books ( book_id, title, total_pages, rating, publishing_date, publisher_id)
VALUES(3, 'Fan Story', 324, 5.45, '2018-02-18', 2);
INSERT INTO books ( book_id, title, total_pages, rating, publishing_date, publisher_id)
VALUES(4, 'History of one human', 145, 6.24, '2018-02-18', 3);
INSERT INTO books ( book_id, title, total_pages, rating, publishing_date, publisher_id)
VALUES(5, 'Everything about world', 621, 1.24, '2018-02-18', 3);

INSERT INTO books_genres ( book_id, genre_id)
VALUES(1,1);
INSERT INTO books_genres ( book_id, genre_id)
VALUES(1,5);
INSERT INTO books_genres ( book_id, genre_id)
VALUES(2,3);
INSERT INTO books_genres ( book_id, genre_id)
VALUES(3,4);
INSERT INTO books_genres ( book_id, genre_id)
VALUES(3,2);
INSERT INTO books_genres ( book_id, genre_id)
VALUES(4,1);
INSERT INTO books_genres ( book_id, genre_id)
VALUES(4,2);
INSERT INTO books_genres ( book_id, genre_id)
VALUES(4,3);
INSERT INTO books_genres ( book_id, genre_id)
VALUES(5,5);

INSERT INTO books_authors( book_id, author_id)
VALUES(1,1);
INSERT INTO books_authors( book_id, author_id)
VALUES(1,3);
INSERT INTO books_authors( book_id, author_id)
VALUES(2,2);
INSERT INTO books_authors( book_id, author_id)
VALUES(3,4);
INSERT INTO books_authors( book_id, author_id)
VALUES(4,5);
INSERT INTO books_authors( book_id, author_id)
VALUES(5,1);
