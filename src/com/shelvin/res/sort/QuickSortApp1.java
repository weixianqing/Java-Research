package com.shelvin.res.sort;

public class QuickSortApp1
{
	
}

class QuickSortArray
{
	private int sData;
	private int maxSize;
	private int[] sArr;
	
	public QuickSortArray(int size)
	{
		this.maxSize=size;
		sArr=new int[maxSize];;
	}
	
	public void insert(int data)
	{
		int i=0;
		
		sData=data;		
		if(i<maxSize)
		{
			sArr[i++]=sData;
		}
		else
		{
			System.out.println("array out of index range!");
		}
	}
	
	public void printOriginal()
	{
		for(int i=0;i<maxSize;i++)
		{
			System.out.print("original array is:");
			System.out.print(" "+sArr[i]);
			System.out.println();
		}
	}
	
	public int partition(int left,int right,int pivot)
	{
		int leftPtr=left-1;
		int rightPtr=right;
		
		while(true)
		{
			while(leftPtr<right && sArr[++leftPtr]<pivot)
				;
			while(rightPtr>left && sArr[--rightPtr]>pivot)
				;
			if(leftPtr>=rightPtr)
			{
				break;
			}
			swap(leftPtr,rightPtr);
		}
		swap(leftPtr,pivot);
		
		return leftPtr;
	}
	
	public void swap(int index1,int index2)
	{
		int temp=sArr[index1];
		sArr[index1]=sArr[index2];
		sArr[index2]=temp;
	}
	
	public void recQuickSort(int left,int right)
	{
		if(left>=right)
		{
			return;
		}
		else
		{
			int pivot=sArr[right];
			
			int parPtr=partition(left, right, pivot);	
			recQuickSort(left,parPtr-1);
			recQuickSort(parPtr+1, right);
		}
	}
	
	public void quickSort()
	{
		int left=0;
		int right=maxSize-1;
		recQuickSort(left, right);
	}
}