package leetcode;

/**
 * Created by shelvin on 16/1/17 at 14:20.
 */

public class ReverseLinkedListII_92
{
    public static void main(String[] args)
    {
        ListNode head = ListNodeFactory.getSortedListNodes(10);
        ListNode dummy = head;
        while (dummy != null)
        {
            System.out.println(dummy.val);
            dummy = dummy.next;
        }
        ListNode rblist = reverseBetween(head, 3, 6);
        while (rblist != null)
        {
            System.out.println(rblist.val);
            rblist = rblist.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n)
    {
        //测试传入的head实际上是第一个实节点,所以这里生成一个dummy虚拟节点,然后把head指向dummy节点,
        //就变成了head(dummy)-->node1-->node2-->......了,head指向了一个虚拟节点,算法也是按照head
        //是一个虚拟节点处理的,算法最后返回dummy.next是链条的第一个实节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        ListNode preMNode = null;
        ListNode postNNode = null;

        for (int i = 0; i < m - 1; i++)
        {
            head = head.next;
        }
        preMNode = head;
        ListNode MNode = preMNode.next;
        ListNode NNode = MNode;
        postNNode = NNode.next;
        for (int i = m; i < n; i++)
        {
            if (null == postNNode)
            {
                return null;
            }
            ListNode temp = postNNode.next;
            postNNode.next = NNode;
            NNode = postNNode;
            postNNode = temp;
        }

        MNode.next = postNNode;
        preMNode.next = NNode;

        return dummy.next;
    }


    public ListNode reverseList(ListNode head)
    {
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode temp = null;

        while (null != cur)
        {
            temp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = temp;
        }

        head.next = null;
        return pre;
    }
}
