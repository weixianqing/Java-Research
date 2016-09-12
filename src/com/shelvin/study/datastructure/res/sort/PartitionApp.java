package com.shelvin.study.datastructure.res.sort;

public class PartitionApp
{
	private int[] pArr;
	private int nElems;
	
	public PartitionApp(int size)
	{
		pArr=new int[size];
	}
	
	public void insert(int data)
	{
		pArr[nElems++]=data;
	}
	
	public int partition(int left,int right,int pivot)
	{
		int leftPtr=left-1;
		int rightPtr=right+1;
		
		while(true)
		{
			while(leftPtr<right && pArr[++leftPtr]<pivot)
				;
			while(rightPtr>left && pArr[--rightPtr]>pivot)
				;
			if(leftPtr>=rightPtr)
			{
				break;
			}
			swap(leftPtr,rightPtr);
		}
		
		return leftPtr;
	}
	
	public void swap(int index1,int index2)
	{
		int temp=pArr[index1];
		pArr[index1]=pArr[index2];
		pArr[index2]=temp;
	}
}