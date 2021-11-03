create table constr_company
(
    id          serial primary key,
    name        varchar(255) unique not null,
    description text                null,
    logo        varchar(255)
);

create table house
(
    id                   serial primary key,
    company_id           int references constr_company (id) on delete cascade on update cascade,
    address              varchar(255) unique not null,
    name                 varchar(255) unique not null,
    constr_start_date    date                null,
    constr_complete_date date                null,
    exploit_date         date                null,
    photo                varchar(255)
);

create type state as enum ('SALE', 'RESERVED', 'SOLD');

create table apartment
(
    id          serial primary key,
    number      int not null,
    house_id    int references house (id) on delete cascade on update cascade,
    entrance    int not null check ( entrance > 0 ),
    floor       int not null check ( floor > 0 ),
    rooms_count int not null check ( rooms_count > 0 ),
    total_area  float,
    living_area float,
    price       int,
    status      state,
    layout_img  varchar(255)
);

create table client
(
    id      serial primary key,
    name    varchar(255) not null,
    surname varchar(255) not null
);


create table owner
(
    client_id    int not null references client (id) on delete cascade on update cascade,
    apartment_id int not null references apartment (id) on delete cascade on update cascade,
    primary key (client_id, apartment_id)
);

