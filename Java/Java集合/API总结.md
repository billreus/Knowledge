<!-- TOC -->

- [Collection](#collection)
  - [List](#list)
    - [ArrayList](#arraylist)
    - [LinkList](#linklist)
    - [Vector](#vector)
    - [Stack](#stack)
  - [Set](#set)
    - [HashSet](#hashset)
    - [TreeSet](#treeset)
- [Map](#map)
  - [HashMap](#hashmap)
  - [HashTable](#hashtable)
  - [TreeMap](#treemap)

<!-- /TOC -->

# Collection

Collection主要包括：添加、清空、是否包含、等于、是否为空、遍历、删除、获取大小、转换为数组

```java
// Collection
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

## List

list继承了collection并新增了：添加指定位置元素、获取指定位置元素、获取指定元素索引、获取指定元素最后一个索引、list迭代器（有add方法，可实现逆向遍历，可定位当前索引位置，可修改对象）、删除指定位置元素、修改指定位置元素、获取list子队列

```java
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

### ArrayList

继承了Collection和List中的API，并新增了：克隆、自定义扩容、自动缩小容量、删除指定位置序列

```java
Object               clone()
void                 ensureCapacity(int minimumCapacity)
void                 trimToSize()
void                 removeRange(int fromIndex, int toIndex)
```

### LinkList

LinkList继承了Collection和List的API，新增了从头尾添加、删除、获取，队列的push/offer,peek,pop/poll。

```java
//LinkedList中新增API
void          addFirst(E object)
void          addLast(E object)
Object        clone()
Iterator<E>   descendingIterator()
E             element()
E             getFirst()
E             getLast()
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
E             removeFirst()
boolean       removeFirstOccurrence(Object o)
E             removeLast()
boolean       removeLastOccurrence(Object o)
```

### Vector

LinkList继承了Collection和List的API并线程安全，新增了从指定位置的添加、删除、获取、删除、修改

```java
synchronized boolean        addAll(Collection<? extends E> collection)
synchronized void           addElement(E object)
synchronized int            capacity()
synchronized Object         clone()
synchronized void           copyInto(Object[] elements)
synchronized E              elementAt(int location)
             Enumeration<E> elements()
synchronized void           ensureCapacity(int minimumCapacity)
synchronized E              firstElement()
synchronized int            indexOf(Object object, int location)
synchronized void           insertElementAt(E object, int location)
synchronized E              lastElement()
synchronized int            lastIndexOf(Object object, int location)
synchronized void           removeAllElements()
synchronized boolean        removeElement(Object object)
synchronized void           removeElementAt(int location)
synchronized void           setElementAt(E object, int location)
synchronized void           setSize(int length)
synchronized String         toString()
synchronized void           trimToSize()
```

### Stack

Stack继承了Vector的全部API，并添加了栈的peek,push,pop和search

```java
             boolean       empty()
synchronized E             peek()
synchronized E             pop()
             E             push(E object)
synchronized int           search(Object o)
```

## Set

与Collection完全一样

### HashSet

与Set一样

### TreeSet

继承了Set的API并添加了树操作

```java
//API
Object                    clone()
E                         first()
boolean                   isEmpty()
E                         last()
E                         pollFirst()
E                         pollLast()
E                         lower(E e)
E                         floor(E e)
E                         ceiling(E e)
E                         higher(E e)
Comparator<? super E>     comparator()
Iterator<E>               descendingIterator()
SortedSet<E>              headSet(E end)
NavigableSet<E>           descendingSet()
NavigableSet<E>           headSet(E end, boolean endInclusive)
SortedSet<E>              subSet(E start, E end)
NavigableSet<E>           subSet(E start, boolean startInclusive, E end, boolean endInclusive)
NavigableSet<E>           tailSet(E start, boolean startInclusive)
SortedSet<E>              tailSet(E start)
```

# Map

map的API主要是对键值对的操作：判断是否含有键、值，返回键值集、获取键、判断是否为空、返回键集、添加键值对、删除指定键、长度、返回值集

```java
//Map的API
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

//Entry的API，添加了对于键值的获取和对于值的修改
abstract boolean     equals(Object object)
abstract K             getKey()
abstract V             getValue()
abstract int         hashCode()
abstract V             setValue(V object)
```

## HashMap

继承了Map的API

## HashTable

相比Map多了对于枚举类的值

```java
synchronized Object              clone()
             boolean             contains(Object value)
synchronized Enumeration<V>      elements()
synchronized Enumeration<K>      keys()
synchronized String              toString()
```

## TreeMap

对于树的各层操作

```java
Entry<K, V>                ceilingEntry(K key)
K                          ceilingKey(K key)
Object                     clone()
Comparator<? super K>      comparator()
NavigableSet<K>            descendingKeySet()
NavigableMap<K, V>         descendingMap()
Entry<K, V>                firstEntry()
K                          firstKey()
Entry<K, V>                floorEntry(K key)
K                          floorKey(K key)
NavigableMap<K, V>         headMap(K to, boolean inclusive)
SortedMap<K, V>            headMap(K toExclusive)
Entry<K, V>                higherEntry(K key)
K                          higherKey(K key)
Entry<K, V>                lastEntry()
K                          lastKey()
Entry<K, V>                lowerEntry(K key)
K                          lowerKey(K key)
NavigableSet<K>            navigableKeySet()
Entry<K, V>                pollFirstEntry()
Entry<K, V>                pollLastEntry()
SortedMap<K, V>            subMap(K fromInclusive, K toExclusive)
NavigableMap<K, V>         subMap(K from, boolean fromInclusive, K to, boolean toInclusive)
NavigableMap<K, V>         tailMap(K from, boolean inclusive)
SortedMap<K, V>            tailMap(K fromInclusive)
```