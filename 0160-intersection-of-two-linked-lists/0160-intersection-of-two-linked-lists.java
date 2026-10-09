/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    static int getLength(ListNode head){
        int length =0;

        while(head!=null){
            length++;
            head = head.next;
        }
        return length;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        ListNode h1 = headA;
        ListNode h2 = headB;

        if(headA == null || headB == null){
            return null;
        }

        while(lenA>lenB){
            h1=h1.next;
            lenA--;
        }

         while(lenB>lenA){
            h2=h2.next;
            lenB--;
        }

        while(h1!=h2){
            h1 = h1.next;
            h2 = h2.next;
        }

        return h1;
    }
}