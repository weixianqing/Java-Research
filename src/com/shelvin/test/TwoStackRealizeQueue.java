package com.shelvin.test;

import java.util.*;

public class TwoStackRealizeQueue
{
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    TwoStackRealizeQueue()
    {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    //No.1
    //开始写代码，用两个栈实现一个队列
    public int offer(int o)
    {
        stack1.push(o);
        return o;
    }

    public int poll()
    {
        Integer temp = null;

        if (!stack2.empty())
        {
            return stack2.pop();
        }else
        {
            while (!stack1.empty())
            {
                temp = stack1.pop();
                stack2.push(temp);
            }

            if (!stack2.empty())
            {
                temp = stack2.pop();
            }

            return temp;
        }
    }

    //end_code
    public static void main(String[] args)
    {
        TwoStackRealizeQueue queue = new TwoStackRealizeQueue();
        List<Integer> number = new ArrayList<Integer>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        number.add(queue.poll());
        number.add(queue.poll());
        number.add(queue.poll());
        number.add(queue.poll());
        number.add(queue.poll());
        System.out.println(number);
    }
}