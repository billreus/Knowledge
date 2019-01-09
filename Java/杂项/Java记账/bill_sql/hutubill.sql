create database daybook;

use  daybook;
 
CREATE TABLE config (-- 配置信息表。保存每月预算和安装路径
  id int AUTO_INCREMENT, -- 主键
  key_ varchar(255) , -- 键值对
  value varchar(255) , -- 值
  PRIMARY KEY (id) --主键约束
)  DEFAULT CHARSET=utf8;
 
CREATE TABLE category (-- 消费分类表。保存消费分类如餐饮交通等
  id int AUTO_INCREMENT,
  name varchar(255) ,
  PRIMARY KEY (id)
)  DEFAULT CHARSET=utf8;
 
CREATE TABLE record (-- 消费记录表。存放每笔消费记录
  id int AUTO_INCREMENT,
  spend int, -- 花费
  cid int, -- 本表中的id
  comment varchar(255) , --备注
  date Date, 日期
  PRIMARY KEY (id),
  CONSTRAINT `fk_record_category` FOREIGN KEY (`cid`) REFERENCES `category` (`id`) --与上表id关联
)  DEFAULT CHARSET=utf8;