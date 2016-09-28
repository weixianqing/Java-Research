package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by shelvin on 28/9/16 at 21:06.
 */

public class WordSearchII_212
{
    public int[] dx = {1, 0, -1, 0};
    public int[] dy = {0, 1, 0, -1};

    public ArrayList<String> searchWord2(char[][] board, ArrayList<String> words)
    {
        ArrayList<String> ans = new ArrayList<>();

        TrieNode root = new TrieNode();
        TrieTree trieTree = new TrieTree(root);

        for (String word : words)
        {
            trieTree.insert(word);
        }

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                search(board, i, j, root, ans);
            }
        }

        return ans;
    }

    public void search(char[][] board, int x, int y, TrieNode root, ArrayList<String> ans)
    {
        if (root.isString)
        {
            if (!ans.contains(root.str))
            {
                ans.add(root.str);
            }
        }

        if (x < 0 || x > board.length || y < 0 || y > board[0].length || board[x][y] == '*')
        {
            return;
        }

        if (root.subTree.containsKey(board[x][y]))
        {
            for (int i = 0; i < 4; i++)
            {
                char now = board[x][y];
                board[x][y] = '*';
                search(board, x + dx[i], y + dy[i], root.subTree.get(now), ans);
                board[x][y] = now;
            }
        }
    }
}

class TrieNode
{
    String str;
    boolean isString;
    HashMap<Character, TrieNode> subTree;

    public TrieNode()
    {
        str = "";
        isString = false;
        subTree = new HashMap<>();
    }
}

class TrieTree
{
    TrieNode root;

    public TrieTree(TrieNode root)
    {
        this.root = root;
    }

    public void insert(String string)
    {
        TrieNode now = root;
        for (int i = 0; i < string.length(); i++)
        {
            if (!now.subTree.containsKey(string.charAt(i)))
            {
                now.subTree.put(string.charAt(i), new TrieNode());
            }
            now = now.subTree.get(string.charAt(i));
        }
        now.isString = true;
        now.str = string;
    }

    public boolean find(String string)
    {
        TrieNode now = root;

        for (int i = 0; i < string.length(); i++)
        {
            if (!now.subTree.containsKey(string.charAt(i)))
            {
                return false;
            }
            now = now.subTree.get(string.charAt(i));
        }

        return now.isString;
    }
}

