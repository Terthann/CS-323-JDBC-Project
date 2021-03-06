-- Created by Andrew Lucas & Giovanni Salas

-- DDL to create the Database.

Create Table writingGroups
(
    groupName Varchar(50) Not Null,
    headWriter Varchar(50),
    yearFormed Int,
    subject Varchar(100),

    Constraint writingGroup_pk
    Primary Key (groupName)
);

Create Table publishers
(
    publisherName Varchar(50) Not Null,
    publisherAddress Varchar(50),
    publisherPhone Varchar(20),
    publisherEmail Varchar(50),

    Constraint publisher_pk
    Primary Key (publisherName)
);

Create Table books
(
    groupName Varchar(50) Not Null,
    bookTitle Varchar(100) Not Null,
    publisherName Varchar(50) Not Null,
    yearPublished Int,
    numberPages Int,

    Constraint books_group_fk
    Foreign Key (groupName)
    References writingGroups (groupName),

    Constraint books_publisher_fk
    Foreign Key (publisherName)
    References publishers (publisherName),

    Constraint books_pk
    Primary Key (groupName, bookTitle, publisherName),

    Constraint books_uk
    Unique (bookTitle, publisherName)
);

-- DML to populate the tables.

Insert Into writingGroups
(groupName, headWriter, yearFormed, subject)
Values
('The A-Team', 'Mr. T', 1990, 'saving the world'),
('The B-Team', 'Iced Tea', 2010, 'cooking tips');

Insert Into publishers
(publisherName, publisherAddress, publisherPhone, publisherEmail)
Values
('Andrew Lucas', '123 Unreal Drive', '555-666-7711', 'alucas@fake.com'),
('Madison Lucas', '321 Real Lane', '666-555-1177', 'mlucas@fake.com'),
('Brandon Sanderson', '5000 Writer Circle', '123-456-7890', 'bsanderson@who.com');

Insert Into books
(groupName, bookTitle, publisherName, yearPublished, numberPages)
Values
('The A-Team', 'Heroes 101', 'Andrew Lucas', 2015, 500),
('The B-Team', 'Pie or Cake?', 'Madison Lucas', 2012, 1000),
('The A-Team', 'Villians 101', 'Andrew Lucas', 2005, 700),
('The B-Team', 'The Perfect Burger', 'Andrew Lucas', 2018, 50),
('The A-Team', 'Teamwork Dreamwork', 'Brandon Sanderson', 1996, 250);