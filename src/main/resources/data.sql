DROP TABLE `articles` IF EXISTS;
-- had to add the drop table line because it kept adding the below information over 60 times but only showed id 31/32 & 65/66
-- had to change the id to GenerationType.IDENTITY because it was being weird about the primary key being messed up 
-- so I took the option away by auto generation and assigning

CREATE TABLE IF NOT EXISTS `articles` (
  `article_id` bigint(5) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `category` varchar(100) NOT NULL,
  PRIMARY KEY (`article_id`)
);

INSERT INTO `articles` (`title`, `category`) VALUES
	('Java Concurrency', 'Java'),
	('Spring Boot Getting Started', 'Spring Boot'); 