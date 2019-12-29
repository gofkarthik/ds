package ds_ref;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/copy-list-with-random-pointer/

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}

public class CopyListRandomPointer {

    //Solution with O(N) and Space O(N)

    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Map<Node,Node> clone=new HashMap<>();
        Node cur=head;
        while(cur != null){
            clone.put(cur,new Node(cur.val,null,null));
            cur=cur.next;
        }
        cur=head;
        while(cur != null){
            clone.get(cur).next = clone.get(cur.next);
            clone.get(cur).random=clone.get(cur.random);
            cur=cur.next;
        }
        return clone.get(head);
    }
}

