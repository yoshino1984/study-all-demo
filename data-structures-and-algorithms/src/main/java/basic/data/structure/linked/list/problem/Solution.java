package basic.data.structure.linked.list.problem;

import basic.common.ListNode;

/**
 * @author wangxin
 * 2020/4/29 19:46
 * @since
 **/
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /** 链表是否有环*/
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /** 删除倒数第n个节点*/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode guard = new ListNode(-1);
        guard.next = head;
        ListNode fast = guard;
        ListNode slow = guard;
        for (int i = 0; i < n; i++) {
            if (fast.next != null) {
                fast = fast.next;
            }
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return guard.next;
    }

    /**
     * 删除中间节点
     * @param node
     */
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode guard = new ListNode(-1);
        guard.next = node;
        ListNode mid = guard;
        ListNode fast = guard.next;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            mid = mid.next;
        }
        if (mid.next != null) {
            mid.next = mid.next.next;
        }
    }


}
