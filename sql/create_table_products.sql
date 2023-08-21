CREATE TABLE IF NOT EXISTS products.products(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    category INT,
    name VARCHAR(255),
    description VARCHAR(255),
    price VARCHAR(10),
    date_add DATETIME,
    date_update DATETIME
);