//Approach (Just find the minRow, maxRow, minCol and maxCol where we see 1)
class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length;          // Rows
        int n = grid[0].length;       // Columns

        int minRow = m;
        int maxRow = -1;
        int minCol = n;
        int maxCol = -1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);

                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }
}
//TC = O(m * m)
//SC = O(1)