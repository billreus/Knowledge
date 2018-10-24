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

新建线程：

```java
Thread t1 = new Thread();
t1.start();
```

线程运行可以使用Runnable接口，该接口只有一个run()方法：

```java
public class CreateThread3 implements Runnable {
    public static void main(String[] args){
        Thread t1 = new Thread(new CreateThread3());
        t1.start();
    }

    @Override
    public void run(){
        //动作
    }
}
```

### 2.2 线程中断

线程中断不会让线程立即退出，而是发给线程一个通知，至于线程接到通知后如何处理完全由目标线程自行决定。

线程中断有关的有三个方法：

```java
public void Thread.interrupt() //中断线程
public boolean Thread.isInterrupted() //判断是否被中断
public static boolean Thread.interrupted() //判断是否被中断，并清除当前中断状态
```

`Thread.sleep()`方法会让当前线程休眠若干时间，并会抛出一个InterruptedException中断异常。

### 2.3 等待(wait)和通知(notify)

属于输出Object类的方法

```java
public final void wait() throws InterruptedException
public final native void notify()
```

当一个对象使用了wait()方法以后，该线程就好停止继续执行变成等待状态，等到其他线程调用obj.notify()方法为止。

* 在等待中的线程会在等待队列中，当notify()被调用时会随机选择一个线程唤醒。

该方法的调用都需要首先获得目标对象的一个监视器，在wait()方法执行后会释放这个监视器。

### 2.4 等待线程结束(join)和谦让(yield)

join有两个方法：

```java
public final void join() throws InterruptedException
public final synchronized void join(long mills) throws InterruptedException
```

第一个方法表示无限等待，会一直阻塞当前线程，直到目标线程执行完毕。第二个方法会给出一个最大等待时间，超过时间线程会继续执行下去。

`public static native void yield();`是一个静态方法，会让当前线程让出CPU。一般用于优先级非常低的功能上。

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

P69