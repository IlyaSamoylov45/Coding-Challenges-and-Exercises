// Given two integers represented as linked-lists, find their sum and return it in the form of linked list.
//
// Note: You can assume that the input integers are non negative and the digits stored in the linked lists are in the reverse order. Take a look at the examples to understand the format.
//
// Example:
// Input 1: 1->2->3
// Input 2: 1->2->3
// Output : 2->4->6
//
// Input 1: 9->9
// Input 2: 9->8
// Output : 8->8->1



// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static ListNode sumTwoLinkedLists(ListNode input1, ListNode input2) {
    ListNode head1 = input1;
    ListNode head2 = input2;
    ListNode dummy = new ListNode(-1);
    ListNode curr = dummy;
    int carry = 0;
    while(head1 != null && head2 != null){
        if(head1 != null){
            carry += head1.data;
            head1=head1.next;
        }
        if(head2 != null){
            carry += head2.data;
            head2 = head2.next;
        }
        curr.next = new ListNode(carry%10);
        curr = curr.next;
        carry/=10;

    }
    if(carry != 0){
        curr.next = new ListNode(carry);
    }
    return dummy.next;
}
