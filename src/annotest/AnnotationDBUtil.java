package annotest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 注解 DBUtil
 */
@JDBCConfig(ip = "127.0.0.1", database = "test", enCoding = "UTF-8", username = "root", password = "123456")
public class AnnotationDBUtil {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        JDBCConfig config = AnnotationDBUtil.class.getAnnotation(JDBCConfig.class);
        String ip = config.ip();
        int port = config.port();
        String database = config.database();
        String enCoding = config.enCoding();
        String username = config.username();
        String password = config.password();
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, enCoding);
        return DriverManager.getConnection(url, username, password);
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }
}
