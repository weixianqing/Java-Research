package com.shelvin.res.stackapp;

public class WordReverse 
{

	public static void main(String[] args) 
	{
		String input="shelvin.zhou";
		Reverse r=new Reverse(input);
		System.out.println("reverse string:"+r.doRev());
	}

}

class WordStack
{
	private int top;
	private char[] words;
	private int maxsize;
	
	public WordStack(int maxsize)
	{
		this.maxsize=maxsize;
		top=-1;
		words=new char[maxsize];
	}
	
	public void push(char word)
	{
		words[++top]=word;
	}
	
	public char pop()
	{
		return(words[top--]);
	}
	
	public char peek()
	{
		return(words[top]);
	}
	
	public boolean isEmpty()
	{
		return(top==-1);
	}
}

class Reverse
{
	private String input;
	private String output;
	
	public Reverse(String input)
	{
		this.input=input;
	}
	
	public String doRev()
	{
		int maxsize=input.length();
		WordStack ws=new WordStack(maxsize);
		if(input!=null)
		{
			for(int i=0;i<input.length();i++)
			{
				ws.push(input.charAt(i));
			}
		}
		else
		{
			System.out.println("null string");
		}
		
		output="";
		while(!ws.isEmpty())
		{
			output=output+ws.pop();	
		}
		
		return output;
	}
}