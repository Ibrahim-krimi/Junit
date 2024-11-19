CREATE TABLE IF NOT EXISTS customers(
    id Integer primary key auto_increment,
    email varchar(100) unique not null
);