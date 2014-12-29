-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 29, 2014 at 11:35 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `lms`
--

-- --------------------------------------------------------

--
-- Table structure for table `book1`
--

CREATE TABLE IF NOT EXISTS `book1` (
  `Book_ID` int(5) NOT NULL AUTO_INCREMENT,
  `ISBN` varchar(13) NOT NULL,
  `Author_Name` varchar(25) NOT NULL,
  `Book_Title` varchar(25) NOT NULL,
  `Edition` int(2) NOT NULL,
  `Price` int(10) NOT NULL,
  `Purchase_Date` varchar(25) NOT NULL,
  `Category` varchar(25) NOT NULL,
  `UPC` varchar(20) NOT NULL,
  PRIMARY KEY (`Book_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=605 ;

-- --------------------------------------------------------

--
-- Table structure for table `bookinventory`
--

CREATE TABLE IF NOT EXISTS `bookinventory` (
  `UPC` varchar(20) NOT NULL,
  `Total` int(11) NOT NULL,
  `Issued` int(11) NOT NULL,
  `Returned` int(11) NOT NULL,
  `Remaining` int(11) NOT NULL,
  `discarded` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `budget`
--

CREATE TABLE IF NOT EXISTS `budget` (
  `ID` int(5) NOT NULL AUTO_INCREMENT,
  `Year` int(4) NOT NULL,
  `Issue_Date` varchar(10) NOT NULL,
  `Aspected_Amount` int(9) NOT NULL,
  `Requested_Amount` int(9) NOT NULL,
  `Issued_Amount` int(9) NOT NULL,
  `Semester_Type` varchar(6) NOT NULL,
  `CS` int(9) NOT NULL,
  `EE` int(9) NOT NULL,
  `BBA` int(9) NOT NULL,
  `HR` int(9) NOT NULL,
  `FurnitureEquipment` int(9) NOT NULL,
  `Bill` int(9) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=27 ;

-- --------------------------------------------------------

--
-- Table structure for table `discard_book`
--

CREATE TABLE IF NOT EXISTS `discard_book` (
  `ID` int(5) NOT NULL AUTO_INCREMENT,
  `IISBN` int(10) NOT NULL,
  `Discard_Date` varchar(10) NOT NULL,
  `Author_Name` varchar(40) NOT NULL,
  `Book_Title` varchar(40) NOT NULL,
  `Edition` int(3) NOT NULL,
  `Price` int(7) NOT NULL,
  `Purchase_Date` varchar(20) NOT NULL,
  `Reason` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

-- --------------------------------------------------------

--
-- Table structure for table `issuance`
--

CREATE TABLE IF NOT EXISTS `issuance` (
  `issuanceid` int(5) NOT NULL AUTO_INCREMENT,
  `studentid` int(5) NOT NULL,
  `issuedate` varchar(10) NOT NULL,
  `returndate` varchar(10) NOT NULL,
  `UPC` varchar(20) NOT NULL,
  PRIMARY KEY (`issuanceid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Table structure for table `librarian`
--

CREATE TABLE IF NOT EXISTS `librarian` (
  `ID` int(4) NOT NULL AUTO_INCREMENT,
  `Year` int(4) NOT NULL,
  `Semester_Type` varchar(6) NOT NULL,
  `Requested_Amount` int(9) NOT NULL,
  `total_of_salaries` int(9) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `User_name` varchar(25) NOT NULL,
  `User_pswd` varchar(25) NOT NULL,
  `logintype` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`User_name`, `User_pswd`, `logintype`) VALUES
('owner', '1', 'owner'),
('librarian', '2', 'librarian'),
('s', '3', 'student');

-- --------------------------------------------------------

--
-- Table structure for table `payroll`
--

CREATE TABLE IF NOT EXISTS `payroll` (
  `Employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `Employee_name` varchar(50) NOT NULL,
  `Post` varchar(50) NOT NULL,
  `Days` int(11) NOT NULL,
  `Overtime_hours` float NOT NULL,
  `Rate_per_day` float NOT NULL,
  `Rate_per_overtime_hour` float NOT NULL,
  `Salary` double NOT NULL,
  `Date_of_Joining` varchar(50) NOT NULL,
  PRIMARY KEY (`Employee_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE IF NOT EXISTS `reservation` (
  `reservationid` int(5) NOT NULL AUTO_INCREMENT,
  `Book_name` varchar(25) NOT NULL,
  `Book_id` varchar(25) NOT NULL,
  `Reservation_Date` varchar(25) NOT NULL,
  `Student_id` varchar(13) NOT NULL,
  PRIMARY KEY (`reservationid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

-- --------------------------------------------------------

--
-- Table structure for table `returning`
--

CREATE TABLE IF NOT EXISTS `returning` (
  `returnid` int(5) NOT NULL AUTO_INCREMENT,
  `returndate` varchar(10) NOT NULL,
  `issueid` int(5) NOT NULL,
  `finepaid` int(5) NOT NULL,
  `UPC` varchar(20) NOT NULL,
  `studentid` varchar(5) NOT NULL,
  PRIMARY KEY (`returnid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=77 ;

-- --------------------------------------------------------

--
-- Table structure for table `salary_budget`
--

CREATE TABLE IF NOT EXISTS `salary_budget` (
  `ID` int(5) NOT NULL AUTO_INCREMENT,
  `Year` int(4) NOT NULL,
  `Semester_Type` char(6) NOT NULL,
  `Issue_Date` varchar(10) NOT NULL,
  `Allocated` int(9) NOT NULL,
  `Spent` int(9) NOT NULL,
  `Current_Balance` int(9) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `studentid` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `emailaddress` varchar(30) NOT NULL,
  `dob` varchar(20) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `date` varchar(25) NOT NULL,
  PRIMARY KEY (`studentid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Table structure for table `student_database`
--

CREATE TABLE IF NOT EXISTS `student_database` (
  `Student_id` int(5) NOT NULL AUTO_INCREMENT,
  `Student_name` varchar(50) NOT NULL,
  `Roll_No` int(10) NOT NULL,
  `Section` varchar(4) NOT NULL,
  `Membership_date` varchar(25) NOT NULL,
  PRIMARY KEY (`Student_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=26 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
