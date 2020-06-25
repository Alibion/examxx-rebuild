-- MySQL dump 10.13  Distrib 5.5.61, for Win32 (AMD64)
--
-- Host: localhost    Database: examxx
-- ------------------------------------------------------
-- Server version	5.5.61

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
-- Table structure for table `et_dialog_classify`
--

DROP TABLE IF EXISTS `et_dialog_classify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `et_dialog_classify` (
  `dialogClassifyID` int(20) NOT NULL,
  `dialogClassifyName` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `et_dialog_classify`
--

LOCK TABLES `et_dialog_classify` WRITE;
/*!40000 ALTER TABLE `et_dialog_classify` DISABLE KEYS */;
INSERT INTO `et_dialog_classify` VALUES (1,'日常问候\n\n'),(2,'Test1');
/*!40000 ALTER TABLE `et_dialog_classify` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `et_dialog_info`
--

DROP TABLE IF EXISTS `et_dialog_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `et_dialog_info` (
  `dialogID` int(6) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dialogClassifyID` int(20) NOT NULL,
  `questionJapanese` varchar(100) NOT NULL,
  `answerJapanese1` varchar(100) NOT NULL,
  `answerJapanese2` varchar(100) DEFAULT NULL,
  `answerJapanese3` varchar(100) DEFAULT NULL,
  `questionChinese` varchar(100) NOT NULL,
  `answerChinese1` varchar(100) NOT NULL,
  `answerChinese2` varchar(100) DEFAULT NULL,
  `answerChinese3` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`dialogID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `et_dialog_info`
--

LOCK TABLES `et_dialog_info` WRITE;
/*!40000 ALTER TABLE `et_dialog_info` DISABLE KEYS */;
INSERT INTO `et_dialog_info` VALUES (1,1,'日本語問題','日本語回答',NULL,NULL,'中文问题','中文回答',NULL,NULL),(2,1,'日本語問題','日本語回答',NULL,NULL,'中文问题','中文回答',NULL,NULL),(3,2,'日本語問題','日本語回答',NULL,NULL,'中文问题','中文回答',NULL,NULL),(4,2,'日本語問題','日本語回答',NULL,NULL,'中文问题','中文回答',NULL,NULL),(5,2,'123','123',NULL,NULL,'123','123',NULL,NULL);
/*!40000 ALTER TABLE `et_dialog_info` ENABLE KEYS */;
UNLOCK TABLES;

-- Dump completed on 2020-06-18 14:30:54
