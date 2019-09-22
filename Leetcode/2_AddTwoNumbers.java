/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/


/**
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode(int x) { val = x; }
* }
*/

class Solution {
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       if(l1 == null){
           return l2;
       }
       if(l2 == null){
           return l1;
       }
       ListNode curr1 = l1;
       ListNode curr2 = l2;
       ListNode dummy = new ListNode(0);
       ListNode ret = dummy;
       int carry = 0;

       while(curr1 != null || curr2 != null){
           int x = 0;
           if(curr1 != null){
               x += curr1.val;
               curr1 = curr1.next;
           }
           if(curr2 != null){
               x += curr2.val;
               curr2 = curr2.next;
           }
           x += carry;
           carry = x/10;

           ret.next = new ListNode(x%10);
           ret = ret.next;

       }
       if (carry > 0) {
           ret.next = new ListNode(carry);
       }
       return dummy.next;
   }
}
