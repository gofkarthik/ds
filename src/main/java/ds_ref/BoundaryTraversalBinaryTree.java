package ds_ref;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int item)
    {
        data = item;
        left = right = null;
    }
}

public class BoundaryTraversalBinaryTree {

    TreeNode root;
    void printBoundaryLeft(TreeNode node)
    {
        if (node == null)
            return;

        if (node.left != null) {
            // to ensure top down order, print the node
            // before calling itself for left subtree
            System.out.print(node.data + " ");
            printBoundaryLeft(node.left);
        }
        else if (node.right != null) {
            System.out.print(node.data + " ");
            printBoundaryLeft(node.right);
        }

        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    public static void main(String[] args) {
        BoundaryTraversalBinaryTree tree=new BoundaryTraversalBinaryTree();
        tree.root = new TreeNode(20);
        tree.root.left = new TreeNode(8);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(12);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.right = new TreeNode(14);
        tree.root.right = new TreeNode(22);
        tree.root.right.right = new TreeNode(25);
        tree.printBoundaryLeft(tree.root);

    }
}
