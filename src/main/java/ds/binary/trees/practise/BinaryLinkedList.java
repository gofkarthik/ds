package ds.binary.trees.practise;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryLinkedList {

    private BinaryNode root;

    void preOrder(BinaryNode node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    void inOrder(BinaryNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    void postOrder(BinaryNode node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    void levelOrder() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode node = queue.remove();
            System.out.print(node.value + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    void insert(int value) {
        BinaryNode node = new BinaryNode(value);
        node = new BinaryNode(value);
        node.value = value;
        if (root == null) {
            root = node;
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode binaryNode = queue.remove();
            if (binaryNode.left == null) {
                binaryNode.left = node;
                return;
            } else if (binaryNode.right == null) {
                binaryNode.right = node;
                return;
            } else {
                    queue.add(binaryNode.left);
                    queue.add(binaryNode.right);
                }
            }

    }

    void search(int value) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode binaryNode = queue.remove();
            if (binaryNode.value == value) {
                System.out.println("value found " + value);
                return;
            } else {
                if (binaryNode.left != null) {
                    queue.add(binaryNode.left);
                }
                if (binaryNode.right != null) {
                    queue.add(binaryNode.right);
                }
            }

        }
    }

    void deleteNodeOfBinaryTree(int value) {

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode binaryNode = queue.remove();
            if (binaryNode.value == value) {
                BinaryNode deepestNode = getDeepestNode();
                System.out.println("deepest node " + deepestNode.value);
                binaryNode.value = deepestNode.value;
                deleteDeepestNode();
                return;
            } else {
                if (binaryNode.left != null) {
                    queue.add(binaryNode.left);
                }
                if (binaryNode.right != null) {
                    queue.add(binaryNode.right);
                }
            }
        }
    }


    BinaryNode getDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode node = null;
        while (!queue.isEmpty()) {
            node = queue.remove();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return node;
    }

    void deleteDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode presentNode = null, previousNode = null;
        while (!queue.isEmpty()) {
            previousNode = presentNode;
            presentNode = queue.remove();
            if (presentNode.left == null) {
                previousNode.right = null;
                return;
            } else if (presentNode.right == null) {
                previousNode.left = null;
                return;
            } else {
                queue.add(presentNode.left);
                queue.add(presentNode.right);
            }
        }
    }


    public static void main(String[] args) {

        BinaryLinkedList tree = new BinaryLinkedList();


        //Insert 10 nodes in the tree
        System.out.println("Inserting 10 nodes to tree");
        for (int i = 1; i <= 10; i++)
            tree.insert(i * 10);


        System.out.println("\nLevel-order of tree:");
        tree.levelOrder();
        System.out.println();


        System.out.println("\nPre-order of tree:");
        tree.preOrder(tree.root);
        System.out.println();


        System.out.println("\nPost-order of tree:");
        tree.postOrder(tree.root);
        System.out.println();


        System.out.println("\nIn-order of tree:");
        tree.inOrder(tree.root);
        System.out.println();


        System.out.println("\nSearching node 50 in the tree...");
        tree.search(50);


        System.out.println("\nSearching node 500 in the tree...");
        tree.search(500);

        System.out.println("\nDeleting node having value-5 in the tree...");
        tree.deleteNodeOfBinaryTree(5);


        System.out.println("\nDeleting node having value-50 in the tree...");
        tree.deleteNodeOfBinaryTree(50);
        tree.levelOrder();

        System.out.println("\n\nDeleting node having value-10 in the tree...");
        tree.deleteNodeOfBinaryTree(10);
        tree.levelOrder();

        System.out.println("\n\nDeleting node having value-80 in the tree...");
        tree.deleteNodeOfBinaryTree(80);
        tree.levelOrder();


    }
}
