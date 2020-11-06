// Given a linked list, swap every two adjacent nodes and return its head.
//
// You may not modify the values in the list's nodes. Only nodes itself may be changed.
//
//
//
// Example 1:
//
//
// Input: head = [1,2,3,4]
// Output: [2,1,4,3]
// Example 2:
//
// Input: head = []
// Output: []
// Example 3:
//
// Input: head = [1]
// Output: [1]
//
//
// Constraints:
//
// The number of nodes in the list is in the range [0, 100].
// 0 <= Node.val <= 100




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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode dummy = new ListNode(0);
        ListNode clean = dummy;
        dummy.next = curr;
        while(curr != null){
            clean.next = curr;
            prev.next = curr.next;
            curr.next = prev;
            clean = prev;
            prev = prev.next;
            if(prev == null || prev.next == null){
                break;
            }
            curr = prev.next;
        }
        return dummy.next;
    }
}
// Time : O(N)
// Space : O(1)




class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = swapPairs(head.next.next);
        ListNode temp = head.next;
        head.next.next = head;
        head.next = curr;
        return temp;
    }
}
// Time : O(N)
// Space : O(N)
