public class Game {
    private int gameid;
    private double price;
    private String title;
    private int releaseYear;
    private String genre;
    private Game next;
    private Game previous;
    private String publisher;

    public Game(int gameid, double price, String title, int releaseYear, String genre, String publisher) {
        this.gameid = gameid;
        this.price = price;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Game getNext() {
        return next;
    }

    public void setNext(Game next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Game{" +
                "title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", genre='" + genre + '\'' +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getGameid() {
        return gameid;
    }

    public void setGameid(int gameid) {
        this.gameid = gameid;
    }

    public Game getPrevious() {
        return previous;
    }

    public void setPrevious(Game previous) {
        this.previous = previous;
    }
}
