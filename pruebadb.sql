-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-12-2014 a las 02:44:21
-- Versión del servidor: 5.5.36
-- Versión de PHP: 5.4.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `pruebadb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE IF NOT EXISTS `persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(65) DEFAULT NULL,
  `apellidos` varchar(65) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `profesion` varchar(65) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id`, `nombres`, `apellidos`, `edad`, `profesion`) VALUES
(18, 'rONY', 'CORTEZ', 28, 'NADA'),
(19, 'rONY', 'CORTEZ', 28, 'NADA'),
(20, 'rONY', 'CORTEZ', 28, 'NADA'),
(21, 'rONY', 'CORTEZ', 28, 'NADA'),
(22, 'rONY', 'CORTEZ', 28, 'NADA');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
