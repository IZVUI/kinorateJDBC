package DAO;

import java.sql.Connection;

public abstract class DAO {
    Connection connection;

    public DAO() throws ClassNotFoundException {
        setConnection(ConnectionFactory.getConnection());
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
