package ds_ref.tree;

/*
create delete traversals
 */


import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    //insert
    TreeNode root;

    void insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
        }
        Queue<TreeNode> qr = new LinkedList<>();
        qr.add(root);
        while (!qr.isEmpty()) {
            TreeNode tr = qr.poll();
            if (tr.left == null) {
                tr.left = new TreeNode(val);
                break;
            } else if (tr.right == null) {
                tr.right = new TreeNode(val);
                break;
            } else {
                qr.add(tr.left);
                qr.add(tr.right);
            }
        }

    }

    //complete insert

}
