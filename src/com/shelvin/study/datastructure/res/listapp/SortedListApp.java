package com.shelvin.study.datastructure.res.listapp;

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
//			return;//��return����ѭ��
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
//		previous=slink;//�������д���
		SLink slink=new SLink(data);
		
		//�ձ�
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
		
		//��ͷ����
		if(previous==null)
		{
			slink.next=first;
			first=slink;
		}
		//���в��룬��β���룻��βʱ��previousָ�����һ�����ӵ㣬currentΪnull������whileѭ����ִ�У�previous.nextԭ��Ϊnull������prev.next=slink
		//�þ�ִ�У���slink���뵽��β
		else
		{
			previous.next=slink;
		}//�ϱ�ע�͵��Ĳ������в���ȷ������ȷ���еĲ�֮ͬ���������else����
		
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
