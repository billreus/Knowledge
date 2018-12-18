<!-- TOC -->

- [1. 概念](#1-概念)
    - [1.1. 同步异步](#11-同步异步)
    - [1.2. 并发和并行](#12-并发和并行)
    - [1.3. 临界区](#13-临界区)
    - [1.4. 阻塞和非阻塞](#14-阻塞和非阻塞)
    - [1.5. 死锁、饥饿、活锁](#15-死锁饥饿活锁)
    - [1.6. 并发级别](#16-并发级别)
- [2. 并发操作](#2-并发操作)
    - [2.1. 线程基本操作](#21-线程基本操作)
        - [2.1.1. Runnable接口](#211-runnable接口)
        - [2.1.2. Callable接口](#212-callable接口)
        - [2.1.3. 继承Thread类](#213-继承thread类)
    - [2.2. 线程中断](#22-线程中断)
        - [2.2.1. InterruptedException](#221-interruptedexception)
        - [2.2.2. interrupted()](#222-interrupted)
        - [2.2.3. sleep()](#223-sleep)
    - [2.3. 等待(wait)和通知(notify)](#23-等待wait和通知notify)
    - [2.4. 等待线程结束(join)和谦让(yield)](#24-等待线程结束join和谦让yield)
    - [2.5. 线程组](#25-线程组)
    - [2.6. 守护线程](#26-守护线程)
    - [2.7. 线程优先级](#27-线程优先级)
        - [2.8 线程安全synchronized](#28-线程安全synchronized)
        - [2.8.1. 加锁](#281-加锁)
        - [2.8.2. 同步与非同步块](#282-同步与非同步块)
        - [2.8.3. 实例锁与全局锁](#283-实例锁与全局锁)
    - [2.9. 同步控制](#29-同步控制)
        - [2.9.1. Condition条件](#291-condition条件)
        - [2.9.2. 信号量](#292-信号量)
        - [2.9.3. 读写锁ReadWriteLock](#293-读写锁readwritelock)
        - [2.9.4. 倒计时器CountDownLatch](#294-倒计时器countdownlatch)
        - [2.9.5. 循环栅栏CyclicBarrier](#295-循环栅栏cyclicbarrier)
        - [2.9.6. 线程阻塞工具LockSupport](#296-线程阻塞工具locksupport)
    - [2.10. 线程复用：线程池](#210-线程复用线程池)
        - [2.10.1. Executor框架](#2101-executor框架)
        - [2.10.2. Fork/Join框架](#2102-forkjoin框架)
- [3. 锁](#3-锁)
    - [3.1. ThreadLocal](#31-threadlocal)
    - [3.2. 无锁](#32-无锁)
        - [3.2.1. 比较交换(CAS)](#321-比较交换cas)
        - [3.2.2. 无锁线程安全整数Atomiclnteger](#322-无锁线程安全整数atomiclnteger)
- [4. 并行模式与算法](#4-并行模式与算法)
    - [4.1. 单例模式](#41-单例模式)
    - [4.2. 不变模式](#42-不变模式)
    - [4.3. 生产者-消费者模式](#43-生产者-消费者模式)
    - [4.4. 网络NIO](#44-网络nio)
        - [4.4.1. NIO--channel](#441-nio--channel)
    - [4.5. 异步IO](#45-异步io)
- [5. Java8并发](#5-java8并发)

<!-- /TOC -->

# 1. 概念

## 1.1. 同步异步

同步和异步用来形容一次方法调用，同步方法调用必须等到调用返回后才能继续后继行为，异步方法调用就会立即返回，调用者可以继续后续工作。

## 1.2. 并发和并行

并发和并行都可以表示两个或者多个任务一起执行，并发侧重于多个任务交替进行，且多个任务之间可能还是串行的，而并行是真正意义上的同时执行。

## 1.3. 临界区

临界区表示一种公共资源可以被多个线程使用，但是每次只能有一个线程使用它，一旦临界区资源被占用，其他线程只能等待。

## 1.4. 阻塞和非阻塞

阻塞非阻塞用来形容多线程间的互相影响。比如一个线程占用了临界区资源，那么其他需要资源的线程在临界区等待，等待会导致线程挂起即阻塞。非阻塞即没有线程阻碍其他线程执行。

## 1.5. 死锁、饥饿、活锁

都属于多线程活跃性问题，死锁是互相占用资源导致这种状态永远维持；饥饿指一个或者多个线程因为种种原因无法获得所需资源导致无法执行；活锁即不断让出资源，而没有一个线程可以拿到需要的资源而正常执行。

## 1.6. 并发级别

并发级别可以分成：阻塞，无饥饿，无阻碍，无锁，无等待。

1. 阻塞：一个线程是阻塞的，其他线程会等待。使用synchronized关键字或者重入锁时就是阻塞线程。
2. 无饥饿：所有线程排队，不允许优先级高的插队。
3. 无障碍：允许所有线程进入临界区，一起共享数据，如果出错，进行回滚。
4. 无锁：并行是无障碍的，并行时保证必然有一个线程在有限步内完成操作离开临界区。
5. 无等待：所有线程在有限步完成操作。

# 2. 并发操作

所有线程的状态都在Thread中的State枚举中定义

```java
public enum State{NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED;}
```

![Image text](https://github.com/billreus/Konwledge/blob/master/picture/state.jpg)

1. NEW状态表示刚刚创建的线程，例如Thread thread = new Thread()
2. 当线程调用了该对象的start()方法时，处于RUNNABLE状态，随时可能被CPU调度进入Running状态
3. 线程因为某种原因放弃CPU使用权，暂停运行会进入Blocked状态。阻塞状态分为三种：
   * 调用wait()方法让线程等待某工作完成。---等待阻塞。
   * 线程执行中获取synchronized同步锁失败（遇到synchronized同步块）就会进入BLOCKED阻塞状态，会暂停执行，直到获得请求锁。---同步阻塞
   * 调用sleep()或者jion()或发出IO请求，线程会进入到阻塞状态。当sleep()状态超时、join()等待线程终止或者超时、或者I/O处理完毕时，线程重新转入就绪状态。---其他阻塞
4. 线程执行完了或者因异常退出了run()方法，进入TERMINATED状态表示该线程结束生命周期。

## 2.1. 线程基本操作

使用线程一共有三种方法：

* 实现Runnable接口;
* 实现Callable接口;
* 继承Tread类;

实现 Runnable 和 Callable 接口的类只能当做一个可以在线程中运行的任务，不是真正意义上的线程，因此最后还需要通过 Thread 来调用

### 2.1.1. Runnable接口

实现run方法，通过Thread调用start()方法来启动线程。

```java
public class MyRunnable implements Runnable {
    public void run() {
        // ...
    }
}
```

```JAVA
public static void main(String[] args) {
    MyRunnable instance = new MyRunnable();
    Thread thread = new Thread(instance);
    thread.start();
}
```

### 2.1.2. Callable接口

与 Runnable 相比，Callable 可以有返回值，返回值通过 FutureTask 进行封装。

```java
public class MyCallable implements Callable<Integer> {
    public Integer call() {
        return 123;
    }
}
```

```JAVA
public static void main(String[] args) throws ExecutionException, InterruptedException {
    MyCallable mc = new MyCallable();
    FutureTask<Integer> ft = new FutureTask<>(mc);
    Thread thread = new Thread(ft);
    thread.start();
    System.out.println(ft.get());
}
```

### 2.1.3. 继承Thread类

同样需要实现run()方法，因为Thread类也实现了Runable接口

```java
public class MyThread extends Thread {
    public void run() {
        // ...
    }
}
```

```java
public static void main(String[] args) {
    MyThread mt = new MyThread();
    mt.start();
}
```

相对于继承Thread使用接口实现会更好一些，因为继承了Thread类就无法继承其它类，但可以实现多个接口且继承整个Thread类开销过大。

## 2.2. 线程中断

线程中断不会让线程立即退出，而是发给线程一个通知，至于线程接到通知后如何处理完全由目标线程自行决定。

线程中断有关的有三个方法：

```java
public void Thread.interrupt() //中断线程
public boolean Thread.isInterrupted() //判断是否被中断
public static boolean Thread.interrupted() //判断是否被中断，并清除当前中断状态
```

### 2.2.1. InterruptedException

通过调用一个线程的 interrupt() 来中断该线程，如果该线程处于阻塞、限期等待或者无限期等待状态，那么就会抛出 InterruptedException，从而提前结束该线程。但是不能中断 I/O 阻塞和 synchronized 锁阻塞。

对于以下代码，在 main() 中启动一个线程之后再中断它，由于线程中调用了 Thread.sleep() 方法，因此会抛出一个 InterruptedException，从而提前结束线程，不执行之后的语句。

```java
public class InterruptExample {

    private static class MyThread1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

```java
public static void main(String[] args) throws InterruptedException {
    Thread thread1 = new MyThread1();
    thread1.start();
    thread1.interrupt();
    System.out.println("Main run");
}
```

### 2.2.2. interrupted()

如果一个线程的 run() 方法执行一个无限循环，并且没有执行 sleep() 等会抛出 InterruptedException 的操作，那么调用线程的 interrupt() 方法就无法使线程提前结束。

但是调用 interrupt() 方法会设置线程的中断标记，此时调用 interrupted() 方法会返回 true。因此可以在循环体中使用 interrupted() 方法来判断线程是否处于中断状态，从而提前结束线程。

```java
public class InterruptExample {

    private static class MyThread2 extends Thread {
        @Override
        public void run() {
            while (!interrupted()) {
                // ..
            }
            System.out.println("Thread end");
        }
    }
}
```

```java
public static void main(String[] args) throws InterruptedException {
    Thread thread2 = new MyThread2();
    thread2.start();
    thread2.interrupt();
}
```

### 2.2.3. sleep()

Thread.sleep(millisec) 方法会休眠当前正在执行的线程，millisec 单位为毫秒

sleep() 可能会抛出 InterruptedException，因为异常不能跨线程传播回 main() 中，因此必须在本地进行处理。线程中抛出的其它异常也同样需要在本地进行处理。

```java
public void run() {
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
```

## 2.3. 等待(wait)和通知(notify)

属于输出Object类的方法

```java
public final void wait() throws InterruptedException
public final native void notify()
```

当一个对象使用了wait()方法以后，该线程就好停止继续执行变成等待状态，等到其他线程调用obj.notify()方法为止。

* 在等待中的线程会在等待队列中，当notify()被调用时会随机选择一个线程唤醒。

该方法的调用都需要首先获得目标对象的一个监视器，在wait()方法执行后会释放这个监视器。

wait()和sleep()的区别在于：

* wait() 是 Object 的方法，而 sleep() 是 Thread 的静态方法；
* wait() 会释放锁，sleep() 不会。

## 2.4. 等待线程结束(join)和谦让(yield)

join有两个方法：

```java
public final void join() throws InterruptedException
public final synchronized void join(long mills) throws InterruptedException
```

第一个方法表示无限等待，会一直阻塞当前线程，直到目标线程执行完毕。第二个方法会给出一个最大等待时间，超过时间线程会继续执行下去。

`public static native void yield();`是一个静态方法，会让当前线程让出CPU。一般用于优先级非常低的功能上。

```java
public void run(){
    Thread.yield();
}
```

## 2.5. 线程组

当线程数量很多时，可以把相同功能的线程放在一个线程组里。

```java
ThreadGroup tq = new ThreadGroup("groupname");
System.out.println(tg.activeCount()); //线程数
tg.list(); //打印线程组中所有线程信息
```

## 2.6. 守护线程

```java
Thread t = new DaemonT(); //Daemont为线程功能设置的自己写的类
t.setDamon(true); //线程守护，必须在start之前
t.start();
```

可以使main中主线程结束后，整个线程结束，用户线程不会继续执行。

## 2.7. 线程优先级

线程优先级使用1到10表示，一般可以用内置的三个静态标量表示：

```java
public final static int MIN_PRIORITY = 1;
public final static int NORM_PRIORITY = 5;
public final static int MAX_PPRIORITY = 10;
```

启动方面优先级主要是对线程类setPriority:

```java
Thread high = new HightPriority();
Thread low = new LowPriority();
high.setPriority(Thread.MAX_PRIORITY);
low.setPriority(Thread.MIN_PRIORITY);
low.start();
high.start();
```

### 2.8 线程安全synchronized

程序并行运行如果两个线程同时修改某一个数据会产生冲突。

关键字synchronized的作用是实现线程间同步，对同步的代码加锁，每次只能有一个线程进入同步块。

指定加锁对象：`synchronized(instance)`

### 2.8.1. 加锁

使用Runnable接口加锁方法：

```java
class MyRunable implements Runnable {
    
    @Override
    public void run() {
        synchronized(this) {
            try {  
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100); // 休眠100ms
                    System.out.println(Thread.currentThread().getName() + " loop " + i);  
                }
            } catch (InterruptedException ie) {  
            }
        }  
    }
}

public class Demo1_1 {

    public static void main(String[] args) {  
        Runnable demo = new MyRunable();     // 新建“Runnable对象”

        Thread t1 = new Thread(demo, "t1");  // 新建“线程t1”, t1是基于demo这个Runnable对象
        Thread t2 = new Thread(demo, "t2");  // 新建“线程t2”, t2是基于demo这个Runnable对象
        t1.start();                          // 启动“线程t1”
        t2.start();                          // 启动“线程t2” 
    } 
}

---结果---
t1 loop 0
t1 loop 1
t1 loop 2
t1 loop 3
t1 loop 4
t2 loop 0
t2 loop 1
t2 loop 2
t2 loop 3
t2 loop 4
```

使用Thread类加锁方法：

```java
class MyThread extends Thread {
    
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized(this) {
            try {  
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100); // 休眠100ms
                    System.out.println(Thread.currentThread().getName() + " loop " + i);  
                }
            } catch (InterruptedException ie) {  
            }
        }  
    }
}

public class Demo1_2 {

    public static void main(String[] args) {  
        Thread t1 = new MyThread("t1");  // 新建“线程t1”
        Thread t2 = new MyThread("t2");  // 新建“线程t2”
        t1.start();                          // 启动“线程t1”
        t2.start();                          // 启动“线程t2” 
    } 
}

---结果---
t1 loop 0
t2 loop 0
t1 loop 1
t2 loop 1
t1 loop 2
t2 loop 2
t1 loop 3
t2 loop 3
t1 loop 4
t2 loop 4
```

* synchronized(this)中的this是指“当前的类对象”，即synchronized(this)所在的类对应的当前对象。它的作用是获取“当前对象的同步锁”。
* Demo1_2中，synchronized(this)中的this代表的是MyThread对象，而t1和t2是两个不同的MyThread对象，因此t1和t2在执行synchronized(this)时，获取的是不同对象的同步锁。
* Demo1_1中，synchronized(this)中的this代表的是MyRunable对象；t1和t2共同一个MyRunable对象，因此，一个线程获取了对象的同步锁，会造成另外一个线程等待。


### 2.8.2. 同步与非同步块

同步代码块中包含非同步代码块对比：

```java
class Count {

    // 含有synchronized同步块的方法
    public void synMethod() {
        synchronized(this) {
            try {  
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100); // 休眠100ms
                    System.out.println(Thread.currentThread().getName() + " synMethod loop " + i);  
                }
            } catch (InterruptedException ie) {  
            }
        }  
    }

    // 非同步的方法
    public void nonSynMethod() {
        try {  
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " nonSynMethod loop " + i);  
            }
        } catch (InterruptedException ie) {  
        }
    }
}

public class Demo2 {

    public static void main(String[] args) {  
        final Count count = new Count();
        // 新建t1, t1会调用“count对象”的synMethod()方法
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        count.synMethod();
                    }
                }, "t1");

        // 新建t2, t2会调用“count对象”的nonSynMethod()方法
        Thread t2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        count.nonSynMethod();
                    }
                }, "t2");  


        t1.start();  // 启动t1
        t2.start();  // 启动t2
    } 
}

--------结果--------
t1 synMethod loop 0
t2 nonSynMethod loop 0
t1 synMethod loop 1
t2 nonSynMethod loop 1
t1 synMethod loop 2
t2 nonSynMethod loop 2
t1 synMethod loop 3
t2 nonSynMethod loop 3
t1 synMethod loop 4
t2 nonSynMethod loop 4
```

主线程新建了两个子线程t1和t2。t1会调用count对象的synMethod()方法，该方法内含有同步块；而t2则会调用count对象的nonSynMethod()方法，该方法不是同步方法。t1运行时，虽然调用synchronized(this)获取“count的同步锁”；但是并没有造成t2的阻塞，因为t2没有用到“count”同步锁。 

```java
class Count {

    // 含有synchronized同步块的方法
    public void synMethod() {
        synchronized(this) {
            try {  
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100); // 休眠100ms
                    System.out.println(Thread.currentThread().getName() + " synMethod loop " + i);  
                }
            } catch (InterruptedException ie) {  
            }
        }  
    }

    // 也包含synchronized同步块的方法
    public void nonSynMethod() {
        synchronized(this) {
            try {  
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " nonSynMethod loop " + i);  
                }
            } catch (InterruptedException ie) {  
            }
        }
    }
}

public class Demo3 {

    public static void main(String[] args) {  
        final Count count = new Count();
        // 新建t1, t1会调用“count对象”的synMethod()方法
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        count.synMethod();
                    }
                }, "t1");

        // 新建t2, t2会调用“count对象”的nonSynMethod()方法
        Thread t2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        count.nonSynMethod();
                    }
                }, "t2");  


        t1.start();  // 启动t1
        t2.start();  // 启动t2
    } 
}

--------结果--------
t1 synMethod loop 0
t1 synMethod loop 1
t1 synMethod loop 2
t1 synMethod loop 3
t1 synMethod loop 4
t2 nonSynMethod loop 0
t2 nonSynMethod loop 1
t2 nonSynMethod loop 2
t2 nonSynMethod loop 3
t2 nonSynMethod loop 4
```

主线程中新建了两个子线程t1和t2。t1和t2运行时都调用synchronized(this)，这个this是Count对象(count)，而t1和t2共用count。因此，在t1运行时，t2会被阻塞，等待t1运行释放“count对象的同步锁”，t2才能运行。

### 2.8.3. 实例锁与全局锁

1. 实例锁：锁在某个实例上，如果该类是单例该锁也具有全局锁概念，对应synchronized关键字
2. 全局锁：锁在类上，无论多少个对象，线程都是共享锁，对应static synchronized

例子：

```java
pulbic class Something {
    public synchronized void isSyncA(){}
    public synchronized void isSyncB(){}
    public static synchronized void cSyncA(){}
    public static synchronized void cSyncB(){}
}
```

假设，Something有两个实例x和y。分析下面4组表达式获取的锁的情况。
1. x.isSyncA()与x.isSyncB() 
2. x.isSyncA()与y.isSyncA()
3. x.cSyncA()与y.cSyncB()
4. x.isSyncA()与Something.cSyncA()
   
不能同时被访问：1中isSyncA()和isSyncB()都是访问同一个对象(对象x)的同步锁！
```java
// LockTest1.java的源码
class Something {
    public synchronized void isSyncA(){
        try {  
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName()+" : isSyncA");
            }
        }catch (InterruptedException ie) {  
        }  
    }
    public synchronized void isSyncB(){
        try {  
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName()+" : isSyncB");
            }
        }catch (InterruptedException ie) {  
        }  
    }
}

public class LockTest1 {

    Something x = new Something();
    //Something y = new Something();

    // 比较(01) x.isSyncA()与x.isSyncB() 
    private void test1() {
        // 新建t11, t11会调用 x.isSyncA()
        Thread t11 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        x.isSyncA();
                    }
                }, "t11");

        // 新建t12, t12会调用 x.isSyncB()
        Thread t12 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        x.isSyncB();
                    }
                }, "t12");  


        t11.start();  // 启动t11
        t12.start();  // 启动t12
    }

    public static void main(String[] args) {
        LockTest1 demo = new LockTest1();
        demo.test1();
    }
}

-----结果-----
t11 : isSyncA
t11 : isSyncA
t11 : isSyncA
t11 : isSyncA
t11 : isSyncA
t12 : isSyncB
t12 : isSyncB
t12 : isSyncB
t12 : isSyncB
t12 : isSyncB
```

可以同时被访问：2中访问的不是同一个对象的同步锁，x.isSyncA()访问的是x的同步锁，而y.isSyncA()访问的是y的同步锁
```java
// LockTest2.java的源码
class Something {
    public synchronized void isSyncA(){
        try {  
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName()+" : isSyncA");
            }
        }catch (InterruptedException ie) {  
        }  
    }
    public synchronized void isSyncB(){
        try {  
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName()+" : isSyncB");
            }
        }catch (InterruptedException ie) {  
        }  
    }
    public static synchronized void cSyncA(){
        try {  
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName()+" : cSyncA");
            } 
        }catch (InterruptedException ie) {  
        }  
    }
    public static synchronized void cSyncB(){
        try {  
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName()+" : cSyncB");
            } 
        }catch (InterruptedException ie) {  
        }  
    }
}

public class LockTest2 {

    Something x = new Something();
    Something y = new Something();

    // 比较(02) x.isSyncA()与y.isSyncA()
    private void test2() {
        // 新建t21, t21会调用 x.isSyncA()
        Thread t21 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        x.isSyncA();
                    }
                }, "t21");

        // 新建t22, t22会调用 x.isSyncB()
        Thread t22 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        y.isSyncA();
                    }
                }, "t22");  


        t21.start();  // 启动t21
        t22.start();  // 启动t22
    }

    public static void main(String[] args) {
        LockTest2 demo = new LockTest2();

        demo.test2();
    }
}

-----结果-----
t21 : isSyncA
t22 : isSyncA
t21 : isSyncA
t22 : isSyncA
t21 : isSyncA
t22 : isSyncA
t21 : isSyncA
t22 : isSyncA
t21 : isSyncA
t22 : isSyncA
```

不能被同时访问：3中cSyncA()和cSyncB()都是static类型，x.cSyncA()相当于Something.isSyncA()，y.cSyncB()相当于Something.isSyncB()，因此它们共用一个同步锁，不能被同时反问。
```java
// LockTest3.java的源码
class Something {
    public synchronized void isSyncA(){
        try {  
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName()+" : isSyncA");
            }
        }catch (InterruptedException ie) {  
        }  
    }
    public synchronized void isSyncB(){
        try {  
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName()+" : isSyncB");
            }
        }catch (InterruptedException ie) {  
        }  
    }
    public static synchronized void cSyncA(){
        try {  
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName()+" : cSyncA");
            } 
        }catch (InterruptedException ie) {  
        }  
    }
    public static synchronized void cSyncB(){
        try {  
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName()+" : cSyncB");
            } 
        }catch (InterruptedException ie) {  
        }  
    }
}

public class LockTest3 {

    Something x = new Something();
    Something y = new Something();

    // 比较(03) x.cSyncA()与y.cSyncB()
    private void test3() {
        // 新建t31, t31会调用 x.isSyncA()
        Thread t31 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        x.cSyncA();
                    }
                }, "t31");

        // 新建t32, t32会调用 x.isSyncB()
        Thread t32 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        y.cSyncB();
                    }
                }, "t32");  


        t31.start();  // 启动t31
        t32.start();  // 启动t32
    }

    public static void main(String[] args) {
        LockTest3 demo = new LockTest3();

        demo.test3();
    }
}

-----结果-----
t31 : cSyncA
t31 : cSyncA
t31 : cSyncA
t31 : cSyncA
t31 : cSyncA
t32 : cSyncB
t32 : cSyncB
t32 : cSyncB
t32 : cSyncB
t32 : cSyncB
```

可以被同时访问:4中isSyncA()是实例方法，x.isSyncA()使用的是对象x的锁；而cSyncA()是静态方法，Something.cSyncA()可以理解对使用的是“类的锁”。因此，它们是可以被同时访问的。
```java
// LockTest4.java的源码
class Something {
    public synchronized void isSyncA(){
        try {  
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName()+" : isSyncA");
            }
        }catch (InterruptedException ie) {  
        }  
    }
    public synchronized void isSyncB(){
        try {  
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName()+" : isSyncB");
            }
        }catch (InterruptedException ie) {  
        }  
    }
    public static synchronized void cSyncA(){
        try {  
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName()+" : cSyncA");
            } 
        }catch (InterruptedException ie) {  
        }  
    }
    public static synchronized void cSyncB(){
        try {  
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName()+" : cSyncB");
            } 
        }catch (InterruptedException ie) {  
        }  
    }
}

public class LockTest4 {

    Something x = new Something();
    Something y = new Something();

    // 比较(04) x.isSyncA()与Something.cSyncA()
    private void test4() {
        // 新建t41, t41会调用 x.isSyncA()
        Thread t41 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        x.isSyncA();
                    }
                }, "t41");

        // 新建t42, t42会调用 x.isSyncB()
        Thread t42 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        Something.cSyncA();
                    }
                }, "t42");  


        t41.start();  // 启动t41
        t42.start();  // 启动t42
    }

    public static void main(String[] args) {
        LockTest4 demo = new LockTest4();

        demo.test4();
    }
}

-----结果-----
t41 : isSyncA
t42 : cSyncA
t41 : isSyncA
t42 : cSyncA
t41 : isSyncA
t42 : cSyncA
t41 : isSyncA
t42 : cSyncA
t41 : isSyncA
t42 : cSyncA
```


## 2.9. 同步控制

重入锁可以完全替代synchronized，重入锁使用`java.util.concurrent.locks.ReentrantLock`类来实现。

```java
public static ReentrantLock lock = new ReentrantLock();
public void run(){
    lock.lock();
    action
    lock.unlock();
}
```

锁申请等待时间使用：tryLock(时长，单位(大写))

重入锁可以实现公平调用锁的申请而不是随机，对公平设置使用如下函数：

```java
public staic ReentrantLock fairLock = new ReentrantLock(true);
```

### 2.9.1. Condition条件

与wait()和notify()类似，只是这两个是配合synchronized使用，Condition是与重入锁相关联。

Condition接口基本方法：

* void await() throws InteruptedException：会使当前线程等待，同时释放当前锁，当其他线程中使用signal()方法时，线程重新获得锁继续执行。与wait()方法类似。
* void signal()：用于唤醒一个等待的线程。

### 2.9.2. 信号量

无论是内部锁还是重入锁，一次只能允许一个线程访问一个资源，而信号量可以指定多个线程访问某一个资源。

信号量提供以下构造函数:

```java
public Semaphore(int permits)
public Semaphore(int permits, boolean fair) //指定是否公平
```

构造函数确定了信号量的准入数，信号量的主要逻辑方法有：

```java
public void acquire()
public void acquireUninterruptibly()
public boolean tryAcquire()
public boolean tryAcquire(long timeout, TimeUnit unit)
public void release()
```

acquire()方法尝试获得准入许可，无法获得会等待直到有线程释放一个许可或者当前线程中断。

acquireUninterruptibly()方法与acquire()方法但不响应中断。

tryAcquire()尝试获得许可，成功返回true，失败返回false。

release()用于线程访问资源结束后释放一个许可，以使其他等待线程可以进行资源访问。

### 2.9.3. 读写锁ReadWriteLock

使用重入锁或者内部锁时，读与读之间，读与写，写与写直接都是串行操作的，由于读操作不会对数据破坏，所以串行读是不合理的。

读写锁可以实现读与读之间的不阻塞。

### 2.9.4. 倒计时器CountDownLatch

可以实现某个线程等到到倒计时结束再开始执行。

构造函数为:

```java
public CountDownLatch(int count)
```

### 2.9.5. 循环栅栏CyclicBarrier

它也可以实现线程间的计数等待，但是比CountDownLatch更加复杂强大。

循环栅栏可以是将计算器计数归零，再进行下一次循环。

CyclicBarrier可以接收一个参数作为barrierAction，即当计数完成一次后系统会执行动作。

```java
public CyclicBarrier(int parties, Runnable barrierAction)
```

### 2.9.6. 线程阻塞工具LockSupport

可以实现线程任意位置内线程阻塞，其静态方法park()可以阻塞当前线程。

## 2.10. 线程复用：线程池

最简单的线程创建和回收如下：

```java
new Thread(new Runnable(){
    @Override
    public void run(){
        // do sth
    }
}).start();
```

在run()方法结束后，自动回收线程。

为了避免系统频发创建和销毁线程，可以让创建的线程进行复用。线程池即放入几个线程，当需要使用线程时可以从池中拿一个空闲线程，完成工作时，把该线程退回到池中。

### 2.10.1. Executor框架

Executor框架提供各种类型的线程池，Executors类主要的工厂方法：

```java
public static ExecutorService newFixedThreadPool(int nThreads)
public static ExecutorService newSingleThreadExecutor()
public static ExecutorService newCachedThreadPool()
public static ScheduleExecutorService newSingleThreadScheduledExecutor()
public static ScheduleExecutorService newScheduledThreadPool(int corePoolSize)
```

* newFixedThreadPool()：返回固定数量的线程池，当有新任务时，线程池中有空闲线程则立即执行，若没有，会暂存任务队列，待有空闲时。
* newSingleThreadExecutor()：返回只有一个线程的线程池。
* newCachedThreadPool()：返回可根据实际情况调整线程数量的线程池，线程池数量不固定，有空闲线程优先使用，若都在工作会创建新的线程。
* newSingleThreadScheduledExecutor()：返回一个ScheduledExecutorService对象，线程池为1,。可以在给定时间或周期执行任务。
* newScheduledThreadPool()：与上面功能相似，不同在于线程池数量可以设定。

### 2.10.2. Fork/Join框架

处理大数据时需要分而治之，ForkJoinPool线程池可以提交一个ForkJoinTask任务，进行fork()分解以及join()等待。ForkJoinTask有两个重要的子类，RecursiveAction和RecursiveTask。分别表示没有返回值的任务和可以携带返回值的任务。

# 3. 锁

## 3.1. ThreadLocal

该方法可以通过增加资源来保证线程安全。

```java
static ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<SimpleDateFormat> 
public static class ParseDate implements Runable{
    int i = 0;
    public ParseDate(int i){
        this.i = i;
    }
    public void run(){
        try{
            if(t1.get() == null){
                t1.set(new SimpleDateFormat("yyyy-MM-dd:mm:ss"));
            }
            Date t = t1.get().parse("2015-03-29 19:29:" +i%60);
            System.out.println(i+":"+t);
        } catch (ParseException e){
            e.printStackTrace();
        }
    }
}
```

get与set的使用保证如果当前线程不持有SimpleDateforamt对象就新建一个设置到线程中，如果已经持有，则直接使用。

## 3.2. 无锁

锁是假设每次临界区操作都会产生冲突，宁可牺牲线程进行等待。无锁是假设对资源访问没有冲突，所有线程都可以不停顿的状态继续执行。

### 3.2.1. 比较交换(CAS)

如果无锁遇到冲突会使用CAS策略，它包含三个参数CAS(V,E,N)。V表示更新的变量，E表示预期值，N表示新值。仅当V值等于E是，才会让V=N，如果V和E值不同则表示其他线程已经更新，当前线程不用做什么。

### 3.2.2. 无锁线程安全整数Atomiclnteger

JDK并发包中的atomic包实现了一些CAS操作。最常用的是AtomicInteger，可以看做一个整数，但是与Integer不同，它是可变且线程安全。

# 4. 并行模式与算法

## 4.1. 单例模式

详见设计模式

## 4.2. 不变模式

不变模式使用于当对象创建后，内部状态和数据不再变化。对象需要被共享，被多线程频繁访问。

设计基于：

1. 去除setter方法以及所有修改自身属性的方法。
2. 所有属性设置为私有，并用final标记。
3. 确保没有子类可以重载修改。
4. 有一个可以创建完整对象的构造函数。

```java
public final class Product{ //确保无子类
    private final String no; //私有属性不被修改
    private final String name; //final保证属性不会给赋值两次
    private final double price;

    public Product(String no, String name, double price){ //创建时必须指定数据
        super(); //创建之后无法修改
        this.no = no;
        this.name = name;
        this.price = price;
    }

    public String getNo(){
        return no;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }
}
```

## 4.3. 生产者-消费者模式

生产者-消费者模式核心是共享内存缓存区（数据在多线程间共享）。

其中BlocKigQueue充当共享内存缓冲区，PCData对象表示一个生产任务，或相关数据。

生产者首先构建PCDate对象，并放入BlockingQueue队列中。

```java
public class Producer implements Runnable{
    private volatile boolean isRunning = true;
    private BlockingQueue<PCDate> queue; //内存缓冲区
    private static AtomicInteger count = new AtomicInteger();//总数，原子性的操作
    private static final int SLEEPTIME = 1000;

    public Producer(BlockingQueue<PCData> queue){
        this.queue = queue;
    }

    public void run(){
        PCDate data = null;
        Random r = new Random();

        System.out.println("Start producer id="+Thread.currentThread().getId());
        try{
            whilie(isRunning){
                Thread.sleep(r.nextInt(SLEEPTIME));
                data = new.PCData(count.incrementAndGet()); //构造任务数据
                System.out.println(data +" is put into queue");
                if (!queue.offer(data, 2, TimeUnit.SECONDS)){//提交数据到缓冲区
                    System.err.println("failed to put data:" + data);
                }
            }
        } catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
    public void stop(){
        isRunning = false;
    }
}
```

消费者从BlockingQueue队列中取出PCData对象，并计算。

```java
public class Consumer implements Runnable{
    private BlockingQueue<PCData> queue;
    private static final int SLEEPTIME = 1000;

    public Consumer(BlockingQueue<PCData> queue){
        this.queue = queue;
    }

    public void run(){
        System.out.println("start Consumer id=" + Thread.currentThread().getId());
        Random r = new Random();

        try{
            while(true){
                PCData data = queue.take(); //提取任务
                if (null != data){
                    int re = data.getData() * data.getData();
                    System.out.println(MessageFormat.format("{0}*{1}={2}", data.getData(), data.getData(), re));
                    Thread.sleep(r.nextInt(SLEEPTIME));
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interupt();
        }
    }
}
```

PCData设置为共享数据模型：

```java
public final class PCData{
    private final int intData;
    public PCData(int d){
        inData = d;
    }
    public PCData(String d){
        intData = Integer.valueOf(d);
    }
    public int getData(){
        return intData;
    }
    @override
    public String toString(){
        return "data:"+intData;
    }
}
```

可以创建三个生产者三个消费者协作运行进行测试

```java
public class Main{
    public static void main(String args[]) throws InterruptedException{
        BlockingQueue<PCData> queue = new LinkedBlockQueue<PCData>(10);
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        Consumer consumer3 = new Consumer(queue);
        ExecutorSevice service = Executors.newCachedThreadPool(); //建立线程池
        service.excute(producer1);
        service.excute(producer2);
        service.excute(producer3);
        service.excute(consumer1);
        service.excute(consumer2);
        service.excute(consumer3);
        Thread.sleep(10 *1000);
        producer1.stop();
        producer2.stop();
        producer3.stop();
        Thread.sleep(3000);
        service.shutdown();
    }
}
```

## 4.4. 网络NIO

Java NIO 是一种代替Java IO的机制。

标准的网络IO会使用Socket进行网络读写，每一个客户端连接开启一个线程。

```java
public class MultiThreadEchoServer{//基于Socket的服务端
    private static ExecutorService tp = Executors.newCachedThreadPool();
    //定义HandleMsg线程，由一个客户端Socket构成，读取Socket内容并返回，返回后关闭Socket
    static class HandleMsg implements = Runnable{
        Socket clientSocket;
        public HandleMsg(Socket clientSocket){
            this.clientSocket = clientSocket;
        }

        public void run(){
            BufferedReader is = null; //缓冲字符输入流,为其他字符输入流添加一些缓冲功能
            PrintWriter os = null;
            try{
                is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                os = new PrintWriter(clientSocket.getOutputStream(), true);
                String inputLine = null;
                long b = System.currentTimeMillis();
                while ((inputLine = is.readLine()) != null){
                    os.println(inputLine);
                }
                long e = System.currentTimeMills();
                System.out.println("spend:"+ (e-b) + "ms");//线程处理一次客户端请求所花时间
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                try{
                    if(is!=null)is.close();
                    if(os!=null)os.close();
                    clientSocket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String args[]){//8000端口等待，有新客户端连接，创建HandleMsg线程
        ServerSocket echoServer = null;
        Socket clientSocker = null;
        try{
            echoServer = new ServerSocket(8000);
        }catch (IOException e){
            System.out.println(e);
        }
        while(true){
            try{//连接HandleMsg
                clinetSocket = echoServer.accept();
                System.out.println(clentSocket.getRemoteSocketAddress() + " connect!");
                tp.execute(new HandleMsg(clientSocket));
            } catch(IOException e){
                System.out.println(e);
            }
        }
    }
}
```

### 4.4.1. NIO--channel

使用NIO可以将上面的网络IO等待时间从业务处理线程中抽取出来

NIO中关键组件：Channel(管道)，Selector(选择器),SelectableChannel(通道选择)

线程管理Selector，Selector来选择SocketChannel(表示一个客户端连接),当SocketChannel准备好了数据，Seletor能立即得到通知。


## 4.5. 异步IO

对于NIO来说，是在IO操作准备好时，得到通知，再由这个线程自行对IO进行操作，IO操作本身还是同步的。

对于AIO不是在IO准备好再通知线程，而是在IO操作完成后再发出通知。

P259

# 5. Java8并发