create table reg_user (
   id                   int                  AUTO_INCREMENT,
   username             varchar(20)           not null,
   password             char(40)              not null,
   sex                  boolean              not null,
   email                varchar(100)          not null,
   pwd_question         varchar(50)           null,
   pwd_answer           varchar(50)          null,
   reg_date              datetime              not null,
   last_login_date        datetime                null,
   last_login_ip          varchar(15)             null,
   constraint PK_REG_USER primary key  (id)
);
