package ma;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.ProductEntity;

public class TestHibernate {
    public static void main(String[] args) {
        // 获取SessionFactory
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        //通过SessionFactory 获取一个Session
        Session s = sf.openSession();
        //在Session基础上开启一个事务
        s.beginTransaction();

        ProductEntity p = new ProductEntity();
        p.setName("iphone7");
        p.setPrice(7000);
        // 通过调用Session的save方法把对象保存到数据库
        s.save(p);
        //提交事务
        s.getTransaction().commit();
        s.close();//关闭Session
        sf.close();//关闭SessionFactory
    }

}
