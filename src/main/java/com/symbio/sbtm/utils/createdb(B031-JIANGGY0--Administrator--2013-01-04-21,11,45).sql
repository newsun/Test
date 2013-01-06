create database SBTMDB;
use SBTMDB;
/*step1 create a user group table*/
create table usergroup(id int(10) auto_increment,name varchar(30), description varchar(250),primary key(id,name));
/*step2 create a user table*/
/********************
 * User is able to be created but forbidden to delete, the column 'validate' is used to set its status 
 */
create table user(
userId varchar(30) primary key,
password varchar(30) not null,
name varchar(30) not null,
groupId int(10) not null, 
valid boolean not null,
description varchar(250),
foreign key(groupId) references usergroup(id) on delete no action on update cascade
);
/*step3 Create a os table*/
create table os(name varchar(30) primary key,description varchar(250));
/*step4 Create a duration table*/
create table duration(name varchar(30) primary key,timespan varchar(30) not null,description varchar(250));
/*Step5 Create a strategy table*/
create table strategy(name varchar(60) primary key,description varchar(250));

/*step6 Create a project table */
create table project(
id int(10) auto_increment primary key,
name varchar(30) not null,
description varchar(200),
createtime TIMESTAMP,
creatorId varchar(30),
foreign key(creatorId) references user(userid) on delete no action on update cascade
);
/*step7 Create a build table*/
create table build(id int(10) primary key auto_increment,name varchar(30) not null, description varchar(250),projectId int(10) not null,foreign key(projectId) references project(id) on delete cascade on update cascade);
/*step8 Create a multiple dynamic tree*/
create table area(
id int(10) primary key auto_increment,
name varchar(30) not null,
parentId int(10) not null,
isleaf boolean not null,
description varchar(200),
projectId int(10) not null,
buildId int(10) not null,
foreign key(projectId) references project(id) on delete cascade on update cascade,
foreign key(buildId) references build(id) on delete cascade on update cascade
);

/*step9 Create a charter table*/
create table charter(
id int(10) primary key auto_increment,
name varchar(60) not null,
description varchar(250),
projectId int(10) not null,
buildId int(10) not null,
/*areasId int(10) not null,*/
starttime varchar(30),
testerId varchar(30),
/*ossId int(10) not null,*/
/*strategiesId int(10),*/
durationName varchar(30),
designAndExectution int(10),
bugIvestigationAndReporting int(10),
sesstionSetup int(10),
chartervsopp varchar(30),
datafiles varchar(250),
notes varchar(250),
foreign key(projectId) references project(id) on delete cascade on update cascade,
foreign key(buildId) references build(id) on delete cascade on update cascade,
/*foreign key(areasId) references areas(id) on delete cascade on update cascade,*/
/*foreign key(ossId) references oss(id) on delete no action on update cascade,*/
/*foreign key(strategiesId) references strategies(id) on delete no action on update cascade,*/
foreign key(durationName) references duration(name) on delete no action on update cascade,
foreign key(testerId) references user(userId) on delete no action on update cascade
);

/*step10 Create a bug table*/
create table bug(id int(10) primary key auto_increment,
summary varchar(30) not null,
description varchar(250) not null,
result varchar(250),
charterId int(10) not null,
foreign key(charterId) references charter(id) on delete cascade on update cascade
);

/*step11 Create a issue table*/
create table issue(id int(10) primary key auto_increment,
summary varchar(30) not null,
description varchar(250) not null,
charterId int(10) not null,
foreign key(charterId) references charter(id) on delete cascade on update cascade
);
/*step12 Create a oss table for charters*/
create table oss(
id int(10) primary key auto_increment,
charterId int(10) not null,
osName varchar(30) not null,
foreign key(charterId) references charter(id) on delete cascade on update cascade,
foreign key(osName) references os(name) on delete no action on update cascade
);

/*step13 Create a strategies table for charters*/
create table strategies(
id int(10) primary key auto_increment,
charterId int(10) not null,
strategyName varchar(60) not null,
foreign key(charterId) references charter(id) on delete cascade on update cascade,
foreign key(strategyName) references strategy(name) on delete no action on update cascade
);
/*step14 Create a areas table for charters*/
create table areas(
id int(10) primary key auto_increment,
charterId int(10) not null,
areaId int(10) not null,
foreign key(charterId) references charter(id) on delete cascade on update cascade,
foreign key(areaId) references area(id) on delete no action on update cascade
);


/***************************************************************************
 *  step1: insert entries into user group table
 ***************************************************************************/
insert into usergroup(name,description) values("admin","Administrator");
insert into usergroup(name,description) values("mana","Project Manager");
insert into usergroup(name,description) values("tester","Tester");

/***************************************************************************
 *  step2: insert entries into user table
 ***************************************************************************/
insert into user(userId,password,name,groupId,description,valid) values("admin","admin","Administrator",1,"test only",true);
insert into user(userId,password,name,groupId,description,valid) values("johnny","johnny","johnny depp",2,"test only",true);
insert into user(userId,password,name,groupId,description,valid) values("user","user","User",3,"test only",true);
insert into user(userId,password,name,groupId,description,valid) values("james","james","james bond",3,"test only",true);

/***************************************************************************
 *  step3: insert entries into os table
 ***************************************************************************/
insert into os(name,description) values("Win98","test only");
insert into os(name,description) values("Win2008","test only");
insert into os(name,description) values("Win7","test only");
insert into os(name,description) values("Win8","test only");

/***************************************************************************
 *  step4: insert entries into duration table
 ***************************************************************************/
insert into duration(name,timespan,description) values("long","1000","test only");
insert into duration(name,timespan,description) values("middle","500","test only");
insert into duration(name,timespan,description) values("short","100","test only");



/***************************************************************************
 *  step5: insert entries into strategies table
 ***************************************************************************/
insert into strategy(name,description) values("Training","test only");
insert into strategy(name,description) values("Exploration & Analysis","test only");
insert into strategy(name,description) values("Claims Testing","test only");
insert into strategy(name,description) values("Capability Testing","test only");
insert into strategy(name,description) values("Bug Regression Testing","test only");
insert into strategy(name,description) values("Performance Testing","test only");
insert into strategy(name,description) values("Complex | Function & Data Testing","test only");
insert into strategy(name,description) values("Complex | Stress Testing","test only");
insert into strategy(name,description) values("Complex | Flow Testing","test only");
insert into strategy(name,description) values("Complex | Use Case Testing","test only");
insert into strategy(name,description) values("Complex | Risk Testing","test only");
insert into strategy(name,description) values("Complex | Structure Testing","test only");

/***************************************************************************
 * upper tables are independent with any project
 ***************************************************************************/

/***************************************************************************
 *  step6: insert entries project table
 ***************************************************************************/
insert into project(name,description,creatorId) values("ProjectA","ProjectA Description","user");
insert into project(name,description,creatorId) values("ProjectB","ProjectB Description","johnny");
insert into project(name,description,creatorId) values("ProjectC","ProjectC Description","admin");
/***************************************************************************
 *  step7: insert entries into build table
 ***************************************************************************/
insert into build(name,description,projectId) values("1.2","test only",1);
insert into build(name,description,projectId) values("1.3","test only",1);
insert into build(name,description,projectId) values("1.4","test only",1);
insert into build(name,description,projectId) values("1.5","test only",1);

insert into build(name,description,projectId) values("1.2","test only",2);
insert into build(name,description,projectId) values("1.3","test only",2);
insert into build(name,description,projectId) values("1.4","test only",2);
insert into build(name,description,projectId) values("1.5","test only",2);

insert into build(name,description,projectId) values("1.2","test only",3);
insert into build(name,description,projectId) values("1.3","test only",3);
insert into build(name,description,projectId) values("1.4","test only",3);
insert into build(name,description,projectId) values("1.5","test only",3);

/***************************************************************************
 *  step8: insert entries into area table
 ***************************************************************************/
insert into area(name,parentId,isleaf,description,projectId,buildId) values("DecideRight",-1,false,"test only",1,1);
insert into area(name,parentId,isleaf,description,projectId,buildId) values("User Manual",1,true,"test only",1,1);
insert into area(name,parentId,isleaf,description,projectId,buildId) values("Installation",1,true,"test only",1,1);
insert into area(name,parentId,isleaf,description,projectId,buildId) values("Online Help",1,true,"test only",1,1);
insert into area(name,parentId,isleaf,description,projectId,buildId) values("Preferences",1,true,"test only",1,1);
insert into area(name,parentId,isleaf,description,projectId,buildId) values("Advisor",1,true,"test only",1,1);

insert into area(name,parentId,isleaf,description,projectId,buildId) values("DecideRight",-1,false,"test only",2,5);
insert into area(name,parentId,isleaf,description,projectId,buildId) values("User Manual",1,true,"test only",2,5);
insert into area(name,parentId,isleaf,description,projectId,buildId) values("Installation",1,true,"test only",2,5);
insert into area(name,parentId,isleaf,description,projectId,buildId) values("Online Help",1,true,"test only",2,5);
insert into area(name,parentId,isleaf,description,projectId,buildId) values("Preferences",1,true,"test only",2,5);

insert into area(name,parentId,isleaf,description,projectId,buildId) values("DecideRight",-1,true,"test only",2,6);
insert into area(name,parentId,isleaf,description,projectId,buildId) values("User Manual",1,true,"test only",2,6);
insert into area(name,parentId,isleaf,description,projectId,buildId) values("Installation",1,true,"test only",2,6);
insert into area(name,parentId,isleaf,description,projectId,buildId) values("Online Help",1,true,"test only",2,6);
insert into area(name,parentId,isleaf,description,projectId,buildId) values("Preferences",1,true,"test only",2,6);


/***************************************************************************
 *  step9 insert entries into charter table
 ***************************************************************************/
insert into charter(name,description,projectId, buildId,starttime,testerId,durationName,designAndExectution,bugIvestigationAndReporting,sesstionSetup,chartervsopp,datafiles,notes) values("charter1","",1,1,"2012-4-22 10:00:00","johnny","long",3,2,1,"charter vs opp","[datafile1],[datafile1],[datafile3]","");
insert into charter(name,description,projectId, buildId,starttime,testerId,durationName,designAndExectution,bugIvestigationAndReporting,sesstionSetup,chartervsopp,datafiles,notes) values("charter2","",1,1,"2012-4-22 10:00:00","johnny","long",3,2,1,"charter vs opp","[datafile1],[datafile1],[datafile3]","");
insert into charter(name,description,projectId, buildId,starttime,testerId,durationName,designAndExectution,bugIvestigationAndReporting,sesstionSetup,chartervsopp,datafiles,notes) values("charter3","",1,1,"2012-4-22 10:00:00","johnny","long",3,2,1,"charter vs opp","[datafile1],[datafile1],[datafile3]","");

insert into charter(name,description,projectId, buildId,starttime,testerId,durationName,designAndExectution,bugIvestigationAndReporting,sesstionSetup,chartervsopp,datafiles,notes) values("charter3","",2,5,"2012-4-22 10:00:00","johnny","long",3,2,1,"charter vs opp","[datafile1],[datafile1],[datafile3]","");
insert into charter(name,description,projectId, buildId,starttime,testerId,durationName,designAndExectution,bugIvestigationAndReporting,sesstionSetup,chartervsopp,datafiles,notes) values("charter4","",2,5,"2012-4-22 10:00:00","johnny","long",3,2,1,"charter vs opp","[datafile1],[datafile1],[datafile3]","");
insert into charter(name,description,projectId, buildId,starttime,testerId,durationName,designAndExectution,bugIvestigationAndReporting,sesstionSetup,chartervsopp,datafiles,notes) values("charter4","",2,5,"2012-4-22 10:00:00","johnny","long",3,2,1,"charter vs opp","[datafile1],[datafile1],[datafile3]","");
insert into charter(name,description,projectId, buildId,starttime,testerId,durationName,designAndExectution,bugIvestigationAndReporting,sesstionSetup,chartervsopp,datafiles,notes) values("charter4","",2,5,"2012-4-22 10:00:00","johnny","long",3,2,1,"charter vs opp","[datafile1],[datafile1],[datafile3]","");
insert into charter(name,description,projectId, buildId,starttime,testerId,durationName,designAndExectution,bugIvestigationAndReporting,sesstionSetup,chartervsopp,datafiles,notes) values("charter4","",2,5,"2012-4-22 10:00:00","johnny","long",3,2,1,"charter vs opp","[datafile1],[datafile1],[datafile3]","");

insert into charter(name,description,projectId, buildId,starttime,testerId,durationName,designAndExectution,bugIvestigationAndReporting,sesstionSetup,chartervsopp,datafiles,notes) values("charter4","",2,6,"2012-4-22 10:00:00","johnny","long",3,2,1,"charter vs opp","[datafile1],[datafile1],[datafile3]","");
insert into charter(name,description,projectId, buildId,starttime,testerId,durationName,designAndExectution,bugIvestigationAndReporting,sesstionSetup,chartervsopp,datafiles,notes) values("charter4","",2,6,"2012-4-22 10:00:00","johnny","long",3,2,1,"charter vs opp","[datafile1],[datafile1],[datafile3]","");
insert into charter(name,description,projectId, buildId,starttime,testerId,durationName,designAndExectution,bugIvestigationAndReporting,sesstionSetup,chartervsopp,datafiles,notes) values("charter4","",2,6,"2012-4-22 10:00:00","johnny","long",3,2,1,"charter vs opp","[datafile1],[datafile1],[datafile3]","");
insert into charter(name,description,projectId, buildId,starttime,testerId,durationName,designAndExectution,bugIvestigationAndReporting,sesstionSetup,chartervsopp,datafiles,notes) values("charter4","",2,6,"2012-4-22 10:00:00","johnny","long",3,2,1,"charter vs opp","[datafile1],[datafile1],[datafile3]","");
insert into charter(name,description,projectId, buildId,starttime,testerId,durationName,designAndExectution,bugIvestigationAndReporting,sesstionSetup,chartervsopp,datafiles,notes) values("charter4","",2,6,"2012-4-22 10:00:00","johnny","long",3,2,1,"charter vs opp","[datafile1],[datafile1],[datafile3]","");

/***************************************************************************
 *  step10 insert entries into bug table
 ***************************************************************************/
insert into bug(summary,description,charterId) values("BUG1: Sumary for bug1","Manual mentions different platforms (Win 3.1, WFW, and WinNT 3.51) and does not mention Win2000. We think Win 2000 is important to test on and that the older OSes are no longer meaningful.",1);
insert into bug(summary,description,charterId) values("BUG2: Sumary for bug2","We did this analysis on Win98.  I have no data to suggest that features may be different on other operating systems, but I'm not sure about that.",2);

/***************************************************************************
 *  step11 insert entries into issue table
 ***************************************************************************/
insert into issue(summary,description,charterId) values("ISSUE1: Sumary for issue1","Manual mentions different platforms (Win 3.1, WFW, and WinNT 3.51) and does not mention Win2000. We think Win 2000 is important to test on and that the older OSes are no longer meaningful.",1);
insert into issue(summary,description,charterId) values("ISSUE2: Sumary for issue2","We did this analysis on Win98.  I have no data to suggest that features may be different on other operating systems, but I'm not sure about that.",2);

/***************************************************************************
 *  step12 insert entries into oss table
 ***************************************************************************/
insert into oss(charterId,osName) values(1,"Win8");

/***************************************************************************
 *  step13 insert entries into strategies table
 ***************************************************************************/
insert into strategies(charterId,strategyName) values(1,"Training");

/***************************************************************************
 *  step14 insert entries into areas table
 ***************************************************************************/
insert into areas(charterId,areaId) values(1,1);
insert into areas(charterId,areaId) values(1,1);
insert into areas(charterId,areaId) values(1,1);
insert into areas(charterId,areaId) values(1,1);
insert into areas(charterId,areaId) values(2,1);
insert into areas(charterId,areaId) values(3,1);
insert into areas(charterId,areaId) values(4,1);
insert into areas(charterId,areaId) values(5,3);
commit;

