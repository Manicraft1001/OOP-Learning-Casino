package me.manicraft.casino.utils.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private String dbUrl;
    private String dbUser;
    private String dbPwd;

    private static ConnectionFactory connectionFactory;

    private ConnectionFactory(String url, String user, String pwd) {
        dbUrl = url;
        dbUser = user;
        dbPwd = pwd;
    }

    public static ConnectionFactory getInstance() {
        if (connectionFactory == null)
            connectionFactory = new ConnectionFactory("jdbc:mysql://localhost/casino", "myuser", "1234");
        return connectionFactory;
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(getDbUrl(), getDbUser(), getDbPwd());
        return conn;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPwd() {
        return dbPwd;
    }

    public void setDbPwd(String dbPwd) {
        this.dbPwd = dbPwd;
    }
}
