package com.shelvin.study.datastructure.res.stackapp;

public class ArrayStackApp 
{
	public static void main(String[] args) 
	{
		ArrayStack as=new ArrayStack(4);
		as.push(62);
		as.push(36);
		as.push(9);
		as.push(22);	
		as.printStack();
		
		System.out.println(as.pop());
		System.out.println(as.peek());
		System.out.println(as.peek());
		System.out.println(as.pop());
		System.out.println(as.pop());
	}
}

class ArrayStack
{
	private int maxsize;
	private int[] array;
	private int top;
	
	public ArrayStack(int maxsize)
	{
		this.maxsize=maxsize;
		array=new int[maxsize];
		top=-1;
	}
	
	public void push(int data)
	{
		array[++top]=data;
	}
	
	public int pop()
	{
		return(array[top--]);
	}
	
	//get top of stack
	public int peek()
	{
		return(array[top]);
	}
	
	public boolean isEmpty()
	{
		return(top==-1);
	}
	
	public boolean isFull()
	{
		return(top==(maxsize-1));
	}
	
	public void printStack()
	{
		System.out.print("bottom-->top: ");
		for(int i=0;i<array.length;i++)
		{
			System.out.print(array[i]+"  ");
		}
		System.out.println("");
	}
}