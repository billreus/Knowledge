import com.rcnjtech.entiy.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

/**
 * 测试类
 *
 * @author RCNJTECH
 */
public class Main {
    private static final SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        final Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Student student = new Student(10001, "张三", "男", new Date());
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
