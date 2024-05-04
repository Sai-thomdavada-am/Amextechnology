CREATE TABLE card (
    id INT AUTO_INCREMENT PRIMARY KEY,
    card_number VARCHAR(16) NOT NULL,
    cardholder_name VARCHAR(100) NOT NULL,
    expiration_date DATE NOT NULL,
    cvv INT NOT NULL
);

INSERT INTO card (card_number, cardholder_name, expiration_date, cvv) 
VALUES ('1234567890123456', 'John Doe', '2024-12-31', 123);
