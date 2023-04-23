import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnect {
    private GameStore gameStore = new GameStore();
    private LandingPage landingPage;
    private BinarySearchTree binarySearchTree = new BinarySearchTree();
    private DefaultListModel<Game> gameDefaultListModel = new DefaultListModel<>();

    public DatabaseConnect(GameStore gameStore, BinarySearchTree binarySearchTree) {
        this.gameStore = gameStore;
        this.binarySearchTree = binarySearchTree;
    }

    public DatabaseConnect() {
    }

    private Connection connect() {
        String url = "jdbc:sqlite:appdb";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public BinarySearchTree getGames() throws SQLException {
        ArrayList<Game> games = new ArrayList<>();
        Connection conn = this.connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Game");

        while (rs.next()) {
            System.out.println(rs.getString("title"));
            Game game = new Game(rs.getString("title"), rs.getInt("releaseYear"), rs.getString("genre"));
            games.add(game);
            binarySearchTree.insertGame(game);
        }
        return binarySearchTree;
    }

    public void addGame(Game game) throws SQLException {
        String sql = "insert into Game(title, releaseYear, genre) VALUES (?,?,?)";

        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, game.getTitle());
            pstmt.setInt(2, game.getReleaseYear());
            pstmt.setString(3, game.getGenre());
            pstmt.executeUpdate();
            binarySearchTree.insertGame(game);
        } catch (SQLException e) {
            System.out.println("We already have " + game.getTitle() + " in our database.");
        }
    }
}
