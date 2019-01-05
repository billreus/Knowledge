# 1. Java内存区域与内存溢出异常

虚拟机实现了自动内存管理机制，不用为每一个new操作配对delete/free代码，也不容易出现内存泄露和内存溢出。

## 1.1. 数据区域

Java虚拟机在执行程序时会把所管理的内存划分成若干个数据区域。每个区域有各自的用途，创建和销毁时间。

主要有五个区域：

1. 方法区(Method Area)
2. 虚拟机栈(VM Stack)
3. 本地方法栈(Native Method Stack)
4. 堆(Heap)
5. 程序计数器(Program Counter Register)

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/suju.png)

### 1.1.1. 程序计数器

程序计数器是一块较小的内存空间，记录正在执行的虚拟机字节码指令的地址。

字节码解释器工作时就是通过改变计数器的值来选取下一条需要执行的字节码指令，分支、循环、跳转、异常处理等基础功能都需要依赖这个计数器完成。

### 1.1.2. 虚拟机栈

虚拟机栈描述的是Java方法执行的内存模型，每个方法在执行的同时会创建一个栈帧用于存储局部变量、操作数栈、动态连接、方法出口等信息。每个方法从执行到执行完成对应着一个栈帧在虚拟机栈中入栈到出栈。

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/xunijizhan.png)

### 1.1.3. 本地方法栈

与虚拟机栈作用相似，虚拟机栈为虚拟机执行Java方法，本地方法栈为虚拟机使用到的本地方法服务。

### 1.1.4. Java堆

所有对象都在这里分配内存，是垃圾收集的主要区域（"GC 堆"）。

是Java虚拟机管理的内存中最大一块，在虚拟机启动时创建。用于存放对象实例，对象实例在这里分配内存。

现代的垃圾收集器基本都是采用分代收集算法，其主要的思想是针对不同类型的对象采取不同的垃圾回收算法。

所有通过new创建的对象的内存都在堆中分配，其大小可以通过-Xmx和-Xms来控制。堆被划分为新生代和旧生代，新生代又被进一步划分为Eden和Survivor区，最后Survivor由FromSpace和ToSpace组成，结构图如下所示：

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/xin.jpg)

新建的对象都是用新生代分配内存，Eden空间不足的时候，会把存活的对象转移到Survivor中，新生代大小可以由-Xmn来控制，也可以用-XX:SurvivorRatio来控制Eden和Survivor的比例旧生代。

### 1.1.5. 方法区

与Java堆一样是各个线程共享的内存区域，用于存放已被加载的类信息、常量、静态变量、即时编译器编译后的代码等数据。

### 1.1.6. 运行时常量池

是方法区的一部分，用于存放编译器生成的各种字面量和符号引用，这部分内容在类加载后进入方法区运行时存放在常量池中。

### 1.1.7 直接内存

在 JDK 1.4 中新加入了 NIO 类，它可以使用 Native 函数库直接分配堆外内存（Native 堆），然后通过一个存储在 Java 堆里的 DirectByteBuffer 对象作为这块内存的引用进行操作。

这样能在一些场景中显著提高性能，因为避免了在 Java 堆和 Native 堆中来回复制数据。

## 1.2. 虚拟机对象

### 1.2.1. 对象的创建

1. 检查这个指令的参数是否能在常量池中定位到一个类的符号引用，并检查这个符号引用代表的类是否已被加载、解析和初始化过。如果没有先执行相应类的加载
2. 虚拟机为新生对象分配内存
3. 虚拟机对对象进行必要的设置，例如是哪个类的实例，如何找到类的元数据，对象哈希码等

### 1.2.2. 对象的内存分布

对象在内存中存储分布可以分为3块区域：对象头，实例数据，对齐填充

对象头分为两部分，一部分是用于存储对象自身运行的数据，如哈希码，锁的标志位，GC分代年龄等，其被称为Mark Word；另一部分是类型指针，用于确定这个对象是哪个类的实例。

实例数据是对象真正存储的有效信息，即代码中定义的各种类型的字段内容。

### 1.2.3. 对象的访问定位

通过栈上的reference数据来操作堆上的具体对象。

访问方式：
1. 句柄访问
2. 直接指针访问

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/jubin.jpg)

句柄访问时Java堆中会划分一块内存作为句柄池，reference中存储的对象就是句柄地址，句柄中包含了对象实例数据与类型数据各自的具体信息地址。

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/zhizhen.jpg)

直接指针访问必须考虑如何放置访问类型数据的相关信息，reference中存储的是对象地址。

句柄访问在对象移动只虚改变指针即可，而直接访问好处是速度更快，目前虚拟机使用第二种。

# 2. 垃圾收集器与内存分配策略

## 2.1. 判断对象是否可被回收算法

### 2.1.1. 引用计数算法

给对象添加一个引用计数器，当对象增加一个引用时计数器加 1，引用失效时计数器减 1。引用计数为 0 的对象可被回收。

两个对象出现循环引用的情况下，此时引用计数器永远不为 0，导致无法对它们进行回收。

### 2.1.2. 可达性算法

通过 GC Roots 作为起始点进行搜索，能够到达到的对象都是存活的，不可达的对象可被回收。

Java 虚拟机使用该算法来判断对象是否可被回收，在 Java 中 GC Roots 一般包含以下内容：

* 虚拟机栈中局部变量表中引用的对象
* 本地方法栈中 JNI 中引用的对象
* 方法区中类静态属性引用的对象
* 方法区中的常量引用的对象

## 2.2. 引用类型

无论是通过引用计数算法判断对象的引用数量，还是通过可达性分析算法判断对象是否可达，判定对象是否可被回收都与引用有关。

### 2.2.1. 强引用

被强引用关联的对象不会被回收。

使用 new 一个新对象的方式来创建强引用。

```java
Object obj = new Object();
```

### 2.2.2. 软引用

被软引用关联的对象只有在内存不够的情况下才会被回收。

使用 SoftReference 类来创建软引用。

```java
Object obj = new Object();
SoftReference<Object> sf = new SoftReference<Object>(obj);
obj = null;  // 使对象只被软引用关联
```

### 2.2.3. 弱引用

被弱引用关联的对象一定会被回收，也就是说它只能存活到下一次垃圾回收发生之前。

使用 WeakReference 类来实现弱引用。

```java
Object obj = new Object();
WeakReference<Object> wf = new WeakReference<Object>(obj);
obj = null;
```

### 2.2.4. 修引用

又称为幽灵引用或者幻影引用。一个对象是否有虚引用的存在，完全不会对其生存时间构成影响，也无法通过虚引用取得一个对象。

为一个对象设置虚引用关联的唯一目的就是能在这个对象被回收时收到一个系统通知。

使用 PhantomReference 来实现虚引用。

```java
Object obj = new Object();
PhantomReference<Object> pf = new PhantomReference<Object>(obj);
obj = null;
```

## 2.3. 垃圾收集算法

### 2.2.1. 标记-清除算法

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/laji1.jpg)

首先标记出所有需要回收的对象，在标记完成后统一回收所有被标记的对象。

不过效率不高，清除后会产生大量不连续内存碎片，导致无法给大对象分配内存。

### 2.2.2. 复制算法

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/laji3.jpg)

用内存按容量划分两个大小相等的两块，每次只用一块，当一块内存用完了就把还活着的对象复制到另一块上面，把已使用过的内存空间一次清理掉。

使得每次都是对整个半区进行内存回收，内存分配也不用考虑碎片，只需要移动堆顶指针，简单高效，不过代价是内存缩小一半。

### 2.2.3. 标记-整理算法

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/laji2.jpg)

与复制相似，不过不是直接对可回收对象进行清理，而是让所有存活的对象都向一端移动，然后直接清理掉端边界以外的内存。

### 2.2.4. 分代收集

现在的商业虚拟机采用分代收集算法，它根据对象存活周期将内存划分为几块，不同块采用适当的收集算法。

一般将堆分为新生代和老年代。

* 新生代使用：复制算法
* 老年代使用：标记 - 清除 或者 标记 - 整理 算法

## 2.4. 垃圾收集器

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/huisou.jpg)

HotSpot虚拟机中有7个垃圾收集器，连线表示垃圾收集器可以配合使用

### 2.4.1. Serial收集器

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/serial.jpg)

Serial 翻译为串行，也就是说它以串行的方式执行。

它是单线程的收集器，只会使用一个线程进行垃圾收集工作。

它的优点是简单高效，对于单个 CPU 环境来说，由于没有线程交互的开销，因此拥有最高的单线程收集效率。

### 2.4.2. ParNew收集器

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/parnew.jpg)

它是 Serial 收集器的多线程版本。

是 Server 模式下的虚拟机首选新生代收集器，除了性能原因外，主要是因为除了 Serial 收集器，只有它能与 CMS 收集器配合工作。

默认开启的线程数量与 CPU 数量相同，可以使用 -XX:ParallelGCThreads 参数来设置线程数。

### 2.4.3. Parallel Scavenge收集器

与 ParNew 一样是多线程收集器。

其它收集器关注点是尽可能缩短垃圾收集时用户线程的停顿时间，而它的目标是达到一个可控制的吞吐量，它被称为“吞吐量优先”收集器。这里的

* 吞吐量指 CPU 用于运行用户代码的时间占总时间的比值。高吞吐量则可以高效率地利用 CPU 时间，尽快完成程序的运算任务，适合在后台运算而不需要太多交互的任务。

### 2.4.4. CMS收集器

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/CMS.jpg)

CMS（Concurrent Mark Sweep），Mark Sweep 指的是标记 - 清除算法。

分为以下四个流程：

1. 初始标记：仅仅只是标记一下 GC Roots 能直接关联到的对象，速度很快，需要停顿。
2. 并发标记：进行 GC Roots Tracing 的过程，它在整个回收过程中耗时最长，不需要停顿。
3. 重新标记：为了修正并发标记期间因用户程序继续运作而导致标记产生变动的那一部分对象的标记记录，需要停顿。
4. 并发清除：不需要停顿。

缺点：
1. 吞吐量低。
2. 无法处理浮动垃圾。（浮动垃圾是指并发清除阶段由于用户线程继续运行而产生的垃圾）
3. 标记 - 清除算法导致的空间碎片

### 2.4.5. G1收集器

堆被分为新生代和老年代，其它收集器进行收集的范围都是整个新生代或者老年代，而 G1 可以直接对新生代和老年代一起回收。

G1 把堆划分成多个大小相等的独立区域（Region），新生代和老年代不再物理隔离。

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/g1.png)

通过引入 Region 的概念，从而将原来的一整块内存空间划分成多个的小空间，使得每个小空间可以单独进行垃圾回收。通过记录每个 Region 垃圾回收时间以及回收所获得的空间（这两个值是通过过去回收的经验获得），并维护一个优先列表，每次根据允许的收集时间，优先回收价值最大的 Region。

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/G1.jpg)

# 3. 内存分配与回收策略

## 3.1. Minor GC 和 Full GC

Minor GC：发生在新生代上，因为新生代对象存活时间很短，因此 Minor GC 会频繁执行，速度较快。

Full GC：发生在老年代上，老年代对象其存活时间长，因此 Full GC 很少执行，执行速度会比 Minor GC 慢很多。

## 3.2. 内存分配策略

### 1. 对象优先在Eden分配
对象在新生代Eden区分配，当Eden区空间不够时会Minor GG。

### 2. 大对象直接进入老年代

大对象是指需要连续内存空间的对象，最典型的大对象是那种很长的字符串以及数组。

经常出现大对象会提前触发垃圾收集以获取足够的连续空间分配给大对象。

### 3. 长期存活对象进入老年代

为对象定义年龄计数器，对象在 Eden 出生并经过 Minor GC 依然存活，将移动到 Survivor 中，年龄就增加 1 岁，增加到一定年龄则移动到老年代中。

* MaxTenuringThreshold 用来定义年龄的阈值

### 4. 动态对象年龄判断

虚拟机并不是永远地要求对象的年龄必须达到 MaxTenuringThreshold 才能晋升老年代，如果在 Survivor 中相同年龄所有对象大小的总和大于 Survivor 空间的一半，则年龄大于或等于该年龄的对象可以直接进入老年代，无需等到 MaxTenuringThreshold 中要求的年龄。

### 5. 空间分配担保

在发生 Minor GC 之前，虚拟机先检查老年代最大可用的连续空间是否大于新生代所有对象总空间，如果大于，则Minor GC是安全的。

如果小于，虚拟机会查看 HandlePromotionFailure 设置值是否允许担保失败，如果允许那么就会继续检查老年代最大可用的连续空间是否大于历次晋升到老年代对象的平均大小，如果大于，将尝试着进行一次 Minor GC；如果小于，或者 HandlePromotionFailure 设置不允许冒险，那么就要进行一次 Full GC。

## 3.3. Full GC 的触发条件

Minor GC，其触发条件非常简单，当 Eden 空间满时，就将触发一次 Minor GC。

以下条件会触发Full GC:
1. 调用System.gc():建议虚拟机执行 Full GC，但是虚拟机不一定真正去执行
2. 老年代空间不足
3. 空间分配担保失败
4. Concurrent Mode Failure：执行 CMS GC 的过程中同时有对象要放入老年代，而此时老年代空间不足（可能是 GC 过程中浮动垃圾过多导致暂时性的空间不足），便会报 Concurrent Mode Failure 错误，并触发 Full GC。

# 4. 类加载机制

类是在运行期间第一次使用时动态加载的，而不是编译时期一次性加载。因为如果在编译时期一次性加载，那么会占用很多的内存。

## 4.1. 类的生命周期

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/class.jpg)

生命周期即上图7个阶段

## 4.2. 类加载过程

### 4.2.1. 加载

加载过程主要有三件事：
1. 通过一个类的全限定名来获取定义此类的二进制字节流。
2. 将这个字节流所代表的静态存储结构转化为方法区的运行时存储结构。
3. 在内存中生成一个代表这个类的 Class 对象，作为方法区这个类的各种数据的访问入口。

* 加载是类加载的一个阶段

### 4.2.2. 验证

确保 Class 文件的字节流中包含的信息符合当前虚拟机的要求，并且不会危害虚拟机自身的安全。

### 4.2.3. 准备

实例变量不会在这阶段分配内存，它将会在对象实例化时随着对象一起分配在堆中。

如果类变量是被 static 修饰的变量，准备阶段会为类变量分配内存并设置初始值，使用的是方法区的内存。

* 初始值一般为0，例如：

下面的类变量 value 被初始化为 0 而不是 123。

```java
public static int value = 123;
```

如果类变量是常量，那么会按照表达式来进行初始化，而不是赋值为 0。

```java
public static final int value = 123;
```

### 4.2.4. 解析

将常量池的符号引用替换为直接引用的过程。

### 4.2.5. 初始化

初始化阶段才真正开始执行类中定义的 Java 程序代码。初始化阶段即虚拟机执行类构造器 <clinit>() 方法的过程。

<clinit>()特点：