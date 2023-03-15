use aidev;

create table tb_ts_member(
	mem_idx int auto_increment primary key,					
    mem_userid varchar(20) unique not null,
    mem_userpw varchar(256) not null,
    mem_name varchar(20) not null,
    mem_email varchar(50) not null,
	mem_gender varchar(100),
	mem_hp varchar(20) not null,
    mem_job varchar(200),
	mem_regdate datetime default now(),
	mem_point int
);

create table tb_ts_board(
	b_idx int auto_increment primary key,
    b_userid varchar(20) not null,
    b_title varchar(100) not null,
    b_content text not null,
    b_hit int default 0,
    b_regdate datetime default now()
);

create table tb_ts_reply(
	re_idx int auto_increment primary key,
    re_userid varchar(20) not null,
    re_content varchar(2000) not null,
	re_boardidx int, 
    re_regdate datetime default now(),
    foreign key (re_boardidx) references tb_ts_board(b_idx) on update cascade
);	

create table tb_ts_point(
	po_idx int auto_increment primary key,
    po_boardidx int,
	po_userid varchar(20) not null,
    po_point int,
    po_totpoint int,
    po_regdate datetime default now(),
	foreign key (po_boardidx) references tb_ts_board(b_idx) on delete cascade
) ;


create table tb_ts_b_hit(
	h_idx int auto_increment primary key,
    h_b_idx int not null,
    h_b_userid varchar(20)
);



select * from tb_ts_member;
select * from tb_ts_board;
select * from tb_ts_reply;
select * from tb_ts_point;
select * from tb_ts_b_hit;

select b_idx from tb_ts_board where b_userid ='apple' and b_content='1112'  order by b_idx desc;


drop table tb_ts_member;
drop table tb_ts_board;
drop table tb_ts_reply;
drop table tb_ts_point;
drop table tb_ts_b_hit;
