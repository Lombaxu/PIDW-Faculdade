import java.sql.*;

public class Database {
    private static final String URL = "jdbc:sqlite:enquete.db";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
    
    public static void criarTabelas() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            
            stmt.execute("CREATE TABLE IF NOT EXISTS usuarios (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT NOT NULL, " +
                "email TEXT UNIQUE NOT NULL, " +
                "senha TEXT NOT NULL)");
            
            stmt.execute("CREATE TABLE IF NOT EXISTS enquetes (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "pergunta TEXT NOT NULL, " +
                "opcoes TEXT NOT NULL)"); // Opções como JSON: ["Ação", "Comédia"]
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}