<!-- TOC -->

- [JAVA API](#java-api)
    - [1 语言包java.lang](#1-语言包javalang)
        - [1.1 数据类型包装类](#11-数据类型包装类)
        - [1.2 字符处理类](#12-字符处理类)
        - [1.3 Math类](#13-math类)
        - [1.4 Object类](#14-object类)
            - [1.4.1 equals方法](#141-equals方法)
            - [1.4.2 hashCode方法](#142-hashcode方法)
        - [1.5 异常类](#15-异常类)
            - [1.5.1 自定义异常](#151-自定义异常)
            - [1.5.2 捕获异常](#152-捕获异常)
    - [2 实用包java.util](#2-实用包javautil)
        - [2.1 Calendar类](#21-calendar类)
        - [2.2 Random类](#22-random类)
        - [2.3 数据结构类(容器)](#23-数据结构类容器)
            - [2.3.1 Collection接口](#231-collection接口)
            - [2.3.2 Map接口](#232-map接口)
    - [3 输入输出java.io](#3-输入输出javaio)
        - [3.1 基类InputStream和OutputStream](#31-基类inputstream和outputstream)
        - [3.2 文件流](#32-文件流)
            - [3.2.1 读写一个文件](#321-读写一个文件)
        - [3.3 缓冲流](#33-缓冲流)
        - [3.4 数据流](#34-数据流)
        - [3.5 字符流](#35-字符流)
    - [4 重要思想](#4-重要思想)
        - [4.1 枚举](#41-枚举)
        - [4.2 泛型](#42-泛型)
        - [4.3 包装（装箱和拆箱）](#43-包装装箱和拆箱)
        - [4.4 String](#44-string)
            - [4.4.1 Stirng,StringBuffer and StringBuilder](#441-stirngstringbuffer-and-stringbuilder)
            - [4.4.2 String Pool](#442-string-pool)
        - [4.5 面向对象](#45-面向对象)
            - [4.5.1 继承](#451-继承)
            - [4.5.2 抽象类与接口](#452-抽象类与接口)
            - [4.5.3 this和super](#453-this和super)
            - [4.5.4 final与static](#454-final与static)
                - [final声明数据](#final声明数据)
                - [static声明变量](#static声明变量)
                - [static声明静态方法](#static声明静态方法)
                - [static声明静态语句块](#static声明静态语句块)
    - [5 窗口工具javax.swing](#5-窗口工具javaxswing)
        - [5.1 JFrame](#51-jframe)
            - [5.1.1 框架](#511-框架)
            - [5.1.2 2D图形](#512-2d图形)
        - [5.2 JLabel](#52-jlabel)

<!-- /TOC -->

# JAVA API

核心API主要有：语言包java.lang，实用包java.util，输入输出java.io，抽象窗口工具包java.awt，轻量级窗口工具javax.swing，网络java.net

## 1 语言包java.lang

语言包主要包括：Object类，数据类型包装类，字符处理，线程类，错误异常值处理类，数学类，过程类，系统和运行类，操作类

### 1.1 数据类型包装类

java本身的基本数据类型不是面向对象的，如果想处理基本类型数据可以使用数据包装类。

例如Integer类，构造方法可以使用`Inerger(int value)`或者`Interger(String s)`

常用一些方法例如：

1. byteValue() 以byte类型返回该Integer
2. CompareTo(Integer anotherInteger) 比较数值是否相等。
3. intValue() 以int型返回此Integer对象 /short/long/float/double
4. toString() 返回一个表示该Integer值的String对象

### 1.2 字符处理类

常用为String类，用来定义一个字符串。

常用方法：

1. length() 返回字符串长度
2. equals() 字符串比较
3. concat() 字符串连接
4. charAt(a) 按照索引值a提取字符串中的字符

### 1.3 Math类

主要是一些数学的计算方法。

### 1.4 Object类

Object类是所有类的父类。存放最基本的方法。

#### 1.4.1 equals方法

Object类中equals方法用于检测一个对象是否等与另一个对象。如果两个对象具有相同引用，它们一定是相等的。

#### 1.4.2 hashCode方法

用于返回每个对象的存储地址，默认是一个散列码。

### 1.5 异常类

异常都是从`Throwable`类派生出来的。异常常分成四类：

* Error:系统内部错误，无需捕获
* Exception:可以处理的异常

Exception 分为两种：

* 受检异常 ：需要用 try...catch... 语句捕获并进行处理，并且可以从异常中恢复；
* 非受检异常 ：是程序运行时错误，例如除 0 会引发 Arithmetic Exception，此时程序崩溃并且无法恢复。

#### 1.5.1 自定义异常

自定义异常只需要让它继承Exception或其子类即可。

#### 1.5.2 捕获异常

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

## 2 实用包java.util

主要包装了一些实用方法和数据结构。如日历类Calendar，随机类Random和堆栈Stack、向量Vector、位集合Bitset以及哈希表Hashtable等数据结构

### 2.1 Calendar类

用于表示日期和时间

方法：

1. GregorianCalendar() 指定时区
2. GregorianCalendar(TimeZone zone) 
3. GregorianCalendar(Locale aLocale)
4. GregorianCalendar(TimeZone zone, Locale aLocale)

### 2.2 Random类

可以产生各种类型的随机数，与math类中不同的是，math中的只产生double类型随机数。

构造方法：

1. Random() 产生随机数，用时间作为seed
2. Random(long seed) 单个long种子创建一个新的随机生成器

### 2.3 数据结构类(容器)

容器主要包括 Collection 和 Map 两种，Collection 存储着对象的集合，而 Map 存储着键值对（两个对象）的映射表。

#### 2.3.1 Collection接口

因为很多功能类似，Collection接口是一个java集合框架的根接口。也是List、Set和Queue接口的父接口。

List是元素内有序集合，元素可以重复。Set是元素无序集合，元素不可重复。

List 是一个接口，不能实例化，需要一个具体类来实现实例化。

List 接口实现的类有：

* ArrayList：基于动态数组实现
* Vector：与ArrayList类似，但线程安全
* LinkedList：双向链表，只能顺序访问，但可以快速在链表中插入删除元素。可以当作栈，队列，双向队列使用。

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

由于Set是元素无序且不可重合，如何判断重复，需使用Object.equals方法。但元素过多会计算量大，所以使用哈希表原理，hashCode方法返回对象的物理地址。如果位置上没有元素，直接存放该位置，如果有元素就调用equals来与新元素进行比较。

Set接口也是 Collection 接口的子接口，它有一个很重要也是很常用的实现类——HashSet，Set 是元素无序并且不包含重复元素的 collection（List 可以重复），被称为集。

Set常用接口：

* TreeSet：基于红黑树实现，支持有序性操作，例如根据一个范围查找元素的操作。但是查找效率不如 HashSet，HashSet 查找的时间复杂度为 O(1)，TreeSet 则为 O(logN)。
* HashSet：基于哈希表实现，支持快速查找，但不支持有序性操作。并且失去了元素的插入顺序信息，也就是说使用 Iterator 遍历 HashSet 得到的结果是不确定的。
* LinkedHashSet：具有 HashSet 的查找效率，且内部使用双向链表维护元素的插入顺序。

Queue常用接口：

* LinkedList：可以用它来实现双向队列。

* PriorityQueue：基于堆结构实现，可以用它来实现优先队列。

#### 2.3.2 Map接口

Map用于应用程序中管理映射。对应键值(key-value)

Map常用接口：

* TreeMap：基于红黑树实现。
* HashMap：基于哈希表实现。
* HashTable：和 HashMap 类似，但它是线程安全的，这意味着同一时刻多个线程可以同时写入 HashTable 并且不会导致数据不一致。它是遗留类，不应该去使用它。现在可以使用 ConcurrentHashMap 来支持线程安全，并且 ConcurrentHashMap 的效率会更高，因为 ConcurrentHashMap 引入了分段锁。
* LinkedHashMap：使用双向链表来维护元素的顺序，顺序为插入顺序或者最近最少使用（LRU）顺序。

HashMap 是基于哈希表的 Map 接口的一个重要实现类。HashMap 中的 Entry 对象是无序排列的，Key 值和 value 值都可以为 null，但是一个 HashMap 只能有一个 key 值为 null 的映射。

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

## 3 输入输出java.io

按照数据流方向可以分为输入流和输出流；按照处理数据的单位分为字节流和字符流；按照功能分为节点流和处理流。

`java.io`包提供了大多数输入输出接口，有一些来自`java.lang`包中的类但都继承自`java.io`中的类。

### 3.1 基类InputStream和OutputStream

字节流主要操作byte类型数据，以byte数组为准，java 中每一种字节流的基本功能依赖于基本类 InputStream 和 Outputstream，他们是抽象类，不能直接使用。

### 3.2 文件流

在 I/O 处理中，最常见的就是对文件的操作。java.io 包中所提供的文件操作类包括：

1. 用于读写本地文件系统中的文件：FileInputStream 和 FileOutputStream
2. 描述本地文件系统中的文件或目录：File、FileDescriptor 和 FilenameFilter
3. 提供对本地文件系统中文件的随机访问支持：RandomAccessFile

#### 3.2.1 读写一个文件

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

### 3.3 缓冲流

类 BufferedInputStream 和 BufferedOutputStream 实现了带缓冲的过滤流，它提供了缓冲机制，把任意的 I/O 流“捆绑”到缓冲流上，可以提高 I/O 流的读取效率。

### 3.4 数据流

接口 DataInput 和 DataOutput，设计了一种较为高级的数据输入输出方式：除了可处理字节和字节数组外，还可以处理 int、float、boolean等基本数据类型，这些数据在文件中的表示方式和它们在内存中的一样，无须转换，如 read(), readInt(), readByte()...; write(), writeChar(), writeBoolean()...此外，还可以用 readLine()方法读取一行信息。

### 3.5 字符流

java.io包中专门用于字符流处理的类，是以 Reader 和 Writer 为基础派生的一系列类。

字符流以字符为单位，根据码表映射字符，一次可能读多个字节，只能处理字符类型的数据。

## 4 重要思想

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

### 4.3 包装（装箱和拆箱）

装箱就是自动将基本数据类型转换成包装器类型；拆箱就是自动将包装类型转换为基本数据类型；

```java
Integer i = new Integer(10); //以前要生成数值10的Integer对象

Integer i = 10; //装箱
int n = i; //拆箱
```

其中装箱时调用的是Integer的valueOf(int)方法，拆箱用的是Integer的intValue方法。

总结：装箱过程是通过调用包装器的valueOf方法实现的，而拆箱过程是通过调用包装器的 xxxValue方法实现的。（xxx代表对应的基本数据类型）。

对于new Integer(10)和Integer.value(10)区别在于：

* new Integer(10) 每次都会新建一个对象；
* Integer.valueOf(10) 会使用缓存池中的对象，多次调用会取得同一个对象的引用。

```java
Integer x = new Integer(10);
Integer y = new Integer(10);
System.out.println(x == y);    // false
Integer z = Integer.valueOf(10);
Integer k = Integer.valueOf(10);
System.out.println(z == k);   // true
```

```java
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;

        System.out.println(i1==i2); // true
        System.out.println(i3==i4); // false
```

这是由于缓存池的设置，由于valueOf() 方法的实现比较简单，就是先判断值是否在缓存池中，如果在的话就直接返回缓存池的内容。如果不是会new一个新的对象

```java
public static Integer valueOf(int i) {
    if (i >= IntegerCache.low && i <= IntegerCache.high)
        return IntegerCache.cache[i + (-IntegerCache.low)];
    return new Integer(i);
}
```

由下可知创建Integer对象时数值的范围在[-128,127],所以200会显示false。

基本类型对应的缓冲池如下：

* boolean values true and false
* all byte values
* short values between -128 and 127
* int values between -128 and 127
* char in the range \u0000 to \u007F

###　4.4 String

String被声明成final，因此它不可能被继承。

内部使用char数组存储数据，也被声明成final，同时String内部没有改变value数组的方法，因此可以保证String不可改变。

```java
public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence {
    /** The value is used for character storage. */
    private final char value[];
```

不可变的好处：

1. 可以缓存hush值；因为String的hash值经常被使用，例如String用做HashMap的Key。不可变使得hash值也不可变，只需进行一次计算。
2. String Pool的需要; 如果一个String对象已经被创建，那么就会从String Pool中取引用。只有String不可变才可使用。
3. 安全性；
4. 线程安全；

#### 4.4.1 Stirng,StringBuffer and StringBuilder

1. 可变性

* String不可变
* StringBuffer 和 StringBuilder 可变

2. 线程安全

* String 不可变，因此是线程安全的
* StringBuilder 不是线程安全的
* StringBuffer 是线程安全的，内部使用 synchronized 进行同步

#### 4.4.2 String Pool

字符串常量池(String Pool)保存着所有字符串字面量(literal strings),可以使用String的intern()方法将运行过程中的字符串添加到String Pool中。

当一个字符串调用 intern() 方法时，如果 String Pool 中已经存在一个字符串和该字符串值相等（使用 equals() 方法进行确定），那么就会返回 String Pool 中字符串的引用；否则，就会在 String Pool 中添加一个新的字符串，并返回这个新字符串的引用。

```java
String s1 = new String("aaa");
String s2 = new String("aaa");
System.out.println(s1 == s2);           // false
String s3 = s1.intern();
String s4 = s1.intern();
System.out.println(s3 == s4);           // true

// 如果是采用 "bbb" 这种字面量的形式创建字符串，会自动地将字符串放入 String Pool 中。
String s5 = "bbb";
String s6 = "bbb";
System.out.println(s5 == s6);  // true
```

### 4.5 面向对象

#### 4.5.1 继承

Java中有三种访问权限:private、protected、public.

protected 用于修饰成员，表示在继承体系中成员对于子类可见，但是这个访问修饰符对于类没有意义。

#### 4.5.2 抽象类与接口

抽象类与抽象方法都使用abstract关键字进行声明，抽象类包含抽象方法。抽象类就是为了继承而存在。

抽象类和普通类区别：

1. 抽象方法必须为public或者protected（因为如果为private，则不能被子类继承，子类便无法实现该方法），缺省情况下默认为public。
2. 抽象类不能用来创建对象；
3. 如果一个类继承于一个抽象类，则子类必须实现父类的抽象方法。如果子类没有实现父类的抽象方法，则必须将子类也定义为为abstract类。

接口的成员（字段 + 方法）默认都是 public 的，并且不允许定义为 private 或者 protected。

使用选择:

1. 使用接口：

* 需要让不相关的类都实现一个方法，例如不相关的类都可以实现 Compareable 接口中的 compareTo() 方法；
* 需要使用多重继承。

2. 使用抽象类：

* 需要在几个相关的类中共享代码。
* 需要能控制继承来的成员的访问权限，而不是都为 public。
* 需要继承非静态和非常量字段。
* 在很多情况下，接口优先于抽象类。因为接口没有抽象类严格的类层次结构要求，可以灵活地为一个类添加行为。并且从 Java 8 开始，接口也可以有默认的方法实现，使得修改接口的成本也变的很低。

#### 4.5.3 this和super

this是自身的一个对象，代表对象本身。一般用于：普通的直接引用；形参与成员名重名；引用构造函数

super可以理解为指向超(父)类对象的一个指针,且是离自己最近的一个父类。一般用于：直接引用父类的成员；子类中成员与父类重名；引用构造函数。

#### 4.5.4 final与static

##### final声明数据

1. 基本类型，final使数值不变
2. 引用类型，final使引用不变，即不能引用其它对象，但是被引用的对象本身可以修改

```java
final int x = 1;
// x = 2;  // cannot assign value to final variable 'x'
final A y = new A();
y.a = 1;
```

final声明方法：

声明方法不能被子类重写。

final声明类：

声明类不允许被继承。

##### static声明变量

1. 静态变量：这个变量属于类，类的所有实例都共享静态变量，可以通过类名访问
2. 实例变量：每创建一个实例就会产生一个实例变量

```java
public class A {

    private int x;         // 实例变量
    private static int y;  // 静态变量

    public static void main(String[] args) {
        // int x = A.x;  // Non-static field 'x' cannot be referenced from a static context
        A a = new A();
        int x = a.x;
        int y = A.y;
    }
}
```

##### static声明静态方法

静态方法在类加载的时候就存在了，它不依赖于任何实例。所以静态方法必须有实现，也就是说它不能是抽象方法。且只能访问所属类的静态字段和静态方法，方法中不能有 this 和 super 关键字。

```java
public class A {

    private static int x;
    private int y;

    public static void func1(){
        int a = x;
        // int b = y;  // Non-static field 'y' cannot be referenced from a static context
        // int b = this.y;     // 'A.this' cannot be referenced from a static context
    }
}
```

##### static声明静态语句块

静态语句块在类初始化时运行一次

```java
public class A {
    static {
        System.out.println("123");
    }

    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
    }
}

>>> 123
```

## 5 窗口工具javax.swing

Swing 是在抽象窗口工具箱（AWT）的架构上发展而来的一个用户界面库，整个可视组件库的基础构造块是 JComponent。它是所有组件的父类，为所有组件提供了绘制的基础架构。换言之，所有的Swing组件都是由它派生而来。

每个Swing组件必须由事件分派线程进行配置，线程将鼠标点击和按键控制转移到用户接口组件。

```java
EventQueue.invokeLater(new Runnable()
{
    public void run()
    {
        statements
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //用户关闭框架的响应动作，用来退出进程。
        frame.setVisible(true);  //显示框架
    }
});
```

### 5.1 JFrame

JFrame类就是一个容器，让你把其他组件添加到里面。

它包含一些方法：

* get/setTitle() 获取/设置窗体标题
* get/setState() 获取/设置窗体的最小化、最大化等状态
* is/setVisible() 获取/设置窗体的可视状态
* get/setLocation()和setBounds 获取/设置窗体的大小位置
* setIconImage() 用于告诉窗口系统在标题栏、任务切换窗口等位置显示哪个图标
* setResizable() 利用一个布尔值确定框架大小是否允许用户改变
* add() 将组件添加到窗体中

#### 5.1.1 框架

获取屏幕大小需要调用Toolkit类的静态方法getDefaultToolkit得到一个Tookit对象。然后调用getScreenSize方法，返回屏幕大小。

```java
Toolkit kit = Toolkit.getDefaultToolkit();
Dimension screenSize = kit.getScreenSize();
int screenHeight = screenSize.height;
int screenWidth = screenSize.width;
```

对框架大小设定为上面取值的50%，然后告知系统定位框架：

```java
setSize(screenWidth / 2, screenHeight / 2);
setLocationByPlatform(true);
```

#### 5.1.2 2D图形

绘制2D需要获得一个Graphics2D类对象。这个类是Graphics类的子类。

使用paintComponent方法就会自动获得Graphics2D类对象，只需转换。

```java
public void paintComponment(Graphics g)
{
    Graphics2D g2 = (Graphics2D) g;
}
```

### 5.2 JLabel

可用作文本描述和图片描述

常用方法：

* get/setText() 获取/设置标签文本
* get/setIcon() 获取/设置标签图片
