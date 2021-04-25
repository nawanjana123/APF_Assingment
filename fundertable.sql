-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2021 at 07:13 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `funder`
--

-- --------------------------------------------------------

--
-- Table structure for table `fundertable`
--

CREATE TABLE `fundertable` (
  `funderID` int(10) NOT NULL,
  `funderName` varchar(50) NOT NULL,
  `funderNIC` varchar(10) NOT NULL,
  `funderAddress` varchar(50) NOT NULL,
  `funderEmail` varchar(50) NOT NULL,
  `funderPhone` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fundertable`
--

INSERT INTO `fundertable` (`funderID`, `funderName`, `funderNIC`, `funderAddress`, `funderEmail`, `funderPhone`) VALUES
(5, 'Rashmika', '970064126V', 'Kandy rd,Malabe', 'Rash@gmail.com', '0701554567'),
(6, 'Maneesha', '980564178V', 'Kandy rd,Kaduwela', 'maneesha@gmail.com', '0761657517'),
(9, 'Pahan', '984754161V', 'Kandy rd,Malabe', 'pahan@gmail.com', '0765857521'),
(14, 'samupdated', '960063126V', 'Kaduwela', 'abcd@gmail.com', '0721557684'),
(17, 'Saman', '985874187V', 'Malabe', 'saman@gmail.com', '076553716'),
(21, 'Saman', '985874187V', 'Malabe', 'saman@gmail.com', '076553716');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `fundertable`
--
ALTER TABLE `fundertable`
  ADD PRIMARY KEY (`funderID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `fundertable`
--
ALTER TABLE `fundertable`
  MODIFY `funderID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
