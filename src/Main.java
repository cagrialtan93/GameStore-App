import java.nio.file.AccessDeniedException;

public class Main {
    public static void main(String[] args) {
        Game w3 = new Game("Witcher 3", 2015, "Action");
        Game gow = new Game("God of War", 2007, "Action");
        Game cs2 = new Game("Counter Strike 2", 2023, "Shooter");
        Game warz = new Game("World War Z", 2017, "Survival");
        Game way = new Game("Way", 2023, "Adventure");
        Game cyberpunk = new Game("Cyberpunk", 2020, "Action");
        Game raft = new Game("Raft", 2017, "Survival");
        Game lol = new Game("League of Legends", 2010, "MMO");

        GameStore gameStore = new GameStore();
        gameStore.addGenre("Action");
        gameStore.addGenre("Survival");
        gameStore.addGenre("Shooter");
        gameStore.addGenre("MMO");
        gameStore.addGenre("Adventure");

        gameStore.addGame(w3);
        gameStore.addGame(gow);
        gameStore.addGame(cyberpunk);
        gameStore.addGame(warz);


        new GUIClass(gameStore);
    }
}