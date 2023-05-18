import com.sun.jdi.event.StepEvent;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnect {
    private GameStore gameStore = new GameStore();
    private LandingPage landingPage;
    private BinarySearchTree binarySearchTree = new BinarySearchTree();
    private DefaultListModel<Game> gameDefaultListModel = new DefaultListModel<>();
    private ArrayList<String> genreList = new ArrayList<>();
    private String url = "jdbc:sqlite:appdb";

    public DatabaseConnect(GameStore gameStore, BinarySearchTree binarySearchTree) throws SQLException {
        this.gameStore = gameStore;
        this.binarySearchTree = binarySearchTree;
        getGames();
    }

    public DatabaseConnect() {

    }

    private Connection connect() {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public User checkCredentials(String username, String password) {
        User user = null;
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            String query = "SELECT * FROM account WHERE username = '" + username + "' AND passoword = '" + password + "'";
            ResultSet rs = stmt.executeQuery(query);

            // Check if a matching record was found
            if (rs.next()) {
                user = new User();
                user = new User(rs.getInt("userid") ,rs.getString("username"), rs.getString("passoword"), rs.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;  // Login credentials are valid
    }

    public Boolean checkUsername(String username){
        Boolean isOk = null;
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            String query = "SELECT * FROM account WHERE username = '" + username + "'";
            ResultSet rs = stmt.executeQuery(query);

            // Check if a matching record was found
            if (rs.next()) {
                isOk = false;
            } else {
                isOk = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isOk;
    }
    public Boolean checkEmail(String email){
        Boolean isOk = null;
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            String query = "SELECT * FROM account WHERE email = '" + email + "'";
            ResultSet rs = stmt.executeQuery(query);

            // Check if a matching record was found
            if (rs.next()) {
                isOk = false;
            } else {
                isOk = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isOk;
    }

    public User checkCredentials(String username, String password, String email){
        User user = null;
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            String query = "SELECT * FROM account WHERE username = '" + username + "' AND passoword = '" + password + "' AND email = '" + email + "'";
            ResultSet rs = stmt.executeQuery(query);

            // Check if a matching record was found
            if (rs.next()) {
                user = new User();
                user = new User(rs.getInt("userid") ,rs.getString("username"), rs.getString("passoword"), rs.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;  // Login credentials are valid

    }
    public boolean createUser(User user) {
        Boolean isCreated = null;
        String sql = "insert into account(username, passoword, email) VALUES (?,?,?)";

        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());
            pstmt.executeUpdate();
            isCreated = true;
        } catch (SQLException e) {
            isCreated = false;
        }
        return isCreated;
    }
    public BinarySearchTree getGames() throws SQLException {
        Connection conn = this.connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM games_ ORDER BY title ASC");

        while (rs.next()) {
            Game game = new Game(rs.getInt("gameid") ,rs.getDouble("price"), rs.getString("title"), rs.getInt("releaseYear"), rs.getString("genre"), rs.getString("publisher"));
            binarySearchTree.insertGame(game);
            gameStore.addGame(game);
        }
        return binarySearchTree;
    }
    public void addGame(Game game) throws SQLException {
        String sql = "insert into games(title, genre, price, publisher, releaseYear) VALUES (?,?,?,?,?)";

        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, game.getTitle());
            pstmt.setString(2, game.getGenre());
            pstmt.setDouble(3, game.getPrice());
            pstmt.setString(4, game.getPublisher());
            pstmt.setInt(5, game.getReleaseYear());

            pstmt.executeUpdate();
            binarySearchTree.insertGame(game);

            for (GenreLinkedList genreLinkedList :
                    gameStore.getGenreLinkedLists()) {
                if (genreLinkedList.getGenre().equals(game.getGenre())) {
                    genreLinkedList.addGame(game);
                }
            }

        } catch (SQLException e) {
            System.out.println("We already have " + game.getTitle() + " in our database.");
        }
    }
    public Boolean addGamesBought(User user, Game game){
        Boolean haveGame = null;
        String sql = "insert into games_bought(userid, gamesid) VALUES (?,?)";
        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            if (!checkGamesBoughtIfItsIn(user.getUserid(), game.getGameid())){
                pstmt.setInt(1, user.getUserid());
                pstmt.setInt(2, game.getGameid());
                pstmt.executeUpdate();
                haveGame = true;
            } else {
                haveGame = false;
            }
        } catch (SQLException e) {
            System.out.println("You already have bought that game.");
        }
        return haveGame;
    }
    public Game checkIfInDatabase(String gameName) throws SQLException {
        Game game = null;
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            String query = "SELECT * FROM games_ WHERE title = '" + gameName + "'";
            ResultSet rs = stmt.executeQuery(query);

            // Check if a matching record was found
            if (rs.next()) {
                game = new Game(rs.getInt("gameid") ,rs.getDouble("price"), rs.getString("title"), rs.getInt("releaseYear"), rs.getString("genre"),rs.getString("publisher"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return game;
    }
    public boolean checkGamesBoughtIfItsIn(int userid, int gameid){
        Boolean result = false;
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            String query = "SELECT * FROM games_bought WHERE userid = '" + userid + "' AND gamesid = '" + gameid + "'";
            ResultSet rs = stmt.executeQuery(query);

            // Check if a matching record was found
            if (rs.next()) {
                result = true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public DefaultListModel<String> getMyGames(User user) throws SQLException {
        DefaultListModel<String> defaultListModel = new DefaultListModel<>();
        Connection conn = this.connect();
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT games.title from account,games, games_bought where account.userid = games_bought.userid and games.gameid = games_bought.gamesid and account.userid = '" + user.getUserid() + "' ORDER BY games.title ASC");

        while (rs.next()){
            defaultListModel.addElement(rs.getString("title"));
        }

        return defaultListModel;
    }
}
