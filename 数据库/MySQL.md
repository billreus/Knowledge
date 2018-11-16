<!-- TOC -->

- [1. 安装](#1-%E5%AE%89%E8%A3%85)
- [2. 使用](#2-%E4%BD%BF%E7%94%A8)
- [3. 创建数据库](#3-%E5%88%9B%E5%BB%BA%E6%95%B0%E6%8D%AE%E5%BA%93)
    - [3.1. 新建数据库](#31-%E6%96%B0%E5%BB%BA%E6%95%B0%E6%8D%AE%E5%BA%93)
    - [3.2. 数据表](#32-%E6%95%B0%E6%8D%AE%E8%A1%A8)
    - [3.3. 约束](#33-%E7%BA%A6%E6%9D%9F)
    - [3.4. SELECT语句](#34-select%E8%AF%AD%E5%8F%A5)
        - [3.4.1. 排序](#341-%E6%8E%92%E5%BA%8F)
        - [3.4.2. SQL内置函数计算](#342-sql%E5%86%85%E7%BD%AE%E5%87%BD%E6%95%B0%E8%AE%A1%E7%AE%97)
        - [3.4.3. 连接查询](#343-%E8%BF%9E%E6%8E%A5%E6%9F%A5%E8%AF%A2)
    - [3.5. 修改](#35-%E4%BF%AE%E6%94%B9)
    - [3.6. 索引](#36-%E7%B4%A2%E5%BC%95)
    - [3.7. 备份](#37-%E5%A4%87%E4%BB%BD)
    - [3.8. 恢复](#38-%E6%81%A2%E5%A4%8D)
- [4. 原理](#4-%E5%8E%9F%E7%90%86)
    - [4.1 索引](#41-%E7%B4%A2%E5%BC%95)
        - [4.1.1. 数据结构](#411-%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84)
            - [4.1.1.1. 二叉树](#4111-%E4%BA%8C%E5%8F%89%E6%A0%91)
            - [4.1.1.2. B-Tree](#4112-b-tree)
            - [4.1.1.3 B+Tree](#4113-btree)

<!-- /TOC -->

# 1. 安装

检查是否安装:`sudo service mysql start`

安装`sudo apt-get install mysql-server`,`sudo apt-get install mysql-client`

安装完成以后设置root用户密码等信息

验证安装并启动成功:`sudo netstat -tap | grep mysql`

MySQL的配置文件可以使用`sudo gedit /etc/mysql/my.cnf`进行修改

# 2. 使用

打开MySQL：`sudo service mysql start`

使用root用户登陆:`mysql -u root`

查看有哪些数据库:`show databases;`

连接数据库:`use 数据库名`

查看数据库中有哪些表:`show tables;`

加载数据库文件:`source 文件路径;`

退出:`exit`

更改密码：`SET PASSWROD FOR myuer = Password('new_password')`

# 3. 创建数据库

## 3.1. 新建数据库

大多数系统中SQL不分大小写，打死你为了严谨，常定义过的字使用大写，数据和变量使用小写。

创建一个名为bill的新的数据库:`CREATE DATABASE bill;`

查看是否存在`show databases;`

连接数据库:`use bill`

删除数据库`DROP DATABASE bill;`

## 3.2. 数据表

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

## 3.3. 约束

MySQL中通常有以下集中约束:

主键`PRIMARY KEY` ,默认值`DEFAULT`，唯一`UNIQUE`，外键`FOREIGN KEY`，非空`NOT NULL`

主键用于约束表中第一行，作为这一行唯一标识符。

默认值用于当有DEFAULT约束的列，参数数据为空时，使用默认值。

唯一规定指定的一列值不能有重复值。

外键用于参考另一个表的主键，被外键约束的列取值必须在参考的列中有对应值。

非空即被约束的列在插入值时必须为非空

## 3.4. SELECT语句

SELECT语句基本格式为：`SELECT 要查询的列名 FROM 表的名字 WHERE 限制条件;`

其中WHERE作为限制条件可以使用:

1. 数学符号 (=, <, >=, <=)
2. OR和AND
3. IN和NOT IN
4. 通用匹配符：`_`代表一个未指定字符，`%`代表不定个指定字符

### 3.4.1. 排序

`ORDER BY 条件 ASC/DESC`可以对关键词进行排序(ASC升序DESC降序)

例如对employee表中的salary降序排列`SELECT name,age,salary,phone FROM employee ORDER BY salary DESC;`

### 3.4.2. SQL内置函数计算

内置计算函数分别为：`COUNT`计数, `SUM`求和, `AVG`求平均, `MAX`最大值, `MIN`最小值

比如计算salary的最大最小值：`SELECT MAX(salary) AS max_salary,MIN(salary) FROM employee;`

* 注：AS关键词可以给值重新命名

### 3.4.3. 连接查询

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

## 3.5. 修改

重命名一张表：`RENAME TABLE 原名 TO 新名字;ALTER TABLE 原名 RENAME 新名;ALTER TABLE 原名 RENAME TO 新名;`

删除表:`DROP TABLE 表的名字`

增加一列：`ALTER TABLE 表名字 ADD COLUMN 列名字 数据类型 约束;`

删除一列:`ALTER TABLE 表名字 DROP COLUMN 列名字;`

重命名一列:`ALTER TABLE 表名字 CHANGE 原列名 新列名 数据类型 约束;`

改变数据类型:`ALTER TABLE 表名字 MODIFY 列名字 新数据类型;`

修改表中某个值:`UPDATE 表名字 SET 列1=值1,列2=值2 WHERE 条件;`

删除一行:`DELETE FROM 表名字 WHERE 条件;`

## 3.6. 索引

对一张表中某列建立索引：

`ALTER TABLE 表名字 ADD INDEX 索引名（列名）`

`CREATE INDEX 索引名（列名）ON 表名字`

## 3.7. 备份

mysqldump 是 MySQL 用于备份数据库的实用程序。它主要产生一个 SQL 脚本文件，其中包含从头重新创建数据库所必需的命令CREATE TABLE INSERT 等。

```sql
mysqldump -u root 数据库名>备份文件名;   #备份整个数据库

mysqldump -u root 数据库名 表名字>备份文件名;  #备份整个表
```

## 3.8. 恢复

`source 文件目录`

# 4. 原理

## 4.1 索引

### 4.1.1. 数据结构

磁盘在读取时是访问内存的十万倍左右，为此计算机进行了优化，进行预读操作。

每次IO时，不仅把当前磁盘地址的数据加载到内存，同时也把相邻数据加载到内存缓冲区。

* 预读说明：当访问一个地址数据的时候，与其相邻的数据很快也会被访问到。每次磁盘IO读取的数据我们称之为一页（page）。一页的大小与操作系统有关，一般为4k或者8k。这也就意味着读取一页内数据的时候，实际上发生了一次磁盘IO。

#### 4.1.1.1. 二叉树

二叉查找树查询的时间复杂度是O（logN），查找速度最快和比较次数最少，既然性能已经如此优秀，但为什么实现索引是使用B-Tree而不是二叉查找树，关键因素是磁盘IO的次数。

数据库索引是存储在磁盘上，当表中的数据量比较大时，索引的大小也跟着增长，达到几个G甚至更多。当我们利用索引进行查询的时候，不可能把索引全部加载到内存中，只能逐一加载每个磁盘页，这里的磁盘页就对应索引树的节点。

为了减少磁盘IO的次数就必须压缩树的高度，让瘦高的树尽量变矮胖，B-Tree就是为此。

#### 4.1.1.2. B-Tree

m阶B-Tree满足以下条件：

1. 每个节点最多拥有m个子树

2. 根节点至少有2个子树

3. 分支节点至少拥有m/2颗子树（除根节点和叶子节点外都是分支节点）

4. 所有叶子节点都在同一层、每个节点最多可以有m-1个key，并且以升序排列

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/B-Tree.png)

该图为寻找0021的过程，在一行中的比较是内存中比较，耗时可以忽略不记。

#### 4.1.1.3 B+Tree

B+Tree是B树的变种，有着比B树更高的查询性能，来看下m阶B+Tree特征：

1. 有m个子树的节点包含有m个元素（B-Tree中是m-1）

2. 根节点和分支节点中不保存数据，只用于索引，所有数据都保存在叶子节点中。

3. 所有分支节点和根节点都同时存在于子节点中，在子节点元素中是最大或者最小的元素。

4. 叶子节点会包含所有的关键字，以及指向数据记录的指针，并且叶子节点本身是根据关键字的大小从小到大顺序链接。

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/B+Tree1.png)

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/B+Tree2.png)

B+树需要：

1. 红点表示是指向卫星数据的指针，指针指向的是存放实际数据的磁盘页，卫星数据就是数据库中一条数据记录。

2. 叶子节点中还有一个指向下一个叶子节点的next指针，所以叶子节点形成了一个有序的链表，方便遍历B+树。

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/B+Tree3.png)

这个过程看下来，貌似与B树的查询过程没有什么区别。但实际上有两点不一样：

1. 首先B+树的中间节点不存储卫星数据，所以同样大小的磁盘页可以容纳更多的节点元素，如此一来，相同数量的数据下，B+树就相对来说要更加矮胖些，磁盘IO的次数更少。

2. 由于只有叶子节点才保存卫星数据，B+树每次查询都要到叶子节点；而B树每次查询则不一样，最好的情况是根节点，最坏的情况是叶子节点，没有B+树稳定。

同时在范围查找时，不像B树那样一个个去查找

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/B+Tree4.png)

总结：

1. 单节点可以存储更多的元素，使得查询磁盘IO次数更少。

2. 所有查询都要查找到叶子节点，查询性能稳定。

3. 所有叶子节点形成有序链表，便于范围查询。

