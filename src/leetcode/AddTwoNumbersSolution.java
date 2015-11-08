package leetcode;


/**
 * Created by shelvin on 11/8/15.
 */

public class AddTwoNumbersSolution
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        /**
         * 这样些代码的本意是为了节省空间,先找l1和l2都不为空的部分相加,然后把l1或l2中多出的部分直接链接到result
         * 链表中,理想很美好,一下子就多了bug,比如5+5=10的进位,1+9999每个9对应的进位,这些都没有考虑,即便考虑,
         * 在这种思路下,处理起来也是很麻烦,因为l2多出的三个9还得一个一个的计算向上进位,是节省了点空间,但是给写代码
         * 造成了很大的麻烦.
        ListNode resultPtr = new ListNode(0);
        ListNode indexPtr = resultPtr;
        int flag = 0;

        while (true)
        {
            int partSum = l1.val + l2.val;

            if (flag == 1)
            {
                indexPtr.val += 1;
                flag = 0;
            }

            if (partSum >= 10)
            {
                flag = 1;
                indexPtr.val += (partSum % 10);
            }else
            {
                indexPtr.val += partSum;
            }

            //....................
            if (l1.next != null && l2.next != null)
            {
                l1 = l1.next;
                l2 = l2.next;
            }else
            {
                break;
            }
            indexPtr.next = new ListNode(0);
            indexPtr = indexPtr.next;
        }

        if (l2.next != null)
        {
            if (flag == 1)
            {
                l2.next.val += 1;
                indexPtr.next = l2.next;
            }else
            {
                indexPtr.next = l2.next;
            }
        }else if (l1.next != null)
        {
            if (flag == 1)
            {
                l1.next.val += 1;
                indexPtr.next = l1.next;
            }else
            {
                indexPtr.next = l1.next;
            }
        }else
        {
            if (flag == 1)
            {
                indexPtr.next= new ListNode(0);
                indexPtr.next.val = 1;
            }
        }

        return resultPtr; */

        ListNode result = new ListNode(0);
        ListNode index = result;
        int sum = 0;
        int carry = 0;

        while (true)
        {
            if (l1 != null)
            {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null)
            {
                sum += l2.val;
                l2 = l2.next;
            }

            /**
             * carry = (sum /= 10)这种写法很不好,很难从代码上直观的明白这句代码的意思
             * 隐含着难发现的bug,比如5+5,val = 0,carry =1,然后进入while的第二次循环,
             * 两个if都不执行,此时sum还是上次的结果10,如果写成carry = sum /10,而且很容易
             * 这样写,因为sum除以10,要么0,要么1,就是确定进位啊,但实际上,的第二次while循环,
             * sum还是10,所以carry还是1,所以第三个if语句成立,程序死循环,如果carry = (sum /= 10);
             * 第一次计算的sum = 10在第一次while循环时就编程了1,所以第二次while循环,carry=1 /10 =0
             * 程序推出while循环,
             * 所以这种写法,第一遍写代码基本不可能写对,而且这个bug要debug很久才会发现.
             */

            index.val += sum % 10;

            //非常容易写错的一句,容易写为carry = sum / 10;
            carry = (sum /= 10);

            //写成
            // carry = sum / 10;
            //sum = 0;
            //更容易理解

            if (carry > 0 || l1 != null || l2 != null)
            {
                index.next = new ListNode(carry);
                index = index.next;
            }else
            {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        AddTwoNumbersSolution atns = new AddTwoNumbersSolution();
        ListNode l1 = new ListNode(5);

        ListNode l2 = new ListNode(5);

        ListNode result = atns.addTwoNumbers(l1,l2);
        while (result != null)
        {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
