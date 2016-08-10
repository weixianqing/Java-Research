package leetcode;

/**
 * Created by shelvin on 5/8/16 at 22:38.
 */

public class RemoveNthNodeFromEndofList_19
{
    public static void main(String[] args)
    {
        ListNode head = new ListNode(0);
        ListNode sec = head.next = new ListNode(1);
        ListNode thi = sec.next = new ListNode(2);
        ListNode fou = thi.next = new ListNode(3);
        fou.next = new ListNode(4);

        RemoveNthNodeFromEndofList_19 test = new RemoveNthNodeFromEndofList_19();
        ListNode res = test.removeNthFromEnd(head,3);

        while (res != null)
        {
            System.out.println(res.val);
            res  = res.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode res = head;
        int totalNodeNum = 0;

        while (res != null)
        {
            totalNodeNum++;
            res = res.next;
        }
        int index = totalNodeNum - n;


        //仔细理解下java的传址引用,res是可以追溯到temp对链表的改变的,res引用的下一个节点的地址是被temp修改过的.
        ListNode temp = res = head;
        for (int i = 0; i < index-1; i++)
        {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return res;
    }
}


