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
    public void reorderList(ListNode head) {

        if(head==null || head.next==null) return;
        //Step 1 
        //Find mid

        ListNode slow = head, fast= head;

        while(fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        

        //Step 2 
        //reverse Second half

        ListNode cur = slow.next;
        slow.next= null;

        ListNode prev = null, back = null;

        while(cur!=null){
            prev = cur;
            cur = cur.next;
            prev.next = back;
            back = prev;
        }

        //Step 3 merging
        //second half start is prev

        ListNode first = head, second = prev;
        ListNode temp1 =null, temp2= null;

        while(second !=null){
            temp1 = first.next;
            temp2 = second.next;

            first.next = second;
            second.next = temp1;
            

            first = temp1;
            second = temp2;
        }



    }
}
