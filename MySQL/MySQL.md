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

表中具体内容使用:`SELECT * FROM employee`查看

表中插入数据:`INSERT INTO 表的名字(列名a, 列名b, 列名c) VALUES(值1, 值2, 值3);`

### 3.3 约束

MySQL中通常有以下集中约束:

主键`PRIMARY KEY` ,默认值`DEFAULT`，唯一`UNIQUE`，外键`FOREIGN KEY`，非空`NOT NULL`

主键用于约束表中第一行，作为这一行唯一标识符。

默认值用于当有DEFAULT约束的列，参数数据为空时，使用默认值。

唯一规定指定的一列值不能有重复值。

外键用于参考另一个表的主键，被外键约束的列取值必须在参考的列中有对应值。

非空即被约束的列在插入值时必须为非空

