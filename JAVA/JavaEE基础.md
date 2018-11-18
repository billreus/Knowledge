<!-- TOC -->

- [1 Tomcat](#1-tomcat)
    - [1.1. 浏览器与服务器交互过程](#11-%E6%B5%8F%E8%A7%88%E5%99%A8%E4%B8%8E%E6%9C%8D%E5%8A%A1%E5%99%A8%E4%BA%A4%E4%BA%92%E8%BF%87%E7%A8%8B)
- [2 Servlet](#2-servlet)
    - [2.1 Servlet接口](#21-servlet%E6%8E%A5%E5%8F%A3)
    - [2.2 转发（Forward）和重新定向（Redirect）](#22-%E8%BD%AC%E5%8F%91forward%E5%92%8C%E9%87%8D%E6%96%B0%E5%AE%9A%E5%90%91redirect)
        - [2.2.1 转发（Forword）](#221-%E8%BD%AC%E5%8F%91forword)
        - [2.2.2 重定向（Redirect）](#222-%E9%87%8D%E5%AE%9A%E5%90%91redirect)
        - [2.2.3 区别](#223-%E5%8C%BA%E5%88%AB)
            - [地址栏](#%E5%9C%B0%E5%9D%80%E6%A0%8F)
            - [数据共享](#%E6%95%B0%E6%8D%AE%E5%85%B1%E4%BA%AB)
            - [运用地方](#%E8%BF%90%E7%94%A8%E5%9C%B0%E6%96%B9)
            - [效率](#%E6%95%88%E7%8E%87)
    - [2.3 自动刷新(Refresh)](#23-%E8%87%AA%E5%8A%A8%E5%88%B7%E6%96%B0refresh)
    - [2.4 JSP](#24-jsp)
        - [2.4.1 工作原理](#241-%E5%B7%A5%E4%BD%9C%E5%8E%9F%E7%90%86)
        - [2.4.2 内置对象和方法](#242-%E5%86%85%E7%BD%AE%E5%AF%B9%E8%B1%A1%E5%92%8C%E6%96%B9%E6%B3%95)
            - [Request](#request)
        - [2.4.3 JSP四种作用域](#243-jsp%E5%9B%9B%E7%A7%8D%E4%BD%9C%E7%94%A8%E5%9F%9F)
    - [2.5 Cookies和Session](#25-cookies%E5%92%8Csession)
        - [2.5.1 会话跟踪](#251-%E4%BC%9A%E8%AF%9D%E8%B7%9F%E8%B8%AA)
        - [2.5.2 Cookies和Session区别](#252-cookies%E5%92%8Csession%E5%8C%BA%E5%88%AB)

<!-- /TOC -->

# 1 Tomcat

## 1.1. 浏览器与服务器交互过程

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/tomcat.png)

当我们在地址栏输入URL地址"http://www.gacl.cn:8080/JavaWebDemo1/1.jsp"时服务器和浏览器做了以下操作：

1. 浏览器根据主机名"www.gacl.cn"去操作系统的Hosts文件查找主机名对应的IP地址。
2. 如果在系统Host中没有对应IP地址，会去互联网上的DNS服务器查找"www.gacl.cn"这台主机对应的IP。
3. 查找到"www.gacl.cn"主机对应的IP地址后，使用IP地址连接到Web服务器。
4. 浏览器连接到web服务器吼，就会使用http协议向服务器发送请求，发送请求过程中，浏览器会向Web服务器以Stream(流)的形式传输数据，告诉Web服务器要访问服务器里面的哪个Web应用下的Web资源，如下图所示：

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/tomcat2.png)

其中：

GET是告诉Web服务器，浏览器是以GET的方式向服务器发请求。

/JavaWebDemo1/1.jsp是告诉Web服务器，浏览器要访问JavaWebDemo1应用里面的1.jsp这个Web资源。

HTTP/1.1：告诉Web服务器，浏览器是以HTTP协议请求的，使用的是1.1的版本。

5. 当浏览器完成上面四步就开始等待服务器把1.jsp的web资源传输给它。
6. 服务器接收到浏览器传输的数据后，开始解析接收到的数据，服务器解析"GET /JavaWebDemo1/1.jsp HTTP/1.1"里面的内容时知道客户端浏览器要访问的是JavaWebDemo1应用里面的1.jsp这个Web资源，然后服务器就去读取1.jsp这个Web资源里面的内容，将读到的内容再以Stream(流)的形式传输给浏览器，如下图所示：

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/tomcat3.png)

7. 浏览器拿到服务器的数据就可以把数据展示给用户看。

# 2 Servlet

Servlet主要负责接收用户请求HttpServletRequest,在doGet(),doPost()中做相应的处理，并将回应HttpServletResponse反馈给用户。Servlet可以设置初始化参数，供Servlet内部使用。一个Servlet类只会有一个实例，在它初始化时调用init()方法，销毁时调用destroy()方法。Servlet需要在web.xml中配置，一个Servlet可以设置多个URL访问。Servlet不是线程安全，因此要谨慎使用类变量。

## 2.1 Servlet接口

Servlet接口定义了5个方法，其中前三个方法与Servlet生命周期相关：

* void init(ServletConfig config) throws ServletException
* void service(ServletRequest req, ServletResponse resp) throws ServletException, java.io.IOException
* void destory()
* java.lang.String getServletInfo()
* ServletConfig getServletConfig()

生命周期： Web容器加载Servlet并将其实例化后，Servlet生命周期开始，容器运行其init()方法进行Servlet的初始化；请求到达时调用Servlet的service()方法，service()方法会根据需要调用与请求对应的doGet或doPost等方法；当服务器关闭或项目被卸载时服务器会将Servlet实例销毁，此时会调用Servlet的destroy()方法。

init方法和destory方法只会执行一次，service方法客户端每次请求Servlet都会执行。Servlet中有时会用到一些需要初始化与销毁的资源，因此可以把初始化资源的代码放入init方法中，销毁资源的代码放入destroy方法中，这样就不需要每次处理客户端的请求都要初始化与销毁资源。

## 2.2 转发（Forward）和重新定向（Redirect）

转发是服务器行为，重定向是客户端行为。

### 2.2.1 转发（Forword） 

通过RequestDispatcher对象的forward（HttpServletRequest request,HttpServletResponse response）方法实现的。RequestDispatcher可以通过HttpServletRequest 的getRequestDispatcher()方法获得。例如下面的代码就是跳转到login_success.jsp页面。

```java
     request.getRequestDispatcher("login_success.jsp").forward(request, response);
```

### 2.2.2 重定向（Redirect） 

利用服务器返回的状态码来实现的，客户端浏览器请求服务器的时候，服务器会返回一个状态码。服务器通过HttpServletRequestResponse的setStatus(int status)方法设置状态码。如果服务器返回301或者302，则浏览器会到新的网址重新请求该资源。

### 2.2.3 区别

#### 地址栏

forward是服务器请求资源,服务器直接访问目标地址的URL,把那个URL的响应内容读取过来,然后把这些内容再发给浏览器.浏览器根本不知道服务器发送的内容从哪里来的,所以它的地址栏还是原来的地址. redirect是服务端根据逻辑,发送一个状态码,告诉浏览器重新去请求那个地址.所以地址栏显示的是新的URL.

#### 数据共享

forward:转发页面和转发到的页面可以共享request里面的数据. redirect:不能共享数据.

#### 运用地方

forward:一般用于用户登陆的时候,根据角色转发到相应的模块. redirect:一般用于用户注销登陆时返回主页面和跳转到其它的网站等

#### 效率

forward:高. redirect:低.

## 2.3 自动刷新(Refresh)

自动刷新不仅可以实现一段时间之后自动跳转到另一个页面，还可以实现一段时间之后自动刷新本页面。Servlet中通过HttpServletResponse对象设置Header属性实现自动刷新例如：

```java
Response.setHeader("Refresh","1000;URL=http://localhost:8080/servlet/example.htm");
```

其中1000为时间，单位为毫秒。URL指定就是要跳转的页面

## 2.4 JSP

Servlet是一个特殊的Java程序，它运行于服务器的JVM中，能够依靠服务器的支持向浏览器提供显示内容。JSP本质上是Servlet的一种简易形式，JSP会被服务器处理成一个类似于Servlet的Java程序，可以简化页面内容的生成。Servlet和JSP最主要的不同点在于，Servlet的应用逻辑是在Java文件中，并且完全从表示层中的HTML分离开来。而JSP的情况是Java和HTML可以组合成一个扩展名为.jsp的文件。

JSP侧重于视图，Servlet更侧重于控制逻辑，在MVC架构模式中，JSP适合充当视图（view）而Servlet适合充当控制器（controller）。

### 2.4.1 工作原理

JSP是一种Servlet，但是与HttpServlet的工作方式不太一样。HttpServlet是先由源代码编译为class文件后部署到服务器下，为先编译后部署。而JSP则是先部署后编译。JSP会在客户端第一次请求JSP文件时被编译为HttpJspPage类（接口Servlet的一个子类）。该类会被服务器临时存放在服务器工作目录里面。

### 2.4.2 内置对象和方法

JSP有9个内置对象：

* request：封装客户端的请求，其中包含来自GET或POST请求的参数；
* response：封装服务器对客户端的响应；
* pageContext：通过该对象可以获取其他对象；
* session：封装用户会话的对象；
* application：封装服务器运行环境的对象；
* out：输出服务器响应的输出流对象；
* config：Web应用的配置对象；
* page：JSP页面本身（相当于Java程序中的this）；
* exception：封装页面抛出异常的对象。

#### Request

* setAttribute(String name,Object)：设置名字为name的request 的参数值
* getAttribute(String name)：返回由name指定的属性值
* getAttributeNames()：返回request 对象所有属性的名字集合，结果是一个枚举的实例
* getCookies()：返回客户端的所有 Cookie 对象，结果是一个Cookie 数组
* getCharacterEncoding() ：返回请求中的字符编码方式 = getContentLength() ：返回请求的 Body的长度
* getHeader(String name) ：获得HTTP协议定义的文件头信息
* getHeaders(String name) ：返回指定名字的request Header 的所有值，结果是一个枚举的实例
* getHeaderNames() ：返回所以request Header 的名字，结果是一个枚举的实例
* getInputStream() ：返回请求的输入流，用于获得请求中的数据
* getMethod() ：获得客户端向服务器端传送数据的方法
* getParameter(String name) ：获得客户端传送给服务器端的有 name指定的参数值
* getParameterNames() ：获得客户端传送给服务器端的所有参数的名字，结果是一个枚举的实例
* getParameterValues(String name)：获得有name指定的参数的所有值
* getProtocol()：获取客户端向服务器端传送数据所依据的协议名称
* getQueryString() ：获得查询字符串
* getRequestURI() ：获取发出请求字符串的客户端地址
* getRemoteAddr()：获取客户端的 IP 地址
* getRemoteHost() ：获取客户端的名字
* getSession([Boolean create]) ：返回和请求相关 Session
* getServerName() ：获取服务器的名字
* getServletPath()：获取客户端所请求的脚本文件的路径
* getServerPort()：获取服务器的端口号
* removeAttribute(String name)：删除请求中的一个属性

其中getAttribute()与getParameter()区别在于：

1. getParameter()是获取 POST/GET 传递的参数值，getAttribute()是获取对象容器中的数据值；
2. getParameter用于客户端重定向时，getAttribute用于服务器端重定向时；

总结：getParameter 返回的是String,用于读取提交的表单中的值;getAttribute 返回的是Object，需进行转换,可用setAttribute 设置成任意对象。

### 2.4.3 JSP四种作用域

JSP中的四种作用域包括page、request、session和application，具体来说：

* page代表与一个页面相关的对象和属性。
* request代表与Web客户机发出的一个请求相关的对象和属性。一个请求可能跨越多个页面，涉及多个Web组件；需要在页面显示的临时数据可以置于此作用域。
* session代表与某个用户与服务器建立的一次会话相关的对象和属性。跟某个用户相关的数据应该放在用户自己的session中。
* application代表与整个Web应用程序相关的对象和属性，它实质上是跨越整个Web应用程序，包括多个页面、请求和会话的一个全局作用域。

## 2.5 Cookies和Session

### 2.5.1 会话跟踪

可以使用Cookies和URL重写

1. 向客户端发送Cookie

```java
Cookie c =new Cookie("name","value"); //创建Cookie 
c.setMaxAge(60*60*24); //设置最大时效，此处设置的最大时效为一天
response.addCookie(c); //把Cookie放入到HTTP响应中
```

从客户端读取Cookie

```java
String name ="name"; 
Cookie[]cookies =request.getCookies(); 
if(cookies !=null){ 
   for(int i= 0;i<cookies.length;i++){ 
    Cookie cookie =cookies[i]; 
    if(name.equals(cookis.getName())) 
    //something is here. 
    //you can get the value 
    cookie.getValue(); 
       
   }
 }
 ```

优点: 数据可以持久保存，不需要服务器资源，简单，基于文本的Key-Value

缺点: 大小受到限制，用户可以禁用Cookie功能，由于保存在本地，有一定的安全风险。

2. URL重写

在URL中添加用户会话的信息作为请求的参数，或者将唯一的会话ID添加到URL结尾以标识一个会话。

优点： 在Cookie被禁用的时候依然可以使用

缺点： 必须对网站的URL进行编码，所有页面必须动态生成，不能用预先记录下来的URL进行访问。

3. 隐藏的表单域

```jsp
<input type="hidden" name ="session" value="..."/>
```

优点： Cookie被禁时可以使用

缺点： 所有页面必须是表单提交之后的结果。

4. HttpSession
在所有会话跟踪技术中，HttpSession对象是最强大也是功能最多的。当一个用户第一次访问某个网站时会自动创建 HttpSession，每个用户可以访问他自己的HttpSession。可以通过HttpServletRequest对象的getSession方 法获得HttpSession，通过HttpSession的setAttribute方法可以将一个值放在HttpSession中，通过调用 HttpSession对象的getAttribute方法，同时传入属性名就可以获取保存在HttpSession中的对象。与上面三种方式不同的 是，HttpSession放在服务器的内存中，因此不要将过大的对象放在里面，即使目前的Servlet容器可以在内存将满时将HttpSession 中的对象移到其他存储设备中，但是这样势必影响性能。添加到HttpSession中的值可以是任意Java对象，这个对象最好实现了 Serializable接口，这样Servlet容器在必要的时候可以将其序列化到文件中，否则在序列化时就会出现异常。

### 2.5.2 Cookies和Session区别

由于HTTP协议是无状态的协议，所以服务端需要记录用户的状态时，就需要用某种机制来识具体的用户，这个机制就是Session.典型的场景比如购物车，当你点击下单按钮时，由于HTTP协议无状态，所以并不知道是哪个用户操作的，所以服务端要为特定的用户创建了特定的Session，用用于标识这个用户，并且跟踪用户，这样才知道购物车里面有几本书。这个Session是保存在服务端的，有一个唯一标识。在服务端保存Session的方法很多，内存、数据库、文件都有。集群的时候也要考虑Session的转移，在大型的网站，一般会有专门的Session服务器集群，用来保存用户会话，这个时候 Session 信息都是放在内存的，使用一些缓存服务比如Memcached之类的来放 Session。

思考一下服务端如何识别特定的客户？这个时候Cookie就登场了。每次HTTP请求的时候，客户端都会发送相应的Cookie信息到服务端。实际上大多数的应用都是用 Cookie 来实现Session跟踪的，第一次创建Session的时候，服务端会在HTTP协议中告诉客户端，需要在 Cookie 里面记录一个Session ID，以后每次请求把这个会话ID发送到服务器，我就知道你是谁了。有人问，如果客户端的浏览器禁用了 Cookie 怎么办？一般这种情况下，会使用一种叫做URL重写的技术来进行会话跟踪，即每次HTTP交互，URL后面都会被附加上一个诸如 sid=xxxxx 这样的参数，服务端据此来识别用户。

Cookie其实还可以用在一些方便用户的场景下，设想你某次登陆过一个网站，下次登录的时候不想再次输入账号了，怎么办？这个信息可以写到Cookie里面，访问网站的时候，网站页面的脚本可以读取这个信息，就自动帮你把用户名给填了，能够方便一下用户。这也是Cookie名称的由来，给用户的一点甜头。所以，总结一下：Session是在服务端保存的一个数据结构，用来跟踪用户的状态，这个数据可以保存在集群、数据库、文件中；Cookie是客户端保存用户信息的一种机制，用来记录用户的一些信息，也是实现Session的一种方式。