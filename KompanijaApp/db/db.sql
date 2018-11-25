/*
SQLyog Ultimate v9.50 
MySQL - 5.6.20 : Database - prosoft18
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prosoft18` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `prosoft18`;

/*Table structure for table `kompanija` */

DROP TABLE IF EXISTS `kompanija`;

CREATE TABLE `kompanija` (
  `kompanijaID` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) DEFAULT NULL,
  `maticniBroj` varchar(8) DEFAULT NULL,
  `ulica` varchar(100) DEFAULT NULL,
  `broj` varchar(50) DEFAULT NULL,
  `ptt` int(11) DEFAULT NULL,
  PRIMARY KEY (`kompanijaID`),
  KEY `ptt` (`ptt`),
  CONSTRAINT `kompanija_ibfk_2` FOREIGN KEY (`ptt`) REFERENCES `mesto` (`ptt`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `kompanija` */

insert  into `kompanija`(`kompanijaID`,`naziv`,`maticniBroj`,`ulica`,`broj`,`ptt`) values (1,'FON','07004044','Jove Ilica','154',11000);

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `ptt` int(11) NOT NULL,
  `naziv` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ptt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mesto` */

insert  into `mesto`(`ptt`,`naziv`) values (11000,'Beograd'),(17000,'Vranje'),(18000,'Nis'),(21000,'Novi Sad'),(34000,'Kragujevac');

/*Table structure for table `proizvod` */

DROP TABLE IF EXISTS `proizvod`;

CREATE TABLE `proizvod` (
  `proizvodID` int(11) NOT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  `cena` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`proizvodID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `proizvod` */

/*Table structure for table `racun` */

DROP TABLE IF EXISTS `racun`;

CREATE TABLE `racun` (
  `racunID` int(11) NOT NULL,
  `datum` date DEFAULT NULL,
  `ukupanIznos` decimal(10,2) DEFAULT NULL,
  `kompanijaID` int(11) DEFAULT NULL,
  PRIMARY KEY (`racunID`),
  KEY `kompanijaID` (`kompanijaID`),
  CONSTRAINT `racun_ibfk_1` FOREIGN KEY (`kompanijaID`) REFERENCES `kompanija` (`kompanijaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `racun` */

/*Table structure for table `stavkaracuna` */

DROP TABLE IF EXISTS `stavkaracuna`;

CREATE TABLE `stavkaracuna` (
  `racunID` int(11) NOT NULL,
  `rb` int(11) NOT NULL,
  `kolicina` int(11) DEFAULT NULL,
  `iznos` decimal(10,2) DEFAULT NULL,
  `proizvodID` int(11) DEFAULT NULL,
  `jedinicaMere` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`racunID`,`rb`),
  KEY `proizvodID` (`proizvodID`),
  CONSTRAINT `stavkaracuna_ibfk_1` FOREIGN KEY (`racunID`) REFERENCES `racun` (`racunID`),
  CONSTRAINT `stavkaracuna_ibfk_2` FOREIGN KEY (`proizvodID`) REFERENCES `proizvod` (`proizvodID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stavkaracuna` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
