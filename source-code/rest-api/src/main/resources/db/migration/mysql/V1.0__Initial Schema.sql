-- MySQL InnoDB Schema
create table application_info (
    id VARCHAR(36),
    info_name VARCHAR(255) NOT NULL,
    info_description VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (info_name)
) Engine=InnoDB;