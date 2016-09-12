package com.shelvin.study.datastructure.res.heap;

public class HeapSortApp 
{
	
}

class HeapNode
{
	private int hData;
	
	public HeapNode(int data)
	{
		hData=data;
	}

	public int gethData() {
		return hData;
	}

	public void sethData(int hData) {
		this.hData = hData;
	}
}

class SortHeap
{
	private int maxSize;
	private int currentSize;
	private HeapNode[] hnode;
	
	public SortHeap(int size)
	{
		maxSize=size;
		currentSize=0;
		hnode=new HeapNode[maxSize];
	}
	
	public boolean isEmpty()
	{
		return(currentSize==0);
	}
	
	public HeapNode remove()
	{
		HeapNode root=hnode[0];
		
		hnode[0]=hnode[currentSize--];//--��λ����ǰ���Ǻ�
		trickleDown(0);
		
		return root;
	}
	
	public void trickleDown(int index)
	{
		int largerChild;
		HeapNode top=hnode[index];
		
		while(index<(currentSize/2))//*****************************************
		{
			int leftChild=2*index+1;
			int rightChild=leftChild+1;
			
			if(rightChild<currentSize && hnode[rightChild].gethData()>hnode[leftChild].gethData())
			{
				largerChild=rightChild;
			}
			else
			{
				largerChild=leftChild;
			}
			
			if(hnode[index].gethData()>hnode[largerChild].gethData())
			{
				break;
			}
			
			hnode[index]=hnode[largerChild];
			index=largerChild;
		}
		
		hnode[index]=top;
		
	}
	
	public void insertAt(int index,int data)
	{
		hnode[index].sethData(data);
		trickleDown(index);		
	}
	
	public void incrementSize()
	{
		currentSize++;
	}
	
	public void printHeap()
	{
		
	}
}