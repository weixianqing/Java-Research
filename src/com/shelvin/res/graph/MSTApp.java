package com.shelvin.res.graph;

public class MSTApp 
{
	
}

class MStack
{
	private int top;
	private int[] stackArr;
	private int stackSize;
	
	public MStack(int size)
	{
		top=-1;
		stackSize=size;
		stackArr=new int[stackSize];
	}
	
	public void pushFirst(int vNum)
	{
		stackArr[++top]=vNum;
	}
	
	public int popFirst()
	{
		return(stackArr[top--]);
	}
	
	public int peek()
	{
		return(stackArr[top]);
	}
	
	public boolean isEmpty()
	{
		return(top==-1);
	}
}

class MVertex
{
	private char vName;
	private boolean isVisited;
	
	public MVertex()
	{
		isVisited=false;
	}
	
	public char getvName() {
		return vName;
	}
	
	public void setvName(char vName) {
		this.vName = vName;
	}
	
	public boolean isVisited() {
		return isVisited;
	}
	
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
}

class MGraph
{
	private MVertex mvertex;
	private MVertex[] vertexArr;
	private MStack mstack;
	private int stackSize;
	private int nVerts;
	private int[][] adjMat;
	
	public MGraph(int size)
	{
		mvertex=new MVertex();
		stackSize=size;
		vertexArr=new MVertex[stackSize];
		mstack=new MStack(stackSize);
		nVerts=0;
		adjMat=new int[stackSize][stackSize];
		
		for(int i=0;i<stackSize;i++)
		{
			for(int j=0;j<stackSize;j++)
			{
				adjMat[i][j]=0;
			}
		}
	}
	
	public void addVertex(char vName)
	{
		mvertex.setvName(vName);
		vertexArr[nVerts++]=mvertex;
	}
	
	public void addEdge(int start,int end)
	{
		adjMat[start][end]=1;
		adjMat[end][start]=1;
	}
	
	public void printVertex(int vNum)
	{
		System.out.print(vertexArr[vNum].getvName()+" ");
	}
	
	public int getAdjUnvisitedVertex(int vNum)
	{
		for(int i=0;i<stackSize;i++)
		{
			if(adjMat[vNum][i]==1 && vertexArr[vNum].isVisited()==true)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public void MST()
	{
		vertexArr[0].setVisited(true);
		printVertex(0);
		mstack.pushFirst(0);
		
		while(!mstack.isEmpty())
		{
			int curVertex=mstack.peek();
			int vnum=getAdjUnvisitedVertex(curVertex);
			
			if(vnum==-1)
			{
				mstack.popFirst();
			}
			else
			{
				vertexArr[vnum].setVisited(true);
				printVertex(curVertex);
				printVertex(vnum);
				System.out.print(" ");
				mstack.pushFirst(vnum);
			}
		}
		
		for(int i=0;i<stackSize;i++)
		{
			vertexArr[i].setVisited(false);
		}
	}
}
