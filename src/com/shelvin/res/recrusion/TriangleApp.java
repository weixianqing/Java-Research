package com.shelvin.res.recrusion;

//static修饰的方法或变量或常量属于类，和对象没有关系；
//类所有的对象都共享同一个静态方法或变量或常量，静态方法、静态变量、静态常量直接通过类名进行访问（也可通过对象，但会造成混淆，因为该静态方法、静态变量、静态常量和
//调用它的对象没有任何关系）
//静态方法不能操作对象，所以不能在静态方法中访问实例域，但是静态方法可以访问自身类中的静态域

public class TriangleApp 
{
	public static void main(String[] args)
	{
			TriangleApp ta=new TriangleApp();
			System.out.println(ta.triangle(5));
			//ta.triangle(5);在main中直接这样调用报错，因为main是static的，
			insert(5);//静态方法可以访问自身类中的静态域，静态方法不能操作对象，所以不能在静态方法中访问实例域,而triangle方法是类的普通方法，只能通过类的对象进行调用
	}
	
	public int triangle(int n)
	{
		if(n==1)
			return 1;
		else
			return(n+triangle(n-1));
	}
	
	public static void insert(int key)
	{
		//triangle(int key);  //静态方法不能操作对象，所以不能在静态方法中访问实例域,而triangle方法是类的普通方法，只能通过类的对象进行调用
	}
	
	public void remove(int key)
	{
		triangle(key);
		this.triangle(key);
	}
}
