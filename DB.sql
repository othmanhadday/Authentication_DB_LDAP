-- MariaDB dump 10.17  Distrib 10.4.11-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: dbstageapp
-- ------------------------------------------------------
-- Server version	10.4.11-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permission` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` VALUES (17,'ROLE_DASHBOARD'),(18,'ROLE_APPS'),(19,'ROLE_INBOX'),(20,'ROLE_UIELEMENTS'),(21,'ROLE_ROLE_Forms');
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_app`
--

DROP TABLE IF EXISTS `role_app`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_app` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_app`
--

LOCK TABLES `role_app` WRITE;
/*!40000 ALTER TABLE `role_app` DISABLE KEYS */;
INSERT INTO `role_app` VALUES (8,'ROLE_ADMIN'),(9,'ROLE_USER'),(10,'ROLE_DEVELOPPER'),(11,'ROLE_ROLE_ROLE_Collaborateur');
/*!40000 ALTER TABLE `role_app` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_permissions`
--

DROP TABLE IF EXISTS `role_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_permissions` (
  `role_id` bigint(20) NOT NULL,
  `permision_id` bigint(20) NOT NULL,
  KEY `FK174i4n1ki104eg1xug01evxv2` (`permision_id`),
  KEY `FKm1y9ecnv8b8sj7e5tes87r4q0` (`role_id`),
  CONSTRAINT `FK174i4n1ki104eg1xug01evxv2` FOREIGN KEY (`permision_id`) REFERENCES `permission` (`id`),
  CONSTRAINT `FKm1y9ecnv8b8sj7e5tes87r4q0` FOREIGN KEY (`role_id`) REFERENCES `role_app` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_permissions`
--

LOCK TABLES `role_permissions` WRITE;
/*!40000 ALTER TABLE `role_permissions` DISABLE KEYS */;
INSERT INTO `role_permissions` VALUES (8,17),(8,19),(9,20),(10,18),(11,20),(11,21);
/*!40000 ALTER TABLE `role_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_app`
--

DROP TABLE IF EXISTS `user_app`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_app` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `activate` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_app`
--

LOCK TABLES `user_app` WRITE;
/*!40000 ALTER TABLE `user_app` DISABLE KEYS */;
INSERT INTO `user_app` VALUES (1,'Test','$2y$12$nT25C5v1c4/2ZcYOcz8SuuCUlJv57kbK5axhjuLxkJYmTHnC9shxy','oth@test.com','\0'),(2,'oth','$2a$10$j1BYN22x9B7v/29msf1gBeYW0DultrxxvsoIIG7qVoAQBOYLF2BBu','oth@oth.com','\0'),(3,'ismail','$2a$10$KcS4HrtSU4Eaa55P2srAxOOXpFbmY0awIyZCpFt4E8q.lsVth4Wca','ismail@test.com','\0'),(12,'ben ben','$2a$10$4xiNKNQQtsJXb0B5CRtcuOnVuJPxQLu8BiW22COC87CYpIccFjysG','ben','\0'),(13,'test','$2a$10$PgfVm2XlpjJFZ2n2wt8dI.Lw5Njb3vy/iRvnnn.WV1mPs90.EtOIu','test@test.com','');
/*!40000 ALTER TABLE `user_app` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_permissions`
--

DROP TABLE IF EXISTS `user_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_permissions` (
  `user_id` bigint(20) NOT NULL,
  `permision_id` bigint(20) NOT NULL,
  KEY `FKmcgorvvu92ognys2ar24ud2qe` (`permision_id`),
  KEY `FKd5omhi4kn9vmqgvpq6w0ug6by` (`user_id`),
  CONSTRAINT `FKd5omhi4kn9vmqgvpq6w0ug6by` FOREIGN KEY (`user_id`) REFERENCES `user_app` (`id`),
  CONSTRAINT `FKmcgorvvu92ognys2ar24ud2qe` FOREIGN KEY (`permision_id`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_permissions`
--

LOCK TABLES `user_permissions` WRITE;
/*!40000 ALTER TABLE `user_permissions` DISABLE KEYS */;
INSERT INTO `user_permissions` VALUES (1,19),(2,19),(2,20),(3,17),(12,17),(12,18),(13,17),(13,18),(13,19);
/*!40000 ALTER TABLE `user_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FK8wfy6e06ixr47r74umfeoo3tj` (`role_id`),
  KEY `FKnycroxxikom02k0lxo2vatn8j` (`user_id`),
  CONSTRAINT `FK8wfy6e06ixr47r74umfeoo3tj` FOREIGN KEY (`role_id`) REFERENCES `role_app` (`id`),
  CONSTRAINT `FKnycroxxikom02k0lxo2vatn8j` FOREIGN KEY (`user_id`) REFERENCES `user_app` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,8),(2,9),(3,9),(12,9),(13,10);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-08 16:29:30
