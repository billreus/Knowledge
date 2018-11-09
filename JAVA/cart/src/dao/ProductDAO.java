package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bean.Product;

public class ProductDAO {

    public ProductDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Success loading Mysql Driver");
        }catch (ClassNotFoundException e){
            System.out.println("Error loading Mysql Driver!");
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/cart",
                "root",  "123456");
    }

    public List<Product> ListProduct(){
        List<Product> products = new ArrayList<Product>();
        String sql = "select * from product order by id desc";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float price = rs.getFloat(3);

                product.setId(id);
                product.setName(name);
                product.setPrice(price);
                products.add(product);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return products;
    }

}
