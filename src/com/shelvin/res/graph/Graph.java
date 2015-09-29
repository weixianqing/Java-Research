package com.shelvin.res.graph;

public class Graph 
{	
	int maxSize;
	Vertex [] arrVertex;
	int [][] adjMatrix;
	int nVertexs;
	
	public Graph(int size)
	{
		maxSize=size;
		nVertexs=0;
		arrVertex=new Vertex[maxSize];
		adjMatrix=new int[maxSize][maxSize];
		
		for(int i=0;i<maxSize;i++)
		{
			for(int j=0;j<maxSize;j++)
			{
				adjMatrix[i][j]=0;
			}
		}
	}
	
	public void addVertex(char vertex)
	{
		arrVertex[nVertexs++]=new Vertex(vertex);
	}
	
	public void addEdge(int begin,int end)
	{
		adjMatrix[begin][end]=1;
		adjMatrix[end][begin]=1;
	}
	
	public void printVertex(int v)
	{
		System.out.print(arrVertex[v].getLabel()+" ");
	}
}

class Vertex
{
	private char label;
	private boolean isVisited;
		
	public char getLabel()
	{
		return label;
	}

	public boolean getIsVisited()
	{
		return isVisited;
	}
	
	public void setIsVisited(boolean isVisited)
	{
		this.isVisited=isVisited;
	}
	
	public Vertex(char vName)
	{
		label=vName;
		isVisited=false;
	}
}