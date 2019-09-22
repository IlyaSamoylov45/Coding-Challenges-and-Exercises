/*
Given a singly-linked list, remove duplicates in the list and return head of the list. Target a worst case space complexity of O(n).
Examples:
1->2->2->4->3->1 ==> 1->2->4->3
1 ==> 1
"" ==> ""
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ListNode removeDuplicates(ListNode head) {
    if(head == null){
        return head;
    }
    Set<Integer> vals = new HashSet<>();
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode curr = dummy.next;
    vals.add(curr.data);
    while(curr != null && curr.next != null){
        if(vals.contains(curr.next.data)){
            curr.next = curr.next.next;
        }else{
            curr = curr.next;
            vals.add(curr.data);
        }
    }
    return dummy.next;
}
