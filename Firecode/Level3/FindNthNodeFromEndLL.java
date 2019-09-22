/*
Given a singly-linked list, implement the method that returns Nth node from the end of the list without using extra memory (constant space complexity).
Examples:
1->2->3->4->5->6, n=2 ==> 5
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ListNode findNthNodeFromEnd(ListNode head, int n) {
    if(head == null){
        return null;
    }

    int count = 0;
    ListNode curr = head;
    while(curr!=null){
        count++;
        curr = curr.next;
    }
    if(count < n){
        return null;
    }
    curr = head;
    while(curr != null && count-n > 0){
        curr = curr.next;
        count--;
    }
    return curr;
}
