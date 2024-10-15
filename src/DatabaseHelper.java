import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHelper implements AutoCloseable {
    private Connection connection;

    public DatabaseHelper(String url, String user, String password) throws SQLException {
        // Подключение к базе данных PostgreSQL
        connection = DriverManager.getConnection(url, user, password);
    }

    // Метод для создания таблицы результатов битвы
    public void createTable() throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS battle_results (" +
                "id SERIAL PRIMARY KEY, " +
                "winner_name VARCHAR(100), " +
                "winner_health INTEGER)";
        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.execute();
        }
    }

    // Метод для записи результатов битвы в базу данных
    public void saveBattleResult(String winnerName, int winnerHealth) throws SQLException {
        String insertSQL = "INSERT INTO battle_results (winner_name, winner_health) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, winnerName);
            preparedStatement.setInt(2, winnerHealth);
            preparedStatement.executeUpdate();
        }
    }

    // Закрытие соединения с базой данных
    @Override
    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}