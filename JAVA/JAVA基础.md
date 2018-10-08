# JAVA基础

## 1 集合类框架

### 1.1 Java.util

Java.util中的集合类包含Java中最常用的类。常用的接口是List和Map。

List包括ArrayList和Vector。他们是可变大小的列表。

#### 1.1.1 ArrayList

ArrayList就是动态数组，可自动改变大小，灵活插入删除元素。

其中常用的方法有:

1. add(E e)将指定元素添加到列表尾部
2. clear()移除此列表中的所有元素
3. contains(Object)如果列表含有指定元素返回ture
4. get(int index)返回列表中指定位置上的元素
5. remove(int index)移除此列表中指定位置上的元素
6. toArray()按从第一个到最后一个元素返回包含此列表中所有元素的数组

```java
package test.array;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTraversal{

    public static void main(String[] args){//创建列表list
        List<Interger> list = new ArrayList<Interger>();

        for(int i=0; i<10; i++){//增加10个元素
            list.add(i)
        }

        System.out.println("Items in the list: ");
        Systrm.out.println(list);

        System.out.println("Items in the list with odd index:");
        for (int i = 1; i < list.size(); i += 2){
            System.out.print(list.get(i)+" ")
        }
    }
}

```

### 1.1.2 HashMap

Map用于应用程序中管理映射。对应键值(key-value)

常用方法:

1. clear()删除所有映射
2. remove(Object key)删除键和关联的值
3. put(Object key, Object value)将指定值与键关联
4. get(Object key)返回键所映射的值
5. putAll(Map t)将Map t中所有映射复制到新map中

```java
package test.map;

import java.util.HashMap;
import java.util.Scanner;

public class PhoneBookByMap {

    public static void main(String[] args) {
        HashMap<String, String> phonebook = new HashMap<String, String>();
        // 创建一个HashMap对象，名称为phonebook，键值对的类型均为String

        Scanner scan = new Scanner(System.in);
        // 创建扫描器用于获取用户的输入

        String keyword = new String();
        // 创建一个名为keyword的字符串用于存放用户输入的关键词

        phonebook = initPhoneBook(phonebook);
        // 利用自写的initPhoneBook方法为电话簿装入数据，完成其初始化的步骤

        System.out.println("Please input a name that you want to search:");
        // 提示用户输入待查询的姓名

        keyword = scan.nextLine();
        // 将用户的输入信息装入字符串keyword中
        while (keyword.isEmpty()) {
            System.out.println("Please input a name!");
            keyword = scan.nextLine();
        }

        // 若用户有输入某个关键词，则按照该关键词在phonebook中查找其对应的号码
        System.out.println("The result is :");
        System.out.println(queryPhone(phonebook, keyword));
        // 这里调用了自写的queryPhone()方法
        scan.close();

    }

    private static HashMap<String, String> initPhoneBook(HashMap<String, String> phonebook) {
        // 该方法用于完成指定HashMap的初始化，为其装入一些号码数据，你也可以自定义这些数据

        phonebook.put("Steve", "13012345678");
        phonebook.put("Bob", "028-80001234");
        phonebook.put("Peter", "182222233333");
        // 使用put()方法将姓名与电话号码相关联，存放在名为phonebook的HashMap中

        return phonebook;
        // 返回修改后的phonebook
    }

    private static String queryPhone(HashMap<String, String> phonebook, String keyword) {

        String result = new String();
        // 创建存放结果的字符串result

        result = phonebook.get(keyword);
        // 使用get()方法查询keyword所对应的电话号码，并赋给result

        if (result == null)
            return "Can not find this user.";
        // 如果未找到该用户的电话号码，则将查询结果修改为“未找到该用户”

        return result;
        // 返回查询结果
    }
}
```

## 2 异常

异常都是从`Throwable`类派生出来的。异常常分成四类：

* Error:系统内部错误，无需捕获
* Exception:可以处理的异常
* RuntimeException:可以捕获也可以不捕获的异常
* 继承Exception的其它类:必须捕获的异常

## 2.1 自定义异常

自定义异常只需要让它继承Exception或其子类即可。

## 2.2 捕获异常

常使用`try`和`catch`来捕获异常。

```java
package bill;

public class CatchException {
    public static void main(String[] args) {
        try {
            // 下面定义了一个try语句块

            System.out.println("I am try block.");

            Class<?> tempClass = Class.forName("");
            // 声明一个空的Class对象用于引发“类未发现异常”
            System.out.println("Bye! Try block.");

        } catch (ClassNotFoundException e) {
            // 下面定义了一个catch语句块
            System.out.println("I am catch block.");

            e.printStackTrace();
            //printStackTrace()的意义在于在命令行打印异常信息在程序中出错的位置及原因

            System.out.println("Goodbye! Catch block.");

        } finally {
            // 下面定义了一个finally语句块
            System.out.println("I am finally block.");
        }
    }
}
```

## 3 输入输出

按照数据流方向可以分为输入流和输出流；按照处理数据的单位分为字节流和字符流；按照功能分为节点流和处理流。

`java.io`包提供了大多数输入输出接口，有一些来自`java.lang`包中的类但都继承自`java.io`中的类。

### 3.1 读写一个文件

读写文件可以使用`FileInputStream`来读取。

```java
package bill;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFileTest{
    public static void main(String[] args){
        try{
            FileInputStream file = new FileInputStream("/lujin");

            int data = 0;

            while ((data = file.read()) != -1) {//数据读取完毕打印出来

                System.out.println(data);
            }

            file.close();//关闭流对象

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {//输入输出发生错误
            e.printStackTrace();
        }
    }
}
```

`FileOutputStream`可以实现写入文件

```java
package bill;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFileTest {

    public static void main(String[] args) {
        try {

            String path = "/home/shiyanlou/Desktop/newfile.txt";

            String content = "bill";
            //声明一个字符串存放待写入的内容

            FileOutputStream file = new FileOutputStream(path);

            file.write(content.getBytes());
            //通过write()方法将数据写入到文件中
            //getBytes()方法是将字符串转化为二进制序列

            file.close();

            System.out.println("File created successfully.");

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
```

## 4 枚举和泛型

### 4.1 枚举

枚举类型可以取代以往常量的定义方式，即将常量封装在类或接口中。

将星期声明成枚举类型`enum Week { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY };`

这种声明定义的类型实际上是一个类，其中有7个实例。

由于是类，所以可以在枚举类型中添加其构造器，以及一些方法，例如：

```java
package bill;

public enum Week {

    MONDAY("MON"), TUESDAY("TUES"), WEDNESDAY("WED"), THURSDAY("THUR"),
    FRIDAY("FRI"), SATURDAY("SAT"), SUNDAY("SUN");
    //必须要先定义枚举类型，才能定义方法

    private String abbr;

    private Week(String abbr) {
        this.abbr = abbr;
    }
    //声明的一个私有构造方法，该方法只能在构造枚举常量时被调用，可以使枚举元素具有指定的缩写信息

    public String getAbbr() {
        return abbr;
    }
    //通过该方法获得枚举元素的缩写
}
```

### 4.2 泛型

泛型不仅可以减少代码的编写，还可以解决类型安全问题，不会因为将对象置于某容器中而失去其类型。

```java
public class GenericTest {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("qqyumidi");
        list.add("corn");
        list.add(100);

        for (int i = 0; i < list.size(); i++) {
            String name = (String) list.get(i); // 1
            System.out.println("name:" + name);
        }
    }
}
```

上面定义了一个List类型的集合，先向其中加入了两个字符串类型的值，随后加入一个Integer类型的值。这是完全允许的，因为此时list默认的类型为Object类型。在之后的循环中，由于忘记了之前在list中也加入了Integer类型的值或其他编码原因，很容易出现类似于//1中的错误。因为编译阶段正常，而运行时会出现“java.lang.ClassCastException”异常。因此，导致此类错误编码过程中不易发现。

泛型，即“参数化类型”。一提到参数，最熟悉的就是定义方法是有形参，然后调用此方法时传递实参。那么参数化类型怎么理解呢？顾名思义，就是将类型由原来的具体的类型参数化，类似于方法中的变量参数，此时类型也定义成参数形式（可以称之为类型形参），然后在使用/调用时传入具体的类型（类型实参）。

定义泛型类只需在类名后加上`< >`并在括号类指明类型的参数。

```java
public class GenericTest {

    public static void main(String[] args) {
        /*
        List list = new ArrayList();
        list.add("qqyumidi");
        list.add("corn");
        list.add(100);
        */

        List<String> list = new ArrayList<String>();
        list.add("qqyumidi");
        list.add("corn");
        //list.add(100);   // 1  提示编译错误

        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i); // 2
            System.out.println("name:" + name);
        }
    }
}
```

采用泛型写法后，在//1处想加入一个Integer类型的对象时会出现编译错误，通过List<String>，直接限定了list集合中只能含有String类型的元素，从而在//2处无须进行强制类型转换，因为此时，集合能够记住元素的类型信息，编译器已经能够确认它是String类型了。

## 5 Swing

Swing 是在抽象窗口工具箱（AWT）的架构上发展而来的一个用户界面库，整个可视组件库的基础构造块是 JComponent。它是所有组件的父类，为所有组件提供了绘制的基础架构。换言之，所有的Swing组件都是由它派生而来

### 5.1 JFrame

JFrame类就是一个容器，让你把其他组件添加到里面。

它包含一些方法：

* get/setTitle() 获取/设置窗体标题
* get/setState() 获取/设置窗体的最小化、最大化等状态
* is/setVisible() 获取/设置窗体的可视状态
* get/setLocation() 获取/设置窗体的大小
* add() 将组件添加到窗体中

### 5.2 JLabel

可用作文本描述和图片描述

常用方法：

* get/setText() 获取/设置标签文本
* get/setIcon() 获取/设置标签图片
