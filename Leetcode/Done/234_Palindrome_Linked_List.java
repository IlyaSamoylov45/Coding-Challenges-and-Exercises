// Given a singly linked list, determine if it is a palindrome.
//
// Example 1:
//
// Input: 1->2
// Output: false
// Example 2:
//
// Input: 1->2->2->1
// Output: true
// Follow up:
// Could you do it in O(n) time and O(1) space?





class Solution {
    public boolean isPalindrome(ListNode head) {
        int count = 0;
        for(ListNode curr = head; curr != null; curr = curr.next){
            count++;
        }
        int half = count/2;
        ListNode curr = head;
        while(half-- > 0){
            curr = curr.next;
        }
        ListNode reversed = reverse(curr);

        while(head != null && reversed!=null){
            if(head.val != reversed.val){
                return false;
            }
            head = head.next;
            reversed = reversed.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
// Time : O(N)
// Space : O(1)
