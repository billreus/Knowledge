# JDBC

## 1 创建JDBC连接

首先在IDE中导入mysql-connector-java.jar，这样便可以和数据库打开一个通信通道

打开链接需要使用`DriverManager.getConnection()`方法创建一个`Connection`对象，它代表与数据库的物理连接

查询需要使用类型声明对象建立并提交一个SQL语句到数据库

提取数据使用适当的关于`ResultSet.getXXX()`方法来检索结果集的数据

```java
import java.sql.*;

public class JdbcTest {
   // JDBC 驱动器名称 和数据库地址
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   //数据库的名称为 EXAMPLE
   static final String DB_URL = "jdbc:mysql://localhost/EXAMPLE";

   //  数据库用户和密码
   static final String USER = "root";

   static final String PASS = "";

   public static void main(String[] args) {
       Connection conn = null;
       Statement stmt = null;
       try{
           //注册JDBC 驱动程序
           Class.forName("com.mysql.jdbc.Driver");

           //打开连接
           System.out.println("Connecting to database...");
           conn = DriverManager.getConnection(DB_URL,USER,PASS);

           //执行查询
           System.out.println("Creating statement...");
           stmt = conn.createStatement();
           String sql;
           sql = "SELECT id, name, age FROM Students";
           ResultSet rs = stmt.executeQuery(sql);

           //得到和处理结果集
           while(rs.next()){
               //检索
               int id  = rs.getInt("id");
               int age = rs.getInt("age");
               String name = rs.getString("name");

               //显示
               System.out.print("ID: " + id);
               System.out.print(", Age: " + age);
               System.out.print(", Name: " + name);
               System.out.println();
           }
           //清理环境
           rs.close();
           stmt.close();
           conn.close();
       }catch(SQLException se){
           // JDBC 操作错误
           se.printStackTrace();
       }catch(Exception e){
           // Class.forName 错误
           e.printStackTrace();
       }finally{
           //这里一般用来关闭资源的
           try{
               if(stmt!=null)
                   stmt.close();
           }catch(SQLException se2){
           }
           try{
               if(conn!=null)
                   conn.close();
           }catch(SQLException se){
               se.printStackTrace();
           }
       }
       System.out.println("Goodbye!");
   }
}
```

## 2 JDBC 接口

主要三个接口为：Statement(使用静态SQL语句), CallableStatement(访问数据库存储过程), PreparedStatement(多次使用SQL语句)

### 2.1 Statement

创建一个Statement对象需要使用Connection对象的createStatement()方法进行创建。

```java
Statement stmt = null;
try {
   stmt = conn.createStatement( );
   . . .
}
catch (SQLException e) {
   . . .
}
finally {
   . . .
}
```

创建一个Statement对象之后可以用它来执行SQL语句

常用三个方法:`boolean execute(String SQL)`,`int excuteUpdate(String SQL)`,`ResultSet executeQuery(String SQL)`

1. 用于检测ResultSet对象可以被检索返回true，用来执行SQL DDL语句或者使用真正的动态SQL
2. 用于执行INSERT\UPDATE或者DELETE语句
3. 返回ResultSet对象。用于产生单个结果集的语句。

关闭Statement对象：

```java
Statement stmt = null;
try {
   stmt = conn.createStatement( );
   . . .
}
catch (SQLException e) {
   . . .
}
finally {
   stmt.close();
}
```

### 2.2 PreparedStatement

PreparedStatement 接口扩展了 Statement 接口，有利于高效地执行多次使用的 SQL 语句。

```java
import java.sql.*;

public class JdbcTest {
   // JDBC 驱动器的名称和数据库地址
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/EXAMPLE";


   static final String USER = "root";
   static final String PASS = "";

   public static void main(String[] args) {
       Connection conn = null;
       PreparedStatement stmt = null;
       try{
           //注册 JDBC 驱动器
           Class.forName("com.mysql.jdbc.Driver");

           //打开连接
           System.out.println("Connecting to database...");
           conn = DriverManager.getConnection(DB_URL,USER,PASS);

           //执行查询
           System.out.println("Creating statement...");
           //这里我们要更改一个同学的年龄，参数待定
           String sql = "UPDATE Students set age=? WHERE id=?";
           stmt = conn.prepareStatement(sql);

           //将值绑定到参数，参数从左至右序号为1，2...
           stmt.setInt(1, 22);  // 绑定 age 的值(序号为1)
           stmt.setInt(2, 1); // 绑定 ID 的值

           // 更新 ID 为1的同学的年龄
           int rows = stmt.executeUpdate();
           System.out.println("被影响的行数 : " + rows );

           // 查询所有记录，并显示.
           sql = "SELECT id, name, age FROM Students";
           ResultSet rs = stmt.executeQuery(sql);

           //处理结果集
           while(rs.next()){
               //检索
               int id  = rs.getInt("id");
               int age = rs.getInt("age");
               String name = rs.getString("name");


               //显示
               System.out.print("ID: " + id);
               System.out.print(", Age: " + age);
               System.out.print(", Name: " + name);
               System.out.println();
           }
           //清理
           rs.close();
           stmt.close();
           conn.close();
       }catch(SQLException se){
           se.printStackTrace();
       }catch(Exception e){
           e.printStackTrace();
       }finally{
           try{
               if(stmt!=null)
                   stmt.close();
           }catch(SQLException se2){
           }
    try{
         if(conn!=null)
                 conn.close();
      }catch(SQLException se){
              se.printStackTrace();
          }
       }
           System.out.println("Goodbye!");
   }
}
```

### 2.3 CallableStatement

用于提供一种标准形式调用存储过程的方法。三种类型参数有：IN,OUT和INOUT。

调用存储过程的语法：`{call 存储过程名[(?, ?, ...)]}`

返回结果参数的过程的语法:`{? = call 存储过程名[(?, ?, ...)]}`

```java
CallableStatement cstmt = null;
try {
   String SQL = "{call getEXAMPLEName (?, ?)}";
   cstmt = conn.prepareCall (SQL);
   . . .
}
catch (SQLException e) {
   . . .
}
finally {
   cstmt.close();
}
```