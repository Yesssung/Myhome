-- 테이블 생성
CREATE TABLE users (
    no number primary key,
    name varchar2(20) NOT NULL,
    password varchar2(20) NOT NULL,
    email varchar2(128) NOT NULL UNIQUE,
    gender char(1) CHECK(gender IN ('M', 'F')),
    created_at date DEFAULT sysdate);
    
-- 시퀀스 생성
CREATE SEQUENCE seq_users_pk 
START WITH 1
INCREMENT BY 1;