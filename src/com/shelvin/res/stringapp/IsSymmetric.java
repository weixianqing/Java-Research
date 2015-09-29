package com.shelvin.res.stringapp;

public class IsSymmetric 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String str="goabacog";
		IsSymmetric issymmetric=new IsSymmetric();
		System.out.println(issymmetric.IS(str));

	}
	
	public boolean IS(String str)
	{
		boolean symmetric=false;
		
		int len_str=str.length();
		for(int i=0;i<(len_str/2);i++)
		{
			if(str.substring(i, i+1).equals(str.substring(len_str-1-i, len_str-i)))
			{
				symmetric=true;
			}
			else
			{
				symmetric=false;
				break;
			}
		}
		
		return symmetric;
	}

}
