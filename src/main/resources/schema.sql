CREATE TABLE IF NOT EXISTS country(
    id INT AUTO_INCREMENT NOT NULL,
    name_common VARCHAR(50) NOT NULL,
    name_official VARCHAR(50) NOT NULL,
    cca3 VARCHAR(3) NOT NULL,
    region VARCHAR(50) NOT NULL,
    subregion VARCHAR(50) NOT NULL,
    population INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS currency(
    id INT AUTO_INCREMENT NOT NULL,
    code VARCHAR(10) NOT NULL,
    name VARCHAR(50) NOT NULL,
    symbol VARCHAR(10),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS country_currencies(
    country_id INT NOT NULL,
    currency_id INT NOT NULL,
    FOREIGN KEY(country_id) REFERENCES country(id),
    FOREIGN KEY(currency_id) REFERENCES currency(id)

);

CREATE TABLE IF NOT EXISTS capital(
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS country_capitals(
    country_id INT NOT NULL,
    capital_id INT NOT NULL,
    FOREIGN KEY (country_id) REFERENCES country(id),
    FOREIGN KEY (capital_id) REFERENCES capital(id)
);

CREATE TABLE IF NOT EXISTS language(
    id INT AUTO_INCREMENT NOT NULL,
    code VARCHAR(10) NOT NULL,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS country_languages(
   country_id INT NOT NULL,
   language_id INT NOT NULL,
   FOREIGN KEY (country_id) REFERENCES country(id),
   FOREIGN KEY (language_id) REFERENCES language(id)
);

CREATE TABLE IF NOT EXISTS border(
   id INT AUTO_INCREMENT NOT NULL,
   name VARCHAR(50) NOT NULL,
   PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS country_borders(
   country_id INT NOT NULL,
   border_id INT NOT NULL,
   FOREIGN KEY (country_id) REFERENCES country(id),
   FOREIGN KEY (border_id) REFERENCES border(id)
);

CREATE TABLE IF NOT EXISTS time_zone(
   id INT AUTO_INCREMENT NOT NULL,
   name VARCHAR(50) NOT NULL,
   PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS country_time_zones(
   country_id INT NOT NULL,
   time_zone_id INT NOT NULL,
   FOREIGN KEY (country_id) REFERENCES country(id),
   FOREIGN KEY (time_zone_id) REFERENCES time_zone(id)
);