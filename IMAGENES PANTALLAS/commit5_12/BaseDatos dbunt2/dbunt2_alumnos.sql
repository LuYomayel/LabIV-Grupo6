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
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumnos` (
  `idAlumno` int(11) NOT NULL AUTO_INCREMENT,
  `Legajo` int(11) NOT NULL,
  `Dni` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Apellido` varchar(45) NOT NULL,
  `FechaNac` date DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `idPais` int(11) NOT NULL,
  `idProvincia` int(11) NOT NULL,
  `idLocalidad` int(11) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Telefono` int(11) DEFAULT NULL,
  `idCarrera` int(11) NOT NULL,
  PRIMARY KEY (`idAlumno`,`idCarrera`),
  UNIQUE KEY `Legajo_UNIQUE` (`Legajo`),
  UNIQUE KEY `Dni_UNIQUE` (`Dni`),
  KEY `idCarrera` (`idCarrera`),
  KEY `idPais` (`idPais`),
  KEY `idProvincia` (`idProvincia`),
  KEY `idLocalidad` (`idLocalidad`),
  CONSTRAINT `idCarrera` FOREIGN KEY (`idCarrera`) REFERENCES `carreras` (`idCarrera`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idLocalidad` FOREIGN KEY (`idLocalidad`) REFERENCES `localidades` (`idLocalidad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idPais` FOREIGN KEY (`idPais`) REFERENCES `paises` (`idPais`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idProvincia` FOREIGN KEY (`idProvincia`) REFERENCES `provincias` (`idProvincia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES (1,12111,40001,'Leonardo','rterter','2000-01-01','Fontevequia 334',1,1,1,'algo1@dominio.com',46364,1),(2,12112,40002,'Ana','ferte','1982-02-02','Parodi 453',1,1,1,'algo2@dominio.com',45346,2),(3,12113,40003,'Chen','Weisong','1978-03-03','Cornejo 354',1,1,1,'algo3@dominio.com',324235,3),(4,12114,40004,'Liam','Olafson','1982-02-02','Elva Galicia 525',1,1,1,'algo4@dominio.com',23423423,1),(5,12115,40005,'Maria','Fernandez','1978-03-03','Lestelle 354',1,1,1,'algo5@dominio.com',53454,2),(6,12116,40006,'Sara','Dominguez','2000-01-01','Sosa 342',1,1,1,'algo6@dominio.com',567657675,3),(7,12117,40007,'Fausto','Sarmiento','2000-01-01','Gral. Rawson 43',1,1,1,'algo7@dominio.com',3454535,1),(8,12118,40008,'Clara','Saavedra','1978-03-03','Pte. Olivarrez 70',1,1,1,'algo8@dominio.com',436346,2),(9,12119,40009,'Mariano','Sepulveda','1982-02-02','Sarita 323',1,1,1,'algo9@dominio.com',6757434,3),(10,12120,40010,'Armando','Esteban','1978-03-03','Jorjelina 32',1,1,1,'algo10@dominio.com',543545,1),(11,12121,40011,'Clara','Salguero','1982-02-02','Ankara 534',1,1,1,'algo11@dominio.com',6546456,2),(12,12122,40012,'Claudio','Manzi','2000-01-01','Cerdeña 54',1,1,1,'algo12@dominio.com',2347767,3),(13,12123,40013,'Mara','Mansilla','2000-01-01','Verona 342',1,1,1,'algo13@dominio.com',56546,1),(14,12124,40014,'Federico','Sosa','1982-02-02','Parma 46346',1,1,1,'algo14@dominio.com',453637,2),(15,12125,40015,'Paulo','Riveiro','2000-01-01','Turín 3777',2,2,2,'algo15@dominio.com',47547457,3);
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
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
