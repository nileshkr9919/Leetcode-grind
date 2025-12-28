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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        ListNode l1 = list1, l2 = list2;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ListNode node = new ListNode(l1.val);
                current.next = node;
                current = current.next;
                l1 = l1.next;
            } else {
                ListNode node = new ListNode(l2.val);
                current.next = node;
                current = current.next;
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            ListNode node = new ListNode(l1.val);
            current.next = node;
            current = current.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            ListNode node = new ListNode(l2.val);
            current.next = node;
            current = current.next;
            l2 = l2.next;
        }

        return dummy.next;

    }
}