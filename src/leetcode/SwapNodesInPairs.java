package leetcode;

/**
 * Created by shelvin on 13/8/16 at 10:35.
 */

public class SwapNodesInPairs
{
    public static void main(String[] args)
    {
        ListNode head = ListNodeFactory.getListNodes(8);

        ListNode begin = head;
        while (begin != null)
        {
            System.out.println(begin.val);
            begin = begin.next;
        }

        System.out.println("original head:" + head.val);
        System.out.println("---------------------------");

        ListNode end = swapPairs(head);
        while (end != null)
        {
            System.out.println(end.val);
            end = end.next;
        }
    }

    public static ListNode swapPairs(ListNode head)
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        head = dummy;
        while (head.next != null && head.next.next != null)
        {
            ListNode temp1 = head.next;
            ListNode temp2 = head.next.next;

            head.next = temp2;
            temp1.next = temp2.next;
            temp2.next = temp1;

            head = temp1;
        }


        return dummy.next;
    }
}
