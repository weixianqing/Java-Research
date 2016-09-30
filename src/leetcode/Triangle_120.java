package leetcode;


/**
 * Created by Shelvin Zhou on 2016/9/30 at 18:46.
 */
public class Triangle_120 {

    //top-down
    public int minPathSum1(int[][] triangle) {
        if (triangle == null && triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null && triangle[0].length == 0) {
            return -1;
        }

        int len = triangle.length;
        int[][] fun = new int[len][len];
        fun[0][0] = triangle[0][0];

        for (int i = 1; i < len; i++) {
            fun[i][0] = fun[i - 1][0] + triangle[i][0];
            fun[i][i] = fun[i - 1][i - 1] + triangle[i][i];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j < i; j++) {
                fun[i][j] = Math.min(fun[i - 1][j], fun[i - 1][j - 1]) + triangle[i][j];
            }
        }

        int best = fun[len - 1][0];
        for (int i = 1; i < len; i++) {
            best = Math.min(best, fun[len - 1][i]);
        }

        return best;
    }


    //down-top
    public int minPathSum2(int[][] triangle) {

        if (triangle == null && triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null && triangle[0].length == 0) {
            return -1;
        }

        int len = triangle.length;
        int[][] fun = new int[len][len];
        fun[0][0] = triangle[0][0];

        for (int i = 0; i < len; i++) {
            fun[len - 1][i] = triangle[len - 1][i];
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                fun[i][j] = Math.min(fun[i + 1][j], fun[i + 1][j + 1]) + triangle[i][j];
            }
        }

        return fun[0][0];
    }

    //memorization
    public int dfsSearch(int[][] triangel, int[][] minSum, int x, int y) {
        if (x >= minSum.length) {
            return 0;
        }

        if (minSum[x][y] != Integer.MAX_VALUE) {
            return minSum[x][y];
        }

        minSum[x][y] = Math.min(dfsSearch(triangel, minSum, x + 1, y), dfsSearch(triangel, minSum, x + 1, y + 1)) + triangel[x][y];

        return minSum[x][y];
    }

    public int minPathSum3(int[][] triangle) {

        if (triangle == null && triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null && triangle[0].length == 0) {
            return -1;
        }

        int len = triangle.length;
        int[][] minSum = new int[triangle.length][triangle.length];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                minSum[i][j] = Integer.MAX_VALUE;
            }
        }

        return dfsSearch(triangle, minSum, 0, 0);
    }
}
