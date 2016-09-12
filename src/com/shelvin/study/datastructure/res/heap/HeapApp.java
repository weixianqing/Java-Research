package com.shelvin.study.datastructure.res.heap;

//�ڶ��У���ǰ����Ĵ�СcurrentSize��һ���ǳ���Ҫ�Ĳ�����Ҳֻ��ͨ���������
//�����ҵ���ʾ�ѵ���ȫ�����������һ���ڵ�

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
		heapArray[currentSize]=node;//��Ҫ���Ǹ�heapArray[currentSize]��ֵ
		trickleUp(currentSize++);//������++
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
		
		while(index>=0 && index<(currentSize/2))//************************index<(currentSize/2)[�ж�������һ���ӽڵ�]��û��Ū����***************************8
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
			
			if(top.get()>=heapArray[largerChild].get())//��Ҫ�������۸��ڵ�������ӽڵ㶼������
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