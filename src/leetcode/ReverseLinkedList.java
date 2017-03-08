package leetcode;

/**
 * Created by shelvin on 16/1/17 at 15:47.
 */

public class ReverseLinkedList
{
    public static void main(String[] args)
    {
        ListNode head = ListNodeFactory.getSortedListNodes(10);
        ListNode h1 = head;
        while (null != h1)
        {
            System.out.println(h1.val);
            h1 = h1.next;
        }

        head = reverseList(head);

        while (head != null)
        {
            System.out.println(head.val);
            head = head.next;
        }

    }

    public ListNode reverseListRecursion(ListNode head)
    {
        if (null == head || null == head.next)
        {
            return head;
        }
        ListNode reHead = reverseListRecursion(head);
        head.next.next = head;
        head.next = null;
        return reHead;
    }

    public static ListNode reverseList(ListNode head)
    {
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode temp;

        while (cur != null)
        {
            temp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = temp;
        }

        //this code is very important, or else there will be dead circle when you print the reversed linked list
        //because the last element of the reversed list is referring the last second element
        //for example
        //original list:1-->list:2-->list:3-->list:4
        //reversed list:list:4-->list:3-->list:2-->list:1-->list:2-->list:1-->list:2.......
        //所以翻转链表后,要把翻转后的链表的最后一个元素和倒数第二个元素的引用解开
        head.next = null;

        return pre;
    }
}
