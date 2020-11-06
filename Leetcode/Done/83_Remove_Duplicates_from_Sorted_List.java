// Given a sorted linked list, delete all duplicates such that each element appear only once.
//
// Example 1:
//
// Input: 1->1->2
// Output: 1->2
// Example 2:
//
// Input: 1->1->2->3->3
// Output: 1->2->3




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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) {
            head.next = head.next.next;
        }
        return head;
    }
}
// Time : O(N)
// Space : O(N)






class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        while(curr != null){
            if(prev.val == curr.val){
                prev.next = curr.next;
            }else{
                prev=prev.next;
            }
            curr = curr.next;
        }
        return head;
    }
}
// Time : O(N)
// Space : O(1)
