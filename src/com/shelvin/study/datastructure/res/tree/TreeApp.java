package com.shelvin.study.datastructure.res.tree;

public class TreeApp
{
    public static void main(String[] args)
    {

    }
}

class Node
{
    public int tData;
    public Node leftChild;
    public Node rightChild;

    public Node(int data)
    {
        tData = data;
    }

    public void printNode()
    {
        System.out.print(tData);
    }
}

class Tree
{
    private Node root;

    public Tree()
    {
        root = null;
    }

    public boolean isEmpty()
    {
        return (root == null);
    }

    public Node find(int data)
    {
        Node current = root;

        if (isEmpty())
        {
            return null;
        }

        while (current.tData != data)
        {
            if (current.tData > data)
            {
                current = current.leftChild;
            } else if (current.tData < data)
            {
                current = current.rightChild;
            }

            if (current == null)
            {
                return null;
            }
        }

        return current;
    }

    public void insert(int data)
    {
        Node current = root;
        Node parent;
        Node insertNode = new Node(data);

        if (isEmpty())
        {
            root.tData = data;
        } else
        {
            while (true)
            {
                parent = current;

                if (current.tData > data)
                {
                    current = current.leftChild;

                    if (current == null)
                    {
                        parent.leftChild = insertNode;
                    }
                } else
                {
                    current = current.rightChild;

                    if (current == null)
                    {
                        parent.rightChild = insertNode;
                    }
                }
            }
        }
    }

    public void delete()
    {

    }

    public void traverse()
    {

    }

    public void print()
    {

    }
}