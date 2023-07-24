# 데이터베이스 삭제/생성/선택
DROP DATABASE IF EXISTS my_first_project;
CREATE DATABASE my_first_project;

USE my_first_project;

CREATE TABLE movieArticle (
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	title CHAR(100) NOT NULL,
	`body` CHAR(100) NOT NULL,
	memberId INT(1) UNSIGNED NOT NULL,
	boardId INT(1) UNSIGNED NOT NULL,
	INDEX boardId (`boardId`)
);

SELECT * FROM movieArticle;

INSERT INTO movieArticle
SET regDate = NOW(),
updateDate = NOW(),
title = '미션 임파서블 : 데드 레코닝',
`body` = '',
memberId = 1,
boardId = 1;

INSERT INTO movieArticle
SET regDate = NOW(),
updateDate = NOW(),
title = '엘리멘탈',
`body` = '',
memberId = 2,
boardId = 2;

INSERT INTO movieArticle
SET regDate = NOW(),
updateDate = NOW(),
title = '여름날 우리',
`body` = '',
memberId = 3,
boardId = 3;

INSERT INTO movieArticle
SET regDate = NOW(),
updateDate = NOW(),
title = '명탐정 코난 : 흑철의 어영',
`body` = '',
memberId = 4,
boardId = 4;

INSERT INTO movieArticle
SET regDate = NOW(),
updateDate = NOW(),
title = '인시디어스 : 빨간 문',
`body` = '',
memberId = 5,
boardId = 5;

INSERT INTO movieArticle
SET regDate = NOW(),
updateDate = NOW(),
title = '범죄도시3',
`body` = '',
memberId = 6,
boardId = 6;

SELECT * FROM movieArticle;

CREATE TABLE `member` (
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	loginId CHAR(100) NOT NULL UNIQUE,
	Email CHAR(100) NOT NULL UNIQUE,
	nickName CHAR(100) NOT NULL UNIQUE,
	loginPw CHAR(100) NOT NULL,
	`name` CHAR(100) NOT NULL
);

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'admin',
loginPw = 'admin',
Email = 'admin',
nickName = '신동우',
`name` = '관리자';

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'user1',
loginPw = 'user1',
Email = 'user1',
nickName = '돼지',
`name` = '유저1';

SELECT * FROM `member`;

CREATE TABLE review (
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	title CHAR(100) NOT NULL,
	`body` CHAR(100) NOT NULL,
	boardId INT(1) UNSIGNED NOT NULL,
	`name` CHAR(100) NOT NULL,
	grades FLOAT(10, 1) NOT NULL
);

INSERT INTO review
SET regDate = NOW(),
updateDate = NOW(),
title = '재밌었어요',
`body` = '오늘 범죄도시3 보고 왔는데, 너무 재밌었어요',
boardId = 1,
`name` = '홍길동',
grades = 1.8;

INSERT INTO review
SET regDate = NOW(),
updateDate = NOW(),
title = '꼭 보세요 진짜 감동이에요ㅠㅠ',
`body` = '엘리멘탈 진짜 최고ㅠㅠㅠㅠ',
boardId = 2,
`name` = '홍길동',
grades = 4.8;

INSERT INTO review
SET regDate = NOW(),
updateDate = NOW(),
title = '재밌었어요',
`body` = '존나 재미없어요',
boardId = 3,
`name` = '신동우',
grades = 2.5;

INSERT INTO review
SET regDate = NOW(),
updateDate = NOW(),
title = '낫밷',
`body` = '존나 재미없어요ㅋㅋ',
boardId = 4,
`name` = '신동우',
grades = 3.1;

SELECT * FROM review;

CREATE TABLE seat (
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	title CHAR(100) NOT NULL,
);


INSERT INTO seats (regDate, title) VALUES (NOW(), 'a1');

SELECT * FROM seat;
