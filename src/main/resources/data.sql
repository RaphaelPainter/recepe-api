ALTER TABLE if exists recipe
DROP CONSTRAINT  IF EXISTS fk_recipe_customer;
ALTER TABLE if exists customer
DROP CONSTRAINT IF EXISTS fk_customer_role;


DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS recipe;
DROP TABLE IF EXISTS role;




CREATE TABLE customer (
   id UUID NOT NULL,
   name VARCHAR(50) NOT NULL,
   email VARCHAR,
   password VARCHAR,
   creation_date DATE NOT NULL,
   role VARCHAR,
   unique(name),
   unique(email),
   primary key(id)
);
INSERT INTO customer (id, name, creation_date) values (
    '550e8400-e29b-41d4-a716-446655440000',
    'test',
    '2023-11-07'
);

CREATE TABLE recipe (
   id UUID NOT NULL,
   name VARCHAR(50) NOT NULL,
   creation_date DATE NOT NULL,
   steps VARCHAR NOT NULL,
   created_by VARCHAR NOT NULL,
   primary key(id),
   unique(name),
   CONSTRAINT fk_recipe_customer
       FOREIGN KEY (created_by)
       REFERENCES customer(id)
);

