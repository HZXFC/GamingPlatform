/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/4/6 21:13:38                            */
/*==============================================================*/


drop table if exists comment;

drop table if exists gameMatch;

drop table if exists regist_multi;

drop table if exists regist_multi_member;

drop table if exists regist_solo;

drop table if exists user;

/*==============================================================*/
/* Table: comment                                               */
/*==============================================================*/
create table comment
(
   userID               int,
   matchID              int,
   date                 datetime,
   content              varchar(256)
);

/*==============================================================*/
/* Table: gameMatch                                             */
/*==============================================================*/
create table gameMatch
(
   matchIMG             varchar(256),
   matchName            varchar(256),
   deadline             datetime,
   teamNum              int,
   personNum            int,
   ruleID               int,
   area                 varchar(256),
   award                int,
   startTime            datetime,
   matchID              int not null,
   primary key (matchID)
);

/*==============================================================*/
/* Table: regist_multi                                          */
/*==============================================================*/
create table regist_multi
(
   userID               int,
   matchID              int,
   groupID              int not null,
   primary key (groupID)
);

/*==============================================================*/
/* Table: regist_multi_member                                   */
/*==============================================================*/
create table regist_multi_member
(
   groupID              int
);

/*==============================================================*/
/* Table: regist_solo                                           */
/*==============================================================*/
create table regist_solo
(
   userID               int,
   matchID              int,
   gameID               varchar(256)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   userIMG              varchar(256),
   userName             varchar(256),
   userID               int not null,
   primary key (userID)
);

alter table comment add constraint FK_Relationship_6 foreign key (userID)
      references user (userID) on delete restrict on update restrict;

alter table comment add constraint FK_Relationship_7 foreign key (matchID)
      references gameMatch (matchID) on delete restrict on update restrict;

alter table regist_multi add constraint FK_Relationship_3 foreign key (userID)
      references user (userID) on delete restrict on update restrict;

alter table regist_multi add constraint FK_Relationship_4 foreign key (matchID)
      references gameMatch (matchID) on delete restrict on update restrict;

alter table regist_multi_member add constraint FK_Relationship_5 foreign key (groupID)
      references regist_multi (groupID) on delete restrict on update restrict;

alter table regist_solo add constraint FK_Relationship_1 foreign key (userID)
      references user (userID) on delete restrict on update restrict;

alter table regist_solo add constraint FK_Relationship_2 foreign key (matchID)
      references gameMatch (matchID) on delete restrict on update restrict;

