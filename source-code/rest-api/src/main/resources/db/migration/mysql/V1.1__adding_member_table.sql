CREATE TABLE IF NOT EXISTS member (
  id varchar(36) NOT NULL,
  username VARCHAR(10) NOT NULL,
  password VARCHAR(10) NOT NULL,
  fullname VARCHAR(50) NOT NULL,
  address VARCHAR(255) NOT NULL,
  country VARCHAR(50) NOT NULL,
  email VARCHAR(45) NOT NULL,
  mobile_no VARCHAR(45) NOT NULL,
  dateofbirth DATE NOT NULL,
  picture VARCHAR(45) NOT NULL,
  status VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY username (username),
  UNIQUE KEY email (email))
ENGINE = InnoDB;