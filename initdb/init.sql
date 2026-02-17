CREATE SEQUENCE IF NOT EXISTS orders_seq START WITH 1;
CREATE TABLE IF NOT EXISTS orders (
  id bigint PRIMARY KEY DEFAULT nextval('orders_seq'),
  info text
);