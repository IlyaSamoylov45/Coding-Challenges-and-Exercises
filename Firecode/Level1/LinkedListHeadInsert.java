/*
Write a method to insert a node at the front of a singly-linked list and return the head of the modified list.
Examples:

LinkedList: 1->2 , Head = 1

InsertAtHead(Head,1) ==> 1->1->2
InsertAtHead(Head,2) ==> 2->1->2
InsertAtHead(Head,3) ==> 3->1->2
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ListNode insertAtHead(ListNode head, int data) {
    ListNode curr = new ListNode(data);
    if(head == null){
        return curr;
    }
    curr.next = head;
    return curr;
}
