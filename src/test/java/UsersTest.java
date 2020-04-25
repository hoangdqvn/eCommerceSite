import com.bookstore.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class UsersTest {

    public static void main(String[] args) {
        Users user1 = new Users();
        user1.setEmail("hoangdq252@gmail.com");
        user1.setFullName("Hoang Dang Quang");
        user1.setPassword("123456");

        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Users.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user1);
        tx1.commit();
        session.close();
    }
}
