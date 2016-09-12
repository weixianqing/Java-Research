package com.shelvin.study.datastructure.res.queueapp;

public class PriorityQueueApp 
{
	public static void main(String[] args)
	{
		PriorityQueue pq=new PriorityQueue(5);
		pq.insert(30);
		pq.insert(50);
		pq.insert(10);
		pq.insert(40);
		pq.insert(20);
		
		while(!pq.isEmpty())
		{
			System.out.print(pq.remove()+" ");
		}
	}
}

class PriorityQueue
{
	private int[] pArr;
	private int maxSize;
	private int nItems;
	
	public PriorityQueue(int size)
	{
		maxSize=size;
		pArr=new int[maxSize];
		nItems=0;
	}
	
	public boolean isEmpty()
	{
		return(nItems==0);
	}
	
	public void insert(int data)
	{
		int i;
		
		if(isEmpty())
		{
			pArr[nItems++]=data;
		}
		else
		{
			for(i=nItems-1;i>=0;i--)//���������Ϊ�˷��������ƶ�
			{
				if(data>pArr[i])
				{
					pArr[i+1]=pArr[i];//****************
				}
				else
				{
					break;
				}	
			}
			pArr[i+1]=data;
			nItems++;
		}
	}
	
	public int remove()
	{
		return(pArr[--nItems]);
	}
}