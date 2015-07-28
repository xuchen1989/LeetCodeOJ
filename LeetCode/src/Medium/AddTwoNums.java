package Medium;

/**
 * 
 * @author xuchen2
 *You are given two linked lists representing two non-negative numbers. 
 *The digits are stored in reverse order and each of their nodes contain a single digit. 
 *Add the two numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class AddTwoNums {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null || l2==null){
            System.out.println("Node l1 or Node l2 ");
        }
        int digit = 0;
        int total = l1.val + l2.val;
        if(total > 9){
            total -= 10;
            digit =1;
        }
        ListNode result = new ListNode(total);
        while(l1.next!=null && l2.next!=null){
            l1 = l1.next;
            l2 = l2.next;
            total = l1.val + l2.val;
            if(total > 9){
                total -= 10;
                digit =1;
            }
            ListNode next = new ListNode(total);
            result.next = next;
            result =  next;
        }
        
        if(l1.next!=null){
            result.next = l1.next;
        }
        if(l2.next!=null){
            result.next = l2.next;
        }
        return result;
    }
	
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 

}
