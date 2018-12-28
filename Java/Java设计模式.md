# 设计模式

## 1 概念

设计模式是对软件设计中普遍存在的各种问题，所提出的 解决方案。

### 1.1 原则

#### 1.1.1 开闭原则

对扩展开放，对修改封闭。

在程序需要扩展的时候，不去修改原有代码，实现热插拔效果。为此我们需要使用接口和抽象类。

#### 1.1.2 里氏代换原则

只有当子类可以替换基类时，基类才能真正被复用。

#### 1.1.3 依赖倒转原则

：针对接口编程，高层模块不应该依赖底层模块，二者都应该依赖抽象而不依赖于具体。

#### 1.1.4 接口隔离原则

使用多个隔离的接口，比使用单个庞大的接口要好。

#### 1.1.5 单一职责原则

类的职责单一，不能将太多职责放在一个类中。

#### 1.1.6 最少知道原则

一个实体应当尽量少的与其他实体之间发生相互作用，使得系统功能模块相对独立。

#### 1.1.7 合成复用原则

一个新的对象里通过关联关系（组合关系、聚合关系）来使用一些已有的对象，使之成为新对象的一部分；新对象通过委派调用已有对象的方法达到复用功能的目的。简而言之，尽量多使用 组合/聚合 的方式，尽量少使用甚至不使用继承关系。

### 1.2 设计模式

通常来说设计模式分为三大类：

* 创建型模式，共5种：工厂模式、抽象工厂模式、单例模式、建造者模式、原型模式。

* 结构型模式，共7种：适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式。

* 行为型模式，共11种：策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式。

## 2 工厂模式

### 2.1 含义

工厂通常是一个用来创建其他对象的对象。工厂模式根据不同的参数来实现不同的分配方案和创建对象。

在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象。

### 2.2 普通工厂模式

普通工厂模式来创建人，先创建一个男人，他每天吃饭睡觉打豆豆。再创建一个女人，她每天吃饭睡觉打豆豆。

定义了接口human代替class male和female在class HumanFactory中的重复引用。

```java
// 二者共同的接口
public interface Human{
    public void eat();
    public void sleep();
    public void beat();
}

// 创建实现类 Male
public class Male implements Human{
    public void eat(){
        System.out.println("Male can eat."); 
    }
    public void sleep(){
        System.out.println("Male can sleep.");
    }
    public void beat(){
        System.out.println("Male can beat.");
    }
} 
//创建实现类 Female
public class Female implements Human{
    public void eat(){
        System.out.println("Female can eat."); 
    }
    public void sleep(){
        System.out.println("Female can sleep.");
    }
    public void beat(){
        System.out.println("Female can beat.");
    }
} 

// 创建普通工厂类
public class HumanFactory{
    public Human createHuman(String gender){
        if( gender.equals("male") ){
           return new Male();
        }else if( gender.equals("female")){
           return new Female();
        }else {
            System.out.println("请输入正确的类型！");
            return null;
        }
    }
}

// 工厂测试类
public class FactoryTest {
    public static void main(String[] args){
        HumanFactory factory = new HumanFactory();
        Human male = factory.createHuman("male");
        male.eat();
        male.sleep();
        male.beat();
    }
}
```

### 2.3 多个工厂方法模式

普通工厂模式中，如果传递字符串则会出错，不能创建对象。多个工厂方法模式提供多个工厂方法，分别创建对象。

接口的使用和普通工厂一样，实现了类似的类声明只需要使用接口。

```java
// 多个工厂方法
public class HumanFactory{
    public Male createMale() {
        return new Male();
    }
    public Female createFemale() {
        return new Female();
    }
}

// 工厂测试类
public class FactoryTest {
    public static void main(String[] args){
        HumanFactory factory = new HumanFactory();
        Human male = factory.createMale();
        male.eat();
        male.sleep();
        male.beat();
    }
}
```

### 2.4 静态工厂方法模式

将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。

```java
// 多个工厂方法
public class HumanFactory{
    public static Male createMale() {
        return new Male();
    }
    public static Female createFemale() {
        return new Female();
    }
}

// 工厂测试类
public class FactoryTest {
    public static void main(String[] args){
        Human male = HumanFactory.createMale();
        male.eat();
        male.sleep();
        male.beat();
    }
}
```

### 2.5 抽象工厂模式

在普通工厂的基础上，对工厂的类也使用接口调用，实现了多个工厂公用一个接口调用

```java
// 抽象食物
interface Food {
    public String getFoodName();
}

// 抽象餐具
interface TableWare {
    public String getToolName();
}

// 抽象工厂
interface KitchenFactory {
    public Food getFood();
    public TableWare getTableWare();
}

//具体食物 Apple 的定义如下
class Apple implements Food{
    public String getFoodName() {
        return "apple";
    }
}

//具体餐具 Knife 的定义如下
class Knife implements TableWare {
    public String getToolName() {
        return "knife";
    }
}

// 具体工厂接口下的 AKitchen ，可以分生出B、C、D厨房等
class AKitchen implements KitchenFactory {

    public Food getFood() {
       return new Apple();
    }

    public TableWare getTableWare() {
       return new Knife();
    }
}

// 吃货要开吃了
public class Foodaholic {

    public void eat(KitchenFactory k) {
       System.out.println("A foodaholic is eating "+ k.getFood().getFoodName()
              + " with " + k.getTableWare().getToolName() );
    }

    public static void main(String[] args) {
       Foodaholic fh = new Foodaholic();
       KitchenFactory kf = new AKitchen();
       fh.eat(kf);
    }
}
```

抽象工厂模式特别适合于这样的一种产品结构：产品分为几个系列，在每个系列中，产品的布局都是类似的，在一个系列中某个位置的产品，在另一个系列中一定有一个对应的产品。这样的产品结构是存在的，这几个系列中同一位置的产品可能是互斥的，它们是针对不同客户的解决方案，每个客户都只选择其一。

工厂方法模式：针对的是 一个产品等级结构。

抽象工厂模式：针对 多个产品等级结构。

## 3 适配器模式

在国内的家中只能用国标接口进行充电

```java
// 国标插头
public interface CnPluginInterface {
    void chargeWith2Pins();
}

// 实现国标插座的充电方法
public class CnPlugin implements CnPluginInterface {
    public void chargeWith2Pins() {
        System.out.println("charge with CnPlugin");
    }
}

// 在国内家中充电
public class Home {
    private CnPluginInterface cnPlugin;

    public Home() { }

    public Home(CnPluginInterface cnPlugin) {
        this.cnPlugin = cnPlugin;
    }

    public void setPlugin(CnPluginInterface cnPlugin) {
        this.cnPlugin = cnPlugin;
    }

    // 充电
    public void charge() {
        // 国标充电
        cnPlugin.chargeWith2Pins();
    }
}

// 国标测试类
public class CnTest {
    public static void main(String[] args) {
        CnPluginInterface cnPlugin = new CnPlugin();
        Home home = new Home(cnPlugin);
        // 会输出 “charge with CnPlugin”
        home.charge();
    }
}
```

然而，当把 iPhone6 带回来时，因为与家里的插座不匹配，所以需要一个适配器。这个适配器必须满足以下条件：

必须符合国内标准的接口，否则的话还是没办法插到国内插座中；
在调用上面实现的国标接口进行充电时，提供一种机制，将这个调用转到对英标接口的调用 。
这就要求：

适配器必须实现原有的旧的接口
适配器对象中持有对新接口的引用，当调用旧接口时，将这个调用委托给实现新接口的对象来处理，也就是在适配器对象中组合一个新接口。

```java
// 英标插头
public interface EnPluginInterface {
    void chargeWith3Pins();
}

// 实现英标插座的充电方法
public class EnPlugin implements EnPluginInterface {
    public void chargeWith3Pins() {
        System.out.println("charge with EnPlugin");
    }
}

//适配器
public class PluginAdapter implements CnPluginInterface {
     private EnPluginInterface enPlugin;

     public PluginAdapter(EnPluginInterface enPlugin) {
         this.enPlugin = enPlugin;
 }

 // 这是重点，适配器实现了英标的插头，然后重载国标的充电方法为英标的方法

public void chargeWith2Pins() {
    enPlugin.chargeWith3Pins();
     }
}

// 适配器测试类
public class AdapterTest {
    public static void main(String[] args) {
        EnPluginInterface enPlugin = new EnPlugin();
        Home home = new Home();
        PluginAdapter pluginAdapter = new PluginAdapter(enPlugin);
        home.setPlugin(pluginAdapter);
        // 会输出 “charge with EnPlugin”
        home.charge();
    }
}
```

当你想使用一个已有的类，但是这个类的接口跟你的又不一样，不能拿来直接用，这个时候你就需要一个适配器来帮你了，其主要作用就是在旧的接口、新的接口之间完成适配。

## 4 修饰者模式

修饰着模式动态地把职责附加到已有对象上去，实现功能扩展。这种特性，使得装饰者模式提供了比继承更具有弹性的解决方案。

例如：当有一个女友类，你想她是哪个国家，爱好，习惯，每个这样的女孩都能看作一个Java类，没有扩展性。

```java
// 抽象类 Girl
public abstract class Girl {
    String description = "no particular";

    public String getDescription(){
        return description;
    }
}

// 美国女孩
public class AmericanGirl extends Girl {
    public AmericanGirl() {
        description = "+AmericanGirl";
    }
}

// 国产妹子
public class ChineseGirl extends Girl {
    public ChineseGirl() {
        description = "+ChineseGirl";
    }
}

// 装饰者
public abstract class GirlDecorator extends Girl {
    public abstract String getDescription();
}

// 下面以美国女孩示例
// 给美国女孩加上金发
public class GoldenHair extends GirlDecorator {

    private Girl girl;

    public GoldenHair(Girl g) {
        girl = g;
    }

    @Override
    public String getDescription() {
        return girl.getDescription() + "+with golden hair";
    }

}

// 加上身材高大的特性
public class Tall extends GirlDecorator {

    private Girl girl;

    public Tall(Girl g) {
        girl = g;
    }

    @Override
    public String getDescription() {
        return girl.getDescription() + "+is very tall";
    }

}


// 检验一下
public class Test {

    public static void main(String[] args) {
        Girl g1 = new AmericanGirl();
        System.out.println(g1.getDescription());

        GoldenHair g2 = new GoldenHair(g1);
        System.out.println(g2.getDescription());

        Tall g3 = new Tall(g2);
        System.out.println(g3.getDescription());

        // 你也可以一步到位
        // Girl g = new Tall(new GoldenHair(new AmericanGirl())); 
    }
}
```

当你需要动态地给一个对象添加功能，实现功能扩展的时候，就可以使用装饰者模式。

## 5 观察者模式

观察者模式（Observer Pattern）就是一种 “发布者-订阅者” 的模式。有时也被称为 “模型-视图”模式、“源-监听者”模式等。在这种模式中，由一个目标对象来管理所有依赖与它的观察者对象，并且当这个目标对象自身发生改变时，会主动向它的观察者们发出通知。

例如：你最近在追一个美剧《生活大爆炸》，假设著名在线视频网站某狐买下独家版权，在线更新与播放。于是你天天等啊等啊，等它的更新通知一来，你就去看那些最新的视频。

```java
// Subject 主题接口
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyAllObservers();
}

// 观察者接口
public interface Observer {
    public void update(Subject s);
}

// 视频网站某狐 实现 Subject 接口
public class VideoSite implements Subject{

    // 观察者列表 以及 更新了的视频列表
    private ArrayList<Observer> userList;
    private ArrayList<String> videos;

    public VideoSite(){
        userList = new ArrayList<Observer>();
        videos = new ArrayList<String>();
    }

    @Override
    public void registerObserver(Observer o) {
        userList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        userList.remove(o);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer o: userList) {
            o.update(this);
        }
    }

    public void addVideos(String video) {
        this.videos.add(video);
        notifyAllObservers();
    }

    public ArrayList<String> getVideos() {
        return videos;
    }

    public String toString(){
        return videos.toString();
    }
}

// 实现观察者，即看视频的美剧迷们
public class VideoFans implements Observer {

    private String name;

    public VideoFans(String name){
        this.name = name;
    }
    @Override
    public void update(Subject s) {
        System.out.println(this.name + ", new videos are available! ");
        // print video list
        System.out.println(s);
    }
}

//  测试一下
public class Main {

    public static void main(String[] args) {
        VideoSite vs = new VideoSite();
        vs.registerObserver(new VideoFans("LiLei"));
        vs.registerObserver(new VideoFans("HanMeimei"));
        vs.registerObserver(new VideoFans("XiaoMing"));

        // add videos
        vs.addVideos("Video 1");
        //vs.addVideos("Video 2");
    }
}
```

应用就太多了。举个简单的例子就是各种 listener，比如当你有一个按键，你肯定要给这个按键添加监听事件（listener）来完成指定动作吧，这就是一种应用。

## 6 单例模式

对象只能有一个实例存在。单例模式的实现方式是，一个类能返回对象的一个引用（永远是同一个）和一个获得该唯一实例的方法（必须是静态方法）。通过单例模式，我们可以保证系统中只有一个实例，从而在某些特定的场合下达到节约或者控制系统资源的目的。

最常见、最简单的单例模式写法之一“饿汉模式” 就是很 “饥渴”，所以一上来就需要给它新建一个实例。但这种方法有一个明显的缺点，那就是不管有没有调用过获得实例的方法（本例中为 getWife() ），每次都会新建一个实例。

```java
// 饿汉模式
public class Wife {

    // 一开始就新建一个实例
    private static final Wife wife = new Wife();

    // 默认构造方法
    private Wife() {}

    // 获得实例的方法
    public static Wife getWife() {
        return wife;
    }
}
```

最常见、最简单的单例模式之二，跟 “饿汉模式” 是 “好基友”。再次顾名思义，“懒汉模式” 就是它很懒，一开始不新建实例，只有当它需要使用的时候，会先判断实例是否为空，如果为空才会新建一个实例来使用。

```java
// 懒汉模式
public class Wife {

    //一开始没有新建实例
    private static Wife wife;

    private Wife() { }

    // 需要时再新建
    public static Wife getWife() {
        if (wife == null) {
            wife = new Wife();
        }
        return wife;
    }
}
```

但是上面的懒汉模式却存在一个严重的问题。那就是如果有多个线程并行调用 getWife() 方法的时候，还是会创建多个实例，单例模式就失效了。

我们在基本的懒汉模式上，把它设为线程同步（synchronized）就好了。synchronized 的作用就是保证在同一时刻最多只有一个线程运行，这样就避免了多线程带来的问题。

```java
// 懒汉模式（线程安全）
public class Wife {
    private static Wife wife;

    private Wife() { }

    // 添加了 synchronized 关键字
    public static synchronized Wife getWife() {
        if (wife == null) {
            wife = new Wife();
        }
        return wife;
    }
}
```

线程安全的懒汉模式解决了多线程的问题，看起来完美了。但是它的效率不高，每次调用获得实例的方法 getWife() 时都要进行同步，但是多数情况下并不需要同步操作（例如我的 wife 实例并不为空可以直接使用的时候，就不需要给 getWife() 加同步方法，直接返回 wife 实例就可以了）。所以只需要在第一次新建实例对象的时候，使用同步方法。

```java
// 双重锁的 getWife() 方法
public static Wife getWife() {

    // 第一个检验锁，如果不为空直接返回实例对象，为空才进入下一步
    if (wife == null) {
        synchronized (Wife.class) {

            //第二个检验锁，因为可能有多个线程进入到 if 语句内
            if (wife == null) {
                wife = new Wife();
            }
        }
    }
    return wife ;
}
```

主要问题在于 wife = new Wife() 这句代码，因为在 JVM（Java 虚拟机）执行这句代码的时候，要做好几件事情，而 JVM 为了优化代码，有可能造成做这几件事情的执行顺序是不固定的，从而造成错误。

这个时候，我们需要给实例加一个 volatile 关键字，它的作用就是防止编译器自行优化代码。最后，我们的 “双重检验锁” 版本

```java
// 双重检验锁
public class Wife {
    private volatile static Wife wife;

    private Wife() { }

    public static Wife getWife() {
        if (wife == null) {
            synchronized(Wife.class) {
                if (wife == null) {
                    wife = new Wife();
                }
            }
        }

        return wife;
    }
}
```

上面的方法，修修补补，实在是太复杂了... 而且 volatile 关键字在某些老版本的 JDK 中无法正常工作。咱们得换一种方法，即 “静态内部类”。这种方式，利用了 JVM 自身的机制来保证线程安全，因为 WifeHolder 类是私有的，除了 getWife() 之外没有其它方式可以访问实例对象，而且只有在调用 getWife() 时才会去真正创建实例对象。（这里类似于 “懒汉模式”）

```java
// 静态内部类
public class Wife {
    private static class WifeHolder {
        private static final Wife wife = new Wife();
    }

    private Wife() { }

    public static Wife getWife() {
        return WifeHolder.wife;
    }
}
```