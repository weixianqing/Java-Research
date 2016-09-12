package com.shelvin.study.datastructure.res.listapp;

public class DoublyLinkListApp 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		DoublyLinkList dll=new DoublyLinkList();
		dll.insertFirst(21);
		dll.insertFirst(62);
		dll.insertFirst(9);
		dll.insertFirst(29);
		dll.insertFirst(21);
		dll.insertLast(39);
		dll.displayForward();
		dll.displayBackward();
		
//		dll.deleteFirst();
//		dll.deleteFirst();
//		dll.deleteFirst();
//		dll.deleteFirst();
//		dll.displayForward();
//		dll.deleteFirst();
//		dll.displayForward();
//		dll.deleteFirst();
//		dll.displayForward();
		
		
//		dll.deleteLast();
//		dll.deleteLast();
//		dll.deleteLast();
//		dll.deleteLast();
//		dll.deleteLast();
//		dll.deleteLast();
//		dll.displayForward();
//		dll.deleteLast();
//		dll.displayForward();
		
//		dll.insertAfter(9, 100);
//		dll.displayForward();
//		dll.insertAfter(39, 3);
//		dll.displayForward();
		
//		System.out.println(dll.isFindKey(29));
//		System.out.println(dll.isFindKey(80));
		
//		dll.deleteKey(9);
//		dll.displayForward();
//		dll.deleteKey(2);
//		dll.displayForward();
//		dll.deleteKey(21);
//		dll.displayForward();
//		dll.deleteKey(39);
//		dll.displayForward();
//		dll.deleteKey(21);
//		dll.displayForward();
//		dll.deleteKey(29);
//		dll.deleteKey(62);
//		dll.displayForward();
//		dll.deleteKey(62);
//		dll.displayForward();
		
	}

}

class DLink
{
	public int data;
	public DLink next;
	public DLink previous;
	
	public DLink(int data)
	{
		this.data=data;
	}
	
	public void displayLink()
	{
		System.out.print("{"+data+"} ");
	}
}

class DoublyLinkList
{
	private DLink first;
	private DLink last;
	
	public DoublyLinkList()
	{
		first=null;
		last=null;
	}
	
	public boolean isEmpty()
	{
		return(first==null);
	}
	
	public void insertFirst(int data)
	{
		DLink dl=new DLink(data);
		
		if(isEmpty())
		{
			last=dl;
		}
		else
		{
			first.previous = dl;
		}
		dl.next=first;
		first=dl;
		
	}
	
	public void insertLast(int data)
	{
		DLink dl=new DLink(data);
		
		if(isEmpty())
		{
			first=dl;
		}
		else
		{
			last.next=dl;
			dl.previous = last;
		}
			
		last=dl;
	}
	
	public DLink deleteFirst()
	{
		DLink temp=first;
		
		if(isEmpty())
		{
			return null;
		}
		
		if(last==first)
		{
			last=null;
			first=null;
		}
		else
		{
			first.next.previous=first;
			first=first.next;
		}
				
		return temp;
	}
	
	public DLink deleteLast()
	{
		DLink temp=last;
		
		if(isEmpty())
		{
			return null;
		}
		
		if(last==first)
		{
			first=null;
			last=null;
		}else
		{
			last.previous.next=null;
			last=last.previous;
		}
			
		return temp;
	}
	
	public void insertAfter(int key,int data)
	{
		DLink dlink=new DLink(data);
		
		if(isEmpty())
		{
			System.out.println("null list");
			return;
		}
		
		DLink current=first;
		
		while(current!=null && current.data!=key)
		{
			current=current.next;
		}
		
		if(current==null)
		{
			System.out.println("key is not in the list");
			return;
		}
		
		if(current==last)
		{
			insertLast(data);
			return;
		}
		
		current.next.previous=dlink;
		dlink.next=current.next;
		dlink.previous=current;
		current.next=dlink;
	}
	
	public DLink isFindKey(int key)
	{
		DLink find=null;
		
		if(first==null)
		{
			System.out.println("null list");
		}
		
		DLink current=first;
		while(current!=null && current.data!=key)
		{
			current=current.next;
		}
		
		if(current==null)
		{
			return null;
		}
		
		if(current.data==key)
		{
			return(find=current);
		}
		
		return find;
	}
	
	public DLink deleteKey(int key)
	{
		DLink temp=null;
		
		temp=isFindKey(key);
		
		if(temp!=null)
		{
			
			if(temp==first)
			{
				deleteFirst();
			}			
			else if(temp==last)
			{
				deleteLast();
			}
			else
			{
				temp.previous.next=temp.next;
				temp.next.previous=temp.previous;
			}
		}
		
		return temp;
	}
	
	public void displayForward()
	{
		DLink current=first;
		if(first==null)
		{
			System.out.println("null list");
		}
		
		while(current!=null)
		{
			current.displayLink();
			current=current.next;
		}
		
		System.out.println("");
	}
	
	public void displayBackward()
	{
		DLink current=last;
		
		if(last==null)
		{
			System.out.println("null list");
		}
		
		while(current!=null)
		{
			current.displayLink();
			current=current.previous;
		}
	}
}