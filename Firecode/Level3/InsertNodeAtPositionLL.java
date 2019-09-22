/*
Given a singly-linked list, implement a method to insert a node at a specific position and return the head of the list.

If the given position is greater than the list size, simply insert the node at the end.

Examples:
Input List: 1->2->3
insertAtPosition(1,4,2) ==> 1->4->2->3
*position=2 means the 2nd node in the list
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ListNode insertAtPosition(ListNode head, int data, int pos) {
    ListNode ins = new ListNode(data);
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode curr = dummy;
    while(curr.next!=null && pos-1 > 0){
        curr = curr.next;
        pos--;
    }
    if(curr.next == null){
        curr.next = ins;
    }else{
        ins.next = curr.next;
        curr.next = ins;
    }
    return dummy.next;
}
