/*
Given the head pointer of a singly linked list, implement a method to reverse the list and return the new head.
Example:
1->2->3 ==> 3->2->1
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ListNode reverseList(ListNode head) {
    return reverseListSupport(head, null);
}

public ListNode reverseListSupport(ListNode head, ListNode newHead){
    if(head == null){
        return newHead;
    }
    ListNode next = head.next;
    head.next = newHead;
    return reverseListSupport(next, head);
}
