--jblog


--cmd 콘솔 sql 접속
sqlplus system/manager

--jblog 계정생성
CREATE USER jblog IDENTIFIED BY jblog ;

--jblog 계정 비번 변경
ALTER USER jblog IDENTIFIED BY jblog ACCOUNT UNLOCK;

--jblog 권한주기
grant resource, connect to jblog;





--테이블 삭제
drop table users;

--users 테이블 만들기 c5
create table    users ( 
                userNo number(10) --회원식별번호 pk
                , id  varchar2(50) UNIQUE NOT NULL --아이디 낫널 유니크
                , userName varchar2(100) NOT NULL
                , password varchar2(50) NOT NULL
                , joinDate date NOT NULL
                , primary key (userNo) --프라이머리 키 지정
);
                
-- blog 테이블 만들기 c3
create table    blog ( 
                id varchar2(50) -- pk fk 식별번호
                , blogTitle varchar2(200) NOT NULL --아이디 낫널 유니크
                , logoFile varchar2(200) -- 블로그이미지경로
                , primary key (id) --프라이머리 키 지정
, CONSTRAINT blog_fk FOREIGN KEY (id) REFERENCES users(id)
);

-- category 테이블 만들기 c5
create table    category ( 
                cateNo number(10) --pk 식별번호
                , id varchar2(50) -- fk 회원
                , cateName varchar2(200) NOT NULL -- 카테고리 이름
                , description varchar2(500) --카테고리 설명
                , regDate date NOT NULL -- 등록일
                , primary key (cateNo) --프라이머리 키 지정
, CONSTRAINT category_fk FOREIGN KEY (id) REFERENCES blog(id)
);

-- post 테이블 만들기 c5
create table    post ( 
                postNo number(10) --pk 식별번호
                , cateNo number(10) --fk 식별번호
                , postTitle varchar2(300) NOT NULL --글제목
                , postContent varchar2(4000) --글내용
                , regDate date NOT NULL --글 등록일
                , primary key (postNo) --프라이머리 키 지정
, CONSTRAINT post_fk FOREIGN KEY (cateNo) REFERENCES category(cateNo)
);

-- comments 테이블 만들기 c5
create table    comments ( 
                cmtNo number(10) --pk 식별번호
                , postNo number(10) -- fk 글번호
                , userNo number(10) -- fk 회원번호
                , cmtContent varchar2(1000) NOT NULL --댓글내용
                , regDate date NOT NULL --등록일
                , primary key (cmtNo) --프라이머리 키 지정
, CONSTRAINT comments_fk1 FOREIGN KEY (postNo) REFERENCES post(postNo)                
, CONSTRAINT comments_fk2 FOREIGN KEY (userNo) REFERENCES users(userNo)                
);

drop table comments;

--시퀀스
--id 번호 자동생성 꼬일때 초기화 (리셋)
drop sequence seq_users_no;
drop sequence seq_category_no;
drop sequence seq_post_no;
drop sequence seq_comments_no;

--번호 자동생성을 위한 시퀀스 sequence
create sequence seq_users_no
increment by 1
START WITH 1
nocache
;

create sequence seq_category_no
increment by 1
START WITH 1
nocache
;

create sequence seq_post_no
increment by 1
START WITH 1
nocache
;

create sequence seq_comments_no
increment by 1
START WITH 1
nocache
;



