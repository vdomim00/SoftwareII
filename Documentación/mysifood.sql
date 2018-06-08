CREATE DATABASE  IF NOT EXISTS `mysifood` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mysifood`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: mysifood
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `almacenes`
--

DROP TABLE IF EXISTS `almacenes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `almacenes` (
  `idAlmacen` int(11) NOT NULL AUTO_INCREMENT,
  `zonas` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idAlmacen`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `almacenes`
--

LOCK TABLES `almacenes` WRITE;
/*!40000 ALTER TABLE `almacenes` DISABLE KEYS */;
INSERT INTO `almacenes` VALUES (1,'zonaguay');
/*!40000 ALTER TABLE `almacenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `usuario` varchar(16) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellidos` varchar(32) DEFAULT NULL,
  `DNI` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `pass` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES ('anonimo','Anonimo','anónimo','00000000Z','anonimo','000000000','anonimo'),('cliente','Antonio','Comomás Quecualquiera','12312554A','antonio@comomucho.yo','645344213','cliente');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallepedidosaalmacen`
--

DROP TABLE IF EXISTS `detallepedidosaalmacen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallepedidosaalmacen` (
  `idDetalle` int(11) NOT NULL AUTO_INCREMENT,
  `pedidoAlmacen_idPedido` int(11) DEFAULT NULL,
  `productos_codigoProducto` varchar(45) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDetalle`),
  KEY `pedidoAlmacen_idPedido` (`pedidoAlmacen_idPedido`),
  KEY `FK_detallepedidosaalmacen_PRODUCTOS_codigoProducto` (`productos_codigoProducto`),
  CONSTRAINT `FK_detallepedidosaalmacen_PRODUCTOS_codigoProducto` FOREIGN KEY (`productos_codigoProducto`) REFERENCES `productos` (`codigoProducto`),
  CONSTRAINT `detallepedidosaalmacen_ibfk_1` FOREIGN KEY (`pedidoAlmacen_idPedido`) REFERENCES `pedidosaalmacen` (`idPedido`),
  CONSTRAINT `detallepedidosaalmacen_ibfk_2` FOREIGN KEY (`productos_codigoProducto`) REFERENCES `productos` (`codigoProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallepedidosaalmacen`
--

LOCK TABLES `detallepedidosaalmacen` WRITE;
/*!40000 ALTER TABLE `detallepedidosaalmacen` DISABLE KEYS */;
INSERT INTO `detallepedidosaalmacen` VALUES (1,6,'chocolate',3),(2,1,'pepinillos',3),(3,2,'galletas',3),(4,5,'chocolate',3),(5,7,'galletas',3),(6,8,'galletas',3),(7,8,'chocolate',3),(8,8,'galletas',3),(9,9,'chocolate',4),(10,9,'pepinillos',5),(11,9,'galletas',2),(12,10,'chocolate',3),(13,11,'pepinillos',24),(14,12,'chocolate',3),(15,13,'pepinillos',45);
/*!40000 ALTER TABLE `detallepedidosaalmacen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallepedidosaproveedores`
--

DROP TABLE IF EXISTS `detallepedidosaproveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallepedidosaproveedores` (
  `idDetalle_pedidosAProveedores` int(11) NOT NULL AUTO_INCREMENT,
  `productos_codigoProducto` varchar(45) DEFAULT NULL,
  `pedidosAProveedores_idPedidoAProveedor` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idDetalle_pedidosAProveedores`),
  KEY `productos_codigoProducto` (`productos_codigoProducto`),
  KEY `pedidosAProveedores_idPedidoAProveedor` (`pedidosAProveedores_idPedidoAProveedor`),
  CONSTRAINT `detallepedidosaproveedores_ibfk_1` FOREIGN KEY (`productos_codigoProducto`) REFERENCES `productos` (`codigoProducto`),
  CONSTRAINT `detallepedidosaproveedores_ibfk_2` FOREIGN KEY (`pedidosAProveedores_idPedidoAProveedor`) REFERENCES `pedidosaproveedores` (`idPedidoAProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallepedidosaproveedores`
--

LOCK TABLES `detallepedidosaproveedores` WRITE;
/*!40000 ALTER TABLE `detallepedidosaproveedores` DISABLE KEYS */;
INSERT INTO `detallepedidosaproveedores` VALUES (1,'chocolate',1,14,'pendiente'),(2,'pepinillos',1,25,'pendiente'),(3,'galletas',2,14,'pendiente'),(4,'pepinillos',2,13,'pendiente');
/*!40000 ALTER TABLE `detallepedidosaproveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedidos` (
  `idPedido` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(45) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `fechaVenta` datetime DEFAULT NULL,
  `nombrePlatos` varchar(500) DEFAULT NULL,
  `observaciones` varchar(500) DEFAULT NULL,
  `clientes_usuario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPedido`),
  KEY `clientes_usuario` (`clientes_usuario`),
  CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`clientes_usuario`) REFERENCES `clientes` (`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (1,'pendiente',14,NULL,'arroz.2 verduras.1',NULL,'cliente'),(2,'pendiente',16,NULL,'arroz.1 verduras.1 pollo.1',NULL,'cliente'),(3,'pendiente',21,NULL,'pollo.3','','anonimo');
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos_has_platos`
--

DROP TABLE IF EXISTS `pedidos_has_platos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedidos_has_platos` (
  `pedidos_idVenta` int(11) NOT NULL,
  `platos_nombrePlato` varchar(90) NOT NULL,
  PRIMARY KEY (`pedidos_idVenta`,`platos_nombrePlato`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos_has_platos`
--

LOCK TABLES `pedidos_has_platos` WRITE;
/*!40000 ALTER TABLE `pedidos_has_platos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedidos_has_platos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidosaalmacen`
--

DROP TABLE IF EXISTS `pedidosaalmacen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedidosaalmacen` (
  `idPedido` int(11) NOT NULL,
  PRIMARY KEY (`idPedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidosaalmacen`
--

LOCK TABLES `pedidosaalmacen` WRITE;
/*!40000 ALTER TABLE `pedidosaalmacen` DISABLE KEYS */;
INSERT INTO `pedidosaalmacen` VALUES (0),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(11),(12),(13);
/*!40000 ALTER TABLE `pedidosaalmacen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidosaproveedores`
--

DROP TABLE IF EXISTS `pedidosaproveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedidosaproveedores` (
  `idPedidoAProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `coste` double DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `proveedores_CIF` varchar(45) DEFAULT NULL,
  `trabajadores_usuario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPedidoAProveedor`),
  KEY `proveedores_CIF` (`proveedores_CIF`),
  KEY `trabajadores_usuario` (`trabajadores_usuario`),
  CONSTRAINT `pedidosaproveedores_ibfk_1` FOREIGN KEY (`proveedores_CIF`) REFERENCES `proveedores` (`CIF`),
  CONSTRAINT `pedidosaproveedores_ibfk_2` FOREIGN KEY (`trabajadores_usuario`) REFERENCES `trabajadores` (`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidosaproveedores`
--

LOCK TABLES `pedidosaproveedores` WRITE;
/*!40000 ALTER TABLE `pedidosaproveedores` DISABLE KEYS */;
INSERT INTO `pedidosaproveedores` VALUES (1,12,'pendiente','N3578035B','encargado'),(2,24,'pendiente','N3578035B','encargado');
/*!40000 ALTER TABLE `pedidosaproveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peticiones`
--

DROP TABLE IF EXISTS `peticiones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `peticiones` (
  `idPeticion` int(11) NOT NULL AUTO_INCREMENT,
  `nombrePlato` varchar(45) DEFAULT NULL,
  `ingredientes` varchar(45) DEFAULT NULL,
  `elaboracion` varchar(45) DEFAULT NULL,
  `alergenos` varchar(45) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `trabajadores_usuario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPeticion`),
  KEY `trabajadores_usuario` (`trabajadores_usuario`),
  CONSTRAINT `peticiones_ibfk_1` FOREIGN KEY (`trabajadores_usuario`) REFERENCES `trabajadores` (`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peticiones`
--

LOCK TABLES `peticiones` WRITE;
/*!40000 ALTER TABLE `peticiones` DISABLE KEYS */;
INSERT INTO `peticiones` VALUES (5,'pavo','pavo','cocer el pavo','gluten',36.5,'cocinero'),(8,'ensalada','lechuga','mezclar y aliñar','lechuga',3.4,'cocinero');
/*!40000 ALTER TABLE `peticiones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platos`
--

DROP TABLE IF EXISTS `platos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `platos` (
  `nombrePlato` varchar(255) NOT NULL,
  `alergenos` varchar(255) DEFAULT NULL,
  `elaboracion` varchar(255) DEFAULT NULL,
  `ingredientes` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  PRIMARY KEY (`nombrePlato`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platos`
--

LOCK TABLES `platos` WRITE;
/*!40000 ALTER TABLE `platos` DISABLE KEYS */;
INSERT INTO `platos` VALUES ('arroz','arroz','cocer el arroz','arroz',13),('pollo','gluten','cocer el pollo','pollo',36.5),('verduras','verdura','freir las verduras','verdura',14);
/*!40000 ALTER TABLE `platos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `codigoProducto` varchar(45) NOT NULL,
  `precio` double DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `secciones_nombreSeccion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigoProducto`),
  KEY `secciones_nombreSeccion` (`secciones_nombreSeccion`),
  CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`secciones_nombreSeccion`) REFERENCES `secciones` (`nombreSeccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES ('arroz',5,58,'variados'),('chocolate',3,45,'variados'),('galletas',2,34,'variados'),('pepinillos',10,36,'verduras'),('pollo',7,76,'carnes'),('sartenPlus',20,34,'sartenes'),('tenedores',4,76,'cuberteria'),('verdura',4,102,'verduras');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedores` (
  `CIF` varchar(45) NOT NULL,
  `nombreEmpresa` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `fax` varchar(45) DEFAULT NULL,
  `URL` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CIF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES ('N3578035B','proveedoresJuan','24007 León',911843762,'proveedoresJuan@miempresa.com','0998455879','www.proveedoresJuan.es');
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secciones`
--

DROP TABLE IF EXISTS `secciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secciones` (
  `nombreSeccion` varchar(45) NOT NULL,
  `zonas_nombreZona` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nombreSeccion`),
  KEY `zonas_nombreZona` (`zonas_nombreZona`),
  CONSTRAINT `secciones_ibfk_1` FOREIGN KEY (`zonas_nombreZona`) REFERENCES `zonas` (`nombreZona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secciones`
--

LOCK TABLES `secciones` WRITE;
/*!40000 ALTER TABLE `secciones` DISABLE KEYS */;
INSERT INTO `secciones` VALUES ('carnes','alimentos'),('congelados','alimentos'),('variados','alimentos'),('verduras','alimentos'),('pienso','perros'),('cuberteria','utensilios'),('sartenes','utensilios');
/*!40000 ALTER TABLE `secciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabajadores`
--

DROP TABLE IF EXISTS `trabajadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trabajadores` (
  `usuario` varchar(45) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `pass` varchar(45) DEFAULT NULL,
  `DNI` varchar(45) DEFAULT NULL,
  `numeroSS` varchar(45) DEFAULT NULL,
  `numeroCuenta` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `rol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajadores`
--

LOCK TABLES `trabajadores` WRITE;
/*!40000 ALTER TABLE `trabajadores` DISABLE KEYS */;
INSERT INTO `trabajadores` VALUES ('administrador','Pablo','Mandamás Quetodos','administrador','10945673A','376462553462116','ES34566473364554','pablo@mando.yo','administrador'),('camarero','Felipe','Repartomás Quetodos','camarero','32153466C','66562553465122','ES12326473312776','felipe@reparto.yo','camarero'),('cocinero','Alex','Cocinomás Quetodos','cocinero','64453442C','543462553465432','ES54436473312329','alex@cocino.yo','cocinero'),('encargado','Raúl','Encargomás Quetodos','encargado','23453442E','123462553465768','ES66436473312194','raul@encargo.yo','encargado');
/*!40000 ALTER TABLE `trabajadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zonas`
--

DROP TABLE IF EXISTS `zonas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zonas` (
  `nombreZona` varchar(45) NOT NULL,
  `almacen_idAlmacen` int(11) DEFAULT NULL,
  PRIMARY KEY (`nombreZona`),
  KEY `almacen_idAlmacen` (`almacen_idAlmacen`),
  CONSTRAINT `zonas_ibfk_1` FOREIGN KEY (`almacen_idAlmacen`) REFERENCES `almacenes` (`idAlmacen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zonas`
--

LOCK TABLES `zonas` WRITE;
/*!40000 ALTER TABLE `zonas` DISABLE KEYS */;
INSERT INTO `zonas` VALUES ('alimentos',1),('perros',1),('utensilios',1);
/*!40000 ALTER TABLE `zonas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-08 20:40:18
