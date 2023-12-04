package annotest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 注解 DBUtil
 */
public class AnnotationDBUtilChild extends AnnotationDBUtil {

    public static Connection getConnection2() throws SQLException {
        JDBCConfig config = AnnotationDBUtilChild.class.getAnnotation(JDBCConfig.class);
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
        System.out.println(getConnection2());
    }
}
