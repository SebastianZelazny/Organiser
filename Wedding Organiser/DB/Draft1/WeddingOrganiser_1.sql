CREATE TABLE `Customer` (
  `customer_id` int PRIMARY KEY,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `prefix` varchar(255)
);

CREATE TABLE `Account` (
  `account_id` int PRIMARY KEY,
  `customer_id` int NOT NULL,
  `contact_id` int NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL
);

CREATE TABLE `Event` (
  `event_id` int PRIMARY KEY,
  `customer_id` int NOT NULL,
  `event_date` datetime,
  `event_name` varchar(255) NOT NULL,
  `address_id` int
);

CREATE TABLE `Address` (
  `address_id` int PRIMARY KEY,
  `address_type` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `postal_code` varchar(255) NOT NULL,
  `street` varchar(255) NOT NULL,
  `additional_comment` varchar(255)
);

CREATE TABLE `Guest` (
  `guest_id` int PRIMARY KEY,
  `contact_id` int,
  `address_id` int,
  `event_id` int NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL
);

CREATE TABLE `Service` (
  `service_id` int PRIMARY KEY,
  `address_id` int,
  `contact_id` int NOT NULL,
  `service_name` varchar(255) NOT NULL,
  `service_type` varchar(255) NOT NULL,
  `description` varchar(255),
  `cost_min` decimal,
  `cost_max` decimal
);

CREATE TABLE `Event_service` (
  `event_service_id` int PRIMARY KEY,
  `event_id` int NOT NULL,
  `service_id` int,
  `serivce_name` varchar(255),
  `service_type` varchar(255),
  `description` varchar(255),
  `cost` decimal
);

CREATE TABLE `event_todo` (
  `event_todo_id` int PRIMARY KEY,
  `event_id` int NOT NULL,
  `todo_id` int,
  `todo_name` varchar(255),
  `description` varchar(255),
  `event_todo_date` datetime,
  `priority` int,
  `notes` varchar(255)
);

CREATE TABLE `ToDo` (
  `todo_id` int PRIMARY KEY,
  `todo_name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `priority` int NOT NULL
);

CREATE TABLE `Contact` (
  `contact_id` int PRIMARY KEY,
  `phone` varchar(255),
  `email` varchar(255),
  `facebook` varchar(255)
);

ALTER TABLE `Account` ADD FOREIGN KEY (`customer_id`) REFERENCES `Customer` (`customer_id`);

ALTER TABLE `Event` ADD FOREIGN KEY (`customer_id`) REFERENCES `Customer` (`customer_id`);

ALTER TABLE `Guest` ADD FOREIGN KEY (`event_id`) REFERENCES `Event` (`event_id`);

ALTER TABLE `Event` ADD FOREIGN KEY (`address_id`) REFERENCES `Address` (`address_id`);

ALTER TABLE `Event_service` ADD FOREIGN KEY (`event_id`) REFERENCES `Event` (`event_id`);

ALTER TABLE `Address` ADD FOREIGN KEY (`address_id`) REFERENCES `Service` (`address_id`);

ALTER TABLE `Event_service` ADD FOREIGN KEY (`service_id`) REFERENCES `Service` (`service_id`);

ALTER TABLE `Contact` ADD FOREIGN KEY (`contact_id`) REFERENCES `Guest` (`contact_id`);

ALTER TABLE `Contact` ADD FOREIGN KEY (`contact_id`) REFERENCES `Service` (`contact_id`);

ALTER TABLE `Contact` ADD FOREIGN KEY (`contact_id`) REFERENCES `Account` (`contact_id`);

ALTER TABLE `Address` ADD FOREIGN KEY (`address_id`) REFERENCES `Guest` (`address_id`);

ALTER TABLE `event_todo` ADD FOREIGN KEY (`event_id`) REFERENCES `Event` (`event_id`);

ALTER TABLE `event_todo` ADD FOREIGN KEY (`todo_id`) REFERENCES `ToDo` (`todo_id`);
