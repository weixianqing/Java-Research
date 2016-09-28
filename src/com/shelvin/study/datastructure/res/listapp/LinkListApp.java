package com.shelvin.study.datastructure.res.listapp;


public class LinkListApp 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		LinkList ll=new LinkList();
		ll.insertFirst(21);
		ll.insertFirst(36);
		ll.insertFirst(8);
		ll.insertFirst(86);
		ll.insertFirst(28);
		ll.insertFirst(18);
		ll.insertFirst(8);
		ll.displayList();
		System.out.println("");
		
		LinkList ll2=new LinkList();
		ll2.insertFirst(21);
		ll2.insertFirst(36);
		ll2.insertFirst(8);
		ll2.insertFirst(86);
		ll2.insertFirst(28);
		ll2.insertFirst(18);
		ll2.insertFirst(8);
		ll2.reverseList();
		ll2.displayList();
		
//		ll.deleteFirst();
//		System.out.println("");
//		ll.displayList();
//		
//		ll.deleteFirst();
//		ll.deleteFirst();
//		System.out.println("");
//		ll.displayList();
//		ll.deleteFirst();
//		System.out.println("");
//		ll.displayList();
//		ll.deleteFirst();
//		ll.displayList();
//		
//		ll.insertFirst(16);
//		System.out.println("");
//		ll.displayList();
		
//		System.out.println("");
//		Link ff1=ll.find(8);
//		System.out.println(ff1.LData);
//		ll.displayList();
//		
//		Link ff2=ll.delete(8);
//		System.out.println("");
//		System.out.println(ff2.LData);
//		ll.displayList();
	}

}

class Link
{
	public int LData;
	public Link LNext;
	
	public Link(int idata)
	{
		LData=idata;
	}
	
	public void displayLink()
	{
		System.out.print("{"+LData+"}");
	}
}

 class LinkList
{
	private Link first;
	
	public LinkList()
	{
		first=null;
	}
	
	public boolean isEmpty()
	{
		return(first==null);
	}
	
	public void insertFirst(int idata)
	{
		Link newlink=new Link(idata);
//		if(first==null)
//		{
//			first=newlink;
//			return;
//		}
		
		
//		if(first==null)
//			first=newlink;
		newlink.LNext=first;
		first=newlink;
	}
	
	public Link deleteFirst()
	{
		Link temp=first;
		if(first==null)
			return null;
		first=first.LNext;
		return temp;
	}
	
	public Link find(int key)
	{
		if(first==null)
		{
			System.out.println("null linklist!");
			return null;
		}
		
		Link currentPoint=first;		
		while(currentPoint.LData!=key)
		{
			if(currentPoint.LNext==null)
			{
				System.out.println("no key "+key+" in this linklist");
				return null;
			}
			else
			{
				currentPoint=currentPoint.LNext;
			}
		}
		
		return currentPoint;
	}
	
	public Link delete(int key)
	{
		Link currentPoint=first;
		Link previousPoint=null;
		
		if(first==null)
		{
			System.out.println("null linklist!");
			return null;
		}
		
		while(currentPoint.LData!=key)
		{
			if(currentPoint.LNext==null)
			{
				System.out.println("no key "+key+" in this linklist");
			}
			else
			{
				previousPoint=currentPoint;
				currentPoint=currentPoint.LNext;
			}
		}
		
		if(currentPoint==first)
		{
			first=first.LNext;//�����������˿��ǣ�ע��
		}
		else
		{
			previousPoint.LNext=currentPoint.LNext;
		}
		
		return currentPoint;
	}
	
	public void reverseList()
	{
		Link current=first;
		while(current.LNext!=null)
		{
			insertFirst(current.LData);
			current=current.LNext;
		}
		if(current.LNext==null)
		{
			insertFirst(current.LData);
		}
		
	}
	
	public void displayList()
	{
		if(first==null)
			return;
		System.out.print("first --> last of the list: ");
		Link currentPoint=first;
		while(currentPoint!=null)
		{
			currentPoint.displayLink();
			currentPoint=currentPoint.LNext;
		}
	}
}
