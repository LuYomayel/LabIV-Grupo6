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
-- Table structure for table `docentes`
--

DROP TABLE IF EXISTS `docentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `docentes` (
  `idDocente` int(11) NOT NULL AUTO_INCREMENT,
  `Legajo` int(11) NOT NULL,
  `Dni` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Apellido` varchar(45) DEFAULT NULL,
  `FechaNac` date DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `idPais` int(11) NOT NULL,
  `idProvincia` int(11) NOT NULL,
  `idLocalidad` int(11) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Telefono` varchar(45) DEFAULT NULL,
  `idCarrera` int(11) NOT NULL,
  PRIMARY KEY (`idDocente`,`idCarrera`),
  KEY `INDEX_LEGAJO` (`Legajo`),
  KEY `FK_idCarrera_Carreras` (`idCarrera`),
  KEY `idPais` (`idPais`),
  KEY `idProvincia` (`idProvincia`),
  KEY `idLocalidad` (`idLocalidad`),
  CONSTRAINT `FK_idCarrera_Carreras` FOREIGN KEY (`idCarrera`) REFERENCES `carreras` (`idCarrera`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idLocalidad_docente` FOREIGN KEY (`idLocalidad`) REFERENCES `localidades` (`idLocalidad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idPais_docente` FOREIGN KEY (`idPais`) REFERENCES `paises` (`idPais`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idProvincia_docente` FOREIGN KEY (`idProvincia`) REFERENCES `provincias` (`idProvincia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docentes`
--

LOCK TABLES `docentes` WRITE;
/*!40000 ALTER TABLE `docentes` DISABLE KEYS */;
INSERT INTO `docentes` VALUES (1,123456,12345543,'Fulana','Esposito','1970-06-01','Fauci 233',1,1,1,'fulani@dominio.com','09876655',1),(2,654321,13456654,'Jose','Juarez','1980-06-01','Pueyrredón 23244',1,1,1,'jJuarez@dominio.com','55678908',1),(3,232353,14353535,'Pepe','Pope','1970-06-01','Pueyrredón 25244',1,1,1,'pepepompin@dom.com','30787978',1),(4,523533,34214124,'Alvaro','Navia','1980-06-01','Asturias 523',1,1,1,'anavia@dominio.com','65436856',1),(5,656546,45634644,'Maria','Estevez','1970-06-01','Gral. Pacheco 325',1,1,1,'Estevezm@dominio.com','78647457',2),(6,323442,63464364,'Lia','Salgado','1980-06-01','Pueyrredón 52244',1,1,1,'LiaSalga@dominio.com','89788589',2),(7,341234,78768786,'Carina','Mancervelli','1970-06-01','Tigre 5325',1,1,1,'cariMancer@dominio.com','54799534',3),(8,765767,53445454,'Mara','Godoy','1980-06-01','Tigre 42342',1,1,1,'MGodoy@dominio.com','56545465',3),(9,324342,73567563,'Clarita','Dominguez','1970-06-01','Tigre 46642',2,2,2,'clarssd@dominio.com','6546546',3);
/*!40000 ALTER TABLE `docentes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-06 12:42:45
