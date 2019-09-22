/*
Given a Singly-Linked List, write a method - findMiddleNode that finds and returns the middle node of the list in a single pass.

Examples:
1 ==> 1
1->2 ==> 1
1->2->3->4 ==> 2
1->2->3->4->5 ==> 3
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ListNode findMiddleNode(ListNode head) {
    if(head == null){
        return null;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
