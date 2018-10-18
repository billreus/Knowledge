# SQL语法

## 初始化

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

## 创建表

```SQL
CREATE TABLE mytable(
  id INT NOT NULL AUTO_INCREMENT,
  col1 INT NOT NULL DEFAULT 1,
  col2 VARCHAR(45) NULL,
  col3 DATE NULL,
  PRIMARY KEY (`id`));
```

## 修改表

添加列

```SQL
ALTER TABLE mytable
ADD col CHAR(20);
```

删除列

```SQL
ALTER TABLE mytable
DROP CILUMN col;
```

删除表

```SQL
DROP TABLE mytable;
```

## 插入

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

## 更新替换

```SQL
UPDATE mytable
SET col = val
WHERE id = 1;
```

## 删除

清空表

```SQL
TRUNCATE TABLE
```

删除指定的数据

```SQL
DELETE FROM mytable
WHERE id = 1;
```

## 查询列

DISTINCT:相同值只出现一次，所有列值相同才算相同

```SQL
SELECT DISTINCT col1, col2
FROM mytable;
```

LIMIT:限制返回行数。第一个参数为起始行，第二个参数为返回总行数。

```SQL
SELECT *
FROM mytable
LIMIT 5;
```

## 排序

ASC：升序。

DESC:降序。

```SQL
SELECT *
FROM mytable
ORDER BY col1 DESC, col2 ASC;
```

## 过滤

```SQL
SELECT *
FROM mytable
WHERE col IS NULL;
```

WHERE语句可用的操作符：`=,<,>,<!=>,>!=<,BERWEEN,IS NULL`

可以使用AND和OR过滤多个条件，IN用于匹配一组值，NOT用于否定。

## 通配符

%:匹配大于等于0个任意字符

_:匹配1个任意字符

[]可以匹配括号内的任意字符。例如 [AB]将匹配A或B。可以用^对其否定

通配符语句使用LIKE

```SQL
SELECT *
FROM mytable
WHERE col LIKE '[^AB]%'; -- 不以A和B开头的任意文本
```

## 计算

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

