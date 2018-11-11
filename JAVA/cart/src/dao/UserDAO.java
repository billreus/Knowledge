package dao;

import bean.User;

import java.sql.*;

public class UserDAO {

    public User getUser(String name, String password){
        User result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Success loading Mysql Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cart",
                    "root",  "123456");
            String sql = "select * from user where name = ? and password = ?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, name);//sql处理后获取结果
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                result = new User();
                result.setId(rs.getInt(1));
                result.setPassword(password);
                result.setName(name);
            }
            ps.close();
            c.close();

        } catch (ClassNotFoundException e) {// TODO Auto-generated catch block
            System.out.println("Error loading Mysql Driver");
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
