/*create database opensongsdb;
create user 'opensongs'@'localhost' IDENTIFIED BY 'Mus1c4!';
grant all PRIVILEGES ON opensongsdb.* to 'opensongs'@'localhost';


CREATE TABLE tblmusica(
	idMusica int not null auto_increment,
    artista varchar(100),
    album varchar(100),
    estilo int,
    linkMP3 text,
    constraint pkMusica primary key(idMusica)
);

create table tblUsuario(
	idUsuario int not null auto_increment,
    nome varchar(100),
    email varchar(100),
    senha varchar(20),
    constraint pkUsuario primary key(idUsuario)
);

create table tblPlaylist(
	idPlaylist int not null auto_increment,
    titulo varchar(150),
	idUsuario int not null,
    constraint pkPlaylist primary key(idPlaylist),
    constraint fkUsuario foreign key(idUsuario) references tblUsuario(idUsuario)
);

create table tblMusicaPlaylist(
	idPlaylist int not null,
    idMusica int not null,
    constraint pkMP primary key(idPlaylist,idMusica),
    constraint fkPl foreign key(idPlaylist) references tblPlaylist(idPlaylist),
    constraint fkMu foreign key(idMusica) references tblMusica(idMusica)
);
insert into tblUsuario values
	(null,'Jonas','jonas@email.com','1234'),
    (null,'Cassia','cassia@email.com','cassia123'),
    (null,'Valdomiro','valdomiro@email.com','valdomiro123');
*/
use opensongsdb;

Select * from tblUsuario;