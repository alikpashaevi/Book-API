-- Author Table
CREATE TABLE practice_project_db.author (
    id BIGINT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    bio TEXT
);

-- Book Table
CREATE TABLE practice_project_db.book (
  id BIGINT PRIMARY KEY,
  title VARCHAR(150) NOT NULL,
  description TEXT,
  author_id INTEGER NOT NULL,
  CONSTRAINT fk_book_author FOREIGN KEY (author_id) REFERENCES author(id) ON DELETE CASCADE
);

-- Review Table
CREATE TABLE practice_project_db.review (
    id BIGINT PRIMARY KEY,
    reviewer_name VARCHAR(100),
    rating INTEGER NOT NULL CHECK (rating BETWEEN 1 AND 5),
    comment TEXT,
    book_id INTEGER NOT NULL,
    CONSTRAINT fk_review_book FOREIGN KEY (book_id) REFERENCES book(id) ON DELETE CASCADE
);

CREATE SEQUENCE practice_project_db.author_id_seq
    INCREMENT 1
    START 1000;

CREATE SEQUENCE practice_project_db.book_id_seq
    INCREMENT 1
    START 1000;

CREATE SEQUENCE practice_project_db.review_id_seq
    INCREMENT 1
    START 1000;