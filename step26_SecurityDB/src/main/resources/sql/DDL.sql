DROP TABLE MEMBER cascade constraint;

CREATE TABLE MEMBER(
	MEMBER_ID VARCHAR2(20) PRIMARY KEY, /*회원 ID */
	MEMBER_PASSWORD CHAR(60) NOT NULL, /*비밀번호*/
 	MEMBER_NAME VARCHAR2(100) NOT NULL, /*이름*/
	MEMBER_EMAIL VARCHAR2(100) NOT NULL /*이메일주소*/
);

--삽입 (admin-admin)
insert into member values('admin', '$2a$10$fbS1tn.E2iOsQ0aoDe5yQulgq.Z0tJUpSlWIzFvaVsi9JzvGzLs.m', '장희정', 'admindaum.net');

/*********************************占쏙옙占쏙옙 占쏙옙占싱븝옙********************************/
/*
 *  - ROLE_ADMIN
 *    - ROLE_MEMBER
 */
DROP TABLE AUTHORITIES;

CREATE TABLE AUTHORITIES(
	USERNAME VARCHAR2(100) NOT NULL, /* ID*/
	ROLE VARCHAR(30) NOT NULL,    /**/
	CONSTRAINT MEMBER_AUTHORITIES_FK FOREIGN KEY(USERNAME) REFERENCES MEMBER(MEMBER_ID),
	CONSTRAINT AUTHORITIES_PK PRIMARY KEY(USERNAME,ROLE)
);

insert into authorities values('admin', 'ROLE_ADMIN');
insert into authorities values('admin', 'ROLE_MEMBER');


commit





