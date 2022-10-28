create table cliente (
     id bigint not null auto_increment,
     nome varchar(150) not null,
     email varchar(100) not null,
     fone varchar(20) not null,
     primary key(id)
);

insert into cliente(id, nome, email, fone) values
(1, "Ester Daiane Camila da Paz", "ester_dapaz@yoma.com.br", "31993912546"),
(2, "Antonella Isabelly Silvana Assis", "antonella.isabelly.assis@phocus.com.br", "96981617185"),
(3, "Sebastiana Emilly Ferreira", "sebastiana_emilly_ferreira@consultorialk.com.br", "81986266746"),
(4, "Brenda Luciana Elza Baptista", "brendalucianabaptista@gmail.com", "96996104113"),
(5, "Benjamin Pedro Henrique Baptista", "benjamin_baptista@virtualcriativa.com.br", "96985553437");