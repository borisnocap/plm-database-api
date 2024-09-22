package io.plumium.database;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@SuppressWarnings("unused")
public interface DatabaseAPI {

    @NotNull Connection getConnection() throws SQLException;

    void close(Connection connection);

    void close(PreparedStatement preparedStatement);

    void close(ResultSet resultSet);

    void executeUpdate(@NotNull Plugin plugin, @NotNull PreparedStatement preparedStatement) throws SQLException;

    /**
     * Получить ID, соответствующий указанному никнейму.
     * @return ID, если игрок с таким никнеймом существует, и null, если не существует.
     */
    @Nullable
    Long getID(String nickname);

    /**
     * Получить никнейм, соответствующий указанному ID.
     * @return Никнейм, если игрок с таким ID существует, и null, если не существует.
     */
    @Nullable
    String getNickname(long id);

    /**
     * Получить ID, соответствующий указанному никнейму без учета регистра.
     * @return ID, если игрок с таким никнеймом существует, и null, если не существует.
     */
    @Nullable
    Long getIdByNickIgnoreCase(String nicknameIgnoreCase);

    /**
     * Получить список никнеймов игроков, которые начинаются с указанного префикса без учета регистра.
     * @return Список никнеймов в правильном регистре.
     */
    List<String> getNicknamesStartsWithIgnoreCase(String prefixIgnoreCase);
}
