-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 07 Bulan Mei 2020 pada 20.58
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `database`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `covid`
--

CREATE TABLE `covid` (
  `id` int(11) NOT NULL,
  `tanggal` varchar(50) NOT NULL,
  `negara` varchar(30) NOT NULL,
  `positif` int(11) NOT NULL,
  `sembuh` int(11) NOT NULL,
  `meninggal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `covid`
--

INSERT INTO `covid` (`id`, `tanggal`, `negara`, `positif`, `sembuh`, `meninggal`) VALUES
(1, '8 mei 2020', 'Indonesia', 23, 12, 5),
(2, '8 mei 2020', 'China', 453, 34, 21),
(3, '7 mei 2020', 'Malaysia', 654, 345, 54),
(4, '6 mei 2020', 'Singapura', 1254, 876, 56);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `covid`
--
ALTER TABLE `covid`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
