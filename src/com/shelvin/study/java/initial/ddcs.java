package com.shelvin.study.java.initial;

/**
 * Created by shelvin on 2015/11/7.
 */
public class ddcs
{
    /**
     * 问题1
     * public static int b = ddcsb.a;
     * public static int a =1;
     * 这个顺序下,打印出的ddcsb.t的值是0
     * 容易理解错误的地方是:我在debug的时候,明明dddcs.a的值已经是1了,然后赋值给了t,
     * 为什么t还是0?
     * 没能理解好这个问题的原因是:我以为t = ddcs.a是像面向对象一样,t指向了一个对象ddcs.a,
     * 当ddcs.a的值变化的时候,t的值也是跟着变化的,但却没有注意,这里都是int类型,是基本类型,不是对象
     * 由于public static int b = ddcsb.a;这句话在前,此时ddcs.a的值是0,所以把ddcs.a=0赋值
     * 给了ddcsb.t,当public static int b = ddcsb.a;这句执行完(此时ddcsb已经被初始化完),ddcs.b是0,
     * 因为ddcs.a是0,然后才是ddcs.a赋值为1;
     * 无论后边怎么处理,ddcsb.t都不能变为1了,因为静态的都只初始化一次,即便后边有new ddcsb这样的语句都
     * 不可能让t变为1了.
     * 然后ddcs中public static int b = ddcsb.a;
     * public static int a =1;这两句调换顺序,此时,ddcsb.t就是1了,因为ddcs.a先初始化为1,然后才用
     * 这个新值1赋值给ddcsb.t,此时t就是1.
     *
     *
     * 问题2
     * 如果把a声明为integer,报空指针错误?
     * 因为integer是对象,java初始化时,先声明并赋默认值,而对象的默认值就是null,所以在ddcsb中,
     * ddcs.a这句调用a时,ddcs中还没有执行到public static int a =1这句,此时a的值就是默认的null
     * 所以会报空指针异常.
     */
    public static int b = ddcsb.a;
    public static int a =1;

    public ddcs()
    {

    }

    public static void main(String[] args)
    {
        System.out.println("ddcsb.t="+ddcsb.t);
    }
}

class ddcsb
{
    public static int t = ddcs.a;
    public static int a = 1;
}
