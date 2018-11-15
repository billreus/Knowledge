package UserProduct;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.ProductEntity;
import test.User;

public class TestManyToMany {
    public static void main(String[] args){
    SessionFactory sf = new Configuration().configure().buildSessionFactory();

    Session s = sf.openSession();
    s.beginTransaction();

    //增加3个用户
    Set<User> users = new HashSet();
    for (int i = 0; i < 3; i++) {
        User u =new User();
        u.setName("user"+i);
        users.add(u);
        s.save(u);
    }

    //产品1被用户1,2,3购买
    ProductEntity p1 = (ProductEntity) s.get(ProductEntity.class, 1);

    p1.setUsers(users);
    s.save(p1);
    s.getTransaction().commit();
    s.close();
    sf.close();
}
}
