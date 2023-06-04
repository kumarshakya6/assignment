CREATE DATABASE  IF NOT EXISTS `contact_directory`;

USE `contact_directory`;

DROP TABLE IF EXISTS Contact;
DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `members`;

--
-- Table structure for table 'contact'

CREATE TABLE Contact(
id int AUTO_INCREMENT  primary key,
first_name varchar(255),
last_name varchar(255),
email varchar(55),
phone_number varchar(20) 
)ENGINE=InnoDB DEFAULT CHARSET=latin1;




INSERT INTO Contact(id,first_name, last_name, email, phone_number) VALUES (1,'aman','maurya','aman.maurya@gmail.com', '9023287873');
INSERT INTO Contact(id,first_name, last_name, email, phone_number) VALUES (2,'rohil','maurya','rohil.maurya@gmail.com', '9023234773');
INSERT INTO Contact(id,first_name, last_name, email, phone_number) VALUES (3,'ashish','shakya','ashish.shakya@gmail.com', '9028732432');
INSERT INTO Contact(id,first_name, last_name, email, phone_number) VALUES (4,'rohit','shakya','rohit.shakya@gmail.com', '9023287873');
INSERT INTO Contact(id,first_name, last_name, email, phone_number) VALUES (5,'arti','saini','arti.saini@gmail.com', '9023287873');

--
-- Table structure for table `members`


CREATE TABLE `members` (
  `user_id` varchar(50) NOT NULL,
  `pw` char(68) NOT NULL,
  `active` tinyint NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;










--
-- Inserting data for table `members`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: fun123
--

INSERT INTO `members`
VALUES
('john','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
('mary','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
('susan','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `roles` (
  `user_id` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  UNIQUE KEY `authorities5_idx_1` (`user_id`,`role`),
  CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `roles`
--

INSERT INTO `roles`
VALUES
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_MANAGER'),
('susan','ROLE_ADMIN');
