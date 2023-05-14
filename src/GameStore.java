import java.util.ArrayList;

public class GameStore {
    private ArrayList<GenreLinkedList> genreLinkedLists = new ArrayList<>();
    private BinarySearchTree binarySearchTree;
    private DatabaseConnect databaseConnect;

    public GameStore() {
        this.binarySearchTree = new BinarySearchTree();
    }

    public void searchByTitle(String title) {

    }

    public void addGame(Game game) {
        for (GenreLinkedList genreLinkedList :
                genreLinkedLists) {
            if (genreLinkedList.getGenre().equals(game.getGenre())) {
                genreLinkedList.addGame(game);
            }
        }
    }

    public void addGenreList(GenreLinkedList genreLinkedList) {
        if (!genreLinkedLists.contains(genreLinkedList)) {
            genreLinkedLists.add(genreLinkedList);
        } else {
            System.out.println("The genre list you want to add is already on our system.");
        }
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
