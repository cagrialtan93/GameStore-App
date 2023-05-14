import javax.swing.*;

public class GenreLinkedList {
    private Game head;
    private Game tail;
    private int size;
    private String genre;
    private String[] games;

    public GenreLinkedList(String genre) {
        this.genre = genre;
        this.size = 0;
        this.head = null;
        this.tail = null;
        this.games = new String[15]; // TODO this should be arraylist.
    }

    public void addGame(Game game) {
        if (head == null) {
            head = tail = game;
        } else {
            game.setNext(head);
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

    public String[] linkedListToArray(){
        Game current = head;
        for (int i = 0; i < size; i++) {
            if (current != null){
                games[i] = current.getTitle();
                current = current.getNext();
            } else {
                break;
            }
        }
        return games;
    }
}
