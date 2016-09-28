package com.shelvin.study.datastructure.res.recrusion;

//http://puffsun.iteye.com/blog/1286331

public class KnapsackApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KnapsackApp ka=new KnapsackApp();
		int[] arr={11,8,7,6,5};
		int start=0;
		int sum=20;
		int left=20;
		ka.knapsack(arr, start, sum, left);
	}
	
	public void knapsack(int[] arr,int start,int sum,int left)
	{
		//***************************************
		if(start==arr.length)
		{
			int[] temp=new int[arr.length-1];
			for(int i=0;i<temp.length;i++)
			{
				temp[i]=arr[i+1];
				//System.out.print(temp[i]+" ");
			}
			//System.out.println();
			knapsack(temp, 0, sum, sum);
		}
		//****************************************
		else if(arr[start]==left)
		{
			for(int i=0;i<start+1;i++)
			{
				System.out.print(arr[i]+" ");
			}
		}
		else if(arr[start]<left)
		{
			knapsack(arr, start+1, sum, left-arr[start]);
//			System.out.println("sum:"+sum);
//			System.out.println("left:"+left);
		}
		else
		{
			knapsack(arr, start+1, sum, left);
		}
	}
}
