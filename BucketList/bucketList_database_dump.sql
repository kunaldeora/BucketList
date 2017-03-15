-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: bucketlist
-- ------------------------------------------------------
-- Server version	5.6.26-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adventure_master`
--

DROP TABLE IF EXISTS `adventure_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adventure_master` (
  `adventureID` int(11) NOT NULL AUTO_INCREMENT,
  `adventureName` varchar(255) DEFAULT NULL,
  `typeOfAdventure` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`adventureID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adventure_master`
--

LOCK TABLES `adventure_master` WRITE;
/*!40000 ALTER TABLE `adventure_master` DISABLE KEYS */;
INSERT INTO `adventure_master` VALUES (1,'skyd','sports'),(2,'bungee','sports'),(3,'riverraft','adventures'),(4,'bull fight','events'),(5,'gun powder','sports'),(6,'rock climbing','adventures'),(7,'kill bill','events'),(9,'kayaking','sports'),(10,'trecking','adventures'),(11,',riverraft','sports'),(12,',gun powder','events'),(13,',bungee','sports'),(14,'Paraglyding','sports'),(15,',skyd',NULL),(16,'',NULL),(17,'',NULL),(18,'',NULL),(19,'',NULL),(20,',rock climbing','sports'),(21,'Snow Skying,skyd,skyd',NULL),(22,'Rolling in the deep,skyd','events'),(23,',bull fight','sports'),(24,'Payal','adventures');
/*!40000 ALTER TABLE `adventure_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adventurer_master`
--

DROP TABLE IF EXISTS `adventurer_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adventurer_master` (
  `aboutMe` varchar(255) DEFAULT NULL,
  `completed_journeys` int(11) DEFAULT NULL,
  `personID` int(11) NOT NULL,
  `location_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`personID`),
  KEY `FKh9dclqt81nyoaxbn0p1kcsn5m` (`location_id`),
  CONSTRAINT `FKh9dclqt81nyoaxbn0p1kcsn5m` FOREIGN KEY (`location_id`) REFERENCES `location` (`locationId`),
  CONSTRAINT `FKim9ipq7y35t1tifqqymacfkdb` FOREIGN KEY (`personID`) REFERENCES `person` (`personID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adventurer_master`
--

LOCK TABLES `adventurer_master` WRITE;
/*!40000 ALTER TABLE `adventurer_master` DISABLE KEYS */;
INSERT INTO `adventurer_master` VALUES (NULL,0,1,2),(NULL,0,4,3),(NULL,0,5,2);
/*!40000 ALTER TABLE `adventurer_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `advertisement_master`
--

DROP TABLE IF EXISTS `advertisement_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `advertisement_master` (
  `advertID` int(11) NOT NULL AUTO_INCREMENT,
  `date_of_event` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `adventure_id` int(11) DEFAULT NULL,
  `organizer_id` int(11) DEFAULT NULL,
  `content` longblob,
  `image_name` varchar(255) DEFAULT NULL,
  `available_tickets` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`advertID`),
  KEY `FK1bb5e31iahs61e7fnem5r422t` (`adventure_id`),
  KEY `FK1unem0igxj82ndyk2vlrmpn41` (`organizer_id`),
  CONSTRAINT `FK1bb5e31iahs61e7fnem5r422t` FOREIGN KEY (`adventure_id`) REFERENCES `adventure_master` (`adventureID`),
  CONSTRAINT `FK1unem0igxj82ndyk2vlrmpn41` FOREIGN KEY (`organizer_id`) REFERENCES `organizer` (`personID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advertisement_master`
--

LOCK TABLES `advertisement_master` WRITE;
/*!40000 ALTER TABLE `advertisement_master` DISABLE KEYS */;
INSERT INTO `advertisement_master` VALUES (1,'kjhkjh','Sky didi','kjhkjh',1,3,NULL,NULL,4,33,'resources/images/adventure1.jpg'),(2,'12 April','Gun Shooting','Come with your gun',12,3,NULL,NULL,6,22,'resources/images/logintest.jpg'),(3,'hkjhkj','Boston Running','message',6,3,NULL,NULL,22,12,NULL),(4,'23 April','Bungeee jumping in bsoton','Dar ke aage jeet hai',2,3,NULL,NULL,19,80,NULL),(5,'15 April','Sky diving in boston','COme',1,6,NULL,NULL,7,45,NULL),(6,'16 may','Bull fight','Wrestling match',4,6,NULL,NULL,13,45,NULL),(7,'16 june','Paraglying in boston','Dar ke aage jeet hai',14,6,NULL,NULL,17,300,NULL),(8,'ljkljlk','Best Payal in market','jlkj',24,6,NULL,NULL,1,7,'resources/images/adventure4.jpg');
/*!40000 ALTER TABLE `advertisement_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bucketlist_master`
--

DROP TABLE IF EXISTS `bucketlist_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bucketlist_master` (
  `bestTime` varchar(255) DEFAULT NULL,
  `DateCompleted` varchar(255) DEFAULT NULL,
  `expected_expense` double DEFAULT NULL,
  `feedback` varchar(255) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT 'N',
  `adventurer_id` int(11) NOT NULL,
  `adventure_id` int(11) NOT NULL,
  PRIMARY KEY (`adventurer_id`,`adventure_id`),
  KEY `FKkvja1pm1tytk1ju326qax0cm6` (`adventure_id`),
  CONSTRAINT `FKhnir7i0wxt9h9eeivcoitij71` FOREIGN KEY (`adventurer_id`) REFERENCES `adventurer_master` (`personID`),
  CONSTRAINT `FKkvja1pm1tytk1ju326qax0cm6` FOREIGN KEY (`adventure_id`) REFERENCES `adventure_master` (`adventureID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bucketlist_master`
--

LOCK TABLES `bucketlist_master` WRITE;
/*!40000 ALTER TABLE `bucketlist_master` DISABLE KEYS */;
INSERT INTO `bucketlist_master` VALUES ('hkj','hkjh',3,'hkjh',222,'Y',1,1),('gjh','gg',33,'jkhgj',33,'Y',1,12),('Fall','31 july',23,'Take warm clothes with you',6,'Y',1,14),(NULL,NULL,0,NULL,0,NULL,1,15),(NULL,NULL,0,NULL,0,NULL,1,16),(NULL,NULL,0,NULL,0,NULL,1,17),(NULL,NULL,0,NULL,0,NULL,1,18),(NULL,NULL,0,NULL,0,NULL,1,19),(NULL,NULL,0,NULL,0,NULL,5,20),('winters','16 april',62,'Best experience ever !!!',5,'Y',5,21),(NULL,NULL,0,NULL,0,NULL,5,22),(NULL,NULL,0,NULL,0,NULL,5,23),(NULL,NULL,0,NULL,0,NULL,5,24);
/*!40000 ALTER TABLE `bucketlist_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `locationId` int(11) NOT NULL AUTO_INCREMENT,
  `locationName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`locationId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'jaipur'),(2,'boston'),(3,'texas');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location_adventure_master`
--

DROP TABLE IF EXISTS `location_adventure_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location_adventure_master` (
  `locationId` int(11) NOT NULL,
  `adventureID` int(11) NOT NULL,
  PRIMARY KEY (`locationId`,`adventureID`),
  KEY `FKibx75wsnomj9nionhbgme30x3` (`adventureID`),
  CONSTRAINT `FK34rs7jcljukkwsrwss7bao77p` FOREIGN KEY (`locationId`) REFERENCES `location` (`locationId`),
  CONSTRAINT `FKibx75wsnomj9nionhbgme30x3` FOREIGN KEY (`adventureID`) REFERENCES `adventure_master` (`adventureID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location_adventure_master`
--

LOCK TABLES `location_adventure_master` WRITE;
/*!40000 ALTER TABLE `location_adventure_master` DISABLE KEYS */;
INSERT INTO `location_adventure_master` VALUES (1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,9),(1,10),(1,11),(1,12),(1,13),(2,14),(2,15),(2,16),(2,17),(2,18),(2,19),(2,20),(2,21),(2,22),(2,23),(2,24);
/*!40000 ALTER TABLE `location_adventure_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `orderID` int(11) NOT NULL AUTO_INCREMENT,
  `orderDate` date DEFAULT NULL,
  `adventurer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderID`),
  KEY `FKf606a8uig9bwvs19v33jf6ijp` (`adventurer_id`),
  CONSTRAINT `FKf606a8uig9bwvs19v33jf6ijp` FOREIGN KEY (`adventurer_id`) REFERENCES `adventurer_master` (`personID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordersitems`
--

DROP TABLE IF EXISTS `ordersitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordersitems` (
  `advertId` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`advertId`),
  KEY `FKg5w7es0xtnnjhwbgk0k0xx1dj` (`order_id`),
  CONSTRAINT `FKg5w7es0xtnnjhwbgk0k0xx1dj` FOREIGN KEY (`order_id`) REFERENCES `orders` (`orderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordersitems`
--

LOCK TABLES `ordersitems` WRITE;
/*!40000 ALTER TABLE `ordersitems` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordersitems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organizer`
--

DROP TABLE IF EXISTS `organizer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organizer` (
  `about_organization` varchar(255) DEFAULT NULL,
  `number_of_events` int(11) DEFAULT NULL,
  `personID` int(11) NOT NULL,
  `location_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`personID`),
  KEY `FKmp3eu2xi0g5cf05r5ub8ex5c1` (`location_id`),
  CONSTRAINT `FKmp3eu2xi0g5cf05r5ub8ex5c1` FOREIGN KEY (`location_id`) REFERENCES `location` (`locationId`),
  CONSTRAINT `FKpudiqw2b5fjcf7x1ppqxm91qd` FOREIGN KEY (`personID`) REFERENCES `person` (`personID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organizer`
--

LOCK TABLES `organizer` WRITE;
/*!40000 ALTER TABLE `organizer` DISABLE KEYS */;
INSERT INTO `organizer` VALUES (NULL,0,2,2),(NULL,0,3,2),(NULL,0,6,2);
/*!40000 ALTER TABLE `organizer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `personID` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`personID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'avi','laddha'),(2,'madhu','laddha'),(3,'manasi','laddha'),(4,'Kunal','Deora'),(5,'Vasanti','mahajan'),(6,'Neelesh','Saxena');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_master`
--

DROP TABLE IF EXISTS `ticket_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket_master` (
  `ticketID` int(11) NOT NULL AUTO_INCREMENT,
  `Owned_by` int(11) DEFAULT NULL,
  `date_of_event` varchar(30) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `advertisement_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ticketID`),
  KEY `FKnfken94mq51v6wdqupohv799e` (`advertisement_id`),
  CONSTRAINT `FKnfken94mq51v6wdqupohv799e` FOREIGN KEY (`advertisement_id`) REFERENCES `advertisement_master` (`advertID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_master`
--

LOCK TABLES `ticket_master` WRITE;
/*!40000 ALTER TABLE `ticket_master` DISABLE KEYS */;
INSERT INTO `ticket_master` VALUES (1,1,'12 April',34,1,'Purchased',2),(2,1,'12 April',67,1,'Purchased',2),(3,1,'kjhkjh',23,1,'Purchased',1),(4,1,'12 April',78,1,'Purchased',2),(5,1,'kjhkjh',88,1,'Purchased',1),(6,1,'kjhkjh',77,1,'Purchased',1),(7,1,'kjhkjh',99,1,'Purchased',1),(8,1,'12 April',47,1,'Purchased',2),(9,1,'12 April',87,1,'Purchased',2),(10,1,'12 April',12,1,'Purchased',2),(11,1,'kjhkjh',23,1,'Purchased',1),(12,1,'kjhkjh',87,1,'Purchased',1),(13,1,'kjhkjh',33,1,'Purchased',1),(14,1,'kjhkjh',33,1,'Purchased',1),(15,1,'12 April',22,1,'Purchased',2),(16,5,'ljkljlk',7,1,'Purchased',8),(17,5,'ljkljlk',7,1,'Purchased',8),(18,5,'ljkljlk',7,1,'Purchased',8);
/*!40000 ALTER TABLE `ticket_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useraccount_master`
--

DROP TABLE IF EXISTS `useraccount_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useraccount_master` (
  `userAccountid` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `type_of_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userAccountid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useraccount_master`
--

LOCK TABLES `useraccount_master` WRITE;
/*!40000 ALTER TABLE `useraccount_master` DISABLE KEYS */;
INSERT INTO `useraccount_master` VALUES (1,'avi@gmail.com','avi123','Adventurer'),(2,'madhu@gmail.com','m123','Organizer'),(3,'m@gmail.com','m123','Organizer'),(4,'kunal.deora@gmail.com','kunal','Adventurer'),(5,'v@gmail.com','vasanti','Adventurer'),(6,'neelu@email.com','neelu','Organizer');
/*!40000 ALTER TABLE `useraccount_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'bucketlist'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-26  8:41:44
