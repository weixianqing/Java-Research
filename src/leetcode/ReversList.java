package leetcode;

/**
 * Created by shelvin on 15/8/16 at 22:56.
 */

public class ReversList
{
    public static void main(String[] args)
    {
        ListNode head = ListNodeFactory.getListNodes(2);
        ListNode res = head;
        while (res != null)
        {
            System.out.println(res.val);
            res = res.next;
        }
        System.out.println("after reversing:");
        ListNode reverse = reverseListRecur(head);
        while (reverse != null)
        {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }

    public static ListNode reverseList(ListNode head)
    {
        if (head == null)
        {
            return null;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next;

        while (cur != null)
        {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        //very important,head.next points to first cur(because head is gave to pre,pre.next point to first cur)
        // when the while begins
        //so, head.next points to first cur, and first cur is reversed in the first while loop
        //now, head.next is first cur, and first cur.next is head(first pre)
        //dead circle
        head.next = null;
        //even though the the last pre(the last while loop generates) is gave to head, the discussion above is also
        //right, because head = pre; just changed the reference, but the real physical link is the
        //head.next is first cur, and first cur.next is head(first pre)(before the head reference is changed )
        //the change is just the reference, not the real link, so we need to "head.next = null",this make the
        //real link changed, and then give the head a new reference to make it refer to a new ListNode.
        head = pre;

        return head;
    }

    public static ListNode reverseListRecur(ListNode head)
    {
        if (head.next == null)
        {
            return head;
        }
        ListNode cur = head;
        ListNode next = head.next;

        cur.next = null;
        ListNode res = reverseListRecur(next);
        next.next = cur;

        return res;
    }
}
