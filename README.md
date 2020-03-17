# schoolmanagementsystem
 crud app as a school management system

CREATE DATABASE WITH THE FOLLOWNING STATEMENTS

CREATE DATABASE `student_hms`;

CREATE TABLE `credentials` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `permission` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`)
);

CREATE TABLE `person` (
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `personal_number` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `adress` varchar(45) DEFAULT NULL,
  `person_username` varchar(45) NOT NULL,
  PRIMARY KEY (`person_username`),
  CONSTRAINT `person_username` FOREIGN KEY (`person_username`) REFERENCES `credentials` (`username`)
);
