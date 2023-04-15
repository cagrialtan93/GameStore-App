import com.sun.source.tree.Tree;

public class BinarySearchTree {
    private TreeNode root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public void insertGame(Game game) {
        TreeNode treeNodeToAdd = new TreeNode(game);
        if (root == null) {
            root = treeNodeToAdd;
        } else {
            root.insertGame(game);
        }
    }

    public void inOrder(TreeNode root){
        if (root == null){
            return;
        }

        inOrder(root.getLeftChild());
        System.out.println(root.getGame().getTitle());
        inOrder(root.getRightChild());
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
