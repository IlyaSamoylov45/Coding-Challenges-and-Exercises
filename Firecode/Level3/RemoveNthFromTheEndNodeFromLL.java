/*
Given a singly-linked list, remove its Nth from the end node.

Examples:
1->2->3->4->5, n=3 ==> 1->2->4->5
1->2->3->4->5, n=1 ==> 1->2->3->4
1->2->3->4->5, n=5 ==> 2->3->4->5
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ListNode removeNthFromEnd(ListNode head, int n) {
    int count = 0;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode curr = head;
    while(curr!= null){
        count++;
        curr = curr.next;
    }
    curr = dummy;
    if(count < n){
        return head;
    }
    while(count-n > 0 && curr.next != null){
        curr = curr.next;
        count--;
    }
    if(curr.next == null){
        return head;
    }
    curr.next = curr.next.next;
    return dummy.next;

}
