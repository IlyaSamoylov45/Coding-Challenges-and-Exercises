/*
Given a circular-linked list, write a function to delete its tail node and return the modified list's head.

*x = indicates head node
1->2->3->4->*1 ==> 1->2->3->*1
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ListNode deleteAtTail(ListNode head) {
    if(head == null || head.next == head){
        return null;
    }
    ListNode curr = head.next;
    while(curr.next.next != head){
        curr = curr.next;
    }
    curr.next = curr.next.next;
    return curr.next;
}
