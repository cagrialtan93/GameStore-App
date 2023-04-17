import java.util.ArrayList;

public class GameStore {
    private ArrayList<GenreLinkedList> genreLinkedLists = new ArrayList<>();
    private BinarySearchTree binarySearchTree;

    public GameStore() {
        this.binarySearchTree = new BinarySearchTree();
    }

    public void searchByTitle(String title) {

    }

    public void addGame(Game game) {

    }

    public void addGenre(String string) {
        genreLinkedLists.add(new GenreLinkedList(string));
    }

    public void displayAllGamesByOrder() {

    }

    public void displayGamesByGenreSelected(String genre) {

    }

    public void removeGame(Game game) {

    }

    public void updateGame(Game game) {

    }

    public ArrayList<GenreLinkedList> getGenreLinkedLists() {
        return genreLinkedLists;
    }

    public void setGenreLinkedLists(ArrayList<GenreLinkedList> genreLinkedLists) {
        this.genreLinkedLists = genreLinkedLists;
    }

    public BinarySearchTree getBinarySearchTree() {
        return binarySearchTree;
    }

    public void setBinarySearchTree(BinarySearchTree binarySearchTree) {
        this.binarySearchTree = binarySearchTree;
    }
}
