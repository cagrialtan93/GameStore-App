public class GenreLinkedList {
    private Game head;
    private Game tail;
    private int size;
    private String genre;

    public GenreLinkedList(String genre) {
        this.genre = genre;
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public void addGame(Game game) {
        if (head == null) {
            head = tail = game;
        } else {
            head.setNext(game);
            head = game;
        }
        size++;
    }

    public void printList() {
        Game current = head;
        if (current != null) {
            System.out.println(current.getTitle());
            current = current.getNext();
        }
    }

    public Game getHead() {
        return head;
    }

    public void setHead(Game head) {
        this.head = head;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Game getTail() {
        return tail;
    }

    public void setTail(Game tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
