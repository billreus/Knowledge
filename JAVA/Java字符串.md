# 1. String

## 1.1. 概念

String, StringBuilder和StringBuffer本质上都是通过字符数组实现的。

StringBuilder是非线程安全的，而StringBuffer是线程安全的。

## 1.2. valueOf

把各种对象转换成String使用valueOf()函数

```java
import java.util.HashMap;

public class StringValueTest {
    
    public static void main(String[] args) {
        testValueAPIs() ;
    }

    /**
     * String 的valueOf()演示程序
     */
    private static void testValueAPIs() {
        System.out.println("-------------------------------- testValueAPIs --------------------------------");
        // 1. String    valueOf(Object obj)
        //  实际上，返回的是obj.toString();
        HashMap map = new HashMap();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
        System.out.printf("%-50s = %s\n", "String.valueOf(map)", String.valueOf(map));

        // 2.String    valueOf(boolean b)
        System.out.printf("%-50s = %s\n", "String.valueOf(true)", String.valueOf(true));

        // 3.String    valueOf(char c)
        System.out.printf("%-50s = %s\n", "String.valueOf('m')", String.valueOf('m'));

        // 4.String    valueOf(int i)
        System.out.printf("%-50s = %s\n", "String.valueOf(96)", String.valueOf(96));

        // 5.String    valueOf(long l)
        System.out.printf("%-50s = %s\n", "String.valueOf(12345L)", String.valueOf(12345L));

        // 6.String    valueOf(float f)
        System.out.printf("%-50s = %s\n", "String.valueOf(1.414f)", String.valueOf(1.414f));

        // 7.String    valueOf(double d)
        System.out.printf("%-50s = %s\n", "String.valueOf(3.14159d)", String.valueOf(3.14159d));

        // 8.String    valueOf(char[] data)
        System.out.printf("%-50s = %s\n", "String.valueOf(new char[]{'s','k','y'})", String.valueOf(new char[]{'s','k','y'}));

        // 9.String    valueOf(char[] data, int offset, int count)
        System.out.printf("%-50s = %s\n", "String.valueOf(new char[]{'s','k','y'}, 0, 2)", String.valueOf(new char[]{'s','k','y'}, 0, 2));

        System.out.println();
    }
}
```

## 1.3. index

```java
public class StringIndexTest {

    public static void main(String[] args) {
        testIndexAPIs() ;
    }

    /**
     * String 中index相关API演示
     */
    private static void testIndexAPIs() {
        System.out.println("-------------------------------- testIndexAPIs --------------------------------");

        String istr = "abcAbcABCabCaBcAbCaBCabc";
        System.out.printf("istr=%s\n", istr);

        // 1. 从前往后，找出‘a’第一次出现的位置
        System.out.printf("%-30s = %d\n", "istr.indexOf((int)'a')", istr.indexOf((int)'a'));

        // 2. 从位置5开始，从前往后，找出‘a’第一次出现的位置
        System.out.printf("%-30s = %d\n", "istr.indexOf((int)'a', 5)", istr.indexOf((int)'a', 5));

        // 3. 从后往前，找出‘a’第一次出现的位置
        System.out.printf("%-30s = %d\n", "istr.lastIndexOf((int)'a')", istr.lastIndexOf((int)'a'));

        // 4. 从位置10开始，从后往前，找出‘a’第一次出现的位置
        System.out.printf("%-30s = %d\n", "istr.lastIndexOf((int)'a', 10)", istr.lastIndexOf((int)'a', 10));


        // 5. 从前往后，找出"bc"第一次出现的位置
        System.out.printf("%-30s = %d\n", "istr.indexOf(\"bc\")", istr.indexOf("bc"));

        // 6. 从位置5开始，从前往后，找出"bc"第一次出现的位置
        System.out.printf("%-30s = %d\n", "istr.indexOf(\"bc\", 5)", istr.indexOf("bc", 5));

        // 7. 从后往前，找出"bc"第一次出现的位置
        System.out.printf("%-30s = %d\n", "istr.lastIndexOf(\"bc\")", istr.lastIndexOf("bc"));

        // 8. 从位置4开始，从后往前，找出"bc"第一次出现的位置
        System.out.printf("%-30s = %d\n", "istr.lastIndexOf(\"bc\", 4)", istr.lastIndexOf("bc", 4));

        System.out.println();
    }
}

-------------- testIndexAPIs --------------
istr=abcAbcABCabCaBcAbCaBCabc
istr.indexOf((int)'a')         = 0
istr.indexOf((int)'a', 5)      = 9
istr.lastIndexOf((int)'a')     = 21
istr.lastIndexOf((int)'a', 10) = 9
istr.indexOf("bc")             = 1
istr.indexOf("bc", 5)          = 22
istr.lastIndexOf("bc")         = 22
istr.lastIndexOf("bc", 4)      = 4
```

## 1.4. String, StringBuffer, StringBuilder区别

### 运行速度

StringBuilder > StringBuffer > String

* String为字符串常量，而StringBuilder和StringBuffer均为字符串变量，即String对象一旦创建之后该对象是不可更改的，但后两者的对象是变量，是可以更改的。

### 线程安全

StringBuilder是线程不安全的，而StringBuffer是线程安全的

### 使用场景

String：适用于少量的字符串操作的情况

StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况

StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况