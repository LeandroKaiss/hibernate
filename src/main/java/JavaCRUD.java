
import java.sql.*;

public class JavaCRUD {
    private static final String DATABASE_URL = "jdbc:mysql://localhost/schema_test?useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Aa123456*w";

    public static void createTable(){
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            boolean flag;
            flag = statement.execute("CREATE TABLE teste2(id int PRIMARY KEY AUTO_INCREMENT, sample1 varchar(50), sample2 int)");
            if (flag) System.out.println("Created");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.exit(1);
            } catch (NullPointerException f) {
                f.printStackTrace();
                System.exit(1);
            }
        }

    }

    public static void insertIntoTable(String sample1, int sample2){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement("INSERT INTO teste2(sample1, sample2) VALUES(?,?)");
            preparedStatement.setString(1, sample1);
            preparedStatement.setInt(2, sample2);
            boolean flag = preparedStatement.execute();
            if (flag) System.out.println("Inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void updateValues(String sample1, int sample2, int id){
        PreparedStatement preparedStatement = null;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
            preparedStatement = connection.prepareStatement("UPDATE teste2 SET sample1=?, sample2=? WHERE id=?");
            preparedStatement.setString(1, sample1);
            preparedStatement.setInt(2, sample2);
            preparedStatement.setInt(3, id);
            boolean flag = preparedStatement.execute();
            if (flag) System.out.println("Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteLine(int id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
            preparedStatement = connection.prepareStatement("DELETE FROM teste2 WHERE id=?");
            preparedStatement.setInt(1, id);
            boolean flag = preparedStatement.execute();
            if (flag) System.out.println("Deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
    public static void main(String[] args) {
        JavaCRUD javaCRUD = new JavaCRUD();
        deleteLine(1);
    }
}

