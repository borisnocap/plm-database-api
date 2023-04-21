package ru.plm.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DatabaseAPI {

    Connection getConnection() throws SQLException;

    void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet);

    void rollbackCommit(Connection connection);

    void closePool();
}
