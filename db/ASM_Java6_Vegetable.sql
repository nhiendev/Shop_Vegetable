create database ASM_Java6_Vegetable

use ASM_Java6_Vegetable

create table Users (
	id bigint IDENTITY(1,1) primary key  not null,
	username nvarchar(255) ,
	password nvarchar (255) not null,
	fullname  nvarchar (255) not null,
	phone varchar(11) not null,
	email nvarchar (255) not null  unique, /* unique : độc nhất*/
	admin int	not null default 0
)
create table Orders(
	id bigint IDENTITY(1,1) primary key ,
	usernameid bigint   not null,
	address nvarchar(255) not null,
	createdate datetime, 
	status int not null
	foreign key (usernameid)
		references Users(id)
)
create table Categories(
	id char(10) primary key,
	name nvarchar(255) not null

)
create table Products(
	id bigint IDENTITY(1,1)  primary key,
	name nvarchar(255) not null,
	img nvarchar(255) ,
	price float not null,
	createdate datetime,
	avialable bit ,
	description nvarchar(max),
	quantity int default 0 ,
	categoryId char(10)
	foreign key (categoryId) references Categories(id) 
)
create table Favorite(
	id bigint IDENTITY(1,1)  primary key,
	productId bigint not null,
	userID bigint not null,
	reviews nvarchar(250) 
	foreign key (productId) references Products(id) on delete cascade on update cascade ,
	foreign key (userID) references Users(id) 	on delete cascade on update cascade
)


create table OrdersDetails(
	id bigint IDENTITY(1,1)  primary key ,
	orderId bigint ,
	productId bigint not null,
	price float not null,
	quantity int not null 
	foreign key (productId)	references Products(id),
	foreign key (orderId) references Orders(id)
)
select * from categories

insert into Products values (N'Fontana Peach & Apple Juice 1 liter',N'product-15.jpg',80, GETDATE(),1,N'They are rich in vitamin C and dietary fiber that keep our digestive and immune system healthy. It is also known to protects from alzheimers, type 2 diabetes and cancer. Eating apples without removing the peel also lowers the risk of obesity.',70,'juices')

insert into Products
values (N'APPLE',N'product-10.jpg',50, GETDATE(),0,N'They are rich in vitamin C and dietary fiber that keep our digestive and immune system healthy. It is also known to protects from alzheimers, type 2 diabetes and cancer. Eating apples without removing the peel also lowers the risk of obesity.',200,'fruit'),
	  (N'GREEN BEANS',N'product-3.jpg',30, GETDATE(),0,N'Okra contains a good amount of vitamin K and C as well as Iron and Folate which boosts blood health and prevent anemia and increases immunity. Okra being high in fiber also helps regulate blood sugar and keep heart healthy.',100,'vegetable'),
	  (N'PURPLE CABBAGE',N'product-4.jpg',10, GETDATE(),0,N'Okra contains a good amount of vitamin K and C as well as Iron and Folate which boosts blood health and prevent anemia and increases immunity. Okra being high in fiber also helps regulate blood sugar and keep heart healthy.',50,'vegetable'),
	  (N'BROCOLLI',N'product-6.jpg',5, GETDATE(),0,N'Okra contains a good amount of vitamin K and C as well as Iron and Folate which boosts blood health and prevent anemia and increases immunity. Okra being high in fiber also helps regulate blood sugar and keep heart healthy.',50,'vegetable'),
	  (N'ONION',N'product-9.jpg',5, GETDATE(),0,N'Raw onion is known to lower the production of LDL (bad cholesterol) and keep your heart healthy. The vitamin C (which remains intact while they are in the raw form) along with the phytochemicals present in onions helps build immunity.',30,'vegetable'),
	  (N'CHILLI',N'product-12.jpg',5, GETDATE(),0,N'Raw onion is known to lower the production of LDL (bad cholesterol) and keep your heart healthy. The vitamin C (which remains intact while they are in the raw form) along with the phytochemicals present in onions helps build immunity.',30,'vegetable'),
	  (N'FRUIT JUICE',N'product-8.jpg',40, GETDATE(),0,N'They are rich in vitamin C and dietary fiber that keep our digestive and immune system healthy. It is also known to protects from alzheimers, type 2 diabetes and cancer. Eating apples without removing the peel also lowers the risk of obesity.',200,'juices'),
	  (N'Dried Unpeel Cashews',N'hatdieu.jpg',180, GETDATE(),0,N'A suitable choice for everyone, a rich source of plant-based nutrition, vitamins, and minerals such as fiber, protein, calcium, iron, copper, magnesium, vitamin K, B6, selenium, phosphorous…',100,'dried'),
	  (N'Trail mix',N'hatkho1.jpg',120, GETDATE(),0,N'A suitable choice for everyone, a rich source of plant-based nutrition, vitamins, and minerals such as fiber, protein, calcium, iron, copper, magnesium, vitamin K, B6, selenium, phosphorous…',100,'dried')






