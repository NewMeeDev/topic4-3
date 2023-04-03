use ordersDB;

select * from orders;

insert into orders (order_number, product_name, price, qty) values('a-228', 'Easy diet pills.', 950, 1);
insert into orders (order_number, product_name, price, qty) values('z-242', 'Brain memory extender.', 499, 1);
insert into orders (order_number, product_name, price, qty) values('m-801', 'Personality transplant.', 1400, 2);
insert into orders (order_number, product_name, price, qty) values('b-002', 'Risk-free muscle steroid builder.', 1999, 1);
insert into orders (order_number, product_name, price, qty) values('c-777', 'Liqid luck.', 2900, 1);
insert into orders (order_number, product_name, price, qty) values('t-1111', 'One absolutely perfect day.', 4200, 1);
insert into orders (order_number, product_name, price, qty) values('h-412', 'Hindsight vision from tomorrow.', 400, 4);
insert into orders (order_number, product_name, price, qty) values('g-555', 'Persuasive charm.', 300, 4);
insert into orders (order_number, product_name, price, qty) values('w-010', 'Instant college degree.', 6000, 2);
insert into orders (order_number, product_name, price, qty) values('v-622', '5 magic beans.', 50, 2);
insert into orders (order_number, product_name, price, qty) values('s-009', 'One million LIKES.', 660, 2);
insert into orders (order_number, product_name, price, qty) values('a-522', 'Regret remover.', 100, 1);

-- einen Admin-User anlegen
create user 'springuser'@'%' identified by '#EBIT2022'; -- Creates the user

-- dem Springboot User alle Rechte auf die gerade angelegte DB geben
grant all on ordersDB.* to 'springuser'@'%';
