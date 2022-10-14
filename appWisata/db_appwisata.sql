-- MariaDB dump 10.19  Distrib 10.4.24-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: db_appwisata
-- ------------------------------------------------------
-- Server version	10.4.24-MariaDB

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
-- Table structure for table `data_hotel`
--

DROP TABLE IF EXISTS `data_hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_hotel` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nama_hotel` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `desa` varchar(100) NOT NULL,
  `kecamatan` varchar(100) NOT NULL,
  `kabupaten` varchar(100) NOT NULL,
  `latitude` varchar(200) NOT NULL,
  `longitude` varchar(200) NOT NULL,
  `deskripsi` text NOT NULL,
  `gambar` varchar(200) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_hotel`
--

LOCK TABLES `data_hotel` WRITE;
/*!40000 ALTER TABLE `data_hotel` DISABLE KEYS */;
INSERT INTO `data_hotel` VALUES (1,'Hotel Anggraeni Bumiayu','Jl. Raya Tonjong, Lebak, Penggarutan, Kec. Bumiayu, Kabupaten Brebes, Jawa Tengah 52273','Bumiayu','Bumiayu','Brebes','-7.224714323520561','109.01518214489076','Hotel Anggraeni Bumiayu Memiliki 3 cabang yaitu berada di Tanjung, Jatibarang dan Bumiayu itu sendiri','http://192.168.1.9/app-wisata-brebes/appWisata/img/anggraeni-bumiayu.jpg','2022-09-02 14:02:09','2022-09-02 14:02:09'),(2,'Hotel Anggraeni Jatibarang','Jl. Jatibarang - Slawi No.19, Talang Bata, Jatibarang Lor, Kec. Jatibarang, Kabupaten Brebes, Jawa T','Jatibarang','Jatibarang','Brebes','-6.96793082545687','109.0669397662042','Hotel Anggraeni Jatibarang merupakan salah satu cabang dari hotel anggraeni bumiayu','http://192.168.1.9/app-wisata-brebes/appWisata/img/anggraeni-jatibarang.jpg','2022-09-02 14:42:07','2022-09-02 14:42:07'),(3,'Hotel Dedy Jaya','Jl. Jenderal A. Yani No.122, Pangembon, Brebes, Kec. Brebes, Kabupaten Brebes, Jawa Tengah 52212','Brebes','Brebes','Brebes','-6.873585957170433','109.04787777024275','Hotel Dedy jaya brebes terletak di jalan pantura depan SMA 2 Brebes','http://192.168.1.9/app-wisata-brebes/appWisata/img/dedy-jaya.jpg','2022-09-02 14:42:07','2022-09-02 14:42:07');
/*!40000 ALTER TABLE `data_hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_wisata`
--

DROP TABLE IF EXISTS `data_wisata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_wisata` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nama_wisata` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `desa` varchar(100) NOT NULL,
  `kecamatan` varchar(100) NOT NULL,
  `kabupaten` varchar(100) NOT NULL,
  `longitude` varchar(200) NOT NULL,
  `latitude` varchar(200) NOT NULL,
  `deskripsi` text NOT NULL,
  `gambar` varchar(500) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_wisata`
--

LOCK TABLES `data_wisata` WRITE;
/*!40000 ALTER TABLE `data_wisata` DISABLE KEYS */;
INSERT INTO `data_wisata` VALUES (1,'Eko Wisata Mangrove Kali Anyar','Sawah,Ladang, Prapag Kidul, Kec. Losari, Kabupaten Brebes, Jawa Tengah 52255','Parapag Kidul','Losari','Brebes','-6.818123972487356 ','108.86439157144723','Eko Wisata Mangrove adalah tempat wisata keluarga bertema alam yang menyajikan pemandangan tumbuhan bakau yang dipelihara dan tumbuh di pesisir pantai prapag kidul','http://192.168.1.5/App-wisata-Brebes/appWisata/img/eko-mangrove.jpg','2022-08-29 14:51:44','2022-08-29 14:51:44'),(2,'Mangrove Alas Jaran','5W5H+294, Desa, Grinting, Kec. Bulakamba, Kabupaten Brebes, Jawa Tengah 52253','Grinting','Bulakamba','Brebes','-6.840086533381899','108.92942687137628','Mangrove alas jaran adalah wisata bertema alam dengan pemandangan tanaman bakau','http://192.168.1.5/App-wisata-Brebes/appWisata/img/alas-jaran.jpg','2022-08-29 14:54:34','2022-08-29 14:54:34'),(3,'Pringgo Wisata','327G+9CJ, Jl. KH. Abbas, Sempilselatap, Glonggong, Kec. Wanasari, Kabupaten Brebes, Jawa Tengah 5225','Glonggong','Wanasari','Brebes','-6.7347429910004575','109.33364143774602','Wisata Glonggong','http://192.168.1.5/App-wisata-Brebes/appWisata/img/pringgo.jpg','2022-08-30 16:33:49','2022-08-30 16:33:49');
/*!40000 ALTER TABLE `data_wisata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `level_user` varchar(50) NOT NULL DEFAULT 'user',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `update_at` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'den','123','Aden','aden@gmail.com','user','2022-08-26 04:03:36','2022-08-26 04:03:36'),(4,'cemil','1234','emil','em@gmail.com','user','2022-08-28 09:26:45','2022-08-28 09:26:45'),(5,'sarden1','1234','sarden','sarden@gmail.com','user','2022-08-28 09:27:59','2022-08-28 09:27:59'),(6,'sarden','1234','sarden','sarden@gmail.com','user','2022-08-28 09:30:12','2022-08-28 09:30:12');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-27 21:17:43
