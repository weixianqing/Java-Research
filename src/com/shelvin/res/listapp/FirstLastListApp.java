package com.shelvin.res.listapp;
/*
 * note1：双端链表比链表多一个链接点，多的是链接点，所以在定义
 * 链接点FLLink时，
 * public FLLink firstlink;
 * public FLLink lastlink;
 * 这样定义是不对的，这样是一个链接点有两个自身的引用，而不是两个链接点，实际上只
 * public FLLink fllink;就可以，两个链接点应该是在定义双端链表类时候定义一个first链接点，定义一个last链接点
 * private FLLink firstlink;
 * private FLLink lastlink;这两句才是定义了两个链接点
 */
public class FirstLastListApp 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		FirstLastLinkList flll=new FirstLastLinkList();
		flll.insertFirst(22);
		flll.insertFirst(96);
		flll.insertFirst(8);
		flll.insertFirst(22);
		flll.insertFirst(39);
		flll.displayList();
		flll.insertLast(0);
		flll.insertLast(10);
		flll.insertLast(41);
		flll.insertLast(6);
		flll.displayList();
		flll.deleteFirst();
		flll.displayList();
		flll.deleteFirst();
		flll.displayList();
	}

}

class FLLink
{
	public int flData;
	public FLLink next;
	
	public FLLink(int data)
	{
		flData=data;
	}
	
	public void displayFLLink()
	{
		System.out.print("{"+flData+"}");
	}
}

class FirstLastLinkList
{
	private FLLink firstlink;
	private FLLink lastlink;
	
	public FirstLastLinkList()
	{
		firstlink=null;
		lastlink=null;
	}
	
	public boolean isEmpty()
	{
		return(firstlink==null);
	}
	
	public void insertFirst(int data)
	{
		FLLink fllink=new FLLink(data);
		
//		if(firstlink==null)
//		{
//			lastlink=fllink;
//		}
//		else
//		{
//			fllink.next=firstlink;
//			firstlink=fllink;
//		}
//上述写法，程序运行不正确，改为下边正常
		
		if(firstlink==null)
		{
			lastlink=fllink;
		}
		
		fllink.next=firstlink;
		firstlink=fllink;
	}
	
	public void insertLast(int data)
	{
		FLLink fllink=new FLLink(data);
		
		if(firstlink==null)
		{
			firstlink=fllink;
		}
		else
		{
			lastlink.next=fllink;
			lastlink=fllink;
		}
	}
	
	public FLLink deleteFirst()
	{
		FLLink temp=null;
		
		if(firstlink==null)
			return null;
		
		if(firstlink.next==null)
			lastlink=null;//没有考虑只有一个元素的情况
		
		temp=firstlink;
		firstlink=firstlink.next;
		return temp;
	}
	
	public void displayList()
	{
		System.out.print("list(first --> last): ");
		FLLink current=firstlink;
		while(current!=null)
		{
			current.displayFLLink();
			current=current.next;
		}
		System.out.println("");
	}
}
