package leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by shelvin on 6/8/16 at 01:16.
 */

public class ListNodeFactory
{
//    public static void main(String[] args)
//    {
//        int numOfListNode = 5;
//        ListNode head = getListNodes(numOfListNode);
////        ListNode head = getSortedListNodes(numOfListNode);
//        for (int i = 0; i < numOfListNode; i++)
//        {
//            System.out.println(head.val);
//            head = head.next;
//        }
//    }

    public static ListNode getListNodes(int numOfListNode)
    {
        ListNode head = new ListNode(0);
        ListNode medi = head;
        Random random = new Random();
        for (int i = 0; i < numOfListNode; i++)
        {
            int val = random.nextInt(100);
            ListNode temp = new ListNode(val);
            medi.next = temp;
            medi = medi.next;
        }
        return head.next;
    }

    public static ListNode getSortedListNodes(int numOfListNode)
    {
        ListNode head = new ListNode(0);
        ListNode medi = head;

        Random random = new Random();
        int[] data = new int[numOfListNode];
        for (int i = 0; i < numOfListNode; i++)
        {
            data[i] = random.nextInt(100);
        }
        Arrays.sort(data);
        for (int i = 0; i < numOfListNode; i++)
        {
            int val = data[i];
            ListNode temp = new ListNode(val);
            medi.next = temp;
            medi = medi.next;
        }

        return head.next;
    }
}
