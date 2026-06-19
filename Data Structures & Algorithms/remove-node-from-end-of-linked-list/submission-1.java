/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode fast = dummy, slow= dummy;
        dummy.next = head;

        for(int i=0; i<n; i++){
            System.out.println("INSIDE -1");
            fast = fast.next;
        }

        while(fast.next != null){
            System.out.println("INSIDE -2");
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println(slow.val);
        System.out.println(fast.val);

        slow.next = slow.next.next;

        return dummy.next;
    }
}
