package ma;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import test.ProductEntity;

public class TestGET {
    public static void main(String[] args){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session s = sf.openSession();
        s.beginTransaction();
        //调用session的get方法，需要传递类的对象
        ProductEntity p =s.get(ProductEntity.class, 2);
        s.delete(p);
        //System.out.println("id=1的产品是" + p.getName());

        //修改
        //p.setName("iphone1");
        //s.update(p);

        s.getTransaction().commit();
        s.close();
        sf.close();
    }
}
