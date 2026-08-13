USE MySQL;
CREATE DATABASE dbproduct;

CREATE USER 'operator'@'localhost' IDENTIFIED BY 'Itcm2026';
GRANT ALL ON dbproduct.* TO 'operator'@'localhost';
FLUSH PRIVILEGES;

USE dbproduct;

CREATE TABLE product(
	product_id INT PRIMARY KEY AUTO_INCREMENT,
	product_name NVARCHAR(50) NOT NULL UNIQUE,
	quantity_per_unit NVARCHAR(100) NOT NULL,
	unit_price DECIMAL(10,2) NOT NULL DEFAULT 0,
	units_in_stock INT NOT NULL DEFAULT 0,
	units_on_order INT NOT NULL DEFAULT 0,
	reorder_level INT NOT NULL DEFAULT 0,
	category INT NOT NULL FOREIGN KEY (category) REFERENCES dbcategory(category_id) ON DELETE RESTRICT,
	discontinued BOOLEAN NOT NULL DEFAULT FALSE
);

INSERT INTO product (
	product_name,
	quantity_per_unit,
	unit_price,
	units_in_stock,
	units_on_order,
	reorder_level,
	category,
	discontinued
) VALUES ('Chai',	'10 boxes x 20 bags',	18.00,	39,	0,	10, 2,	false), 
('Chang', '24 - 12 oz bottles',	19.00,	17,	40,	25, 2,	0), 
('Aniseed Syrup',	'12 - 550 ml bottles',	10.00,	13,	70,	25, 1,	0), 
('Chef Antons Cajun Seasoning',	'48 - 6 oz jars',	22.00, 53,	0,	0,	2, 0), 
('Queso Cabrales',	'1 kg pkg.',	21.00,	22,	30,	30, 2,	0), 
('Raclette Courdavault','5 kg pkg.',	55.00,	79,	0,	0, 2,	1);

SELECT * FROM product;