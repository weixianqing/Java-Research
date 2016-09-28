package com.shelvin.study.datastructure.res.unionfind;

/**
 * Created by shelvin on 22/8/16 at 22:23.
 */

public class UnionFind
{
    private int[] id;
    private int count;
    //as weights for subtree with unequal number of nodes
    private int[] weighted;

    public UnionFind(int N)
    {
        count = N;
        for (int i = 0; i < count; i++)
        {
            id[i] = i;
        }

        for (int i = 0; i < count; i++)
        {
            weighted[i] = 1;
        }
    }

    public int getCount()
    {
        return count;
    }

    public int quickfindFind(int p)
    {
        return id[p];
    }

    public void quickfindUnion(int p, int q)
    {
        int pID = quickfindFind(p);
        int qID = quickfindFind(q);
        if (pID == qID)
        {
            return;
        }

        for (int i = 0; i < count; i++)
        {
            if (id[i] == pID)
            {
                id[i] = qID;
            }
        }

        count--;
    }

    public int quickunionFind(int p)
    {
        while (id[p] != p)
        {
            p = id[p];
        }

        return p;
    }

    public void quickunionUnion(int p, int q)
    {
        int pRoot = quickunionFind(p);
        int qRoot = quickunionFind(q);
        if (pRoot == qRoot)
        {
            return;
        }
        id[pRoot] = qRoot;
        count--;
    }

    public void weightedquickunionUnion(int p, int q)
    {
        int pRoot = quickunionFind(p);
        int qRoot = quickfindFind(q);
        if (pRoot == qRoot)
        {
            return;
        }

        if (weighted[pRoot] > weighted[qRoot])
        {
            id[qRoot] = pRoot;
            weighted[pRoot] += weighted[qRoot];
        } else
        {
            id[pRoot] = qRoot;
            weighted[qRoot] += weighted[pRoot];
        }

        count--;
    }

    public int optimalFind(int p)
    {
        //path compression
        while (p != id[p])
        {
            id[p] = id[id[p]];
            p = id[p];
        }

        return p;
    }
}
