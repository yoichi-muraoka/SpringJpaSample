CREATE DATABASE mydb
	CHARACTER SET utf8mb4
	COLLATE utf8mb4_general_ci;

USE mydb;

CREATE TABLE member_types (
	id INT PRIMARY KEY,
	name VARCHAR(30) NOT NULL
);

INSERT INTO member_types VALUES
	(1, 'Normal Member'),
	(2, 'Premium Member');

CREATE TABLE members (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(30) NOT NULL,
	age INT,
	address VARCHAR(100),
	type_id INT NOT NULL,
	created DATETIME NOT NULL
);

INSERT INTO members VALUES 
	(1, 'Noboru Asahi', 25, 'Tokyo, Japan', 1, NOW()),
	(2, 'Minako Nakanishi', 31, 'Aichi, Japan', 2, NOW()),
	(3, 'Joe Murakami', 22, 'Christchurch, New Zealand', 1, NOW()),
	(4, 'Saki Miyamoto', 34, 'Sydney, Australia', 2, NOW()),
	(5, 'Nicky Okazaki', 28, 'London, U.K.',2, NOW());
