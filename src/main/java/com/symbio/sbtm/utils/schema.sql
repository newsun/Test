create database SBTM;
use SBTM;
/*step1 create a role table*/
create table Role(
id bigint(20) auto_increment primary key,
name varchar(50) not null unique,
description varchar(250) default ""
);
/*step2 create a user table*/
/********************
 * User is able to be created but forbidden to delete, the column 'validate' is used to set its status 
 */
create table User(
id bigint(20) auto_increment primary key,
userId varchar(50) not null unique,
password varchar(50) not null,
firstName varchar(50) default null,
lastName varchar(50) default null,
valid boolean default true,
description varchar(250) default ""
);

/*step3 create Role_User table*/
create table Role_User(
userId bigint(20) not null,
roleId bigint(20) not null,
primary key(userId,roleId),
foreign key(roleId) references Role(id) on delete cascade on update cascade,
foreign key(userId) references User(id) on delete cascade on update cascade
);

/*step3 Create a os table*/
create table OS(
id int(10) auto_increment primary key,
name varchar(50) unique,
description varchar(250)
);
/*step4 Create a duration table*/
create table Duration(
name varchar(50) primary key,
timespan varchar(50) not null,
description varchar(250)
);
/*Step5 Create a strategy table*/
create table Strategy(
name varchar(60) primary key,
description varchar(250)
);

/*step6 Create a project table */
create table Project(
id bigint(20) auto_increment primary key,
name varchar(50) not null unique,
description varchar(200),
createtime datetime,
creatorId varchar(50),
foreign key(creatorId) references User(userId) on delete no action on update cascade
);
/*step7 Create a build table*/
create table Build(
id bigint(20) primary key auto_increment,
name varchar(50) not null,
description varchar(250),
projectId bigint(20) not null,
foreign key(projectId) references Project(id) on delete cascade on update cascade
);
/*step8 Create a multiple dynamic tree*/
create table Area(
id bigint(20) primary key auto_increment,
name varchar(50) not null unique,
description varchar(200),
projectId bigint(20) not null,
buildId bigint(20) default null,
parentId bigint(20) default null,
foreign key(projectId) references Project(id) on delete cascade on update cascade,
foreign key(buildId) references Build(id) on delete cascade on update cascade,
foreign key(parentId) references Area(id) on delete cascade on update cascade
);

/*step9 Create a charter table*/
create table Charter(
id bigint(20) primary key auto_increment,
name varchar(60) not null,
description varchar(250),
projectId bigint(20) not null,
buildId bigint(20) not null,
/*areasId bigint(20) not null,*/
starttime varchar(50),
testerId varchar(50),
/*ossId bigint(20) not null,*/
/*strategiesId bigint(20),*/
durationName varchar(50),
designAndExectution bigint(20),
bugIvestigationAndReporting bigint(20),
sesstionSetup bigint(20),
chartervsopp varchar(50),
datafiles varchar(250),
notes varchar(250),
foreign key(projectId) references Project(id) on delete cascade on update cascade,
foreign key(buildId) references Build(id) on delete cascade on update cascade,
/*foreign key(areasId) references areas(id) on delete cascade on update cascade,*/
/*foreign key(ossId) references oss(id) on delete no action on update cascade,*/
/*foreign key(strategiesId) references strategies(id) on delete no action on update cascade,*/
foreign key(durationName) references Duration(name) on delete no action on update cascade,
foreign key(testerId) references User(userId) on delete no action on update cascade
);

/*step10 Create a bug table*/
create table Bug(
id bigint(20) primary key auto_increment,
summary varchar(50) not null,
precedure varchar(250) not null,
description varchar(250),
charterId bigint(20) not null,
foreign key(charterId) references Charter(id) on delete cascade on update cascade
);

/*step11 Create a issue table*/
create table Issue(
id bigint(20) primary key auto_increment,
summary varchar(50) not null,
precedure varchar(250) not null,
description varchar(250),
charterId bigint(20) not null,
foreign key(charterId) references Charter(id) on delete cascade on update cascade
);
/*step12 Create a oss table for charters*/
create table Charter_OS(
charterId bigint(20) not null,
osName varchar(50) not null,
primary key(charterId,osName),
foreign key(charterId) references Charter(id) on delete cascade on update cascade,
foreign key(osName) references OS(name) on delete no action on update cascade
);

/*step13 Create a strategies table for charters*/
create table Charter_Strategy(
charterId bigint(20) not null,
strategyName varchar(60) not null,
primary key(charterId,strategyName),
foreign key(charterId) references Charter(id) on delete cascade on update cascade,
foreign key(strategyName) references Strategy(name) on delete no action on update cascade
);
/*step14 Create a areas table for charters*/
create table Charter_Area(
charterId bigint(20) not null,
areaId bigint(20) not null,
primary key(charterId,areaId),
foreign key(charterId) references Charter(id) on delete cascade on update cascade,
foreign key(areaId) references Area(id) on delete no action on update cascade
);
/*step14 Create many2many between user and role*/

