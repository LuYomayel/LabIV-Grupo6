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
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cursos` (
  `idCurso` int(11) NOT NULL AUTO_INCREMENT,
  `idMateria` int(11) NOT NULL,
  `Descripcion_curso` varchar(45) DEFAULT NULL,
  `Semestre` int(11) DEFAULT NULL,
  `Año` int(11) DEFAULT NULL,
  `idDocente` int(11) NOT NULL,
  PRIMARY KEY (`idCurso`),
  KEY `FK_idMateria_Materia` (`idMateria`),
  KEY `FK_idDocente_docente` (`idDocente`),
  CONSTRAINT `FK_idDocente_docente` FOREIGN KEY (`idDocente`) REFERENCES `docentes` (`idDocente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_idMateria_Materia` FOREIGN KEY (`idMateria`) REFERENCES `materias` (`idMateria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES (1,1,'Matemáticas 1°S 2020 Aula A1',1,2020,1),(2,1,'Matemáticas 2°S 2020 Aula B1',2,2020,2),(3,2,'Estadística 1°S Aula C1',1,2021,3),(4,2,'Estadística 2°S Aula D1',2,2021,4),(5,3,'Economía 1°S Aula D1',1,2021,5),(6,3,'Economía 2°S Aula C1',2,2021,6);
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
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
