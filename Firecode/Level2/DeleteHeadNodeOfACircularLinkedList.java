/*
Given a circular linked list, implement a method to delete its head node. Return the list's new head node.

*x = indicates head node
1->2->3->4->*1 ==> 2->3->4->*2
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ListNode deleteAtHead(ListNode head) {
    if(head == null || head.next == head){
        return null;
    }
    ListNode curr = head;
    while(curr.next != head){
        curr = curr.next;
    }
    curr.next = head.next;
    return curr.next;
}
