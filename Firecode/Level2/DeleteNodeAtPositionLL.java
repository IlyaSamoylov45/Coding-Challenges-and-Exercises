/*
Given a singly-linked list, implement a method to delete the node at a given position (starting from 1 as the head position) and return the head of the list. Do nothing if the input position is out of range.

Examples:
LinkedList: 1->2->3->4 , Head = 1
deleteAtMiddle(Head,3) ==> 1->2->4

*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ListNode deleteAtMiddle(ListNode head, int position) {
    if(head == null){
        return null;
    }
    if (position == 1){
        return head.next;
    }
    ListNode prev = head;
    while(position - 2 > 0 && prev != null){
        prev = prev.next;
        position--;
    }
    if(prev != null){
        prev.next = prev.next.next;
    }
    return head;



}
