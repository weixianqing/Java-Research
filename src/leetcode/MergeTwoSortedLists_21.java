package leetcode;

/**
 * Created by shelvin on 5/8/16 at 23:53.
 */

public class MergeTwoSortedLists_21
{
    public static void main(String[] args)
    {
        ListNode l1 = ListNodeFactory.getSortedListNodes(15);
        ListNode l2 = ListNodeFactory.getSortedListNodes(10);
        ListNode res = mergeTwoLists(l1,l2);
        while (res != null)
        {
            System.out.print(res.val+" ");
            res = res.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if (l1 == null)
        {
            return l2;
        }
        if (l2 == null)
        {
            return l1;
        }

        ListNode index1 = l1;
        ListNode index2 = l2;
        ListNode head = new ListNode(0);
        ListNode temp = head;

        while (null != index1 && null != index2)
        {
            if (index1.val < index2.val)
            {
                temp.next = index1;
                index1 = index1.next;
                temp = temp.next;
            }else
            {
                temp.next = index2;
                index2 = index2.next;
                temp = temp.next;
            }
        }

        if (null == index1)
        {
            temp.next = index2;
        }

        if (null == index2)
        {
            temp.next = index1;
        }

        return head.next;
    }
}
