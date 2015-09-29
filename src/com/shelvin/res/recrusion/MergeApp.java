package com.shelvin.res.recrusion;

public class MergeApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeApp ma=new MergeApp();
		int[] arr={2,9,3,10,7,26,32,16,7,38,90,39};
		int beginIndex=0;
		int endIndex=arr.length-1;
		
		System.out.print("original arr: ");
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		
		ma.mergeSort(arr, beginIndex, endIndex);
		
		System.out.println();
		System.out.print("sorted arr: ");
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}

	public void mergeSort(int[] arr,int beginIndex,int endIndex)
	{
		if(beginIndex==endIndex)
		{
			return;
		}
		else
		{
			int midIndex=(beginIndex+endIndex)/2;
			mergeSort(arr, beginIndex, midIndex);
			mergeSort(arr, midIndex+1, endIndex);
			merge(arr, beginIndex, midIndex+1, endIndex);
		}
		
//		System.out.println(" ");
//		for(int i=0;i<arr.length;i++)
//		{
//			System.out.print(arr[i]+" ");
//		}
		
	}
	
	public void merge(int[] arr,int lowPtr,int highPtr,int endIndex)
	{
		int i=0;
		int maxSize=endIndex+1;
		int[] sortedArr=new int[maxSize];
		int midIndex=highPtr-1;
		int n=endIndex-lowPtr+1;
		int lowBound=lowPtr;
		
		while(lowPtr<=midIndex && highPtr<=endIndex)
		{
			if(arr[lowPtr]<arr[highPtr])
			{
				sortedArr[i++]=arr[lowPtr++];
			}
			else
			{
				sortedArr[i++]=arr[highPtr++];
			}
		}
		
		while(lowPtr<=midIndex)
		{
			sortedArr[i++]=arr[lowPtr++];
		}
		
		while(highPtr<=endIndex)
		{
			sortedArr[i++]=arr[highPtr++];
		}
		
		for(i=0;i<n;i++)
		{
			//mistake:arr[i]=sortedArr[i];
			arr[lowBound+i]=sortedArr[i];
		}
	}
	
	
}
