// Check if a given linked list has cycles. Try to achieve O(n) runtime with a space complexity of O(1). If there is a cycle, return true otherwise return false. Consider empty lists as non cyclic.
// Examples:
// 1->2->3->4->1 ==> true
// 1->2->3->4 ==> false



// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public Boolean isCyclic(ListNode head) {
    if(head == null){
        return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while(slow != fast && fast != null && fast.next != null){
        slow = slow.next;
        fast=fast.next.next;
    }
    return fast == slow;
}
// Time : O(N)
// Space : O(1)
