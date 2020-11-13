// Write a method to merge k Sorted Linked Lists. Why would you ever want to do that? Well, if you're dealing with a list of over 200 Million Integers that needs to be sorted, an efficient approach might involve splitting up the massive list into k smaller lists, sorting each list in memory and then combining the sorted lists to re-create the original list, albeit sorted.
//
// Example:
// Inputs Lists :
// LinkedList1: 1->2->13->20
// LinkedList2: 1->20->35->40
// LinkedList3: 5->6->12->18
//
// Output List:
// LinkedList: 1->1->2->5->6->12->13->18->20->20->35->40
//
// Note:
// mergeKLists takes in an ArrayList of ListNodes - lists, where each ListNode is the head of a custom Linked List structure.



// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public ListNode mergeKLists(ArrayList<ListNode> lists) {
    PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((o1, o2) -> o1.data - o2.data);
    for(ListNode n : lists){
        if(n != null){
            queue.offer(n);
        }
    }
    ListNode dummy = new ListNode(-1);
    ListNode curr = dummy;
    while(!queue.isEmpty()){
        ListNode x = queue.remove();
        if(x.next!=null){
            queue.offer(x.next);
        }
        curr.next = x;
        curr = curr.next;
    }
    return dummy.next;
}
// Time : O(nkLogk)
// Space : O(k)
