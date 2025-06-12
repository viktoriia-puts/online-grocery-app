CREATE DATABASE IF NOT EXISTS shop;

CREATE TABLE shop.categories (
      id INT AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(255) NOT NULL
);

CREATE TABLE shop.products (
      id INT AUTO_INCREMENT PRIMARY KEY,
      price int,
      itemname varchar(255),
      quantity float,
      availability boolean,
      image_url VARCHAR(255),
      category_id int
);


INSERT INTO shop.categories (name)
VALUES
    ('Vegetables & Fruits'),
    ('Dairy Products'),
    ('Bakery & Bread'),
    ('Frozen Foods'),
    ('Cereals & Pasta'),
    ('Confectionery'),
    ('Seafood'),
    ('Nuts & Dried Fruits'),
    ('Snacks'),
    ('Tea & Coffee'),
    ('Alcohol'),
    ('Canned Goods'),
    ('Beverages'),
    ('Misc'),
    ('Rest');

CREATE TABLE shop.account (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

ALTER TABLE shop.products
    ADD CONSTRAINT fk_category
        FOREIGN KEY (category_id) REFERENCES shop.categories(id);


insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (44, 'Tart Shells - Savory, 4', 7, true, 'http://dummyimage.com/247x100.png/5fa2dd/ffffff', 15);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (5, 'Flower - Commercial Bronze', 1, true, 'http://dummyimage.com/241x100.png/dddddd/000000', 5);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (34, 'Bag Clear 10 Lb', 1, false, 'http://dummyimage.com/173x100.png/dddddd/000000', 11);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (64, 'Apron', 5, false, 'http://dummyimage.com/247x100.png/5fa2dd/ffffff', 3);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (80, 'Chilli Paste, Hot Sambal Oelek', 7, false, 'http://dummyimage.com/195x100.png/5fa2dd/ffffff', 6);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (62, 'Pop Shoppe Cream Soda', 3, false, 'http://dummyimage.com/236x100.png/cc0000/ffffff', 2);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (44, 'Mustard - Individual Pkg', 8, false, 'http://dummyimage.com/248x100.png/cc0000/ffffff', 7);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (38, 'Coconut - Creamed, Pure', 6, true, 'http://dummyimage.com/182x100.png/ff4444/ffffff', 15);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (78, 'Juice - Lime', 2, false, 'http://dummyimage.com/184x100.png/5fa2dd/ffffff', 1);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (11, 'Arrowroot', 4, false, 'http://dummyimage.com/153x100.png/cc0000/ffffff', 3);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (13, 'Sterno - Chafing Dish Fuel', 4, true, 'http://dummyimage.com/231x100.png/ff4444/ffffff', 11);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (62, 'Vinegar - White', 4, false, 'http://dummyimage.com/130x100.png/ff4444/ffffff', 15);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (93, 'Barramundi', 4, true, 'http://dummyimage.com/214x100.png/dddddd/000000', 11);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (45, 'Kiwano', 9, true, 'http://dummyimage.com/107x100.png/ff4444/ffffff', 6);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (66, 'Guinea Fowl', 2, false, 'http://dummyimage.com/161x100.png/cc0000/ffffff', 1);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (15, 'Oranges - Navel, 72', 9, false, 'http://dummyimage.com/207x100.png/5fa2dd/ffffff', 1);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (51, 'Cups 10oz Trans', 5, false, 'http://dummyimage.com/216x100.png/dddddd/000000', 3);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (19, 'Salmon - Fillets', 7, true, 'http://dummyimage.com/240x100.png/5fa2dd/ffffff', 7);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (26, 'Sauce - Plum', 1, false, 'http://dummyimage.com/133x100.png/ff4444/ffffff', 9);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (75, 'Coffee - Flavoured', 7, true, 'http://dummyimage.com/212x100.png/5fa2dd/ffffff', 8);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (44, 'Peas Snow', 5, true, 'http://dummyimage.com/113x100.png/cc0000/ffffff', 7);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (21, 'Maintenance Removal Charge', 5, true, 'http://dummyimage.com/101x100.png/5fa2dd/ffffff', 6);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (89, 'Mousse - Mango', 7, false, 'http://dummyimage.com/209x100.png/cc0000/ffffff', 11);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (10, 'Wine - Prosecco Valdobienne', 9, false, 'http://dummyimage.com/113x100.png/ff4444/ffffff', 9);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (57, 'Sansho Powder', 3, false, 'http://dummyimage.com/149x100.png/5fa2dd/ffffff', 15);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (57, 'Beer - Corona', 2, false, 'http://dummyimage.com/246x100.png/ff4444/ffffff', 12);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (52, 'Crackers - Trio', 1, true, 'http://dummyimage.com/160x100.png/ff4444/ffffff', 12);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (11, 'Peas Snow', 10, false, 'http://dummyimage.com/222x100.png/dddddd/000000', 6);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (43, 'Asparagus - White, Canned', 2, false, 'http://dummyimage.com/227x100.png/ff4444/ffffff', 9);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (45, 'Appetizer - Southwestern', 2, false, 'http://dummyimage.com/198x100.png/5fa2dd/ffffff', 10);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (64, 'Pork - Butt, Boneless', 1, true, 'http://dummyimage.com/141x100.png/cc0000/ffffff', 1);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (71, 'Sauce - Chili', 5, true, 'http://dummyimage.com/128x100.png/dddddd/000000', 9);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (38, 'Tomatoes - Grape', 1, true, 'http://dummyimage.com/109x100.png/5fa2dd/ffffff', 7);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (94, 'Fondant - Icing', 8, false, 'http://dummyimage.com/105x100.png/dddddd/000000', 10);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (72, 'Wine - Black Tower Qr', 4, true, 'http://dummyimage.com/196x100.png/dddddd/000000', 8);
insert into shop.products (price, itemname, quantity, availability, image_url, category_id) values (7, 'Tart Shells - Sweet, 2', 3, true, 'http://dummyimage.com/117x100.png/5fa2dd/ffffff', 2);