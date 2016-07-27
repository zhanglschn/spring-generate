package threadLocal;

import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.beans.factory.support.InstantiationStrategy;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 使用Threadlocal模拟dao
 *
 * @author:chenssy
 * @date : 2016/6/22 17:48
 */
public class TopDao {
    private static  ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();


    public  static Connection getConnection() throws SQLException {

        InstantiationStrategy


        if(connectionThreadLocal.get() == null){
            Connection connection = DriverManager.getConnection("");
            connectionThreadLocal.set(connection);
        }
        return connectionThreadLocal.get();
    }
}
