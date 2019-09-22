/*
Write a method to insert a node at the end of a singly-linked list. Return the head of the modified list.

Examples:

LinkedList: 1->2 , Head = 1

InsertAtTail(Head,1) ==> 1->2->1
InsertAtTail(Head,2) ==> 1->2->2
InsertAtTail(Head,3) ==> 1->2->3
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ListNode insertAtTail(ListNode head, int data) {
    ListNode temp = new ListNode(data);
    ListNode curr = head;
    if(curr == null){
        return temp;
    }

    while(curr.next!=null){
        curr = curr.next;
    }
    curr.next = temp;

    return head;


}
