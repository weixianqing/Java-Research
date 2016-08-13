package leetcode;

/**
 * Created by shelvin on 13/8/16 at 14:10.
 */

public class ReverseNodesInKGroup_25
{
    public static void main(String[] args)
    {
        ListNode head = ListNodeFactory.getListNodes(8);
        ListNode index1 = head;
        while (index1 != null)
        {
            System.out.println(index1.val);
            index1 = index1.next;
        }

        System.out.println("--------------------------");
        ListNode index2 = reverseGroup(head, 4);
        while (index2 != null)
        {
            System.out.println(index2.val);
            index2 = index2.next;
        }
    }

    public static ListNode reverseGroup(ListNode head, int k)
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        head = dummy;
        while (head.next != null)
        {
            head = reverseKGroup(head, k);
        }

        return dummy.next;
    }

    public static ListNode reverseKGroup(ListNode head, int k)
    {
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode n1 = head.next;

        //judge if this circle has enough k elements;
        ListNode next = head;
        for (int i = 0; i < k; i++)
        {
            if (next.next == null)
            {
                return next;
            }

            next = next.next;
        }


        for (int i = 0; i < k; i++)
        {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        n1.next = cur;
        head.next = pre;
        return n1;
    }
}
