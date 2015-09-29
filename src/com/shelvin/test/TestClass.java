package com.shelvin.test;

public class TestClass {
    public  static void main(String[] args)

    {
        try {

            //测试Class.forName()
            Class testTypeForName=Class.forName("com.shelvin.test.TestClassType");
            System.out.println("testForName---"+testTypeForName);

            //测试类名.class
            Class testTypeClass=TestClassType.class;
            System.out.println("testTypeClass---"+testTypeClass);

            //测试Object.getClass()
            TestClassType testGetClass= new TestClassType();
            System.out.println("testGetClass---"+testGetClass.getClass());
            testGetClass.comMethod();

        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();

        }
    }
}

class TestClassType{

    String string="shelvin";

    //构造函数
    public TestClassType(){
        System.out.println("----构造函数---");
    }

    //静态的参数初始化
    static{
        System.out.println("---静态的参数初始化---");
    }

    //非静态的参数初始化
    {
        System.out.println("----非静态的参数初始化---");
    }

    public void comMethod()
    {
        System.out.println("---这是一个普通函数，测试在new一个类的时候，看该类是否初始化---");
    }

}
