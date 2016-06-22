package threadLocal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 使用Threadlocal模拟dao
 *
 * @author:chenssy
 * @date : 2016/6/22 17:48
 */
public class TopDao {
    private static  ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();

    public  static Connection getConnection() throws SQLException {
        if(connectionThreadLocal.get() == null){
            Connection connection = DriverManager.getConnection("");
            connectionThreadLocal.set(connection);
        }
        return connectionThreadLocal.get();
    }
}
