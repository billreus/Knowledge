<!-- TOC -->

- [1. 注解](#1-%E6%B3%A8%E8%A7%A3)
  - [层](#%E5%B1%82)
- [2. DAO层](#2-dao%E5%B1%82)
  - [2.1. Java注解](#21-java%E6%B3%A8%E8%A7%A3)
    - [2.1.1. 插入](#211-%E6%8F%92%E5%85%A5)
    - [2.1.2. 选择](#212-%E9%80%89%E6%8B%A9)
    - [2.1.3. 更新](#213-%E6%9B%B4%E6%96%B0)
  - [2.2. xml配置](#22-xml%E9%85%8D%E7%BD%AE)
- [3. Service层](#3-service%E5%B1%82)
  - [3.1. 复写](#31-%E5%A4%8D%E5%86%99)
  - [3.2. 返回数据](#32-%E8%BF%94%E5%9B%9E%E6%95%B0%E6%8D%AE)
  - [3.3. 对数据进行处理](#33-%E5%AF%B9%E6%95%B0%E6%8D%AE%E8%BF%9B%E8%A1%8C%E5%A4%84%E7%90%86)
- [4. Controller层](#4-controller%E5%B1%82)
- [AOP](#aop)
  - [Request、Response](#requestresponse)
  - [其它](#%E5%85%B6%E5%AE%83)
  - [异常](#%E5%BC%82%E5%B8%B8)
- [AOP](#aop-1)
- [Log](#log)
- [request](#request)
- [response](#response)
- [error](#error)

<!-- /TOC -->

# 1. 注解

## 层

主要层分为：controller，service，dao.

* controller层与web交互，dao层与数据库交互。model与Aspect层作用于主要层。

@Controller ：controller层注解

@Maooer：dao层注解 

@repository ：dao层注解（一般不使用，要自己写对应dao的mapper配置文件）

@service：service层注解

@Aspect：面向切面的AOP层注解

@component：中立层

* model无需注解

# 2. DAO层

DAO层直接与数据库交互，主要有两种与数据库交互的方法：

1. Java注解
2. xml配置文件

## 2.1. Java注解

常用注解：
1. @Insert插入
2. @Select选择
3. @Upadate更新
4. @param命名参数传入sql，与#{}内的参数对应

### 2.1.1. 插入

示例：

```java
@Insert({"insert into ", TABLE_NAME, " (", INSERT_FIELDS,
        " ) values (#{title},#{link},#{image},#{likeCount},#{commentCount},#{createdDate},#{userId})"})
int addNews(News news);
```

### 2.1.2. 选择

示例：

```java
@Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, "where id=#{id}"})
News selectbyId(int id);
```

### 2.1.3. 更新

示例：

```java
@Update({"update ", TABLE_NAME, " set like_count=#{likeCount} where id=#{id}"})
int updateLikeCount(@Param("id")int id,@Param("likeCount")int likeCount);
```

## 2.2. xml配置

配置模版为：

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.nowcode.toutiao.dao.NewsDAO"> <!--相关联的map层-->
    <sql id="table">news</sql><!--表名-->
    <sql id="selectFields">id,title, link, image, like_count, comment_count,created_date,user_id</sql><!--列名-->
    <select id="selectByUserIdAndOffset" resultType="com.nowcode.toutiao.model.News"><!-- -->
        SELECT
        <include refid="selectFields"/>
        FROM
        <include refid="table"/>

        <if test="userId != 0"><!--判断-->
            WHERE user_id = #{userId}
        </if>
        ORDER BY id DESC<!--排序-->
        LIMIT #{offset},#{limit}
    </select>
</mapper>
```

# 3. Service层

实现对DAO层数据操作统一命名对象

## 3.1. 复写

@Autowired 注释，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。 通过 @Autowired的使用来消除 set ，get方法。即不用声明和new对象。

## 3.2. 返回数据

Service层主要对DAO层声明的对象进行return封装，便于Controller层调用

例如在2.1.3中更新了数据，在Service中封装为：

```java
public  int  updateCommentCount(int id,int count){
        return newsDAO.updateCommentCount(id,count);
    }
```

## 3.3. 对数据进行处理

Service层第二个作用是对前端读取上来的数据进行一些处理，处理完再交给DAO层，最后放入数据库。

# 4. Controller层

映射地址使用：@RequestMapping(path={"/dizhi"}, method = {RequestMethod.GET, RequestMethod.POST})

将java对象转为json格式的数据:@ResponseBody

# AOP

@Before和@After：用于切类动作前后

## Request、Response

@RequestMapping：处理请求地址映射的注解，后面("/")

@ResponseBody: 返回结果直接写入 HTTP response body中, 常和mapping一起使用

@RequestParam： 将请求参数绑定至方法参数。例如：(value = "key", defaultValue = "key") String key然后再response方法来添加到页面。

@PathVariable：将请求URL中的模板变量映射到功能处理方法的参数上，用于url上的传递参数，例如在/profile/{id}的url设置中，使用@PathVariable("id") int id。

@CookieValue:绑定获取cookies值

## 其它

@Autowired：对类成员变量、方法及构造函数自动装配，直接声明定义不需要new，直接调用其他类。

## 异常

@Exception

@ExceptionHandler： 异常捕获动作，后面使用@ResponseBody自定义动作





# AOP
# Log
logger.info()
# request
# response
# error