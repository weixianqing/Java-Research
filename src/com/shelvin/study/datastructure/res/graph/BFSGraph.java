package com.shelvin.study.datastructure.res.graph;

public class BFSGraph 
{
	
}

//class BFS
//{
//	
//}

class BQueue
{
	private int[] arrQueue;
	private final int qSize=100;
	private int front;
	private int rear;
	private int qNum;
	
	public BQueue()
	{
		arrQueue=new int[qSize];
		front=0;
		rear=-1;
		qNum=0;
	}
	
	public void pushLast(int vNum)
	{
		arrQueue[++rear]=vNum;
		qNum++;
	}
	
	public int popFirst()
	{
		int temp=arrQueue[front++];
		qNum--;
		if(front==qSize)
		{
			front=0;
		}
		return temp;
	}
	
	public boolean isEmpty()
	{
		return(qNum==0);
	}
}

class BVertex
{
	private char vName;
	private boolean isVisited;
	
	public BVertex()
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

class BGraph
{
	private BVertex vertex;
	private int vNum;
	private int maxSize;
	private BVertex[] arrVertex;
	private int[][] adjMat;
	private BQueue bqueue;
	
	public BGraph(int vSize)
	{
		vertex=new BVertex();
		vNum=0;
		maxSize=vSize;
		arrVertex=new BVertex[maxSize];
		adjMat=new int[maxSize][maxSize];
		bqueue=new BQueue();
		
		for(int i=0;i<maxSize;i++)
		{
			for(int j=0;j<maxSize;j++)
			{
				adjMat[i][j]=0;	
			}
		}
	}
	
	public void addVertex(char vName)
	{
		vertex.setvName(vName);
		arrVertex[vNum++]=vertex;
	}
	
	public void addEdge(int start,int end)
	{
		adjMat[start][end]=1;
		adjMat[end][start]=1;
	}
	
	public void printVertex(int number)
	{
		System.out.print(arrVertex[number].getvName()+" ");
	}

	public int getAdjUnvisitedVertex(int vNum)
	{
		for(int i=0;i<maxSize;i++)
		{
			if(adjMat[vNum][i]==1 && arrVertex[vNum].isVisited()==true)
			{
				return i;
			}
		}
		return -1;
	}
		
	public void BFS()
	{
		int number2;
		arrVertex[0].setVisited(true);
		printVertex(0);
		bqueue.pushLast(0);
		
		while(!bqueue.isEmpty())
		{
			int number1=bqueue.popFirst();

			while((number2=getAdjUnvisitedVertex(number1))!=-1)
			{
				arrVertex[number2].setVisited(true);
				printVertex(number2);
				bqueue.pushLast(number2);
			}
		}
		
		for(int i=0;i<arrVertex.length;i++)
		{
			arrVertex[i].setVisited(false);
		}
	}
}