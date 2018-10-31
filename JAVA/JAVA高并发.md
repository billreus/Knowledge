<!-- TOC -->

- [高并发设计](#高并发设计)
    - [1 概念](#1-概念)
        - [1.1 同步异步](#11-同步异步)
        - [1.2 并发和并行](#12-并发和并行)
        - [1.3 临界区](#13-临界区)
        - [1.4 阻塞和非阻塞](#14-阻塞和非阻塞)
        - [1.5 死锁、饥饿、活锁](#15-死锁饥饿活锁)
        - [1.6 并发级别](#16-并发级别)
    - [2 并发操作](#2-并发操作)
        - [2.1 线程基本操作](#21-线程基本操作)
            - [2.1.1 Runnable接口](#211-runnable接口)
            - [2.1.2 Callable接口](#212-callable接口)
            - [2.1.3 继承Thread类](#213-继承thread类)
        - [2.2 线程中断](#22-线程中断)
            - [2.2.1 InterruptedException](#221-interruptedexception)
            - [2.2.2 interrupted()](#222-interrupted)
            - [2.2.3 sleep()](#223-sleep)
        - [2.3 等待(wait)和通知(notify)](#23-等待wait和通知notify)
        - [2.4 等待线程结束(join)和谦让(yield)](#24-等待线程结束join和谦让yield)
        - [2.5 线程组](#25-线程组)
        - [2.6 守护线程](#26-守护线程)
        - [2.7 线程优先级](#27-线程优先级)
        - [2.8 线程安全synchronized](#28-线程安全synchronized)
        - [2.9 同步控制](#29-同步控制)
            - [2.9.1 Condition条件](#291-condition条件)
            - [2.9.2 信号量](#292-信号量)
            - [2.9.3 读写锁ReadWriteLock](#293-读写锁readwritelock)
            - [2.9.4 倒计时器CountDownLatch](#294-倒计时器countdownlatch)
            - [2.9.5 循环栅栏CyclicBarrier](#295-循环栅栏cyclicbarrier)
            - [2.9.5 线程阻塞工具LockSupport](#295-线程阻塞工具locksupport)
        - [2.10 线程复用：线程池](#210-线程复用线程池)
            - [2.10.1 Executor框架](#2101-executor框架)
            - [2.10.2 Fork/Join框架](#2102-forkjoin框架)
    - [3 锁](#3-锁)
        - [3.1 ThreadLocal](#31-threadlocal)
        - [3.2 无锁](#32-无锁)
            - [3.2.1 比较交换(CAS)](#321-比较交换cas)
            - [3.2.2 无锁线程安全整数Atomiclnteger](#322-无锁线程安全整数atomiclnteger)
    - [4 并行模式与算法](#4-并行模式与算法)

<!-- /TOC -->

# 高并发设计

## 1 概念

### 1.1 同步异步

同步和异步用来形容一次方法调用，同步方法调用必须等到调用返回后才能继续后继行为，异步方法调用就会立即返回，调用者可以继续后续工作。

### 1.2 并发和并行

并发和并行都可以表示两个或者多个任务一起执行，并发侧重于多个任务交替进行，且多个任务之间可能还是串行的，而并行是真正意义上的同时执行。

### 1.3 临界区

临界区表示一种公共资源可以被多个线程使用，但是每次只能有一个线程使用它，一旦临界区资源被占用，其他线程只能等待。

### 1.4 阻塞和非阻塞

阻塞非阻塞用来形容多线程间的互相影响。比如一个线程占用了临界区资源，那么其他需要资源的线程在临界区等待，等待会导致线程挂起即阻塞。非阻塞即没有线程阻碍其他线程执行。

### 1.5 死锁、饥饿、活锁

都属于多线程活跃性问题，死锁是互相占用资源导致这种状态永远维持；饥饿指一个或者多个线程因为种种原因无法获得所需资源导致无法执行；活锁即不断让出资源，而没有一个线程可以拿到需要的资源而正常执行。

### 1.6 并发级别

并发级别可以分成：阻塞，无饥饿，无阻碍，无锁，无等待。

1. 阻塞：一个线程是阻塞的，其他线程会等待。使用synchronized关键字或者重入锁时就是阻塞线程。
2. 无饥饿：所有线程排队，不允许优先级高的插队。
3. 无障碍：允许所有线程进入临界区，一起共享数据，如果出错，进行回滚。
4. 无锁：并行是无障碍的，并行时保证必然有一个线程在有限步内完成操作离开临界区。
5. 无等待：所有线程在有限步完成操作。

## 2 并发操作

所有线程的状态都在Thread中的State枚举中定义

```java
public enum State{NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED;}
```

NEW状态表示刚刚创建的线程，等待start()方法调用，当线程执行时，处于RUNNABLE状态，如果线程执行中遇到synchronized同步块就会进入BLOCKED阻塞状态，会暂停执行，知道获得请求锁。WATTING和TIMED_WAITING都表示等待状态，区别是WAITING会进入无时间限制的等待，TIMED_WAITING会进行有时限的等待。线程执行完毕会进入TERMINATED状态表示结束。

### 2.1 线程基本操作

使用线程一共有三种方法：

* 实现Runnable接口;
* 实现Callable接口;
* 继承Tread类;

实现 Runnable 和 Callable 接口的类只能当做一个可以在线程中运行的任务，不是真正意义上的线程，因此最后还需要通过 Thread 来调用

#### 2.1.1 Runnable接口

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

#### 2.1.2 Callable接口

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

#### 2.1.3 继承Thread类

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

### 2.2 线程中断

线程中断不会让线程立即退出，而是发给线程一个通知，至于线程接到通知后如何处理完全由目标线程自行决定。

线程中断有关的有三个方法：

```java
public void Thread.interrupt() //中断线程
public boolean Thread.isInterrupted() //判断是否被中断
public static boolean Thread.interrupted() //判断是否被中断，并清除当前中断状态
```

#### 2.2.1 InterruptedException

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

#### 2.2.2 interrupted()

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

#### 2.2.3 sleep()

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

### 2.3 等待(wait)和通知(notify)

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

### 2.4 等待线程结束(join)和谦让(yield)

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

### 2.5 线程组

当线程数量很多时，可以把相同功能的线程放在一个线程组里。

```java
ThreadGroup tq = new ThreadGroup("groupname");
System.out.println(tg.activeCount()); //线程数
tg.list(); //打印线程组中所有线程信息
```

### 2.6 守护线程

```java
Thread t = new DaemonT(); //Daemont为线程功能设置的自己写的类
t.setDamon(true); //线程守护，必须在start之前
t.start();
```

可以使main中主线程结束后，整个线程结束，用户线程不会继续执行。

### 2.7 线程优先级

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

指定加锁方法：

```java
public synchronized void increase(){
    i++;
}
```

### 2.9 同步控制

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

#### 2.9.1 Condition条件

与wait()和notify()类似，只是这两个是配合synchronized使用，Condition是与重入锁相关联。

Condition接口基本方法：

* void await() throws InteruptedException：会使当前线程等待，同时释放当前锁，当其他线程中使用signal()方法时，线程重新获得锁继续执行。与wait()方法类似。
* void signal()：用于唤醒一个等待的线程。

#### 2.9.2 信号量

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

#### 2.9.3 读写锁ReadWriteLock

使用重入锁或者内部锁时，读与读之间，读与写，写与写直接都是串行操作的，由于读操作不会对数据破坏，所以串行读是不合理的。

读写锁可以实现读与读之间的不阻塞。

#### 2.9.4 倒计时器CountDownLatch

可以实现某个线程等到到倒计时结束再开始执行。

构造函数为:

```java
public CountDownLatch(int count)
```

#### 2.9.5 循环栅栏CyclicBarrier

它也可以实现线程间的计数等待，但是比CountDownLatch更加复杂强大。

循环栅栏可以是将计算器计数归零，再进行下一次循环。

CyclicBarrier可以接收一个参数作为barrierAction，即当计数完成一次后系统会执行动作。

```java
public CyclicBarrier(int parties, Runnable barrierAction)
```

#### 2.9.5 线程阻塞工具LockSupport

可以实现线程任意位置内线程阻塞，其静态方法park()可以阻塞当前线程。

### 2.10 线程复用：线程池

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

#### 2.10.1 Executor框架

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

#### 2.10.2 Fork/Join框架

处理大数据时需要分而治之，ForkJoinPool线程池可以提交一个ForkJoinTask任务，进行fork()分解以及join()等待。ForkJoinTask有两个重要的子类，RecursiveAction和RecursiveTask。分别表示没有返回值的任务和可以携带返回值的任务。

## 3 锁

### 3.1 ThreadLocal

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

### 3.2 无锁

锁是假设每次临界区操作都会产生冲突，宁可牺牲线程进行等待。无锁是假设对资源访问没有冲突，所有线程都可以不停顿的状态继续执行。

#### 3.2.1 比较交换(CAS)

如果无锁遇到冲突会使用CAS策略，它包含三个参数CAS(V,E,N)。V表示更新的变量，E表示预期值，N表示新值。仅当V值等于E是，才会让V=N，如果V和E值不同则表示其他线程已经更新，当前线程不用做什么。

#### 3.2.2 无锁线程安全整数Atomiclnteger

JDK并发包中的atomic包实现了一些CAS操作。最常用的是AtomicInteger，可以看做一个整数，但是与Integer不同，它是可变且线程安全。

## 4 并行模式与算法
