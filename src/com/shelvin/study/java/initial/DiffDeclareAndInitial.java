package com.shelvin.study.java.initial;

/**
 * Created by shelvin on 19/1/16.
 */
public class DiffDeclareAndInitial
{
    static
    {
        System.out.println("father static block is invoked.");
    }

    public DiffDeclareAndInitial()
    {
        System.out.println("father constructor is invoked.");
    }

    public static void main(String[] args)
    {
        DiffDeclareAndInitial ddi4 = null;
        System.out.println("----------------------------------------");
        DiffDeclareAndInitial ddi3 = new DiffDeclareAndInitial();
        System.out.println(ddi3.hashCode());
        System.out.println("----------------------------------------");
        DiffDeclareAndInitial ddi = new SonofDiffDeclareAndInitial();
        System.out.println(ddi.hashCode());
        ddi = new SonofDiffDeclareAndInitial();
        System.out.println(ddi.hashCode());
        System.out.println("----------------------------------------");

        SonofDiffDeclareAndInitial sddi = new SonofDiffDeclareAndInitial();
        System.out.println(sddi.hashCode());
        sddi = new SonofDiffDeclareAndInitial();
        System.out.println(sddi.hashCode());
        System.out.println("----------------------------------------");

        DiffDeclareAndInitial ddi2 = new DiffDeclareAndInitial();
        System.out.println(ddi2.hashCode());
    }
}

class SonofDiffDeclareAndInitial extends DiffDeclareAndInitial
{
    static
    {
        System.out.println("son static block is invoked.");
    }

    public SonofDiffDeclareAndInitial()
    {
        System.out.println("son constructor is invoked.");
    }
}
