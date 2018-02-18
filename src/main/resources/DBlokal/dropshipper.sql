-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 18, 2018 at 06:03 PM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dropshipper`
--

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

CREATE TABLE `bank` (
  `BANK_ID` int(11) NOT NULL,
  `BANK_NAME` varchar(30) DEFAULT NULL,
  `BANK_TRFCD` varchar(10) DEFAULT NULL,
  `IS_ACTIVE` int(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `BARANG_ID` int(11) NOT NULL,
  `KATEGORI_ID` int(11) DEFAULT NULL,
  `VENDOR_ID` int(11) DEFAULT NULL,
  `SKU` varchar(15) DEFAULT NULL,
  `BARANG_NAME` varchar(30) DEFAULT NULL,
  `WARNA` varchar(15) DEFAULT NULL,
  `BARANG_BERAT` int(11) DEFAULT NULL,
  `BARANG_PRICE` int(11) DEFAULT NULL,
  `GAMBAR` varchar(255) DEFAULT NULL,
  `BARANG_KETERANGAN` text,
  `IS_ACTIVE` int(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`BARANG_ID`, `KATEGORI_ID`, `VENDOR_ID`, `SKU`, `BARANG_NAME`, `WARNA`, `BARANG_BERAT`, `BARANG_PRICE`, `GAMBAR`, `BARANG_KETERANGAN`, `IS_ACTIVE`) VALUES
(1, 1, 1, 'R123V1', 'Roti Cokelat', 'coklat', 2000, 10000, NULL, 'Roti adalah makanan berbahan dasar utama tepung terigu dan air, yang difermentasikan dengan ragi, tetapi ada juga yang tidak menggunakan ragi.', NULL),
(2, 2, 1, 'S125V1', 'Susu', NULL, 50, 6000, NULL, 'Susu secara alami mengandung nutrisi penting, seperti bermacam-macam vitamin, protein, kalsium, magnesium, fosfor, dan zinc, pendapat lain menambahkan bahwa susu mengandung mineral dan lemak.', 1),
(3, 4, 2, 'O890V2', 'Obat maag', NULL, 10, 7000, NULL, 'Obat-obatan untuk sakit maag umumnya dimakan dua jam sebelum makan dan dua jam sesudah makan. Adapun dengan tujuan obat dikonsumsi dua jam sebelum makan yaitu untuk menetralisir asam lambung', 1),
(4, 5, 3, 'L234V3', 'Laptop', 'Hitam', 4000, 7000000, NULL, 'Laptop atau komputer jinjing adalah komputer bergerak yang berukuran relatif kecil dan ringan, beratnya berkisar dari 1–6 kg', 1),
(5, 5, 3, 'M231V3', 'Mouse', 'Merah', 500, 200000, NULL, 'Mouse dengan warna merah', 1),
(6, 5, 3, 'M232V3', 'Mouse', 'Hitam', 500, 200000, NULL, 'Mouse dengan warna hitam', 0),
(7, 5, 3, 'M233V3', 'Mouse', 'Biru', 5000, 200000, NULL, 'Mouse dengan warna biru', NULL),
(8, 5, 3, 'M334V3', 'Monitor', NULL, 4000, 2500000, NULL, 'salah satu jenis soft-copy device, karena keluarannya adalah berupa sinyal elektronik, dalam hal ini berupa gambar yang tampil di layar monitor. Gambar yang tampil adalah hasil pemrosesan data ataupun informasi masukan.', 1),
(9, 1, 4, 'B122V4', 'Buah', NULL, 1000, 30000, NULL, ' makanan alami yang memiliki kandungan vitamin, gizi, dan mineral yang sangat baik untuk dikonsumsi tiap hari. ', 1),
(10, 1, 1, 'kjnajsk87y', 'najn', 'akjsd', 1222, 1, NULL, NULL, NULL),
(11, 1, 1, 'adaw112', 'asa', 'www', 1, 111111, NULL, NULL, NULL),
(12, 1, 1, 'jhksdf7', 'akjsnd', 'slkndf', 3, 3, NULL, NULL, NULL),
(13, 1, 1, 'jkads78', 'sigit', 'kjasd', 8, 8, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `detailtransaksi`
--

CREATE TABLE `detailtransaksi` (
  `DETAIL_ID` int(11) NOT NULL,
  `BARANG_ID` int(11) DEFAULT NULL,
  `TRANSAKSI_ID` int(11) DEFAULT NULL,
  `DETAIL_QTY` int(11) DEFAULT NULL,
  `DETAIL_TOTAL` int(11) DEFAULT NULL,
  `TOTAL_BERAT` int(11) DEFAULT NULL,
  `IS_ACTIVE` int(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `KATEGORI_ID` int(11) NOT NULL,
  `KATEGORI_NAME` varchar(20) DEFAULT NULL,
  `KATEGORI_LEVEL` int(11) DEFAULT NULL,
  `KATEGORI_PARENT_ID` int(11) DEFAULT NULL,
  `IS_ACTIVE` int(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`KATEGORI_ID`, `KATEGORI_NAME`, `KATEGORI_LEVEL`, `KATEGORI_PARENT_ID`, `IS_ACTIVE`) VALUES
(1, 'Makanan', 1, 1, 1),
(2, 'Minuman', 1, 1, 1),
(3, 'Elektronik', 1, 1, 1),
(4, 'Obat-obatan', 1, 1, 1),
(5, 'Perlengkapan PC', 1, 1, 1),
(6, 'Sampah', 1, 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `kurir`
--

CREATE TABLE `kurir` (
  `KURIR_ID` int(11) NOT NULL,
  `KURIR_NAME` varchar(25) DEFAULT NULL,
  `IS_ACTIVE` int(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `lokasi`
--

CREATE TABLE `lokasi` (
  `LOKASI_ID` int(11) NOT NULL,
  `WILAYAH_ID` int(11) DEFAULT NULL,
  `KODEPOS` varchar(6) DEFAULT NULL,
  `ALAMAT` varchar(50) DEFAULT NULL,
  `IS_ACTIVE` int(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lokasi`
--

INSERT INTO `lokasi` (`LOKASI_ID`, `WILAYAH_ID`, `KODEPOS`, `ALAMAT`, `IS_ACTIVE`) VALUES
(1, 1, '81333', 'x', 1),
(2, 1, '45252', 'xy', NULL),
(3, 3, '12345', '2', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `pengambilan`
--

CREATE TABLE `pengambilan` (
  `PENGAMBILAN_ID` int(11) NOT NULL,
  `KURIR_ID` int(11) DEFAULT NULL,
  `DETAIL_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `rekening`
--

CREATE TABLE `rekening` (
  `REKENING_ID` int(11) NOT NULL,
  `BANK_ID` int(11) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  `REKENING_NAME` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `TRANSAKSI_ID` int(11) NOT NULL,
  `WAKTU_ID` int(11) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  `TRANSAKSI_TGL` datetime DEFAULT NULL,
  `TGL_PENGAMBILAN` date DEFAULT NULL,
  `BIAYA_KURIR` int(11) DEFAULT NULL,
  `IS_ACTIVE` int(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `USER_ID` int(11) NOT NULL,
  `LOKASI_ID` int(11) DEFAULT NULL,
  `USER_KTP` varchar(16) DEFAULT NULL,
  `USER_NAME` varchar(20) NOT NULL,
  `USER_EMAIL` varchar(30) NOT NULL,
  `USER_PASSWORD` varchar(50) NOT NULL,
  `USER_PHONE` varchar(16) DEFAULT NULL,
  `IS_ACTIVE` int(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`USER_ID`, `LOKASI_ID`, `USER_KTP`, `USER_NAME`, `USER_EMAIL`, `USER_PASSWORD`, `USER_PHONE`, `IS_ACTIVE`) VALUES
(1, 1, '510806', 'user1', 'user1@gmail.com', '123', '087762123456', 1),
(2, 1, '510805', 'user2', 'user2@gmail.com', '890', '087123456789', 1),
(3, 1, '11111', 'natan', 'natan@gmail.com', '123', '085980234578', 1),
(4, 1, '3', '3', '3', '3', '3', 1);

-- --------------------------------------------------------

--
-- Table structure for table `vendor`
--

CREATE TABLE `vendor` (
  `VENDOR_ID` int(11) NOT NULL,
  `LOKASI_ID` int(11) DEFAULT NULL,
  `VENDOR_NAME` varchar(20) DEFAULT NULL,
  `VENDOR_PHONE` varchar(13) DEFAULT NULL,
  `VENDOR_EMAIL` varchar(30) DEFAULT NULL,
  `IS_ACTIVE` int(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vendor`
--

INSERT INTO `vendor` (`VENDOR_ID`, `LOKASI_ID`, `VENDOR_NAME`, `VENDOR_PHONE`, `VENDOR_EMAIL`, `IS_ACTIVE`) VALUES
(1, 1, 'Vendor 1', '087890123456', 'vendor1@gmail.com', 1),
(2, 1, 'Vendor 2', '089123123456', 'vendor2@gmail.com', 1),
(3, 1, 'Vendor 3', '089999000123', 'vendor3@gmail.com', 1),
(4, 1, 'Vendor 4', '081234567803', 'vendor4@gmail.com', 1),
(5, 2, 'Vendor 5', '081213133112', 'Vendor5@gmail.com', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `waktu_pengambilan`
--

CREATE TABLE `waktu_pengambilan` (
  `WAKTU_ID` int(11) NOT NULL,
  `WAKTU_PENGAMBILAN` time DEFAULT NULL,
  `IS_ACTIVE` int(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `waktu_pengambilan`
--

INSERT INTO `waktu_pengambilan` (`WAKTU_ID`, `WAKTU_PENGAMBILAN`, `IS_ACTIVE`) VALUES
(1, '08:00:00', 1),
(2, '11:00:00', 1),
(3, '16:00:00', 1),
(4, '20:00:00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `wilayah`
--

CREATE TABLE `wilayah` (
  `WILAYAH_ID` int(11) NOT NULL,
  `WILAYAH_NAME` varchar(20) DEFAULT NULL,
  `LEVEL` int(11) DEFAULT NULL,
  `PARENT_ID` int(11) DEFAULT NULL,
  `IS_ACTIVE` int(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `wilayah`
--

INSERT INTO `wilayah` (`WILAYAH_ID`, `WILAYAH_NAME`, `LEVEL`, `PARENT_ID`, `IS_ACTIVE`) VALUES
(1, 'Jakarta', 1, NULL, 1),
(2, 'bekasi', 1, NULL, NULL),
(3, 'Tanggerang', 1, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bank`
--
ALTER TABLE `bank`
  ADD PRIMARY KEY (`BANK_ID`);

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`BARANG_ID`),
  ADD KEY `FK_REFERENCE_12` (`VENDOR_ID`),
  ADD KEY `FK_REFERENCE_4` (`KATEGORI_ID`);

--
-- Indexes for table `detailtransaksi`
--
ALTER TABLE `detailtransaksi`
  ADD PRIMARY KEY (`DETAIL_ID`),
  ADD KEY `FK_REFERENCE_5` (`BARANG_ID`),
  ADD KEY `FK_REFERENCE_7` (`TRANSAKSI_ID`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`KATEGORI_ID`);

--
-- Indexes for table `kurir`
--
ALTER TABLE `kurir`
  ADD PRIMARY KEY (`KURIR_ID`);

--
-- Indexes for table `lokasi`
--
ALTER TABLE `lokasi`
  ADD PRIMARY KEY (`LOKASI_ID`),
  ADD KEY `FK_REFERENCE_21` (`WILAYAH_ID`);

--
-- Indexes for table `pengambilan`
--
ALTER TABLE `pengambilan`
  ADD PRIMARY KEY (`PENGAMBILAN_ID`),
  ADD KEY `FK_REFERENCE_14` (`DETAIL_ID`),
  ADD KEY `FK_REFERENCE_15` (`KURIR_ID`);

--
-- Indexes for table `rekening`
--
ALTER TABLE `rekening`
  ADD PRIMARY KEY (`REKENING_ID`),
  ADD KEY `FK_REFERENCE_17` (`BANK_ID`),
  ADD KEY `FK_REFERENCE_19` (`USER_ID`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`TRANSAKSI_ID`),
  ADD KEY `FK_REFERENCE_16` (`WAKTU_ID`),
  ADD KEY `FK_REFERENCE_20` (`USER_ID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`USER_ID`),
  ADD KEY `FK_REFERENCE_8` (`LOKASI_ID`);

--
-- Indexes for table `vendor`
--
ALTER TABLE `vendor`
  ADD PRIMARY KEY (`VENDOR_ID`),
  ADD KEY `FK_REFERENCE_9` (`LOKASI_ID`);

--
-- Indexes for table `waktu_pengambilan`
--
ALTER TABLE `waktu_pengambilan`
  ADD PRIMARY KEY (`WAKTU_ID`);

--
-- Indexes for table `wilayah`
--
ALTER TABLE `wilayah`
  ADD PRIMARY KEY (`WILAYAH_ID`),
  ADD KEY `FK_REFERENCE_18` (`PARENT_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bank`
--
ALTER TABLE `bank`
  MODIFY `BANK_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `BARANG_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `detailtransaksi`
--
ALTER TABLE `detailtransaksi`
  MODIFY `DETAIL_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `kategori`
--
ALTER TABLE `kategori`
  MODIFY `KATEGORI_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `kurir`
--
ALTER TABLE `kurir`
  MODIFY `KURIR_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `lokasi`
--
ALTER TABLE `lokasi`
  MODIFY `LOKASI_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `pengambilan`
--
ALTER TABLE `pengambilan`
  MODIFY `PENGAMBILAN_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rekening`
--
ALTER TABLE `rekening`
  MODIFY `REKENING_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `USER_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `vendor`
--
ALTER TABLE `vendor`
  MODIFY `VENDOR_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `waktu_pengambilan`
--
ALTER TABLE `waktu_pengambilan`
  MODIFY `WAKTU_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `wilayah`
--
ALTER TABLE `wilayah`
  MODIFY `WILAYAH_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `FK_REFERENCE_12` FOREIGN KEY (`VENDOR_ID`) REFERENCES `vendor` (`VENDOR_ID`),
  ADD CONSTRAINT `FK_REFERENCE_4` FOREIGN KEY (`KATEGORI_ID`) REFERENCES `kategori` (`KATEGORI_ID`);

--
-- Constraints for table `detailtransaksi`
--
ALTER TABLE `detailtransaksi`
  ADD CONSTRAINT `FK_REFERENCE_5` FOREIGN KEY (`BARANG_ID`) REFERENCES `barang` (`BARANG_ID`),
  ADD CONSTRAINT `FK_REFERENCE_7` FOREIGN KEY (`TRANSAKSI_ID`) REFERENCES `transaksi` (`TRANSAKSI_ID`);

--
-- Constraints for table `lokasi`
--
ALTER TABLE `lokasi`
  ADD CONSTRAINT `FK_REFERENCE_21` FOREIGN KEY (`WILAYAH_ID`) REFERENCES `wilayah` (`WILAYAH_ID`);

--
-- Constraints for table `pengambilan`
--
ALTER TABLE `pengambilan`
  ADD CONSTRAINT `FK_REFERENCE_14` FOREIGN KEY (`DETAIL_ID`) REFERENCES `detailtransaksi` (`DETAIL_ID`),
  ADD CONSTRAINT `FK_REFERENCE_15` FOREIGN KEY (`KURIR_ID`) REFERENCES `kurir` (`KURIR_ID`);

--
-- Constraints for table `rekening`
--
ALTER TABLE `rekening`
  ADD CONSTRAINT `FK_REFERENCE_17` FOREIGN KEY (`BANK_ID`) REFERENCES `bank` (`BANK_ID`),
  ADD CONSTRAINT `FK_REFERENCE_19` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `FK_REFERENCE_16` FOREIGN KEY (`WAKTU_ID`) REFERENCES `waktu_pengambilan` (`WAKTU_ID`),
  ADD CONSTRAINT `FK_REFERENCE_20` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_REFERENCE_8` FOREIGN KEY (`LOKASI_ID`) REFERENCES `lokasi` (`LOKASI_ID`);

--
-- Constraints for table `vendor`
--
ALTER TABLE `vendor`
  ADD CONSTRAINT `FK_REFERENCE_9` FOREIGN KEY (`LOKASI_ID`) REFERENCES `lokasi` (`LOKASI_ID`);

--
-- Constraints for table `wilayah`
--
ALTER TABLE `wilayah`
  ADD CONSTRAINT `FK_REFERENCE_18` FOREIGN KEY (`PARENT_ID`) REFERENCES `wilayah` (`WILAYAH_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
