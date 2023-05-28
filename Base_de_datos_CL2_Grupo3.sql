
create database projectoalmacen2;
use projectoalmacen2;
Create table tb_productos(
idprod int not null auto_increment,
descripcion varchar(100),
estado int ,
idtipo int,
precio double,
stock int,
constraint pk_tb_productos primary key(idprod) 
);
Create table tb_categorias(
idtipo int not null auto_increment,
nombrecategoria varchar(100),
constraint pk_tb_categorias primary key(idtipo) 
);

create table tb_proveedores(
idprov int not null auto_increment,
nombre varchar(255),
direccion varchar(255),
telefono char(9),
ruc char(11),
razonsocial varchar(255),
constraint pk_tb_proveedores primary key (idprov));

create table tb_usuarios(
idusu int not null auto_increment,
nombre varchar(255),
apellido varchar(255),
email varchar(255),
contraseña varchar(255),
constraint pk_tb_usuarios primary key (idusu));

create table tb_ordenes_de_compra(
idorden int not null auto_increment,
fecha DATE,
idprov int,
idusu int,
foreign key (idprov) references tb_proveedores(idprov),
foreign key (idusu) references tb_usuarios(idusu),
constraint pk_tb_ordenes_de_compra primary key (idorden)
);