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
-- Table structure for table `alumnosxcurso`
--

DROP TABLE IF EXISTS `alumnosxcurso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumnosxcurso` (
  `idAlumnosxcurso` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(45) DEFAULT NULL,
  `parcial1` double DEFAULT NULL,
  `parcial2` double DEFAULT NULL,
  `recuperatorio1` double DEFAULT NULL,
  `recuperatorio2` double DEFAULT NULL,
  `idCurso` int(11) NOT NULL,
  `idAlumno` int(11) NOT NULL,
  PRIMARY KEY (`idAlumnosxcurso`,`idCurso`,`idAlumno`),
  KEY `FK_id_curso_cursos` (`idCurso`),
  KEY `FK_idAlumno_Alumnos` (`idAlumno`),
  CONSTRAINT `FK_idAlumno_Alumnos` FOREIGN KEY (`idAlumno`) REFERENCES `alumnos` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_id_curso_cursos` FOREIGN KEY (`idCurso`) REFERENCES `cursos` (`idCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnosxcurso`
--

LOCK TABLES `alumnosxcurso` WRITE;
/*!40000 ALTER TABLE `alumnosxcurso` DISABLE KEYS */;
INSERT INTO `alumnosxcurso` VALUES (1,'regular',7,7,NULL,NULL,1,1),(2,'regular',8,8,NULL,NULL,2,2),(3,'regular',1,8,7,NULL,3,3),(4,'libre',5,5,9,9,4,4),(5,'libre',7,7,NULL,NULL,1,2),(6,'regular',NULL,NULL,NULL,NULL,2,1),(7,'regular',7,7,NULL,NULL,3,2),(8,'regular',8,8,NULL,NULL,4,3),(9,'regular',7,7,NULL,NULL,5,5),(10,'regular',5,5,10,10,6,6),(11,NULL,NULL,NULL,NULL,NULL,1,7),(12,NULL,NULL,NULL,NULL,NULL,2,8),(13,NULL,NULL,NULL,NULL,NULL,1,9),(14,NULL,NULL,NULL,NULL,NULL,2,10),(15,NULL,NULL,NULL,NULL,NULL,1,11);
/*!40000 ALTER TABLE `alumnosxcurso` ENABLE KEYS */;
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
