SET FOREIGN_KEY_CHECKS=0;

--------------------------------
--Table structure for 'hello'
--Mariadb里，表名 和 字段名不再使用引号
--------------------------------
DROP TABLE IF EXISTS hello;
CREATE TABLE hello (
	id int(11) NOT NULL AUTO_INCREMENT,
	msg varchar(255) DEFAULT NULL,
	date datetime DEFAULT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--------------------------------
--Records of hello
--------------------------------
INSERT INTO hello VALUES ('1','你好','2016-12-26 23:21:46');
INSERT INTO hello VALUES ('2','我好','2016-12-26 23:21:51');
INSERT INTO hello VALUES ('3','大家好','2016-12-26 23:21:56');



