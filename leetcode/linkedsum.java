/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	//whether add one in higher bit or not
    	int up = 0;
    	int sum = 0;
    	int tempt;
    	//output result,but remember there's no head reference, so we need a 'dummy' or 'sentinel' one
    	// to return the result
    	ListNode result = new ListNode(0);
    	//digit operation
    	ListNode temp = result;
    	ListNode a = l1;
    	ListNode b = l2;

    	while (a != null || b != null) {
    	if (a != null) {
    		sum += a.val;
    		a = a.next;
    	}
    	if (b != null) {
    		sum += b.val;
    		b = b.next
    	}
    	tempt = up + sum % 10;
    	temp.next = new ListNode(tempt % 10);
    	temp = temp.next;
    	up = (tempt) / 10;
    	sum = 0;
    	}
    	// attention! when there's no appending digits in both a and b, you have to check that whether 
    	//there is a one !
    	if (up == 1) {
    		temp.next = new ListNode(1);
    		temp = temp.next;
    	}
    	return result.next;
    }
}