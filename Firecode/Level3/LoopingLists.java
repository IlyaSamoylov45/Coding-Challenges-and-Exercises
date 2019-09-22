/*
Given a singly-linked list, implement a method to check if the list has cycles. The space complexity can be O(n). If there is a cycle, return true otherwise return false. Empty lists should be considered non-cyclic.

Examples:
1->2->3->4->1 ==> true
1->2->3->4 ==> false
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public Boolean isCyclic(ListNode head) {
    if(head == null){
        return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while(fast != null && fast.next != null){
        if(slow == fast){
            return true;
        }
        slow = slow.next;
        fast = fast.next.next;
    }
    return false;
}
