package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by zhousw on 2016/7/18.
 */

//1.维持两个heap,一个是最小堆，一个是最大堆。最大堆存放的都是小数（都小于中位数），最小堆存放的都是大数（都大于中位数）
//一直使maxHeap的size大于minHeap(size大1).
//当两边size相同时，两个堆都有数据没什么问题，如果两个堆都是空，要加判断条件注意条件判断minHeap.peek() != null，
// 否则minHeap.poll()报错
public class FindMedianInDynamicInput
{
    static PriorityQueue<Integer> maxHeap;
    static PriorityQueue<Integer> minHeap;
    static Comparator<Integer> comparator = new Comparator<Integer>()
    {
        @Override
        public int compare(Integer o1, Integer o2)
        {
            return o2.compareTo(o1);
        }
    };

    public static void main(String[] args)
    {
        maxHeap = new PriorityQueue<Integer>(20, comparator);
        minHeap = new PriorityQueue<Integer>(20);
    }

    public static void addNum(int value)
    {
        if (maxHeap.size() == minHeap.size())
        {
            //注意条件判断minHeap.peek() != null
            //当两个堆都是空时，value直接插入最小堆，此时不走下边的if语句，直接跳到
            //else中，要实现这个路由，最直接的方法就是让if失效，失效的最好方法就是
            //加条件让size都为0时，if不成立，由于minHeap有弹出操作 ，如果minHeap为null，
            //弹出肯定报错 ，所以限定条件就是minHeap要弹出的元素不为空，所以minHeap.peek() != null
            if (minHeap.peek() != null && value > minHeap.peek())
            {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(value);
            } else
            {
                maxHeap.offer(value);
            }
        } else
        {
            if (value < maxHeap.peek())
            {
                //而这里的maxHeap弹出肯定不会报错，因为当两边size不相等使，数据一定是在maxHeap中的
                //所以如果minHeap的size为0，maxHeap的size就肯定不为0，而maxHeap的size为0的情况，
                //除了minHeap和maxHeap都为0外，不存在其他情况
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(value);
            } else
            {
                minHeap.offer(value);
            }
        }
    }

    public static int getMedian()
    {
        int res;

        if (minHeap.size() == maxHeap.size())
        {
            res = (minHeap.peek() + maxHeap.peek()) / 2;
        } else
        {
            res = maxHeap.peek();
        }

        return res;
    }
}
