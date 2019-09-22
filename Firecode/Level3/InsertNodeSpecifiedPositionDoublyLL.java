/*
In doubly linked list, implement a method to insert a node at specified position and return the list's head. Do nothing if insertion position is outside the bounds of the list.

Examples:
insertAtPos(1<=>2<=>3,4,2) ==> 1<=>4<=>2<=>3
insertAtPos(1,4,3) ==> 1
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public DoublyLinkedNode insertAtPos(DoublyLinkedNode head, int data, int pos) {
    DoublyLinkedNode dummy = new DoublyLinkedNode(0);
    DoublyLinkedNode curr = dummy;
    dummy.next = head;
    DoublyLinkedNode ins = new DoublyLinkedNode(data);
    while(curr.next != null && --pos > 0){
        curr = curr.next;
    }
    pos--;
    if(pos > 0){
        return dummy.next;
    }
    if(curr.next == null){
        curr.next = ins;
        ins.prev = curr;
    }else{
        ins.next = curr.next;
        curr.next = ins;
        ins.prev = curr;
        ins.next.prev = ins;
    }
    dummy.next.prev = null;
    return dummy.next;
}
