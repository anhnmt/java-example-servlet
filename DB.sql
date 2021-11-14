create database DB_JSPServlet_Exam;

go

use DB_JSPServlet_Exam;

go

create table TblComputers
(
    ComId       int identity primary key,
    ComName     nvarchar(200),
    Producer    nvarchar(200),
    Description varchar(max),
    YearMaking  datetime,
    Price       float
)

go

insert into TblComputers(ComName, Producer, Description, YearMaking, Price)
VALUES ('HP Parvilion', 'HP', 'Corei5 8Gb Ram 500Gb HDD', '2017-05-12', 12000000),
       ('Acer Aspire', 'Acer', 'Corei3 4Gb Ram 500Gb HDD', '2016-11-28', 9000000),
       ('Dell Voltro', 'Dell', 'Corei7 8Gb Ram 500Gb HDD', '2017-12-11', 15000000),
       ('Sony Vaio', 'Sony', 'Corei5 8Gb Ram 500Gb HDD', '2017-05-12', 11000000);

go

select * from  TblComputers;