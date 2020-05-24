DROP TABLE IF EXISTS ACCOUNT;
CREATE TABLE ACCOUNT (
    id int AUTO_INCREMENT NOT NULL primary key,
    firstname           varchar(255),
    lastname            varchar(255),
    email               varchar(255),
    creditCard_id       bigint,
    productsToSell      other,
    created             timestamp
);
DROP TABLE IF EXISTS PRODUCT;
CREATE TABLE PRODUCT (
  id int AUTO_INCREMENT NOT NULL primary key,
  name          varchar(255),
  description   varchar(255),
  price         double,
  added         timestamp
);

DROP TABLE IF EXISTS CREDITCARD;
CREATE TABLE CREDITCARD (
  id bigint AUTO_INCREMENT NOT NULL primary key,
  number varchar(16) NOT NULL,
  holder   varchar(255) NOT NULL,
  exp_year  int NOT NULL,
  exp_month int NOT NULL,
  account_id bigint NOT NUll,
  CONSTRAINT fk_account_id FOREIGN KEY (account_id) REFERENCES ACCOUNT(id)
);

ALTER TABLE ACCOUNT
ADD FOREIGN KEY (creditCard_id) REFERENCES CREDITCARD(id);
