package ds.algorithms.linkedlist;

import java.util.ArrayList;
import java.util.List;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

public class LinkedListHackerRank {

    //print a singly linked list
    static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode tempNode = head;
        while (tempNode != null) {
            System.out.println(tempNode.data);
            tempNode = tempNode.next;
        }

    }

    //insert node at head

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {

        SinglyLinkedListNode currentNode= llist;

        if(currentNode == null){
            currentNode=new SinglyLinkedListNode(data);
        }else{
            SinglyLinkedListNode node=new SinglyLinkedListNode(data);
            node.next = currentNode;
            currentNode = node;
        }
        return currentNode;
    }

    //insert node at tail
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        if(head == null){
            head = new SinglyLinkedListNode(data);
        }
        else{
            SinglyLinkedListNode tmp=head;
            while(tmp.next != null){
                tmp=tmp.next;
            }
            SinglyLinkedListNode node = new SinglyLinkedListNode(data);
            tmp.next=node;
        }
        return head;
    }

    //insert at specific position
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        if(head == null){
            head = node;
        }
        else{
            SinglyLinkedListNode current = head;
            for(int i=1;i< position ; i++){
                current = current.next;
                if(current.next == null){
                    break;
                }
            }
            node.next = current.next;
            current.next = node;
        }
        return head;
    }

    //delete node at position
    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        if(position ==0){
            if(head.next == null){
                head = null;
            }else{
                head=head.next;
            }
        }else{
            SinglyLinkedListNode tmp = head;
            for(int i=1;i<position;i++){
                tmp=tmp.next;
            }
            tmp.next = tmp.next.next;
        }
        return head;
    }

    //print a linkedlist reverse
    static void reversePrint(SinglyLinkedListNode head) {
        if(head == null) return;
        reversePrint(head.next);
        System.out.println(head.data);

    }

    //reverse a singly list
    // 1->2->3->4
    // start with next prev as null ,current = 1->2
    // next -> 2->3->4
    // current 1-> (null) (prev).
    //prev = current
    //current as next
    // return prev
    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {

        SinglyLinkedListNode current = head;
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev=current;
            current=next;
        }
        head = prev;
        return head;
    }

    //mug it up
    //reverse using recursive
    // A simple and tail recursive function to reverse
    // a linked list.  prev is passed as NULL initially.

    SinglyLinkedListNode head;
    SinglyLinkedListNode reverseUtil(SinglyLinkedListNode curr, SinglyLinkedListNode prev)
    {

        /* If last node mark it head*/
        if (curr.next == null) {
            head = curr;

            /* Update next to prev node */
            curr.next = prev;

            return head;
        }
        /* Save curr->next node for recursive call */
        SinglyLinkedListNode next1 = curr.next;
        /* and update next ..*/
        curr.next = prev;
        reverseUtil(next1, curr);
        return head;
    }

    void are(){
        List<List<Integer>> data=new ArrayList<>();
        for (List<Integer> datum : data) {

        }
    }
    //compare linked list identical
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode curr1=head1;
        SinglyLinkedListNode curr2=head2;
        while(curr1 != null && curr2 != null){
            if(curr1.data != curr2.data){
                return false;
            }
            curr1=curr1.next;
            curr2=curr2.next;
        }
        return (curr1 == null && curr2 == null);
    }

    //merge 2 sorted list
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode head=new SinglyLinkedListNode(0);
        SinglyLinkedListNode merge=head;
        SinglyLinkedListNode cur1=head1;
        SinglyLinkedListNode cur2=head2;
        while(cur1 != null && cur2 != null){
            if(cur1.data < cur2.data){
                merge.next = cur1;
                cur1 = cur1.next;
            }else{
                merge.next = cur2;
                cur2 = cur2.next;
            }
            merge=merge.next;
        }

        if(cur1 != null){
            merge.next=cur1;
        }
        if(cur2 != null){
            merge.next = cur2;
        }
        return head.next;
    }
}
