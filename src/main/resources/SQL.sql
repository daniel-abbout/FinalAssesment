
create
database pop;
       use
database pop;

           -- Create User table
CREATE TABLE User
(
    id       INT PRIMARY KEY,
    username VARCHAR(255),
    email    VARCHAR(255),
    password VARCHAR(255),
    role     VARCHAR(50) -- Assuming roles are represented as strings
);

-- Insert data into User table (sample data)
INSERT INTO User (id, username, email, password, role)
VALUES (1, 'user1', 'user1@example.com', 'password1', 'ADMIN'),
       (2, 'user2', 'user2@example.com', 'password2', 'USER');


-- Create Album table
CREATE TABLE Album
(
    id          INT PRIMARY KEY,
    userId      INT,
    title       VARCHAR(255),
    updatedDate TIMESTAMP,
    FOREIGN KEY (userId) REFERENCES User (id)
);
-- Insert data into Album table (sample data)
INSERT INTO Album (id, userId, title, updatedDate)
VALUES (1, 1, 'Album 1', '2024-04-21 10:00:00'),
       (2, 1, 'Album 2', '2024-04-20 12:00:00');
-- Create Photo table
CREATE TABLE Photo
(
    id           INT PRIMARY KEY,
    albumId      INT,
    title        VARCHAR(255),
    url          VARCHAR(255),
    thumbnailUrl VARCHAR(255),
    FOREIGN KEY (albumId) REFERENCES Album (id)
);


-- Insert data into Photo table (sample data)
INSERT INTO Photo (id, albumId, title, url, thumbnailUrl)
VALUES (1, 1, 'Photo 1', 'https://example.com/photo1.jpg', 'https://example.com/thumbnail1.jpg'),
       (2, 1, 'Photo 2', 'https://example.com/photo2.jpg', 'https://example.com/thumbnail2.jpg');




-- CREATE
-- DATABASE gallery;
-- use
-- gallery;
-- CREATE TABLE users
-- (
--     id         INT PRIMARY KEY,
--     name       VARCHAR(255),
--     username   VARCHAR(255),
--     email      VARCHAR(255),
--     address_id INT,
--     company_id INT,
--     phone      VARCHAR(40),
--     website    VARCHAR(255),
--     role       VARCHAR(255)
-- );
--
-- CREATE TABLE addresses
-- (
--     id      INT PRIMARY KEY,
--     user_id INT,
--     street  VARCHAR(255),
--     suite   VARCHAR(255),
--     city    VARCHAR(255),
--     zipcode VARCHAR(20),
--     lat     DECIMAL(9, 6),
--     lng     DECIMAL(9, 6),
--     FOREIGN KEY (user_id) REFERENCES users (id)
-- );
--
-- CREATE TABLE companies
-- (
--     id          INT,
--     name        VARCHAR(255),
--     catchPhrase VARCHAR(255),
--     bs          VARCHAR(255),
--     FOREIGN KEY (id) REFERENCES users (id)
-- );
--
-- INSERT INTO companies (id, name, catchPhrase, bs)
-- VALUES (1, 'Romaguera-Crona', 'Multi-layered client-server neural-net', 'harness real-time e-markets');
--
--
-- INSERT INTO users (id, name, username, email, address_id, company_id, phone, website, role)
-- VALUES (1, 'Leanne Graham', 'Bret', 'Sincere@april.biz', 1, 1, '1-770-736-8031 x56442', 'hildegard.org', 'ADMIN');
--
--
-- INSERT INTO addresses (id, user_id, street, suite, city, zipcode, lat, lng)
-- VALUES (1, 1, 'Kulas Light', 'Apt. 556', 'Gwenborough', '92998-3874', -37.3159, 81.1496);
--
--
-- CREATE TABLE albums
-- (
--     id      INT PRIMARY KEY,
--     user_id INT,
--     title   VARCHAR(255),
--     FOREIGN KEY (user_id) REFERENCES users (id)
-- );
--
--
-- INSERT INTO albums (id, user_id, title)
-- VALUES (1, 1, 'quidem molestiae enim');
--
--
-- CREATE TABLE photos
-- (
--     id            INT PRIMARY KEY,
--     album_id      INT,
--     title         VARCHAR(255),
--     url           VARCHAR(255),
--     thumbnail_url VARCHAR(255),
--     FOREIGN KEY (album_id) REFERENCES albums (id)
-- );
--
--
-- INSERT INTO photos (id, album_id, title, url, thumbnail_url)
-- VALUES (1, 1, 'accusamus beatae ad facilis cum similique qui sunt', 'https://via.placeholder.com/600/92c952',
--         'https://via.placeholder.com/150/92c952');
