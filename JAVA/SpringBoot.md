# 注解

## 层

主要层分为：controller，dao，service

@Controller：controller层注解

@repository：dao层注解

@service：service层注解

@Aspect：面向切面的AOP层注解

@component：除了三层以外的中立层，例如AOP层

## AOP

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