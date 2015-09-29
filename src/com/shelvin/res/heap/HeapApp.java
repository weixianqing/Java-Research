package com.shelvin.res.heap;

//在堆中，当前数组的大小currentSize是一个非常重要的参数，也只有通过这个参数
//才能找到表示堆的完全二叉树的最后一个节点

public class HeapApp 
{
	
}

class Node
{
	private int iData;
	
	public Node(int data)
	{
		iData=data;
	}
	
	public void set(int data)
	{
		iData=data;
	}
	
	public int get()
	{
		return(iData);
	}
}

class Heap
{
	int maxSize;
	int currentSize;
	Node[] heapArray;
	
	public Heap(int size)
	{
		maxSize=size;
		currentSize=0;
		heapArray=new Node[maxSize];
	}
	
	public boolean isEmpty()
	{
		return(currentSize==0);
	}
	
	public boolean insert(int data)
	{
		if(currentSize==maxSize)
		{
			return false;
		}
		Node node=new Node(data);
		heapArray[currentSize]=node;//不要忘记给heapArray[currentSize]赋值
		trickleUp(currentSize++);//忘记了++
		return true;
	}
	
	public void trickleUp(int index)
	{
		Node bottom;
		bottom=heapArray[index];
		
		int parent=(index-1)/2;
		while(index>0 && parent>=0 && heapArray[index].get()>heapArray[parent].get())
		{
			heapArray[index]=heapArray[parent];
			index=parent;
			parent=(parent-1)/2;//
		}
		heapArray[index]=bottom;
	}
	
	public Node remove()
	{
		Node root=heapArray[0];
		
		heapArray[0]=heapArray[currentSize--];//--
		trickleDown(0);
		return root;
	}
	
	public void trickleDown(int index)
	{
		Node top=heapArray[index];
		int largerChild;
		
		while(index>=0 && index<(currentSize/2))//************************index<(currentSize/2)[判断至少有一个子节点]还没有弄明白***************************8
		{
			int leftChild=2*index+1;
			int rightChild=leftChild+1;
			
			if(rightChild<=currentSize && heapArray[leftChild].get()<heapArray[rightChild].get())
			{
				largerChild=rightChild;
			}
			else
			{
				largerChild=leftChild;
			}
			
			if(top.get()>=heapArray[largerChild].get())//不要忘记讨论父节点比两个子节点都大的情况
			{
				break;
			}
			heapArray[index]=heapArray[largerChild];
			index=largerChild;
		}
		
		heapArray[index]=top;
	}
	
	public boolean change(int index,int data)
	{
		if(index>currentSize || index<0)
		{
			return false;
		}
		
		if(data>heapArray[index].get())
		{
			heapArray[index].set(data);
			trickleUp(index);
		}
		else
		{
			heapArray[index].set(data);
			trickleDown(index);
		}
		
		return true;
	}
	
	public void printHeap()
	{
		
	}
}