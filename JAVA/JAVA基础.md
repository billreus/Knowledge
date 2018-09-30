# JAVA

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