/* ���� */
DROP TABLE tb_quest 
	CASCADE CONSTRAINTS;

/* ȸ������ */
DROP TABLE tb_user 
	CASCADE CONSTRAINTS;

/* ä�� �� �м� */
DROP TABLE tb_result 
	CASCADE CONSTRAINTS;

/* �����Ʈ */
DROP TABLE tb_error 
	CASCADE CONSTRAINTS;

/* �������� */
DROP TABLE tb_notice 
	CASCADE CONSTRAINTS;

/* ���� */
CREATE TABLE tb_quest (
	qno NUMBER(5) NOT NULL, /* ������ȣ */
	sub VARCHAR2(20), /* �����ȣ */
	quest VARCHAR2(2000), /* ����+���� */
	ans NUMBER(1), /* �� */
	exp VARCHAR2(2000), /* �ؼ� */
	keywd VARCHAR2(20), /* Ű���� */
	inans VARCHAR2(20) /* ����� */
);

CREATE UNIQUE INDEX PK_tb_quest
	ON tb_quest (
		qno ASC
	);

ALTER TABLE tb_quest
	ADD
		CONSTRAINT PK_tb_quest
		PRIMARY KEY (
			qno
		);

/* ȸ������ */
CREATE TABLE tb_user (
	userid VARCHAR2(20) NOT NULL, /* ID */
	pwd VARCHAR2(50), /* ��й�ȣ */
	manager NUMBER(5) /* ������ */
);

CREATE UNIQUE INDEX PK_tb_user
	ON tb_user (
		userid ASC
	);

ALTER TABLE tb_user
	ADD
		CONSTRAINT PK_tb_user
		PRIMARY KEY (
			userid
		);

/* ä�� �� �м� */
CREATE TABLE tb_result (
	userid VARCHAR2(20) NOT NULL, /* ID */
	COL NUMBER(5), /* �м���ȣ */
	sub1 number(3), /* 1�������� */
	sub2 number(3), /* 2�������� */
	sub3 number(3), /* 3�������� */
	sub4 number(3), /* 4�������� */
	sub5 number(3), /* 5�������� */
	avg number(3), /* ������� */
	testdt VARCHAR2(20) /* �������� */
);

CREATE UNIQUE INDEX PK_tb_result
	ON tb_result (
		userid ASC
	);

ALTER TABLE tb_result
	ADD
		CONSTRAINT PK_tb_result
		PRIMARY KEY (
			userid
		);

/* �����Ʈ */
CREATE TABLE tb_error (
	qno NUMBER(5) NOT NULL, /* ������ȣ */
	userid VARCHAR2(20), /* ID */
	e_ans NUMBER(5), /* Ǭ�� */
	ecount NUMBER(5) /* Ʋ��Ƚ�� */
);

CREATE UNIQUE INDEX PK_tb_error
	ON tb_error (
		qno ASC
	);

ALTER TABLE tb_error
	ADD
		CONSTRAINT PK_tb_error
		PRIMARY KEY (
			qno
		);

/* �������� */
CREATE TABLE tb_notice (
	nno NUMBER(5) NOT NULL, /* ������ȣ */
	title VARCHAR2(50), /* ���� */
	cont VARCHAR2(255), /* ���� */
	regdt VARCHAR2(20), /* ������� */
	userid VARCHAR2(20) /* ID */
);

CREATE UNIQUE INDEX PK_tb_notice
	ON tb_notice (
		nno ASC
	);

ALTER TABLE tb_notice
	ADD
		CONSTRAINT PK_tb_notice
		PRIMARY KEY (
			nno
		);

ALTER TABLE tb_result
	ADD
		CONSTRAINT FK_tb_user_TO_tb_result
		FOREIGN KEY (
			userid
		)
		REFERENCES tb_user (
			userid
		);

ALTER TABLE tb_error
	ADD
		CONSTRAINT FK_tb_quest_TO_tb_error
		FOREIGN KEY (
			qno
		)
		REFERENCES tb_quest (
			qno
		);

ALTER TABLE tb_notice
	ADD
		CONSTRAINT FK_tb_user_TO_tb_notice
		FOREIGN KEY (
			userid
		)
		REFERENCES tb_user (
			userid
		);
		
create sequence quest_seq;
create sequence notice_seq;

insert into tb_user values('admin','admin',1)


insert into tb_quest values(quest_seq.nextval, 
1, 
'�����ؼ��� ���� �������� ���� ���� ����?
�� ������ ������Ŷ �ؼ��� ����� �ΰ� �ִ�.
�� ���� ������ ���� �������� �ڵ�(Codd)�� ���� �����ͺ��̽��� ������ �� �ֵ��� �����Ͽ� �����Ͽ���.
�� Ʃ�� �����ؼ��� ������ �����ؼ��� �ִ�.
�� ���ϴ� ������ �� ������ ��� �����ϴ°��� ����ϴ� ������ Ư���� ������.', 
4, 
'4���� �������� ���� �����Դϴ�.
�����ؼ�- E.F.Codd �ڵ尡 ������ Predicate�������� calculus �� ����� �ΰ� �����ߴ�-�������� Ư���� ���Ѵ�-Ʃ�ð����ؼ��� ������ �����ؼ��� �ִ�-��� ������ ����� � �����͸� �������� ���@�����ؼ��� �������� ���� �����ͺ��̽��� ó���ϴ� ��ɰ� �ɷ¸鿡�� �����ϴ�', 
'�����ؼ�',
 0)
 
 
 
insert into tb_quest values(quest_seq.nextval, 
1, 
'���� ���� ���Ͽ� ���� �������� ���� ���� ����?
�� ���ڵ带 ������ �� ������ Ž���� �� ������ ����Ű�� �����͸� ����Ͽ� ���� ������ �� �ִ�.
�� ���ڵ带 �߰� �� �����ϴ� ���, ���� ��ü�� ������ �ʿ䰡 ����.
�� �ε����� �����ϱ� ���� ������ �����÷ο� ó���� ���� ������ ������ �ʿ� ����.
�� ���� ������ Ʈ�� ���� ����, �Ǹ��� ���� ����, ������ ���� �������� �����ȴ�.', 
3, 
'���� ���� ������ �ε����� �����ϱ� ���� ������ �����÷ο� ó���� ���� ������ ������ �ʿ��ϱ� ������ ���� ȿ������ �������� ���Դϴ�.', 
'���� ���� ����',
 0)

insert into tb_quest values(quest_seq.nextval, 
1, 
'��(VIEW)�� ���� �������� ���� ���� ����?
�� DBA�� ���� ���鿡�� �並 Ȱ���� �� �ִ�.
�� �� ���� �� �ٸ� �並 ������ �� �ִ�.
�� �信 ���� ����, ����, ���� ���� �� ���� ������ ������ �ʴ´�.
�� ���� ���Ǵ� ALTER���� �̿��Ͽ� ������ �� ����.', 
3, 
'��� ������ ���뿡 ���� ����,����, ���� ���� ����', 
'��',
 0)
 
 select * from tb_error;
 select que.qno, userid, sub, quest, ans, exp, e_ans, ecount from tb_error err left join tb_quest que on err.qno = que.qno
commit