<!-- TOC -->

- [MySQL](#mysql)
    - [1 安装](#1-安装)
    - [2 使用](#2-使用)
    - [3 创建数据库](#3-创建数据库)
        - [3.1 新建数据库](#31-新建数据库)
        - [3.2 数据表](#32-数据表)
        - [3.3 约束](#33-约束)
        - [3.4 SELECT语句](#34-select语句)
            - [3.4.1 排序](#341-排序)
            - [3.4.2 SQL内置函数计算](#342-sql内置函数计算)
            - [3.4.3 连接查询](#343-连接查询)
        - [3.5 修改](#35-修改)
        - [3.6 索引](#36-索引)
        - [3.7 备份](#37-备份)
        - [3.8 恢复](#38-恢复)

<!-- /TOC -->

# MySQL

## 1 安装

检查是否安装:`sudo service mysql start`

安装`sudo apt-get install mysql-server`,`sudo apt-get install mysql-client`

安装完成以后设置root用户密码等信息

验证安装并启动成功:`sudo netstat -tap | grep mysql`

MySQL的配置文件可以使用`sudo gedit /etc/mysql/my.cnf`进行修改

## 2 使用

打开MySQL：`sudo service mysql start`

使用root用户登陆:`mysql -u root`

查看有哪些数据库:`show databases;`

连接数据库:`use 数据库名`

查看数据库中有哪些表:`show tables;`

加载数据库文件:`source 文件路径;`

退出:`exit`

## 3 创建数据库

### 3.1 新建数据库

大多数系统中SQL不分大小写，打死你为了严谨，常定义过的字使用大写，数据和变量使用小写。

创建一个名为bill的新的数据库:`CREATE DATABASE bill;`

查看是否存在`show databases;`

连接数据库:`use bill`

删除数据库`DROP DATABASE bill;`

### 3.2 数据表

数据表(table)为存放数据的具体内容，一个数据库中多张表，相互联系。

新建数据表:

```sql
CREATE TABLE 表的名字
(
列名a 数据类型（数据长度）,
列名b 数据类型（数据长度）,
列名c 数据类型（数据长度）
);
```

表中具体内容使用:`SELECT * FROM 表名`查看

表中插入数据:`INSERT INTO 表的名字(列名a, 列名b, 列名c) VALUES(值1, 值2, 值3);`

### 3.3 约束

MySQL中通常有以下集中约束:

主键`PRIMARY KEY` ,默认值`DEFAULT`，唯一`UNIQUE`，外键`FOREIGN KEY`，非空`NOT NULL`

主键用于约束表中第一行，作为这一行唯一标识符。

默认值用于当有DEFAULT约束的列，参数数据为空时，使用默认值。

唯一规定指定的一列值不能有重复值。

外键用于参考另一个表的主键，被外键约束的列取值必须在参考的列中有对应值。

非空即被约束的列在插入值时必须为非空

### 3.4 SELECT语句

SELECT语句基本格式为：`SELECT 要查询的列名 FROM 表的名字 WHERE 限制条件;`

其中WHERE作为限制条件可以使用:

1. 数学符号 (=, <, >=, <=)
2. OR和AND
3. IN和NOT IN
4. 通用匹配符：`_`代表一个未指定字符，`%`代表不定个指定字符

#### 3.4.1 排序

`ORDER BY 条件 ASC/DESC`可以对关键词进行排序(ASC升序DESC降序)

例如对employee表中的salary降序排列`SELECT name,age,salary,phone FROM employee ORDER BY salary DESC;`

#### 3.4.2 SQL内置函数计算

内置计算函数分别为：`COUNT`计数, `SUM`求和, `AVG`求平均, `MAX`最大值, `MIN`最小值

比如计算salary的最大最小值：`SELECT MAX(salary) AS max_salary,MIN(salary) FROM employee;`

* 注：AS关键词可以给值重新命名

#### 3.4.3 连接查询

处理多个表时，可以把多个表当作一个表操作

例如:查询各员工所在部门的人数，其中员工的 id 和 name 来自 employee 表，people_num 来自 department 表：

```sql
SELECT id,name,people_num
FROM employee,department
WHERE employee.in_dpt = department.dpt_name

/*
FROM employee JOIN department
ON employee.in_dpt = department.dpt_name
*/

ORDER BY id;
```

### 3.5 修改

重命名一张表：`RENAME TABLE 原名 TO 新名字;ALTER TABLE 原名 RENAME 新名;ALTER TABLE 原名 RENAME TO 新名;`

删除表:`DROP TABLE 表的名字`

增加一列：`ALTER TABLE 表名字 ADD COLUMN 列名字 数据类型 约束;`

删除一列:`ALTER TABLE 表名字 DROP COLUMN 列名字;`

重命名一列:`ALTER TABLE 表名字 CHANGE 原列名 新列名 数据类型 约束;`

改变数据类型:`ALTER TABLE 表名字 MODIFY 列名字 新数据类型;`

修改表中某个值:`UPDATE 表名字 SET 列1=值1,列2=值2 WHERE 条件;`

删除一行:`DELETE FROM 表名字 WHERE 条件;`

### 3.6 索引

对一张表中某列建立索引：

`ALTER TABLE 表名字 ADD INDEX 索引名（列名）`

`CREATE INDEX 索引名（列名）ON 表名字`

### 3.7 备份

mysqldump 是 MySQL 用于备份数据库的实用程序。它主要产生一个 SQL 脚本文件，其中包含从头重新创建数据库所必需的命令CREATE TABLE INSERT 等。

```sql
mysqldump -u root 数据库名>备份文件名;   #备份整个数据库

mysqldump -u root 数据库名 表名字>备份文件名;  #备份整个表
```

### 3.8 恢复

`source 文件目录`