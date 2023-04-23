import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnect {
    GameStore gameStore = new GameStore();
    LandingPage landingPage = new LandingPage(gameStore);

    public DatabaseConnect(GameStore gameStore) throws SQLException {
        this.gameStore = gameStore;
    }

    public DatabaseConnect() throws SQLException {
    }

    private Connection connect() {
        String url = "jdbc:sqlite:appdb";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("nice");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public ArrayList<Game> getGames() throws SQLException {
        Connection conn = this.connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Game");

        while (rs.next()) {
            System.out.println(rs.getString("title"));
            Game game = new Game(rs.getString("title"), rs.getInt("releaseYear"), rs.getString("genre"));
            gameStore.addGame(game);

        }
        return null;
    }

    public void addGame(Game game) throws SQLException {
        String sql = "insert into Game(title, releaseYear, genre) VALUES (?,?,?)";

        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, game.getTitle());
            pstmt.setInt(2, game.getReleaseYear());
            pstmt.setString(3, game.getGenre());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("We already have " + game.getTitle() + " in our database.");
        }
    }
}
