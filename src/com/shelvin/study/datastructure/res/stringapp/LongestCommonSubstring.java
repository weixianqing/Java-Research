package com.shelvin.study.datastructure.res.stringapp;
/*
 * noet 1:������������ int[][] index=new int[4][4]�У�����4��ָ���鳤�ȣ�����д����ʱ
 * �������±�������4���������鳤�Ⱦͳ���5������ǲ��Եġ�
 * note 2���ַ������Ҫ��equals����������==
 * note 3���ַ������ɣ���1�����������ʱ�俪���ܴ󣬳��Է��򣻣�2��������������м䴦����ʱ�俪���ܴ󣬳��Դ��м������ߣ�
*/
public class LongestCommonSubstring 
{
	
	public static void main(String[] args)
	{
		String str1="abcdrtgjfbc";
		String str2="abfcadrtgjffb";
		//System.out.println(str1.length());
//		for(int i=1;i<str1.length();i++)
//		{
//			System.out.println("str1.substring(i, i+1)"+str1.substring(i, i+1));
//		}
		LongestCommonSubstring lcs=new LongestCommonSubstring();
		lcs.LCS(str1, str2);
	}
	
	public void LCS(String str1,String str2)
	{
		int x=0;
		int y=0;
		int len_str1=str1.length();
		//System.out.println("length of str1:"+len_str1);
		int len_str2=str2.length();
		//System.out.println("length of str2:"+len_str2);
		int[][] index=new int[len_str1][len_str2];
		//System.out.println("length of index:"+index.length);
		//System.out.println("length of rows of index:"+index[0].length);
		
		for(int i=0;i<len_str1-1;++i)
		{
			//System.out.println("i:"+i);
			for(int j=0;j<len_str2-1;j++)
			{
				index[i][j]=0;
				//System.out.println("j:"+j);
			}
			//System.out.println("i:"+i);
		}
		
//		for(int i=0;i<len_str1;i++)
//			index[i][0]=0;
//		for(int j=0;j<len_str2;j++)
//			index[0][j]=0;
		
		int max=-1;
		
		for(int i=1;i<len_str1;i++)
		{
			for(int j=1;j<len_str2;j++)
			{
				if(str1.substring(i-1, i).equals(str2.substring(j-1, j)))
				{
					//System.out.println("str1.substring(i,i+1)"+str1.substring(i, i+1));
					//System.out.println("str2.substring(j,j+1)"+str1.substring(j, j+1));
					index[i][j]=index[i-1][j-1]+1;
				}
				else
				{
					index[i][j]=0;
				}
				if(index[i][j]>max)
				{
					max=index[i][j];
					x=i-1;
					y=j-1;
				}
			}
		}
		
		System.out.println("x:"+x);
		System.out.println("y:"+y);
		for(int i=max-1;i>=0;i--)
		{
			System.out.print(str1.substring(x, x+1));
			x--;
		}
	}
}
