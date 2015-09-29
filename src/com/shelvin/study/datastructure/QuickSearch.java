package com.shelvin.study.datastructure;

public class QuickSearch {
	
	public static void main(String[] args)
	{
		int[] num = new int[]{72,6,57,88,60,42,83,73,49,85};
		int l = 0;
		int h = num.length-1;
		QuickSearch qs = new QuickSearch();
		int[] s = qs.QuickSort(num, l,h);
		for(int i=0;i<s.length;i++)
		{
			System.out.println(s[i]);
		}
	}
	
	public int AdjustArray(int[] num,int l,int h)
	{
		int i=l;
		int j=h;		
		int x=0;
		
		x=num[i];
		while(i<j)
		{
			while(i<j && x<num[j])
			{
				j--;
			}
			if(x>num[j])
			{
				num[i]=num[j];
				i++;
			}
			
			while(i<j && x>num[i])
			{
				i++;
			}
			if(x<num[i])
			{
				num[j]=num[i];
				j--;
			}
		}
		
		num[i]=x;
		return i;
	}
	
	public int[] QuickSort(int[] num,int l,int h)
	{
		if(l<h)
		{
			int i = AdjustArray(num, l, h);
			num = QuickSort(num, l, i-1);
			num = QuickSort(num, i+1, h);
		}
				
		return num;
	}
	
	
}
