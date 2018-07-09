/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, returnnull.
 * Follow up:
 * Can you solve it without using extra space?
 */

public class LinkedListCycleIi {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head){
        ListNode res = null;
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode){
                break;
            }
        }
        if (fastNode == null || fastNode.next == null) return res;

        slowNode = head;
        while (slowNode != fastNode){
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        res = slowNode;
        return res;
    }
}
