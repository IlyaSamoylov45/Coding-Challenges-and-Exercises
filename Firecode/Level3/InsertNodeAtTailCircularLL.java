/*
Given a circular linked list, write a method to insert a node at its tail. Return the list's head.

Examples:

*x = indicates head node
Insert 1 ==> *1
Insert 2 ==> 1->2->*1
Insert 3 ==> 1->2->3->*1
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ListNode insertAtTail(ListNode head, int data) {
    ListNode ins = new ListNode(data);
    if(head == null){
        ins.next = ins;
        return ins;
    }
    ListNode curr = head.next;
    while(curr.next != head){
        curr = curr.next;
    }
    ins.next = curr.next;
    curr.next = ins;
    return ins.next;
}
