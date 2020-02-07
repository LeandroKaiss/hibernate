import org.hibernate.*;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

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

    public String listData() {
        Session session = null;
        StringBuilder result = new StringBuilder();
        try {
            SessionFactory sessionFactory = Util.getSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createSQLQuery("Select * FROM table1");
            List<Object[]> rows = query.list();
            for (Object[] res : rows)
                result.append(res[0].toString()).append(" ").append(res[1].toString()).append(" ").append(res[2].toString()).append(" ").append("\n");
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            assert session != null;
            session.close();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Schema schema = new Schema();
        HibernateCRUD hibernateCRUD = new HibernateCRUD();
        WriteData writeData = new WriteData();
        writeData.write(hibernateCRUD.listData(), "query.txt");
    }
}
