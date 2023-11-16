ALTER TABLE if exists recipe
DROP CONSTRAINT  IF EXISTS fk_recipe_api_user;

ALTER TABLE if exists COOKS
DROP CONSTRAINT IF EXISTS fk_api_user_role;

ALTER TABLE if exists COOKS
DROP CONSTRAINT IF EXISTS fk_cook_users;

ALTER TABLE if exists FOOD
DROP CONSTRAINT IF EXISTS fk_food_season_start;

ALTER TABLE if exists FOOD
DROP CONSTRAINT IF EXISTS fk_food_season_end;


DROP TABLE IF EXISTS ACCOUNT;
DROP TABLE IF EXISTS recipe;
DROP TABLE IF EXISTS COOKS;
DROP TABLE IF EXISTS FOOD;
DROP TABLE IF EXISTS MONTH_REF;

CREATE TABLE ACCOUNT (
   id UUID NOT NULL,
   name VARCHAR(50) NOT NULL,
   email VARCHAR,
   password VARCHAR,
   creation_date DATETIME NOT NULL,
   role VARCHAR,
   unique(email),
   primary key(id)
);
INSERT INTO ACCOUNT (id, name,  email, password, creation_date, role) values (
    '550e8400-e29b-41d4-a716-446655440000',
    'Paul',
    'admin_test',
    '$2a$10$JVWfPunx/.7PDxNjk8XH3eHsw0/eGP8ZiSA4l9FjFfPr.HAKQ6QK.',
    '2023-11-07',
    'ADMIN'
);
INSERT INTO ACCOUNT (id, name,  email, password, creation_date, role) values (
    '450e8400-e29b-41d4-a716-446655440000',
    'Paul',
    'user_test',
    '$2a$10$JVWfPunx/.7PDxNjk8XH3eHsw0/eGP8ZiSA4l9FjFfPr.HAKQ6QK.',
    '2023-11-07',
    'USER'
);

CREATE TABLE COOKS (
   id UUID NOT NULL,
   name VARCHAR(50) NOT NULL,
   creation_date DATETIME NOT NULL,
   users_fk UUID NOT NULL,
   unique(name),
   primary key(id),
   CONSTRAINT fk_cook_users
          FOREIGN KEY (users_fk)
          REFERENCES COOKS(id)
);

CREATE TABLE recipe (
   id UUID NOT NULL,
   name VARCHAR(50) NOT NULL,
   cooks_fk VARCHAR NOT NULL,
   primary key(id),
   unique(name),
   CONSTRAINT fk_recipe_api_user
       FOREIGN KEY (cooks_fk)
       REFERENCES COOKS(id)
);


CREATE TABLE MONTH_REF (
   id NUMERIC,
   name VARCHAR(50) NOT NULL,
   primary key(id),
   unique(name),
   unique(id)
);
INSERT INTO MONTH_REF (id, name) values (1, 'Janvier');
INSERT INTO MONTH_REF (id, name) values (2, 'Février');
INSERT INTO MONTH_REF (id, name) values (3, 'Mars');
INSERT INTO MONTH_REF (id, name) values (4, 'Avril');
INSERT INTO MONTH_REF (id, name) values (5, 'Mai');
INSERT INTO MONTH_REF (id, name) values (6, 'Juin');
INSERT INTO MONTH_REF (id, name) values (7, 'Juillet');
INSERT INTO MONTH_REF (id, name) values (8, 'Août');
INSERT INTO MONTH_REF (id, name) values (9, 'Septembre');
INSERT INTO MONTH_REF (id, name) values (10, 'Octobre');
INSERT INTO MONTH_REF (id, name) values (11, 'Novembre');
INSERT INTO MONTH_REF (id, name) values (12, 'Décembre');


CREATE TABLE FOOD (
   id UUID NOT NULL,
   name VARCHAR(50) NOT NULL,
   season_start NUMERIC,
   season_end NUMERIC,
   primary key(id),
   unique(name),
   CONSTRAINT fk_food_season_start
       FOREIGN KEY (season_start)
       REFERENCES MONTH_REF(id),
   CONSTRAINT fk_food_season_end
          FOREIGN KEY (season_end)
          REFERENCES MONTH_REF(id)
);
INSERT INTO FOOD (id, name, season_start, season_end) values (
'450e8400-e29b-41d4-a716-446655440000',
'topinambour'
10,
2
);