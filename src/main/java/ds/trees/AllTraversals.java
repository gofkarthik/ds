package ds.trees;

import ds.trees.util.*;


import java.util.*;

public class AllTraversals {


    static void levelOrder(Node node)
    {
        // Your code here
        if(node == null){
            return;
        }
        Node temp=node;
        Queue<Node> queue=new LinkedList<>();
        queue.add(temp);
        while(!queue.isEmpty()){
            temp=queue.poll();
            System.out.print(temp.data+" ");
            if(temp.left != null)queue.add(temp.left);
            if(temp.right != null)queue.add(temp.right);
        }
    }

    static void levelOrderLineByLine(Node node){
        if(node == null)return;
        Queue<Node> queue=new LinkedList();
        queue.add(node);
        queue.add(null);
        while(!queue.isEmpty()){
            Node cur=queue.poll();
            if(cur == null){
                if(!queue.isEmpty()){
                    queue.add(null);
                }
                System.out.println();
            }else{
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
                System.out.print(cur.data+" ");
            }

        }
    }

    static void levelOrderSumAverage(Node node){
        if(node == null)return;
        Queue<Node> queue=new LinkedList();
        queue.add(node);
        queue.add(null);
        int sum=0;
        int count=0;
        while(!queue.isEmpty()){
            Node cur=queue.poll();
            if(cur == null){
                if(!queue.isEmpty()){
                    queue.add(null);
                }
                System.out.println("sum "+sum+" count "+count+" avg "+sum/count);
                sum=0;
                count=0;

            }else{
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
                sum+=cur.data;
                count++;
                System.out.print(cur.data+" ");
            }

        }
    }

    static  void reversePrint(Node node)
    {
        // your code here
        if(node == null) return;
        Queue<Node> queue=new LinkedList<>();
        Stack<Integer> stack=new Stack<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node cur=queue.poll();
            stack.add(cur.data);
            if(cur.right != null) queue.add(cur.right);
            if(cur.left != null) queue.add(cur.left);
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    //zigzag
    void zigZagTraversal(Node root,boolean isZigZag)
    {
        //Add your code here.
        if(root == null) return;
        Stack<Node> s1=new Stack<>();
        Stack<Node> s2=new Stack<>();
        s1.add(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
            while(!s1.isEmpty()){
                Node curr=s1.pop();
                System.out.print(curr.data+" ");
                if(isZigZag){
                    if(curr.left != null){
                        s2.push(curr.left);
                    }
                    if(curr.right != null){
                        s2.push(curr.right);
                    }
                }else{
                    if(curr.right != null){
                        s2.push(curr.right);
                    }
                    if(curr.left != null){
                        s2.push(curr.left);
                    }
                }
            }
            while(!s2.isEmpty()){
                Node curr=s2.pop();
                System.out.print(curr.data+" ");
                if(isZigZag) {
                    if (curr.right != null) {
                        s1.push(curr.right);
                    }
                    if (curr.left != null) {
                        s1.push(curr.left);
                    }
                }else{
                    if(curr.left != null){
                        s1.push(curr.left);
                    }
                    if(curr.right != null){
                        s1.push(curr.right);
                    }
                }
            }

        }

    }

    //Inorder recursive
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root == null) return result;
        inOrderTraverse(root,result);
        return result;
    }


    private void inOrderTraverse(TreeNode root,List<Integer> result){
        if(root == null)return;
        inOrderTraverse(root.left,result);
        result.add(root.val);
        inOrderTraverse(root.right,result);
    }

     List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> ss=new Stack<>();
        TreeNode cur=root;
        while(!ss.isEmpty() || cur!= null){
            while(cur != null){
                ss.push(cur);
                cur=cur.left;
            }
            cur=ss.pop();
            result.add(cur.val);
            cur=cur.right;
        }
        while(!ss.isEmpty()){
            result.add(ss.pop().val);
        }
        return result;
    }

    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root == null)   return result;
        recursivePreOrder(root,result);
        return result;
    }

    private void recursivePreOrder(TreeNode root,List<Integer> result){
        if(root == null) return;
        result.add(root.val);
        recursivePreOrder(root.left,result);
        recursivePreOrder(root.right,result);
    }

    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> ss=new Stack<>();
        if(root == null)return result;
        ss.add(root);
        while(! ss.isEmpty()){
            TreeNode node=ss.pop();
            result.add(node.val);
            if(node.right != null) ss.push(node.right);
            if(node.left != null) ss.push(node.left);
        }
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root == null)return result;
        Stack<TreeNode> ss1=new Stack<>();
        Stack<TreeNode> ss2=new Stack<>();
        ss1.add(root);
        while(!ss1.isEmpty()){
            TreeNode node=ss1.pop();
            ss2.add(node);
            if(node.left != null) ss1.add(node.left);
            if(node.right != null) ss1.add(node.right);
        }
        while(!ss2.isEmpty()){
            result.add(ss2.pop().val);
        }
        return result;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println("Level order traversal of binary tree is - ");
        levelOrder(root);
        System.out.println("Level order traversal of binary tree is (line by line - ");
        levelOrderLineByLine(root);
        System.out.println("Level order traversal sum count average");
        levelOrderSumAverage(root);
        System.out.println("Level order traversal reverse");
        reversePrint(root);
    }
}
