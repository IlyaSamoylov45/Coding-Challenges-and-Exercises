/*
Given a singly-linked list, write a method to delete its last node and return the head.

Example:
1->2->3->4 ==> 1->2->3
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ListNode deleteAtTail(ListNode head) {
    if(head == null || head.next == null){
        return null;
    }
    ListNode prev = head;
    ListNode curr = head.next;

    while(curr.next != null){
        prev = curr;
        curr = curr.next;
    }
    prev.next = null;
    return head;

}
