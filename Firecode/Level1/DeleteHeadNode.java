/*
Given a singly-linked list, write a method to delete the first node of the list and return the new head.

Example:
LinkedList: 1->2->3 , Head = 1

deleteAtHead(Head) ==> 2->3

*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ListNode deleteAtHead(ListNode head) {
    if(head == null){
        return head;
    }
    return head.next;

}
