package com.shelvin.res.sort;

public class QuickSortApp2
{
	
}

class QuickSortArray2
{
	private int sData;
	private int maxSize;
	private int[] sArr;
	
	public QuickSortArray2(int size)
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
	
	public int medianOf3(int left,int right)
	{
		int median=(left+right)/2;
		
		if(sArr[left]>sArr[median])
		{
			swap(left, median);
		}
		
		if(sArr[left]>sArr[right])
		{
			swap(left, right);
		}
		
		if(sArr[median]>sArr[right])
		{
			swap(median, right);
		}
		
		//源代码中为什么加一个swap(median,right-1)
		return sArr[median];
	}
	
	public void recQuickSort(int left,int right)
	{
		int size=right-left+1;
		if(size<=3)
		{
			manualSort(left, right);
		}
		else
		{
			int median=medianOf3(left, right);
			int pivot=median;
			
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
	
	//仔细理解三个元素的时候为什么不能用快排
	public void manualSort(int left,int right)
	{
		int size=right-left+1;
		
		if(size<=1)
		{
			return;
		}
		else if(size==2)
		{
			if(sArr[left]>sArr[right])
			{
				swap(left, right);
			}
		}
		else
		{
			medianOf3(left, right);
		}
		
	}
}