/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/5/9 23:18:37                            */
/*==============================================================*/


drop table if exists comment;

drop table if exists currentMatch;

drop table if exists matchFocus;

drop table if exists regist_multi_member;

drop table if exists regist_solo;

drop table if exists userFocus;

drop table if exists user_detail;

drop table if exists regist_multi;

drop table if exists user;

drop table if exists gamematch;

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
/* Table: currentMatch                                          */
/*==============================================================*/
create table currentMatch
(
   matchID              int,
   matchUrl             varchar(1024)
);

/*==============================================================*/
/* Table: gamematch                                             */
/*==============================================================*/
create table gamematch
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
   matchID              int not null auto_increment,
   primary key (matchID)
);

/*==============================================================*/
/* Table: matchFocus                                            */
/*==============================================================*/
create table matchFocus
(
   userID               int,
   matchID              int
);

/*==============================================================*/
/* Table: regist_multi                                          */
/*==============================================================*/
create table regist_multi
(
   userID               int,
   matchID              int,
   groupID              int not null auto_increment,
   primary key (groupID)
);

/*==============================================================*/
/* Table: regist_multi_member                                   */
/*==============================================================*/
create table regist_multi_member
(
   groupID              int,
   userID               int,
   gameID               varchar(256)
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
   pwd                  varchar(256),
   userName             varchar(256),
   userID               int not null auto_increment,
   primary key (userID)
);

/*==============================================================*/
/* Table: userFocus                                             */
/*==============================================================*/
create table userFocus
(
   userID               int,
   use_userID           int
);

/*==============================================================*/
/* Table: user_detail                                           */
/*==============================================================*/
create table user_detail
(
   userID               int,
   AdmName              varchar(20),
   userImg              varchar(20)
);

alter table comment add constraint FK_Relationship_6 foreign key (userID)
      references user (userID) on delete restrict on update restrict;

alter table comment add constraint FK_Relationship_7 foreign key (matchID)
      references gamematch (matchID) on delete restrict on update restrict;

alter table currentMatch add constraint FK_Relationship_14 foreign key (matchID)
      references gamematch (matchID) on delete restrict on update restrict;

alter table matchFocus add constraint FK_Relationship_10 foreign key (userID)
      references user (userID) on delete restrict on update restrict;

alter table matchFocus add constraint FK_Relationship_11 foreign key (matchID)
      references gamematch (matchID) on delete restrict on update restrict;

alter table regist_multi add constraint FK_Relationship_3 foreign key (userID)
      references user (userID) on delete restrict on update restrict;

alter table regist_multi add constraint FK_Relationship_4 foreign key (matchID)
      references gamematch (matchID) on delete restrict on update restrict;

alter table regist_multi_member add constraint FK_Relationship_5 foreign key (groupID)
      references regist_multi (groupID) on delete restrict on update restrict;

alter table regist_multi_member add constraint FK_Relationship_8 foreign key (userID)
      references user (userID) on delete restrict on update restrict;

alter table regist_solo add constraint FK_Relationship_1 foreign key (userID)
      references user (userID) on delete restrict on update restrict;

alter table regist_solo add constraint FK_Relationship_2 foreign key (matchID)
      references gamematch (matchID) on delete restrict on update restrict;

alter table userFocus add constraint FK_Relationship_12 foreign key (userID)
      references user (userID) on delete restrict on update restrict;

alter table userFocus add constraint FK_Relationship_13 foreign key (use_userID)
      references user (userID) on delete restrict on update restrict;

alter table user_detail add constraint FK_Relationship_9 foreign key (userID)
      references user (userID) on delete restrict on update restrict;