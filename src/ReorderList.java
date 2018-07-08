import java.util.Stack;

/**
 * Given a singly linked list L: L 0→L 1→…→L n-1→L n,
 * reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
 *
 * You must do this in-place without altering the nodes' values.
 *
 * For example,
 * Given{1,2,3,4}, reorder it to{1,4,2,3}.
 */
public class ReorderList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public void reorderList(ListNode head){
        if (head == null || head.next == null) return;

        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode.next != null && fastNode.next.next !=null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        slowNode = slowNode.next;
        Stack<ListNode> stack = new Stack<>();

        while (slowNode != null){
            stack.push(slowNode);
            slowNode = slowNode.next;
        }

        while (!stack.isEmpty()){
            ListNode tmpNext = head.next;
            ListNode endNode = stack.pop();
            head.next = endNode;
            endNode.next = tmpNext;
            head = tmpNext;
        }

        head.next = null;
    }
}
