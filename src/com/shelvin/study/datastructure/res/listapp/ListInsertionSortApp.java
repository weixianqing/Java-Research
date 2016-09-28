package com.shelvin.study.datastructure.res.listapp;

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
		first=null;//��Ҫ��ʼ������Ϊ���ǹ��캯����������������ϱ��Ǹ�Ҳ�ǹ�������û�в���������ϵͳ
		//����������캯��ʱ��Ҳ��Ҫ��first���г�ʼ�����и�������Ҫʵ��ȷ������ϵͳ��ʽ����������������
		//�Ĺ�����ʱ���ϱ߲���Ϊ�յĹ������Ƿ���ã���ϵͳ��ʽ�����������������Ĺ�����ʱ��ϵͳĬ�Ϲ������Ƿ���ã�
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
//while(current!=null)��������Ѿ�����±�if��first=linkArr�Ѿ���������Ϊ�յ������
		
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

