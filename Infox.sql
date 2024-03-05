create database dbinfox;
use dbinfox;
create table tbusuarios(
iduser int primary key,
usuario varchar(50) not null,
fone varchar (15),
login varchar (15)not null unique,
senha varchar (15)not null
);

select * from tbusuarios;
describe tbusuarios;
describe tbclientes;
select * from tbclientes;

insert into tbusuarios(iduser,usuario,fone,login,senha)
values(1,'Sara Viana', '99161-6825','saraviana04','123456');

insert into tbusuarios(iduser,usuario,fone,login,senha)
values(2, 'Administrador', '99161-6825', 'admin', 'admin');

insert into tbusuarios(iduser,usuario,fone,login,senha)
values(3,'Elson Viana', '98149-4165','ElsonViana04','123456');

update tbusuarios set fone ='8888-8888' where iduser=2;

delete from tbusuarios where iduser = 3;

create table tbclientes(
idcli int primary key auto_increment,
nomecli varchar(50) not null,
endcli varchar(100),
fonecli varchar(50) not null,
emailcli varchar(50)
);


insert into tbclientes(nomecli,endcli,fonecli,emailcli)
values('Alda Celia', 'quadra 57,13','98888-1013','aldacelia@gmail.com');


create table tbos(
os int primary key auto_increment,
data_os timestamp default current_timestamp,
equipamento varchar(150) not null,
defeito varchar(150) not null,
servico varchar(150),
tecnico varchar (30),
valor decimal(10,2),
idcli int not null,
foreign key(idcli) references tbclientes(idcli)
);

describe tbos;
select * from tbos;

insert into tbos(equipamento,defeito,servico,tecnico,valor,idcli)
values('notebook','tela','trocar tela','sara',87.50,'1');

select
O.os,equipamento,defeito,servico,valor,
C.nomecli,fonecli
from tbos as O 
inner join tbclientes as C
on (O.idcli = C.idcli);









