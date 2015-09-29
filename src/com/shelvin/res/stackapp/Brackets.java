package com.shelvin.res.stackapp;

public class Brackets 
{
	public static void main(String[] args) 
	{
		String input="zhou{xiexiaochen}agw[(agtjeaae)";
		BracketCheck bc=new BracketCheck(input);
		bc.check();
	}
}

class BStack
{
	private int maxsize;
	private char[] words;
	private int top;
	
	public BStack(int maxsize)
	{
		this.maxsize=maxsize;
		top=-1;
		words=new char[this.maxsize];
	}
	
	public boolean isEmpty()
	{
		return(top==-1);
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
}

class BracketCheck
{
	private String input;
	
	public BracketCheck(String input)
	{
		this.input=input;
	}
	
	public void check()
	{
		BStack bs=new BStack(input.length());
		
		for(int i=0;i<input.length();i++)
		{
			char bracket=input.charAt(i);
			switch(bracket)
			{
			case '(':
			case '[':
			case '{':
				bs.push(bracket);
				System.out.println("i="+i+" bracket="+bs.peek());;
				break;
			case ')':
			case ']':
			case '}':
				if(!bs.isEmpty())
				{
					char bc=bs.pop();
					System.out.println("i="+i+" bracket="+bracket);
//					if(bracket=='(' && bc!=')'
//					|| bracket=='[' && bc!=']'
//					|| bracket=='{' && bc!='}')
//上述三行错误，必须是下边这种形式，bracket和bc对于等于和不等于不能改变
					if(bracket==')' && bc!='('
					|| bracket==']' && bc!='['
					|| bracket=='}' && bc!='{')
					{
						System.out.println("match error:"+bracket+" at "+i);
					}
				}
				else
				{
					System.out.println("error:"+bracket+" at "+i);
				}
				break;
			default:
				break;
			}
		}
		
		while(!bs.isEmpty())
		{
			System.out.println("mistake match:"+bs.pop());
			//System.out.println("there is no right delimiter.");
		}
	}
}
