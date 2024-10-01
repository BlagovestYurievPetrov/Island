public class Main {
    public static void main(String[] args) {

        int[][] mat = {
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 0, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1}
        };

        int[][] small = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        int[][] noIslands = {
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
        };

        int[][] border = {
                {1, 0, 0},
                {0, 1, 1},
                {0, 0, 1}
        };

        System.out.println("Islands number = " + countIslands(mat));
        System.out.println("Islands number = " + countIslands(small));
        System.out.println("Islands number = " + countIslands(noIslands));
        System.out.println("Islands number = " + countIslands(border));
    }

    public static int countIslands(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            if (mat[i][0] == 1) {
                visitCellsInAllDirections(mat, i, 0, n, m);
            }
            if (mat[i][m - 1] == 1) {
                visitCellsInAllDirections(mat, i, m - 1, n, m);
            }
        }

        for (int j = 0; j < m; j++) {
            if (mat[0][j] == 1) {
                visitCellsInAllDirections(mat, 0, j, n, m);
            }
            if (mat[n - 1][j] == 1) {
                visitCellsInAllDirections(mat, n - 1, j, n, m);
            }
        }

        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (mat[i][j] == 1) {
                    count++;
                    visitCellsInAllDirections(mat, i, j, n, m);
                }
            }
        }
        return count;
    }

    private static void visitCellsInAllDirections(int[][] mat, int x, int y, int n, int m) {
        if (x < 0 || x >= n || y < 0 || y >= m || mat[x][y] == 0) {
            return;
        }

        mat[x][y] = 0;

        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            visitCellsInAllDirections(mat, newX, newY, n, m);
        }
    }

    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
}