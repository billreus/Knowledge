## json接口开发

需要返回json格式的需要配置@Controller+@ResponseBody或者使用@RestController

## 自定义Filter

filters用于录调用日志、排除有XSS威胁的字符、执行权限验证等等

配置：

1. 实现Filter接口，实现Filter方法
2. 添加@Configuration注解，自定义Filter加入过滤链

```java
@Configuration
public class WebConfiguration {
    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }
    
    @Bean
    public FilterRegistrationBean testFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }
    
    public class MyFilter implements Filter {
		@Override
		public void destroy() {
			// TODO Auto-generated method stub
		}

		@Override
		public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
				throws IOException, ServletException {
			// TODO Auto-generated method stub
			HttpServletRequest request = (HttpServletRequest) srequest;
			System.out.println("this is MyFilter,url :"+request.getRequestURI());
			filterChain.doFilter(srequest, sresponse);
		}

		@Override
		public void init(FilterConfig arg0) throws ServletException {
			// TODO Auto-generated method stub
		}
    }
}
```

## 自定义Property

property用于配置文件,

配置:
1. 在application.properties中
```java
com.neo.title=题目
com.neo.description=描述
```
2. 自定义配置类
```java
@Component
public class NeoProperties {
	@Value("${com.neo.title}")
	private String title;
	@Value("${com.neo.description}")
	private String description;
	//省略getter settet方法
	}
```

## log配置

配置输出的地址和输出级别

```java
logging.path=/user/local/log
logging.level.com.favorites=DEBUG
logging.level.org.springframework.web=INFO
logging.level.org.hibernate=ERROR
```

path为本机的log地址，logging.level  后面可以根据包路径配置不同资源的log级别

## 数据库操作

数据库连接首先在application.properties中：

```java
spring.datasource.url=jdbc:mysql://localhost:3306/toutiao?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=123456
```

## Thymeleaf

### 变量表达式

用${xxx}表达变量

#### 文本打印：

```html
Velocity: <p>$message</p>
FreeMarker: <p>${message}</p>
Thymeleaf: <p th:text="${message}">Hello World!</p>
```

#### for循环

```html
<tr th:each="prod : ${prods}">
      <td th:text="${prod.name}">Onions</td>
      <td th:text="${prod.price}">2.41</td>
      <td th:text="${prod.inStock}? #{true} : #{false}">yes</td>
</tr>
```

#### 条件求值

```html
<a th:href="@{/login}" th:unless=${session.user != null}>Login</a>
```

### URL

把一个有用的上下文或回话信息添加到URL.`@{/order/list} , @{/order/details(id=${orderId})}  `

```html
<a th:href="@{http://www.thymeleaf.org}">Thymeleaf</a>
```

### 选择表达式

*{customer.name}

### 文字国际化表达式

允许我们从一个外部文件获取区域文字信息，用Key索引Value，还可以提供一组参数.

```
#{main.title}  
#{message.entrycreated(${entryId})}  
```

```html
    <table>  
      ...  
      <th th:text="#{header.address.city}">...</th>  
      <th th:text="#{header.address.country}">...</th>  
      ...  
    </table>  
```

### 常用th标签

1. th:id 替换id
2. th:text 文本替换
3. th:value 属性赋值
4. th:each for遍历属性赋值
5. th:if 条件判断
6. th:href 链接地址
7. th:action 表单提交的地址

## Redis

Redis连接首先在application.properties中：

```java
mybatis.config-location=classpath:mybatis-config.xml
mybatis.mapper-locations=classpath:com.nowcode.toutiao/dao/*.xml
```

再添加配置文件mybatis-config.xml

### Mapper

对数据库进行封装，在DAO层通过@Mapper注解进行操作。

常用操作有：选择@Select, 添加@Insert, 更新@Update, 删除@Delete

通过在注解中#{name}与函数中@Param("name") int name来对应赋值操作。

```java
@Mapper
public interface NewsDAO {
    String TABLE_NAME = "news";
    String INSERT_FIELDS = " title, link, image, like_count, comment_count, created_date, user_id ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, " (", INSERT_FIELDS,
            " ) values (#{title},#{link},#{image},#{likeCount},#{commentCount},#{createdDate},#{userId})"})
    int addNews(News news);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, "where id=#{id}"})
    News selectbyId(int id);

    @Update({"update ", TABLE_NAME, " set comment_count=#{commentCount} where id=#{id}"})
    int updateCommentCount(@Param("id")int id,@Param("commentCount")int commentCount);

}
```

### XML

除了在dao层实现对数据库的操作，也可以使用xml映射来实现，dao层只需要声明即可。

首先需要在application.properties中配置映射路径，例如`mybatis.mapper-locations=classpath:com.nowcode.toutiao/dao/*.xml`

然后在main/resources路径下创建与main/java下相同路径且名称一一对应相同的dao层xml文件。

最后编写xml文件，模版如下:

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.nowcode.toutiao.dao.NewsDAO">//对应dao层目录
    <sql id="table">news</sql>//表名
    <sql id="selectFields">id,title, link, image, like_count, comment_count,created_date,user_id</sql>//轴名
    <select id="selectByUserIdAndOffset" resultType="com.nowcode.toutiao.model.News">//对应封装函数名，和需要使用的文件位置
        SELECT
        <include refid="selectFields"/>
        FROM
        <include refid="table"/>

        <if test="userId != 0">
            WHERE user_id = #{userId}
        </if>
        ORDER BY id DESC
        LIMIT #{offset},#{limit}
    </select>//上面为数据库操作
</mapper>
```

写完之后只需要在dao层进行声明，即可和方法一一样进行使用，声明例如：

```java
List<News> selectByUserIdAndOffset(@Param("userId") int userId, @Param("offset") int offset,@Param("limit") int limit);
```

### 使用

在其他层调用只需要对接口进行自动装配@Autowired，然后调用该接口函数进行操作即可。

