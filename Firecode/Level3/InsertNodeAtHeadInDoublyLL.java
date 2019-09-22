/*
Given a doubly linked list, implement a method to insert a node at its head. Return the head of the list.

Examples:
Insert 1 ==> 1
Insert 2 ==> 2<=>1
Insert 3 ==> 3<=>2<=>1
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public DoublyLinkedNode insertAtHead(DoublyLinkedNode head, int data) {
    DoublyLinkedNode curr = new DoublyLinkedNode(data);
    if(head == null){
        return curr;
    }
    curr.next = head;
    curr.next.prev = curr;
    return curr;
}
