package com.shelvin.study.datastructure.res.stackapp;

public class LinkStackApp 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

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

class SLinkList
{
	private SLink first;
	
	public SLinkList()
	{
		first=null;
	}
	
	public boolean isEmpty()
	{
		return(first==null);
	}
	
	public void insertFirst(int data)
	{
		SLink slink=new SLink(data);
		if(isEmpty())
			first=slink;
		slink.next=first;
		first=slink;
	}
	
	public void deleteFirst()
	{
		if(isEmpty())
		{
			System.out.println("empty list");
			return;
		}
		first=first.next;
	}
	
	public void displayList()
	{
		SLink current=first;
		if(isEmpty())
		{
			System.out.println("list is empty.");
			return;
		}
		while(current.next!=null)
		{
			current.displayLink();
			System.out.println("");
			current=current.next;
		}
	}
}

class LinkStack
{
	private SLinkList stacklist;
	public LinkStack()
	{
		stacklist=new SLinkList();
	}
	
	public void push(int data)
	{
		stacklist.insertFirst(data);
	}
	
	public void pop()
	{
		stacklist.deleteFirst();
	}
	
	public boolean isEmpty()
	{
		return(stacklist==null);
	}
	
	public void displayStack()
	{
		stacklist.displayList();
	}
}