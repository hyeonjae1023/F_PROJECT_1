/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 10.4.28-MariaDB : Database - my_first_project
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`my_first_project` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `my_first_project`;

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `loginId` char(100) NOT NULL,
  `Email` char(100) NOT NULL,
  `nickName` char(100) NOT NULL,
  `loginPw` char(100) NOT NULL,
  `name` char(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `loginId` (`loginId`),
  UNIQUE KEY `Email` (`Email`),
  UNIQUE KEY `nickName` (`nickName`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `member` */

insert  into `member`(`id`,`regDate`,`updateDate`,`loginId`,`Email`,`nickName`,`loginPw`,`name`) values 
(1,'2023-07-24 21:40:14','2023-07-24 21:40:14','admin','admin','신동우','admin','관리자'),
(2,'2023-07-24 21:40:17','2023-07-24 21:40:17','user1','user1','돼지','user1','유저1');

/*Table structure for table `movieArticle` */

DROP TABLE IF EXISTS `movieArticle`;

CREATE TABLE `movieArticle` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `title` char(100) NOT NULL,
  `body` char(100) NOT NULL,
  `memberId` int(1) unsigned NOT NULL,
  `boardId` int(1) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `boardId` (`boardId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `movieArticle` */

insert  into `movieArticle`(`id`,`regDate`,`updateDate`,`title`,`body`,`memberId`,`boardId`) values 
(1,'2023-07-24 21:40:02','2023-07-24 21:40:02','미션 임파서블 : 데드 레코닝','',1,1),
(2,'2023-07-24 21:40:02','2023-07-24 21:40:02','엘리멘탈','',2,2),
(3,'2023-07-24 21:40:02','2023-07-24 21:40:02','여름날 우리','',3,3),
(4,'2023-07-24 21:40:02','2023-07-24 21:40:02','명탐정 코난 : 흑철의 어영','',4,4),
(5,'2023-07-24 21:40:02','2023-07-24 21:40:02','인시디어스 : 빨간 문','',5,5),
(6,'2023-07-24 21:40:02','2023-07-24 21:40:02','범죄도시3','',6,6);

/*Table structure for table `review` */

DROP TABLE IF EXISTS `review`;

CREATE TABLE `review` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `title` char(100) NOT NULL,
  `body` char(100) NOT NULL,
  `boardId` int(1) unsigned NOT NULL,
  `name` char(100) NOT NULL,
  `grades` float(10,1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `review` */

insert  into `review`(`id`,`regDate`,`updateDate`,`title`,`body`,`boardId`,`name`,`grades`) values 
(1,'2023-07-24 21:40:28','2023-07-24 22:11:36','재밌었어요','dksf  dfssdf',1,'홍길동',3.6),
(2,'2023-07-24 21:40:31','2023-07-24 22:13:17','꼭 보세요 진짜 감동이에요ㅠㅠ','tldf eeee',2,'홍길동',5.9),
(3,'2023-07-24 21:40:52','2023-07-24 22:22:56','재밌었어요','보드아이디가 뭔가요',3,'신동우',3.2),
(4,'2023-07-24 21:40:54','2023-07-24 21:40:54','낫밷','존나 재미없어요ㅋㅋ',4,'신동우',3.1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
