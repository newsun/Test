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

/*step4 Create a os table*/
create table OS(
id bigint auto_increment primary key,
name varchar(50) unique not null,
description varchar(255)
);
/*step5 Create a duration table*/
create table Duration(
id bigint auto_increment primary key,
name varchar(50) not null unique,
timespan varchar(50) not null,
description varchar(255)
);
/*Step6 Create a strategy table*/
create table Strategy(
id bigint auto_increment primary key,
name varchar(60) not null unique,
description varchar(255)
);

/*step7 Create a project table */
create table Project(
id bigint auto_increment primary key,
name varchar(50) unique not null,
description varchar(255),
createtime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
creatorId bigint not null,
foreign key(creatorId) references User(id) on delete no action on update cascade
);
/*step8 Create a build table*/
create table Build(
id bigint auto_increment primary key,
name varchar(50) not null,
description varchar(255),
projectId bigint not null,
unique(projectId,name),
foreign key(projectId) references Project(id) on delete cascade on update cascade
);
/*step9 Create a multiple dynamic area tree*/
create table Area(
id bigint auto_increment primary key,
name varchar(50) not null,
description varchar(255),
projectId bigint not null,
parentId bigint default null,
isLeaf boolean default true,
unique(projectId,name),
foreign key(projectId) references Project(id) on delete cascade on update cascade,
foreign key(parentId) references Area(id) on delete cascade on update cascade
);
/*step10 Create a Build_Area table*/
create table Build_Area(
areaId bigint not null,
buildId bigint not null,
primary key(areaId,buildId),
foreign key(areaId) references Area(id) on delete cascade on update cascade,
foreign key(buildId) references Build(id) on delete cascade on update cascade
);
/*step11 Create a charter table*/
create table Charter(
id bigint primary key auto_increment,
name varchar(50) not null,
description varchar(255),
/*areaId bigint not null,*/
/*projectId bigint not null,*/
/*buildId bigint not null,*/
starttime timestamp,
endtime timestamp,
testerId bigint not null,
durationId bigint,
designAndExectution bigint,
bugIvestigationAndReporting bigint,
sesstionSetup bigint,
chartervsopp varchar(50),
note varchar(255),
/*unique(areaId,name),*/
/*foreign key(projectId) references Project(id) on delete cascade on update cascade,*/
/*foreign key(buildId) references Build(id) on delete cascade on update cascade,*/
/*foreign key(areasId) references areas(id) on delete cascade on update cascade,*/
/*foreign key(ossId) references oss(id) on delete no action on update cascade,*/
/*foreign key(strategiesId) references strategies(id) on delete no action on update cascade,*/
/*foreign key(areaId) references Area(id) on delete cascade on update cascade,*/
foreign key(durationId) references Duration(id) on delete no action on update cascade,
foreign key(testerId) references User(id) on delete no action on update cascade
);
/*step12 Create a Charter_OS table for charters*/
create table Charter_OS(
charterId bigint not null,
osId bigint not null,
primary key(charterId,osId),
foreign key(charterId) references Charter(id) on delete cascade on update cascade,
foreign key(osId) references OS(id) on delete no action on update cascade
);
/*step12 Create a bug table*/
create table Bug(
id bigint primary key auto_increment,
summary varchar(255) not null,
precedure varchar(5000) not null,
description varchar(5000),
charterId bigint not null,
foreign key(charterId) references Charter(id) on delete cascade on update cascade
);
/*step13 Create a issue table*/
create table Issue(
id bigint primary key auto_increment,
summary varchar(255) not null,
precedure varchar(5000) not null,
description varchar(5000),
charterId bigint not null,
foreign key(charterId) references Charter(id) on delete cascade on update cascade
);
/*step14 Create a strategies table for charters*/
create table Charter_Strategy(
charterId bigint not null,
strategyId bigint not null,
primary key(charterId,strategyId),
foreign key(charterId) references Charter(id) on delete cascade on update cascade,
foreign key(strategyId) references Strategy(id) on delete no action on update cascade
);
/*step17 Create a areas table for charters*/
create table Charter_Area(
charterId bigint not null,
areaId bigint not null,
primary key(charterId,areaId),
foreign key(charterId) references Charter(id) on delete cascade on update cascade,
foreign key(areaId) references Area(id) on delete cascade on update cascade
);
/*step18 Create data files list for charter,bug, issue*/
create table datafiles(
id bigint auto_increment primary key,
charterId bigint,
bugId bigint,
issueId bigint,
fileName varchar(255) not null,
description varchar(255),
content LONGBLOB,
fileSize bigint,
fileType varchar(50),
foreign key(charterId) references Charter(id) on delete cascade on update cascade,
foreign key(bugId) references Bug(id) on delete cascade on update cascade,
foreign key(issueId) references Issue(id) on delete cascade on update cascade
);