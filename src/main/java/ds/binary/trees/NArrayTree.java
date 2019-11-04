package ds.binary.trees;

import java.util.*;

/*
                1
       3       2       4
    5      6


 */
public class NArrayTree {

    class Node {
        int val;
        public List<Node> children;
        public Node() {
        }
        public Node(int val, List<Node> _children) {
            val = val;
            children = _children;
        }

    }
    //iterating n array tree level order
    /*
              1
       3       2       4
    5      6

     */
     //Create a queue 1 goes to queue, print 1 or add 1 to list
     //Run until queue not empty
    //  -- create list to collect values of second level (3,2,4)
    //  -- run loop until queue size //first run it is root(1)
    //        --get queue element (1)
    /*          --iterate its child
                -- add to queue (3,2,4)
        --add elements to parent list
     */

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> elements = new ArrayList<>();
        List<Integer> element=new ArrayList<>();
        if(root == null )return elements;
        element.add(root.val);
        elements.add(element);
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> element1=new ArrayList<>();
            //A very vital step .take queue size in integer else queue size will be always growing
            //so take it before looping it
            int sum=0;
            int count=0;
            int qSize=queue.size();
            for(int i=0;i<qSize;i++){
                Node nn = queue.poll();
                for(Node n:nn.children){
                    queue.offer(n);
                    element1.add(n.val);
                    System.out.print(n.val +" ");
                    sum +=n.val;
                    count ++;
                }
            }
            if(!element1.isEmpty()){
                elements.add(element1);
                //for average
                System.out.println("average "+sum/count);
            }
        }
        return elements;
    }

    public static void main(String[] args) {

        List<Integer> ll =new ArrayList<>();
        int l=ll.size();
        System.out.println(l);
        ll.add(2);
        ll.add(5);
        System.out.println(l);
    }

}
