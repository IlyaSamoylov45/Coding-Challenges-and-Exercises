// Given a singly-linked list, implement the method that returns Nth node from the end of the list without using extra memory (constant space complexity).

// Examples:
// 1->2->3->4->5->6, n=2 ==> 5

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ListNode findNthNodeFromEnd(ListNode head, int n) {
    if(n < 0){
        return null;
    }
    for(ListNode curr = head; curr != null; curr = curr.next){
        n--;
    }
    if(n > 0){
        return null;
    }
    ListNode curr = head;
    while(n++ < 0){
        curr = curr.next;
    }
    return curr;
}
