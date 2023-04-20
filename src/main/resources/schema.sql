
CREATE TABLE CONTINENT(
  id INT PRIMARY KEY AUTO_INCREMENT,
  code varchar(10),
  name varchar(256)
);

CREATE TABLE LANGUAGE(
 id INT PRIMARY KEY AUTO_INCREMENT,
 code varchar(10),
 name varchar(256),
 rtl INT
);


CREATE TABLE IF NOT EXISTS Country(
  id INT PRIMARY KEY AUTO_INCREMENT,
  code varchar(10),
  currency varchar(256),
  emoji varchar(256),
  name varchar(256),
  phone varchar(256)
);

