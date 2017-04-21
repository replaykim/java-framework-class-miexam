package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by replay on 2017. 4. 21..
 */
public class JejuConnectionMaker implements ConnectionMaker {
    private String className;
    private String url;
    private String username;
    private String password;

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        {
            Class.forName(className);
            return DriverManager.getConnection(url, username, password);
        }
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
