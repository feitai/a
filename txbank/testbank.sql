

create database testBank;
use testBank;


    create  table accounts
    (
        accountid int primary key auto_increment not null,
        balance numeric(10,2)
    );

create table oprecord
(
    id int primary key auto_increment not null,
    accountid int references accounts(accountid),
    opmoney numeric(10,2),
    optime datetime ,
    optype enum('deposite','withdraw','tracsfer') not null,
    transferid varchar(50)
);