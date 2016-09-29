package leetcode;

/**
 * Created by Shelvin Zhou on 2016/9/29 at 19:37.
 * 马走日
 */
public class MaZouRi {

    int[][] move = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
    int ansNum = 1;

    public static void main(String[] args) {
        int[][] board = new int[5][5];
        int count = 1;
        board[0][0] = 1;
        MaZouRi maZouRi = new MaZouRi();
        maZouRi.DFS(board, 0, 0, count);
        return;
    }

    public void DFS(int[][] board, int x, int y, int count) {

        int nextX;
        int nextY;

        for (int i = 0; i < 8; i++) {
            nextX = x + move[i][0];
            nextY = y + move[i][1];

            if (isValide(board, nextX, nextY)) {
                if (count != 5 * 5 - 1) {
                    count++;
                    board[nextX][nextY] = count;
                    DFS(board, nextX, nextY, count);
                    board[nextX][nextY] = 0;
                    count--;
                } else {
                    board[nextX][nextY] = 25;
                    System.out.println("----------------------------------------");
                    System.out.println("solution:" + ansNum++);
                    for (int j = 0; j < 5; j++) {
                        for (int k = 0; k < 5; k++) {
                            System.out.print(board[j][k] + "  ");
                        }
                        System.out.println();
                    }
                    board[nextX][nextY] = 0;
                    System.out.println("------------------------------------------");
                }
            }
        }
    }

    public boolean isValide(int[][] board, int x, int y) {
        if (x >= 0 && x <= 4 && y >= 0 && y <= 4 && board[x][y] == 0) {
            return true;
        }
        return false;
    }
}
