// Remove all elements from a linked list of integers that have value val.
//
// Example:
//
// Input:  1->2->6->3->4->5->6, val = 6
// Output: 1->2->3->4->5



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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        while(curr.next != null){
            if(curr.next.val == val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
// Time : O(N)
// Space : O(1)



class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
// Time : O(N)
// Space : O(N)
