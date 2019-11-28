package ds.amazon;

/**
 * https://leetcode.com/problems/add-two-numbers/
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 *Time complexity : O(max⁡(m,n))O(\max(m, n))O(max(m,n)). Assume that mmm and nnn represents the length of l1l1l1 and l2l2l2 respectively, the algorithm above iterates at most max⁡(m,n)\max(m, n)max(m,n) times.
 * Space complexity : O(max⁡(m,n))O(\max(m, n))O(max(m,n)). The length of the new list is at most max⁡(m,n)+1\max(m,n) + 1max(m,n)+1.
 *
 */

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1=l1;
        ListNode p2=l2;
        ListNode resultNode=new ListNode(0);
        ListNode cur=resultNode;
        int carry=0;
        while(p1 != null || p2!= null){
            int p1Val = p1 !=null ? p1.val : 0;
            int p2Val = p2 !=null ? p2.val : 0;
            int sum = carry+p1Val+p2Val;
            carry = sum/10;
            cur.next=new ListNode(sum%10);
            cur=cur.next;
            if(p1 != null)p1=p1.next;
            if(p2 != null) p2=p2.next;
        }
        if(carry > 0){
            cur.next = new ListNode(carry);
        }
        return resultNode.next;
    }
}
