package com.shelvin.study.datastructure.res.listapp;
/*
 * note1��˫������������һ�����ӵ㣬��������ӵ㣬�����ڶ���
 * ���ӵ�FLLinkʱ��
 * public FLLink firstlink;
 * public FLLink lastlink;
 * ���������ǲ��Եģ�������һ�����ӵ���������������ã��������������ӵ㣬ʵ����ֻ
 * public FLLink fllink;�Ϳ��ԣ��������ӵ�Ӧ�����ڶ���˫��������ʱ����һ��first���ӵ㣬����һ��last���ӵ�
 * private FLLink firstlink;
 * private FLLink lastlink;��������Ƕ������������ӵ�
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
			lastlink = null;
		
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
