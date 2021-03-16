-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 16, 2021 at 10:21 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.3.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbstageapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `permission`
--

CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL,
  `permission` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `permission`
--

INSERT INTO `permission` (`id`, `permission`) VALUES
(17, 'ROLE_DASHBOARD'),
(18, 'ROLE_APPS'),
(19, 'ROLE_INBOX'),
(20, 'ROLE_UIELEMENTS'),
(21, 'ROLE_Forms');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `product_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `category`, `price`, `product_name`) VALUES
(21, 'water', 20, 'soda'),
(22, 'water', 10, 'water'),
(23, 'food', 30, 'Fried Rice'),
(24, 'Food', 30, 'Noodle');

-- --------------------------------------------------------

--
-- Table structure for table `role_app`
--

CREATE TABLE `role_app` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `deleted` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role_app`
--

INSERT INTO `role_app` (`id`, `name`, `deleted`) VALUES
(8, 'ROLE_ADMIN', b'0'),
(9, 'ROLE_USER', b'0'),
(10, 'ROLE_DEVELOPPER', b'0'),
(11, 'ROLE_Collaborateur', b'0'),
(12, 'ROLE_SI', b'0'),
(13, 'ROLE_OP', b'1'),
(14, 'ROLE_lmlml', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `role_app_users`
--

CREATE TABLE `role_app_users` (
  `role_app_id` bigint(20) NOT NULL,
  `users_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `role_permissions`
--

CREATE TABLE `role_permissions` (
  `role_id` bigint(20) NOT NULL,
  `permision_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role_permissions`
--

INSERT INTO `role_permissions` (`role_id`, `permision_id`) VALUES
(9, 20),
(10, 18),
(11, 20),
(11, 21),
(12, 19),
(12, 20),
(12, 21),
(13, 17),
(13, 21),
(8, 18),
(8, 19),
(8, 21),
(14, 17),
(14, 21);

-- --------------------------------------------------------

--
-- Table structure for table `user_app`
--

CREATE TABLE `user_app` (
  `id` bigint(20) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `activate` bit(1) NOT NULL,
  `deleted` bit(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_app`
--

INSERT INTO `user_app` (`id`, `nom`, `password`, `username`, `activate`, `deleted`, `email`) VALUES
(1, 'Test', '$2a$10$yiqYOgR3YZr7ph9La.duke1qbUJuXhpFvXJrMl6S/EFGHzLI3tW/S', 'oth@test.com', b'1', b'0', 'test154'),
(2, 'test', '$2a$10$j1BYN22x9B7v/29msf1gBeYW0DultrxxvsoIIG7qVoAQBOYLF2BBu', 'test@test.com', b'1', b'0', NULL),
(3, 'ismail', '$2a$10$KcS4HrtSU4Eaa55P2srAxOOXpFbmY0awIyZCpFt4E8q.lsVth4Wca', 'ismail@test.com', b'1', b'0', NULL),
(13, 'test', '$2a$10$PgfVm2XlpjJFZ2n2wt8dI.Lw5Njb3vy/iRvnnn.WV1mPs90.EtOIu', 'test@gmail.com', b'1', b'0', NULL),
(15, NULL, '$2a$10$SkYMylPXIdwVAppMGnTx6uKedmKGvhNiOpJ.dNWgiuVDs6GnbXPKa', NULL, b'1', b'1', NULL),
(16, 'tsst', '$2a$10$JUg4IQdfMpXzkYT7pV17TuBUVQzBFOWxn/MltWedq2LoPNGvCH8cS', 'tsst', b'1', b'1', 'tsst@gmail.com'),
(17, 'dfsg', '$2a$10$pC/us/OZANgJ/wq1SYamKe2nRqCun/ri1p72Au.JrTyy.d38ROEMa', 'dfhdf', b'1', b'1', NULL),
(18, 'ben', '$2a$10$LmuU6n3hGcu5SC3vhkF2s.gboZTD/bNJ/ZB8SKZXzB4sn0jtiEnBu', 'ben', b'1', b'0', 'ben@gmail.com'),
(19, 'mm12', '$2a$10$Feizuxpb3CO1addHnCsKbuMyRZYRKFprHpC193FwIYYEfmMbon9OS', 'mm@oth.com', b'1', b'1', NULL),
(20, 'Othmane Hadday', '$2a$10$LJHobIr0iEnioyVqMO.cJeNogh6oZCQIGI5XutVC1/uzMt/ugS5Ee', 'othmane.hadday@e-polytechnique.ma', b'1', b'0', 'othmane.hadday@e-polytechnique.ma');

-- --------------------------------------------------------

--
-- Table structure for table `user_app_permissions`
--

CREATE TABLE `user_app_permissions` (
  `user_app_id` bigint(20) NOT NULL,
  `permissions_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `user_permissions`
--

CREATE TABLE `user_permissions` (
  `user_id` bigint(20) NOT NULL,
  `permision_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_permissions`
--

INSERT INTO `user_permissions` (`user_id`, `permision_id`) VALUES
(3, 17),
(12, 17),
(12, 18),
(2, 21),
(18, 19),
(18, 20),
(18, 21),
(13, 20),
(1, 17),
(1, 20),
(1, 21),
(16, 18),
(20, 17),
(20, 20),
(20, 21);

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(3, 9),
(12, 9),
(14, 8),
(15, 10),
(2, 9),
(17, 8),
(19, 10),
(18, 12),
(13, 9),
(1, 11),
(16, 10),
(20, 9);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `permission`
--
ALTER TABLE `permission`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role_app`
--
ALTER TABLE `role_app`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role_app_users`
--
ALTER TABLE `role_app_users`
  ADD KEY `FK15t2cg7i4vi89dpneqw4jba3` (`users_id`),
  ADD KEY `FKnpbvs1ua116a8d6xk9bsv3elk` (`role_app_id`);

--
-- Indexes for table `role_permissions`
--
ALTER TABLE `role_permissions`
  ADD KEY `FK174i4n1ki104eg1xug01evxv2` (`permision_id`),
  ADD KEY `FKm1y9ecnv8b8sj7e5tes87r4q0` (`role_id`);

--
-- Indexes for table `user_app`
--
ALTER TABLE `user_app`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_app_permissions`
--
ALTER TABLE `user_app_permissions`
  ADD KEY `FKqiehnek7798eembs2ooef05ai` (`permissions_id`),
  ADD KEY `FKhccoakqr38t3841q95ec9p4ke` (`user_app_id`);

--
-- Indexes for table `user_permissions`
--
ALTER TABLE `user_permissions`
  ADD KEY `FKmcgorvvu92ognys2ar24ud2qe` (`permision_id`),
  ADD KEY `FKd5omhi4kn9vmqgvpq6w0ug6by` (`user_id`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD KEY `FK8wfy6e06ixr47r74umfeoo3tj` (`role_id`),
  ADD KEY `FKnycroxxikom02k0lxo2vatn8j` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `permission`
--
ALTER TABLE `permission`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `role_app`
--
ALTER TABLE `role_app`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `user_app`
--
ALTER TABLE `user_app`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `role_app_users`
--
ALTER TABLE `role_app_users`
  ADD CONSTRAINT `FK15t2cg7i4vi89dpneqw4jba3` FOREIGN KEY (`users_id`) REFERENCES `user_app` (`id`),
  ADD CONSTRAINT `FKnpbvs1ua116a8d6xk9bsv3elk` FOREIGN KEY (`role_app_id`) REFERENCES `role_app` (`id`);

--
-- Constraints for table `role_permissions`
--
ALTER TABLE `role_permissions`
  ADD CONSTRAINT `FK174i4n1ki104eg1xug01evxv2` FOREIGN KEY (`permision_id`) REFERENCES `permission` (`id`),
  ADD CONSTRAINT `FKm1y9ecnv8b8sj7e5tes87r4q0` FOREIGN KEY (`role_id`) REFERENCES `role_app` (`id`);

--
-- Constraints for table `user_app_permissions`
--
ALTER TABLE `user_app_permissions`
  ADD CONSTRAINT `FKhccoakqr38t3841q95ec9p4ke` FOREIGN KEY (`user_app_id`) REFERENCES `user_app` (`id`),
  ADD CONSTRAINT `FKqiehnek7798eembs2ooef05ai` FOREIGN KEY (`permissions_id`) REFERENCES `permission` (`id`);

--
-- Constraints for table `user_permissions`
--
ALTER TABLE `user_permissions`
  ADD CONSTRAINT `FKd5omhi4kn9vmqgvpq6w0ug6by` FOREIGN KEY (`user_id`) REFERENCES `user_app` (`id`),
  ADD CONSTRAINT `FKmcgorvvu92ognys2ar24ud2qe` FOREIGN KEY (`permision_id`) REFERENCES `permission` (`id`);

--
-- Constraints for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FK8wfy6e06ixr47r74umfeoo3tj` FOREIGN KEY (`role_id`) REFERENCES `role_app` (`id`),
  ADD CONSTRAINT `FKnycroxxikom02k0lxo2vatn8j` FOREIGN KEY (`user_id`) REFERENCES `user_app` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
