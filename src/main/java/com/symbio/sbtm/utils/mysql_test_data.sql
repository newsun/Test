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
insert into User(userId,password) values("admin","admin");
insert into User(userId,password) values("johnny","johnny");
insert into User(userId,password) values("user","user");
insert into User(userId,password) values("james","james");
/***************************************************************************
 *  step3: insert entries into User_Role table
 ***************************************************************************/
insert into User_Role(userId,roleId) values(1,1);
insert into User_Role(userId,roleId) values(2,2);
insert into User_Role(userId,roleId) values(3,3);
insert into User_Role(userId,roleId) values(4,4);

/***************************************************************************
 *  step4: insert entries into os table
 ***************************************************************************/
insert into OS(name,description) values("Win98","test only");
insert into OS(name,description) values("Win2008","test only");
insert into OS(name,description) values("Win7","test only");
insert into OS(name,description) values("Win8","test only");

/***************************************************************************
 *  step5: insert entries into duration table
 ***************************************************************************/
insert into duration(name,timespan,description) values("long","1000","test only");
insert into duration(name,timespan,description) values("middle","500","test only");
insert into duration(name,timespan,description) values("short","100","test only");

/***************************************************************************
 *  step6: insert entries into strategy table
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
 * above tables are independent with any project
 ***************************************************************************/

/***************************************************************************
 *  step7: insert entries project table
 ***************************************************************************/
insert into project(name,description,creatorId) values("ProjectA","ProjectA Description",1);
insert into project(name,description,creatorId) values("ProjectB","ProjectB Description",2);
insert into project(name,description,creatorId) values("ProjectC","ProjectC Description",3);
/***************************************************************************
 *  step8: insert entries into build table
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
 *  step9: insert entries into area table
 ***************************************************************************/
insert into area(name,projectId) values("DecideRight",1);
insert into area(name,projectId) values("User Manual",1);
insert into area(name,projectId) values("Installation",1);
insert into area(name,projectId) values("Online Help",1);
insert into area(name,projectId) values("Preferences",1);
insert into area(name,projectId) values("Advisor",1);

insert into area(name,projectId) values("DecideRight",2);
insert into area(name,projectId) values("User Manual",2);
insert into area(name,projectId) values("Installation",2);
insert into area(name,projectId) values("Online Help",2);
insert into area(name,projectId) values("Preferences",2);

insert into area(name,projectId) values("DecideRight 2",2);
insert into area(name,projectId) values("User Manual 2",2);
insert into area(name,projectId) values("Installation 2",2);
insert into area(name,projectId) values("Online Help 2",2);
insert into area(name,projectId) values("Preferences 2",2);

/***************************************************************************
* step10: insert into build_area
***************************************************************************/
insert into Build_Area(buildId,areaId) values(1,1);
insert into Build_Area(buildId,areaId) values(1,2);
insert into Build_Area(buildId,areaId) values(1,3);
insert into Build_Area(buildId,areaId) values(1,4);
insert into Build_Area(buildId,areaId) values(1,5);
insert into Build_Area(buildId,areaId) values(2,1);
insert into Build_Area(buildId,areaId) values(2,2);
insert into Build_Area(buildId,areaId) values(2,3);
insert into Build_Area(buildId,areaId) values(2,4);
insert into Build_Area(buildId,areaId) values(2,5);
insert into Build_Area(buildId,areaId) values(3,1);
insert into Build_Area(buildId,areaId) values(3,2);
insert into Build_Area(buildId,areaId) values(3,3);
insert into Build_Area(buildId,areaId) values(3,4);
insert into Build_Area(buildId,areaId) values(3,5);
insert into Build_Area(buildId,areaId) values(4,1);
insert into Build_Area(buildId,areaId) values(4,2);
insert into Build_Area(buildId,areaId) values(4,3);
insert into Build_Area(buildId,areaId) values(4,4);
insert into Build_Area(buildId,areaId) values(4,5);
insert into Build_Area(buildId,areaId) values(5,1);
insert into Build_Area(buildId,areaId) values(5,2);
insert into Build_Area(buildId,areaId) values(5,3);
insert into Build_Area(buildId,areaId) values(5,4);
insert into Build_Area(buildId,areaId) values(5,5);

insert into Build_Area(buildId,areaId) values(6,1);
insert into Build_Area(buildId,areaId) values(6,2);
insert into Build_Area(buildId,areaId) values(6,3);
insert into Build_Area(buildId,areaId) values(6,4);
insert into Build_Area(buildId,areaId) values(6,5);
insert into Build_Area(buildId,areaId) values(7,1);
insert into Build_Area(buildId,areaId) values(7,2);
insert into Build_Area(buildId,areaId) values(7,3);
insert into Build_Area(buildId,areaId) values(7,4);
insert into Build_Area(buildId,areaId) values(7,5);
insert into Build_Area(buildId,areaId) values(8,1);
insert into Build_Area(buildId,areaId) values(8,2);
insert into Build_Area(buildId,areaId) values(8,3);
insert into Build_Area(buildId,areaId) values(8,4);
insert into Build_Area(buildId,areaId) values(8,5);
insert into Build_Area(buildId,areaId) values(9,1);
insert into Build_Area(buildId,areaId) values(9,2);
insert into Build_Area(buildId,areaId) values(9,3);
insert into Build_Area(buildId,areaId) values(9,4);
insert into Build_Area(buildId,areaId) values(9,5);
insert into Build_Area(buildId,areaId) values(10,1);
insert into Build_Area(buildId,areaId) values(10,2);
insert into Build_Area(buildId,areaId) values(10,3);
insert into Build_Area(buildId,areaId) values(10,4);
insert into Build_Area(buildId,areaId) values(10,5);
insert into Build_Area(buildId,areaId) values(11,1);
insert into Build_Area(buildId,areaId) values(11,2);
insert into Build_Area(buildId,areaId) values(11,3);
insert into Build_Area(buildId,areaId) values(11,4);
insert into Build_Area(buildId,areaId) values(11,5);
insert into Build_Area(buildId,areaId) values(12,1);
insert into Build_Area(buildId,areaId) values(12,2);
insert into Build_Area(buildId,areaId) values(12,3);
insert into Build_Area(buildId,areaId) values(12,4);
insert into Build_Area(buildId,areaId) values(12,5);

/***************************************************************************
 *  step11 insert entries into charter table
 ***************************************************************************/
insert into Charter(name,testerId) values("Charter1",4);
insert into Charter(name,testerId) values("Charter2",4);
insert into Charter(name,testerId) values("Charter3",4);
insert into Charter(name,testerId) values("Charter4",4);
insert into Charter(name,testerId) values("Charter5",4);
insert into Charter(name,testerId) values("Charter6",4);
insert into Charter(name,testerId) values("Charter7",4);
insert into Charter(name,testerId) values("Charter8",4);
insert into Charter(name,testerId) values("Charter9",4);
insert into Charter(name,testerId) values("Charter10",4);
insert into Charter(name,testerId) values("Charter11",4);
insert into Charter(name,testerId) values("Charter12",4);
insert into Charter(name,testerId) values("Charter13",4);
insert into Charter(name,testerId) values("Charter14",4);
insert into Charter(name,testerId) values("Charter15",4);
insert into Charter(name,testerId) values("Charter16",4);
insert into Charter(name,testerId) values("Charter17",4);
insert into Charter(name,testerId) values("Charter18",4);
insert into Charter(name,testerId) values("Charter19",4);
insert into Charter(name,testerId) values("Charter20",4);

insert into Charter(name,testerId) values("Charter1",4);
insert into Charter(name,testerId) values("Charter2",4);
insert into Charter(name,testerId) values("Charter3",4);
insert into Charter(name,testerId) values("Charter4",4);
insert into Charter(name,testerId) values("Charter5",4);
insert into Charter(name,testerId) values("Charter6",4);
insert into Charter(name,testerId) values("Charter7",4);
insert into Charter(name,testerId) values("Charter8",4);
insert into Charter(name,testerId) values("Charter9",4);
insert into Charter(name,testerId) values("Charter10",4);
insert into Charter(name,testerId) values("Charter11",4);
insert into Charter(name,testerId) values("Charter12",4);
insert into Charter(name,testerId) values("Charter13",4);
insert into Charter(name,testerId) values("Charter14",4);
insert into Charter(name,testerId) values("Charter15",4);
insert into Charter(name,testerId) values("Charter16",4);
insert into Charter(name,testerId) values("Charter17",4);
insert into Charter(name,testerId) values("Charter18",4);
insert into Charter(name,testerId) values("Charter19",4);
insert into Charter(name,testerId) values("Charter20",4);

insert into Charter(name,testerId) values("Charter1",4);
insert into Charter(name,testerId) values("Charter2",4);
insert into Charter(name,testerId) values("Charter3",4);
insert into Charter(name,testerId) values("Charter4",4);
insert into Charter(name,testerId) values("Charter5",4);
insert into Charter(name,testerId) values("Charter6",4);
insert into Charter(name,testerId) values("Charter7",4);
insert into Charter(name,testerId) values("Charter8",4);
insert into Charter(name,testerId) values("Charter9",4);
insert into Charter(name,testerId) values("Charter10",4);
insert into Charter(name,testerId) values("Charter11",4);
insert into Charter(name,testerId) values("Charter12",4);
insert into Charter(name,testerId) values("Charter13",4);
insert into Charter(name,testerId) values("Charter14",4);
insert into Charter(name,testerId) values("Charter15",4);
insert into Charter(name,testerId) values("Charter16",4);
insert into Charter(name,testerId) values("Charter17",4);
insert into Charter(name,testerId) values("Charter18",4);
insert into Charter(name,testerId) values("Charter19",4);
insert into Charter(name,testerId) values("Charter20",4);
/***************************************************************************
 *  step12 insert entries into bug table
 ***************************************************************************/
insert into bug(summary,precedure,description,charterId) values("BUG1: Sumary for bug1","Manual mentions different platforms (Win 3.1, WFW, and WinNT 3.51) and does not mention Win2000. We think Win 2000 is important to test on and that the older OSes are no longer meaningful.","",1);
insert into bug(summary,precedure,description,charterId) values("BUG2: Sumary for bug2","We did this analysis on Win98.  I have no data to suggest that features may be different on other operating systems, but I'm not sure about that.","",2);

/***************************************************************************
 *  step13 insert entries into issue table
 ***************************************************************************/
insert into issue(summary,precedure,description,charterId) values("ISSUE1: Sumary for issue1","Manual mentions different platforms (Win 3.1, WFW, and WinNT 3.51) and does not mention Win2000. We think Win 2000 is important to test on and that the older OSes are no longer meaningful.","",1);
insert into issue(summary,precedure,description,charterId) values("ISSUE2: Sumary for issue2","We did this analysis on Win98.  I have no data to suggest that features may be different on other operating systems, but I'm not sure about that.","",2);

/***************************************************************************
 *  step14 insert entries into oss table
 ***************************************************************************/

/***************************************************************************
 *  step15 insert entries into strategies table
 ***************************************************************************/
insert into strategies(charterId,strategyName) values(1,"Training");

/***************************************************************************
 *  step16des insert entries into areas table
 ***************************************************************************/
commit;
