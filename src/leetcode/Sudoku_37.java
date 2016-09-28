package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shelvin Zhou on 2016/9/28 at 13:34.
 */
public class Sudoku_37 {
    public void solveSudoku(char[][] board) {

    }

    public boolean sudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.') {
                    continue;
                }

                for (int k = 0; k < 9; k++) {
                    board[i][j] = (char) (k + '0');
                    if (isValid(board, i, j) && sudoku(board)) {
                        //sudoku(board);放在这里不对
                        //sudoku函数返回的false要用做判断条件判断board[i][j]以后的值是否有不合适的，
                        //如果 i和j后边有的值不合适，说明i和j的位置放k不合适，此时，要把本层递归的board[i][j]的k值修改为'.'
                        //然后k更新为k为k+1，尝试下一个k值。
                        return true;
                    } else {
                        board[i][j] = '.';
                    }
                }
                //该句不要遗漏
                return false;
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int x, int y) {

        Set<Character> contained = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (contained.contains(board[x][i])) {
                return false;
            }
            if (board[x][i] > '0' && board[x][i] <= '9') {
                contained.add(board[x][i]);
            }
        }

        contained = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (contained.contains(board[i][y])) {
                return false;
            }
            if (board[i][y] > '0' && board[i][y] <= '9') {
                contained.add(board[i][y]);
            }
        }

        contained = new HashSet<>();
        int beginX = x / 3 * 3;
        int beginY = y / 3 * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (contained.contains(board[beginX + i][beginY + j])) {
                    return false;
                }
                if (board[beginX + i][beginY + j] > '0' && board[beginX + i][beginY + j] <= '9') {
                    contained.add(board[beginX + i][beginY + j]);
                }
            }
        }

        return true;
    }
}
