CREATE TABLE IF NOT EXISTS products.categories(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    date_add DATETIME,
    date_update DATETIME
);