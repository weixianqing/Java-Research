package leetcode;

/**
 * Created by Shelvin Zhou on 2016/8/12 at 19:07.
 */

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        if (right - left == 1) {
            return mergeTwoLists(lists[left], lists[right]);
        }

        int mid = left + (right - left) / 2;
        ListNode leftNode = mergeKLists(lists, left, mid);
        ListNode rightNode = mergeKLists(lists, mid + 1, right);
        return mergeTwoLists(leftNode, rightNode);
    }

    public ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        }
        if (listNode2 == null) {
            return listNode1;
        }

        ListNode res = null;
        ListNode index1 = listNode1;
        ListNode index2 = listNode2;
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (index1 != null && index2 != null) {
            if (index1.val < index2.val) {
                temp.next = index1;
                temp = index1;
                index1 = index1.next;
            } else {
                temp.next = index2;
                temp = index2;
                index2 = index2.next;
            }
        }

        if (index1 == null) {
            temp.next = index2;
        }

        if (index2 == null) {
            temp.next = index1;
        }

        return res;
    }
}
