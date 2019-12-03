# Host: localhost  (Version 5.1.62-community)
# Date: 2019-01-08 20:35:38
# Generator: MySQL-Front 6.1  (Build 1.26)


#
# Structure for table "course"
#

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `COURSE_NO` varchar(255) DEFAULT NULL,
  `COURSE_NAME` varchar(255) DEFAULT NULL,
  `CREDIT` int(11) DEFAULT NULL,
  `COURSE_HOUR` int(11) DEFAULT NULL,
  `COURSE_TYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Data for table "course"
#

INSERT INTO `course` VALUES (3,'1','数据库',7,66,'专业必修'),(4,'2','编译原理',8,32,'专业选修'),(5,'3','马克思原理',9,64,'公选'),(7,'4','操作系统',9,88,'专业必修'),(8,'6','计算机科学导论',9,12,'专业必修');

#
# Structure for table "elective"
#

DROP TABLE IF EXISTS `elective`;
CREATE TABLE `elective` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `COURSE_ID` int(11) NOT NULL,
  `STUDENT_ID` int(11) NOT NULL,
  `TEACHER_SUBJECT` varchar(255) DEFAULT NULL,
  `TEACHER_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

#
# Data for table "elective"
#

INSERT INTO `elective` VALUES (19,3,1,'数据库','数据库老师'),(20,4,1,'编译原理','编译原理老师');

#
# Structure for table "grade"
#

DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `GRADE_NAME` varchar(255) DEFAULT NULL,
  `SUBJECT` varchar(255) DEFAULT NULL,
  `AMOUNT` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

#
# Data for table "grade"
#

INSERT INTO `grade` VALUES (4,'1603班','计算机科学与技术学院','55'),(7,'1602班','计算机科学与技术学院','100'),(8,'1601班','计算机科学与技术学院','20'),(10,'1604班','外国语学院','90'),(11,'1601班','文学院','56'),(12,'1601班','外国语学院','55'),(13,'1606班','计算机科学与技术学院','68');

#
# Structure for table "score"
#

DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `STUDENT_NO` varchar(255) DEFAULT NULL,
  `COURSE_NO` varchar(255) DEFAULT NULL,
  `SCORE` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Data for table "score"
#

INSERT INTO `score` VALUES (1,'2019','1',10),(2,'2018','1',89),(3,'2017','1',88),(4,'2016','1',60),(5,'2019','2',90),(6,'2018','2',77),(7,'2017','2',69),(8,'2016','2',88);

#
# Structure for table "student"
#

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `STUDENT_NO` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `STUDENT_NAME` varchar(255) NOT NULL,
  `SEX` varchar(255) DEFAULT NULL,
  `SUBJECT` varchar(255) NOT NULL,
  `STU_CLASS` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Data for table "student"
#

INSERT INTO `student` VALUES (1,'2019','123456','张三','女','音乐学院','1601班'),(2,'2018','123456','李四','男','美术学院','1601班'),(4,'2017','123456','王五','女','美术学院','1601班'),(5,'2016','123456','赵六','男','计算机科学与技术学院','1603班'),(8,'8080','123456','嘿嘿嘿','女','计算机科学与技术学院','1604班');

#
# Structure for table "subject"
#

DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SUBJECT_NO` varchar(255) NOT NULL,
  `SUBJECT_NAME` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Data for table "subject"
#

INSERT INTO `subject` VALUES (1,'1','计算机科学与技术学院'),(2,'2','音乐学院'),(6,'3','美术学院'),(7,'4','文学院'),(8,'5','生科学院');

#
# Structure for table "teacher"
#

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TEACHER_NO` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `TEACHER_NAME` varchar(255) NOT NULL,
  `SEX` varchar(255) DEFAULT NULL,
  `TYPE` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "teacher"
#

INSERT INTO `teacher` VALUES (1,'1','123456','编译原理老师','男','编译原理'),(2,'2','123456','数据库老师','女','数据库'),(3,'3','123456','三三','男','web实训'),(4,'4','123456','四四','女','马克思原理');

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (4,'1','123456','教师'),(5,'2019','123456','学生'),(6,'3','123456','管理员');
