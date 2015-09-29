package com.shelvin.test;

/**
 * Created by shelvin zhou on 2015/1/11.
 */
public class RTConstant{
    public static void main(String args[]){
        //System.out.println(Data.i1);
        //System.out.println(Data.i2);//initialization!
        //System.out.println(Data.b1);//initialization!
        //System.out.println(Data.s1);
        //System.out.println(Data.i3);//initialization!
        //System.out.println(Data.a); //initialization!
        //System.out.println(Data.e); //initialization!
    }
}
class Data{
    static{
        System.out.println("initialization!");
    }
    public static final int i1=0;
    public static final Integer i2=0;
    public static final Boolean b1=true;
    public static final String s1="0";
    public static final int i3=s1.length();
    public static final AAA a=new AAA();
    public static final Enum e=E.A;
}
class AAA{

}
enum E {
    A,B,C,D,E,F,G;
}
