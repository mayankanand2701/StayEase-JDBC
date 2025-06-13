create database hotel;
use hotel;

-- Code for Guests 

CREATE TABLE IF NOT EXISTS Guest (
    guestid INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    address VARCHAR(255),
    phone VARCHAR(15),
    email VARCHAR(100),
    age INT,
    gender VARCHAR(10),
    membership VARCHAR(20)
);

select * from guest;

-- Code for Rooms

CREATE TABLE Rooms (
    roomid INT PRIMARY KEY,
    roomtype VARCHAR(50),
    price DECIMAL(10,2),
    status VARCHAR(20)
);

INSERT INTO Rooms VALUES (101, 'Deluxe', 3500.00, 'Available');
INSERT INTO Rooms VALUES (102, 'Deluxe', 3500.00, 'Occupied');
INSERT INTO Rooms VALUES (103, 'Deluxe', 3500.00, 'Available');

INSERT INTO Rooms VALUES (201, 'Executive', 5000.00, 'Available');
INSERT INTO Rooms VALUES (202, 'Executive', 5000.00, 'Occupied');
INSERT INTO Rooms VALUES (203, 'Executive', 5000.00, 'Available');

INSERT INTO Rooms VALUES (301, 'Suite', 8000.00, 'Available');
INSERT INTO Rooms VALUES (302, 'Suite', 8000.00, 'Occupied');
INSERT INTO Rooms VALUES (303, 'Suite', 8000.00, 'Available');

INSERT INTO Rooms VALUES (401, 'Presidential Suite', 15000.00, 'Available');
INSERT INTO Rooms VALUES (402, 'Presidential Suite', 15000.00, 'Occupied');

Select * from rooms;

-- Code for Food Items

CREATE TABLE FoodItems (
    itemid INT PRIMARY KEY,
    itemname VARCHAR(100),
    price DECIMAL(10,2)
);

INSERT INTO FoodItems VALUES (1, 'Paneer Butter Masala', 220.00);
INSERT INTO FoodItems VALUES (2, 'Chicken Biryani', 250.00);
INSERT INTO FoodItems VALUES (3, 'Veg Fried Rice', 180.00);
INSERT INTO FoodItems VALUES (4, 'Tandoori Roti (2 pcs)', 40.00);
INSERT INTO FoodItems VALUES (5, 'Chocolate Brownie', 120.00);
INSERT INTO FoodItems VALUES (6, 'Cold Coffee', 90.00);

Select * from FoodItems;


-- Code for Food Order Table

CREATE TABLE FoodOrders (
    orderid INT PRIMARY KEY,
    guestid INT,
    itemid INT,
    roomid INT,
    numberofitems INT,
    totalamount DECIMAL(10,2),
    status VARCHAR(20),
    FOREIGN KEY (guestid) REFERENCES Guest(guestid),
    FOREIGN KEY (itemid) REFERENCES FoodItems(itemid),
    FOREIGN KEY (roomid) REFERENCES Rooms(roomid)
);
Select * from FoodOrders;



