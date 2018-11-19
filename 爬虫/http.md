<!-- TOC -->

- [1.HTTP基础](#1http基础)
    - [1.1.URL](#11url)
    - [1.2.超文本](#12超文本)
    - [1.3.HTTP、HTTPS](#13httphttps)
    - [1.4.HTTP请求过程](#14http请求过程)
    - [1.5.Request](#15request)
        - [1.5.1.GET POST](#151get-post)
        - [1.5.2.Request URL](#152request-url)
        - [1.5.3.Request Headers](#153request-headers)
        - [1.5.4.Requset Body](#154requset-body)
    - [1.6.Response](#16response)
        - [1.6.1.Response Status Code](#161response-status-code)
        - [1.6.2.Response Headers](#162response-headers)
        - [1.6.3.Respose Body](#163respose-body)
- [2.Web基础](#2web基础)
    - [2.1.网页的组成](#21网页的组成)
    - [2.2.网页结构](#22网页结构)
    - [2.3.选择器](#23选择器)

<!-- /TOC -->

# 1.HTTP基础

## 1.1.URL

目前网页链接基本都是URL。

## 1.2.超文本

网页的源代码HTML可称为超文本。

## 1.3.HTTP、HTTPS

在 URL 的开头会有 http 或 https，这个就是访问资源需要的协议类型。

HTTP 的全称是 Hyper Text Transfer Protocol，中文名叫做超文本传输协议，HTTP 协议是用于从网络传输超文本数据到本地浏览器的传送协议，目前广泛使用的是 HTTP 1.1 版本。

HTTPS 的全称是 Hyper Text Transfer Protocol over Secure Socket Layer，是以安全为目标的 HTTP 通道，简单讲是 HTTP 的安全版，即 HTTP 下加入 SSL 层，简称为 HTTPS。

## 1.4.HTTP请求过程

当输入一个URL，浏览器向网站所在的服务器发送了一个 Request，即请求，网站服务器接收到这个 Request 之后进行处理和解析，然后返回对应的一个 Response，即响应，然后传回给浏览器，Response里面就包含了页面的源代码等内容，浏览器再对其进行解析便将网页呈现了出来。

## 1.5.Request

Request，即请求，由客户端向服务端发出。可以将 Request 划分为四部分内容：Request Method、Request URL、Request Headers、Request Body，即请求方式、请求链接、请求头、请求体。

### 1.5.1.GET POST

请求方式常见两种类型：GET和POST

我们在浏览器中直接输入一个 URL 并回车，这便发起了一个 GET 请求，请求的参数会直接包含到 URL 里，例如百度搜索 Python，这就是一个 GET 请求，链接为：https://www.baidu.com/s?wd=Python，URL 中包含了请求的参数信息，这里参数 wd 就是要搜寻的关键字。

POST 请求大多为表单提交发起，如一个登录表单，输入用户名密码，点击登录按钮，这通常会发起一个 POST 请求，其数据通常以 Form Data 即表单的形式传输，不会体现在 URL 中。

GET 和 POST 请求方法有如下区别：

* GET 方式请求中参数是包含在 URL 里面的，数据可以在 URL 中看到，而 POST 请求的 URL 不会包含这些数据，数据都是通过表单的形式传输，会包含在 Request Body 中。
* GET 方式请求提交的数据最多只有 1024 字节，而 POST 方式没有限制。

我们平常遇到的绝大部分请求都是 GET 或 POST 请求，另外还有一些请求方式，如 HEAD、PUT、DELETE、OPTIONS、CONNECT、TRACE。

### 1.5.2.Request URL

请求的网址，用URL可以唯一确定请求的资源。

### 1.5.3.Request Headers

 请求头，用来说明服务器要使用的附加信息，如Cookie、Referer、User-Agent等。

* Accept，请求报头域，用于指定客户端可接受哪些类型的信息。
* Accept-Language，指定客户端可接受的语言类型。
* Accept-Encoding，指定客户端可接受的内容编码。
* Host，用于指定请求资源的主机 IP 和端口号，其内容为请求 URL 的原始服务器或网关的位置。从 HTTP 1.1 版本开始，Request 必须包含此内容。
* Cookie，也常用复数形式 Cookies，是网站为了辨别用户进行 Session 跟踪而储存在用户本地的数据。Cookies 的主要功能就是维持当前访问会话，例如我们输入用户名密码登录了某个网站，登录成功之后服务器会用 Session 保存我们的登录状态信息，后面我们每次刷新或请求该站点的其他页面时会发现都是保持着登录状态的，在这里就是 Cookies 的功劳，Cookies 里有信息标识了我们所对应的服务器的 Session 会话，每次浏览器在请求该站点的页面时都会在请求头中加上 Cookies 并将其发送给服务器，服务器通过 Cookies 识别出是我们自己，并且查出当前状态是登录的状态，所以返回的结果就是登录之后才能看到的网页内容。
* Referer，此内容用来标识这个请求是从哪个页面发过来的，服务器可以拿到这一信息并做相应的处理，如做来源统计、做防盗链处理等。
* User-Agent，简称 UA，它是一个特殊字符串头，使得服务器能够识别客户使用的操作系统及版本、浏览器及版本等信息。在做爬虫时加上此信息可以伪装为浏览器，如果不加很可能会被识别出为爬虫。
* Content-Type，即 Internet Media Type，互联网媒体类型，也叫做 MIME 类型，在 HTTP 协议消息头中，使用它来表示具体请求中的媒体类型信息。例如 text/html 代表 HTML 格式，image/gif 代表 GIF 图片，application/json 代表 Json 类型，更多对应关系可以查看此对照表：http://tool.oschina.net/commons。

### 1.5.4.Requset Body

即请求体，一般承载的内容是 POST 请求中的 Form Data，即表单数据，而对于 GET 请求 Request Body 则为空。

## 1.6.Response

Response，即响应，由服务端返回给客户端。Response 可以划分为三部分，Response Status Code、Response Headers、Response Body。

### 1.6.1.Response Status Code

响应状态码，此状态码表示了服务器的响应状态，如 200 则代表服务器正常响应，404 则代表页面未找到，500 则代表服务器内部发生错误。

### 1.6.2.Response Headers

响应头，其中包含了服务器对请求的应答信息，如 Content-Type、Server、Set-Cookie 等，下面将一些常用的头信息说明如下：

* Date，标识 Response 产生的时间。
* Last-Modified，指定资源的最后修改时间。
* Content-Encoding，指定 Response 内容的编码。
* Server，包含了服务器的信息，名称，版本号等。
* Content-Type，文档类型，指定了返回的数据类型是什么，如text/html 则代表返回 HTML 文档，application/x-javascript 则代表返回 JavaScript 文件，image/jpeg 则代表返回了图片。
* Set-Cookie，设置Cookie，Response Headers 中的 Set-Cookie即告诉浏览器需要将此内容放在 Cookies 中，下次请求携带 Cookies 请求。
* Expires，指定 Response 的过期时间，使用它可以控制代理服务器或浏览器将内容更新到缓存中，如果再次访问时，直接从缓存中加载，降低服务器负载，缩短加载时间。

### 1.6.3.Respose Body

即响应体，最重要的当属响应体内容了，响应的正文数据都是在响应体中，如请求一个网页，它的响应体就是网页的 HTML 代码，请求一张图片，它的响应体就是图片的二进制数据。所以最主要的数据都包含在响应体中了，我们做爬虫请求网页后要解析的内容就是解析响应体。

# 2.Web基础

## 2.1.网页的组成

网页可以分为三个部分，HTML、CSS、JavaScript.

HTML相当于骨架，通过各种标签来表示，如图片用img，段落用p，它们之间的布局通过布局标签div嵌套组合。

css为层叠样式表，层叠指HTML中引用数个样式文件翻身冲突时，浏览器能依据层叠处理。样式指网页中的文字大小、颜色、间距、排列等。

```css
#head_wrapper.s-ps-islite .s-p-top {
    position: absolute;
    bottom: 40px;
    width: 100%;
    height: 181px;
}
```

在大括号前面是一个CSS选择器，此选择器的意思是选中 id 为 head_wrapper 且class为s-ps-islite内部的s-p-top 的元素。

## 2.2.网页结构

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>This is a Demo</title>
    </head>
    <body>
        <div id="container">
            <div class="wrapper">
                <h2 class="title">Hello World</h2>
                <p class="text">Hello, this is a paragraph.</p>
            </div>
        </div>
    </body>
</html>
```
开头是 DOCTYPE 定义了文档类型，其次最外层是 html 标签，最后还有对应的结尾代表标签闭合，其内部是 head 标签和 body 标签，分别代表网页头和网页体，它们也分别需要尾标签表示闭合。

title定义了网页标题，body显示网页内容，div 定义网页中的区块。

区块中id名称唯一，我们可以通过id读取这个区块，区块内有个class为weapper，可与css配合设定样式。h2表示一个二级标题，p表示一个段落。

## 2.3.选择器

网页由一个个节点组成，css选择器根据不同节点设置不同样式规则。

例如上例中有个div的结点的id为container，我们可以用#container来表示。