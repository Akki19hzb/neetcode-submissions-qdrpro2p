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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode lfHead = null, lfCurr= null;

        if(list1 == null) return list2;
        if(list2 ==null) return list1;
        int count =0;
        while(list1!=null && list2!=null){
            count++;
            ListNode temp;
            if(list1.val <= list2.val){
                temp = new ListNode(list1.val);
                list1 = list1.next;
                System.out.println("A:"+count);
            }else{
                temp = new ListNode(list2.val);
                list2 = list2.next;
                System.out.println("B:"+count);
                
            }
            if(lfHead==null){
                lfHead = temp;
                System.out.println("Inside HEAD: "+count);
                
            }else{
                lfCurr.next = temp;
            }

            lfCurr = temp;

        }

        while(list1!=null){
            ListNode temp = new ListNode(list1.val);
            lfCurr.next = temp;
            lfCurr = temp;
            list1 = list1.next;
        }

           while(list2!=null){
            ListNode temp = new ListNode(list2.val);
            lfCurr.next = temp;
            lfCurr = temp;
            list2 = list2.next;
        }
        return lfHead;
    }
}