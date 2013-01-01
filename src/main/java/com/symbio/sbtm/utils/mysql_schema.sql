create database SBTM;
use SBTM;
/*step1 create a role table*/
create table Role(
id bigint auto_increment primary key,
name varchar(50) not null unique,
description varchar(255) default ""
);
/*step2 create a user table*/
/* User is able to be created but forbidden to delete, the column 'validate' is used to set its status */
create table User(
id bigint auto_increment primary key,
userId varchar(50) not null unique,
password varchar(50) not null,
firstName varchar(50) default null,
lastName varchar(50) default null,
valid boolean default true,
description varchar(255) default ""
);

/*step3 create Role_User table*/
create table User_Role(
userId bigint not null,
roleId bigint not null,
primary key(userId,roleId),
foreign key(roleId) references Role(id) on delete cascade on update cascade,
foreign key(userId) references User(id) on delete cascade on update cascade
);

/*step3 Create a os table*/
create table OS(
id bigint auto_increment primary key,
name varchar(50) unique not null,
description varchar(255)
);
/*step4 Create a duration table*/
create table Duration(
id bigint auto_increment primary key,
name varchar(50) not null unique,
timespan varchar(50) not null,
description varchar(255)
);
/*Step5 Create a strategy table*/
create table Strategy(
id bigint auto_increment primary key,
name varchar(60) not null unique,
description varchar(255)
);

/*step6 Create a project table */
create table Project(
id bigint auto_increment primary key,
name varchar(50) unique not null,
description varchar(255),
createtime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
creatorId bigint not null,
foreign key(creatorId) references User(id) on delete no action on update cascade
);
/*step7 Create a build table*/
create table Build(
id bigint auto_increment primary key,
name varchar(50) not null,
description varchar(255),
projectId bigint not null,
unique(projectId,name),
foreign key(projectId) references Project(id) on delete cascade on update cascade
);
/*step8 Create a multiple dynamic tree*/
create table Area(
name varchar(50) not null,
description varchar(255),
projectId bigint not null,
buildId bigint default null,
parentId bigint default null,
isLeaf boolean not null default true,
primary key(projectId,name),
foreign key(projectId) references Project(id) on delete cascade on update cascade,
foreign key(buildId) references Build(id) on delete cascade on update cascade,
foreign key(parentId) references Area(id) on delete cascade on update cascade
);

/*step9 Create a charter table*/
create table Charter(
id bigint primary key auto_increment,
name varchar(60) not null,
description varchar(255),
projectId bigint not null,
buildId bigint not null,
/*areasId bigint not null,*/
starttime varchar(50),
testerId varchar(50),
/*ossId bigint not null,*/
/*strategiesId bigint,*/
durationName varchar(50),
designAndExectution bigint,
bugIvestigationAndReporting bigint,
sesstionSetup bigint,
chartervsopp varchar(50),
datafiles varchar(255),
notes varchar(255),
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
id bigint primary key auto_increment,
summary varchar(50) not null,
precedure varchar(255) not null,
description varchar(255),
charterId bigint not null,
foreign key(charterId) references Charter(id) on delete cascade on update cascade
);

/*step11 Create a issue table*/
create table Issue(
id bigint primary key auto_increment,
summary varchar(50) not null,
precedure varchar(255) not null,
description varchar(255),
charterId bigint not null,
foreign key(charterId) references Charter(id) on delete cascade on update cascade
);
/*step12 Create a oss table for charters*/
create table Charter_OS(
charterId bigint not null,
osName varchar(50) not null,
primary key(charterId,osName),
foreign key(charterId) references Charter(id) on delete cascade on update cascade,
foreign key(osName) references OS(name) on delete no action on update cascade
);

/*step13 Create a strategies table for charters*/
create table Charter_Strategy(
charterId bigint not null,
strategyName varchar(60) not null,
primary key(charterId,strategyName),
foreign key(charterId) references Charter(id) on delete cascade on update cascade,
foreign key(strategyName) references Strategy(name) on delete no action on update cascade
);
/*step14 Create a areas table for charters*/
create table Charter_Area(
charterId bigint not null,
areaId bigint not null,
primary key(charterId,areaId),
foreign key(charterId) references Charter(id) on delete cascade on update cascade,
foreign key(areaId) references Area(id) on delete no action on update cascade
);
/*step14 Create many2many between user and role*/

