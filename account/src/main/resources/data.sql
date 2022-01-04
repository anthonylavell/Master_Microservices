INSERT INTO customer (name,email,mobile_number,create_dt)
VALUES ('Anthony Ward','Anthonylavell@yahoo.com','1234567890',CURDATE());

INSERT INTO accounts (account_number,customer_id,loan_type,branch_address,create_dt)
VALUES (186576453,1,'saving','123 flake st, Chicago',CURDATE());