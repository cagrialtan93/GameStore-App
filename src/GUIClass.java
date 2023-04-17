import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;

public class GUIClass {
    private GameStore gameStore;
    private Game[] games;

    public GUIClass(GameStore gameStore) {
        this.gameStore = gameStore;
        this.games = new Game[3]; //todo make this right
        JFrame jFrame = new JFrame("Online Game Store");

        for (int i = 0; i < games.length; i++) {
            System.out.println(games[i]);
        }

        String[] games = new String[10];


        JList<Game> jList = new JList<>(gameStore.getGenreLinkedLists().get(0).linkedListToArray());

        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()){
                    System.out.println(jList.getSelectedValue().getTitle());
                }
            }
        });

        jFrame.add(jList);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(400, 400);
        jFrame.show();

    }
}
