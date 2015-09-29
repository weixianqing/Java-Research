package com.shelvin.res.listapp;

public class ListInsertionSortApp 
{
	public static void main(String[] args)
	{
		LLink[] ll=new LLink[8];
		
		System.out.print("unsorted array:");
		for(int i=0;i<ll.length;i++)
		{
			int m=(int)((Math.random())*99);
			ll[i]=new LLink(m);
			System.out.print(ll[i].data+" ");
			//asl.insert(ll[i]);
		}
		ASortedList asl=new ASortedList(ll);
		System.out.println("");
		System.out.print("sorted array:");
		for(int j=0;j<ll.length;j++)
		{
			ll[j]=asl.removeFirst();
			System.out.print(ll[j].data+" ");
		}
		
	}
}

class LLink
{
	public int data;
	public LLink next;
	
	public LLink(int data)
	{
		this.data=data;
	}
	
	public void displayLink()
	{
		System.out.print("{"+data+"} ");
	}
}

class ASortedList
{
	private LLink first;
	
	public ASortedList()
	{
		first=null;
	}
	
	public boolean isEmpty()
	{
		return(first==null);
	}
	
	public ASortedList(LLink[] ll)
	{
		first=null;//需要初始化，因为这是构造函数，带数组参数；上边那个也是构造器，没有参数，所以系统
		//调用这个构造函数时，也需要对first进行初始化；有个问题需要实验确定，当系统显式调用这个带数组参数
		//的构造器时，上边参数为空的构造器是否调用；当系统显式调用这个带数组参数的构造器时，系统默认构造器是否调用；
		for(int i=0;i<ll.length;i++)
		{
			insert(ll[i]);
		}
	}
	
	public void insert(LLink linkArr)
	{
		LLink previous=null;
		LLink current=first;
		
//		if(first==null)
//		{
//			first=linkArr;
//			
//			return;
//		}
//while(current!=null)这个条件已经结合下边if中first=linkArr已经包括链表为空的情况了
		
		while(current!=null && linkArr.data>current.data)
		{
			previous=current;
			current=current.next;
		}
		
		if(previous==null)
		{
			first=linkArr;
		}
		else
		{
			previous.next=linkArr;
		}
		
		linkArr.next=current;
		
	}
	
	public LLink removeFirst()
	{
		LLink temp=first;
		first=first.next;
		return temp;
	}
}

