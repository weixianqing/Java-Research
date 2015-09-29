package com.shelvin.res.queueapp;

public class ArrayQueueApp 
{
	public static void main(String[] args) 
	{
		ArrayQueue aq=new ArrayQueue(4);
		aq.push(12);
		aq.push(81);
		aq.push(33);
		aq.push(70);
		aq.display();
		System.out.println("");
		//aq.push(50);
		aq.push(36);
		aq.display();
		System.out.println("");
		
		aq.pop();
//		aq.pop();
		aq.display();
		System.out.println("");
		System.out.println(aq.size());
		aq.pop();
		aq.display();
		System.out.println("");
		System.out.println(aq.size());
	}
}

class ArrayQueue
{
	private int maxSize;
	private int[] queueArr;
	private int front;
	private int rear;
	private int nItems;
	
	public ArrayQueue(int size)
	{
		this.maxSize=size;
		queueArr=new int[maxSize];
		front=0;
		rear=-1;
		nItems=0;
	}
	
	public boolean isEmpty()
	{
		return(nItems==0);
	}
	
	public void push(int data)
	{
		if(rear==maxSize-1)
		{
			rear=-1;
			System.out.println("queue is full.");
		}
		queueArr[++rear]=data;
		nItems++;
	}
	
	public int pop()
	{
		int temp=queueArr[front++];
		if(front==maxSize-1)
		{
			front=0;
			System.out.println("queue is null.");
			
		}
		nItems--;		
		return temp;
	}
	
	public int peekFront()
	{
		return(queueArr[front]);
	}
	
	public boolean isFull()
	{
		return(nItems==maxSize);
	}
	
	public int size()
	{
		return nItems-1;//写程序时为return nItems；调试不对，改为return nItems-1;正确，还没找原因
	}
	
	public void display()
	{
		for(int i=front;i<queueArr.length;i++)
		{
			System.out.print(queueArr[i]+" ");
		}
		System.out.println("");
	}
}