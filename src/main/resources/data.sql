ALTER TABLE if exists recipe
DROP CONSTRAINT  IF EXISTS fk_recipe_api_user;
ALTER TABLE if exists api_user
DROP CONSTRAINT IF EXISTS fk_api_user_role;


DROP TABLE IF EXISTS api_user;
DROP TABLE IF EXISTS recipe;
DROP TABLE IF EXISTS role;




CREATE TABLE api_user (
   id UUID NOT NULL,
   name VARCHAR(50) NOT NULL,
   email VARCHAR,
   encrypted_password VARCHAR,
   creation_date DATE NOT NULL,
   role VARCHAR,
   unique(email),
   primary key(id)
);
INSERT INTO api_user (id, name,  email, encrypted_password, creation_date, role) values (
    '550e8400-e29b-41d4-a716-446655440000',
    'admin',
    'admin',
    '$2a$10$JVWfPunx/.7PDxNjk8XH3eHsw0/eGP8ZiSA4l9FjFfPr.HAKQ6QK.',
    '2023-11-07',
    'ADMIN'
);
INSERT INTO api_user (id, name,  email, encrypted_password, creation_date, role) values (
    '450e8400-e29b-41d4-a716-446655440000',
    'user',
    'user',
    '$2a$10$JVWfPunx/.7PDxNjk8XH3eHsw0/eGP8ZiSA4l9FjFfPr.HAKQ6QK.',
    '2023-11-07',
    'USER'
);

CREATE TABLE recipe (
   id UUID NOT NULL,
   name VARCHAR(50) NOT NULL,
   creation_date DATE NOT NULL,
   steps VARCHAR NOT NULL,
   created_by VARCHAR NOT NULL,
   primary key(id),
   unique(name),
   CONSTRAINT fk_recipe_api_user
       FOREIGN KEY (created_by)
       REFERENCES api_user(id)
);

