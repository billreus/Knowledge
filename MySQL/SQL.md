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