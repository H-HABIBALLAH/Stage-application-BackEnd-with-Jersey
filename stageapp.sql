-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 13, 2021 at 09:22 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `stageapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrateur`
--

CREATE TABLE `administrateur` (
  `id` bigint(20) NOT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `administrateur`
--

INSERT INTO `administrateur` (`id`, `mail`, `nom`, `password`, `prenom`) VALUES
(2, 'Sadou@ensibs.fr', 'Mr', 'abcde', 'Sadou');

-- --------------------------------------------------------

--
-- Table structure for table `etudiant`
--

CREATE TABLE `etudiant` (
  `id` bigint(20) NOT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `competences` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `formation` varchar(255) DEFAULT NULL,
  `inscrit` bit(1) DEFAULT NULL,
  `linked_in_link` varchar(255) DEFAULT NULL,
  `no_etudiant` varchar(255) DEFAULT NULL,
  `cv` longblob NOT NULL,
  `lm` longblob NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `etudiant`
--

INSERT INTO `etudiant` (`id`, `mail`, `nom`, `password`, `prenom`, `competences`, `description`, `formation`, `inscrit`, `linked_in_link`, `no_etudiant`, `cv`, `lm`) VALUES
(6, 'hamza1habiballah@gmail.com', 'HABIB ALLAH', '28936322a5eb164c9ced5a0166f93f15', 'Hamza', '', 'Rigoureux', 'Cyberlog', b'1', 'www.linkedin.com/myProfile', 'e2163456', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `offre`
--

CREATE TABLE `offre` (
  `id` bigint(20) NOT NULL,
  `competences` varchar(255) DEFAULT NULL,
  `confirme` bit(1) DEFAULT NULL,
  `contenu` varchar(255) DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `entrepriseName` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `offre`
--

INSERT INTO `offre` (`id`, `competences`, `confirme`, `contenu`, `titre`, `entrepriseName`) VALUES
(1, 'java', b'1', 'de4mois', 'stage', 'capgemini'),
(2, 'pentest', b'0', 'de3mois', 'stage', 'orange'),
(3, 'jee', b'1', 'de4mois', 'stage2', 'capgemini'),
(4, 'pentest', b'0', 'de3mois', 'stage', 'orange');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrateur`
--
ALTER TABLE `administrateur`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `offre`
--
ALTER TABLE `offre`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `administrateur`
--
ALTER TABLE `administrateur`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `etudiant`
--
ALTER TABLE `etudiant`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `offre`
--
ALTER TABLE `offre`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
