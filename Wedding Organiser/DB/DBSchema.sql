-- WeddingOrganizer.Address definition

CREATE TABLE `Address` (
  `address_id` int NOT NULL AUTO_INCREMENT,
  `address_type` varchar(10) NOT NULL,
  `city` varchar(255) NOT NULL,
  `postal_code` varchar(255) NOT NULL,
  `street` varchar(255) NOT NULL,
  `additional_comment` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- WeddingOrganizer.Contact definition

CREATE TABLE `Contact` (
  `contact_id` int NOT NULL AUTO_INCREMENT,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `facebook` varchar(255) DEFAULT NULL,
  `contact_type` varchar(10) NOT NULL,
  PRIMARY KEY (`contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- WeddingOrganizer.Expense definition

CREATE TABLE `Expense` (
  `expense_id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(5000) DEFAULT NULL,
  `expense_type` varchar(10) NOT NULL,
  PRIMARY KEY (`expense_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- WeddingOrganizer.ToDo definition

CREATE TABLE `ToDo` (
  `todo_id` int NOT NULL AUTO_INCREMENT,
  `todo_name` varchar(500) NOT NULL,
  `description` varchar(5000) NOT NULL,
  `priority` int NOT NULL,
  PRIMARY KEY (`todo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- WeddingOrganizer.Account definition

CREATE TABLE `Account` (
  `account_id` int NOT NULL AUTO_INCREMENT,
  `contact_id` int NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(10) NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `contact_id` (`contact_id`),
  CONSTRAINT `Account_ibfk_1` FOREIGN KEY (`contact_id`) REFERENCES `Contact` (`contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- WeddingOrganizer.Event definition

CREATE TABLE `Event` (
  `event_id` int NOT NULL AUTO_INCREMENT,
  `address_id` int DEFAULT NULL,
  `account_id` int NOT NULL,
  `event_date` datetime DEFAULT NULL,
  `event_name` varchar(500) NOT NULL,
  PRIMARY KEY (`event_id`),
  UNIQUE KEY `address_id` (`address_id`),
  KEY `account_id` (`account_id`),
  CONSTRAINT `Event_FK` FOREIGN KEY (`address_id`) REFERENCES `Address` (`address_id`),
  CONSTRAINT `Event_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `Account` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- WeddingOrganizer.Event_todo definition

CREATE TABLE `Event_todo` (
  `event_todo_id` int NOT NULL AUTO_INCREMENT,
  `event_id` int NOT NULL,
  `todo_id` int DEFAULT NULL,
  `todo_name` varchar(500) DEFAULT NULL,
  `description` varchar(5000) DEFAULT NULL,
  `event_todo_date` datetime DEFAULT NULL,
  `priority` int DEFAULT NULL,
  `notes` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`event_todo_id`),
  KEY `event_id` (`event_id`),
  KEY `todo_id` (`todo_id`),
  CONSTRAINT `Event_todo_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `Event` (`event_id`),
  CONSTRAINT `Event_todo_ibfk_2` FOREIGN KEY (`todo_id`) REFERENCES `ToDo` (`todo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- WeddingOrganizer.Gallery definition

CREATE TABLE `Gallery` (
  `gallery_id` int NOT NULL AUTO_INCREMENT,
  `event_id` int NOT NULL,
  `gallery_name` varchar(500) NOT NULL,
  `description` varchar(5000) DEFAULT NULL,
  `is_private` tinyint(1) NOT NULL,
  PRIMARY KEY (`gallery_id`),
  KEY `event_id` (`event_id`),
  CONSTRAINT `Gallery_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `Event` (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- WeddingOrganizer.Guest definition

CREATE TABLE `Guest` (
  `guest_id` int NOT NULL AUTO_INCREMENT,
  `contact_id` int DEFAULT NULL,
  `address_id` int DEFAULT NULL,
  `event_id` int NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `invited` tinyint(1) NOT NULL,
  `confirmed` varchar(10) NOT NULL,
  `guest_type` varchar(10) NOT NULL,
  `discount_type` varchar(10) DEFAULT NULL,
  `invited_by` varchar(10) DEFAULT NULL,
  `accommodation` tinyint(1) NOT NULL,
  `transport` tinyint(1) NOT NULL,
  `diet` varchar(10) DEFAULT NULL,
  `additional_comment` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`guest_id`),
  UNIQUE KEY `contact_id` (`contact_id`),
  UNIQUE KEY `address_id` (`address_id`),
  KEY `event_id` (`event_id`),
  CONSTRAINT `Guest_FK` FOREIGN KEY (`address_id`) REFERENCES `Address` (`address_id`),
  CONSTRAINT `Guest_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `Event` (`event_id`),
  CONSTRAINT `Guest_ibfk_2` FOREIGN KEY (`contact_id`) REFERENCES `Contact` (`contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- WeddingOrganizer.Service definition

CREATE TABLE `Service` (
  `service_id` int NOT NULL AUTO_INCREMENT,
  `contact_id` int NOT NULL,
  `service_name` varchar(500) NOT NULL,
  `service_type` varchar(10) NOT NULL,
  `description` varchar(5000) DEFAULT NULL,
  `cost_min` decimal(10,0) DEFAULT NULL,
  `cost_max` decimal(10,0) DEFAULT NULL,
  `currency` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`service_id`),
  UNIQUE KEY `contact_id` (`contact_id`),
  CONSTRAINT `Service_ibfk_1` FOREIGN KEY (`contact_id`) REFERENCES `Contact` (`contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- WeddingOrganizer.Service_address definition

CREATE TABLE `Service_address` (
  `service_address_id` int NOT NULL AUTO_INCREMENT,
  `address_id` int NOT NULL,
  `service_id` int NOT NULL,
  PRIMARY KEY (`service_address_id`),
  UNIQUE KEY `address_id` (`address_id`),
  KEY `service_id` (`service_id`),
  CONSTRAINT `Service_address_ibfk_1` FOREIGN KEY (`service_id`) REFERENCES `Service` (`service_id`),
  CONSTRAINT `Service_address_ibfk_2` FOREIGN KEY (`address_id`) REFERENCES `Address` (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- WeddingOrganizer.Table_definition definition

CREATE TABLE `Table_definition` (
  `table_definition_id` int NOT NULL AUTO_INCREMENT,
  `event_id` int NOT NULL,
  `table_name` varchar(100) NOT NULL,
  `table_type` varchar(10) NOT NULL,
  `table_size` int NOT NULL,
  `additional_comment` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`table_definition_id`),
  KEY `event_id` (`event_id`),
  CONSTRAINT `Table_definition_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `Event` (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- WeddingOrganizer.Budget definition

CREATE TABLE `Budget` (
  `budget_id` int NOT NULL AUTO_INCREMENT,
  `event_id` int NOT NULL,
  `value` decimal(10,0) DEFAULT NULL,
  `currency` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`budget_id`),
  UNIQUE KEY `event_id` (`event_id`),
  CONSTRAINT `Budget_FK` FOREIGN KEY (`event_id`) REFERENCES `Event` (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- WeddingOrganizer.Event_expense definition

CREATE TABLE `Event_expense` (
  `event_expense_id` int NOT NULL AUTO_INCREMENT,
  `budget_id` int NOT NULL,
  `expense_id` int DEFAULT NULL,
  `service_id` int DEFAULT NULL,
  `description` varchar(5000) DEFAULT NULL,
  `expense_type` varchar(10) NOT NULL,
  `cost` decimal(10,0) NOT NULL,
  `paid` decimal(10,0) NOT NULL,
  `currency` varchar(10) DEFAULT NULL,
  `additional_comment` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`event_expense_id`),
  KEY `budget_id` (`budget_id`),
  KEY `expense_id` (`expense_id`),
  KEY `service_id` (`service_id`),
  CONSTRAINT `Event_expense_ibfk_1` FOREIGN KEY (`budget_id`) REFERENCES `Budget` (`budget_id`),
  CONSTRAINT `Event_expense_ibfk_2` FOREIGN KEY (`expense_id`) REFERENCES `Expense` (`expense_id`),
  CONSTRAINT `Event_expense_ibfk_3` FOREIGN KEY (`service_id`) REFERENCES `Service` (`service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- WeddingOrganizer.File definition

CREATE TABLE `File` (
  `file_id` int NOT NULL AUTO_INCREMENT,
  `gallery_id` int NOT NULL,
  `file_type` varchar(10) NOT NULL,
  `file_size` int NOT NULL,
  `file_description` varchar(5000) DEFAULT NULL,
  `upload_date` datetime DEFAULT NULL,
  PRIMARY KEY (`file_id`),
  KEY `gallery_id` (`gallery_id`),
  CONSTRAINT `File_ibfk_1` FOREIGN KEY (`gallery_id`) REFERENCES `Gallery` (`gallery_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- WeddingOrganizer.File_guest_tag definition

CREATE TABLE `File_guest_tag` (
  `file_guest_tag_id` int NOT NULL AUTO_INCREMENT,
  `file_id` int NOT NULL,
  `guest_id` int NOT NULL,
  PRIMARY KEY (`file_guest_tag_id`),
  KEY `file_id` (`file_id`),
  KEY `guest_id` (`guest_id`),
  CONSTRAINT `File_guest_tag_ibfk_1` FOREIGN KEY (`file_id`) REFERENCES `File` (`file_id`),
  CONSTRAINT `File_guest_tag_ibfk_2` FOREIGN KEY (`guest_id`) REFERENCES `Guest` (`guest_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- WeddingOrganizer.File_tag definition

CREATE TABLE `File_tag` (
  `file_tag_id` int NOT NULL AUTO_INCREMENT,
  `file_id` int NOT NULL,
  `hashtag` varchar(500) NOT NULL,
  PRIMARY KEY (`file_tag_id`),
  KEY `file_id` (`file_id`),
  CONSTRAINT `File_tag_ibfk_1` FOREIGN KEY (`file_id`) REFERENCES `File` (`file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- WeddingOrganizer.Gallery_access definition

CREATE TABLE `Gallery_access` (
  `gallery_access_id` int NOT NULL AUTO_INCREMENT,
  `gallery_id` int NOT NULL,
  `guest_id` int NOT NULL,
  PRIMARY KEY (`gallery_access_id`),
  KEY `gallery_id` (`gallery_id`),
  KEY `guest_id` (`guest_id`),
  CONSTRAINT `Gallery_access_ibfk_1` FOREIGN KEY (`gallery_id`) REFERENCES `Gallery` (`gallery_id`),
  CONSTRAINT `Gallery_access_ibfk_2` FOREIGN KEY (`guest_id`) REFERENCES `Guest` (`guest_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- WeddingOrganizer.Guest_table definition

CREATE TABLE `Guest_table` (
  `guest_table_id` int NOT NULL AUTO_INCREMENT,
  `table_definition_id` int NOT NULL,
  `guest_id` int NOT NULL,
  `position` int DEFAULT NULL,
  PRIMARY KEY (`guest_table_id`),
  UNIQUE KEY `guest_id` (`guest_id`),
  KEY `table_id` (`table_definition_id`),
  CONSTRAINT `Guest_table_ibfk_1` FOREIGN KEY (`table_definition_id`) REFERENCES `Table_definition` (`table_definition_id`),
  CONSTRAINT `Guest_table_ibfk_2` FOREIGN KEY (`guest_id`) REFERENCES `Guest` (`guest_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;