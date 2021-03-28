CREATE TABLE role_group (
  id bigint(20) NOT NULL,
  create_at datetime(6) DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  update_at datetime(6) DEFAULT NULL,
  user_type varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  create_at datetime(6) DEFAULT NULL,
  email varchar(255) NOT NULL UNIQUE,
  name varchar(255) DEFAULT NULL,
  password varchar(60) DEFAULT NULL,
  status bit(1) NOT NULL,
  update_at datetime(6) DEFAULT NULL,
  user_type varchar(255) DEFAULT NULL,
  role_group_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_user_role_group FOREIGN KEY (role_group_id) REFERENCES role_group(id)
);

-- INSERT ROLE_GROUP ADMIN
insert into role_group
(id, description, name, user_type)
values
(last_insert_id(), 'Has access to all.', 'ADMINISTRATORS','ADMINISTER');

-- INSERT ADMIN (Password: 123senha123)
insert into user
(id, create_at, email, name, password, status, user_type, role_group_id)
values
(last_insert_id(), now(), 'marceloazvedo1@gmail.com', 'Marcelo Santos de Azevedo', '$2a$10$mCBPmzt6orQusY0M3fGvAepSY5NMERZooXiHNHyRbnXuTUuZNEGU2', false, 'ADMINISTER',
    (select rg.id from role_group rg where user_type = 'ADMINISTER' limit 1)
);