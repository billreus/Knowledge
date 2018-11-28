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
    - [2.3. Hashtable](#23-hashtable)
        - [2.3.1. 构造函数和API](#231-%E6%9E%84%E9%80%A0%E5%87%BD%E6%95%B0%E5%92%8Capi)
        - [2.3.2. 数据结构](#232-%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84)
        - [2.3.3. 源码](#233-%E6%BA%90%E7%A0%81)
        - [2.3.4. 对外接口](#234-%E5%AF%B9%E5%A4%96%E6%8E%A5%E5%8F%A3)
        - [2.3.5. 实现接口](#235-%E5%AE%9E%E7%8E%B0%E6%8E%A5%E5%8F%A3)
        - [2.3.6. 遍历](#236-%E9%81%8D%E5%8E%86)
    - [2.4. TreeMap](#24-treemap)
        - [2.4.1. 构造函数和API](#241-%E6%9E%84%E9%80%A0%E5%87%BD%E6%95%B0%E5%92%8Capi)
        - [2.4.2. 数据结构](#242-%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84)
        - [2.4.3. 源码](#243-%E6%BA%90%E7%A0%81)
        - [2.4.4. Entry函数](#244-entry%E5%87%BD%E6%95%B0)
        - [2.4.5. 遍历方式](#245-%E9%81%8D%E5%8E%86%E6%96%B9%E5%BC%8F)
    - [2.5. WeakHashMap](#25-weakhashmap)
        - [2.5.1. 构造函数和API](#251-%E6%9E%84%E9%80%A0%E5%87%BD%E6%95%B0%E5%92%8Capi)
        - [2.5.2. 数据结构](#252-%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84)
        - [2.5.3. 源码](#253-%E6%BA%90%E7%A0%81)
        - [2.5.4. 遍历](#254-%E9%81%8D%E5%8E%86)
    - [2.6. 总结](#26-%E6%80%BB%E7%BB%93)
    - [2.1. HashMap与Hashtable](#21-hashmap%E4%B8%8Ehashtable)
        - [2.1.1. 相同点](#211-%E7%9B%B8%E5%90%8C%E7%82%B9)
        - [2.1.2. 不同点](#212-%E4%B8%8D%E5%90%8C%E7%82%B9)
    - [2.2. HashMap和WeakHashMap](#22-hashmap%E5%92%8Cweakhashmap)
- [3. Set](#3-set)

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

## 2.3. Hashtable

Hashtable 继承于Dictionary，实现了Map、Cloneable、java.io.Serializable接口。

Hashtable 的函数都是同步的，这意味着它是线程安全的。它的key、value都不可以为null。此外，Hashtable中的映射不是有序的。

### 2.3.1. 构造函数和API

```java
// 默认构造函数。
public Hashtable() 

// 指定“容量大小”的构造函数
public Hashtable(int initialCapacity) 

// 指定“容量大小”和“加载因子”的构造函数
public Hashtable(int initialCapacity, float loadFactor) 

// 包含“子Map”的构造函数
public Hashtable(Map<? extends K, ? extends V> t)

//API
synchronized void                clear()
synchronized Object              clone()
             boolean             contains(Object value)
synchronized boolean             containsKey(Object key)
synchronized boolean             containsValue(Object value)
synchronized Enumeration<V>      elements()
synchronized Set<Entry<K, V>>    entrySet()
synchronized boolean             equals(Object object)
synchronized V                   get(Object key)
synchronized int                 hashCode()
synchronized boolean             isEmpty()
synchronized Set<K>              keySet()
synchronized Enumeration<K>      keys()
synchronized V                   put(K key, V value)
synchronized void                putAll(Map<? extends K, ? extends V> map)
synchronized V                   remove(Object key)
synchronized int                 size()
synchronized String              toString()
synchronized Collection<V>       values()
```

### 2.3.2. 数据结构

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/hashtable.jpg)

1. Hashtable继承于Dictionary类，实现了Map接口。Map是"key-value键值对"接口，Dictionary是声明了操作"键值对"函数接口的抽象类。 
2. Hashtable是通过"拉链法"实现的哈希表。它包括几个重要的成员变量：table, count, threshold, loadFactor, modCount。

* hashtable与hashmap类似，只是继承类是Directionary,而不是AbstractMap。
* Hashtable数据存储数组与hashmap一样也是使用节点Entry实现的。

### 2.3.3. 源码

```JAVA
package java.util;
import java.io.*;

public class Hashtable<K,V>
    extends Dictionary<K,V>
    implements Map<K,V>, Cloneable, java.io.Serializable {

    // Hashtable保存key-value的数组。
    // Hashtable是采用拉链法实现的，每一个Entry本质上是一个单向链表
    private transient Entry[] table;

    // Hashtable中元素的实际数量
    private transient int count;

    // 阈值，用于判断是否需要调整Hashtable的容量（threshold = 容量*加载因子）
    private int threshold;

    // 加载因子
    private float loadFactor;

    // Hashtable被改变的次数
    private transient int modCount = 0;

    // 序列版本号
    private static final long serialVersionUID = 1421746759512286392L;

    // 指定“容量大小”和“加载因子”的构造函数
    public Hashtable(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal Load: "+loadFactor);

        if (initialCapacity==0)
            initialCapacity = 1;
        this.loadFactor = loadFactor;
        table = new Entry[initialCapacity];
        threshold = (int)(initialCapacity * loadFactor);
    }

    // 指定“容量大小”的构造函数
    public Hashtable(int initialCapacity) {
        this(initialCapacity, 0.75f);
    }

    // 默认构造函数。
    public Hashtable() {
        // 默认构造函数，指定的容量大小是11；加载因子是0.75
        this(11, 0.75f);
    }

    // 包含“子Map”的构造函数
    public Hashtable(Map<? extends K, ? extends V> t) {
        this(Math.max(2*t.size(), 11), 0.75f);
        // 将“子Map”的全部元素都添加到Hashtable中
        putAll(t);
    }

    public synchronized int size() {
        return count;
    }

    public synchronized boolean isEmpty() {
        return count == 0;
    }

    // 返回“所有key”的枚举对象
    public synchronized Enumeration<K> keys() {
        return this.<K>getEnumeration(KEYS);
    }

    // 返回“所有value”的枚举对象
    public synchronized Enumeration<V> elements() {
        return this.<V>getEnumeration(VALUES);
    }

    // 判断Hashtable是否包含“值(value)”
    public synchronized boolean contains(Object value) {
        // Hashtable中“键值对”的value不能是null，
        // 若是null的话，抛出异常!
        if (value == null) {
            throw new NullPointerException();
        }

        // 从后向前遍历table数组中的元素(Entry)
        // 对于每个Entry(单向链表)，逐个遍历，判断节点的值是否等于value
        Entry tab[] = table;
        for (int i = tab.length ; i-- > 0 ;) {
            for (Entry<K,V> e = tab[i] ; e != null ; e = e.next) {
                if (e.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsValue(Object value) {
        return contains(value);
    }

    // 判断Hashtable是否包含key
    public synchronized boolean containsKey(Object key) {
        Entry tab[] = table;
        int hash = key.hashCode();
        // 计算索引值，
        // % tab.length 的目的是防止数据越界
        int index = (hash & 0x7FFFFFFF) % tab.length;
        // 找到“key对应的Entry(链表)”，然后在链表中找出“哈希值”和“键值”与key都相等的元素
        for (Entry<K,V> e = tab[index] ; e != null ; e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    // 返回key对应的value，没有的话返回null
    public synchronized V get(Object key) {
        Entry tab[] = table;
        int hash = key.hashCode();
        // 计算索引值，
        int index = (hash & 0x7FFFFFFF) % tab.length;
        // 找到“key对应的Entry(链表)”，然后在链表中找出“哈希值”和“键值”与key都相等的元素
        for (Entry<K,V> e = tab[index] ; e != null ; e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {
                return e.value;
            }
        }
        return null;
    }

    // 调整Hashtable的长度，将长度变成原来的(2倍+1)
    // (01) 将“旧的Entry数组”赋值给一个临时变量。
    // (02) 创建一个“新的Entry数组”，并赋值给“旧的Entry数组”
    // (03) 将“Hashtable”中的全部元素依次添加到“新的Entry数组”中
    protected void rehash() {
        int oldCapacity = table.length;
        Entry[] oldMap = table;

        int newCapacity = oldCapacity * 2 + 1;
        Entry[] newMap = new Entry[newCapacity];

        modCount++;
        threshold = (int)(newCapacity * loadFactor);
        table = newMap;

        for (int i = oldCapacity ; i-- > 0 ;) {
            for (Entry<K,V> old = oldMap[i] ; old != null ; ) {
                Entry<K,V> e = old;
                old = old.next;

                int index = (e.hash & 0x7FFFFFFF) % newCapacity;
                e.next = newMap[index];
                newMap[index] = e;
            }
        }
    }

    // 将“key-value”添加到Hashtable中
    public synchronized V put(K key, V value) {
        // Hashtable中不能插入value为null的元素！！！
        if (value == null) {
            throw new NullPointerException();
        }

        // 若“Hashtable中已存在键为key的键值对”，
        // 则用“新的value”替换“旧的value”
        Entry tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        for (Entry<K,V> e = tab[index] ; e != null ; e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {
                V old = e.value;
                e.value = value;
                return old;
                }
        }

        // 若“Hashtable中不存在键为key的键值对”，
        // (01) 将“修改统计数”+1
        modCount++;
        // (02) 若“Hashtable实际容量” > “阈值”(阈值=总的容量 * 加载因子)
        //  则调整Hashtable的大小
        if (count >= threshold) {
            // Rehash the table if the threshold is exceeded
            rehash();

            tab = table;
            index = (hash & 0x7FFFFFFF) % tab.length;
        }

        // (03) 将“Hashtable中index”位置的Entry(链表)保存到e中
        Entry<K,V> e = tab[index];
        // (04) 创建“新的Entry节点”，并将“新的Entry”插入“Hashtable的index位置”，并设置e为“新的Entry”的下一个元素(即“新Entry”为链表表头)。        
        tab[index] = new Entry<K,V>(hash, key, value, e);
        // (05) 将“Hashtable的实际容量”+1
        count++;
        return null;
    }

    // 删除Hashtable中键为key的元素
    public synchronized V remove(Object key) {
        Entry tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        // 找到“key对应的Entry(链表)”
        // 然后在链表中找出要删除的节点，并删除该节点。
        for (Entry<K,V> e = tab[index], prev = null ; e != null ; prev = e, e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {
                modCount++;
                if (prev != null) {
                    prev.next = e.next;
                } else {
                    tab[index] = e.next;
                }
                count--;
                V oldValue = e.value;
                e.value = null;
                return oldValue;
            }
        }
        return null;
    }

    // 将“Map(t)”的中全部元素逐一添加到Hashtable中
    public synchronized void putAll(Map<? extends K, ? extends V> t) {
        for (Map.Entry<? extends K, ? extends V> e : t.entrySet())
            put(e.getKey(), e.getValue());
    }

    // 清空Hashtable
    // 将Hashtable的table数组的值全部设为null
    public synchronized void clear() {
        Entry tab[] = table;
        modCount++;
        for (int index = tab.length; --index >= 0; )
            tab[index] = null;
        count = 0;
    }

    // 克隆一个Hashtable，并以Object的形式返回。
    public synchronized Object clone() {
        try {
            Hashtable<K,V> t = (Hashtable<K,V>) super.clone();
            t.table = new Entry[table.length];
            for (int i = table.length ; i-- > 0 ; ) {
                t.table[i] = (table[i] != null)
                ? (Entry<K,V>) table[i].clone() : null;
            }
            t.keySet = null;
            t.entrySet = null;
            t.values = null;
            t.modCount = 0;
            return t;
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError();
        }
    }

    public synchronized String toString() {
        int max = size() - 1;
        if (max == -1)
            return "{}";

        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<K,V>> it = entrySet().iterator();

        sb.append('{');
        for (int i = 0; ; i++) {
            Map.Entry<K,V> e = it.next();
            K key = e.getKey();
            V value = e.getValue();
            sb.append(key   == this ? "(this Map)" : key.toString());
            sb.append('=');
            sb.append(value == this ? "(this Map)" : value.toString());

            if (i == max)
                return sb.append('}').toString();
            sb.append(", ");
        }
    }

    // 获取Hashtable的枚举类对象
    // 若Hashtable的实际大小为0,则返回“空枚举类”对象；
    // 否则，返回正常的Enumerator的对象。(Enumerator实现了迭代器和枚举两个接口)
    private <T> Enumeration<T> getEnumeration(int type) {
    if (count == 0) {
        return (Enumeration<T>)emptyEnumerator;
    } else {
        return new Enumerator<T>(type, false);
    }
    }

    // 获取Hashtable的迭代器
    // 若Hashtable的实际大小为0,则返回“空迭代器”对象；
    // 否则，返回正常的Enumerator的对象。(Enumerator实现了迭代器和枚举两个接口)
    private <T> Iterator<T> getIterator(int type) {
        if (count == 0) {
            return (Iterator<T>) emptyIterator;
        } else {
            return new Enumerator<T>(type, true);
        }
    }

    // Hashtable的“key的集合”。它是一个Set，意味着没有重复元素
    private transient volatile Set<K> keySet = null;
    // Hashtable的“key-value的集合”。它是一个Set，意味着没有重复元素
    private transient volatile Set<Map.Entry<K,V>> entrySet = null;
    // Hashtable的“key-value的集合”。它是一个Collection，意味着可以有重复元素
    private transient volatile Collection<V> values = null;

    // 返回一个被synchronizedSet封装后的KeySet对象
    // synchronizedSet封装的目的是对KeySet的所有方法都添加synchronized，实现多线程同步
    public Set<K> keySet() {
        if (keySet == null)
            keySet = Collections.synchronizedSet(new KeySet(), this);
        return keySet;
    }

    // Hashtable的Key的Set集合。
    // KeySet继承于AbstractSet，所以，KeySet中的元素没有重复的。
    private class KeySet extends AbstractSet<K> {
        public Iterator<K> iterator() {
            return getIterator(KEYS);
        }
        public int size() {
            return count;
        }
        public boolean contains(Object o) {
            return containsKey(o);
        }
        public boolean remove(Object o) {
            return Hashtable.this.remove(o) != null;
        }
        public void clear() {
            Hashtable.this.clear();
        }
    }

    // 返回一个被synchronizedSet封装后的EntrySet对象
    // synchronizedSet封装的目的是对EntrySet的所有方法都添加synchronized，实现多线程同步
    public Set<Map.Entry<K,V>> entrySet() {
        if (entrySet==null)
            entrySet = Collections.synchronizedSet(new EntrySet(), this);
        return entrySet;
    }

    // Hashtable的Entry的Set集合。
    // EntrySet继承于AbstractSet，所以，EntrySet中的元素没有重复的。
    private class EntrySet extends AbstractSet<Map.Entry<K,V>> {
        public Iterator<Map.Entry<K,V>> iterator() {
            return getIterator(ENTRIES);
        }

        public boolean add(Map.Entry<K,V> o) {
            return super.add(o);
        }

        // 查找EntrySet中是否包含Object(0)
        // 首先，在table中找到o对应的Entry(Entry是一个单向链表)
        // 然后，查找Entry链表中是否存在Object
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry entry = (Map.Entry)o;
            Object key = entry.getKey();
            Entry[] tab = table;
            int hash = key.hashCode();
            int index = (hash & 0x7FFFFFFF) % tab.length;

            for (Entry e = tab[index]; e != null; e = e.next)
                if (e.hash==hash && e.equals(entry))
                    return true;
            return false;
        }

        // 删除元素Object(0)
        // 首先，在table中找到o对应的Entry(Entry是一个单向链表)
        // 然后，删除链表中的元素Object
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<K,V> entry = (Map.Entry<K,V>) o;
            K key = entry.getKey();
            Entry[] tab = table;
            int hash = key.hashCode();
            int index = (hash & 0x7FFFFFFF) % tab.length;

            for (Entry<K,V> e = tab[index], prev = null; e != null;
                 prev = e, e = e.next) {
                if (e.hash==hash && e.equals(entry)) {
                    modCount++;
                    if (prev != null)
                        prev.next = e.next;
                    else
                        tab[index] = e.next;

                    count--;
                    e.value = null;
                    return true;
                }
            }
            return false;
        }

        public int size() {
            return count;
        }

        public void clear() {
            Hashtable.this.clear();
        }
    }

    // 返回一个被synchronizedCollection封装后的ValueCollection对象
    // synchronizedCollection封装的目的是对ValueCollection的所有方法都添加synchronized，实现多线程同步
    public Collection<V> values() {
    if (values==null)
        values = Collections.synchronizedCollection(new ValueCollection(),
                                                        this);
        return values;
    }

    // Hashtable的value的Collection集合。
    // ValueCollection继承于AbstractCollection，所以，ValueCollection中的元素可以重复的。
    private class ValueCollection extends AbstractCollection<V> {
        public Iterator<V> iterator() {
        return getIterator(VALUES);
        }
        public int size() {
            return count;
        }
        public boolean contains(Object o) {
            return containsValue(o);
        }
        public void clear() {
            Hashtable.this.clear();
        }
    }

    // 重新equals()函数
    // 若两个Hashtable的所有key-value键值对都相等，则判断它们两个相等
    public synchronized boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Map))
            return false;
        Map<K,V> t = (Map<K,V>) o;
        if (t.size() != size())
            return false;

        try {
            // 通过迭代器依次取出当前Hashtable的key-value键值对
            // 并判断该键值对，存在于Hashtable(o)中。
            // 若不存在，则立即返回false；否则，遍历完“当前Hashtable”并返回true。
            Iterator<Map.Entry<K,V>> i = entrySet().iterator();
            while (i.hasNext()) {
                Map.Entry<K,V> e = i.next();
                K key = e.getKey();
                V value = e.getValue();
                if (value == null) {
                    if (!(t.get(key)==null && t.containsKey(key)))
                        return false;
                } else {
                    if (!value.equals(t.get(key)))
                        return false;
                }
            }
        } catch (ClassCastException unused)   {
            return false;
        } catch (NullPointerException unused) {
            return false;
        }

        return true;
    }

    // 计算Hashtable的哈希值
    // 若 Hashtable的实际大小为0 或者 加载因子<0，则返回0。
    // 否则，返回“Hashtable中的每个Entry的key和value的异或值 的总和”。
    public synchronized int hashCode() {
        int h = 0;
        if (count == 0 || loadFactor < 0)
            return h;  // Returns zero

        loadFactor = -loadFactor;  // Mark hashCode computation in progress
        Entry[] tab = table;
        for (int i = 0; i < tab.length; i++)
            for (Entry e = tab[i]; e != null; e = e.next)
                h += e.key.hashCode() ^ e.value.hashCode();
        loadFactor = -loadFactor;  // Mark hashCode computation complete

        return h;
    }

    // java.io.Serializable的写入函数
    // 将Hashtable的“总的容量，实际容量，所有的Entry”都写入到输出流中
    private synchronized void writeObject(java.io.ObjectOutputStream s)
        throws IOException
    {
        // Write out the length, threshold, loadfactor
        s.defaultWriteObject();

        // Write out length, count of elements and then the key/value objects
        s.writeInt(table.length);
        s.writeInt(count);
        for (int index = table.length-1; index >= 0; index--) {
            Entry entry = table[index];

            while (entry != null) {
            s.writeObject(entry.key);
            s.writeObject(entry.value);
            entry = entry.next;
            }
        }
    }

    // java.io.Serializable的读取函数：根据写入方式读出
    // 将Hashtable的“总的容量，实际容量，所有的Entry”依次读出
    private void readObject(java.io.ObjectInputStream s)
         throws IOException, ClassNotFoundException
    {
        // Read in the length, threshold, and loadfactor
        s.defaultReadObject();

        // Read the original length of the array and number of elements
        int origlength = s.readInt();
        int elements = s.readInt();

        // Compute new size with a bit of room 5% to grow but
        // no larger than the original size.  Make the length
        // odd if it's large enough, this helps distribute the entries.
        // Guard against the length ending up zero, that's not valid.
        int length = (int)(elements * loadFactor) + (elements / 20) + 3;
        if (length > elements && (length & 1) == 0)
            length--;
        if (origlength > 0 && length > origlength)
            length = origlength;

        Entry[] table = new Entry[length];
        count = 0;

        // Read the number of elements and then all the key/value objects
        for (; elements > 0; elements--) {
            K key = (K)s.readObject();
            V value = (V)s.readObject();
                // synch could be eliminated for performance
                reconstitutionPut(table, key, value);
        }
        this.table = table;
    }

    private void reconstitutionPut(Entry[] tab, K key, V value)
        throws StreamCorruptedException
    {
        if (value == null) {
            throw new java.io.StreamCorruptedException();
        }
        // Makes sure the key is not already in the hashtable.
        // This should not happen in deserialized version.
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        for (Entry<K,V> e = tab[index] ; e != null ; e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {
                throw new java.io.StreamCorruptedException();
            }
        }
        // Creates the new entry.
        Entry<K,V> e = tab[index];
        tab[index] = new Entry<K,V>(hash, key, value, e);
        count++;
    }

    // Hashtable的Entry节点，它本质上是一个单向链表。
    // 也因此，我们才能推断出Hashtable是由拉链法实现的散列表
    private static class Entry<K,V> implements Map.Entry<K,V> {
        // 哈希值
        int hash;
        K key;
        V value;
        // 指向的下一个Entry，即链表的下一个节点
        Entry<K,V> next;

        // 构造函数
        protected Entry(int hash, K key, V value, Entry<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        protected Object clone() {
            return new Entry<K,V>(hash, key, value,
                  (next==null ? null : (Entry<K,V>) next.clone()));
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        // 设置value。若value是null，则抛出异常。
        public V setValue(V value) {
            if (value == null)
                throw new NullPointerException();

            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        // 覆盖equals()方法，判断两个Entry是否相等。
        // 若两个Entry的key和value都相等，则认为它们相等。
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry e = (Map.Entry)o;

            return (key==null ? e.getKey()==null : key.equals(e.getKey())) &&
               (value==null ? e.getValue()==null : value.equals(e.getValue()));
        }

        public int hashCode() {
            return hash ^ (value==null ? 0 : value.hashCode());
        }

        public String toString() {
            return key.toString()+"="+value.toString();
        }
    }

    private static final int KEYS = 0;
    private static final int VALUES = 1;
    private static final int ENTRIES = 2;

    // Enumerator的作用是提供了“通过elements()遍历Hashtable的接口” 和 “通过entrySet()遍历Hashtable的接口”。因为，它同时实现了 “Enumerator接口”和“Iterator接口”。
    private class Enumerator<T> implements Enumeration<T>, Iterator<T> {
        // 指向Hashtable的table
        Entry[] table = Hashtable.this.table;
        // Hashtable的总的大小
        int index = table.length;
        Entry<K,V> entry = null;
        Entry<K,V> lastReturned = null;
        int type;

        // Enumerator是 “迭代器(Iterator)” 还是 “枚举类(Enumeration)”的标志
        // iterator为true，表示它是迭代器；否则，是枚举类。
        boolean iterator;

        // 在将Enumerator当作迭代器使用时会用到，用来实现fail-fast机制。
        protected int expectedModCount = modCount;

        Enumerator(int type, boolean iterator) {
            this.type = type;
            this.iterator = iterator;
        }

        // 从遍历table的数组的末尾向前查找，直到找到不为null的Entry。
        public boolean hasMoreElements() {
            Entry<K,V> e = entry;
            int i = index;
            Entry[] t = table;
            /* Use locals for faster loop iteration */
            while (e == null && i > 0) {
                e = t[--i];
            }
            entry = e;
            index = i;
            return e != null;
        }

        // 获取下一个元素
        // 注意：从hasMoreElements() 和nextElement() 可以看出“Hashtable的elements()遍历方式”
        // 首先，从后向前的遍历table数组。table数组的每个节点都是一个单向链表(Entry)。
        // 然后，依次向后遍历单向链表Entry。
        public T nextElement() {
            Entry<K,V> et = entry;
            int i = index;
            Entry[] t = table;
            /* Use locals for faster loop iteration */
            while (et == null && i > 0) {
                et = t[--i];
            }
            entry = et;
            index = i;
            if (et != null) {
                Entry<K,V> e = lastReturned = entry;
                entry = e.next;
                return type == KEYS ? (T)e.key : (type == VALUES ? (T)e.value : (T)e);
            }
            throw new NoSuchElementException("Hashtable Enumerator");
        }

        // 迭代器Iterator的判断是否存在下一个元素
        // 实际上，它是调用的hasMoreElements()
        public boolean hasNext() {
            return hasMoreElements();
        }

        // 迭代器获取下一个元素
        // 实际上，它是调用的nextElement()
        public T next() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            return nextElement();
        }

        // 迭代器的remove()接口。
        // 首先，它在table数组中找出要删除元素所在的Entry，
        // 然后，删除单向链表Entry中的元素。
        public void remove() {
            if (!iterator)
                throw new UnsupportedOperationException();
            if (lastReturned == null)
                throw new IllegalStateException("Hashtable Enumerator");
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();

            synchronized(Hashtable.this) {
                Entry[] tab = Hashtable.this.table;
                int index = (lastReturned.hash & 0x7FFFFFFF) % tab.length;

                for (Entry<K,V> e = tab[index], prev = null; e != null;
                     prev = e, e = e.next) {
                    if (e == lastReturned) {
                        modCount++;
                        expectedModCount++;
                        if (prev == null)
                            tab[index] = e.next;
                        else
                            prev.next = e.next;
                        count--;
                        lastReturned = null;
                        return;
                    }
                }
                throw new ConcurrentModificationException();
            }
        }
    }


    private static Enumeration emptyEnumerator = new EmptyEnumerator();
    private static Iterator emptyIterator = new EmptyIterator();

    // 空枚举类
    // 当Hashtable的实际大小为0；此时，又要通过Enumeration遍历Hashtable时，返回的是“空枚举类”的对象。
    private static class EmptyEnumerator implements Enumeration<Object> {

        EmptyEnumerator() {
        }

        // 空枚举类的hasMoreElements() 始终返回false
        public boolean hasMoreElements() {
            return false;
        }

        // 空枚举类的nextElement() 抛出异常
        public Object nextElement() {
            throw new NoSuchElementException("Hashtable Enumerator");
        }
    }


    // 空迭代器
    // 当Hashtable的实际大小为0；此时，又要通过迭代器遍历Hashtable时，返回的是“空迭代器”的对象。
    private static class EmptyIterator implements Iterator<Object> {

        EmptyIterator() {
        }

        public boolean hasNext() {
            return false;
        }

        public Object next() {
            throw new NoSuchElementException("Hashtable Iterator");
        }

        public void remove() {
            throw new IllegalStateException("Hashtable Iterator");
        }

    }
}
```

和Hashmap一样，Hashtable也是一个散列表，它也是通过“拉链法”解决哈希冲突的

### 2.3.4. 对外接口

```java
clear() //清空hasbtale
contains(),containsValue() //判断是否包含值value
containsKey()//是否包含key
elements()//返回所有value的枚举对象
get()//获取key对应的value
put()//添加key-value
putAll()//全部元素添加
remove()//删除表中为key的元素
```

### 2.3.5. 实现接口

Cloneable接口

```java
// 克隆一个Hashtable，并以Object的形式返回。
public synchronized Object clone() {
    try {
        Hashtable<K,V> t = (Hashtable<K,V>) super.clone();
        t.table = new Entry[table.length];
        for (int i = table.length ; i-- > 0 ; ) {
            t.table[i] = (table[i] != null)
            ? (Entry<K,V>) table[i].clone() : null;
        }
        t.keySet = null;
        t.entrySet = null;
        t.values = null;
        t.modCount = 0;
        return t;
    } catch (CloneNotSupportedException e) {
        // this shouldn't happen, since we are Cloneable
        throw new InternalError();
    }
}
```

Serializable接口，实现串行读取写入。

* 串行写入函数就是将Hashtable的“总的容量，实际容量，所有的Entry”都写入到输出流中
* 串行读取函数就是根据写入方式读出将Hashtable的“总的容量，实际容量，所有的Entry”依次读出

```java
private synchronized void writeObject(java.io.ObjectOutputStream s)
    throws IOException
{
    // Write out the length, threshold, loadfactor
    s.defaultWriteObject();

    // Write out length, count of elements and then the key/value objects
    s.writeInt(table.length);
    s.writeInt(count);
    for (int index = table.length-1; index >= 0; index--) {
        Entry entry = table[index];

        while (entry != null) {
        s.writeObject(entry.key);
        s.writeObject(entry.value);
        entry = entry.next;
        }
    }
}

private void readObject(java.io.ObjectInputStream s)
     throws IOException, ClassNotFoundException
{
    // Read in the length, threshold, and loadfactor
    s.defaultReadObject();

    // Read the original length of the array and number of elements
    int origlength = s.readInt();
    int elements = s.readInt();

    // Compute new size with a bit of room 5% to grow but
    // no larger than the original size.  Make the length
    // odd if it's large enough, this helps distribute the entries.
    // Guard against the length ending up zero, that's not valid.
    int length = (int)(elements * loadFactor) + (elements / 20) + 3;
    if (length > elements && (length & 1) == 0)
        length--;
    if (origlength > 0 && length > origlength)
        length = origlength;

    Entry[] table = new Entry[length];
    count = 0;

    // Read the number of elements and then all the key/value objects
    for (; elements > 0; elements--) {
        K key = (K)s.readObject();
        V value = (V)s.readObject();
            // synch could be eliminated for performance
            reconstitutionPut(table, key, value);
    }
    this.table = table;
}
```

### 2.3.6. 遍历

遍历键值对

1. 根据entrySet()获取Hashtable的“键值对”的Set集合。
2. 通过Iterator迭代器遍历“第一步”得到的集合。

```java
// 假设table是Hashtable对象
// table中的key是String类型，value是Integer类型
Integer integ = null;
Iterator iter = table.entrySet().iterator();
while(iter.hasNext()) {
    Map.Entry entry = (Map.Entry)iter.next();
    // 获取key
    key = (String)entry.getKey();
        // 获取value
    integ = (Integer)entry.getValue();
}
```

Iterator遍历键

1. 根据keySet()获取Hashtable的“键”的Set集合。
2. 通过Iterator迭代器遍历“第一步”得到的集合。

```java
// 假设table是Hashtable对象
// table中的key是String类型，value是Integer类型
String key = null;
Integer integ = null;
Iterator iter = table.keySet().iterator();
while (iter.hasNext()) {
        // 获取key
    key = (String)iter.next();
        // 根据key，获取value
    integ = (Integer)table.get(key);
}
```

Enumeration遍历键

1. 根据keys()获取Hashtable的集合。
2. 通过Enumeration遍历“第一步”得到的集合。

```java
Enumeration enu = table.keys();
while(enu.hasMoreElements()) {
    System.out.println(enu.nextElement());
}   
```

Iterator遍历值

1. 根据value()获取Hashtable的“值”的集合。
2. 通过Iterator迭代器遍历“第一步”得到的集合。

```java
// 假设table是Hashtable对象
// table中的key是String类型，value是Integer类型
Integer value = null;
Collection c = table.values();
Iterator iter= c.iterator();
while (iter.hasNext()) {
    value = (Integer)iter.next();
}
```

Enumeration遍历值

1. 根据elements()获取Hashtable的集合。
2. 通过Enumeration遍历“第一步”得到的集合。

```java
Enumeration enu = table.elements();
while(enu.hasMoreElements()) {
    System.out.println(enu.nextElement());
}
```

## 2.4. TreeMap

TreeMap 是一个有序的key-value集合，它是通过红黑树实现的。

TreeMap 继承于AbstractMap，所以它是一个Map，即一个key-value集合。

TreeMap 实现了NavigableMap接口，意味着它支持一系列的导航方法。比如返回有序的key集合。

TreeMap 实现了Cloneable接口，意味着它能被克隆。

TreeMap 实现了java.io.Serializable接口，意味着它支持序列化。

TreeMap是非同步的。 它的iterator 方法返回的迭代器是fail-fastl的。

### 2.4.1. 构造函数和API

```java
//构造函数
// 默认构造函数。使用该构造函数，TreeMap中的元素按照自然排序进行排列。
TreeMap()

// 创建的TreeMap包含Map
TreeMap(Map<? extends K, ? extends V> copyFrom)

// 指定Tree的比较器
TreeMap(Comparator<? super K> comparator)

// 创建的TreeSet包含copyFrom
TreeMap(SortedMap<K, ? extends V> copyFrom)

//API
Entry<K, V>                ceilingEntry(K key)
K                          ceilingKey(K key)
void                       clear()
Object                     clone()
Comparator<? super K>      comparator()
boolean                    containsKey(Object key)
NavigableSet<K>            descendingKeySet()
NavigableMap<K, V>         descendingMap()
Set<Entry<K, V>>           entrySet()
Entry<K, V>                firstEntry()
K                          firstKey()
Entry<K, V>                floorEntry(K key)
K                          floorKey(K key)
V                          get(Object key)
NavigableMap<K, V>         headMap(K to, boolean inclusive)
SortedMap<K, V>            headMap(K toExclusive)
Entry<K, V>                higherEntry(K key)
K                          higherKey(K key)
boolean                    isEmpty()
Set<K>                     keySet()
Entry<K, V>                lastEntry()
K                          lastKey()
Entry<K, V>                lowerEntry(K key)
K                          lowerKey(K key)
NavigableSet<K>            navigableKeySet()
Entry<K, V>                pollFirstEntry()
Entry<K, V>                pollLastEntry()
V                          put(K key, V value)
V                          remove(Object key)
int                        size()
SortedMap<K, V>            subMap(K fromInclusive, K toExclusive)
NavigableMap<K, V>         subMap(K from, boolean fromInclusive, K to, boolean toInclusive)
NavigableMap<K, V>         tailMap(K from, boolean inclusive)
SortedMap<K, V>            tailMap(K fromInclusive)
```

### 2.4.2. 数据结构

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/treemap.jpg)

* TreeMap实现继承于AbstractMap，并且实现了NavigableMap接口。
* TreeMap的本质是R-B Tree(红黑树)，它包含几个重要的成员变量： root, size, comparator。

### 2.4.3. 源码

```java
package java.util;

public class TreeMap<K,V>
extends AbstractMap<K,V>
implements NavigableMap<K,V>, Cloneable, java.io.Serializable
{

    // 比较器。用来给TreeMap排序
    private final Comparator<? super K> comparator;

    // TreeMap是红黑树实现的，root是红黑书的根节点
    private transient Entry<K,V> root = null;

    // 红黑树的节点总数
    private transient int size = 0;

    // 记录红黑树的修改次数
    private transient int modCount = 0;

    // 默认构造函数
    public TreeMap() {
        comparator = null;
    }

    // 带比较器的构造函数
    public TreeMap(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }

    // 带Map的构造函数，Map会成为TreeMap的子集
    public TreeMap(Map<? extends K, ? extends V> m) {
        comparator = null;
        putAll(m);
    }

    // 带SortedMap的构造函数，SortedMap会成为TreeMap的子集
    public TreeMap(SortedMap<K, ? extends V> m) {
        comparator = m.comparator();
        try {
            buildFromSorted(m.size(), m.entrySet().iterator(), null, null);
        } catch (java.io.IOException cannotHappen) {
        } catch (ClassNotFoundException cannotHappen) {
        }
    }

    public int size() {
        return size;
    }

    // 返回TreeMap中是否保护“键(key)”
    public boolean containsKey(Object key) {
        return getEntry(key) != null;
    }

    // 返回TreeMap中是否保护"值(value)"
    public boolean containsValue(Object value) {
        // getFirstEntry() 是返回红黑树的第一个节点
        // successor(e) 是获取节点e的后继节点
        for (Entry<K,V> e = getFirstEntry(); e != null; e = successor(e))
            if (valEquals(value, e.value))
                return true;
        return false;
    }

    // 获取“键(key)”对应的“值(value)”
    public V get(Object key) {
        // 获取“键”为key的节点(p)
        Entry<K,V> p = getEntry(key);
        // 若节点(p)为null，返回null；否则，返回节点对应的值
        return (p==null ? null : p.value);
    }

    public Comparator<? super K> comparator() {
        return comparator;
    }

    // 获取第一个节点对应的key
    public K firstKey() {
        return key(getFirstEntry());
    }

    // 获取最后一个节点对应的key
    public K lastKey() {
        return key(getLastEntry());
    }

    // 将map中的全部节点添加到TreeMap中
    public void putAll(Map<? extends K, ? extends V> map) {
        // 获取map的大小
        int mapSize = map.size();
        // 如果TreeMap的大小是0,且map的大小不是0,且map是已排序的“key-value对”
        if (size==0 && mapSize!=0 && map instanceof SortedMap) {
            Comparator c = ((SortedMap)map).comparator();
            // 如果TreeMap和map的比较器相等；
            // 则将map的元素全部拷贝到TreeMap中，然后返回！
            if (c == comparator || (c != null && c.equals(comparator))) {
                ++modCount;
                try {
                    buildFromSorted(mapSize, map.entrySet().iterator(),
                                null, null);
                } catch (java.io.IOException cannotHappen) {
                } catch (ClassNotFoundException cannotHappen) {
                }
                return;
            }
        }
        // 调用AbstractMap中的putAll();
        // AbstractMap中的putAll()又会调用到TreeMap的put()
        super.putAll(map);
    }

    // 获取TreeMap中“键”为key的节点
    final Entry<K,V> getEntry(Object key) {
        // 若“比较器”为null，则通过getEntryUsingComparator()获取“键”为key的节点
        if (comparator != null)
            return getEntryUsingComparator(key);
        if (key == null)
            throw new NullPointerException();
        Comparable<? super K> k = (Comparable<? super K>) key;
        // 将p设为根节点
        Entry<K,V> p = root;
        while (p != null) {
            int cmp = k.compareTo(p.key);
            // 若“p的key” < key，则p=“p的左孩子”
            if (cmp < 0)
                p = p.left;
            // 若“p的key” > key，则p=“p的左孩子”
            else if (cmp > 0)
                p = p.right;
            // 若“p的key” = key，则返回节点p
            else
                return p;
        }
        return null;
    }

    // 获取TreeMap中“键”为key的节点(对应TreeMap的比较器不是null的情况)
    final Entry<K,V> getEntryUsingComparator(Object key) {
        K k = (K) key;
        Comparator<? super K> cpr = comparator;
        if (cpr != null) {
            // 将p设为根节点
            Entry<K,V> p = root;
            while (p != null) {
                int cmp = cpr.compare(k, p.key);
                // 若“p的key” < key，则p=“p的左孩子”
                if (cmp < 0)
                    p = p.left;
                // 若“p的key” > key，则p=“p的左孩子”
                else if (cmp > 0)
                    p = p.right;
                // 若“p的key” = key，则返回节点p
                else
                    return p;
            }
        }
        return null;
    }

    // 获取TreeMap中不小于key的最小的节点；
    // 若不存在(即TreeMap中所有节点的键都比key大)，就返回null
    final Entry<K,V> getCeilingEntry(K key) {
        Entry<K,V> p = root;
        while (p != null) {
            int cmp = compare(key, p.key);
            // 情况一：若“p的key” > key。
            // 若 p 存在左孩子，则设 p=“p的左孩子”；
            // 否则，返回p
            if (cmp < 0) {
                if (p.left != null)
                    p = p.left;
                else
                    return p;
            // 情况二：若“p的key” < key。
            } else if (cmp > 0) {
                // 若 p 存在右孩子，则设 p=“p的右孩子”
                if (p.right != null) {
                    p = p.right;
                } else {
                    // 若 p 不存在右孩子，则找出 p 的后继节点，并返回
                    // 注意：这里返回的 “p的后继节点”有2种可能性：第一，null；第二，TreeMap中大于key的最小的节点。
                    //   理解这一点的核心是，getCeilingEntry是从root开始遍历的。
                    //   若getCeilingEntry能走到这一步，那么，它之前“已经遍历过的节点的key”都 > key。
                    //   能理解上面所说的，那么就很容易明白，为什么“p的后继节点”又2种可能性了。
                    Entry<K,V> parent = p.parent;
                    Entry<K,V> ch = p;
                    while (parent != null && ch == parent.right) {
                        ch = parent;
                        parent = parent.parent;
                    }
                    return parent;
                }
            // 情况三：若“p的key” = key。
            } else
                return p;
        }
        return null;
    }

    // 获取TreeMap中不大于key的最大的节点；
    // 若不存在(即TreeMap中所有节点的键都比key小)，就返回null
    // getFloorEntry的原理和getCeilingEntry类似，这里不再多说。
    final Entry<K,V> getFloorEntry(K key) {
        Entry<K,V> p = root;
        while (p != null) {
            int cmp = compare(key, p.key);
            if (cmp > 0) {
                if (p.right != null)
                    p = p.right;
                else
                    return p;
            } else if (cmp < 0) {
                if (p.left != null) {
                    p = p.left;
                } else {
                    Entry<K,V> parent = p.parent;
                    Entry<K,V> ch = p;
                    while (parent != null && ch == parent.left) {
                        ch = parent;
                        parent = parent.parent;
                    }
                    return parent;
                }
            } else
                return p;

        }
        return null;
    }

    // 获取TreeMap中大于key的最小的节点。
    // 若不存在，就返回null。
    //   请参照getCeilingEntry来对getHigherEntry进行理解。
    final Entry<K,V> getHigherEntry(K key) {
        Entry<K,V> p = root;
        while (p != null) {
            int cmp = compare(key, p.key);
            if (cmp < 0) {
                if (p.left != null)
                    p = p.left;
                else
                    return p;
            } else {
                if (p.right != null) {
                    p = p.right;
                } else {
                    Entry<K,V> parent = p.parent;
                    Entry<K,V> ch = p;
                    while (parent != null && ch == parent.right) {
                        ch = parent;
                        parent = parent.parent;
                    }
                    return parent;
                }
            }
        }
        return null;
    }

    // 获取TreeMap中小于key的最大的节点。
    // 若不存在，就返回null。
    //   请参照getCeilingEntry来对getLowerEntry进行理解。
    final Entry<K,V> getLowerEntry(K key) {
        Entry<K,V> p = root;
        while (p != null) {
            int cmp = compare(key, p.key);
            if (cmp > 0) {
                if (p.right != null)
                    p = p.right;
                else
                    return p;
            } else {
                if (p.left != null) {
                    p = p.left;
                } else {
                    Entry<K,V> parent = p.parent;
                    Entry<K,V> ch = p;
                    while (parent != null && ch == parent.left) {
                        ch = parent;
                        parent = parent.parent;
                    }
                    return parent;
                }
            }
        }
        return null;
    }

    // 将“key, value”添加到TreeMap中
    // 理解TreeMap的前提是掌握“红黑树”。
    // 若理解“红黑树中添加节点”的算法，则很容易理解put。
    public V put(K key, V value) {
        Entry<K,V> t = root;
        // 若红黑树为空，则插入根节点
        if (t == null) {
        // TBD:
        // 5045147: (coll) Adding null to an empty TreeSet should
        // throw NullPointerException
        //
        // compare(key, key); // type check
            root = new Entry<K,V>(key, value, null);
            size = 1;
            modCount++;
            return null;
        }
        int cmp;
        Entry<K,V> parent;
        // split comparator and comparable paths
        Comparator<? super K> cpr = comparator;
        // 在二叉树(红黑树是特殊的二叉树)中，找到(key, value)的插入位置。
        // 红黑树是以key来进行排序的，所以这里以key来进行查找。
        if (cpr != null) {
            do {
                parent = t;
                cmp = cpr.compare(key, t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else
                    return t.setValue(value);
            } while (t != null);
        }
        else {
            if (key == null)
                throw new NullPointerException();
            Comparable<? super K> k = (Comparable<? super K>) key;
            do {
                parent = t;
                cmp = k.compareTo(t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else
                    return t.setValue(value);
            } while (t != null);
        }
        // 新建红黑树的节点(e)
        Entry<K,V> e = new Entry<K,V>(key, value, parent);
        if (cmp < 0)
            parent.left = e;
        else
            parent.right = e;
        // 红黑树插入节点后，不再是一颗红黑树；
        // 这里通过fixAfterInsertion的处理，来恢复红黑树的特性。
        fixAfterInsertion(e);
        size++;
        modCount++;
        return null;
    }

    // 删除TreeMap中的键为key的节点，并返回节点的值
    public V remove(Object key) {
        // 找到键为key的节点
        Entry<K,V> p = getEntry(key);
        if (p == null)
            return null;

        // 保存节点的值
        V oldValue = p.value;
        // 删除节点
        deleteEntry(p);
        return oldValue;
    }

    // 清空红黑树
    public void clear() {
        modCount++;
        size = 0;
        root = null;
    }

    // 克隆一个TreeMap，并返回Object对象
    public Object clone() {
        TreeMap<K,V> clone = null;
        try {
            clone = (TreeMap<K,V>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }

        // Put clone into "virgin" state (except for comparator)
        clone.root = null;
        clone.size = 0;
        clone.modCount = 0;
        clone.entrySet = null;
        clone.navigableKeySet = null;
        clone.descendingMap = null;

        // Initialize clone with our mappings
        try {
            clone.buildFromSorted(size, entrySet().iterator(), null, null);
        } catch (java.io.IOException cannotHappen) {
        } catch (ClassNotFoundException cannotHappen) {
        }

        return clone;
    }

    // 获取第一个节点(对外接口)。
    public Map.Entry<K,V> firstEntry() {
        return exportEntry(getFirstEntry());
    }

    // 获取最后一个节点(对外接口)。
    public Map.Entry<K,V> lastEntry() {
        return exportEntry(getLastEntry());
    }

    // 获取第一个节点，并将改节点从TreeMap中删除。
    public Map.Entry<K,V> pollFirstEntry() {
        // 获取第一个节点
        Entry<K,V> p = getFirstEntry();
        Map.Entry<K,V> result = exportEntry(p);
        // 删除第一个节点
        if (p != null)
            deleteEntry(p);
        return result;
    }

    // 获取最后一个节点，并将改节点从TreeMap中删除。
    public Map.Entry<K,V> pollLastEntry() {
        // 获取最后一个节点
        Entry<K,V> p = getLastEntry();
        Map.Entry<K,V> result = exportEntry(p);
        // 删除最后一个节点
        if (p != null)
            deleteEntry(p);
        return result;
    }

    // 返回小于key的最大的键值对，没有的话返回null
    public Map.Entry<K,V> lowerEntry(K key) {
        return exportEntry(getLowerEntry(key));
    }

    // 返回小于key的最大的键值对所对应的KEY，没有的话返回null
    public K lowerKey(K key) {
        return keyOrNull(getLowerEntry(key));
    }

    // 返回不大于key的最大的键值对，没有的话返回null
    public Map.Entry<K,V> floorEntry(K key) {
        return exportEntry(getFloorEntry(key));
    }

    // 返回不大于key的最大的键值对所对应的KEY，没有的话返回null
    public K floorKey(K key) {
        return keyOrNull(getFloorEntry(key));
    }

    // 返回不小于key的最小的键值对，没有的话返回null
    public Map.Entry<K,V> ceilingEntry(K key) {
        return exportEntry(getCeilingEntry(key));
    }

    // 返回不小于key的最小的键值对所对应的KEY，没有的话返回null
    public K ceilingKey(K key) {
        return keyOrNull(getCeilingEntry(key));
    }

    // 返回大于key的最小的键值对，没有的话返回null
    public Map.Entry<K,V> higherEntry(K key) {
        return exportEntry(getHigherEntry(key));
    }

    // 返回大于key的最小的键值对所对应的KEY，没有的话返回null
    public K higherKey(K key) {
        return keyOrNull(getHigherEntry(key));
    }

    // TreeMap的红黑树节点对应的集合
    private transient EntrySet entrySet = null;
    // KeySet为KeySet导航类
    private transient KeySet<K> navigableKeySet = null;
    // descendingMap为键值对的倒序“映射”
    private transient NavigableMap<K,V> descendingMap = null;

    // 返回TreeMap的“键的集合”
    public Set<K> keySet() {
        return navigableKeySet();
    }

    // 获取“可导航”的Key的集合
    // 实际上是返回KeySet类的对象。
    public NavigableSet<K> navigableKeySet() {
        KeySet<K> nks = navigableKeySet;
        return (nks != null) ? nks : (navigableKeySet = new KeySet(this));
    }

    // 返回“TreeMap的值对应的集合”
    public Collection<V> values() {
        Collection<V> vs = values;
        return (vs != null) ? vs : (values = new Values());
    }

    // 获取TreeMap的Entry的集合，实际上是返回EntrySet类的对象。
    public Set<Map.Entry<K,V>> entrySet() {
        EntrySet es = entrySet;
        return (es != null) ? es : (entrySet = new EntrySet());
    }

    // 获取TreeMap的降序Map
    // 实际上是返回DescendingSubMap类的对象
    public NavigableMap<K, V> descendingMap() {
        NavigableMap<K, V> km = descendingMap;
        return (km != null) ? km :
            (descendingMap = new DescendingSubMap(this,
                                                  true, null, true,
                                                  true, null, true));
    }

    // 获取TreeMap的子Map
    // 范围是从fromKey 到 toKey；fromInclusive是是否包含fromKey的标记，toInclusive是是否包含toKey的标记
    public NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive,
                                    K toKey,   boolean toInclusive) {
        return new AscendingSubMap(this,
                                   false, fromKey, fromInclusive,
                                   false, toKey,   toInclusive);
    }

    // 获取“Map的头部”
    // 范围从第一个节点 到 toKey, inclusive是是否包含toKey的标记
    public NavigableMap<K,V> headMap(K toKey, boolean inclusive) {
        return new AscendingSubMap(this,
                                   true,  null,  true,
                                   false, toKey, inclusive);
    }

    // 获取“Map的尾部”。
    // 范围是从 fromKey 到 最后一个节点，inclusive是是否包含fromKey的标记
    public NavigableMap<K,V> tailMap(K fromKey, boolean inclusive) {
        return new AscendingSubMap(this,
                                   false, fromKey, inclusive,
                                   true,  null,    true);
    }

    // 获取“子Map”。
    // 范围是从fromKey(包括) 到 toKey(不包括)
    public SortedMap<K,V> subMap(K fromKey, K toKey) {
        return subMap(fromKey, true, toKey, false);
    }

    // 获取“Map的头部”。
    // 范围从第一个节点 到 toKey(不包括)
    public SortedMap<K,V> headMap(K toKey) {
        return headMap(toKey, false);
    }

    // 获取“Map的尾部”。
    // 范围是从 fromKey(包括) 到 最后一个节点
    public SortedMap<K,V> tailMap(K fromKey) {
        return tailMap(fromKey, true);
    }

    // ”TreeMap的值的集合“对应的类，它集成于AbstractCollection
    class Values extends AbstractCollection<V> {
        // 返回迭代器
        public Iterator<V> iterator() {
            return new ValueIterator(getFirstEntry());
        }

        // 返回个数
        public int size() {
            return TreeMap.this.size();
        }

        // "TreeMap的值的集合"中是否包含"对象o"
        public boolean contains(Object o) {
            return TreeMap.this.containsValue(o);
        }

        // 删除"TreeMap的值的集合"中的"对象o"
        public boolean remove(Object o) {
            for (Entry<K,V> e = getFirstEntry(); e != null; e = successor(e)) {
                if (valEquals(e.getValue(), o)) {
                    deleteEntry(e);
                    return true;
                }
            }
            return false;
        }

        // 清空删除"TreeMap的值的集合"
        public void clear() {
            TreeMap.this.clear();
        }
    }

    // EntrySet是“TreeMap的所有键值对组成的集合”，
    // EntrySet集合的单位是单个“键值对”。
    class EntrySet extends AbstractSet<Map.Entry<K,V>> {
        public Iterator<Map.Entry<K,V>> iterator() {
            return new EntryIterator(getFirstEntry());
        }

        // EntrySet中是否包含“键值对Object”
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<K,V> entry = (Map.Entry<K,V>) o;
            V value = entry.getValue();
            Entry<K,V> p = getEntry(entry.getKey());
            return p != null && valEquals(p.getValue(), value);
        }

        // 删除EntrySet中的“键值对Object”
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<K,V> entry = (Map.Entry<K,V>) o;
            V value = entry.getValue();
            Entry<K,V> p = getEntry(entry.getKey());
            if (p != null && valEquals(p.getValue(), value)) {
                deleteEntry(p);
                return true;
            }
            return false;
        }

        // 返回EntrySet中元素个数
        public int size() {
            return TreeMap.this.size();
        }

        // 清空EntrySet
        public void clear() {
            TreeMap.this.clear();
        }
    }

    // 返回“TreeMap的KEY组成的迭代器(顺序)”
    Iterator<K> keyIterator() {
        return new KeyIterator(getFirstEntry());
    }

    // 返回“TreeMap的KEY组成的迭代器(逆序)”
    Iterator<K> descendingKeyIterator() {
        return new DescendingKeyIterator(getLastEntry());
    }

    // KeySet是“TreeMap中所有的KEY组成的集合”
    // KeySet继承于AbstractSet，而且实现了NavigableSet接口。
    static final class KeySet<E> extends AbstractSet<E> implements NavigableSet<E> {
        // NavigableMap成员，KeySet是通过NavigableMap实现的
        private final NavigableMap<E, Object> m;
        KeySet(NavigableMap<E,Object> map) { m = map; }

        // 升序迭代器
        public Iterator<E> iterator() {
            // 若是TreeMap对象，则调用TreeMap的迭代器keyIterator()
            // 否则，调用TreeMap子类NavigableSubMap的迭代器keyIterator()
            if (m instanceof TreeMap)
                return ((TreeMap<E,Object>)m).keyIterator();
            else
                return (Iterator<E>)(((TreeMap.NavigableSubMap)m).keyIterator());
        }

        // 降序迭代器
        public Iterator<E> descendingIterator() {
            // 若是TreeMap对象，则调用TreeMap的迭代器descendingKeyIterator()
            // 否则，调用TreeMap子类NavigableSubMap的迭代器descendingKeyIterator()
            if (m instanceof TreeMap)
                return ((TreeMap<E,Object>)m).descendingKeyIterator();
            else
                return (Iterator<E>)(((TreeMap.NavigableSubMap)m).descendingKeyIterator());
        }

        public int size() { return m.size(); }
        public boolean isEmpty() { return m.isEmpty(); }
        public boolean contains(Object o) { return m.containsKey(o); }
        public void clear() { m.clear(); }
        public E lower(E e) { return m.lowerKey(e); }
        public E floor(E e) { return m.floorKey(e); }
        public E ceiling(E e) { return m.ceilingKey(e); }
        public E higher(E e) { return m.higherKey(e); }
        public E first() { return m.firstKey(); }
        public E last() { return m.lastKey(); }
        public Comparator<? super E> comparator() { return m.comparator(); }
        public E pollFirst() {
            Map.Entry<E,Object> e = m.pollFirstEntry();
            return e == null? null : e.getKey();
        }
        public E pollLast() {
            Map.Entry<E,Object> e = m.pollLastEntry();
            return e == null? null : e.getKey();
        }
        public boolean remove(Object o) {
            int oldSize = size();
            m.remove(o);
            return size() != oldSize;
        }
        public NavigableSet<E> subSet(E fromElement, boolean fromInclusive,
                                      E toElement,   boolean toInclusive) {
            return new TreeSet<E>(m.subMap(fromElement, fromInclusive,
                                           toElement,   toInclusive));
        }
        public NavigableSet<E> headSet(E toElement, boolean inclusive) {
            return new TreeSet<E>(m.headMap(toElement, inclusive));
        }
        public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
            return new TreeSet<E>(m.tailMap(fromElement, inclusive));
        }
        public SortedSet<E> subSet(E fromElement, E toElement) {
            return subSet(fromElement, true, toElement, false);
        }
        public SortedSet<E> headSet(E toElement) {
            return headSet(toElement, false);
        }
        public SortedSet<E> tailSet(E fromElement) {
            return tailSet(fromElement, true);
        }
        public NavigableSet<E> descendingSet() {
            return new TreeSet(m.descendingMap());
        }
    }

    // 它是TreeMap中的一个抽象迭代器，实现了一些通用的接口。
    abstract class PrivateEntryIterator<T> implements Iterator<T> {
        // 下一个元素
        Entry<K,V> next;
        // 上一次返回元素
        Entry<K,V> lastReturned;
        // 期望的修改次数，用于实现fast-fail机制
        int expectedModCount;

        PrivateEntryIterator(Entry<K,V> first) {
            expectedModCount = modCount;
            lastReturned = null;
            next = first;
        }

        public final boolean hasNext() {
            return next != null;
        }

        // 获取下一个节点
        final Entry<K,V> nextEntry() {
            Entry<K,V> e = next;
            if (e == null)
                throw new NoSuchElementException();
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            next = successor(e);
            lastReturned = e;
            return e;
        }

        // 获取上一个节点
        final Entry<K,V> prevEntry() {
            Entry<K,V> e = next;
            if (e == null)
                throw new NoSuchElementException();
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            next = predecessor(e);
            lastReturned = e;
            return e;
        }

        // 删除当前节点
        public void remove() {
            if (lastReturned == null)
                throw new IllegalStateException();
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            // 这里重点强调一下“为什么当lastReturned的左右孩子都不为空时，要将其赋值给next”。
            // 目的是为了“删除lastReturned节点之后，next节点指向的仍然是下一个节点”。
            //     根据“红黑树”的特性可知：
            //     当被删除节点有两个儿子时。那么，首先把“它的后继节点的内容”复制给“该节点的内容”；之后，删除“它的后继节点”。
            //     这意味着“当被删除节点有两个儿子时，删除当前节点之后，'新的当前节点'实际上是‘原有的后继节点(即下一个节点)’”。
            //     而此时next仍然指向"新的当前节点"。也就是说next是仍然是指向下一个节点；能继续遍历红黑树。
            if (lastReturned.left != null && lastReturned.right != null)
                next = lastReturned;
            deleteEntry(lastReturned);
            expectedModCount = modCount;
            lastReturned = null;
        }
    }

    // TreeMap的Entry对应的迭代器
    final class EntryIterator extends PrivateEntryIterator<Map.Entry<K,V>> {
        EntryIterator(Entry<K,V> first) {
            super(first);
        }
        public Map.Entry<K,V> next() {
            return nextEntry();
        }
    }

    // TreeMap的Value对应的迭代器
    final class ValueIterator extends PrivateEntryIterator<V> {
        ValueIterator(Entry<K,V> first) {
            super(first);
        }
        public V next() {
            return nextEntry().value;
        }
    }

    // reeMap的KEY组成的迭代器(顺序)
    final class KeyIterator extends PrivateEntryIterator<K> {
        KeyIterator(Entry<K,V> first) {
            super(first);
        }
        public K next() {
            return nextEntry().key;
        }
    }

    // TreeMap的KEY组成的迭代器(逆序)
    final class DescendingKeyIterator extends PrivateEntryIterator<K> {
        DescendingKeyIterator(Entry<K,V> first) {
            super(first);
        }
        public K next() {
            return prevEntry().key;
        }
    }

    // 比较两个对象的大小
    final int compare(Object k1, Object k2) {
        return comparator==null ? ((Comparable<? super K>)k1).compareTo((K)k2)
            : comparator.compare((K)k1, (K)k2);
    }

    // 判断两个对象是否相等
    final static boolean valEquals(Object o1, Object o2) {
        return (o1==null ? o2==null : o1.equals(o2));
    }

    // 返回“Key-Value键值对”的一个简单拷贝(AbstractMap.SimpleImmutableEntry<K,V>对象)
    // 可用来读取“键值对”的值
    static <K,V> Map.Entry<K,V> exportEntry(TreeMap.Entry<K,V> e) {
        return e == null? null :
            new AbstractMap.SimpleImmutableEntry<K,V>(e);
    }

    // 若“键值对”不为null，则返回KEY；否则，返回null
    static <K,V> K keyOrNull(TreeMap.Entry<K,V> e) {
        return e == null? null : e.key;
    }

    // 若“键值对”不为null，则返回KEY；否则，抛出异常
    static <K> K key(Entry<K,?> e) {
        if (e==null)
            throw new NoSuchElementException();
        return e.key;
    }

    // TreeMap的SubMap，它一个抽象类，实现了公共操作。
    // 它包括了"(升序)AscendingSubMap"和"(降序)DescendingSubMap"两个子类。
    static abstract class NavigableSubMap<K,V> extends AbstractMap<K,V>
        implements NavigableMap<K,V>, java.io.Serializable {
        // TreeMap的拷贝
        final TreeMap<K,V> m;
        // lo是“子Map范围的最小值”，hi是“子Map范围的最大值”；
        // loInclusive是“是否包含lo的标记”，hiInclusive是“是否包含hi的标记”
        // fromStart是“表示是否从第一个节点开始计算”，
        // toEnd是“表示是否计算到最后一个节点      ”
        final K lo, hi;      
        final boolean fromStart, toEnd;
        final boolean loInclusive, hiInclusive;

        // 构造函数
        NavigableSubMap(TreeMap<K,V> m,
                        boolean fromStart, K lo, boolean loInclusive,
                        boolean toEnd,     K hi, boolean hiInclusive) {
            if (!fromStart && !toEnd) {
                if (m.compare(lo, hi) > 0)
                    throw new IllegalArgumentException("fromKey > toKey");
            } else {
                if (!fromStart) // type check
                    m.compare(lo, lo);
                if (!toEnd)
                    m.compare(hi, hi);
            }

            this.m = m;
            this.fromStart = fromStart;
            this.lo = lo;
            this.loInclusive = loInclusive;
            this.toEnd = toEnd;
            this.hi = hi;
            this.hiInclusive = hiInclusive;
        }

        // 判断key是否太小
        final boolean tooLow(Object key) {
            // 若该SubMap不包括“起始节点”，
            // 并且，“key小于最小键(lo)”或者“key等于最小键(lo)，但最小键却没包括在该SubMap内”
            // 则判断key太小。其余情况都不是太小！
            if (!fromStart) {
                int c = m.compare(key, lo);
                if (c < 0 || (c == 0 && !loInclusive))
                    return true;
            }
            return false;
        }

        // 判断key是否太大
        final boolean tooHigh(Object key) {
            // 若该SubMap不包括“结束节点”，
            // 并且，“key大于最大键(hi)”或者“key等于最大键(hi)，但最大键却没包括在该SubMap内”
            // 则判断key太大。其余情况都不是太大！
            if (!toEnd) {
                int c = m.compare(key, hi);
                if (c > 0 || (c == 0 && !hiInclusive))
                    return true;
            }
            return false;
        }

        // 判断key是否在“lo和hi”开区间范围内
        final boolean inRange(Object key) {
            return !tooLow(key) && !tooHigh(key);
        }

        // 判断key是否在封闭区间内
        final boolean inClosedRange(Object key) {
            return (fromStart || m.compare(key, lo) >= 0)
                && (toEnd || m.compare(hi, key) >= 0);
        }

        // 判断key是否在区间内, inclusive是区间开关标志
        final boolean inRange(Object key, boolean inclusive) {
            return inclusive ? inRange(key) : inClosedRange(key);
        }

        // 返回最低的Entry
        final TreeMap.Entry<K,V> absLowest() {
        // 若“包含起始节点”，则调用getFirstEntry()返回第一个节点
        // 否则的话，若包括lo，则调用getCeilingEntry(lo)获取大于/等于lo的最小的Entry;
        //           否则，调用getHigherEntry(lo)获取大于lo的最小Entry
        TreeMap.Entry<K,V> e =
                (fromStart ?  m.getFirstEntry() :
                 (loInclusive ? m.getCeilingEntry(lo) :
                                m.getHigherEntry(lo)));
            return (e == null || tooHigh(e.key)) ? null : e;
        }

        // 返回最高的Entry
        final TreeMap.Entry<K,V> absHighest() {
        // 若“包含结束节点”，则调用getLastEntry()返回最后一个节点
        // 否则的话，若包括hi，则调用getFloorEntry(hi)获取小于/等于hi的最大的Entry;
        //           否则，调用getLowerEntry(hi)获取大于hi的最大Entry
        TreeMap.Entry<K,V> e =
        TreeMap.Entry<K,V> e =
                (toEnd ?  m.getLastEntry() :
                 (hiInclusive ?  m.getFloorEntry(hi) :
                                 m.getLowerEntry(hi)));
            return (e == null || tooLow(e.key)) ? null : e;
        }

        // 返回"大于/等于key的最小的Entry"
        final TreeMap.Entry<K,V> absCeiling(K key) {
            // 只有在“key太小”的情况下，absLowest()返回的Entry才是“大于/等于key的最小Entry”
            // 其它情况下不行。例如，当包含“起始节点”时，absLowest()返回的是最小Entry了！
            if (tooLow(key))
                return absLowest();
            // 获取“大于/等于key的最小Entry”
        TreeMap.Entry<K,V> e = m.getCeilingEntry(key);
            return (e == null || tooHigh(e.key)) ? null : e;
        }

        // 返回"大于key的最小的Entry"
        final TreeMap.Entry<K,V> absHigher(K key) {
            // 只有在“key太小”的情况下，absLowest()返回的Entry才是“大于key的最小Entry”
            // 其它情况下不行。例如，当包含“起始节点”时，absLowest()返回的是最小Entry了,而不一定是“大于key的最小Entry”！
            if (tooLow(key))
                return absLowest();
            // 获取“大于key的最小Entry”
        TreeMap.Entry<K,V> e = m.getHigherEntry(key);
            return (e == null || tooHigh(e.key)) ? null : e;
        }

        // 返回"小于/等于key的最大的Entry"
        final TreeMap.Entry<K,V> absFloor(K key) {
            // 只有在“key太大”的情况下，(absHighest)返回的Entry才是“小于/等于key的最大Entry”
            // 其它情况下不行。例如，当包含“结束节点”时，absHighest()返回的是最大Entry了！
            if (tooHigh(key))
                return absHighest();
        // 获取"小于/等于key的最大的Entry"
        TreeMap.Entry<K,V> e = m.getFloorEntry(key);
            return (e == null || tooLow(e.key)) ? null : e;
        }

        // 返回"小于key的最大的Entry"
        final TreeMap.Entry<K,V> absLower(K key) {
            // 只有在“key太大”的情况下，(absHighest)返回的Entry才是“小于key的最大Entry”
            // 其它情况下不行。例如，当包含“结束节点”时，absHighest()返回的是最大Entry了,而不一定是“小于key的最大Entry”！
            if (tooHigh(key))
                return absHighest();
        // 获取"小于key的最大的Entry"
        TreeMap.Entry<K,V> e = m.getLowerEntry(key);
            return (e == null || tooLow(e.key)) ? null : e;
        }

        // 返回“大于最大节点中的最小节点”，不存在的话，返回null
        final TreeMap.Entry<K,V> absHighFence() {
            return (toEnd ? null : (hiInclusive ?
                                    m.getHigherEntry(hi) :
                                    m.getCeilingEntry(hi)));
        }

        // 返回“小于最小节点中的最大节点”，不存在的话，返回null
        final TreeMap.Entry<K,V> absLowFence() {
            return (fromStart ? null : (loInclusive ?
                                        m.getLowerEntry(lo) :
                                        m.getFloorEntry(lo)));
        }

        // 下面几个abstract方法是需要NavigableSubMap的实现类实现的方法
        abstract TreeMap.Entry<K,V> subLowest();
        abstract TreeMap.Entry<K,V> subHighest();
        abstract TreeMap.Entry<K,V> subCeiling(K key);
        abstract TreeMap.Entry<K,V> subHigher(K key);
        abstract TreeMap.Entry<K,V> subFloor(K key);
        abstract TreeMap.Entry<K,V> subLower(K key);
        // 返回“顺序”的键迭代器
        abstract Iterator<K> keyIterator();
        // 返回“逆序”的键迭代器
        abstract Iterator<K> descendingKeyIterator();

        // 返回SubMap是否为空。空的话，返回true，否则返回false
        public boolean isEmpty() {
            return (fromStart && toEnd) ? m.isEmpty() : entrySet().isEmpty();
        }

        // 返回SubMap的大小
        public int size() {
            return (fromStart && toEnd) ? m.size() : entrySet().size();
        }

        // 返回SubMap是否包含键key
        public final boolean containsKey(Object key) {
            return inRange(key) && m.containsKey(key);
        }

        // 将key-value 插入SubMap中
        public final V put(K key, V value) {
            if (!inRange(key))
                throw new IllegalArgumentException("key out of range");
            return m.put(key, value);
        }

        // 获取key对应值
        public final V get(Object key) {
            return !inRange(key)? null :  m.get(key);
        }

        // 删除key对应的键值对
        public final V remove(Object key) {
            return !inRange(key)? null  : m.remove(key);
        }

        // 获取“大于/等于key的最小键值对”
        public final Map.Entry<K,V> ceilingEntry(K key) {
            return exportEntry(subCeiling(key));
        }

        // 获取“大于/等于key的最小键”
        public final K ceilingKey(K key) {
            return keyOrNull(subCeiling(key));
        }

        // 获取“大于key的最小键值对”
        public final Map.Entry<K,V> higherEntry(K key) {
            return exportEntry(subHigher(key));
        }

        // 获取“大于key的最小键”
        public final K higherKey(K key) {
            return keyOrNull(subHigher(key));
        }

        // 获取“小于/等于key的最大键值对”
        public final Map.Entry<K,V> floorEntry(K key) {
            return exportEntry(subFloor(key));
        }

        // 获取“小于/等于key的最大键”
        public final K floorKey(K key) {
            return keyOrNull(subFloor(key));
        }

        // 获取“小于key的最大键值对”
        public final Map.Entry<K,V> lowerEntry(K key) {
            return exportEntry(subLower(key));
        }

        // 获取“小于key的最大键”
        public final K lowerKey(K key) {
            return keyOrNull(subLower(key));
        }

        // 获取"SubMap的第一个键"
        public final K firstKey() {
            return key(subLowest());
        }

        // 获取"SubMap的最后一个键"
        public final K lastKey() {
            return key(subHighest());
        }

        // 获取"SubMap的第一个键值对"
        public final Map.Entry<K,V> firstEntry() {
            return exportEntry(subLowest());
        }

        // 获取"SubMap的最后一个键值对"
        public final Map.Entry<K,V> lastEntry() {
            return exportEntry(subHighest());
        }

        // 返回"SubMap的第一个键值对"，并从SubMap中删除改键值对
        public final Map.Entry<K,V> pollFirstEntry() {
        TreeMap.Entry<K,V> e = subLowest();
            Map.Entry<K,V> result = exportEntry(e);
            if (e != null)
                m.deleteEntry(e);
            return result;
        }

        // 返回"SubMap的最后一个键值对"，并从SubMap中删除改键值对
        public final Map.Entry<K,V> pollLastEntry() {
        TreeMap.Entry<K,V> e = subHighest();
            Map.Entry<K,V> result = exportEntry(e);
            if (e != null)
                m.deleteEntry(e);
            return result;
        }

        // Views
        transient NavigableMap<K,V> descendingMapView = null;
        transient EntrySetView entrySetView = null;
        transient KeySet<K> navigableKeySetView = null;

        // 返回NavigableSet对象，实际上返回的是当前对象的"Key集合"。 
        public final NavigableSet<K> navigableKeySet() {
            KeySet<K> nksv = navigableKeySetView;
            return (nksv != null) ? nksv :
                (navigableKeySetView = new TreeMap.KeySet(this));
        }

        // 返回"Key集合"对象
        public final Set<K> keySet() {
            return navigableKeySet();
        }

        // 返回“逆序”的Key集合
        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        // 排列fromKey(包含) 到 toKey(不包含) 的子map
        public final SortedMap<K,V> subMap(K fromKey, K toKey) {
            return subMap(fromKey, true, toKey, false);
        }

        // 返回当前Map的头部(从第一个节点 到 toKey, 不包括toKey)
        public final SortedMap<K,V> headMap(K toKey) {
            return headMap(toKey, false);
        }

        // 返回当前Map的尾部[从 fromKey(包括fromKeyKey) 到 最后一个节点]
        public final SortedMap<K,V> tailMap(K fromKey) {
            return tailMap(fromKey, true);
        }

        // Map的Entry的集合
        abstract class EntrySetView extends AbstractSet<Map.Entry<K,V>> {
            private transient int size = -1, sizeModCount;

            // 获取EntrySet的大小
            public int size() {
                // 若SubMap是从“开始节点”到“结尾节点”，则SubMap大小就是原TreeMap的大小
                if (fromStart && toEnd)
                    return m.size();
                // 若SubMap不是从“开始节点”到“结尾节点”，则调用iterator()遍历EntrySetView中的元素
                if (size == -1 || sizeModCount != m.modCount) {
                    sizeModCount = m.modCount;
                    size = 0;
                    Iterator i = iterator();
                    while (i.hasNext()) {
                        size++;
                        i.next();
                    }
                }
                return size;
            }

            // 判断EntrySetView是否为空
            public boolean isEmpty() {
                TreeMap.Entry<K,V> n = absLowest();
                return n == null || tooHigh(n.key);
            }

            // 判断EntrySetView是否包含Object
            public boolean contains(Object o) {
                if (!(o instanceof Map.Entry))
                    return false;
                Map.Entry<K,V> entry = (Map.Entry<K,V>) o;
                K key = entry.getKey();
                if (!inRange(key))
                    return false;
                TreeMap.Entry node = m.getEntry(key);
                return node != null &&
                    valEquals(node.getValue(), entry.getValue());
            }

            // 从EntrySetView中删除Object
            public boolean remove(Object o) {
                if (!(o instanceof Map.Entry))
                    return false;
                Map.Entry<K,V> entry = (Map.Entry<K,V>) o;
                K key = entry.getKey();
                if (!inRange(key))
                    return false;
                TreeMap.Entry<K,V> node = m.getEntry(key);
                if (node!=null && valEquals(node.getValue(),entry.getValue())){
                    m.deleteEntry(node);
                    return true;
                }
                return false;
            }
        }

        // SubMap的迭代器
        abstract class SubMapIterator<T> implements Iterator<T> {
            // 上一次被返回的Entry
            TreeMap.Entry<K,V> lastReturned;
            // 指向下一个Entry
            TreeMap.Entry<K,V> next;
            // “栅栏key”。根据SubMap是“升序”还是“降序”具有不同的意义
            final K fenceKey;
            int expectedModCount;

            // 构造函数
            SubMapIterator(TreeMap.Entry<K,V> first,
                           TreeMap.Entry<K,V> fence) {
                // 每创建一个SubMapIterator时，保存修改次数
                // 若后面发现expectedModCount和modCount不相等，则抛出ConcurrentModificationException异常。
                // 这就是所说的fast-fail机制的原理！
                expectedModCount = m.modCount;
                lastReturned = null;
                next = first;
                fenceKey = fence == null ? null : fence.key;
            }

            // 是否存在下一个Entry
            public final boolean hasNext() {
                return next != null && next.key != fenceKey;
            }

            // 返回下一个Entry
            final TreeMap.Entry<K,V> nextEntry() {
                TreeMap.Entry<K,V> e = next;
                if (e == null || e.key == fenceKey)
                    throw new NoSuchElementException();
                if (m.modCount != expectedModCount)
                    throw new ConcurrentModificationException();
                // next指向e的后继节点
                next = successor(e);
        lastReturned = e;
                return e;
            }

            // 返回上一个Entry
            final TreeMap.Entry<K,V> prevEntry() {
                TreeMap.Entry<K,V> e = next;
                if (e == null || e.key == fenceKey)
                    throw new NoSuchElementException();
                if (m.modCount != expectedModCount)
                    throw new ConcurrentModificationException();
                // next指向e的前继节点
                next = predecessor(e);
        lastReturned = e;
                return e;
            }

            // 删除当前节点(用于“升序的SubMap”)。
            // 删除之后，可以继续升序遍历；红黑树特性没变。
            final void removeAscending() {
                if (lastReturned == null)
                    throw new IllegalStateException();
                if (m.modCount != expectedModCount)
                    throw new ConcurrentModificationException();
                // 这里重点强调一下“为什么当lastReturned的左右孩子都不为空时，要将其赋值给next”。
                // 目的是为了“删除lastReturned节点之后，next节点指向的仍然是下一个节点”。
                //     根据“红黑树”的特性可知：
                //     当被删除节点有两个儿子时。那么，首先把“它的后继节点的内容”复制给“该节点的内容”；之后，删除“它的后继节点”。
                //     这意味着“当被删除节点有两个儿子时，删除当前节点之后，'新的当前节点'实际上是‘原有的后继节点(即下一个节点)’”。
                //     而此时next仍然指向"新的当前节点"。也就是说next是仍然是指向下一个节点；能继续遍历红黑树。
                if (lastReturned.left != null && lastReturned.right != null)
                    next = lastReturned;
                m.deleteEntry(lastReturned);
                lastReturned = null;
                expectedModCount = m.modCount;
            }

            // 删除当前节点(用于“降序的SubMap”)。
            // 删除之后，可以继续降序遍历；红黑树特性没变。
            final void removeDescending() {
                if (lastReturned == null)
                    throw new IllegalStateException();
                if (m.modCount != expectedModCount)
                    throw new ConcurrentModificationException();
                m.deleteEntry(lastReturned);
                lastReturned = null;
                expectedModCount = m.modCount;
            }

        }

        // SubMap的Entry迭代器，它只支持升序操作，继承于SubMapIterator
        final class SubMapEntryIterator extends SubMapIterator<Map.Entry<K,V>> {
            SubMapEntryIterator(TreeMap.Entry<K,V> first,
                                TreeMap.Entry<K,V> fence) {
                super(first, fence);
            }
            // 获取下一个节点(升序)
            public Map.Entry<K,V> next() {
                return nextEntry();
            }
            // 删除当前节点(升序)
            public void remove() {
                removeAscending();
            }
        }

        // SubMap的Key迭代器，它只支持升序操作，继承于SubMapIterator
        final class SubMapKeyIterator extends SubMapIterator<K> {
            SubMapKeyIterator(TreeMap.Entry<K,V> first,
                              TreeMap.Entry<K,V> fence) {
                super(first, fence);
            }
            // 获取下一个节点(升序)
            public K next() {
                return nextEntry().key;
            }
            // 删除当前节点(升序)
            public void remove() {
                removeAscending();
            }
        }

        // 降序SubMap的Entry迭代器，它只支持降序操作，继承于SubMapIterator
        final class DescendingSubMapEntryIterator extends SubMapIterator<Map.Entry<K,V>> {
            DescendingSubMapEntryIterator(TreeMap.Entry<K,V> last,
                                          TreeMap.Entry<K,V> fence) {
                super(last, fence);
            }

            // 获取下一个节点(降序)
            public Map.Entry<K,V> next() {
                return prevEntry();
            }
            // 删除当前节点(降序)
            public void remove() {
                removeDescending();
            }
        }

        // 降序SubMap的Key迭代器，它只支持降序操作，继承于SubMapIterator
        final class DescendingSubMapKeyIterator extends SubMapIterator<K> {
            DescendingSubMapKeyIterator(TreeMap.Entry<K,V> last,
                                        TreeMap.Entry<K,V> fence) {
                super(last, fence);
            }
            // 获取下一个节点(降序)
            public K next() {
                return prevEntry().key;
            }
            // 删除当前节点(降序)
            public void remove() {
                removeDescending();
            }
        }
    }


    // 升序的SubMap，继承于NavigableSubMap
    static final class AscendingSubMap<K,V> extends NavigableSubMap<K,V> {
        private static final long serialVersionUID = 912986545866124060L;

        // 构造函数
        AscendingSubMap(TreeMap<K,V> m,
                        boolean fromStart, K lo, boolean loInclusive,
                        boolean toEnd,     K hi, boolean hiInclusive) {
            super(m, fromStart, lo, loInclusive, toEnd, hi, hiInclusive);
        }

        // 比较器
        public Comparator<? super K> comparator() {
            return m.comparator();
        }

        // 获取“子Map”。
        // 范围是从fromKey 到 toKey；fromInclusive是是否包含fromKey的标记，toInclusive是是否包含toKey的标记
        public NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive,
                                        K toKey,   boolean toInclusive) {
            if (!inRange(fromKey, fromInclusive))
                throw new IllegalArgumentException("fromKey out of range");
            if (!inRange(toKey, toInclusive))
                throw new IllegalArgumentException("toKey out of range");
            return new AscendingSubMap(m,
                                       false, fromKey, fromInclusive,
                                       false, toKey,   toInclusive);
        }

        // 获取“Map的头部”。
        // 范围从第一个节点 到 toKey, inclusive是是否包含toKey的标记
        public NavigableMap<K,V> headMap(K toKey, boolean inclusive) {
            if (!inRange(toKey, inclusive))
                throw new IllegalArgumentException("toKey out of range");
            return new AscendingSubMap(m,
                                       fromStart, lo,    loInclusive,
                                       false,     toKey, inclusive);
        }

        // 获取“Map的尾部”。
        // 范围是从 fromKey 到 最后一个节点，inclusive是是否包含fromKey的标记
        public NavigableMap<K,V> tailMap(K fromKey, boolean inclusive){
            if (!inRange(fromKey, inclusive))
                throw new IllegalArgumentException("fromKey out of range");
            return new AscendingSubMap(m,
                                       false, fromKey, inclusive,
                                       toEnd, hi,      hiInclusive);
        }

        // 获取对应的降序Map
        public NavigableMap<K,V> descendingMap() {
            NavigableMap<K,V> mv = descendingMapView;
            return (mv != null) ? mv :
                (descendingMapView =
                 new DescendingSubMap(m,
                                      fromStart, lo, loInclusive,
                                      toEnd,     hi, hiInclusive));
        }

        // 返回“升序Key迭代器”
        Iterator<K> keyIterator() {
            return new SubMapKeyIterator(absLowest(), absHighFence());
        }

        // 返回“降序Key迭代器”
        Iterator<K> descendingKeyIterator() {
            return new DescendingSubMapKeyIterator(absHighest(), absLowFence());
        }

        // “升序EntrySet集合”类
        // 实现了iterator()
        final class AscendingEntrySetView extends EntrySetView {
            public Iterator<Map.Entry<K,V>> iterator() {
                return new SubMapEntryIterator(absLowest(), absHighFence());
            }
        }

        // 返回“升序EntrySet集合”
        public Set<Map.Entry<K,V>> entrySet() {
            EntrySetView es = entrySetView;
            return (es != null) ? es : new AscendingEntrySetView();
        }

        TreeMap.Entry<K,V> subLowest()       { return absLowest(); }
        TreeMap.Entry<K,V> subHighest()      { return absHighest(); }
        TreeMap.Entry<K,V> subCeiling(K key) { return absCeiling(key); }
        TreeMap.Entry<K,V> subHigher(K key)  { return absHigher(key); }
        TreeMap.Entry<K,V> subFloor(K key)   { return absFloor(key); }
        TreeMap.Entry<K,V> subLower(K key)   { return absLower(key); }
    }

    // 降序的SubMap，继承于NavigableSubMap
    // 相比于升序SubMap，它的实现机制是将“SubMap的比较器反转”！
    static final class DescendingSubMap<K,V>  extends NavigableSubMap<K,V> {
        private static final long serialVersionUID = 912986545866120460L;
        DescendingSubMap(TreeMap<K,V> m,
                        boolean fromStart, K lo, boolean loInclusive,
                        boolean toEnd,     K hi, boolean hiInclusive) {
            super(m, fromStart, lo, loInclusive, toEnd, hi, hiInclusive);
        }

        // 反转的比较器：是将原始比较器反转得到的。
        private final Comparator<? super K> reverseComparator =
            Collections.reverseOrder(m.comparator);

        // 获取反转比较器
        public Comparator<? super K> comparator() {
            return reverseComparator;
        }

        // 获取“子Map”。
        // 范围是从fromKey 到 toKey；fromInclusive是是否包含fromKey的标记，toInclusive是是否包含toKey的标记
        public NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive,
                                        K toKey,   boolean toInclusive) {
            if (!inRange(fromKey, fromInclusive))
                throw new IllegalArgumentException("fromKey out of range");
            if (!inRange(toKey, toInclusive))
                throw new IllegalArgumentException("toKey out of range");
            return new DescendingSubMap(m,
                                        false, toKey,   toInclusive,
                                        false, fromKey, fromInclusive);
        }

        // 获取“Map的头部”。
        // 范围从第一个节点 到 toKey, inclusive是是否包含toKey的标记
        public NavigableMap<K,V> headMap(K toKey, boolean inclusive) {
            if (!inRange(toKey, inclusive))
                throw new IllegalArgumentException("toKey out of range");
            return new DescendingSubMap(m,
                                        false, toKey, inclusive,
                                        toEnd, hi,    hiInclusive);
        }

        // 获取“Map的尾部”。
        // 范围是从 fromKey 到 最后一个节点，inclusive是是否包含fromKey的标记
        public NavigableMap<K,V> tailMap(K fromKey, boolean inclusive){
            if (!inRange(fromKey, inclusive))
                throw new IllegalArgumentException("fromKey out of range");
            return new DescendingSubMap(m,
                                        fromStart, lo, loInclusive,
                                        false, fromKey, inclusive);
        }

        // 获取对应的降序Map
        public NavigableMap<K,V> descendingMap() {
            NavigableMap<K,V> mv = descendingMapView;
            return (mv != null) ? mv :
                (descendingMapView =
                 new AscendingSubMap(m,
                                     fromStart, lo, loInclusive,
                                     toEnd,     hi, hiInclusive));
        }

        // 返回“升序Key迭代器”
        Iterator<K> keyIterator() {
            return new DescendingSubMapKeyIterator(absHighest(), absLowFence());
        }

        // 返回“降序Key迭代器”
        Iterator<K> descendingKeyIterator() {
            return new SubMapKeyIterator(absLowest(), absHighFence());
        }

        // “降序EntrySet集合”类
        // 实现了iterator()
        final class DescendingEntrySetView extends EntrySetView {
            public Iterator<Map.Entry<K,V>> iterator() {
                return new DescendingSubMapEntryIterator(absHighest(), absLowFence());
            }
        }

        // 返回“降序EntrySet集合”
        public Set<Map.Entry<K,V>> entrySet() {
            EntrySetView es = entrySetView;
            return (es != null) ? es : new DescendingEntrySetView();
        }

        TreeMap.Entry<K,V> subLowest()       { return absHighest(); }
        TreeMap.Entry<K,V> subHighest()      { return absLowest(); }
        TreeMap.Entry<K,V> subCeiling(K key) { return absFloor(key); }
        TreeMap.Entry<K,V> subHigher(K key)  { return absLower(key); }
        TreeMap.Entry<K,V> subFloor(K key)   { return absCeiling(key); }
        TreeMap.Entry<K,V> subLower(K key)   { return absHigher(key); }
    }

    // SubMap是旧版本的类，新的Java中没有用到。
    private class SubMap extends AbstractMap<K,V>
    implements SortedMap<K,V>, java.io.Serializable {
        private static final long serialVersionUID = -6520786458950516097L;
        private boolean fromStart = false, toEnd = false;
        private K fromKey, toKey;
        private Object readResolve() {
            return new AscendingSubMap(TreeMap.this,
                                       fromStart, fromKey, true,
                                       toEnd, toKey, false);
        }
        public Set<Map.Entry<K,V>> entrySet() { throw new InternalError(); }
        public K lastKey() { throw new InternalError(); }
        public K firstKey() { throw new InternalError(); }
        public SortedMap<K,V> subMap(K fromKey, K toKey) { throw new InternalError(); }
        public SortedMap<K,V> headMap(K toKey) { throw new InternalError(); }
        public SortedMap<K,V> tailMap(K fromKey) { throw new InternalError(); }
        public Comparator<? super K> comparator() { throw new InternalError(); }
    }


    // 红黑树的节点颜色--红色
    private static final boolean RED   = false;
    // 红黑树的节点颜色--黑色
    private static final boolean BLACK = true;

    // “红黑树的节点”对应的类。
    // 包含了 key(键)、value(值)、left(左孩子)、right(右孩子)、parent(父节点)、color(颜色)
    static final class Entry<K,V> implements Map.Entry<K,V> {
        // 键
        K key;
        // 值
        V value;
        // 左孩子
        Entry<K,V> left = null;
        // 右孩子
        Entry<K,V> right = null;
        // 父节点
        Entry<K,V> parent;
        // 当前节点颜色
        boolean color = BLACK;

        // 构造函数
        Entry(K key, V value, Entry<K,V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        // 返回“键”
        public K getKey() {
            return key;
        }

        // 返回“值”
        public V getValue() {
            return value;
        }

        // 更新“值”，返回旧的值
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        // 判断两个节点是否相等的函数，覆盖equals()函数。
        // 若两个节点的“key相等”并且“value相等”，则两个节点相等
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<?,?> e = (Map.Entry<?,?>)o;

            return valEquals(key,e.getKey()) && valEquals(value,e.getValue());
        }

        // 覆盖hashCode函数。
        public int hashCode() {
            int keyHash = (key==null ? 0 : key.hashCode());
            int valueHash = (value==null ? 0 : value.hashCode());
            return keyHash ^ valueHash;
        }

        // 覆盖toString()函数。
        public String toString() {
            return key + "=" + value;
        }
    }

    // 返回“红黑树的第一个节点”
    final Entry<K,V> getFirstEntry() {
        Entry<K,V> p = root;
        if (p != null)
            while (p.left != null)
                p = p.left;
        return p;
    }

    // 返回“红黑树的最后一个节点”
    final Entry<K,V> getLastEntry() {
        Entry<K,V> p = root;
        if (p != null)
            while (p.right != null)
                p = p.right;
        return p;
    }

    // 返回“节点t的后继节点”
    static <K,V> TreeMap.Entry<K,V> successor(Entry<K,V> t) {
        if (t == null)
            return null;
        else if (t.right != null) {
            Entry<K,V> p = t.right;
            while (p.left != null)
                p = p.left;
            return p;
        } else {
            Entry<K,V> p = t.parent;
            Entry<K,V> ch = t;
            while (p != null && ch == p.right) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }

    // 返回“节点t的前继节点”
    static <K,V> Entry<K,V> predecessor(Entry<K,V> t) {
        if (t == null)
            return null;
        else if (t.left != null) {
            Entry<K,V> p = t.left;
            while (p.right != null)
                p = p.right;
            return p;
        } else {
            Entry<K,V> p = t.parent;
            Entry<K,V> ch = t;
            while (p != null && ch == p.left) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }

    // 返回“节点p的颜色”
    // 根据“红黑树的特性”可知：空节点颜色是黑色。
    private static <K,V> boolean colorOf(Entry<K,V> p) {
        return (p == null ? BLACK : p.color);
    }

    // 返回“节点p的父节点”
    private static <K,V> Entry<K,V> parentOf(Entry<K,V> p) {
        return (p == null ? null: p.parent);
    }

    // 设置“节点p的颜色为c”
    private static <K,V> void setColor(Entry<K,V> p, boolean c) {
        if (p != null)
        p.color = c;
    }

    // 设置“节点p的左孩子”
    private static <K,V> Entry<K,V> leftOf(Entry<K,V> p) {
        return (p == null) ? null: p.left;
    }

    // 设置“节点p的右孩子”
    private static <K,V> Entry<K,V> rightOf(Entry<K,V> p) {
        return (p == null) ? null: p.right;
    }

    // 对节点p执行“左旋”操作
    private void rotateLeft(Entry<K,V> p) {
        if (p != null) {
            Entry<K,V> r = p.right;
            p.right = r.left;
            if (r.left != null)
                r.left.parent = p;
            r.parent = p.parent;
            if (p.parent == null)
                root = r;
            else if (p.parent.left == p)
                p.parent.left = r;
            else
                p.parent.right = r;
            r.left = p;
            p.parent = r;
        }
    }

    // 对节点p执行“右旋”操作
    private void rotateRight(Entry<K,V> p) {
        if (p != null) {
            Entry<K,V> l = p.left;
            p.left = l.right;
            if (l.right != null) l.right.parent = p;
            l.parent = p.parent;
            if (p.parent == null)
                root = l;
            else if (p.parent.right == p)
                p.parent.right = l;
            else p.parent.left = l;
            l.right = p;
            p.parent = l;
        }
    }

    // 插入之后的修正操作。
    // 目的是保证：红黑树插入节点之后，仍然是一颗红黑树
    private void fixAfterInsertion(Entry<K,V> x) {
        x.color = RED;

        while (x != null && x != root && x.parent.color == RED) {
            if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
                Entry<K,V> y = rightOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == rightOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateLeft(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateRight(parentOf(parentOf(x)));
                }
            } else {
                Entry<K,V> y = leftOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == leftOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateRight(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateLeft(parentOf(parentOf(x)));
                }
            }
        }
        root.color = BLACK;
    }

    // 删除“红黑树的节点p”
    private void deleteEntry(Entry<K,V> p) {
        modCount++;
        size--;

        // If strictly internal, copy successor's element to p and then make p
        // point to successor.
        if (p.left != null && p.right != null) {
            Entry<K,V> s = successor (p);
            p.key = s.key;
            p.value = s.value;
            p = s;
        } // p has 2 children

        // Start fixup at replacement node, if it exists.
        Entry<K,V> replacement = (p.left != null ? p.left : p.right);

        if (replacement != null) {
            // Link replacement to parent
            replacement.parent = p.parent;
            if (p.parent == null)
                root = replacement;
            else if (p == p.parent.left)
                p.parent.left  = replacement;
            else
                p.parent.right = replacement;

            // Null out links so they are OK to use by fixAfterDeletion.
            p.left = p.right = p.parent = null;

            // Fix replacement
            if (p.color == BLACK)
                fixAfterDeletion(replacement);
        } else if (p.parent == null) { // return if we are the only node.
            root = null;
        } else { //  No children. Use self as phantom replacement and unlink.
            if (p.color == BLACK)
                fixAfterDeletion(p);

            if (p.parent != null) {
                if (p == p.parent.left)
                    p.parent.left = null;
                else if (p == p.parent.right)
                    p.parent.right = null;
                p.parent = null;
            }
        }
    }

    // 删除之后的修正操作。
    // 目的是保证：红黑树删除节点之后，仍然是一颗红黑树
    private void fixAfterDeletion(Entry<K,V> x) {
        while (x != root && colorOf(x) == BLACK) {
            if (x == leftOf(parentOf(x))) {
                Entry<K,V> sib = rightOf(parentOf(x));

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateLeft(parentOf(x));
                    sib = rightOf(parentOf(x));
                }

                if (colorOf(leftOf(sib))  == BLACK &&
                    colorOf(rightOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(rightOf(sib)) == BLACK) {
                        setColor(leftOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateRight(sib);
                        sib = rightOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(rightOf(sib), BLACK);
                    rotateLeft(parentOf(x));
                    x = root;
                }
            } else { // symmetric
                Entry<K,V> sib = leftOf(parentOf(x));

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateRight(parentOf(x));
                    sib = leftOf(parentOf(x));
                }

                if (colorOf(rightOf(sib)) == BLACK &&
                    colorOf(leftOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(leftOf(sib)) == BLACK) {
                        setColor(rightOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateLeft(sib);
                        sib = leftOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(leftOf(sib), BLACK);
                    rotateRight(parentOf(x));
                    x = root;
                }
            }
        }

        setColor(x, BLACK);
    }

    private static final long serialVersionUID = 919286545866124006L;

    // java.io.Serializable的写入函数
    // 将TreeMap的“容量，所有的Entry”都写入到输出流中
    private void writeObject(java.io.ObjectOutputStream s)
        throws java.io.IOException {
        // Write out the Comparator and any hidden stuff
        s.defaultWriteObject();

        // Write out size (number of Mappings)
        s.writeInt(size);

        // Write out keys and values (alternating)
        for (Iterator<Map.Entry<K,V>> i = entrySet().iterator(); i.hasNext(); ) {
            Map.Entry<K,V> e = i.next();
            s.writeObject(e.getKey());
            s.writeObject(e.getValue());
        }
    }


    // java.io.Serializable的读取函数：根据写入方式读出
    // 先将TreeMap的“容量、所有的Entry”依次读出
    private void readObject(final java.io.ObjectInputStream s)
        throws java.io.IOException, ClassNotFoundException {
        // Read in the Comparator and any hidden stuff
        s.defaultReadObject();

        // Read in size
        int size = s.readInt();

        buildFromSorted(size, null, s, null);
    }

    // 根据已经一个排好序的map创建一个TreeMap
    private void buildFromSorted(int size, Iterator it,
                 java.io.ObjectInputStream str,
                 V defaultVal)
        throws  java.io.IOException, ClassNotFoundException {
        this.size = size;
        root = buildFromSorted(0, 0, size-1, computeRedLevel(size),
                   it, str, defaultVal);
    }

    // 根据已经一个排好序的map创建一个TreeMap
    // 将map中的元素逐个添加到TreeMap中，并返回map的中间元素作为根节点。
    private final Entry<K,V> buildFromSorted(int level, int lo, int hi,
                         int redLevel,
                         Iterator it,
                         java.io.ObjectInputStream str,
                         V defaultVal)
        throws  java.io.IOException, ClassNotFoundException {

        if (hi < lo) return null;

      
        // 获取中间元素
        int mid = (lo + hi) / 2;

        Entry<K,V> left  = null;
        // 若lo小于mid，则递归调用获取(middel的)左孩子。
        if (lo < mid)
            left = buildFromSorted(level+1, lo, mid - 1, redLevel,
                   it, str, defaultVal);

        // 获取middle节点对应的key和value
        K key;
        V value;
        if (it != null) {
            if (defaultVal==null) {
                Map.Entry<K,V> entry = (Map.Entry<K,V>)it.next();
                key = entry.getKey();
                value = entry.getValue();
            } else {
                key = (K)it.next();
                value = defaultVal;
            }
        } else { // use stream
            key = (K) str.readObject();
            value = (defaultVal != null ? defaultVal : (V) str.readObject());
        }

        // 创建middle节点
        Entry<K,V> middle =  new Entry<K,V>(key, value, null);

        // 若当前节点的深度=红色节点的深度，则将节点着色为红色。
        if (level == redLevel)
            middle.color = RED;

        // 设置middle为left的父亲，left为middle的左孩子
        if (left != null) {
            middle.left = left;
            left.parent = middle;
        }

        if (mid < hi) {
            // 递归调用获取(middel的)右孩子。
            Entry<K,V> right = buildFromSorted(level+1, mid+1, hi, redLevel,
                           it, str, defaultVal);
            // 设置middle为left的父亲，left为middle的左孩子
            middle.right = right;
            right.parent = middle;
        }

        return middle;
    }

    // 计算节点树为sz的最大深度，也是红色节点的深度值。
    private static int computeRedLevel(int sz) {
        int level = 0;
        for (int m = sz - 1; m >= 0; m = m / 2 - 1)
            level++;
        return level;
    }
}
```

* TreeMap是通过红黑树实现的，TreeMap存储的是key-value键值对。
* TreeMap的排序是基于对key的排序。
* TreeMap提供了操作“key”、“key-value”、“value”等方法，也提供了对TreeMap这颗树进行整体操作的方法，如获取子树、反向树。

### 2.4.4. Entry函数

TreeMap的 firstEntry()、 lastEntry()、 lowerEntry()、 higherEntry()、 floorEntry()、 ceilingEntry()、 pollFirstEntry() 、 pollLastEntry() 原理都是类似的；下面以firstEntry()来进行详细说明

```java
public Map.Entry<K,V> firstEntry() {
    return exportEntry(getFirstEntry());
}

final Entry<K,V> getFirstEntry() {
    Entry<K,V> p = root;
    if (p != null)
        while (p.left != null)
            p = p.left;
    return p;
}
```

* firstEntry() 是对外接口； getFirstEntry() 是内部接口。
* 对firstEntry()返回的Entry对象只能进行getKey()、getValue()等读取操作；而对getFirstEntry()返回的对象除了可以进行读取操作之后，还可以通过setValue()修改值。

使用两个函数是防止用户修改返回的Entry。getFirstEntry()返回的Entry是可以被修改的，但是经过firstEntry()返回的Entry不能被修改，只可以读取Entry的key值和value值。

```java
static <K,V> Map.Entry<K,V> exportEntry(TreeMap.Entry<K,V> e) {
    return e == null? null :
        new AbstractMap.SimpleImmutableEntry<K,V>(e);
}
```

exportEntry() 是新建一个AbstractMap.SimpleImmutableEntry类型的对象，并返回。

SimpleImmutableEntry实际上是简化的key-value节点。它只提供了getKey()、getValue()方法类获取节点的值；但不能修改value的值，因为调用 setValue() 会抛出异常UnsupportedOperationException();

### 2.4.5. 遍历方式

遍历键值对

```java
// 假设map是TreeMap对象
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

遍历TreeMap的键

```java
// 假设map是TreeMap对象
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

遍历TreeMap的值

```java

// 假设map是TreeMap对象
// map中的key是String类型，value是Integer类型
Integer value = null;
Collection c = map.values();
Iterator iter= c.iterator();
while (iter.hasNext()) {
    value = (Integer)iter.next();
}
```

## 2.5. WeakHashMap

WeakHashMap 是一个散列表，它存储的内容也是键值对(key-value)映射，而且键和值都可以是null。

但是WeakHashMap的键是“弱键”。在 WeakHashMap 中，当某个键不再正常使用时，会被从WeakHashMap中被自动移除。

弱键步骤：

1. 新建WeakHashMap，将“键值对”添加到WeakHashMap中。实际上，WeakHashMap是通过数组table保存Entry(键值对)；每一个Entry实际上是一个单向链表，即Entry是键值对链表。
2. 当某“弱键”不再被其它对象引用，并被GC回收时。在GC回收该“弱键”时，这个“弱键”也同时会被添加到ReferenceQueue(queue)队列中。
3. 当下一次我们需要操作WeakHashMap时，会先同步table和queue。table中保存了全部的键值对，而queue中保存被GC回收的键值对；同步它们，就是删除table中被GC回收的键值对。

### 2.5.1. 构造函数和API

```java
// 默认构造函数。
WeakHashMap()

// 指定“容量大小”的构造函数
WeakHashMap(int capacity)

// 指定“容量大小”和“加载因子”的构造函数
WeakHashMap(int capacity, float loadFactor)

// 包含“子Map”的构造函数
WeakHashMap(Map<? extends K, ? extends V> map)

//API
void                   clear()
Object                 clone()
boolean                containsKey(Object key)
boolean                containsValue(Object value)
Set<Entry<K, V>>       entrySet()
V                      get(Object key)
boolean                isEmpty()
Set<K>                 keySet()
V                      put(K key, V value)
void                   putAll(Map<? extends K, ? extends V> map)
V                      remove(Object key)
int                    size()
Collection<V>          values()
```

### 2.5.2.  数据结构

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/weakhashmap.jpg)

1. WeakHashMap继承于AbstractMap，并且实现了Map接口。
2. WeakHashMap是哈希表，但是它的键是"弱键"。WeakHashMap中保护几个重要的成员变量：table, size, threshold, loadFactor, modCount, queue。

### 2.5.3. 源码

```java
package java.util;
import java.lang.ref.WeakReference;
import java.lang.ref.ReferenceQueue;

public class WeakHashMap<K,V>
    extends AbstractMap<K,V>
    implements Map<K,V> {

    // 默认的初始容量是16，必须是2的幂。
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    // 最大容量（必须是2的幂且小于2的30次方，传入容量过大将被这个值替换）
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    // 默认加载因子
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    // 存储数据的Entry数组，长度是2的幂。
    // WeakHashMap是采用拉链法实现的，每一个Entry本质上是一个单向链表
    private Entry[] table;

    // WeakHashMap的大小，它是WeakHashMap保存的键值对的数量
    private int size;

    // WeakHashMap的阈值，用于判断是否需要调整WeakHashMap的容量（threshold = 容量*加载因子）
    private int threshold;

    // 加载因子实际大小
    private final float loadFactor;

    // queue保存的是“已被GC清除”的“弱引用的键”。
    // 弱引用和ReferenceQueue 是联合使用的：如果弱引用所引用的对象被垃圾回收，Java虚拟机就会把这个弱引用加入到与之关联的引用队列中
    private final ReferenceQueue<K> queue = new ReferenceQueue<K>();

    // WeakHashMap被改变的次数
    private volatile int modCount;

    // 指定“容量大小”和“加载因子”的构造函数
    public WeakHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Initial Capacity: "+
                                               initialCapacity);
        // WeakHashMap的最大容量只能是MAXIMUM_CAPACITY
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;

        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal Load factor: "+
                                               loadFactor);
        // 找出“大于initialCapacity”的最小的2的幂
        int capacity = 1;
        while (capacity < initialCapacity)
            capacity <<= 1;
        // 创建Entry数组，用来保存数据
        table = new Entry[capacity];
        // 设置“加载因子”
        this.loadFactor = loadFactor;
        // 设置“WeakHashMap阈值”，当WeakHashMap中存储数据的数量达到threshold时，就需要将WeakHashMap的容量加倍。
        threshold = (int)(capacity * loadFactor);
    }

    // 指定“容量大小”的构造函数
    public WeakHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    // 默认构造函数。
    public WeakHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        threshold = (int)(DEFAULT_INITIAL_CAPACITY);
        table = new Entry[DEFAULT_INITIAL_CAPACITY];
    }

    // 包含“子Map”的构造函数
    public WeakHashMap(Map<? extends K, ? extends V> m) {
        this(Math.max((int) (m.size() / DEFAULT_LOAD_FACTOR) + 1, 16),
             DEFAULT_LOAD_FACTOR);
        // 将m中的全部元素逐个添加到WeakHashMap中
        putAll(m);
    }

    // 键为null的mask值。
    // 因为WeakReference中允许“null的key”，若直接插入“null的key”，将其当作弱引用时，会被删除。
    // 因此，这里对于“key为null”的清空，都统一替换为“key为NULL_KEY”，“NULL_KEY”是“静态的final常量”。
    private static final Object NULL_KEY = new Object();

    // 对“null的key”进行特殊处理
    private static Object maskNull(Object key) {
        return (key == null ? NULL_KEY : key);
    }

    // 还原对“null的key”的特殊处理
    private static <K> K unmaskNull(Object key) {
        return (K) (key == NULL_KEY ? null : key);
    }

    // 判断“x”和“y”是否相等
    static boolean eq(Object x, Object y) {
        return x == y || x.equals(y);
    }

    // 返回索引值
    // h & (length-1)保证返回值的小于length
    static int indexFor(int h, int length) {
        return h & (length-1);
    }

    // 清空table中无用键值对。原理如下：
    // (01) 当WeakHashMap中某个“弱引用的key”由于没有再被引用而被GC收回时，
    //   被回收的“该弱引用key”也被会被添加到"ReferenceQueue(queue)"中。
    // (02) 当我们执行expungeStaleEntries时，
    //   就遍历"ReferenceQueue(queue)"中的所有key
    //   然后就在“WeakReference的table”中删除与“ReferenceQueue(queue)中key”对应的键值对
    private void expungeStaleEntries() {
        Entry<K,V> e;
        while ( (e = (Entry<K,V>) queue.poll()) != null) {
            int h = e.hash;
            int i = indexFor(h, table.length);

            Entry<K,V> prev = table[i];
            Entry<K,V> p = prev;
            while (p != null) {
                Entry<K,V> next = p.next;
                if (p == e) {
                    if (prev == e)
                        table[i] = next;
                    else
                        prev.next = next;
                    e.next = null;  // Help GC
                    e.value = null; //  "   "
                    size--;
                    break;
                }
                prev = p;
                p = next;
            }
        }
    }

    // 获取WeakHashMap的table(存放键值对的数组)
    private Entry[] getTable() {
        // 删除table中“已被GC回收的key对应的键值对”
        expungeStaleEntries();
        return table;
    }

    // 获取WeakHashMap的实际大小
    public int size() {
        if (size == 0)
            return 0;
        // 删除table中“已被GC回收的key对应的键值对”
        expungeStaleEntries();
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // 获取key对应的value
    public V get(Object key) {
        Object k = maskNull(key);
        // 获取key的hash值。
        int h = HashMap.hash(k.hashCode());
        Entry[] tab = getTable();
        int index = indexFor(h, tab.length);
        Entry<K,V> e = tab[index];
        // 在“该hash值对应的链表”上查找“键值等于key”的元素
        while (e != null) {
            if (e.hash == h && eq(k, e.get()))
                return e.value;
            e = e.next;
        }
        return null;
    }

    // WeakHashMap是否包含key
    public boolean containsKey(Object key) {
        return getEntry(key) != null;
    }

    // 返回“键为key”的键值对
    Entry<K,V> getEntry(Object key) {
        Object k = maskNull(key);
        int h = HashMap.hash(k.hashCode());
        Entry[] tab = getTable();
        int index = indexFor(h, tab.length);
        Entry<K,V> e = tab[index];
        while (e != null && !(e.hash == h && eq(k, e.get())))
            e = e.next;
        return e;
    }

    // 将“key-value”添加到WeakHashMap中
    public V put(K key, V value) {
        K k = (K) maskNull(key);
        int h = HashMap.hash(k.hashCode());
        Entry[] tab = getTable();
        int i = indexFor(h, tab.length);

        for (Entry<K,V> e = tab[i]; e != null; e = e.next) {
            // 若“该key”对应的键值对已经存在，则用新的value取代旧的value。然后退出！
            if (h == e.hash && eq(k, e.get())) {
                V oldValue = e.value;
                if (value != oldValue)
                    e.value = value;
                return oldValue;
            }
        }

        // 若“该key”对应的键值对不存在于WeakHashMap中，则将“key-value”添加到table中
        modCount++;
        Entry<K,V> e = tab[i];
        tab[i] = new Entry<K,V>(k, value, queue, h, e);
        if (++size >= threshold)
            resize(tab.length * 2);
        return null;
    }

    // 重新调整WeakHashMap的大小，newCapacity是调整后的单位
    void resize(int newCapacity) {
        Entry[] oldTable = getTable();
        int oldCapacity = oldTable.length;
        if (oldCapacity == MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return;
        }

        // 新建一个newTable，将“旧的table”的全部元素添加到“新的newTable”中，
        // 然后，将“新的newTable”赋值给“旧的table”。
        Entry[] newTable = new Entry[newCapacity];
        transfer(oldTable, newTable);
        table = newTable;

        if (size >= threshold / 2) {
            threshold = (int)(newCapacity * loadFactor);
        } else {
            // 删除table中“已被GC回收的key对应的键值对”
            expungeStaleEntries();
            transfer(newTable, oldTable);
            table = oldTable;
        }
    }

    // 将WeakHashMap中的全部元素都添加到newTable中
    private void transfer(Entry[] src, Entry[] dest) {
        for (int j = 0; j < src.length; ++j) {
            Entry<K,V> e = src[j];
            src[j] = null;
            while (e != null) {
                Entry<K,V> next = e.next;
                Object key = e.get();
                if (key == null) {
                    e.next = null;  // Help GC
                    e.value = null; //  "   "
                    size--;
                } else {
                    int i = indexFor(e.hash, dest.length);
                    e.next = dest[i];
                    dest[i] = e;
                }
                e = next;
            }
        }
    }

    // 将"m"的全部元素都添加到WeakHashMap中
    public void putAll(Map<? extends K, ? extends V> m) {
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

        // 将“m”中的元素逐个添加到WeakHashMap中。
        for (Map.Entry<? extends K, ? extends V> e : m.entrySet())
            put(e.getKey(), e.getValue());
    }

    // 删除“键为key”元素
    public V remove(Object key) {
        Object k = maskNull(key);
        // 获取哈希值。
        int h = HashMap.hash(k.hashCode());
        Entry[] tab = getTable();
        int i = indexFor(h, tab.length);
        Entry<K,V> prev = tab[i];
        Entry<K,V> e = prev;

        // 删除链表中“键为key”的元素
        // 本质是“删除单向链表中的节点”
        while (e != null) {
            Entry<K,V> next = e.next;
            if (h == e.hash && eq(k, e.get())) {
                modCount++;
                size--;
                if (prev == e)
                    tab[i] = next;
                else
                    prev.next = next;
                return e.value;
            }
            prev = e;
            e = next;
        }

        return null;
    }

    // 删除“键值对”
    Entry<K,V> removeMapping(Object o) {
        if (!(o instanceof Map.Entry))
            return null;
        Entry[] tab = getTable();
        Map.Entry entry = (Map.Entry)o;
        Object k = maskNull(entry.getKey());
        int h = HashMap.hash(k.hashCode());
        int i = indexFor(h, tab.length);
        Entry<K,V> prev = tab[i];
        Entry<K,V> e = prev;

        // 删除链表中的“键值对e”
        // 本质是“删除单向链表中的节点”
        while (e != null) {
            Entry<K,V> next = e.next;
            if (h == e.hash && e.equals(entry)) {
                modCount++;
                size--;
                if (prev == e)
                    tab[i] = next;
                else
                    prev.next = next;
                return e;
            }
            prev = e;
            e = next;
        }

        return null;
    }

    // 清空WeakHashMap，将所有的元素设为null
    public void clear() {
        while (queue.poll() != null)
            ;

        modCount++;
        Entry[] tab = table;
        for (int i = 0; i < tab.length; ++i)
            tab[i] = null;
        size = 0;

        while (queue.poll() != null)
            ;
    }

    // 是否包含“值为value”的元素
    public boolean containsValue(Object value) {
        // 若“value为null”，则调用containsNullValue()查找
        if (value==null)
            return containsNullValue();

        // 若“value不为null”，则查找WeakHashMap中是否有值为value的节点。
        Entry[] tab = getTable();
        for (int i = tab.length ; i-- > 0 ;)
            for (Entry e = tab[i] ; e != null ; e = e.next)
                if (value.equals(e.value))
                    return true;
        return false;
    }

    // 是否包含null值
    private boolean containsNullValue() {
        Entry[] tab = getTable();
        for (int i = tab.length ; i-- > 0 ;)
            for (Entry e = tab[i] ; e != null ; e = e.next)
                if (e.value==null)
                    return true;
        return false;
    }

    // Entry是单向链表。
    // 它是 “WeakHashMap链式存储法”对应的链表。
    // 它实现了Map.Entry 接口，即实现getKey(), getValue(), setValue(V value), equals(Object o), hashCode()这些函数
    private static class Entry<K,V> extends WeakReference<K> implements Map.Entry<K,V> {
        private V value;
        private final int hash;
        // 指向下一个节点
        private Entry<K,V> next;

        // 构造函数。
        Entry(K key, V value,
          ReferenceQueue<K> queue,
              int hash, Entry<K,V> next) {
            super(key, queue);
            this.value = value;
            this.hash  = hash;
            this.next  = next;
        }

        public K getKey() {
            return WeakHashMap.<K>unmaskNull(get());
        }

        public V getValue() {
            return value;
        }

        public V setValue(V newValue) {
        V oldValue = value;
            value = newValue;
            return oldValue;
        }

        // 判断两个Entry是否相等
        // 若两个Entry的“key”和“value”都相等，则返回true。
        // 否则，返回false
        public boolean equals(Object o) {
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
        public int hashCode() {
            Object k = getKey();
            Object v = getValue();
            return  ((k==null ? 0 : k.hashCode()) ^
                     (v==null ? 0 : v.hashCode()));
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    // HashIterator是WeakHashMap迭代器的抽象出来的父类，实现了公共了函数。
    // 它包含“key迭代器(KeyIterator)”、“Value迭代器(ValueIterator)”和“Entry迭代器(EntryIterator)”3个子类。
    private abstract class HashIterator<T> implements Iterator<T> {
        // 当前索引
        int index;
        // 当前元素
        Entry<K,V> entry = null;
        // 上一次返回元素
        Entry<K,V> lastReturned = null;
        // expectedModCount用于实现fast-fail机制。
        int expectedModCount = modCount;

        // 下一个键(强引用)
        Object nextKey = null;

        // 当前键(强引用)
        Object currentKey = null;

        // 构造函数
        HashIterator() {
            index = (size() != 0 ? table.length : 0);
        }

        // 是否存在下一个元素
        public boolean hasNext() {
            Entry[] t = table;

            // 一个Entry就是一个单向链表
            // 若该Entry的下一个节点不为空，就将next指向下一个节点;
            // 否则，将next指向下一个链表(也是下一个Entry)的不为null的节点。
            while (nextKey == null) {
                Entry<K,V> e = entry;
                int i = index;
                while (e == null && i > 0)
                    e = t[--i];
                entry = e;
                index = i;
                if (e == null) {
                    currentKey = null;
                    return false;
                }
                nextKey = e.get(); // hold on to key in strong ref
                if (nextKey == null)
                    entry = entry.next;
            }
            return true;
        }

        // 获取下一个元素
        protected Entry<K,V> nextEntry() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            if (nextKey == null && !hasNext())
                throw new NoSuchElementException();

            lastReturned = entry;
            entry = entry.next;
            currentKey = nextKey;
            nextKey = null;
            return lastReturned;
        }

        // 删除当前元素
        public void remove() {
            if (lastReturned == null)
                throw new IllegalStateException();
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();

            WeakHashMap.this.remove(currentKey);
            expectedModCount = modCount;
            lastReturned = null;
            currentKey = null;
        }

    }

    // value的迭代器
    private class ValueIterator extends HashIterator<V> {
        public V next() {
            return nextEntry().value;
        }
    }

    // key的迭代器
    private class KeyIterator extends HashIterator<K> {
        public K next() {
            return nextEntry().getKey();
        }
    }

    // Entry的迭代器
    private class EntryIterator extends HashIterator<Map.Entry<K,V>> {
        public Map.Entry<K,V> next() {
            return nextEntry();
        }
    }

    // WeakHashMap的Entry对应的集合
    private transient Set<Map.Entry<K,V>> entrySet = null;

    // 返回“key的集合”，实际上返回一个“KeySet对象”
    public Set<K> keySet() {
        Set<K> ks = keySet;
        return (ks != null ? ks : (keySet = new KeySet()));
    }

    // Key对应的集合
    // KeySet继承于AbstractSet，说明该集合中没有重复的Key。
    private class KeySet extends AbstractSet<K> {
        public Iterator<K> iterator() {
            return new KeyIterator();
        }

        public int size() {
            return WeakHashMap.this.size();
        }

        public boolean contains(Object o) {
            return containsKey(o);
        }

        public boolean remove(Object o) {
            if (containsKey(o)) {
                WeakHashMap.this.remove(o);
                return true;
            }
            else
                return false;
        }

        public void clear() {
            WeakHashMap.this.clear();
        }
    }

    // 返回“value集合”，实际上返回的是一个Values对象
    public Collection<V> values() {
        Collection<V> vs = values;
        return (vs != null ?  vs : (values = new Values()));
    }

    // “value集合”
    // Values继承于AbstractCollection，不同于“KeySet继承于AbstractSet”，
    // Values中的元素能够重复。因为不同的key可以指向相同的value。
    private class Values extends AbstractCollection<V> {
        public Iterator<V> iterator() {
            return new ValueIterator();
        }

        public int size() {
            return WeakHashMap.this.size();
        }

        public boolean contains(Object o) {
            return containsValue(o);
        }

        public void clear() {
            WeakHashMap.this.clear();
        }
    }

    // 返回“WeakHashMap的Entry集合”
    // 它实际是返回一个EntrySet对象
    public Set<Map.Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> es = entrySet;
        return es != null ? es : (entrySet = new EntrySet());
    }

    // EntrySet对应的集合
    // EntrySet继承于AbstractSet，说明该集合中没有重复的EntrySet。
    private class EntrySet extends AbstractSet<Map.Entry<K,V>> {
        public Iterator<Map.Entry<K,V>> iterator() {
            return new EntryIterator();
        }

        // 是否包含“值(o)”
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry e = (Map.Entry)o;
            Object k = e.getKey();
            Entry candidate = getEntry(e.getKey());
            return candidate != null && candidate.equals(e);
        }

        // 删除“值(o)”
        public boolean remove(Object o) {
            return removeMapping(o) != null;
        }

        // 返回WeakHashMap的大小
        public int size() {
            return WeakHashMap.this.size();
        }

        // 清空WeakHashMap
        public void clear() {
            WeakHashMap.this.clear();
        }

        // 拷贝函数。将WeakHashMap中的全部元素都拷贝到List中
        private List<Map.Entry<K,V>> deepCopy() {
            List<Map.Entry<K,V>> list = new ArrayList<Map.Entry<K,V>>(size());
            for (Map.Entry<K,V> e : this)
                list.add(new AbstractMap.SimpleEntry<K,V>(e));
            return list;
        }

        // 返回Entry对应的Object[]数组
        public Object[] toArray() {
            return deepCopy().toArray();
        }

        // 返回Entry对应的T[]数组(T[]我们新建数组时，定义的数组类型)
        public <T> T[] toArray(T[] a) {
            return deepCopy().toArray(a);
        }
    }
}
```

### 2.5.4. 遍历

遍历键值对

```java
// 假设map是WeakHashMap对象
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

遍历键

```java
// 假设map是WeakHashMap对象
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

遍历值

```java
// 假设map是WeakHashMap对象
// map中的key是String类型，value是Integer类型
Integer value = null;
Collection c = map.values();
Iterator iter= c.iterator();
while (iter.hasNext()) {
    value = (Integer)iter.next();
}
```

## 2.6. 总结

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/map1.jpg)

1. Map 是“键值对”映射的抽象接口。
2. AbstractMap 实现了Map中的绝大部分函数接口。它减少了“Map的实现类”的重复编码。
3. SortedMap 有序的“键值对”映射接口。
4. NavigableMap 是继承于SortedMap的，支持导航函数的接口。
5. HashMap, Hashtable, TreeMap, WeakHashMap这4个类是“键值对”映射的实现类。

区别在于：

* HashMap 是基于“拉链法”实现的散列表。一般用于单线程程序中。
* Hashtable 也是基于“拉链法”实现的散列表。它一般用于多线程程序中。
* WeakHashMap 也是基于“拉链法”实现的散列表，它一般也用于单线程程序中。相比HashMap，WeakHashMap中的键是“弱键”，当“弱键”被GC回收时，它对应的键值对也会被从WeakHashMap中删除；而HashMap中的键是强键。
* TreeMap 是有序的散列表，它是通过红黑树实现的。它一般用于单线程中存储有序的映射。

## 2.1. HashMap与Hashtable

### 2.1.1. 相同点

两者都是存储键值对的散列表，且都基于拉链法。

存储实现是：通过table数组存储，数组的每一个元素都是一个Entry；而一个Entry就是一个单向链表，Entry链表中的每一个节点就保存了key-value键值对数据。

添加key-value键值对：首先，根据key值计算出哈希值，再计算出数组索引(即，该key-value在table中的索引)。然后，根据数组索引找到Entry(即，单向链表)，再遍历单向链表，将key和链表中的每一个节点的key进行对比。若key已经存在Entry链表中，则用该value值取代旧的value值；若key不存在Entry链表中，则新建一个key-value节点，并将该节点插入Entry链表的表头位置。

删除key-value键值对：删除键值对，相比于“添加键值对”来说，简单很多。首先，还是根据key计算出哈希值，再计算出数组索引(即，该key-value在table中的索引)。然后，根据索引找出Entry(即，单向链表)。若节点key-value存在与链表Entry中，则删除链表中的节点即可。

### 2.1.2. 不同点

HashMap 继承于AbstractMap，实现了Map、Cloneable、java.io.Serializable接口。

Hashtable 继承于Dictionary，实现了Map、Cloneable、java.io.Serializable接口。

其中：

* 实现了Map接口，意味着它们都支持key-value键值对操作。支持“添加key-value键值对”、“获取key”、“获取value”、“获取map大小”、“清空map”等基本的key-value键值对操作。
* 实现了Cloneable接口，意味着它能被克隆。
* 实现了java.io.Serializable接口，意味着它们支持序列化，能通过序列化去传输。

1. 线程安全上：

* Hashtable的几乎所有函数都是同步的，即它是线程安全的，支持多线程。
而HashMap的函数则是非同步的，它不是线程安全的。

2. null值的处理不同：

* HashMap的key、value都可以为null。
* Hashtable的key、value都不可以为null。

3. 支持遍历方式上：
   
Dictionary一般是通过Enumeration(枚举类)去遍历，Map则是通过Iterator(迭代器)去遍历。 然而由于Hashtable也实现了Map接口，所以，它即支持Enumeration遍历，也支持Iterator遍历。

* HashMap是“从前向后”的遍历数组；再对数组具体某一项对应的链表，从表头开始进行遍历。
* Hashtabl是“从后往前”的遍历数组；再对数组具体某一项对应的链表，从表头开始进行遍历。

4. 容量初值和增加方式：

* HashMap默认的容量大小是16；增加容量时，每次将容量变为“原始容量x2”。
* Hashtable默认的容量大小是11；增加容量时，每次将容量变为“原始容量x2 + 1”。

5. 添加key-value时的hash值算法

* HashMap添加元素时，是使用自定义的哈希算法。
* Hashtable没有自定义哈希算法，而直接采用的key的hashCode()。

## 2.2. HashMap和WeakHashMap

相同点：
1. 它们都是散列表，存储的是“键值对”映射。
2. 它们都继承于AbstractMap，并且实现Map基础。
3. 它们的构造函数都一样,都包括4个构造函数，而且函数的参数都一样。
4. 默认的容量大小是16，默认的加载因子是0.75。
5. 它们的“键”和“值”都允许为null。
6. 它们都是“非同步的”

不同点：
1. HashMap实现了Cloneable和Serializable接口，而WeakHashMap没有。
2. HashMap的“键”是“强引用(StrongReference)”，而WeakHashMap的键是“弱引用(WeakReference)”。
   
“弱键”能实现WeakReference对“键值对”的动态回收：
1. 新建WeakHashMap，将“键值对”添加到WeakHashMap中。
2. 当某“弱键”不再被其它对象引用，并被GC回收时。在GC回收该“弱键”时，这个“弱键”也同时会被添加到queue队列中。
3. 当下一次我们需要操作WeakHashMap时，会先同步table和queue。table中保存了全部的键值对，而queue中保存被GC回收的“弱键”；同步它们，就是删除table中被GC回收的“弱键”对应的键值对。

# 3. Set