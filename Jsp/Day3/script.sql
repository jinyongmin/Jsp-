use aidev;
create table tb_member;
select*from tb_member;
create table tb_member(						#테이블도 하나의 객체 tb(출신) 테이블의 멤버
	mem_idx int auto_increment primary key,				#테이블과 테이블을 합칠때 어떤테이블의 출신인지 알아보기 용이.,auto_increment(자동으로1 씩증가)
	mem_userid varchar(20) unique not null,
    mem_userpw varchar(20) not null,
    mem_name varchar(20) not null,
    mem_hp varchar(20) not null,
    mem_email varchar(50) not null,
    mem_hobby varchar(100),
    mem_ssn1 varchar(6) not null,
    mem_ssn2 varchar(7) not null,
    mem_zipcode varchar(5),
    mem_address1 varchar(100),
    mem_address2 varchar(100),
    mem_address3 varchar(100),
	mem_gender varchar(20)
    
);
alter table tb_member modify mem_userpw varchar(255);
desc tb_member;
delete from tb_member;
drop table tb_member;
truncate tb_member;
SET foreign_key_checks = 0; 
#SHA2
# 대표적인 단방향 암호화 해시함수
select sha2('1234', 256);	
select sha2('angel1004!))$',256);	

# tb_member의 비밀번호 저장 크기를 변경		다 탈퇴시키고 sha2로 비밀번호 암호화하고 ok페이지들을 서블릿으로 변환해서 작업.......................................
# 회원가입시 비밀번호를 SHA2를 이용하여 저장
# 로그인시 비밀번호를 SHA2로 체크하여 로그인
#ex) insert into 테이블명 (필드..) values (?,sha2(?,256), ?,...)
# 서블릿으로 변화해서 작업