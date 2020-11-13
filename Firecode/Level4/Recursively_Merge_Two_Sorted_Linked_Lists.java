// Given two sorted singly-linked lists, recursively merge them into a new sorted singly-linked list in O(n) runtime. Do not allocate any extra space!
// You can assume that both the given lists are already sorted in ascending order.
// Examples:
// 1->2->3->4 + 5->6->7->8 ==> 1->2->3->4->5->6->7->8
//
// 1->2->3->4 + 1->2->7->9 ==> 1->1->2->2->3->4->7->9
//
// 1->2->3->4 + null ==> 1->2->3->4


// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
    if(l1 == null){
        return l2;
    }
    if(l2 == null){
        return l1;
    }
    if(l1.data > l2.data){
        l2.next = mergeTwoSortedList(l1, l2.next);
        return l2;
    }
    l1.next = mergeTwoSortedList(l1.next, l2);
    return l1;


}
// Time : O(N + M)
// Space : O(N + M)
