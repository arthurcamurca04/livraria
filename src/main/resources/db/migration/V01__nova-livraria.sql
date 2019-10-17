create table livro(
	id bigint auto_increment not null,
	titulo varchar(80) not null,
	autor varchar(80) not null,
	editora varchar(80) not null,
	ano varchar(40) not null,
	preco decimal(10,2),
	primary key(id)
);
