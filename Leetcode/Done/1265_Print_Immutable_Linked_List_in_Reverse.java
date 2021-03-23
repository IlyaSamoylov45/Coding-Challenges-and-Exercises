// You are given an immutable linked list, print out all values of each node in reverse with the help of the following interface:
//
// ImmutableListNode: An interface of immutable linked list, you are given the head of the list.
// You need to use the following functions to access the linked list (you can't access the ImmutableListNode directly):
//
// ImmutableListNode.printValue(): Print value of the current node.
// ImmutableListNode.getNext(): Return the next node.
// The input is only given to initialize the linked list internally. You must solve this problem without modifying the linked list. In other words, you must operate the linked list using only the mentioned APIs.
//
//
//
// Example 1:
//
// Input: head = [1,2,3,4]
// Output: [4,3,2,1]
// Example 2:
//
// Input: head = [0,-4,-1,3,-5]
// Output: [-5,3,-1,-4,0]
// Example 3:
//
// Input: head = [-2,0,6,4,4,-6]
// Output: [-6,4,4,6,0,-2]
//
//
// Constraints:
//
// The length of the linked list is between [1, 1000].
// The value of each node in the linked list is between [-1000, 1000].
//
//
// Follow up:
//
// Could you solve this problem in:
//
// Constant space complexity?
// Linear time complexity and less than linear space complexity?







/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation.
 * interface ImmutableListNode {
 *     public void printValue(); // print the value of this node.
 *     public ImmutableListNode getNext(); // return the next node.
 * };
 */

class Solution {
    public void printLinkedListInReverse(ImmutableListNode head) {
        if(head == null){
            return;
        }
        printLinkedListInReverse(head.getNext());
        head.printValue();
    }
}
// Time : O(N)
// Space : O(N)





class Solution {
    public void printLinkedListInReverse(ImmutableListNode head) {
        ImmutableListNode start = head;
        ImmutableListNode end = null;

        while (start != end) {
            ImmutableListNode cur = start;
            while (cur.getNext() != end) {
                cur = cur.getNext();
            }
            cur.printValue();
            end = cur;
        }
    }
}
// Time : O(N^2)
// Space : O(1)






class Solution {
    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null) {
            return;
        }

        printLinkedListInReverse(head, null);
    }

    private void printLinkedListInReverse(ImmutableListNode start, ImmutableListNode end){
        if (start == null || start == end) {
            return;
        } else if (start.getNext() == end) {
            start.printValue();
            return;
        }

        ImmutableListNode slow = start;
        ImmutableListNode fast = start;
        while(fast != end && fast.getNext() != end) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        printLinkedListInReverse(slow, end);
        printLinkedListInReverse(start, slow);


    }
}
// Time : O(N log N)
// Space : O(log N)
