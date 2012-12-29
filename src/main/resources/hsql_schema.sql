create table Role(
id bigint IDENTITY primary key,
name varchar(50) not null,
description varchar(250)
);

create table User(
id bigint IDENTITY primary key,
userId varchar(50) not null,
password varchar(50) not null,
firstName varchar(50) default null,
lastName varchar(50) default null,
valid boolean default true,
description varchar(250)
);

create table Role_User(
userId bigint not null,
roleId bigint not null,
primary key(userId,roleId),
foreign key(roleId) references Role(id) on delete cascade on update cascade,
foreign key(userId) references User(id) on delete cascade on update cascade
);

create table OS(
id bigint IDENTITY primary key,
name varchar(50),
description varchar(250)
);

create table Duration(
name varchar(50) primary key,
timespan varchar(50) not null,
description varchar(250)
);

create table Strategy(
name varchar(60) primary key,
description varchar(250)
);

create table Project(
id bigint IDENTITY primary key,
name varchar(50) not null,
description varchar(200),
createtime bigint,
creatorId bigint not null,
foreign key(creatorId) references User(userId) on delete no action on update cascade
);

create table Build(
id bigint primary key IDENTITY,
name varchar(50) not null,
description varchar(250),
projectId bigint not null,
foreign key(projectId) references Project(id) on delete cascade on update cascade
);

create table Area(
id bigint primary key IDENTITY,
name varchar(50) not null,
description varchar(200),
projectId bigint not null,
buildId bigint default null,
parentId bigint default null,
foreign key(projectId) references Project(id) on delete cascade on update cascade,
foreign key(buildId) references Build(id) on delete cascade on update cascade,
foreign key(parentId) references Area(id) on delete cascade on update cascade
);

create table Charter(
id bigint primary key IDENTITY,
name varchar(60) not null,
description varchar(250),
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
id bigint primary key IDENTITY,
summary varchar(50) not null,
precedure varchar(250) not null,
description varchar(250),
charterId bigint not null,
foreign key(charterId) references Charter(id) on delete cascade on update cascade
);

/*step11 Create a issue table*/
create table Issue(
id bigint primary key IDENTITY,
summary varchar(50) not null,
precedure varchar(250) not null,
description varchar(250),
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

