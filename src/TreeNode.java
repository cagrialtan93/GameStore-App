import com.sun.source.tree.Tree;

public class TreeNode {
    private TreeNode leftChild;
    private TreeNode rightChild;
    private Game game;

    public TreeNode(Game game) {
        this.game = game;
    }

    public void insertGame(Game gameToAdd) {
        TreeNode nodeToAdd = new TreeNode(gameToAdd);
        if (game == gameToAdd) {
            return;
        } else {
            if (gameToAdd.getTitle().compareTo(game.getTitle()) < 0) {
                if (leftChild == null) {
                    leftChild = nodeToAdd;
                } else {
                    leftChild.insertGame(gameToAdd);
                }
            } else {
                if (rightChild == null) {
                    rightChild = nodeToAdd;
                } else {
                    rightChild.insertGame(gameToAdd);
                }
            }
        }
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
