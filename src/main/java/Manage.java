import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Manage {
    private static SessionFactory factory;

    public static void main(String[] args) {
        try {
            factory = new Configuration().
                    configure().
                    addAnnotatedClass(Schema.class).
                    buildSessionFactory();
        } catch (Throwable throwable) {
            System.err.println("sessionFactory failed to be created");
            throw new ExceptionInInitializerError(throwable);
        }

    }
}
