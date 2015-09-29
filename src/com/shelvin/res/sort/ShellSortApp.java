package com.shelvin.res.sort;


public class ShellSortApp 
{
	public static void main(String[] args) 
	{
		
	}
}

class ShellSortArray
{
	private int sData;
	private int maxSize;
	private int[] sArr;
	
	public ShellSortArray(int size)
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
	
	public void ShellSort()
	{
		int h=1;
		int temp;
		
		while(h<maxSize/3)
		{
			h=3*h+1;
		}
	
//***********************************************************
//这里的h在插入排序中就直接是1，应用在希尔排序中，h变成一个变量，从最初的h=3×h+1
//开始递减，直到h变为1，就变成插入排序
//举例：数组a{3，1，4，0，18，25，7，2，11，4，45}，有上边while可算出h=4，所以
//h=4时，a[0],a[4],a[8]；a[1],a[5],a[9]；a[2],a[6],a[10]；a[3],a[7]进行4-insert排序，然后h递减为1，进行1-insert排序（普通插入排序）
		while(h>0)//该while循环控制h递减，知道h递减为1
		{
			for(int outer=h;h<maxSize;h++)//该for循环保证针对每个特定h，所有的数据都进行h-insert循环
			{
				int inner=outer;
				temp=sArr[outer];
				
				while(inner>(h-1) && sArr[inner-h]>temp)//该while循环就是一个插入排序算法，和普通插入排序相比，h可变，可进行h-insert排序，当h递减为1时，就是普通插入排序
				//inner>(h-1)条件：这其实是插入排序的条件；在插入排序中，假定某个数左边所有数据都已排序，该数右边所有数据都未排序，现在把该数插入到左边排序的数中到适当位置
				//所以，该数要和从该数开始（不包括该数）该数左边的所有数据进行比较，如果找不到合适位置就一直比较，知道找到合适位置或者到达数组0位置，所有这里while条件就要求
			    //这个变换的指针不能数组越界（该指针小于零）；在这里，该指针是inner-h，所以(inner-h)>=0,为了提高运算效率，(inner-h)>=0变为(inner-h)>(-1)，
				//这样就减少了=的比较，降低了比较次数；然后inner>(h-1)
				{
					sArr[inner]=sArr[inner-h];
					inner=inner-h;//每隔h个数据组成的数据序列进行排序，排序方法是插入排序
					//比如h=4时，就是数组中每隔四个数组成的数据序列进行插入排序，然后h递减为1，然后数组中每隔一个数组成数据序列
					//进行插入排序，h=1的插入排序也就是我们理解的普通插入排序。
				}
				
				sArr[inner]=temp;
			}
			
			h=(h-1)/3;
		}
//**************************************************************		
	}
}
