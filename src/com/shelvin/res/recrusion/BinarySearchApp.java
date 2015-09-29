package com.shelvin.res.recrusion;

public class BinarySearchApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1,3,5,9,12,21,36,40,51,66,78,86,98,132};
		int key=7;
		int beginIndex=0;
		int endIndex=arr.length-1;
		//System.out.println(endIndex);
		//System.out.println(arr.length);
		//System.out.println(BinarySearch(arr, key, beginIndex, endIndex));
		BinarySearch(arr, key, beginIndex, endIndex);
	}
	
	public static int BinarySearch(int[] arr,int key,int beginIndex,int endIndex)
	{
		int midIndex=(beginIndex+endIndex)/2;
		//System.out.println(midIndex);
		if(beginIndex>endIndex)
		{
			return -1;
		}
		if(key==arr[midIndex])
		{
			return midIndex;
		}
		else if(key<arr[midIndex])
		{
			//System.out.println(BinarySearch(arr, key, beginIndex, midIndex-1));
			return BinarySearch(arr, key, beginIndex, midIndex-1);
		}
		else
		{
			//System.out.println(BinarySearch(arr, key, midIndex+1, endIndex));
			return BinarySearch(arr, key, midIndex+1, endIndex);
		}
	}

}
