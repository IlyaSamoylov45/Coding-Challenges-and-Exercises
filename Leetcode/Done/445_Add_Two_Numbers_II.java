// You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//
//
// Example 1:
//
//
// Input: l1 = [7,2,4,3], l2 = [5,6,4]
// Output: [7,8,0,7]
// Example 2:
//
// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [8,0,7]
// Example 3:
//
// Input: l1 = [0], l2 = [0]
// Output: [0]
//
//
// Constraints:
//
// The number of nodes in each linked list is in the range [1, 100].
// 0 <= Node.val <= 9
// It is guaranteed that the list represents a number that does not have leading zeros.
//
//
// Follow up: Could you solve it without reversing the input lists?








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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode head = null;
        int carry = 0;
        while(l1 != null || l2 != null){
            carry += l1 == null ? 0 : l1.val;
            carry += l2 == null ? 0 : l2.val;

            ListNode curr = new ListNode(carry%10);
            carry /= 10;
            curr.next = head;
            head = curr;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

        }

        if(carry != 0){
            ListNode curr = new ListNode(carry);
            curr.next = head;
            head = curr;
        }
        return head;



    }

    private ListNode reverse(ListNode root){
        if(root == null){
            return root;
        }

        ListNode prev = null;
        ListNode curr = root;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;


        }

        return prev;
    }

}
// Time : O(N + M)
// Space : O(max(N + M))








class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1 = getListLength(l1);
        int n2 = getListLength(l2);

        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode head = new ListNode();
        ListNode curr = head;

        while(n1 > 0 && n2 > 0){
            int val = 0;
            if(n1 >= n2){
                val += curr1.val;
                curr1 = curr1.next;
                --n1;
            }
            if(n1 < n2){
                val += curr2.val;
                curr2 = curr2.next;
                --n2;
            }

            curr.next = new ListNode(val);
            curr = curr.next;
        }

        int carry = flatten(head.next);
        if(carry != 0){
            ListNode temp = new ListNode(carry);
            curr = head.next;
            temp.next = curr;
            head.next = temp;
        }
        return head.next;

    }

    private int getListLength(ListNode root){
        int count = 0;
        ListNode curr = root;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        return count;
    }

    private int flatten(ListNode root){
        if(root == null){
            return 0;
        }
        int carry = flatten(root.next) + root.val;
        root.val = carry%10;
        return carry/10;

    }

}
// Time : O(N + M)
// Space : O(max(N + M))
