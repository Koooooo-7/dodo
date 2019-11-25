CREATE TABLE dodo_user
(
    id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    username varchar(100),
    password varchar(100),
    role int,
    created_time TIMESTAMP(3) DEFAULT now(),
    updated_time TIMESTAMP(3) DEFAULT now(),
    created_by int DEFAULT 0,
    updated_by int DEFAULT 0
);
COMMENT ON COLUMN dodo_user.role IS 'admin:0';
COMMENT ON TABLE dodo_user IS 'table_user';