package com.shelvin.res.listapp;

public class SortedListApp 
{
	public static void main(String[] args)
	{
		SortedList sl=new SortedList();
		sl.insert(22);
		sl.insert(8);
		sl.insert(30);
		sl.insert(28);
		sl.insert(16);
		sl.insert(30);
		sl.displayList();
	}
}

class SLink
{
	public int data;
	public SLink next;
	
	public SLink(int data)
	{
		this.data=data;
	}
	
	public void displayLink()
	{
		System.out.print("{"+data+"} ");
	}
}

class SortedList
{
	private SLink first;
	private SLink current;
	private SLink previous;
	
	public SortedList()
	{
		first=null;
	}
	
	public boolean isEmpty()
	{
		return(first==null);
	}
	
	public void insert(int data)
	{
//		SLink slink=new SLink(data);
//		//current=first;
//		if(first==null)
//		{
//			first=slink;
//			System.out.println("first data: "+first.data);
//			return;//无return，死循环
//		}
//		
//		current=first;
//			
//		while(current!=null && data>current.data)
//		{
//			previous=current;
//			current=current.next;
//		}
//		
//		if(previous==null)
//		{
//			slink.next=first;
//			first=slink;
//		}
//		
//		slink=current;
//		previous=slink;//导致运行错误
		SLink slink=new SLink(data);
		
		//空表
		if(first==null)
		{
			first=slink;
			return;
		}
		
		current=first;
		
		while(current!=null && data>=current.data)
		{
			previous=current;
			current=current.next;
		}
		
		//表头插入
		if(previous==null)
		{
			slink.next=first;
			first=slink;
		}
		//表中插入，表尾插入；表尾时：previous指向最后一个链接点，current为null，所以while循环不执行，previous.next原来为null，现在prev.next=slink
		//该句执行，把slink插入到表尾
		else
		{
			previous.next=slink;
		}//上边注释掉的部分运行不正确，和正确运行的不同之处就在这个else部分
		
		slink.next=current;
	}
	
	public void removeFirst()
	{
		first=first.next;
	}
	
	public void displayList()
	{
		current=first;
		if(isEmpty())
		{
			System.out.println("empty list.");
		}
		
		while(current.next!=null)
		{
			current.displayLink();
			current=current.next;
		}
	}
}
