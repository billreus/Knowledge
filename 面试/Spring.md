# SpringBoot

## 文件结构
/src

​	/main

​		/java

​			/model1

​				/config

​				/exception

​				/pojo(DTO发给前端，PO数据库查询，VO前端发过来的数据)

​				/enums

​				/controller

​				/service

​				/dao --用于get，set

​		/resources -- 资源

​			/mappers --xml映射

​			/static -- 静态资源

​			/templates --动态资源

​	/test -- 测试


## 注解

### 自定义注解

自定义注解首先定义注解名：

```java
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}
```

其中@Target定义了Annotation修饰对象的范围，ElementType的类型有：

1. CONSTRUCTOR:用于描述构造器
2. FIELD:用于描述域
3. LOCAL_VARIABLE:用于描述局部变量
4. METHOD:用于描述方法
5. PACKAGE:用于描述包
6. PARAMETER:用于描述参数
7. TYPE:用于描述类、接口(包括注解类型) 或enum声明

@Retention定义了注解的生命周期，生命周期有三种：

1. RetentionPolicy.SOURCE：注解只保留在源文件，当Java文件编译成class文件的时候，注解被遗弃；
2. RetentionPolicy.CLASS：注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期；
3. RetentionPolicy.RUNTIME：注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；

这3个生命周期分别对应于：Java源文件(.java文件) ---> .class文件 ---> 内存中的字节码。

首先要明确生命周期长度 SOURCE < CLASS < RUNTIME ，所以前者能作用的地方后者一定也能作用。一般如果需要在运行时去动态获取注解信息，那只能用 RUNTIME 注解；如果要在编译时进行一些预处理操作，比如生成一些辅助代码（如 ButterKnife），就用 CLASS注解；如果只是做一些检查性的操作，比如 @Override 和 @SuppressWarnings，则可选用 SOURCE 注解。

### 自定义解析器

自定义注解需要搭配自定义解析器使用，从而实现自定义注解的功能。首先自定义注解下去需要实现`HandlerMethodArgumentResolver`接口。

`HandlerMethodArgumentResolver`接口包含两个接口函数

```java
public interface HandlerMethodArgumentResolver {
    boolean supportsParameter(MethodParameter var1);

    @Nullable
    Object resolveArgument(MethodParameter var1, @Nullable ModelAndViewContainer var2, NativeWebRequest var3, @Nullable WebDataBinderFactory var4) throws Exception;
}
```

`supportsParameter`用于判定是否需要处理该参数，返回true为需要，一般自定义注解会绑定在该函数中，然后会调用下面的方法`resolveArgument`，`resolveArgument`会处理参数返回。

#### 例子

```java
public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    /**
    * Token头名称
    **/
    private static final String TOKEN = "Shop-Token";

    /**
    * 判断是否支持要转换的参数类型
    **/
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().isAssignableFrom(Integer.class) && methodParameter.hasParameterAnnotation(LoginUser.class);
    }

    /**
    * 判断支持后进行的校验
    **/
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        String token = nativeWebRequest.getHeader(TOKEN);
        if(token == null || token.isEmpty()){
            return null;
        }
        return UserToken.getUserId(token);
    }
}
```

## Token

### 概念

JSON Web Token是目前最流行的跨域认证方案，特别适用于分布式站点的单点登陆（SSO）场景。

### 原理

服务器认证后会生成一个JSON对象，发回给用户，以后每次通信都携带此JSON对象，由于服务器不需要保存任何数据，所以服务器就变成无状态的。

Token较于session区别在于：

1. session 存储在服务端占用服务器资源，而 JWT 存储在客户端
2. session 存储在 Cookie 中，存在伪造跨站请求伪造攻击的风险
3. session 只存在一台服务器上，那么下次请求就必须请求这台服务器，不利于分布式应用
4. 存储在客户端的 JWT 比存储在服务端的 session 更具有扩展性

Token验证流程：

1. 浏览器发起请求登陆，携带用户名和密码；
2. 服务端验证身份，根据算法，将用户标识符打包生成 token,
3. 服务器返回JWT信息给浏览器，JWT不包含敏感信息；
4. 浏览器发起请求获取用户资料，把刚刚拿到的 token一起发送给服务器；
5. 服务器发现数据中有 token，验明正身；
6. 服务器返回该用户的用户资料；

### JWT

一个Token分为3部分，按顺序：

* 头部(header)
* 载荷(payload)
* 签名(signature)

#### 头部

头部有两个信息，声明类型和加密算法，通常使用jwt和SHA256。

#### 载荷

用来存放实际需要传递数据，JWT默认不加密。

#### 签名

签名部分是对前两部分的签名，防止数据篡改。

### 生成

生成和校验Token可以如下：

```java
public class JwtUtil {
    /**
     * 密钥
     */
    private static final String SECRET = "Shop321Token123";

    /**
     * 签名生成者
     */
    private static final  String ISSUSER = "admin";

    /**
     * 签名主题
     */
    private static final String SUBJECT = "this is shop token";
    /**
     * 签名观众
     */
    static final String AUDIENCE = "APP";

    /**
     * 生成TOKEN
     * @param userId
     * @return
     */
    public String createToken(Integer userId){
        try{
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            Map<String, Object> map = new HashMap<>();
            Date nowDate = new Date();
            // 过期时间：2小时
            Date expireDate = getAfterDate(nowDate,0,0,0,2,0,0);
            map.put("alg", "HS256");
            map.put("typ", "JWT");
            String token = JWT.create()
                    // 设置头部信息 Header
                    .withHeader(map)
                    // 设置 载荷 Payload
                    .withClaim("userId", userId)
                    .withIssuer(ISSUSER)
                    .withSubject(SUBJECT)
                    .withAudience(AUDIENCE)
                    // 生成签名的时间
                    .withIssuedAt(nowDate)
                    // 签名过期的时间
                    .withExpiresAt(expireDate)
                    // 签名 Signature
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception){
            exception.printStackTrace();
        }
        return null;
    }

    /**
     * 校验token获取id
     * @param token
     * @return
     */
    public Integer verifyTokenAndGetUserId(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSUSER)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            Map<String, Claim> claims = jwt.getClaims();
            Claim claim = claims.get("userId");
            return claim.asInt();
        } catch (JWTVerificationException exception){
            exception.printStackTrace();
        }
        return 0;
    }
}
```

## AOP

### 配置

首先定义一个切面类，加上@Component和@Aspect注解

然后定义切点

```java
private final String POINT_CUT = "execution(public * com.springboot.controller.*.*(..))";

@Pointcut(POINT_CUT)
public void pointCut(){}
```

最后通知增强，主要包括五个注解：

1. @Before  在切点方法之前执行
2. @After  在切点方法之后执行
3. @AfterReturning 切点方法返回后执行
4. @AfterThrowing 切点方法抛异常执行
5.  @Around 属于环绕增强，能控制切点执行前，执行后，用这个注解后，程序抛异常，会影响@AfterThrowing这个注解

# MQ

作用：

1. 异步处理提高系统性能（生产者只管把消息发出去，消费者什么时候消费，生产者不用管）。
2. 降低系统耦合性。
3. 流量削峰，高并发下，mq作为临时容器将消息存起来，消费者根据数据库的能力采取拉模式拉取所有消息然后分页执行。
4. 消息分发，通过扇型交换机（Fanout exchange）或者多重绑定，可以将消息发给多个队列。
5. 延时任务，比如超时未支付等通过延时交换机（Delayed message exchange）实现。

缺点：

1. 降低系统的可用性，mq挂了整个系统都挂了。
2. 增加系统复杂度。
3. 一致性问题，生产者消息发出去了就提示前端成功，消费者可能偏偏就失败了。
4. 生成者可能发送失败，消费者可能消费失败，消息可能重复投递/消费。

## RabbitMQ

消息由生产者发送到Exchange中，然后Exchange和Message Queue之间通过Routing Key建立路由规则关联起来；消费者直接订阅Message Queue，只要Queue里面有消息，就会被消费者消费，实现生产者与消费者的低耦合。

### Exchange

Exchange有四种类型，分别是Direct, Topic, Fanout, Header。

#### Direct

所有发送到Direct Exchange的消息都会转发到RouteKey中的指定Queue。

* Direct自带默认的key，可以不进行任何绑定(binding)

#### Topic

与Direct类似，不过routingkey可以有通配符，从而实现多个消息发到同一个队列中

#### Fanout

直接将消息路由绑定到所有队列中，无需进行匹配操作

#### Header Exchange

根据header来匹配

### DLX(死信队列)

当一个消息在队列中变成死信之后会重新publish到宁一个Exchange。

消息变成死信的情况：

1. 消息被拒绝，ack为false，并且requeue=false;
2. 消息TTL过期
3. 队列达到最大长度

#### 插件

延时队列一般使用`rabbitmq-delayed-message-exchange`插件，即在Exchange中根据各个message的`x-delay`头设置延迟时间，时间到达后才发送到对应的queue，进而被queue消费。

正常我们申明一个Exchange只需要指定其类型（direct，fanout，topic等）即可，而声明延迟Exchange需要指定type为`x-delayed-message`，并通过参数`x-delay-type`指定其Exchange的类型（direct，fanout，topic等）。其实现如下：

```
  Map<String, Object> params = new HashMap<>();
  params.put("x-delay-type", "direct");
  channel.exchangeDeclare(exchangeName, "x-delayed-message", false, false, params);
```

- 声明好Exchange之后，绑定任意队列即可

- 发送消息的时候需要额外添加header，`x-delay`，用于设置延迟时间，单位：ms。实现如下：

```
  int delayMs = 5000;
  String msg1 = "delay message " + delayMs;
  Map<String, Object> headers = new HashMap<>();
  headers.put("x-delay", delayMs);
  AMQP.BasicProperties props = new AMQP.BasicProperties.Builder().headers(headers).build();
  channel.basicPublish(exchangeName, "", props, msg1.getBytes("utf-8"));
```