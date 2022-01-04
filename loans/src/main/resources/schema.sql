CREATE TABLE IF NOT EXISTS loan (
 loan_number integer AUTO_INCREMENT PRIMARY KEY,
  customer_id integer NOT NULL,
  start_dt date DEFAULT NULL,
  loan_type VARCHAR(100) NOT NULL,
  total_loan integer NOT NULL,
  amount_paid integer NOT NULL,
  outstanding_amount integer NOT NULL,
  create_dt date DEFAULT NULL
);