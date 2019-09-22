/*
Given a singly-linked list, write a method isListPalindrome to determine if the list is a palindrome. A palindrome is a sequence that reads the same backward as forward.
Examples:

1->2->3->2->1 ==> true

1->2->2->3 ==> false

1 ==> true

null ==> true
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public Boolean isListPalindrome(ListNode head) {
    if(head == null){
        return true;
    }
    Stack<ListNode> vals = new Stack<>();
    ListNode curr = head;
    while(curr != null){
        vals.push(curr);
        curr = curr.next;
    }
    curr = head;
    while(!vals.isEmpty()){
        if(curr.data != vals.pop().data){
            return false;
        }
        curr = curr.next;
    }
    return true;
}
