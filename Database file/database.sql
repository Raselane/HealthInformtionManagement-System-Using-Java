-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 04, 2022 at 01:03 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `endassessment`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

CREATE TABLE `appointments` (
  `id` int(11) NOT NULL,
  `patient` varchar(255) NOT NULL,
  `time` varchar(255) NOT NULL,
  `ap_date` varchar(255) NOT NULL,
  `doctor` varchar(255) DEFAULT NULL,
  `doctor_type` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL DEFAULT 'pending'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `slots`
--

CREATE TABLE `slots` (
  `id` int(11) NOT NULL,
  `slot` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `slots`
--

INSERT INTO `slots` (`id`, `slot`) VALUES
(1, '0800-0900'),
(2, '0900-1000'),
(3, '1000-1100'),
(4, '1100-1200'),
(5, '1200-1300'),
(6, '1400-1500'),
(7, '1500-1600');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  `dob` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `type` varchar(255) NOT NULL DEFAULT 'patient',
  `status` varchar(255) NOT NULL DEFAULT 'pending'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `fullname`, `dob`, `gender`, `phone`, `address`, `type`, `status`) VALUES
(4, 'mapota', '1', 'General Kalosane', '2022-10-08', 'Male', '56678080', 'Thetsane', 'admin', 'approved'),
(14, 'Thato', '53975799', 'Thato Litseo', '2000-10-10', 'Female', '67546756', 'Katlehong', 'patient', 'approved'),
(15, 'Fusi', '53975799', 'Fusi Silase', '2022-10-10', 'Male', '59789678', 'Lesia', 'patient', 'approved'),
(16, 'Lebo', '53975799', 'Lebo Kalake', '2022-10-27', 'Female', '5000000', 'thetsane	', 'cardiologist', 'approved'),
(17, 'kabelo', 'kabelo', 'Kabelo Chaba', '2000-10-10', 'Male', '53876545', NULL, 'general', 'approved'),
(20, 'lenka', 'lenka', 'Lenka Liphapang', '1923-07-11', 'Male', '53975799', NULL, 'receptionist', 'approved');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointments`
--
ALTER TABLE `appointments`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `slots`
--
ALTER TABLE `slots`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointments`
--
ALTER TABLE `appointments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `slots`
--
ALTER TABLE `slots`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
