<!-- TOC -->

- [SQL语法](#sql语法)
    - [概念](#概念)
        - [主键与外键](#主键与外键)
    - [基本操作](#基本操作)
        - [创建表](#创建表)
        - [修改表](#修改表)
        - [插入](#插入)
        - [更新替换](#更新替换)
        - [删除](#删除)
    - [查询](#查询)
        - [查询列](#查询列)
        - [排序](#排序)
        - [过滤](#过滤)
        - [通配符](#通配符)
        - [计算](#计算)
    - [文本处理](#文本处理)
    - [日期和时间处理](#日期和时间处理)
    - [分组](#分组)
    - [连接](#连接)
        - [内连接](#内连接)
        - [自连接](#自连接)
        - [自然连接](#自然连接)
        - [外连接](#外连接)

<!-- /TOC -->

# SQL语法

## 概念

### 主键与外键

主键是能确定一条记录的唯一标识，比如，一条记录包括身份正号，姓名，年龄。身份证号是唯一能确定你这个人的，其他都可能有重复，所以，身份证号是主键。

外键用于与另一张表的关联。是能确定另一张表记录的字段，用于保持数据的一致性。比如，A表中的一个字段，是B表的主键，那他就可以是A表的外键。

例如：

学生表(学号，姓名，性别，班级)

    其中每个学生的学号是唯一的，学号就是一个主键；

课程表(课程编号,课程名,学分)

    其中课程编号是唯一的,课程编号就是一个主键；

成绩表(学号,课程号,成绩)

    成绩表中单一一个属性无法唯一标识一条记录，学号和课程号的组合才可以唯一标识一条记录，所以，学号和课程号的属性组是一个主键。

成绩表中的学号不是成绩表的主键，但它和学生表中的学号相对应，并且学生表中的学号是学生表的主键，则称成绩表中的学号是学生表的外键；同理，成绩表中的课程号是课程表的外键。

## 基本操作

SQL注释支持以下三种

```SQL
# 注释
SELECT * --注释
/* 注释
   注释 */
```

数据库的创建与使用：

```SQL
CREATE DATABASE test;
USE test;
```

### 创建表

```SQL
CREATE TABLE mytable(
  id INT NOT NULL AUTO_INCREMENT, --该值不允许为空，自增数列
  col1 INT NOT NULL DEFAULT 1, --约束，默认为1
  col2 VARCHAR(45) NULL,
  col3 DATE NULL,
  PRIMARY KEY (`id`)); --主键
```

### 修改表

添加列

```SQL
ALTER TABLE mytable
ADD col CHAR(20);
```

删除列

```SQL
ALTER TABLE mytable
DROP COLUMN col;
```

删除表

```SQL
DROP TABLE mytable;
```

### 插入

普通插入

```SQL
INSERT INTO mytable(col1, col2)
VALUES(val1, val2);
```

插入检索出来的数据

```SQL
INSERT INTO mytable1(col1, col2)
SELECT col1, col2
FROM mytable2;
```

将一个表的内容插入到一个新表

```SQL
CREATE TABLE newtable AS
SELECT * FROM mytable;
```

### 更新替换

```SQL
UPDATE mytable
SET col = val
WHERE id = 1;
```

### 删除

清空表

```SQL
TRUNCATE TABLE
```

删除指定的数据

```SQL
DELETE FROM mytable
WHERE id = 1;
```

## 查询

SELECT语句用于从表中选取数据。

```sql
SELECT 列名 FROM 表名

SELECT * FROM 表名 -- 选取所有列
```

### 查询列

DISTINCT:相同值只出现一次（删除了重复的数据），所有列值相同才算相同

```SQL
SELECT DISTINCT col1, col2
FROM mytable;
```

LIMIT:限制返回行数。第一个参数为起始行（0为第一行），第二个参数为返回总行数。

```SQL
SELECT *
FROM mytable
LIMIT 5;
```

### 排序

ASC：升序。

DESC:降序。

```SQL
SELECT *
FROM mytable
ORDER BY col1 DESC, col2 ASC;
```

### 过滤

```SQL
SELECT *
FROM mytable
WHERE col IS NULL;
```

WHERE语句可用的操作符：`=,<,>,<!=>,>!=<,BERWEEN,IS NULL`

可以使用AND和OR过滤多个条件，IN用于匹配一组值，NOT用于否定。

### 通配符

%:匹配大于等于0个任意字符

_:匹配1个任意字符

[]可以匹配括号内的任意字符。例如 [AB]将匹配A或B。可以用^对其否定

通配符语句使用LIKE

```SQL
SELECT *
FROM mytable
WHERE col LIKE '[^AB]%'; -- 不以A和B开头的任意文本
```

### 计算

计算出结果一般使用AS来取别名，否则输出字段名为计算表达式

```SQL
SELECT col1 * col2 AS alias
FROM mytable;
```

CONCAT() 用于连接两个字段。许多数据库会使用空格把一个值填充为列宽，因此连接的结果会出现一些不必要的空格，使用 TRIM() 可以去除首尾空格。

```SQL
SELECT CONCAT(TRIM(col1), '(', TRIM(col2), ')') AS concat_col
FROM mytable;
```

常用计算函数有：`AVG(), COUNT(), MAX(), MIN(), SUM()`

## 文本处理

LEFT():左边的字符

RIGHT():右边的字符

LOWER():转换成小写

UPPER():转换成大写

LTRIM():去除左边空格

RTRIM():去除右边空格

LENGTH():长度

SOUNDEX():转换为语音值

## 日期和时间处理

* 日期格式：YYYY-MM-DD
* 时间格式：HH:MM:SS

AddDate()：增加一个日期（天、周等）

AddTime()：增加一个时间（时、分等）

CurDate()：返回当前日期

CurTime()：返回当前时间

Date()：返回日期时间的日期部分

DateDiff()：计算两个日期之差

Date_Add()：高度灵活的日期运算函数

Date_Format()：返回一个格式化的日期或时间串

Day()：返回一个日期的天数部分

DayOfWeek()：对于一个日期，返回对应的星期几

Hour()：返回一个时间的小时部分

Minute()：返回一个时间的分钟部分

Month()：返回一个日期的月份部分

Now()：返回当前日期和时间

Second()：返回一个时间的秒部分

Time()：返回一个日期时间的时间部分

Year()：返回一个日期的年份部分

## 分组

分组就是把具有相同数据值的行放在同一组中

```sql
SELECT col, COUNT(*) AS num --COUNT(*)表示所有行，以选中的相同col，放入num列
FROM mytable
GROUP BY col;
```

## 连接

连接用于连接多个表，使用JOIN关键字，条件语句使用ON而不是WHERE

### 内连接

内连接又称等值连接，使用INNER JOIN关键字

```sql
SELECT A.value, B.value --选取A,B表的value列，最后显示这两列
FROM tablea AS A INNER JOIN tableb AS B --tablea AS A取别名
ON A.key = B.key; --连接条件是a,b表的key列相等
```

### 自连接

可以看成是内连接的一种，只是连接的表是自己本身

例如：一张员工表，包含员工姓名和员工所属部门，要找出与 Jim 处在同一部门的所有员工姓名。

```sql
SELECT e1.name
FROM employee AS e1 INNER JOIN employee AS e2
ON e1.department = e2.department
      AND e2.name = "Jim";
```

### 自然连接

自然连接是把同名列通过等值测试连接起来的，同名列可以有多个。

内连接和自然连接的区别：内连接提供连接的列，而自然连接自动连接所有同名列。

```sql
SELECT A.value, B.value
FROM tablea AS A NATURAL JOIN tableb AS B;
```

### 外连接

外连接保留了没有关联的那些行。分为左外连接，右外连接以及全外连接，左外连接就是保留左表没有关联的行。

```sql
SELECT Customers.cust_id, Orders.order_num
FROM Customers LEFT OUTER JOIN Orders
ON Customers.cust_id = Orders.cust_id;
```