package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by shelvin on 29/9/16 at 22:29.
 */

public class SurroundedRegions_130
{
    static final int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final char Free = 'F';
    static final char Travelled = 'T';


    public void solve(char[][] board)
    {
        if (board == null)
        {
            return;
        }

        int row = board.length;
        int column = board[0].length;

        for (int i = 0; i < row; i++)
        {
            bfs(board, i, 0);
            bfs(board, i, column - 1);
        }

        for (int i = 0; i < column; i++)
        {
            bfs(board, 0, i);
            bfs(board, row - 1, i);
        }

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                switch (board[i][j])
                {
                    case 'O':
                        board[i][j] = 'X';
                        break;
                    case 'F':
                        board[i][j] = 'O';
                }
            }
        }
    }

    public void bfs(char[][] board, int x, int y)
    {
        if (board[x][y] != '0')
        {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));

        while (!queue.isEmpty())
        {
            Node temp = queue.poll();
            board[temp.x][temp.y] = Free;
            for (Node node : searchNeighbers(board, temp))
            {
                queue.offer(node);
            }
        }
    }

    public List<Node> searchNeighbers(char[][] board, Node node)
    {
        List<Node> neighbers = new ArrayList<>();
        for (int i = 0; i < 4; i++)
        {
            int x = node.x + direction[i][0];
            int y = node.y + direction[i][1];

            if (x >= 0 && x <= board.length && y >= 0 && y <= board[0].length && board[x][y] == '0')
            {
                board[x][y] = Travelled;
                neighbers.add(new Node(x, y));
            }
        }

        return neighbers;
    }
}

class Node
{
    int x = 0;
    int y = 0;

    public Node(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
