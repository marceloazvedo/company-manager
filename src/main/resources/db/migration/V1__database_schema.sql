CREATE TABLE role_group (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  description varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  updated_at datetime(6) DEFAULT NULL,
  created_at datetime(6) DEFAULT NULL,
  user_type varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  email varchar(255) NOT NULL UNIQUE,
  name varchar(255) DEFAULT NULL,
  password varchar(60) DEFAULT NULL,
  status bit(1) NOT NULL,
  updated_at datetime(6) DEFAULT NULL,
  created_at datetime(6) DEFAULT NULL,
  user_type varchar(255) DEFAULT NULL,
  role_group_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_user_role_group FOREIGN KEY (role_group_id) REFERENCES role_group(id)
);

CREATE TABLE client (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  updated_at datetime(6) DEFAULT NULL,
  user_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_client_user FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE company (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  cnpj varchar(255) NOT NULL UNIQUE,
  full_name varchar(255) DEFAULT NULL,
  updated_at datetime(6) DEFAULT NULL,
  created_at datetime(6) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE company_users (
    company_id bigint(20) NOT NULL,
    users_id bigint(20) NOT NULL,
    CONSTRAINT fk_company FOREIGN KEY (company_id) REFERENCES company(id),
    CONSTRAINT fk_users_company FOREIGN KEY (users_id) REFERENCES user(id)
);

-- INSERT ROLE_GROUP ADMIN
insert into role_group (description, name, user_type, created_at)
values ('Has access to all', 'ADMINISTRATORS','ADMINISTER', now());

-- INSERT ADMIN (Password: 123senha123)
insert into user
(created_at, email, name, password, status, user_type, role_group_id)
values
(now(), 'marceloazvedo1@gmail.com', 'Marcelo Santos de Azevedo', '$2a$10$mCBPmzt6orQusY0M3fGvAepSY5NMERZooXiHNHyRbnXuTUuZNEGU2', false, 'ADMINISTER',
    (select rg.id from role_group rg where user_type = 'ADMINISTER' limit 1)
);