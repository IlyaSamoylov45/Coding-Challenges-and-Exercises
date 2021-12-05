// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
//
// Merge all the linked-lists into one sorted linked-list and return it.
//
//
//
// Example 1:
//
// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted list:
// 1->1->2->3->4->4->5->6
// Example 2:
//
// Input: lists = []
// Output: []
// Example 3:
//
// Input: lists = [[]]
// Output: []
//
//
// Constraints:
//
// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] is sorted in ascending order.
// The sum of lists[i].length won't exceed 10^4.







/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pQueue = new PriorityQueue<>((l1, l2) -> Integer.compare(l1.val, l2.val));
        for(ListNode node : lists){
            if(node != null){
                pQueue.offer(node);
            }
        }
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(!pQueue.isEmpty()){
            ListNode temp =  pQueue.remove();
                curr.next = temp;
                curr = curr.next;
                temp= temp.next;
            if(temp != null){
                pQueue.offer(temp);
            }
        }

        return head.next;
    }
}
// Time : Time complexity : O(Nlog k) where k is the number of linked lists.
// Space : O(n) Creating a new linked list costs O(n) space.
//         O(k) The code above present applies in-place method which cost O(1) space.
//              And the priority queue costs O(k) space.







class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }

        int interval = 1;
        while(interval < lists.length){
            for(int i = 0; i + interval < lists.length; i+=(interval*2)){
                lists[i] = merge2Lists(lists[i], lists[i+interval]);
            }
            interval*=2;
        }
        return lists[0];

    }

    private ListNode merge2Lists(ListNode l1, ListNode l2){

        ListNode head = new ListNode(0);
        ListNode curr = head;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if(l2 != null){
            curr.next = l2;
        }
        if(l1 != null){
            curr.next = l1;
        }
        return head.next;
    }
}
// Time complexity : O(NLogK) where k is the number of linked lists.
//    We can merge two sorted linked list in O(n) time where n is the total number of nodes in two lists.
// Space complexity : O(1)
// We can merge two sorted linked lists in O(1) space.
