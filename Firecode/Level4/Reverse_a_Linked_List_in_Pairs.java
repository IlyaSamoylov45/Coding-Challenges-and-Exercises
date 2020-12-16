// Given a singly-linked list, reverse the list in pairs.
// Example:
// Given 1->2->3->4,
// reverseInPairs(1) ==> 2->1->4->3


public ListNode reverseInPairs(ListNode head) {
    ListNode curr = head;
    while(curr != null && curr.next != null){
        int temp = curr.data;
        curr.data = curr.next.data;
        curr.next.data = temp;
        curr = curr.next.next;
    }
    return head;
}
// Time : O(N)
// Space : O(1)




public ListNode reverseInPairs(ListNode head) {
   if(head == null || head.next == null){
       return head;
   }
   ListNode next = head.next;
   ListNode nextNext = head.next.next;
   next.next = head;
   head.next = nextNext == null ? null : reverseInPairs(nextNext);
   return next;
}
// Time : O(N)
// Space : O(N)
