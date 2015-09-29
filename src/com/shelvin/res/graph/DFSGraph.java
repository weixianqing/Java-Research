	package com.shelvin.res.graph;

public class DFSGraph
{
	public static void main(String[] args)
	{
		DFS dfs=new DFS();
		dfs.addV('a');
		dfs.addV('b');
		dfs.addV('c');
		dfs.addV('d');
		dfs.addV('e');
		
		dfs.addE(0, 1);
		dfs.addE(1, 2);
		dfs.addE(0, 3);
		dfs.addE(3, 4);
		//dfs.addE(2, 4);该测试将图变为连通图，该代码处理不好，还要做改进
		
		dfs.DFSearch();
	}
}

class DFS 
{
	private int size=20;
	private int gsize=30;
	private Stack gStack;
	private Graph graph;
	
	public DFS()
	{
		gStack=new Stack(size);
		graph=new Graph(gsize);
	}
	
	public void addV(char label)
	{
		graph.addVertex(label);
	}
	
	public void addE(int begin,int end)
	{
		graph.addEdge(begin, end);
	}
	
	public int getAdjUnvisitedVertex(int v)
	{
		for(int i=0;i<graph.maxSize;i++)
		{
			if(graph.adjMatrix[v][i]==1 && graph.arrVertex[i].getIsVisited()==false)
			{
				return i;				
			}
		}
		return -1;
	}
	
	public void DFSearch()
	{
		graph.arrVertex[0].setIsVisited(true);
		//graph.printVertex(0);
		gStack.push(0);
		
		while(!gStack.isEmpty())
		{
			if(gStack.top==0)
			{
				System.out.println();
				graph.printVertex(0);
			}
			//System.out.println("top="+gStack.top);
			//System.out.println("gStack.peek()="+gStack.peek());
			int i=getAdjUnvisitedVertex(gStack.peek());
			//System.out.println("i="+i);
			if(i==-1)
			{
				gStack.pop();
			}
			else
			{
				graph.arrVertex[i].setIsVisited(true);
				graph.printVertex(i);
				gStack.push(i);
				//System.out.println("top="+gStack.top);
			}			
		}
		//System.out.println("");
		
		for(int i=0;i<(graph.nVertexs);i++)
		{
			graph.arrVertex[i].setIsVisited(false);
		}
	}
}

class Stack
{
	private int maxSize;
	private int[] arrStack;
	int top;
	
	public Stack(int size)
	{
		maxSize=size;
		arrStack=new int[maxSize];
		top=-1;
	}
	
	public void push(int vertexNum)
	{
		arrStack[++top]=vertexNum;
	}
	
	public int pop()
	{
		return(arrStack[top--]);
	}
	
	public int peek()
	{
		return(arrStack[top]);
	}
	
	public boolean isEmpty()
	{
		return(top==-1);
	}
}