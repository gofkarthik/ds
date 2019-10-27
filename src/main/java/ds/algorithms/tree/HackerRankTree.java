package ds.algorithms.tree;

import java.util.*;

/*
  for understanding recursion
  call stack
  methodcall linenumber root
  preorder                 9  -->step1
  when recursive call is made that call goes into stack with new value called and line called is kept there
   preorder    6           9  (line 6 is where recursive call is made)
   preorder                2  (this is the new function call)
 */
public class HackerRankTree {

     class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
        }
    }
    //visit root //visit left //visit right
    public static void preOrder(Node root) {
        if(root == null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //visit left visit right visit root
    public static void postOrder(Node root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    //visit left root visit right
    public static void inOrder(Node root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    ///iterative
    //in depth explanation found here
    //https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
    /*
       create cur point to root
       create stack
       while -> cur != null && stack.size > 0
           while(cur != null) --> put int stack ,cur-> cur.left
        pop from stack
        print element
        cur=cur.right
     */
    public static void inOrderItr(Node root) {

        //iterative
        if(root == null){
            return;
        }
        Stack<Node> ss=new Stack<>();
        Node cur=root;
        while(cur != null || ss.size() > 0){
            while(cur != null){
                ss.push(cur);
                cur = cur.left;
            }
            cur=ss.pop();
            System.out.print(cur.data + " ");
            cur = cur.right;
        }
    }
    //height of bianry tree is 1 + number of edges on the longest path from root to leaf
    //for height consider taht node also so +1
    //this is also called max depth
    // if node==null return 0
    // int left=keep finding left
    // int right=keep finding right
    // if(left > right) h = 1+left else h= 1+right returh h
    public static int height(Node node) {
        if (node == null)
            return -1; //normally it is . . 0
        /* compute the depth of each subtree */
        int lDepth = height(node.left);
        int rDepth = height(node.right);

        /* use the larger one */
        if (lDepth > rDepth)
            return (lDepth + 1);
        else
            return (rDepth + 1);
    }

    //level order traversal
    public static void levelOrder(Node root) {
        if(root == null){
            return;
        }
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            System.out.print(node.data+ " ");
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }

/*
    //top view of the binary tree
    //level order traversal + vertical order traversal

    Vertical order traversal
    for vertical order calculate horizontal distance for each node in binary tree

    horizontal distance is distance from one side of the tree
    for root hd=0
    for left child hd=hd-1
    for right child hd=hd+1

                              a 0
               -1(0-1)  b             c (0+1)=1
                (-2)  d     e0        0f     g2
               -3 l                 -1h   i1
                                            j2
                                              k3

                       -3   -2  -1 0   1    2   3
                        l   d    b a   c    g   k
                                 h e   i    j
                                   f
            min distance = -3
            max distance = 3
            node with same horizontal distance will come in same line as seen above

     Algorithm for vertical order traversal
     Create queue and hashtable

     Enque root
     update hd as 0
     update hd and node related to that
     while(queue not empty)
     dequeu
     check for left and right child
     caclulate and udate there hd in hash table
     enque left child

     //create a tree map with list<nodes>
     hashtable
     hd   nodes
     0     a,e,f
     -1    b
      1    c
     printing order => 0 -1 1 -2 2 -3 3

  */
    void addNodeInMap(TreeMap<Integer,List<TreeNode>> orderMap,
                      TreeNode node,int node_index){

        //for vertical tree
       /* if(orderMap.containsKey(node_index)){
            List<TreeNode> treeOrder=orderMap.get(node_index);
            treeOrder.add(node);
        }else{
            List<TreeNode> nodes=new ArrayList<>();
            nodes.add(node);
            orderMap.put(node_index,nodes);
        }*/


        //put only if not exist //for top view
        if( !orderMap.containsKey(node_index)){
            List<TreeNode> nodes=new ArrayList<>();
            nodes.add(node);
            orderMap.put(node_index,nodes);
        }
    }

    public List<List<Integer>> verticalOrderTraversal(TreeNode root) {

        TreeMap<Integer,List<TreeNode>> orderMap=new TreeMap<>();
        Queue<TreeNode> nodes=new LinkedList<>();
        Queue<Integer> node_index=new LinkedList<>();
        nodes.add(root);
        node_index.add(0);
        while(!nodes.isEmpty()){
            TreeNode node=nodes.remove();
            Integer node_hd_index=node_index.remove();
            addNodeInMap(orderMap,node,node_hd_index);
            if(node.left != null){
                nodes.add(node.left);
                node_index.add(node_hd_index-1);
            }
            if(node.right != null){
                nodes.add(node.right);
                node_index.add(node_hd_index+1);
            }
        }
        List<List<Integer>> entires=new ArrayList<>();
        for(Map.Entry<Integer,List<TreeNode>> nodesEntries:orderMap.entrySet()){
            List<TreeNode> treeNodes=nodesEntries.getValue();
            List<Integer> values=new ArrayList<>();
            for(TreeNode treeNode:treeNodes){
                values.add(treeNode.val);
            }
            entires.add(values);
        }
        return entires;
    }

      /*
        level order abcdefglhijk
        top view-> only one node should come out of vertical line from above
                l d now we have b and h (so in level order traversal whoever came first they will come)
                  ldbacgk*/

      private void topView(Node root){
          class QueueObj{
              Node node;
              int hd;
              QueueObj(Node node,int hd){
                this.node=node;
                this.hd=hd;
              }
          }
          TreeMap<Integer,Node> orderMap=new TreeMap<>();
          Queue<TreeNode> nodes=new LinkedList<>();

      }

     //this is binary search tree insertion
    //for binary tree insertion do a level order traversal
    //insert new node for left and right
    public  Node insert(Node root,int data) {
        if(root == null){
            root =new Node(data);
            return root;
        }else if( data <= root.data ){
            root.left=insert(root.left,data);
            return root;
        }else{
            root.right=insert(root.right,data);
            return root;
        }

    }

     //Lowest common ancestor of 2 nodes in binary tree
    // common parent of nodes
    /*
                         a
                      b              c
                 d        e       f      g
              h    i    r   s
                m     n

           so far m and n the lowest common ancestor is b
           but lca for f and c is c itself
     Algo
       1) search the two node in binary tree
       2) if (node found) return node else return null
       3)  when some node receives left and right as not null,then it is the LCA
           else return what it receives
              x
             m  r   -->return x

              x
            null r  --> return r and vie versa

              x
            null null  --> return null

      lca(node root,node 1,node 2)
       if root == null return null
       if(root == p || root = q) return root //search code
       //do in order traversal
       left=lca(root.left,p,q)
       right=lca(root.left,p,q)
       if(left != null && reight !=null) return root
       else (left != null ? left : right
     */

    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.
        if(root == null) return root;
        if(root.data == v1 || root.data == v2) return root;
        Node left=lca(root.left,v1,v2);
        Node right=lca(root.right,v1,v2);
        if(left != null && right != null) return root;
        else return left != null ? left:right;

    }

    //dfs search on binary tree
    //bfs is level order traversal
    public void DFS(Node root) {
        Stack<Node> s = new Stack<Node>();
        s.add(root);
        while (s.isEmpty() == false) {
            Node x = s.pop();
            if(x.right!=null) s.add(x.right);
            if(x.left!=null) s.add(x.left);
            System.out.print(" " + x.data);
        }
    }

    /*
    huffman coding -- compression technique
    message -> bccabb,,,
    length(message) = 20
      acivalue  -- 8 bit(asci value are 8 bits)
    A 65         0100001
    so total bits  8x20 = 160 bits

    can we use less bits ? let use methods below
     fixed size
     charachter  count/frequencu  code
     A           3/20             000
     B           5/20             001
     ..........

    I will use my based code
    so now 20x3 = 60 bits
    now I have encoded with my own code
    so to decode we need to send the above table
    so from above
     5x8           5x3    message
   charchter      codes      60 bit
   equals 115 bits

    Huffmean encoding
    Use variable size
    Give small size for repeating words
    it follows optimal merge pattern
    arrange alphabets in increasing order of ther count

    2   3 4  5 6
    E  A  D  B C

    now merge 2 smaller and make one code

                  20
               9
           5          11
         2   3   4   5  6

         now in the tree mark left side eges as 0 and right as 1


                   20
             o        \
               9
           0     1
           5            11
         0   1          0   1
         2   3    4    5    6

         char   count code
         A      3       001   3x3 =9
         B              10    5x2=10

         size of message is 45 bits
    */


}
