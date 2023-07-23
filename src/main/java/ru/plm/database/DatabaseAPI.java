package ru.plm.database;

import org.bukkit.plugin.Plugin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Callable;

public interface DatabaseAPI {

    Connection getConnection() throws SQLException;

    Connection getConnectionWithoutAutoCommit() throws SQLException;

    void rollbackCommit(Connection connection);

    void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet);

    void close(Connection connection);

    void closePool();

    void runSyncAndAsyncTaskStepByStep(Plugin plugin, Callable<Void> asyncTask, Runnable syncTask, Runnable onErrorSyncTask);
}
