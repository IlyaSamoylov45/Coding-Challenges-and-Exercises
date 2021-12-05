// Given the head of a linked list, rotate the list to the right by k places.
//
//
//
// Example 1:
//
//
// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]
// Example 2:
//
//
// Input: head = [0,1,2], k = 4
// Output: [2,0,1]
//
//
// Constraints:
//
// The number of nodes in the list is in the range [0, 500].
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 109






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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k <= 0){
            return head;
        }

        int n = 0;
        ListNode current = head;
        while(current != null){
            n++;
            current = current.next;
        }

        n = (n - (k%n));
        current = head;

        while(--n > 0){
            current = current.next;
        }
        ListNode dummy = new ListNode();
        ListNode rotate = current.next;
        dummy.next = rotate;
        current.next = null;

        if(rotate == null){
            return head;
        }

        while(rotate.next != null){
            rotate = rotate.next;
        }

        rotate.next = head;
        return dummy.next;


    }
}
// Time : O(N)
// Space : O(1)







class Solution {
    public ListNode rotateRight(ListNode head, int k) {
      if(head == null || head.next == null || k <= 0){
          return head;
      }

      int size = 1;
	    ListNode fast = head;
	    ListNode slow = head;

        while(fast.next != null){
            size++;
            fast = fast.next;
        }

        for(int i=size-k%size;i>1;i--){
		        slow = slow.next;
        }

        fast.next = head;
	      head = slow.next;
	      slow.next = null;
        return head;

    }
}
// Time : O(N)
// Space : O(1)
