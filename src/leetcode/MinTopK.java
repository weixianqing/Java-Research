package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by zhousw on 2016/7/17.
 */
public class MinTopK
{
    public static void main(String[] args)
    {
        int[] input = {5,1,10,4,6};
        int len = input.length;
//        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(len);
//        for (int i = 0; i < len; i++)
//        {
//            queue.add(input[i]);
//        }
//
//        while (!queue.isEmpty())
//        {
//            System.out.print(queue.poll()+"  ");
//        }
//
//        System.out.println();
//        System.out.println("---------------------------------------------------");
//
//        Comparator<Integer> comparator = new Comparator<Integer>()
//        {
//            @Override
//            public int compare(Integer o1, Integer o2)
//            {
//                return o2.compareTo(o1);
//            }
//        };
//
//        PriorityQueue<Integer> queue1 = new PriorityQueue<Integer>(len,comparator);
//        for (int i = 0; i < len; i++)
//        {
//            queue1.add(input[i]);
//        }
//
//        while (!queue1.isEmpty())
//        {
//            System.out.print(queue1.poll()+"  ");
//        }

        int k = 3;
        int[] res =topK_maxHeap(k,input);
        for (int i = 0; i < k; i++)
        {
            System.out.print(res[i]+"  ");
        }
    }


    //最小堆堆顶元素最小
    //PriorityQueue默认实现是最小堆
    public static int[] topK_maxHeap(int k,int[] input)
    {
        int[] res = new int[k];

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < k; i++)
        {
            queue.add(input[i]);
        }

        for (int i = k; i < input.length; i++)
        {
            if (input[i] < queue.peek())
            {
                queue.poll();
                queue.add(input[i]);
            }
        }

        for (int i = 0; i < k; i++)
        {
            res[i] = queue.poll();
        }

        return res;
    }
}
