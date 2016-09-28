package leetcode;

/**
 * Created by Shelvin Zhou on 2016/9/28 at 18:30.
 */
public class WordSearch_79
{
    public boolean exist(char[][] board, String word)
    {
        if (board.length == 0 || board == null)
        {
            return false;
        }

        if (word.length() == 0)
        {
            return true;
        }

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (board[i][j] == word.charAt(0))
                {
                    boolean res = find(board, i, j, word, 0);
                    if (res)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean find(char[][] board, int i, int j, String word, int index)
    {
        if (i < 0 || i > board.length || j < 0 || j > board[0].length || board[i][j] != word.charAt(index))
        {
            return false;
        }

        board[i][j] = '#';
        boolean rst = find(board, i - 1, j, word, index) || find(board, i + 1, j, word, index)
                || find(board, i, j - 1, word, index) || find(board, i, j + 1, word, index);
        board[i][j] = word.charAt(index);
        return rst;
    }
}
