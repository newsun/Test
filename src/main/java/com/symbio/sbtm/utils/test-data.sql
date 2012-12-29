/***************************************************************************
 *  step1: insert entries into role table
 ***************************************************************************/
insert into Role(name,description) values("Administrator","System Administrator");
insert into Role(name,description) values("Project Manager","Project Manager");
insert into Role(name,description) values("Build Manager","Build Manager");
insert into Role(name,description) values("Tester","Tester");

/***************************************************************************
 *  step2: insert entries into user table
 ***************************************************************************/
insert into user(userId,password) values("admin","admin");
insert into user(userId,password) values("johnny","johnny");
insert into user(userId,password) values("user","user");
insert into user(userId,password) values("james","james");
/*
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
*/