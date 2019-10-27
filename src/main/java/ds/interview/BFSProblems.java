package ds.interview;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}



public class BFSProblems {

    /*
    Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
    For example, given a 3-ary tree:

     */
 //N array
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new LinkedList<>();
        if (root == null) return ret;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> val_ll=new ArrayList<>();
        val_ll.add(root.val);
        ret.add(val_ll);
        while (!queue.isEmpty()) {
            List<Integer> vals=new ArrayList<>();
            int queueSize=queue.size();
            for(int i=0;i<queueSize;i++){
                Node nn=queue.poll();
                for(Node a:nn.children){
                    queue.offer(a);
                    vals.add(a.val);
                }
            }
            if(!vals.isEmpty())ret.add(vals);
        }

        return ret;
    }
    //N array depth
    public int maxDepth(Node root) {
        if(root == null) return 0;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        int depth=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                Node qq= queue.poll();
                for(Node node:qq.children){
                    queue.offer(node);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {

    }
}
