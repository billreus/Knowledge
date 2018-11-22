<!-- TOC -->

- [Java集合](#java%E9%9B%86%E5%90%88)
- [1. List](#1-list)
    - [1.1 Collection](#11-collection)
        - [1.1.1 List](#111-list)
        - [1.1.2 Set](#112-set)
        - [1.1.3 Iterator](#113-iterator)
            - [1.1.3.1 ListIterator](#1131-listiterator)
    - [1.2 ArrayList](#12-arraylist)
        - [1.2.1 ArrayList数据结构](#121-arraylist%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84)
        - [1.2.2 ArrayList源码](#122-arraylist%E6%BA%90%E7%A0%81)
            - [1.2.2.1 继承关系](#1221-%E7%BB%A7%E6%89%BF%E5%85%B3%E7%B3%BB)
            - [1.2.2.2 属性](#1222-%E5%B1%9E%E6%80%A7)
            - [1.2.2.3 构造函数](#1223-%E6%9E%84%E9%80%A0%E5%87%BD%E6%95%B0)
            - [1.2.2.4 核心函数](#1224-%E6%A0%B8%E5%BF%83%E5%87%BD%E6%95%B0)
        - [1.2.3 ArrayList遍历方式](#123-arraylist%E9%81%8D%E5%8E%86%E6%96%B9%E5%BC%8F)
        - [1.2.4 toArray()异常](#124-toarray%E5%BC%82%E5%B8%B8)
        - [1.2.5 常用示例](#125-%E5%B8%B8%E7%94%A8%E7%A4%BA%E4%BE%8B)
        - [1.2.6 fail-fast总结](#126-fail-fast%E6%80%BB%E7%BB%93)
    - [1.3 LinkedList](#13-linkedlist)
        - [1.3.1 构造函数](#131-%E6%9E%84%E9%80%A0%E5%87%BD%E6%95%B0)
        - [1.3.2 API](#132-api)
        - [1.3.3 LinkedList数据结构](#133-linkedlist%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84)
        - [1.3.4 LinkedList源码](#134-linkedlist%E6%BA%90%E7%A0%81)
        - [1.3.5 LinkedList遍历](#135-linkedlist%E9%81%8D%E5%8E%86)
        - [1.3.6 LinkedList与ArrayList区别](#136-linkedlist%E4%B8%8Earraylist%E5%8C%BA%E5%88%AB)
    - [1.4. Vector](#14-vector)
        - [1.4.1. 构造函数](#141-%E6%9E%84%E9%80%A0%E5%87%BD%E6%95%B0)
        - [1.4.2. API](#142-api)
        - [1.4.3. 数据结构](#143-%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84)
        - [1.4.4. 源码](#144-%E6%BA%90%E7%A0%81)
        - [1.4.5. 遍历方式](#145-%E9%81%8D%E5%8E%86%E6%96%B9%E5%BC%8F)
        - [1.4.6. ArrayList和vector的区别](#146-arraylist%E5%92%8Cvector%E7%9A%84%E5%8C%BA%E5%88%AB)
    - [1.5. Stack](#15-stack)
        - [1.5.1. 构造函数和API](#151-%E6%9E%84%E9%80%A0%E5%87%BD%E6%95%B0%E5%92%8Capi)
        - [1.5.2. 源码](#152-%E6%BA%90%E7%A0%81)
        - [1.5.3. 示例](#153-%E7%A4%BA%E4%BE%8B)
    - [1.6. List总结](#16-list%E6%80%BB%E7%BB%93)
        - [1.6.1 使用场景](#161-%E4%BD%BF%E7%94%A8%E5%9C%BA%E6%99%AF)
        - [1.6.2. LinkedList和ArrayList性能分析](#162-linkedlist%E5%92%8Carraylist%E6%80%A7%E8%83%BD%E5%88%86%E6%9E%90)
            - [插入，删除](#%E6%8F%92%E5%85%A5%E5%88%A0%E9%99%A4)
            - [随机访问](#%E9%9A%8F%E6%9C%BA%E8%AE%BF%E9%97%AE)
        - [1.6.3 Vector和ArrayList性能分析](#163-vector%E5%92%8Carraylist%E6%80%A7%E8%83%BD%E5%88%86%E6%9E%90)
- [2. Map](#2-map)
    - [2.1. Map定义](#21-map%E5%AE%9A%E4%B9%89)
        - [2.1.1. Map.Entry](#211-mapentry)
        - [2.1.2. AbstractMap](#212-abstractmap)
        - [2.1.3. SortedMap](#213-sortedmap)
        - [2.1.4. NavigableMap](#214-navigablemap)
    - [2.2. HashMap](#22-hashmap)
        - [2.2.1. 构造函数和API](#221-%E6%9E%84%E9%80%A0%E5%87%BD%E6%95%B0%E5%92%8Capi)
        - [2.2.2. 数据结构](#222-%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84)
        - [2.2.3. 源码](#223-%E6%BA%90%E7%A0%81)
        - [2.2.4. 存储方式](#224-%E5%AD%98%E5%82%A8%E6%96%B9%E5%BC%8F)
        - [2.2.5. 构造方法](#225-%E6%9E%84%E9%80%A0%E6%96%B9%E6%B3%95)
        - [2.5.6. 常用接口](#256-%E5%B8%B8%E7%94%A8%E6%8E%A5%E5%8F%A3)
        - [2.5.7. 遍历](#257-%E9%81%8D%E5%8E%86)
    - [2.3.](#23)

<!-- /TOC -->


# Java集合

Java集合包含了常用的数据结构：集合、链表、队列、栈、数组、映射等。Java集合工具包位置是java.util.*

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/java.util.jpg)

Java集合主要可以分为四个部分：List列表、Set集合、Map映射、工具类(Iterator迭代器、Enumeration枚举类、Arrays和Collections)。

主要实现的接口是Collection和Map。

# 1. List

## 1.1 Collection

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/Collection.jpg)

Collection是一个接口，它主要有两个分支：List和Set。

List和Set都是接口，它们继承于Collection。List是有序的队列，List中可以有重复的元素；而Set是数学概念中的集合，Set中没有重复元素。

Collection中有一个iterator()函数，它的作用是返回一个Iterator接口。通常，我们通过Iterator迭代器来遍历集合。ListIterator是List接口所特有的，在List接口中，通过ListIterator()返回一个ListIterator对象。

Collection定义如下：

```java
public interface Collection<E> extends Iterable<E>{}
```

Collection包含了集合的基本操作：添加、删除、清空、遍历(读取)、是否为空、获取大小、是否保护某元素等等。

```java
// Collection的API
abstract boolean         add(E object)
abstract boolean         addAll(Collection<? extends E> collection)
abstract void            clear()
abstract boolean         contains(Object object)
abstract boolean         containsAll(Collection<?> collection)
abstract boolean         equals(Object object)
abstract int             hashCode()
abstract boolean         isEmpty()
abstract Iterator<E>     iterator()
abstract boolean         remove(Object object)
abstract boolean         removeAll(Collection<?> collection)
abstract boolean         retainAll(Collection<?> collection)
abstract int             size()
abstract <T> T[]         toArray(T[] array)
abstract Object[]        toArray()
```

### 1.1.1 List

List定义如下：

```java
public interface List<E> extends Collection<E> {}
```

List是一个继承于Collection的接口，即List是集合中的一种。List是有序的队列，List中的每一个元素都有一个索引；第一个元素的索引值是0，往后的元素的索引值依次+1。

关于API方面。既然List是继承于Collection接口，它自然就包含了Collection中的全部函数接口；由于List是有序队列，它也额外的有自己的API接口。主要有“添加、删除、获取、修改指定位置的元素”、“获取List中的子队列”等。

```java
// Collection的API
abstract boolean         add(E object)
abstract boolean         addAll(Collection<? extends E> collection)
abstract void            clear()
abstract boolean         contains(Object object)
abstract boolean         containsAll(Collection<?> collection)
abstract boolean         equals(Object object)
abstract int             hashCode()
abstract boolean         isEmpty()
abstract Iterator<E>     iterator()
abstract boolean         remove(Object object)
abstract boolean         removeAll(Collection<?> collection)
abstract boolean         retainAll(Collection<?> collection)
abstract int             size()
abstract <T> T[]         toArray(T[] array)
abstract Object[]        toArray()
// 相比与Collection，List新增的API：
abstract void                add(int location, E object)
abstract boolean             addAll(int location, Collection<? extends E> collection)
abstract E                   get(int location)
abstract int                 indexOf(Object object)
abstract int                 lastIndexOf(Object object)
abstract ListIterator<E>     listIterator(int location)
abstract ListIterator<E>     listIterator()
abstract E                   remove(int location)
abstract E                   set(int location, E object)
abstract List<E>             subList(int start, int end)
```

### 1.1.2 Set

Set定义如下:

```java
public interface Set<E> extends Collection<E> {}
```

Set是一个继承于Collection的接口，即Set也是集合中的一种。Set是没有重复元素的集合。

关于API方面。Set的API和Collection完全一样。

```java
// Set的API
abstract boolean         add(E object)
abstract boolean         addAll(Collection<? extends E> collection)
abstract void             clear()
abstract boolean         contains(Object object)
abstract boolean         containsAll(Collection<?> collection)
abstract boolean         equals(Object object)
abstract int             hashCode()
abstract boolean         isEmpty()
abstract Iterator<E>     iterator()
abstract boolean         remove(Object object)
abstract boolean         removeAll(Collection<?> collection)
abstract boolean         retainAll(Collection<?> collection)
abstract int             size()
abstract <T> T[]         toArray(T[] array)
abstract Object[]         toArray()
```

### 1.1.3 Iterator

Iterator的定义如下:

```java
public interface Iterator<E> {}
```

Iterator是一个接口，它是集合的迭代器。集合可以通过Iterator去遍历集合中的元素。Iterator提供的API接口，包括：是否存在下一个元素、获取下一个元素、删除当前元素。

* 注意：Iterator遍历Collection时，是fail-fast机制的。即，当某一个线程A通过iterator去遍历某集合的过程中，若该集合的内容被其他线程所改变了；那么线程A访问集合时，就会抛出ConcurrentModificationException异常，产生fail-fast事件。

```java
// Iterator的API
abstract boolean hasNext()
abstract E next()
abstract void remove()
```

#### 1.1.3.1 ListIterator

ListIterator定义如下：

```java
public interface ListIterator<E> extends Iterator<E> {}
```

ListIterator是一个继承于Iterator的接口，它是队列迭代器。专门用于便利List，能提供向前/向后遍历。相比于Iterator，它新增了添加、是否存在上一个元素、获取上一个元素等等API接口。

```java
// ListIterator的API
// 继承于Iterator的接口
abstract boolean hasNext()
abstract E next()
abstract void remove()
// 新增API接口
abstract void add(E object)
abstract boolean hasPrevious()
abstract int nextIndex()
abstract E previous()
abstract int previousIndex()
abstract void set(E object)
```

## 1.2 ArrayList

ArrayList 是一个数组队列，相当于动态数组。与Java中的数组相比，它的容量能动态增长。它继承于AbstractList，实现了List, RandomAccess, Cloneable, java.io.Serializable这些接口。

ArrayList 继承了AbstractList，实现了List。它是一个数组队列，提供了相关的添加、删除、修改、遍历等功能。

ArrayList 实现了RandmoAccess接口，即提供了随机访问功能。RandmoAccess是java中用来被List实现，为List提供快速访问功能的。在ArrayList中，我们即可以通过元素的序号快速获取元素对象；这就是快速随机访问。

ArrayList 实现了Cloneable接口，即覆盖了函数clone()，能被克隆。

ArrayList 实现java.io.Serializable接口，这意味着ArrayList支持序列化，能通过序列化去传输。

和Vector不同，ArrayList中的操作不是线程安全的！所以，建议在单线程中才使用ArrayList，而在多线程中可以选择Vector或者CopyOnWriteArrayList。

ArrayList构造函数：

```java
// 默认构造函数
ArrayList()

// capacity是ArrayList的默认容量大小。当由于增加数据导致容量不足时，容量会添加上一次容量大小的一半。
ArrayList(int capacity)

// 创建一个包含collection的ArrayList
ArrayList(Collection<? extends E> collection)
```

API为：

```java
// Collection中定义的API
boolean             add(E object)
boolean             addAll(Collection<? extends E> collection)
void                clear()
boolean             contains(Object object)
boolean             containsAll(Collection<?> collection)
boolean             equals(Object object)
int                 hashCode()
boolean             isEmpty()
Iterator<E>         iterator()
boolean             remove(Object object)
boolean             removeAll(Collection<?> collection)
boolean             retainAll(Collection<?> collection)
int                 size()
<T> T[]             toArray(T[] array)
Object[]            toArray()
// AbstractCollection中定义的API
void                add(int location, E object)
boolean             addAll(int location, Collection<? extends E> collection)
E                   get(int location)
int                 indexOf(Object object)
int                 lastIndexOf(Object object)
ListIterator<E>     listIterator(int location)
ListIterator<E>     listIterator()
E                   remove(int location)
E                   set(int location, E object)
List<E>             subList(int start, int end)
// ArrayList新增的API
Object               clone()
void                 ensureCapacity(int minimumCapacity)
void                 trimToSize()
void                 removeRange(int fromIndex, int toIndex)
```

### 1.2.1 ArrayList数据结构

ArrayList与Collection关系如下图：

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/ArrayList1.jpg)

ArrayList包含了两个重要的对象：elementData 和 size。

1. elementData 是"Object[]类型的数组"，它保存了添加到ArrayList中的元素。实际上，elementData是个动态数组，我们能通过构造函数 ArrayList(int initialCapacity)来执行它的初始容量为initialCapacity；如果通过不含参数的构造函数ArrayList()来创建ArrayList，则elementData的容量默认是10。elementData数组的大小会根据ArrayList容量的增长而动态的增长，具体的增长方式，请参考源码分析中的ensureCapacity()函数。

2. size 则是动态数组的实际大小。

### 1.2.2 ArrayList源码

#### 1.2.2.1 继承关系

```java
public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable
```

ArrayList继承AbstractList抽象父类，实现了List接口（规定了List的操作规范）、RandomAccess（可随机访问）、Cloneable（可拷贝）、Serializable（可序列化）。

#### 1.2.2.2 属性

```java
public class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable
{
    // 版本号
    private static final long serialVersionUID = 8683452581122892189L;
    // 缺省容量
    private static final int DEFAULT_CAPACITY = 10;
    // 空对象数组
    private static final Object[] EMPTY_ELEMENTDATA = {};
    // 缺省空对象数组
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    // 元素数组
    transient Object[] elementData;
    // 实际元素大小，默认为0
    private int size;
    // 最大数组容量
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
}
```

类的属性中核心的属性为元素数组elementData，类型为Object[]，用于存放实际元素，并且被标记为transient，意味着在序列化的时候，此字段是不会被序列化的。

#### 1.2.2.3 构造函数

ArrayList(int)型构造函数

```java
    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) { // 初始容量大于0
            this.elementData = new Object[initialCapacity]; // 初始化元素数组
        } else if (initialCapacity == 0) { // 初始容量为0
            this.elementData = EMPTY_ELEMENTDATA; // 为空对象数组
        } else { // 初始容量小于0，抛出异常
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);
        }
    }
```

* 指定elementData数组的大小，不允许初始化大小小于0，否则抛出异常。

ArrayList()类型构造函数

```java
    public ArrayList() {
        // 无参构造函数，设置元素数组为空 
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }
```

* 未指定初始化大小时，给elementData赋值为空集合

ArrayList(Collection<? extends E>)型构造函数

```java
    public ArrayList(Collection<? extends E> c) { // 集合参数构造函数
        elementData = c.toArray(); // 转化为数组
        if ((size = elementData.length) != 0) { // 参数为非空集合
            if (elementData.getClass() != Object[].class) // 是否成功转化为Object类型数组
                elementData = Arrays.copyOf(elementData, size, Object[].class); // 不为Object数组的话就进行复制
        } else { // 集合大小为空，则设置元素数组为空
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }
```

#### 1.2.2.4 核心函数

add函数：

```java
    public boolean add(E e) { // 添加元素
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = e;
        return true;
    }
```

其中ensureCapacityInternal函数可以理解为确保elementData数组有合适的大小。ensureCapacityInternal的具体函数如下：

```java
private void ensureCapacityInternal(int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) { // 判断元素数组是否为空数组
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity); // 取较大值,默认值为10
        }

        ensureExplicitCapacity(minCapacity);
    }
```

ensureExplicitCapacity函数也是为了确保elemenData数组有合适的大小。ensureExplicitCapacity的具体函数如下:

```java
private void ensureExplicitCapacity(int minCapacity) {
        // 结构性修改加1
        modCount++;
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
```

grow函数会对数组进行扩容，ensureCapacityInternal、ensureExplicitCapacity都只是过程，最后完成实际扩容操作还是得看grow函数，grow函数的具体函数如下:

```java
    private void grow(int minCapacity) {
        int oldCapacity = elementData.length; // 旧容量
        int newCapacity = oldCapacity + (oldCapacity >> 1); // 新容量为旧容量的1.5倍
        if (newCapacity - minCapacity < 0) // 新容量小于参数指定容量，修改新容量
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0) // 新容量大于最大容量
            newCapacity = hugeCapacity(minCapacity); // 指定新容量
        // 拷贝扩容
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
```

* 正常情况下会扩容1.5倍，特殊情况下（新扩展数组大小已经达到了最大值）则只取最大值。

set函数：

```java
    public E set(int index, E element) {
        // 检验索引是否合法
        rangeCheck(index);
        // 旧值
        E oldValue = elementData(index);
        // 赋新值
        elementData[index] = element;
        // 返回旧值
        return oldValue;
    }
```

* 设定指定下标索引的元素值。

indexOf函数：

```java
// 从首开始查找数组里面是否存在指定元素
    public int indexOf(Object o) {
        if (o == null) { // 查找的元素为空
            for (int i = 0; i < size; i++) // 遍历数组，找到第一个为空的元素，返回下标
                if (elementData[i]==null)
                    return i;
        } else { // 查找的元素不为空
            for (int i = 0; i < size; i++) // 遍历数组，找到第一个和指定元素相等的元素，返回下标
                if (o.equals(elementData[i]))
                    return i;
        } 
        // 没有找到，返回空
        return -1;
    }
```

* 从头开始查找与指定元素相等的元素，注意，是可以查找null元素的，意味着ArrayList中可以存放null元素的。与此函数对应的lastIndexOf，表示从尾部开始查找。

get函数：

```java
    public E get(int index) {
        // 检验索引是否合法
        rangeCheck(index);

        return elementData(index);
    }
```

get函数会检查索引值是否合法（只检查是否大于size，而没有检查是否小于0），值得注意的是，在get函数中存在element函数，element函数用于返回具体的元素，具体函数如下:

```java
    E elementData(int index) {
        return (E) elementData[index];
    }
```

remove函数：

```java
    public E remove(int index) {
        // 检查索引是否合法
        rangeCheck(index);

        modCount++;
        E oldValue = elementData(index);
        // 需要移动的元素的个数
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);
        // 赋值为空，有利于进行GC
        elementData[--size] = null;
        // 返回旧值
        return oldValue;
    }
```

* remove函数用户移除指定下标的元素，此时会把指定下标到数组末尾的元素向前移动一个单位，并且会把数组最后一个元素设置为null，这样是为了方便之后将整个数组不被使用时，会被GC，可以作为小的技巧使用。

### 1.2.3 ArrayList遍历方式

ArrayList有三种遍历方式：

1. 通过迭代器遍历(Iterator)

```java
Integer value = null;
Iterator iter = list.iterator();
while(iter.hasNext()){
    value = (Integr)iter.next();
}
```

2. 随机访问通过索引值遍历(RandomAccess)

```java
Integer value = null;
int size = list.size();
for(int i=0; i<size; i++){
    value = (Integer)list.get(i);
}
```

3. for循环遍历

```java
Integer value = null;
for(Integer intege:list){
    value = intege;
}
```

* 遍历时随机访问效率最为高效，迭代器最慢。

### 1.2.4 toArray()异常

ArrayList提供2个toArray()函数：

```java
Object[] toArray()
<T> T[] toArray(T[] contents)
```

调用 toArray() 函数会抛出“java.lang.ClassCastException”异常，但是调用 toArray(T[] contents) 能正常返回 T[]。

toArray() 会抛出异常是因为 toArray() 返回的是 Object[] 数组，将 Object[] 转换为其它类型(如如，将Object[]转换为的Integer[])则会抛出“java.lang.ClassCastException”异常，因为Java不支持向下转型。

调用 toArray(T[] contents) 返回T[]的可以通过以下几种方式实现:

```java
// toArray(T[] contents)调用方式一
public static Integer[] vectorToArray1(ArrayList<Integer> v) {
    Integer[] newText = new Integer[v.size()];
    v.toArray(newText);
    return newText;
}

// toArray(T[] contents)调用方式二。最常用！
public static Integer[] vectorToArray2(ArrayList<Integer> v) {
    Integer[] newText = (Integer[])v.toArray(new Integer[0]);
    return newText;
}

// toArray(T[] contents)调用方式三
public static Integer[] vectorToArray3(ArrayList<Integer> v) {
    Integer[] newText = new Integer[v.size()];
    Integer[] newStrings = (Integer[])v.toArray(newText);
    return newStrings;
}
```

### 1.2.5 常用示例

```java
import java.util.*;

/*
 * @desc ArrayList常用API的测试程序
 * @author skywang 
 * @email kuiwu-wang@163.com
 */
public class ArrayListTest {

    public static void main(String[] args) {
        
        // 创建ArrayList
        ArrayList list = new ArrayList();

        // 将“”
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        // 将下面的元素添加到第1个位置
        list.add(0, "5");

        // 获取第1个元素
        System.out.println("the first element is: "+ list.get(0));
        // 删除“3”
        list.remove("3");
        // 获取ArrayList的大小
        System.out.println("Arraylist size=: "+ list.size());
        // 判断list中是否包含"3"
        System.out.println("ArrayList contains 3 is: "+ list.contains(3));
        // 设置第2个元素为10
        list.set(1, "10");

        // 通过Iterator遍历ArrayList
        for(Iterator iter = list.iterator(); iter.hasNext(); ) {
            System.out.println("next is: "+ iter.next());
        }

        // 将ArrayList转换为数组
        String[] arr = (String[])list.toArray(new String[0]);
        for (String str:arr)
            System.out.println("str: "+ str);

        // 清空ArrayList
        list.clear();
        // 判断ArrayList是否为空
        System.out.println("ArrayList is empty: "+ list.isEmpty());
    }
}
```

### 1.2.6 fail-fast总结

fail-fast 机制是java集合(Collection)中的一种错误机制。当多个线程对同一个集合的内容进行操作时，就可能会产生fail-fast事件。
例如：当某一个线程A通过iterator去遍历某集合的过程中，若该集合的内容被其他线程所改变了；那么线程A访问集合时，就会抛出ConcurrentModificationException异常，产生fail-fast事件。

```java
import java.util.*;
import java.util.concurrent.*;

/*
 * @desc java集合中Fast-Fail的测试程序。
 *
 *   fast-fail事件产生的条件：当多个线程对Collection进行操作时，若其中某一个线程通过iterator去遍历集合时，该集合的内容被其他线程所改变；则会抛出ConcurrentModificationException异常。
 *   fast-fail解决办法：通过util.concurrent集合包下的相应类去处理，则不会产生fast-fail事件。
 *
 *   本例中，分别测试ArrayList和CopyOnWriteArrayList这两种情况。ArrayList会产生fast-fail事件，而CopyOnWriteArrayList不会产生fast-fail事件。
 *   (01) 使用ArrayList时，会产生fast-fail事件，抛出ConcurrentModificationException异常；定义如下：
 *            private static List<String> list = new ArrayList<String>();
 *   (02) 使用时CopyOnWriteArrayList，不会产生fast-fail事件；定义如下：
 *            private static List<String> list = new CopyOnWriteArrayList<String>();
 *
 */
public class FastFailTest {

    private static List<String> list = new ArrayList<String>();
    //private static List<String> list = new CopyOnWriteArrayList<String>();
    public static void main(String[] args) {
    
        // 同时启动两个线程对list进行操作！
        new ThreadOne().start();
        new ThreadTwo().start();
    }

    private static void printAll() {
        System.out.println("");

        String value = null;
        Iterator iter = list.iterator();
        while(iter.hasNext()) {
            value = (String)iter.next();
            System.out.print(value+", ");
        }
    }

    /**
     * 向list中依次添加0,1,2,3,4,5，每添加一个数之后，就通过printAll()遍历整个list
     */
    private static class ThreadOne extends Thread {
        public void run() {
            int i = 0;
            while (i<6) {
                list.add(String.valueOf(i));
                printAll();
                i++;
            }
        }
    }

    /**
     * 向list中依次添加10,11,12,13,14,15，每添加一个数之后，就通过printAll()遍历整个list
     */
    private static class ThreadTwo extends Thread {
        public void run() {
            int i = 10;
            while (i<16) {
                list.add(String.valueOf(i));
                printAll();
                i++;
            }
        }
    }

}
```

运行结果：
运行该代码，抛出异常java.util.ConcurrentModificationException！即，产生fail-fast事件！

结果说明：
(01) FastFailTest中通过 new ThreadOne().start() 和 new ThreadTwo().start() 同时启动两个线程去操作list。
    ThreadOne线程：向list中依次添加0,1,2,3,4,5。每添加一个数之后，就通过printAll()遍历整个list。
    ThreadTwo线程：向list中依次添加10,11,12,13,14,15。每添加一个数之后，就通过printAll()遍历整个list。
(02) 当某一个线程遍历list的过程中，list的内容被另外一个线程所改变了；就会抛出ConcurrentModificationException异常，产生fail-fast事件。

解决方法是

```java
private static List<String> list = new ArrayList<String>();//替换为

private static List<String> list = new CopyOnWriteArrayList<String>();
```

具体原理参考：http://www.cnblogs.com/skywang12345/p/3308762.html

## 1.3 LinkedList

LinkedList 是一个继承于AbstractSequentialList的双向链表。它也可以被当作堆栈、队列或双端队列进行操作。
LinkedList 实现 List 接口，能对它进行队列操作。
LinkedList 实现 Deque 接口，即能将LinkedList当作双端队列使用。
LinkedList 实现了Cloneable接口，即覆盖了函数clone()，能克隆。
LinkedList 实现java.io.Serializable接口，这意味着LinkedList支持序列化，能通过序列化去传输。
LinkedList 是非同步的。

### 1.3.1 构造函数

```java
// 默认构造函数
LinkedList()

// 创建一个LinkedList, 保护Collection中的全部元素
LinkedList(Collection<? extends E> collection)
```

### 1.3.2 API

```java
//LinkedList的API
boolean       add(E object)
void          add(int location, E object)
boolean       addAll(Collection<? extends E> collection)
boolean       addAll(int location, Collection<? extends E> collection)
void          addFirst(E object)
void          addLast(E object)
void          clear()
Object        clone()
boolean       contains(Object object)
Iterator<E>   descendingIterator()
E             element()
E             get(int location)
E             getFirst()
E             getLast()
int           indexOf(Object object)
int           lastIndexOf(Object object)
ListIterator<E>     listIterator(int location)
boolean       offer(E o)
boolean       offerFirst(E e)
boolean       offerLast(E e)
E             peek()
E             peekFirst()
E             peekLast()
E             poll()
E             pollFirst()
E             pollLast()
E             pop()
void          push(E e)
E             remove()
E             remove(int location)
boolean       remove(Object object)
E             removeFirst()
boolean       removeFirstOccurrence(Object o)
E             removeLast()
boolean       removeLastOccurrence(Object o)
E             set(int location, E object)
int           size()
<T> T[]       toArray(T[] contents)
Object[]     toArray()
```

### 1.3.3 LinkedList数据结构

LinkedList与Collection关系图如下：

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/LinkedList.jpg)

LinkedList的本质是双向链表。
1. LinkedList继承于AbstractSequentialList，并且实现了Dequeue接口。 
2. LinkedList包含两个重要的成员：header 和 size。
　　
header是双向链表的表头，它是双向链表节点所对应的类Entry的实例。Entry中包含成员变量： previous, next, element。其中，previous是该节点的上一个节点，next是该节点的下一个节点，element是该节点所包含的值,size是双向链表中节点的个数。

### 1.3.4 LinkedList源码

LinkedList实际上是通过双向链表去实现的。既然是双向链表，那么它的顺序访问会非常高效，而随机访问效率比较低。

虽然LinkedList是通过双向链表的，但是它也实现了List接口{也就是说，它实现了get(int location)、remove(int location)等“根据索引值来获取、删除节点的函数”}。

原理是通过一个计数索引值来实现的。例如，当我们调用get(int location)时，首先会比较“location”和“双向链表长度的1/2”；若前者大，则从链表头开始往后查找，直到location位置；否则，从链表末尾开始先前查找，直到location位置。这就是“双线链表和索引值联系起来”的方法。

源码中定义了节点的基本结构：

```java
private static class Node<E>{
    E item; //表示该节点包含的值
    Node<E> next; //表达当前节点的下一个节点
    Noed<E> prev; //表示当前节点的上一个节点

    Node(Node<E> prev, E element, Node<E> next){
        this.item = element;
        this.next = next;
        this.prev = prev
    }
}
```

源码：

```java
public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, java.io.Serializable
{
   //实现Serilizable接口时，将不需要序列化的属性前添加关键字transient，序列化对象的时候，这个属性就不会序列化到指定的目的地中。
    transient int size = 0;
    //指向首节点
    transient Node<E> first;
    //指向最后一个节点
    transient Node<E> last;
    //构建一个空列表
    public LinkedList() {
    }
    //构建一个包含集合c的列表
    public LinkedList(Collection<? extends E> c) {
        this();
        addAll(c);
    }
   //将节点值为e的节点作为首节点
    private void linkFirst(E e) {
        final Node<E> f = first;
        //构建一个prev值为null,next为f,节点值为e的节点
        final Node<E> newNode = new Node<>(null, e, f);
        //将newNode作为首节点
        first = newNode;
        //如果newNode后面没有节点就将newNode作为最后一个节点
        if (f == null)
            last = newNode;
        //否则就将newNode赋给其prev
        else
            f.prev = newNode;
        //列表长度加一
        size++;
        modCount++;
    }
    //将节点值为e的节点作为最后一个节点
    void linkLast(E e) {
        final Node<E> l = last;
      //构建一个prev值为l,next为null,节点值为e的节点
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }
    //在非空节点succ之前插入节点e
    void linkBefore(E e, Node<E> succ) {
        final Node<E> pred = succ.prev;
        //将succ前面的节点和succ作为其prev和next
        final Node<E> newNode = new Node<>(pred, e, succ);
        //然后将newNode作为succ的prev
        succ.prev = newNode; 
        //如果原来succ是首节点，则将newNode设置为首节点
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
        modCount++;
    }
     //释放非空的首节点f
    private E unlinkFirst(Node<E> f) {
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null; // help GC
        //将first节点后面的节点设为首节点
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        modCount++;
        return element;
    }
     //释放非空的尾节点l
       private E unlinkLast(Node<E> l) {
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        modCount++;
        return element;
    }
    //删除非空节点x
    E unlink(Node<E> x) 
    {
        final E element = x.item;
        final Node<E> next = x.next;    //x后面的节点
        final Node<E> prev = x.prev;    //x前面的节点

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.item = null;
        size--;
        modCount++;
        return element;
    }
    //返回列表首节点元素值
    public E getFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }
    //返列表尾节点元素值
    public E getLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.item;
    }
    //移除首节点
    public E removeFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }
   //删除尾节点
    public E removeLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return unlinkLast(l);
    }
  //在列表首部插入节点e
    public void addFirst(E e) {
        linkFirst(e);
    }
    //在列表尾部插入节点e
    public void addLast(E e) {
        linkLast(e);
    }
   //判断列表中是否包含有元素o
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }
    //返回列表长度大小
    public int size() {
        return size;
    }
    //在列表尾部插入元素
    public boolean add(E e) {
        linkLast(e);
        return true;
    }
    //删除元素为o的节点
    public boolean remove(Object o) 
    {    
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }
   //将集合c中所有元素添加到列表的尾部
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }
   //从指定的位置index开始，将集合c中的元素插入到列表中
    public boolean addAll(int index, Collection<? extends E> c) {
        //首先判断插入位置的合法性
        checkPositionIndex(index);
        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;
        Node<E> pred, succ;
        if (index == size) {//说明在列表尾部插入集合元素
            succ = null;
            pred = last;
        } 
        else {  //否则，找到index所在的节点
            succ = node(index);
            pred = succ.prev;
        }
        for (Object o : a) {
            @SuppressWarnings("unchecked") E e = (E) o;
            Node<E> newNode = new Node<>(pred, e, null);
            if (pred == null)
                first = newNode;
            else
                pred.next = newNode;
            pred = newNode;
        }
        if (succ == null) {
            last = pred;
        } else {
            pred.next = succ;
            succ.prev = pred;
        }
        size += numNew;
        modCount++;
        return true;
    }
    //删除列表中所有节点
    public void clear() {
        for (Node<E> x = first; x != null; )  
        {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
        modCount++;
    }
    //获取指定索引位置节点的元素值
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }
    //替换指定索引位置节点的元素值
    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> x = node(index);
        E oldVal = x.item;
        x.item = element;
        return oldVal;
    }
    //在指定索引位置之前插入元素e
    public void add(int index, E element) {
        checkPositionIndex(index);   
        if (index == size)
            linkLast(element);
        else
            linkBefore(element, node(index));
    }
    //删除指定位置的元素
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }
    //判断指定索引位置的元素是否存在
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }
    //构建 IndexOutOfBoundsException详细信息
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    //返回指定索引位置的节点
    Node<E> node(int index) {
        //此处是一个小技巧，当index<size/2时，从列表前半部分开始，否则从后半部分开始
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }//返回列表中第一次出现o的位置，若不存在则返回-1
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }
    //逆向搜索，返回第一出现o的位置，不存在则返回-1
    public int lastIndexOf(Object o) {
        int index = size;
        if (o == null) {
            for (Node<E> x = last; x != null; x = x.prev) {
                index--;
                if (x.item == null)
                    return index;
            }
        } else {
            for (Node<E> x = last; x != null; x = x.prev) {
                index--;
                if (o.equals(x.item))
                    return index;
            }
        }
        return -1;
    }
   //获取列表首节点元素值
    public E peek() {
        final Node<E> f = first;
        return (f == null) ? null : f.item;
    }

    //获取列表首节点元素值，若为空则抛异常
    public E element() {
        return getFirst();
    }
   //检索首节点，若空则返回null,不为空则返回其元素值并删除首节点
    public E poll() {
        final Node<E> f = first;
        return (f == null) ? null : unlinkFirst(f);
    }
    //检索首节点，若空则抛异常,不为空则返回其元素值并删除首节点
    public E remove() {
        return removeFirst();
    }
   //在列表尾部增加节点e
    public boolean offer(E e) {
        return add(e);
    }
   //在列表首部插入节点e
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }
  //在列表尾部插入节点e
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }
    public E peekFirst() {
        final Node<E> f = first;
        return (f == null) ? null : f.item;
     }
  //获取列表尾节点元素值
    public E peekLast() {
        final Node<E> l = last;
        return (l == null) ? null : l.item;
    }
    public E pollFirst() {
        final Node<E> f = first;
        return (f == null) ? null : unlinkFirst(f);
    }
    public E pollLast() {
        final Node<E> l = last;
        return (l == null) ? null : unlinkLast(l);
    }
   //入栈
    public void push(E e)
    {
        addFirst(e);
    }
    //出栈
    public E pop() {
        return removeFirst();
    }
    //删除列表中第一出现o的节点
    public boolean removeFirstOccurrence(Object o) {
        return remove(o);
    }
    //逆向搜索，删除第一次出现o的节点
    public boolean removeLastOccurrence(Object o) {
        if (o == null) {
            for (Node<E> x = last; x != null; x = x.prev) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = last; x != null; x = x.prev) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }
```

### 1.3.5 LinkedList遍历

LinkedList支持多种遍历方式，一般不采用随机访问的方式去遍历，而采用逐个遍历的方式。

效率最高的有以下两种：

removeFist()
```java
try {
    while(list.removeFirst() != null)
        ;
} catch (NoSuchElementException e) {
}
```

removeLast()
```java
try {
    while(list.removeLast() != null)
        ;
} catch (NoSuchElementException e) {
}
```

### 1.3.6 LinkedList与ArrayList区别

1. ArrayList实现了基于动态数组的数据结构，LinkedList基于链表的数据结构。

2. LinkedList不支持高效的随机元素访问。

3. ArrayList的空间浪费主要体现在在list列表的结尾预留一定的容量空间，而LinkedList的空间花费则体现在它的每一个元素都需要消耗相当的空间，就存储密度来说，ArrayList是优于LinkedList的。

总结：，当操作是在一列数据的后面添加数据而不是在前面或中间,并且需要随机地访问其中的元素时,使用ArrayList会提供比较好的性能，当你的操作是在一列数据的前面或中间添加或删除数据,并且按照顺序访问其中的元素时,就应该使用LinkedList了。

## 1.4. Vector

Vector是矢量矩阵，继承于AbstractList，实现了List。所以，它是一个队列，支持相关添加、删除、修改、遍历。

Vector实现了RandmoAccess接口，即提供了随机访问功能。

Vector 实现了Cloneable接口，即实现clone()函数。它能被克隆。

和ArrayList不同，Vector中的操作是线程安全的。

### 1.4.1. 构造函数

```Java
// 默认构造函数
Vector()

// capacity是Vector的默认容量大小。当由于增加数据导致容量增加时，每次容量会增加一倍。
Vector(int capacity)

// capacity是Vector的默认容量大小，capacityIncrement是每次Vector容量增加时的增量值。
Vector(int capacity, int capacityIncrement)

// 创建一个包含collection的Vector
Vector(Collection<? extends E> collection)
```

### 1.4.2. API

```java
synchronized boolean        add(E object)
             void           add(int location, E object)
synchronized boolean        addAll(Collection<? extends E> collection)
synchronized boolean        addAll(int location, Collection<? extends E> collection)
synchronized void           addElement(E object)
synchronized int            capacity()
             void           clear()
synchronized Object         clone()
             boolean        contains(Object object)
synchronized boolean        containsAll(Collection<?> collection)
synchronized void           copyInto(Object[] elements)
synchronized E              elementAt(int location)
             Enumeration<E> elements()
synchronized void           ensureCapacity(int minimumCapacity)
synchronized boolean        equals(Object object)
synchronized E              firstElement()
             E              get(int location)
synchronized int            hashCode()
synchronized int            indexOf(Object object, int location)
             int            indexOf(Object object)
synchronized void           insertElementAt(E object, int location)
synchronized boolean        isEmpty()
synchronized E              lastElement()
synchronized int            lastIndexOf(Object object, int location)
synchronized int            lastIndexOf(Object object)
synchronized E              remove(int location)
             boolean        remove(Object object)
synchronized boolean        removeAll(Collection<?> collection)
synchronized void           removeAllElements()
synchronized boolean        removeElement(Object object)
synchronized void           removeElementAt(int location)
synchronized boolean        retainAll(Collection<?> collection)
synchronized E              set(int location, E object)
synchronized void           setElementAt(E object, int location)
synchronized void           setSize(int length)
synchronized int            size()
synchronized List<E>        subList(int start, int end)
synchronized <T> T[]        toArray(T[] contents)
synchronized Object[]       toArray()
synchronized String         toString()
synchronized void           trimToSize()
```

### 1.4.3. 数据结构

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/vector.jpg)

Vector的数据结构与ArrayList类似，它包含了3个成员变量：elementData , elementCount， capacityIncrement。

1. elementData 是"Object[]类型的数组"，它保存了添加到Vector中的元素。elementData是个动态数组，如果初始化Vector时，没指定动态数组的大小，则使用默认大小10。随着Vector中元素的增加，Vector的容量也会动态增长，capacityIncrement是与容量增长相关的增长系数，具体的增长方式，请参考源码分析中的ensureCapacity()函数。

2. elementCount 是动态数组的实际大小。

3. capacityIncrement 是动态数组的增长系数。如果在创建Vector时，指定了capacityIncrement的大小；则，每次当Vector中动态数组容量增加时，增加的大小都是capacityIncrement。如果没有指定增长系数，每次容量大小增加一倍。

### 1.4.4. 源码

```java
package java.util;

public class Vector<E>
    extends AbstractList<E>
    implements List<E>, RandomAccess, Cloneable, java.io.Serializable
{
   
    // 保存Vector中数据的数组
    protected Object[] elementData;

    // 实际数据的数量
    protected int elementCount;

    // 容量增长系数
    protected int capacityIncrement;

    // Vector的序列版本号
    private static final long serialVersionUID = -2767605614048989439L;

    // Vector构造函数。默认容量是10。
    public Vector() {
        this(10);
    }

    // 指定Vector容量大小的构造函数
    public Vector(int initialCapacity) {
        this(initialCapacity, 0);
    }

    // 指定Vector"容量大小"和"增长系数"的构造函数
    public Vector(int initialCapacity, int capacityIncrement) {
        super();
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);
        // 新建一个数组，数组容量是initialCapacity
        this.elementData = new Object[initialCapacity];
        // 设置容量增长系数
        this.capacityIncrement = capacityIncrement;
    }

    // 指定集合的Vector构造函数。
    public Vector(Collection<? extends E> c) {
        // 获取“集合(c)”的数组，并将其赋值给elementData
        elementData = c.toArray();
        // 设置数组长度
        elementCount = elementData.length;
        // c.toArray might (incorrectly) not return Object[] (see 6260652)
        if (elementData.getClass() != Object[].class)
            elementData = Arrays.copyOf(elementData, elementCount, Object[].class);
    }

    // 将数组Vector的全部元素都拷贝到数组anArray中
    public synchronized void copyInto(Object[] anArray) {
        System.arraycopy(elementData, 0, anArray, 0, elementCount);
    }

    // 将当前容量值设为 =实际元素个数
    public synchronized void trimToSize() {
        modCount++;
        int oldCapacity = elementData.length;
        if (elementCount < oldCapacity) {
            elementData = Arrays.copyOf(elementData, elementCount);
        }
    }

    // 确认“Vector容量”的帮助函数
    private void ensureCapacityHelper(int minCapacity) {
        int oldCapacity = elementData.length;
        // 当Vector的容量不足以容纳当前的全部元素，增加容量大小。
        // 若 容量增量系数>0(即capacityIncrement>0)，则将容量增大当capacityIncrement
        // 否则，将容量增大一倍。
        if (minCapacity > oldCapacity) {
            Object[] oldData = elementData;
            int newCapacity = (capacityIncrement > 0) ?
                (oldCapacity + capacityIncrement) : (oldCapacity * 2);
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    // 确定Vector的容量。
    public synchronized void ensureCapacity(int minCapacity) {
        // 将Vector的改变统计数+1
        modCount++;
        ensureCapacityHelper(minCapacity);
    }

    // 设置容量值为 newSize
    public synchronized void setSize(int newSize) {
        modCount++;
        if (newSize > elementCount) {
            // 若 "newSize 大于 Vector容量"，则调整Vector的大小。
            ensureCapacityHelper(newSize);
        } else {
            // 若 "newSize 小于/等于 Vector容量"，则将newSize位置开始的元素都设置为null
            for (int i = newSize ; i < elementCount ; i++) {
                elementData[i] = null;
            }
        }
        elementCount = newSize;
    }

    // 返回“Vector的总的容量”
    public synchronized int capacity() {
        return elementData.length;
    }

    // 返回“Vector的实际大小”，即Vector中元素个数
    public synchronized int size() {
        return elementCount;
    }

    // 判断Vector是否为空
    public synchronized boolean isEmpty() {
        return elementCount == 0;
    }

    // 返回“Vector中全部元素对应的Enumeration”
    public Enumeration<E> elements() {
        // 通过匿名类实现Enumeration
        return new Enumeration<E>() {
            int count = 0;

            // 是否存在下一个元素
            public boolean hasMoreElements() {
                return count < elementCount;
            }

            // 获取下一个元素
            public E nextElement() {
                synchronized (Vector.this) {
                    if (count < elementCount) {
                        return (E)elementData[count++];
                    }
                }
                throw new NoSuchElementException("Vector Enumeration");
            }
        };
    }

    // 返回Vector中是否包含对象(o)
    public boolean contains(Object o) {
        return indexOf(o, 0) >= 0;
    }


    // 从index位置开始向后查找元素(o)。
    // 若找到，则返回元素的索引值；否则，返回-1
    public synchronized int indexOf(Object o, int index) {
        if (o == null) {
            // 若查找元素为null，则正向找出null元素，并返回它对应的序号
            for (int i = index ; i < elementCount ; i++)
            if (elementData[i]==null)
                return i;
        } else {
            // 若查找元素不为null，则正向找出该元素，并返回它对应的序号
            for (int i = index ; i < elementCount ; i++)
            if (o.equals(elementData[i]))
                return i;
        }
        return -1;
    }

    // 查找并返回元素(o)在Vector中的索引值
    public int indexOf(Object o) {
        return indexOf(o, 0);
    }

    // 从后向前查找元素(o)。并返回元素的索引
    public synchronized int lastIndexOf(Object o) {
        return lastIndexOf(o, elementCount-1);
    }

    // 从后向前查找元素(o)。开始位置是从前向后的第index个数；
    // 若找到，则返回元素的“索引值”；否则，返回-1。
    public synchronized int lastIndexOf(Object o, int index) {
        if (index >= elementCount)
            throw new IndexOutOfBoundsException(index + " >= "+ elementCount);

        if (o == null) {
            // 若查找元素为null，则反向找出null元素，并返回它对应的序号
            for (int i = index; i >= 0; i--)
            if (elementData[i]==null)
                return i;
        } else {
            // 若查找元素不为null，则反向找出该元素，并返回它对应的序号
            for (int i = index; i >= 0; i--)
            if (o.equals(elementData[i]))
                return i;
        }
        return -1;
    }

    // 返回Vector中index位置的元素。
    // 若index月结，则抛出异常
    public synchronized E elementAt(int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + elementCount);
        }

        return (E)elementData[index];
    }

    // 获取Vector中的第一个元素。
    // 若失败，则抛出异常！
    public synchronized E firstElement() {
        if (elementCount == 0) {
            throw new NoSuchElementException();
        }
        return (E)elementData[0];
    }

    // 获取Vector中的最后一个元素。
    // 若失败，则抛出异常！
    public synchronized E lastElement() {
        if (elementCount == 0) {
            throw new NoSuchElementException();
        }
        return (E)elementData[elementCount - 1];
    }

    // 设置index位置的元素值为obj
    public synchronized void setElementAt(E obj, int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " +
                                 elementCount);
        }
        elementData[index] = obj;
    }

    // 删除index位置的元素
    public synchronized void removeElementAt(int index) {
        modCount++;
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " +
                                 elementCount);
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        int j = elementCount - index - 1;
        if (j > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        elementCount--;
        elementData[elementCount] = null; /* to let gc do its work */
    }

    // 在index位置处插入元素(obj)
    public synchronized void insertElementAt(E obj, int index) {
        modCount++;
        if (index > elementCount) {
            throw new ArrayIndexOutOfBoundsException(index
                                 + " > " + elementCount);
        }
        ensureCapacityHelper(elementCount + 1);
        System.arraycopy(elementData, index, elementData, index + 1, elementCount - index);
        elementData[index] = obj;
        elementCount++;
    }

    // 将“元素obj”添加到Vector末尾
    public synchronized void addElement(E obj) {
        modCount++;
        ensureCapacityHelper(elementCount + 1);
        elementData[elementCount++] = obj;
    }

    // 在Vector中查找并删除元素obj。
    // 成功的话，返回true；否则，返回false。
    public synchronized boolean removeElement(Object obj) {
        modCount++;
        int i = indexOf(obj);
        if (i >= 0) {
            removeElementAt(i);
            return true;
        }
        return false;
    }

    // 删除Vector中的全部元素
    public synchronized void removeAllElements() {
        modCount++;
        // 将Vector中的全部元素设为null
        for (int i = 0; i < elementCount; i++)
            elementData[i] = null;

        elementCount = 0;
    }

    // 克隆函数
    public synchronized Object clone() {
        try {
            Vector<E> v = (Vector<E>) super.clone();
            // 将当前Vector的全部元素拷贝到v中
            v.elementData = Arrays.copyOf(elementData, elementCount);
            v.modCount = 0;
            return v;
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError();
        }
    }

    // 返回Object数组
    public synchronized Object[] toArray() {
        return Arrays.copyOf(elementData, elementCount);
    }

    // 返回Vector的模板数组。所谓模板数组，即可以将T设为任意的数据类型
    public synchronized <T> T[] toArray(T[] a) {
        // 若数组a的大小 < Vector的元素个数；
        // 则新建一个T[]数组，数组大小是“Vector的元素个数”，并将“Vector”全部拷贝到新数组中
        if (a.length < elementCount)
            return (T[]) Arrays.copyOf(elementData, elementCount, a.getClass());

        // 若数组a的大小 >= Vector的元素个数；
        // 则将Vector的全部元素都拷贝到数组a中。
    System.arraycopy(elementData, 0, a, 0, elementCount);

        if (a.length > elementCount)
            a[elementCount] = null;

        return a;
    }

    // 获取index位置的元素
    public synchronized E get(int index) {
        if (index >= elementCount)
            throw new ArrayIndexOutOfBoundsException(index);

        return (E)elementData[index];
    }

    // 设置index位置的值为element。并返回index位置的原始值
    public synchronized E set(int index, E element) {
        if (index >= elementCount)
            throw new ArrayIndexOutOfBoundsException(index);

        Object oldValue = elementData[index];
        elementData[index] = element;
        return (E)oldValue;
    }

    // 将“元素e”添加到Vector最后。
    public synchronized boolean add(E e) {
        modCount++;
        ensureCapacityHelper(elementCount + 1);
        elementData[elementCount++] = e;
        return true;
    }

    // 删除Vector中的元素o
    public boolean remove(Object o) {
        return removeElement(o);
    }

    // 在index位置添加元素element
    public void add(int index, E element) {
        insertElementAt(element, index);
    }

    // 删除index位置的元素，并返回index位置的原始值
    public synchronized E remove(int index) {
        modCount++;
        if (index >= elementCount)
            throw new ArrayIndexOutOfBoundsException(index);
        Object oldValue = elementData[index];

        int numMoved = elementCount - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                     numMoved);
        elementData[--elementCount] = null; // Let gc do its work

        return (E)oldValue;
    }

    // 清空Vector
    public void clear() {
        removeAllElements();
    }

    // 返回Vector是否包含集合c
    public synchronized boolean containsAll(Collection<?> c) {
        return super.containsAll(c);
    }

    // 将集合c添加到Vector中
    public synchronized boolean addAll(Collection<? extends E> c) {
        modCount++;
        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacityHelper(elementCount + numNew);
        // 将集合c的全部元素拷贝到数组elementData中
        System.arraycopy(a, 0, elementData, elementCount, numNew);
        elementCount += numNew;
        return numNew != 0;
    }

    // 删除集合c的全部元素
    public synchronized boolean removeAll(Collection<?> c) {
        return super.removeAll(c);
    }

    // 删除“非集合c中的元素”
    public synchronized boolean retainAll(Collection<?> c)  {
        return super.retainAll(c);
    }

    // 从index位置开始，将集合c添加到Vector中
    public synchronized boolean addAll(int index, Collection<? extends E> c) {
        modCount++;
        if (index < 0 || index > elementCount)
            throw new ArrayIndexOutOfBoundsException(index);

        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacityHelper(elementCount + numNew);

        int numMoved = elementCount - index;
        if (numMoved > 0)
        System.arraycopy(elementData, index, elementData, index + numNew, numMoved);

        System.arraycopy(a, 0, elementData, index, numNew);
        elementCount += numNew;
        return numNew != 0;
    }

    // 返回两个对象是否相等
    public synchronized boolean equals(Object o) {
        return super.equals(o);
    }

    // 计算哈希值
    public synchronized int hashCode() {
        return super.hashCode();
    }

    // 调用父类的toString()
    public synchronized String toString() {
        return super.toString();
    }

    // 获取Vector中fromIndex(包括)到toIndex(不包括)的子集
    public synchronized List<E> subList(int fromIndex, int toIndex) {
        return Collections.synchronizedList(super.subList(fromIndex, toIndex), this);
    }

    // 删除Vector中fromIndex到toIndex的元素
    protected synchronized void removeRange(int fromIndex, int toIndex) {
        modCount++;
        int numMoved = elementCount - toIndex;
        System.arraycopy(elementData, toIndex, elementData, fromIndex,
                         numMoved);

        // Let gc do its work
        int newElementCount = elementCount - (toIndex-fromIndex);
        while (elementCount != newElementCount)
            elementData[--elementCount] = null;
    }

    // java.io.Serializable的写入函数
    private synchronized void writeObject(java.io.ObjectOutputStream s)
        throws java.io.IOException {
        s.defaultWriteObject();
    }
}
```

### 1.4.5. 遍历方式

Vecort支持4种遍历方式：迭代器，随机访问，for循环，Enumeration遍历。速度最快的是随机访问。

迭代器：

```java
Integer value = null;
int size= vec.size();
for (int i=0; i<size; i++){
    value = (Integer)vec.get(i);
}
```

随机访问:

```java
Integer value = null;
int size = vec.size();
for (int i=0; i<size; i++){
    value = (Integer)vec.get(i);
}
```

for循环：

```java
Integer value = null;
for (Integer integ:vec){
    value = integ;
}
```

Enumeration遍历:

```java
Integer value = null;
Enumeration enu = vec.elements();
while (enu.hasMoreElements()) {
    value = (Integer)enu.nextElement();
}
```

### 1.4.6. ArrayList和vector的区别

1. Vector的方法都是同步的(Synchronized),是线程安全的(thread-safe)，而ArrayList的方法不是，由于线程的同步必然要影响性能，因此,ArrayList的性能比Vector好。 
2. 当Vector或ArrayList中的元素超过它的初始大小时,Vector会将它的容量翻倍,而ArrayList只增加50%的大小，这样,ArrayList就有利于节约内存空间。

## 1.5. Stack

Stack是栈，满足先进后出，java中stack继承于Vector，由于Vector是通过数组实现的，这就意味着，Stack也是通过数组实现的，而非链表。当然，我们也可以将LinkedList当作栈来使用。

Stack与Collection的关系如下：

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/stack.jpg)

### 1.5.1. 构造函数和API

Stack只有一个默认构造函数：`Stack()`

Stack由于继承Vector，因此包含Vector全部的API，且还有如下API:

```JAVA
             boolean       empty()
synchronized E             peek()
synchronized E             pop()
             E             push(E object)
synchronized int           search(Object o)
```

### 1.5.2. 源码

```java
package java.util;

public
class Stack<E> extends Vector<E> {
    // 版本ID。
    private static final long serialVersionUID = 1224463164541339165L;

    // 构造函数
    public Stack() {
    }

    // push函数：将元素存入栈顶
    public E push(E item) {
        // 将元素存入栈顶。
        // addElement()的实现在Vector.java中
        addElement(item);

        return item;
    }

    // pop函数：返回栈顶元素，并将其从栈中删除
    public synchronized E pop() {
        E    obj;
        int    len = size();

        obj = peek();
        // 删除栈顶元素，removeElementAt()的实现在Vector.java中
        removeElementAt(len - 1);

        return obj;
    }

    // peek函数：返回栈顶元素，不执行删除操作
    public synchronized E peek() {
        int    len = size();

        if (len == 0)
            throw new EmptyStackException();
        // 返回栈顶元素，elementAt()具体实现在Vector.java中
        return elementAt(len - 1);
    }

    // 栈是否为空
    public boolean empty() {
        return size() == 0;
    }

    // 查找“元素o”在栈中的位置：由栈底向栈顶方向数
    public synchronized int search(Object o) {
        // 获取元素索引，elementAt()具体实现在Vector.java中
        int i = lastIndexOf(o);

        if (i >= 0) {
            return size() - i;
        }
        return -1;
    }
}
```

Stack实际上也是通过数组去实现的：

1. 执行push时(即，将元素推入栈中)，是通过将元素追加的数组的末尾中。
2. 执行peek时(即，取出栈顶元素，不执行删除)，是返回数组末尾的元素。
3. 执行pop时(即，取出栈顶元素，并将该元素从栈中删除)，是取出数组末尾的元素，然后将该元素从数组中删除。

### 1.5.3. 示例

```java
import java.util.Stack;
import java.util.Iterator;
import java.util.List;

public class StackTest {

    public static void main(String[] args) {
        Stack stack = new Stack();
        // 将1,2,3,4,5添加到栈中
        for(int i=1; i<6; i++) {
            stack.push(String.valueOf(i));
        }

        // 遍历并打印出该栈
        iteratorThroughRandomAccess(stack) ;

        // 查找“2”在栈中的位置，并输出
        int pos = stack.search("2");
        System.out.println("the postion of 2 is:"+pos);

        // pop返回栈顶元素将其删除之后，遍历栈
        stack.pop();
        iteratorThroughRandomAccess(stack) ;

        // peek栈顶元素之后，遍历栈
        String val = (String)stack.peek();
        System.out.println("peek:"+val);
        iteratorThroughRandomAccess(stack) ;

        // 通过Iterator去遍历Stack
        iteratorThroughIterator(stack) ;
    }

    /**
     * 通过快速访问遍历Stack
     */
    public static void iteratorThroughRandomAccess(List list) {
        String val = null;
        for (int i=0; i<list.size(); i++) {
            val = (String)list.get(i);
            System.out.print(val+" ");
        }
        System.out.println();
    }

    /**
     * 通过迭代器遍历Stack
     */
    public static void iteratorThroughIterator(List list) {

        String val = null;
        for(Iterator iter = list.iterator(); iter.hasNext(); ) {
            val = (String)iter.next();
            System.out.print(val+" ");
        }
        System.out.println();
    }

}
```

## 1.6. List总结

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/list.jpg)

List是一个接口，继承于Collection的接口，代表着是一个有序队列。

AbstractList实现List接口中除size()、get(int location)之外的函数。

AbstractSequentialList 实现了“链表中，根据index索引值操作链表的全部函数”。

ArrayList, LinkedList, Vector, Stack是List的4个实现类：

1. ArrayList 是一个数组队列，相当于动态数组。它由数组实现，随机访问效率高，随机插入、随机删除效率低。
2. LinkedList 是一个双向链表。它也可以被当作堆栈、队列或双端队列进行操作。LinkedList随机访问速度慢，但插入、删除效率高。
3. Vector 是矢量队列，和ArrayList一样，它也是一个动态数组，由数组实现。但是ArrayList是非线程安全的，而Vector是线程安全的。
4. Stack 是栈，它继承于Vector。它的特性是：先进后出(FILO, First In Last Out)。

### 1.6.1 使用场景

如果涉及到“栈”、“队列”、“链表”等操作，应该考虑用List，具体的选择哪个List，根据下面的标准来取舍。

* 对于需要快速插入，删除元素，应该使用LinkedList。
* 对于需要快速随机访问元素，应该使用ArrayList。
* 对于“单线程环境” 或者 “多线程环境，但List仅仅只会被单个线程操作”，此时应该使用非同步的类(如ArrayList)。
* 对于“多线程环境，且List可能同时被多个线程操作”，此时，应该使用同步的类(如Vector)。

### 1.6.2. LinkedList和ArrayList性能分析

#### 插入，删除

对于插入元素，LinkedList定位插入元素代码如下：

```java
// 在index前添加节点，且节点的值为element
public void add(int index, E element) {
    addBefore(element, (index==size ? header : entry(index)));
}

// 获取双向链表中指定位置的节点
private Entry<E> entry(int index) {
    if (index < 0 || index >= size)
        throw new IndexOutOfBoundsException("Index: "+index+
                                            ", Size: "+size);
    Entry<E> e = header;
    // 获取index处的节点。
    // 若index < 双向链表长度的1/2,则从前向后查找;
    // 否则，从后向前查找。
    if (index < (size >> 1)) {
        for (int i = 0; i <= index; i++)
            e = e.next;
    } else {
        for (int i = size; i > index; i--)
            e = e.previous;
    }
    return e;
}

// 将节点(节点数据是e)添加到entry节点之前。
private Entry<E> addBefore(E e, Entry<E> entry) {
    // 新建节点newEntry，将newEntry插入到节点e之前；并且设置newEntry的数据是e
    Entry<E> newEntry = new Entry<E>(e, entry, entry.previous);
    // 插入newEntry到链表中
    newEntry.previous.next = newEntry;
    newEntry.next.previous = newEntry;
    size++;
    modCount++;
    return newEntry;
}
```

可以看出通过add(int index, E element)向LinkedList插入元素时。先是在双向链表中找到要插入节点的位置index；找到之后，再插入一个新节点。

双向链表查找index位置的节点时，有一个加速动作：若index < 双向链表长度的1/2，则从前向后查找; 否则，从后向前查找。

相对于ArrayList中插入代码：

```java
// 将e添加到ArrayList的指定位置
public void add(int index, E element) {
    if (index > size || index < 0)
        throw new IndexOutOfBoundsException(
        "Index: "+index+", Size: "+size);

    //确认ArrayList的容量，若容量不够，则增加容量
    ensureCapacity(size+1);  
    System.arraycopy(elementData, index, elementData, index + 1,
         size - index);//耗时
    elementData[index] = element;
    size++;
}
```

arraycopy()会移动index之后所有元素,所以会增加时间。

删除与插入原理类似。

#### 随机访问

随机访问中LinkedList很慢，而ArrayList访问很快

LinkedList源码：

```java
// 返回LinkedList指定位置的元素
public E get(int index) {
    return entry(index).element;
}

// 获取双向链表中指定位置的节点
private Entry<E> entry(int index) {
    if (index < 0 || index >= size)
        throw new IndexOutOfBoundsException("Index: "+index+
                                            ", Size: "+size);
    Entry<E> e = header;
    // 获取index处的节点。
    // 若index < 双向链表长度的1/2,则从前先后查找;
    // 否则，从后向前查找。
    if (index < (size >> 1)) {
        for (int i = 0; i <= index; i++)
            e = e.next;
    } else {
        for (int i = size; i > index; i--)
            e = e.previous;
    }
    return e;
}
```

通过get(int index)获取LinkedList第index个元素时。先是在双向链表中找到要index位置的元素；找到之后再返回。

ArrayList源码：

```java
// 获取index位置的元素值
public E get(int index) {
    RangeCheck(index);

    return (E) elementData[index];
}

private void RangeCheck(int index) {
    if (index >= size)
        throw new IndexOutOfBoundsException(
        "Index: "+index+", Size: "+size);
}
```

通过get(int index)获取ArrayList第index个元素时。直接返回数组中index位置的元素，而不需要像LinkedList一样进行查找。

### 1.6.3 Vector和ArrayList性能分析

相同点：

1. 都是List，都继承于AbstractList,并实现了List接口。

ArrayList和Vector的类定义如下：

```java

// ArrayList的定义
public class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable

// Vector的定义
public class Vector<E> extends AbstractList<E>
    implements List<E>, RandomAccess, Cloneable, java.io.Serializable {}
```

2. 都实现了RandomAccess和Cloneable接口

实现RandomAccess接口，意味着它们都支持快速随机访问；

实现Cloneable接口，意味着它们能克隆自己。

3. 都是通过数组实现，本质上都是动态数组
4. 它们的默认数组容量都是10
5. 都支持Iterator和ListIerator遍历

不同点：

1. 线程安全不同

ArrayList是非线程安全，Vector是线程安全的支持同步，多线程。

2. 对序列化支持不同

ArrayList支持序列化，而Vector不支持；即ArrayList有实现java.io.Serializable接口，而Vector没有实现该接口。

3. 构造函数个数不同

ArrayList有3个构造函数，而Vector有4个构造函数。Vector除了包括和ArrayList类似的3个构造函数之外，另外的一个构造函数可以指定容量增加系数。

4. 增加容量方式不同

ArrayList：逐个添加元素，当容量不足时，新的容量=(原始容量*3)/2+1

Vector:与增长系数有关，“新的容量”=“原始容量+增长系数”。若增长系数无效(即，小于/等于0)，则“新的容量”=“原始容量 x 2”。

```java
public void ensureCapacity(int minCapacity) {//ArrayList
    // 将“修改统计数”+1
    modCount++;
    int oldCapacity = elementData.length;
    // 若当前容量不足以容纳当前的元素个数，设置 新的容量=“(原始容量x3)/2 + 1”
    if (minCapacity > oldCapacity) {
        Object oldData[] = elementData;
        int newCapacity = (oldCapacity * 3)/2 + 1;
        if (newCapacity < minCapacity)
            newCapacity = minCapacity;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
}

private void ensureCapacityHelper(int minCapacity) {//Vector
    int oldCapacity = elementData.length;
    // 当Vector的容量不足以容纳当前的全部元素，增加容量大小。
    // 若 容量增量系数>0(即capacityIncrement>0)，则将容量增大当capacityIncrement
    // 否则，将容量增大一倍。
    if (minCapacity > oldCapacity) {
        Object[] oldData = elementData;
        int newCapacity = (capacityIncrement > 0) ?
            (oldCapacity + capacityIncrement) : (oldCapacity * 2);
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
}
```

5. 对Enumeration的支持不同。Vector支持通过Enumeration去遍历，而List不支持

# 2. Map

Set的实现类都是基于Map来实现的，HashSet是通过HashMap实现的，TreeSet是通过TreeMap实现的。

Map构架如下：

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/map.jpg)

1. Map 是映射接口，Map中存储的内容是键值对(key-value)。
2. AbstractMap 是继承于Map的抽象类，它实现了Map中的大部分API。其它Map的实现类可以通过继承AbstractMap来减少重复编码。
3. SortedMap 是继承于Map的接口。SortedMap中的内容是排序的键值对，排序的方法是通过比较器(Comparator)。
4. NavigableMap 是继承于SortedMap的接口。相比于SortedMap，NavigableMap有一系列的导航方法；如"获取大于/等于某对象的键值对"、“获取小于/等于某对象的键值对”等等。 
5. TreeMap 继承于AbstractMap，且实现了NavigableMap接口；因此，TreeMap中的内容是“有序的键值对”！
6. HashMap 继承于AbstractMap，但没实现NavigableMap接口；因此，HashMap的内容是“键值对，但不保证次序”！
7. Hashtable 虽然不是继承于AbstractMap，但它继承于Dictionary(Dictionary也是键值对的接口)，而且也实现Map接口；因此，Hashtable的内容也是“键值对，也不保证次序”。但和HashMap相比，Hashtable是线程安全的，而且它支持通过Enumeration去遍历。
8. WeakHashMap 继承于AbstractMap。它和HashMap的键类型不同，WeakHashMap的键是“弱键”。

## 2.1. Map定义

Map定义如下：

```JAVA
public interface Map<K, V>{}
```

Map是一个键值对映射接口，映射中不能包含重复的键，每个键只能映射一个值。

Map的实现类应该提供两个构造方法，第一个是void无参数构造方法用于创建空映射，第二个是带有单个Map类型参数的构造方法，用于创建一个与其参数具有相同键值映射关系的新映射。

```java
//API
abstract void                 clear()
abstract boolean              containsKey(Object key)
abstract boolean              containsValue(Object value)
abstract Set<Entry<K, V>>     entrySet()//返回键-值集的Set集合
abstract boolean              equals(Object object)
abstract V                    get(Object key)
abstract int                  hashCode()
abstract boolean              isEmpty()
abstract Set<K>               keySet()//返回键集的Set集合
abstract V                    put(K key, V value)
abstract void                 putAll(Map<? extends K, ? extends V> map)
abstract V                    remove(Object key)
abstract int                  size()
abstract Collection<V>        values()//返回值集的Collection集合
```

*  因为Map中不能包含重复的键；每个键最多只能映射到一个值。所以，键-值集、键集都是Set，值集时Collection。


### 2.1.1. Map.Entry

Map.Entry是Map中内部的一个接口，Map.Entry是键值对，Map通过 entrySet() 获取Map.Entry的键值对集合，从而通过该集合实现对键值对的操作。

```java
//定义
interface Entry<K,V> { }

//API
abstract boolean     equals(Object object)
abstract K             getKey()
abstract V             getValue()
abstract int         hashCode()
abstract V             setValue(V object)
```

### 2.1.2. AbstractMap

定义

```java
public abstract class AbstractMap<K,V> implements Map<K,V> {}
```

要实现不可修改的映射，扩展此类并提供 entrySet 方法的实现即可。通常，返回的 set 将依次在 AbstractSet 上实现。此 set 不支持 add() 或 remove() 方法，其迭代器也不支持 remove() 方法。

要实现可修改的映射，编程人员必须另外重写此类的 put 方法（否则将抛出 UnsupportedOperationException），entrySet().iterator() 返回的迭代器也必须另外实现其 remove 方法。

```java
//API
abstract Set<Entry<K, V>>     entrySet()
         void                 clear()
         boolean              containsKey(Object key)
         boolean              containsValue(Object value)
         boolean              equals(Object object)
         V                    get(Object key)
         int                  hashCode()
         boolean              isEmpty()
         Set<K>               keySet()
         V                    put(K key, V value)
         void                 putAll(Map<? extends K, ? extends V> map)
         V                    remove(Object key)
         int                  size()
         String               toString()
         Collection<V>        values()
         Object               clone()
```

### 2.1.3. SortedMap

定义

```java
public interface SortedMap<K, V> extends Map<K, V>{}
```

SortedMap是一个继承于Map接口的接口,是一个有序的SortedMap键值映射。

SortedMap的排序方式有两种：自然排序 或者 用户指定比较器。 插入有序 SortedMap 的所有元素都必须实现 Comparable 接口（或者被指定的比较器所接受）。

所有SortedMap 实现类都应该提供 4 个“标准”构造方法：
1. void（无参数）构造方法，它创建一个空的有序映射，按照键的自然顺序进行排序。
2. 带有一个 Comparator 类型参数的构造方法，它创建一个空的有序映射，根据指定的比较器进行排序。
3. 带有一个 Map 类型参数的构造方法，它创建一个新的有序映射，其键-值映射关系与参数相同，按照键的自然顺序进行排序。
4. 带有一个 SortedMap 类型参数的构造方法，它创建一个新的有序映射，其键-值映射关系和排序方法与输入的有序映射相同。无法保证强制实施此建议，因为接口不能包含构造方法。

```JAVA
// 继承于Map的API
abstract void                 clear()
abstract boolean              containsKey(Object key)
abstract boolean              containsValue(Object value)
abstract Set<Entry<K, V>>     entrySet()
abstract boolean              equals(Object object)
abstract V                    get(Object key)
abstract int                  hashCode()
abstract boolean              isEmpty()
abstract Set<K>               keySet()
abstract V                    put(K key, V value)
abstract void                 putAll(Map<? extends K, ? extends V> map)
abstract V                    remove(Object key)
abstract int                  size()
abstract Collection<V>        values()
// SortedMap新增的API 
abstract Comparator<? super K>     comparator()
abstract K                         firstKey()
abstract SortedMap<K, V>           headMap(K endKey)
abstract K                         lastKey()
abstract SortedMap<K, V>           subMap(K startKey, K endKey)
abstract SortedMap<K, V>           tailMap(K startKey)
```

### 2.1.4. NavigableMap

```java
public interface NavigableMap<K,V> extends SortedMap<K,V> { }
```

NavigableMap是继承于SortedMap的接口。它是一个可导航的键-值对集合，具有了为给定搜索目标报告最接近匹配项的导航方法。

NavigableMap分别提供了获取“键”、“键-值对”、“键集”、“键-值对集”的相关方法。

```java
abstract Entry<K, V>             ceilingEntry(K key)
abstract Entry<K, V>             firstEntry()
abstract Entry<K, V>             floorEntry(K key)
abstract Entry<K, V>             higherEntry(K key)
abstract Entry<K, V>             lastEntry()
abstract Entry<K, V>             lowerEntry(K key)
abstract Entry<K, V>             pollFirstEntry()
abstract Entry<K, V>             pollLastEntry()
abstract K                       ceilingKey(K key)
abstract K                       floorKey(K key)
abstract K                       higherKey(K key)
abstract K                       lowerKey(K key)
abstract NavigableSet<K>         descendingKeySet()
abstract NavigableSet<K>         navigableKeySet()
abstract NavigableMap<K, V>      descendingMap()
abstract NavigableMap<K, V>      headMap(K toKey, boolean inclusive)
abstract SortedMap<K, V>         headMap(K toKey)
abstract SortedMap<K, V>         subMap(K fromKey, K toKey)
abstract NavigableMap<K, V>      subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)
abstract SortedMap<K, V>         tailMap(K fromKey)
abstract NavigableMap<K, V>      tailMap(K fromKey, boolean inclusive)
```

NavigableMap除了继承SortedMap的特性外，它的提供的功能可以分为4类：

* 第1类，提供操作键-值对的方法。lowerEntry、floorEntry、ceilingEntry 和 higherEntry 方法，它们分别返回与小于、小于等于、大于等于、大于给定键的键关联的 Map.Entry 对象。firstEntry、pollFirstEntry、lastEntry 和 pollLastEntry 方法，它们返回和/或移除最小和最大的映射关系（如果存在），否则返回 null。
* 第2类，提供操作键的方法。这个和第1类比较类似lowerKey、floorKey、ceilingKey 和 higherKey 方法，它们分别返回与小于、小于等于、大于等于、大于给定键的键。
* 第3类，获取键集。navigableKeySet、descendingKeySet分别获取正序/反序的键集。
* 第4类，获取键-值对的子集。

## 2.2. HashMap

HashMap 继承于AbstractMap，实现了Map、Cloneable、java.io.Serializable接口。

HashMap 的实现不是同步的，这意味着它不是线程安全的。它的key、value都可以为null。此外，HashMap中的映射不是有序的。

HashMap 的实例有两个参数影响其性能：“初始容量” 和 “加载因子”。

* 容量是哈希表中桶的数量，初始容量只是哈希表在创建时的容量。
* 加载因子是哈希表在其容量自动增加之前可以达到多满的一种尺度。当哈希表中的条目数超出了加载因子与当前容量的乘积时，则要对该哈希表进行 rehash 操作（即重建内部数据结构），从而哈希表将具有大约两倍的桶数。
* 通常，默认加载因子是 0.75, 这是在时间和空间成本上寻求一种折衷。加载因子过高虽然减少了空间开销，但同时也增加了查询成本。

### 2.2.1. 构造函数和API

```java
// 默认构造函数。
HashMap()

// 指定“容量大小”的构造函数
HashMap(int capacity)

// 指定“容量大小”和“加载因子”的构造函数
HashMap(int capacity, float loadFactor)

// 包含“子Map”的构造函数
HashMap(Map<? extends K, ? extends V> map)
```

常用API

```JAVA
void                 clear()
Object               clone()
boolean              containsKey(Object key)
boolean              containsValue(Object value)
Set<Entry<K, V>>     entrySet()
V                    get(Object key)
boolean              isEmpty()
Set<K>               keySet()
V                    put(K key, V value)
void                 putAll(Map<? extends K, ? extends V> map)
V                    remove(Object key)
int                  size()
Collection<V>        values()
```

### 2.2.2. 数据结构

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/hashmap.jpg)

1. HashMap继承于AbstractMap类，实现了Map接口。Map是"key-value键值对"接口，AbstractMap实现了"键值对"的通用函数接口。 
2. HashMap是通过"拉链法"实现的哈希表。它包括几个重要的成员变量：table, size, threshold, loadFactor, modCount。
　　
* table是一个Entry[]数组类型，而Entry实际上就是一个单向链表。哈希表的"key-value键值对"都是存储在Entry数组中的。 
* size是HashMap的大小，它是HashMap保存的键值对的数量。 
* threshold是HashMap的阈值，用于判断是否需要调整HashMap的容量。threshold的值="容量*加载因子"，当HashMap中存储数据的数量达到threshold时，就需要将HashMap的容量加倍。
* loadFactor就是加载因子。 
* modCount是用来实现fail-fast机制的。

### 2.2.3. 源码

```java
package java.util;
import java.io.*;

public class HashMap<K,V>
    extends AbstractMap<K,V>
    implements Map<K,V>, Cloneable, Serializable
{

    // 默认的初始容量是16，必须是2的幂。
    static final int DEFAULT_INITIAL_CAPACITY = 16;

    // 最大容量（必须是2的幂且小于2的30次方，传入容量过大将被这个值替换）
    static final int MAXIMUM_CAPACITY = 1 << 30;

    // 默认加载因子
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    // 存储数据的Entry数组，长度是2的幂。
    // HashMap是采用拉链法实现的，每一个Entry本质上是一个单向链表
    transient Entry[] table;

    // HashMap的大小，它是HashMap保存的键值对的数量
    transient int size;

    // HashMap的阈值，用于判断是否需要调整HashMap的容量（threshold = 容量*加载因子）
    int threshold;

    // 加载因子实际大小
    final float loadFactor;

    // HashMap被改变的次数
    transient volatile int modCount;

    // 指定“容量大小”和“加载因子”的构造函数
    public HashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                                               initialCapacity);
        // HashMap的最大容量只能是MAXIMUM_CAPACITY
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                                               loadFactor);

        // 找出“大于initialCapacity”的最小的2的幂
        int capacity = 1;
        while (capacity < initialCapacity)
            capacity <<= 1;

        // 设置“加载因子”
        this.loadFactor = loadFactor;
        // 设置“HashMap阈值”，当HashMap中存储数据的数量达到threshold时，就需要将HashMap的容量加倍。
        threshold = (int)(capacity * loadFactor);
        // 创建Entry数组，用来保存数据
        table = new Entry[capacity];
        init();
    }


    // 指定“容量大小”的构造函数
    public HashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    // 默认构造函数。
    public HashMap() {
        // 设置“加载因子”
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        // 设置“HashMap阈值”，当HashMap中存储数据的数量达到threshold时，就需要将HashMap的容量加倍。
        threshold = (int)(DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        // 创建Entry数组，用来保存数据
        table = new Entry[DEFAULT_INITIAL_CAPACITY];
        init();
    }

    // 包含“子Map”的构造函数
    public HashMap(Map<? extends K, ? extends V> m) {
        this(Math.max((int) (m.size() / DEFAULT_LOAD_FACTOR) + 1,
                      DEFAULT_INITIAL_CAPACITY), DEFAULT_LOAD_FACTOR);
        // 将m中的全部元素逐个添加到HashMap中
        putAllForCreate(m);
    }

    static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    // 返回索引值
    // h & (length-1)保证返回值的小于length
    static int indexFor(int h, int length) {
        return h & (length-1);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 获取key对应的value
    public V get(Object key) {
        if (key == null)
            return getForNullKey();
        // 获取key的hash值
        int hash = hash(key.hashCode());
        // 在“该hash值对应的链表”上查找“键值等于key”的元素
        for (Entry<K,V> e = table[indexFor(hash, table.length)];
             e != null;
             e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k)))
                return e.value;
        }
        return null;
    }

    // 获取“key为null”的元素的值
    // HashMap将“key为null”的元素存储在table[0]位置！
    private V getForNullKey() {
        for (Entry<K,V> e = table[0]; e != null; e = e.next) {
            if (e.key == null)
                return e.value;
        }
        return null;
    }

    // HashMap是否包含key
    public boolean containsKey(Object key) {
        return getEntry(key) != null;
    }

    // 返回“键为key”的键值对
    final Entry<K,V> getEntry(Object key) {
        // 获取哈希值
        // HashMap将“key为null”的元素存储在table[0]位置，“key不为null”的则调用hash()计算哈希值
        int hash = (key == null) ? 0 : hash(key.hashCode());
        // 在“该hash值对应的链表”上查找“键值等于key”的元素
        for (Entry<K,V> e = table[indexFor(hash, table.length)];
             e != null;
             e = e.next) {
            Object k;
            if (e.hash == hash &&
                ((k = e.key) == key || (key != null && key.equals(k))))
                return e;
        }
        return null;
    }

    // 将“key-value”添加到HashMap中
    public V put(K key, V value) {
        // 若“key为null”，则将该键值对添加到table[0]中。
        if (key == null)
            return putForNullKey(value);
        // 若“key不为null”，则计算该key的哈希值，然后将其添加到该哈希值对应的链表中。
        int hash = hash(key.hashCode());
        int i = indexFor(hash, table.length);
        for (Entry<K,V> e = table[i]; e != null; e = e.next) {
            Object k;
            // 若“该key”对应的键值对已经存在，则用新的value取代旧的value。然后退出！
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }

        // 若“该key”对应的键值对不存在，则将“key-value”添加到table中
        modCount++;
        addEntry(hash, key, value, i);
        return null;
    }

    // putForNullKey()的作用是将“key为null”键值对添加到table[0]位置
    private V putForNullKey(V value) {
        for (Entry<K,V> e = table[0]; e != null; e = e.next) {
            if (e.key == null) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }
        // 这里的完全不会被执行到!
        modCount++;
        addEntry(0, null, value, 0);
        return null;
    }

    // 创建HashMap对应的“添加方法”，
    // 它和put()不同。putForCreate()是内部方法，它被构造函数等调用，用来创建HashMap
    // 而put()是对外提供的往HashMap中添加元素的方法。
    private void putForCreate(K key, V value) {
        int hash = (key == null) ? 0 : hash(key.hashCode());
        int i = indexFor(hash, table.length);

        // 若该HashMap表中存在“键值等于key”的元素，则替换该元素的value值
        for (Entry<K,V> e = table[i]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash &&
                ((k = e.key) == key || (key != null && key.equals(k)))) {
                e.value = value;
                return;
            }
        }

        // 若该HashMap表中不存在“键值等于key”的元素，则将该key-value添加到HashMap中
        createEntry(hash, key, value, i);
    }

    // 将“m”中的全部元素都添加到HashMap中。
    // 该方法被内部的构造HashMap的方法所调用。
    private void putAllForCreate(Map<? extends K, ? extends V> m) {
        // 利用迭代器将元素逐个添加到HashMap中
        for (Iterator<? extends Map.Entry<? extends K, ? extends V>> i = m.entrySet().iterator(); i.hasNext(); ) {
            Map.Entry<? extends K, ? extends V> e = i.next();
            putForCreate(e.getKey(), e.getValue());
        }
    }

    // 重新调整HashMap的大小，newCapacity是调整后的单位
    void resize(int newCapacity) {
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return;
        }

        // 新建一个HashMap，将“旧HashMap”的全部元素添加到“新HashMap”中，
        // 然后，将“新HashMap”赋值给“旧HashMap”。
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int)(newCapacity * loadFactor);
    }

    // 将HashMap中的全部元素都添加到newTable中
    void transfer(Entry[] newTable) {
        Entry[] src = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            Entry<K,V> e = src[j];
            if (e != null) {
                src[j] = null;
                do {
                    Entry<K,V> next = e.next;
                    int i = indexFor(e.hash, newCapacity);
                    e.next = newTable[i];
                    newTable[i] = e;
                    e = next;
                } while (e != null);
            }
        }
    }

    // 将"m"的全部元素都添加到HashMap中
    public void putAll(Map<? extends K, ? extends V> m) {
        // 有效性判断
        int numKeysToBeAdded = m.size();
        if (numKeysToBeAdded == 0)
            return;

        // 计算容量是否足够，
        // 若“当前实际容量 < 需要的容量”，则将容量x2。
        if (numKeysToBeAdded > threshold) {
            int targetCapacity = (int)(numKeysToBeAdded / loadFactor + 1);
            if (targetCapacity > MAXIMUM_CAPACITY)
                targetCapacity = MAXIMUM_CAPACITY;
            int newCapacity = table.length;
            while (newCapacity < targetCapacity)
                newCapacity <<= 1;
            if (newCapacity > table.length)
                resize(newCapacity);
        }

        // 通过迭代器，将“m”中的元素逐个添加到HashMap中。
        for (Iterator<? extends Map.Entry<? extends K, ? extends V>> i = m.entrySet().iterator(); i.hasNext(); ) {
            Map.Entry<? extends K, ? extends V> e = i.next();
            put(e.getKey(), e.getValue());
        }
    }

    // 删除“键为key”元素
    public V remove(Object key) {
        Entry<K,V> e = removeEntryForKey(key);
        return (e == null ? null : e.value);
    }

    // 删除“键为key”的元素
    final Entry<K,V> removeEntryForKey(Object key) {
        // 获取哈希值。若key为null，则哈希值为0；否则调用hash()进行计算
        int hash = (key == null) ? 0 : hash(key.hashCode());
        int i = indexFor(hash, table.length);
        Entry<K,V> prev = table[i];
        Entry<K,V> e = prev;

        // 删除链表中“键为key”的元素
        // 本质是“删除单向链表中的节点”
        while (e != null) {
            Entry<K,V> next = e.next;
            Object k;
            if (e.hash == hash &&
                ((k = e.key) == key || (key != null && key.equals(k)))) {
                modCount++;
                size--;
                if (prev == e)
                    table[i] = next;
                else
                    prev.next = next;
                e.recordRemoval(this);
                return e;
            }
            prev = e;
            e = next;
        }

        return e;
    }

    // 删除“键值对”
    final Entry<K,V> removeMapping(Object o) {
        if (!(o instanceof Map.Entry))
            return null;

        Map.Entry<K,V> entry = (Map.Entry<K,V>) o;
        Object key = entry.getKey();
        int hash = (key == null) ? 0 : hash(key.hashCode());
        int i = indexFor(hash, table.length);
        Entry<K,V> prev = table[i];
        Entry<K,V> e = prev;

        // 删除链表中的“键值对e”
        // 本质是“删除单向链表中的节点”
        while (e != null) {
            Entry<K,V> next = e.next;
            if (e.hash == hash && e.equals(entry)) {
                modCount++;
                size--;
                if (prev == e)
                    table[i] = next;
                else
                    prev.next = next;
                e.recordRemoval(this);
                return e;
            }
            prev = e;
            e = next;
        }

        return e;
    }

    // 清空HashMap，将所有的元素设为null
    public void clear() {
        modCount++;
        Entry[] tab = table;
        for (int i = 0; i < tab.length; i++)
            tab[i] = null;
        size = 0;
    }

    // 是否包含“值为value”的元素
    public boolean containsValue(Object value) {
    // 若“value为null”，则调用containsNullValue()查找
    if (value == null)
            return containsNullValue();

    // 若“value不为null”，则查找HashMap中是否有值为value的节点。
    Entry[] tab = table;
        for (int i = 0; i < tab.length ; i++)
            for (Entry e = tab[i] ; e != null ; e = e.next)
                if (value.equals(e.value))
                    return true;
    return false;
    }

    // 是否包含null值
    private boolean containsNullValue() {
    Entry[] tab = table;
        for (int i = 0; i < tab.length ; i++)
            for (Entry e = tab[i] ; e != null ; e = e.next)
                if (e.value == null)
                    return true;
    return false;
    }

    // 克隆一个HashMap，并返回Object对象
    public Object clone() {
        HashMap<K,V> result = null;
        try {
            result = (HashMap<K,V>)super.clone();
        } catch (CloneNotSupportedException e) {
            // assert false;
        }
        result.table = new Entry[table.length];
        result.entrySet = null;
        result.modCount = 0;
        result.size = 0;
        result.init();
        // 调用putAllForCreate()将全部元素添加到HashMap中
        result.putAllForCreate(this);

        return result;
    }

    // Entry是单向链表。
    // 它是 “HashMap链式存储法”对应的链表。
    // 它实现了Map.Entry 接口，即实现getKey(), getValue(), setValue(V value), equals(Object o), hashCode()这些函数
    static class Entry<K,V> implements Map.Entry<K,V> {
        final K key;
        V value;
        // 指向下一个节点
        Entry<K,V> next;
        final int hash;

        // 构造函数。
        // 输入参数包括"哈希值(h)", "键(k)", "值(v)", "下一节点(n)"
        Entry(int h, K k, V v, Entry<K,V> n) {
            value = v;
            next = n;
            key = k;
            hash = h;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        // 判断两个Entry是否相等
        // 若两个Entry的“key”和“value”都相等，则返回true。
        // 否则，返回false
        public final boolean equals(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry e = (Map.Entry)o;
            Object k1 = getKey();
            Object k2 = e.getKey();
            if (k1 == k2 || (k1 != null && k1.equals(k2))) {
                Object v1 = getValue();
                Object v2 = e.getValue();
                if (v1 == v2 || (v1 != null && v1.equals(v2)))
                    return true;
            }
            return false;
        }

        // 实现hashCode()
        public final int hashCode() {
            return (key==null   ? 0 : key.hashCode()) ^
                   (value==null ? 0 : value.hashCode());
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }

        // 当向HashMap中添加元素时，绘调用recordAccess()。
        // 这里不做任何处理
        void recordAccess(HashMap<K,V> m) {
        }

        // 当从HashMap中删除元素时，绘调用recordRemoval()。
        // 这里不做任何处理
        void recordRemoval(HashMap<K,V> m) {
        }
    }

    // 新增Entry。将“key-value”插入指定位置，bucketIndex是位置索引。
    void addEntry(int hash, K key, V value, int bucketIndex) {
        // 保存“bucketIndex”位置的值到“e”中
        Entry<K,V> e = table[bucketIndex];
        // 设置“bucketIndex”位置的元素为“新Entry”，
        // 设置“e”为“新Entry的下一个节点”
        table[bucketIndex] = new Entry<K,V>(hash, key, value, e);
        // 若HashMap的实际大小 不小于 “阈值”，则调整HashMap的大小
        if (size++ >= threshold)
            resize(2 * table.length);
    }

    // 创建Entry。将“key-value”插入指定位置，bucketIndex是位置索引。
    // 它和addEntry的区别是：
    // (01) addEntry()一般用在 新增Entry可能导致“HashMap的实际容量”超过“阈值”的情况下。
    //   例如，我们新建一个HashMap，然后不断通过put()向HashMap中添加元素；
    // put()是通过addEntry()新增Entry的。
    //   在这种情况下，我们不知道何时“HashMap的实际容量”会超过“阈值”；
    //   因此，需要调用addEntry()
    // (02) createEntry() 一般用在 新增Entry不会导致“HashMap的实际容量”超过“阈值”的情况下。
    //   例如，我们调用HashMap“带有Map”的构造函数，它绘将Map的全部元素添加到HashMap中；
    // 但在添加之前，我们已经计算好“HashMap的容量和阈值”。也就是，可以确定“即使将Map中
    // 的全部元素添加到HashMap中，都不会超过HashMap的阈值”。
    //   此时，调用createEntry()即可。
    void createEntry(int hash, K key, V value, int bucketIndex) {
        // 保存“bucketIndex”位置的值到“e”中
        Entry<K,V> e = table[bucketIndex];
        // 设置“bucketIndex”位置的元素为“新Entry”，
        // 设置“e”为“新Entry的下一个节点”
        table[bucketIndex] = new Entry<K,V>(hash, key, value, e);
        size++;
    }

    // HashIterator是HashMap迭代器的抽象出来的父类，实现了公共了函数。
    // 它包含“key迭代器(KeyIterator)”、“Value迭代器(ValueIterator)”和“Entry迭代器(EntryIterator)”3个子类。
    private abstract class HashIterator<E> implements Iterator<E> {
        // 下一个元素
        Entry<K,V> next;
        // expectedModCount用于实现fast-fail机制。
        int expectedModCount;
        // 当前索引
        int index;
        // 当前元素
        Entry<K,V> current;

        HashIterator() {
            expectedModCount = modCount;
            if (size > 0) { // advance to first entry
                Entry[] t = table;
                // 将next指向table中第一个不为null的元素。
                // 这里利用了index的初始值为0，从0开始依次向后遍历，直到找到不为null的元素就退出循环。
                while (index < t.length && (next = t[index++]) == null)
                    ;
            }
        }

        public final boolean hasNext() {
            return next != null;
        }

        // 获取下一个元素
        final Entry<K,V> nextEntry() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            Entry<K,V> e = next;
            if (e == null)
                throw new NoSuchElementException();

            // 注意！！！
            // 一个Entry就是一个单向链表
            // 若该Entry的下一个节点不为空，就将next指向下一个节点;
            // 否则，将next指向下一个链表(也是下一个Entry)的不为null的节点。
            if ((next = e.next) == null) {
                Entry[] t = table;
                while (index < t.length && (next = t[index++]) == null)
                    ;
            }
            current = e;
            return e;
        }

        // 删除当前元素
        public void remove() {
            if (current == null)
                throw new IllegalStateException();
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            Object k = current.key;
            current = null;
            HashMap.this.removeEntryForKey(k);
            expectedModCount = modCount;
        }

    }

    // value的迭代器
    private final class ValueIterator extends HashIterator<V> {
        public V next() {
            return nextEntry().value;
        }
    }

    // key的迭代器
    private final class KeyIterator extends HashIterator<K> {
        public K next() {
            return nextEntry().getKey();
        }
    }

    // Entry的迭代器
    private final class EntryIterator extends HashIterator<Map.Entry<K,V>> {
        public Map.Entry<K,V> next() {
            return nextEntry();
        }
    }

    // 返回一个“key迭代器”
    Iterator<K> newKeyIterator()   {
        return new KeyIterator();
    }
    // 返回一个“value迭代器”
    Iterator<V> newValueIterator()   {
        return new ValueIterator();
    }
    // 返回一个“entry迭代器”
    Iterator<Map.Entry<K,V>> newEntryIterator()   {
        return new EntryIterator();
    }

    // HashMap的Entry对应的集合
    private transient Set<Map.Entry<K,V>> entrySet = null;

    // 返回“key的集合”，实际上返回一个“KeySet对象”
    public Set<K> keySet() {
        Set<K> ks = keySet;
        return (ks != null ? ks : (keySet = new KeySet()));
    }

    // Key对应的集合
    // KeySet继承于AbstractSet，说明该集合中没有重复的Key。
    private final class KeySet extends AbstractSet<K> {
        public Iterator<K> iterator() {
            return newKeyIterator();
        }
        public int size() {
            return size;
        }
        public boolean contains(Object o) {
            return containsKey(o);
        }
        public boolean remove(Object o) {
            return HashMap.this.removeEntryForKey(o) != null;
        }
        public void clear() {
            HashMap.this.clear();
        }
    }

    // 返回“value集合”，实际上返回的是一个Values对象
    public Collection<V> values() {
        Collection<V> vs = values;
        return (vs != null ? vs : (values = new Values()));
    }

    // “value集合”
    // Values继承于AbstractCollection，不同于“KeySet继承于AbstractSet”，
    // Values中的元素能够重复。因为不同的key可以指向相同的value。
    private final class Values extends AbstractCollection<V> {
        public Iterator<V> iterator() {
            return newValueIterator();
        }
        public int size() {
            return size;
        }
        public boolean contains(Object o) {
            return containsValue(o);
        }
        public void clear() {
            HashMap.this.clear();
        }
    }

    // 返回“HashMap的Entry集合”
    public Set<Map.Entry<K,V>> entrySet() {
        return entrySet0();
    }

    // 返回“HashMap的Entry集合”，它实际是返回一个EntrySet对象
    private Set<Map.Entry<K,V>> entrySet0() {
        Set<Map.Entry<K,V>> es = entrySet;
        return es != null ? es : (entrySet = new EntrySet());
    }

    // EntrySet对应的集合
    // EntrySet继承于AbstractSet，说明该集合中没有重复的EntrySet。
    private final class EntrySet extends AbstractSet<Map.Entry<K,V>> {
        public Iterator<Map.Entry<K,V>> iterator() {
            return newEntryIterator();
        }
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<K,V> e = (Map.Entry<K,V>) o;
            Entry<K,V> candidate = getEntry(e.getKey());
            return candidate != null && candidate.equals(e);
        }
        public boolean remove(Object o) {
            return removeMapping(o) != null;
        }
        public int size() {
            return size;
        }
        public void clear() {
            HashMap.this.clear();
        }
    }

    // java.io.Serializable的写入函数
    // 将HashMap的“总的容量，实际容量，所有的Entry”都写入到输出流中
    private void writeObject(java.io.ObjectOutputStream s)
        throws IOException
    {
        Iterator<Map.Entry<K,V>> i =
            (size > 0) ? entrySet0().iterator() : null;

        // Write out the threshold, loadfactor, and any hidden stuff
        s.defaultWriteObject();

        // Write out number of buckets
        s.writeInt(table.length);

        // Write out size (number of Mappings)
        s.writeInt(size);

        // Write out keys and values (alternating)
        if (i != null) {
            while (i.hasNext()) {
            Map.Entry<K,V> e = i.next();
            s.writeObject(e.getKey());
            s.writeObject(e.getValue());
            }
        }
    }


    private static final long serialVersionUID = 362498820763181265L;

    // java.io.Serializable的读取函数：根据写入方式读出
    // 将HashMap的“总的容量，实际容量，所有的Entry”依次读出
    private void readObject(java.io.ObjectInputStream s)
         throws IOException, ClassNotFoundException
    {
        // Read in the threshold, loadfactor, and any hidden stuff
        s.defaultReadObject();

        // Read in number of buckets and allocate the bucket array;
        int numBuckets = s.readInt();
        table = new Entry[numBuckets];

        init();  // Give subclass a chance to do its thing.

        // Read in size (number of Mappings)
        int size = s.readInt();

        // Read the keys and values, and put the mappings in the HashMap
        for (int i=0; i<size; i++) {
            K key = (K) s.readObject();
            V value = (V) s.readObject();
            putForCreate(key, value);
        }
    }

    // 返回“HashMap总的容量”
    int   capacity()     { return table.length; }
    // 返回“HashMap的加载因子”
    float loadFactor()   { return loadFactor;   }
}
```

### 2.2.4. 存储方式

HashMap中的key-value都是存储在Entry数组中

```java
static class Entry<K,V> implements Map.Entry<K,V> {
    final K key;
    V value;
    // 指向下一个节点
    Entry<K,V> next;
    final int hash;

    // 构造函数。
    // 输入参数包括"哈希值(h)", "键(k)", "值(v)", "下一节点(n)"
    Entry(int h, K k, V v, Entry<K,V> n) {
        value = v;
        next = n;
        key = k;
        hash = h;
    }

    public final K getKey() {
        return key;
    }

    public final V getValue() {
        return value;
    }

    public final V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }

    // 判断两个Entry是否相等
    // 若两个Entry的“key”和“value”都相等，则返回true。
    // 否则，返回false
    public final boolean equals(Object o) {
        if (!(o instanceof Map.Entry))
            return false;
        Map.Entry e = (Map.Entry)o;
        Object k1 = getKey();
        Object k2 = e.getKey();
        if (k1 == k2 || (k1 != null && k1.equals(k2))) {
            Object v1 = getValue();
            Object v2 = e.getValue();
            if (v1 == v2 || (v1 != null && v1.equals(v2)))
                return true;
        }
        return false;
    }

    // 实现hashCode()
    public final int hashCode() {
        return (key==null   ? 0 : key.hashCode()) ^
               (value==null ? 0 : value.hashCode());
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }

    // 当向HashMap中添加元素时，绘调用recordAccess()。
    // 这里不做任何处理
    void recordAccess(HashMap<K,V> m) {
    }

    // 当从HashMap中删除元素时，绘调用recordRemoval()。
    // 这里不做任何处理
    void recordRemoval(HashMap<K,V> m) {
    }
}
```

我们可以看出 Entry 实际上就是一个单向链表。这也是为什么我们说HashMap是通过拉链法解决哈希冲突的

### 2.2.5. 构造方法

```java
// 默认构造函数。
public HashMap() {
    // 设置“加载因子”
    this.loadFactor = DEFAULT_LOAD_FACTOR;
    // 设置“HashMap阈值”，当HashMap中存储数据的数量达到threshold时，就需要将HashMap的容量加倍。
    threshold = (int)(DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    // 创建Entry数组，用来保存数据
    table = new Entry[DEFAULT_INITIAL_CAPACITY];
    init();
}

// 指定“容量大小”和“加载因子”的构造函数
public HashMap(int initialCapacity, float loadFactor) {
    if (initialCapacity < 0)
        throw new IllegalArgumentException("Illegal initial capacity: " +
                                           initialCapacity);
    // HashMap的最大容量只能是MAXIMUM_CAPACITY
    if (initialCapacity > MAXIMUM_CAPACITY)
        initialCapacity = MAXIMUM_CAPACITY;
    if (loadFactor <= 0 || Float.isNaN(loadFactor))
        throw new IllegalArgumentException("Illegal load factor: " +
                                           loadFactor);

    // Find a power of 2 >= initialCapacity
    int capacity = 1;
    while (capacity < initialCapacity)
        capacity <<= 1;

    // 设置“加载因子”
    this.loadFactor = loadFactor;
    // 设置“HashMap阈值”，当HashMap中存储数据的数量达到threshold时，就需要将HashMap的容量加倍。
    threshold = (int)(capacity * loadFactor);
    // 创建Entry数组，用来保存数据
    table = new Entry[capacity];
    init();
}

// 指定“容量大小”的构造函数
public HashMap(int initialCapacity) {
    this(initialCapacity, DEFAULT_LOAD_FACTOR);
}

// 包含“子Map”的构造函数
public HashMap(Map<? extends K, ? extends V> m) {
    this(Math.max((int) (m.size() / DEFAULT_LOAD_FACTOR) + 1,
                  DEFAULT_INITIAL_CAPACITY), DEFAULT_LOAD_FACTOR);
    // 将m中的全部元素逐个添加到HashMap中
    putAllForCreate(m);
}
```

### 2.5.6. 常用接口

```java
claer()//清空
containsKey()//判断是否包含key
containsValue()//判断是否包含value
entrySet()//返回所有Entry的集合
get()//获取key对应的value
put()//让hashmap对象可以将键值添加到hashmap中
remove()//删除键为key元素
```

### 2.5.7. 遍历

遍历键值对需要以下步骤：

1. 根据entrySet()获取HashMap的“键值对”的Set集合。
2. 通过Iterator迭代器遍历“第一步”得到的集合。

```java
// 假设map是HashMap对象
// map中的key是String类型，value是Integer类型
Integer integ = null;
Iterator iter = map.entrySet().iterator();
while(iter.hasNext()) {
    Map.Entry entry = (Map.Entry)iter.next();
    // 获取key
    key = (String)entry.getKey();
        // 获取value
    integ = (Integer)entry.getValue();
}
```

遍历键步骤：

1. 根据keySet()获取HashMap的“键”的Set集合。
2. 通过Iterator迭代器遍历“第一步”得到的集合。

```java
// 假设map是HashMap对象
// map中的key是String类型，value是Integer类型
String key = null;
Integer integ = null;
Iterator iter = map.keySet().iterator();
while (iter.hasNext()) {
        // 获取key
    key = (String)iter.next();
        // 根据key，获取value
    integ = (Integer)map.get(key);
}
```

遍历值步骤：

1. 根据value()获取HashMap的“值”的集合。
2. 通过Iterator迭代器遍历“第一步”得到的集合。

```java
// 假设map是HashMap对象
// map中的key是String类型，value是Integer类型
Integer value = null;
Collection c = map.values();
Iterator iter= c.iterator();
while (iter.hasNext()) {
    value = (Integer)iter.next();
}
```

## 2.3.