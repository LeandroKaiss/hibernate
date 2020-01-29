import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateCRUD {
    public void saveData(Schema schema){
        Session session = null;
        try {
            SessionFactory sessionFactory = Util.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(schema);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateData(Schema schema){
        Session session = null;
        try {
            SessionFactory sessionFactory = Util.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(schema);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteData(Schema schema){
        Session session = null;
        try {
            SessionFactory sessionFactory = Util.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(schema);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void main(String[] args) {
        Schema schema = new Schema();
        HibernateCRUD hibernateCRUD = new HibernateCRUD();
        schema.setId(2);
        hibernateCRUD.deleteData(schema);
    }
}
