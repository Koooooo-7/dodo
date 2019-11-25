CREATE TABLE dodo_banner
(
    id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name varchar(100),
    src varchar(255),
    sort int,
    status int DEFAULT 0,
    created_time TIMESTAMP(3) DEFAULT now(),
    updated_time TIMESTAMP(3) DEFAULT now(),
    created_by int DEFAULT 0,
    updated_by int DEFAULT 0
);
COMMENT ON COLUMN dodo_banner.status IS 'delete:0';
COMMENT ON TABLE dodo_banner IS 'table_banner';