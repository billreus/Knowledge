package ma;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.Category;
import test.ProductEntity;

public class TestManyToOne {
    public static void main(String[] args){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session s = sf.openSession();
        s.beginTransaction();

        Category c = new Category();
        c.setName("c1");
        s.save(c);

        ProductEntity p = s.get(ProductEntity.class, 8);
        p.setCategory(c);
        s.update(p);

        s.getTransaction().commit();
        s.close();
        sf.close();
    }
}
