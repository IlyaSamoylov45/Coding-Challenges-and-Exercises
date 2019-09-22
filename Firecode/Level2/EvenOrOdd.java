/*
Given a singly-linked list, check whether its length is even or odd in a single pass. An Empty list has 0 nodes which makes the number of nodes in it even.

Examples:
1->2->3->4 == true 1->2->3->4->5 == false
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public Boolean isListEven(ListNode head) {
    int count = 0;
    for(ListNode curr = head; curr != null; curr = curr.next){
        count++;
    }
    return count % 2 == 0 ? true : false;
}
