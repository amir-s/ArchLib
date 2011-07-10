-- phpMyAdmin SQL Dump
-- version 3.4.3.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 10, 2011 at 05:38 PM
-- Server version: 5.1.54
-- PHP Version: 5.3.5-1ubuntu7.2

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `authors`
--

CREATE TABLE IF NOT EXISTS `authors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `website` text NOT NULL,
  `email` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Dumping data for table `authors`
--

INSERT INTO `authors` (`id`, `name`, `website`, `email`) VALUES
(20, 'name', 'kk', 'kk'),
(18, '11', '33', '22'),
(17, 'Amir ', 'amir@amir.amir', 'amiramiramir'),
(19, 'new auth', 'amir.s@acm.org', 'asdasd.net');

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE IF NOT EXISTS `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` text NOT NULL,
  `author_id` int(11) NOT NULL,
  `isbn` text NOT NULL,
  `year` int(11) NOT NULL,
  `publisher` text NOT NULL,
  `filename` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `title`, `author_id`, `isbn`, `year`, `publisher`, `filename`) VALUES
(1, 'yf', 18, '17989', 12, 'jlkfjk', 'memorymanagement_whitepaper.pdf'),
(2, 'dasdasdasdad', 19, 'ddd', 3, '', 'memorymanagement_whitepaper.pdf'),
(3, 'yyyyyyy', 20, 'iiiiiiii', 23, '', 'a.pdf');

-- --------------------------------------------------------

--
-- Table structure for table `related_books`
--

CREATE TABLE IF NOT EXISTS `related_books` (
  `book_id` int(11) NOT NULL,
  `related_id` int(11) NOT NULL,
  PRIMARY KEY (`book_id`,`related_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
