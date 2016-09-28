package com.shelvin.study.datastructure.res.queueapp;

public class LinkQueueApp 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}

class Link
{
	public int data;
	public Link next;
	
	public Link(int data)
	{
		this.data=data;
	}
	
	public void displayLink()
	{
		System.out.print("{"+data+"} ");
	}
}

class FirstLastList
{
	private Link first;
	private Link last;
	
	public FirstLastList()
	{
		first=null;
		last=null;
	}
	
	public boolean isEmpty()
	{
		return(first==null);
	}
	
	public void insertLast(int data)
	{
		Link link=new Link(data);
		if(isEmpty())
		{
			first=link;
		}
		last.next=link;
		last=link;
	}
	
	public void deleteFirst()
	{
		if(isEmpty())
		{
			System.out.println("empty queue.");
			return;
		}
		if(first.next==null)
		{
			last=null;
		}
		first=first.next;
	}
	
	public void displayList()
	{
		Link current=first;
		while(first.next!=null)
		{
			current.displayLink();
			current=current.next;
		}
		System.out.println("");
	}
}

class LinkQueue
{
	FirstLastList fllist=null;
	public LinkQueue()
	{
		fllist=new FirstLastList();
	}
	
	public boolean isEmpty()
	{
		return(fllist.isEmpty());
	}
	
	public void push(int data)
	{
		fllist.insertLast(data);
	}
	
	public void pop()
	{
		fllist.deleteFirst();
	}
	
	public void displayQueue()
	{
		fllist.displayList();
	}
}
