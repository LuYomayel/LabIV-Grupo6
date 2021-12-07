-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dbunt2
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `materiasxcarrera`
--

DROP TABLE IF EXISTS `materiasxcarrera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materiasxcarrera` (
  `idMateriasxCarrera` int(11) NOT NULL AUTO_INCREMENT,
  `idCarrera_Mat` int(11) NOT NULL,
  `IdMateria_Mat` int(11) NOT NULL,
  PRIMARY KEY (`idMateriasxCarrera`),
  KEY `FK_MateriasxCarrera_Mat_idx` (`IdMateria_Mat`),
  CONSTRAINT `FK_MateriasxCarrera_Mat` FOREIGN KEY (`IdMateria_Mat`) REFERENCES `materias` (`idMateria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materiasxcarrera`
--

LOCK TABLES `materiasxcarrera` WRITE;
/*!40000 ALTER TABLE `materiasxcarrera` DISABLE KEYS */;
INSERT INTO `materiasxcarrera` VALUES (1,1,1),(2,2,1),(3,1,2),(4,1,3),(5,11,5),(6,12,5),(7,11,6),(8,11,7),(9,3,8),(10,4,8),(11,3,9),(12,3,10),(13,7,13),(14,6,13),(15,7,15);
/*!40000 ALTER TABLE `materiasxcarrera` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-06 12:42:46
