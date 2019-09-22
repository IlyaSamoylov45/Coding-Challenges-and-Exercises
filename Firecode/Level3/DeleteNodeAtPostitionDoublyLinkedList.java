/*
Given a doubly-linked list, write a method to delete the node at a given position (starting from 1 as the head position) and return the modified list's head. Do nothing if the input position is out of range.

Examples:
1<=>2<=>3<=>4, pos=6 ==> 1<=>2<=>3<=>4
1<=>2<=>3<=>4, pos=3 ==> 1<=>2<=>4
*/
public DoublyLinkedNode deleteAtPos(DoublyLinkedNode head, int pos) {
    if (head == null){
        return null;
    }
    DoublyLinkedNode dummy = new DoublyLinkedNode(0);
    dummy.next = head;
    head.prev = dummy;
    DoublyLinkedNode curr = head;

    while(curr != null && pos-1 > 0){
        curr = curr.next;
        pos--;
    }
    if(curr == null){
        return head;
    }
    curr.prev.next = curr.next;
    curr.prev = null;
    return dummy.next;

}
