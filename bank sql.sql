create table BANK.B2
(   Accountnumber VARCHAR(15) not null Primary key,
    Password VARCHAR(15) not null,
    Name VARCHAR(15) not null,
    DOB VARCHAR(10) not null,
    SEX VARCHAR(6) not null,
    PhoneNumber BIGINT not null,
    Balance BIGINT not null,
    IFSI VARCHAR(11) not null,
    email VARCHAR(19) not null,
    status numeric(1) not null,
    pin numeric(4) not null,
    Block VARCHAR(19) not null
);