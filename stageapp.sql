-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 02, 2021 at 10:58 AM
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
-- Database: `stageapp_importTest`
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
(1, 'Mr', 'Loic', 'Loic1234', 'Loic@ensibs.fr'),
(2, 'Sadou@ensibs.fr', 'Mr', 'abcde', 'Sadou'),
(3, 'Sadou@ensibs.fr', 'salah', 'abcde', 'Sadou');

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
  `no_etudiant` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `etudiant`
--

INSERT INTO `etudiant` (`id`, `mail`, `nom`, `password`, `prenom`, `competences`, `description`, `formation`, `inscrit`, `linked_in_link`, `no_etudiant`) VALUES
(1, NULL, NULL, NULL, NULL, 'Java - C++', 'Je suis rigoureux', 'CyberLog', b'1', 'www.LinkedIn', 'e3213');

-- --------------------------------------------------------

--
-- Table structure for table `fichier`
--

CREATE TABLE `fichier` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `data` blob NOT NULL,
  `etudiant_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fichier`
--

INSERT INTO `fichier` (`id`, `title`, `type`, `data`, `etudiant_id`) VALUES
(1, 'fichier1', 'CV', '', NULL);

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
  `admin_id` bigint(20) DEFAULT NULL,
  `entrepriseName` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

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
-- Indexes for table `fichier`
--
ALTER TABLE `fichier`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhyn7yowblj7qf44x6sjyg6kii` (`etudiant_id`);

--
-- Indexes for table `offre`
--
ALTER TABLE `offre`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7er9r0hnjgqlwsavi2820cye5` (`admin_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `administrateur`
--
ALTER TABLE `administrateur`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `etudiant`
--
ALTER TABLE `etudiant`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `fichier`
--
ALTER TABLE `fichier`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `offre`
--
ALTER TABLE `offre`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
