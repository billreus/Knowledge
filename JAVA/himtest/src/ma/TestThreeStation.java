package ma;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.ProductEntity;

public class TestThreeStation {

    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session s = sf.openSession();
        s.beginTransaction();
        /*
        ProductEntity p = new ProductEntity();
        p.setName("p1");
        System.out.println("此时p是瞬时状态");
        s.save(p);
        System.out.println("此时p是持久状态");
        s.getTransaction().commit();
        s.close();
        System.out.println("此时p是脱管状态");
        sf.close();
        */
        for(int i = 0; i < 10; i++){
            ProductEntity p = new ProductEntity();
            p.setName("iphone"+i);
            p.setPrice(i);
            s.save(p);
        }
        s.getTransaction().commit();
        s.close();
        sf.close();
    }

}
