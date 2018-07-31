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