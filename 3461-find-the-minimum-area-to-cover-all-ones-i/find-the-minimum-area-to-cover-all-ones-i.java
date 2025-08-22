//Approach (Just find the minRow, maxRow, minCol and maxCol where we see 1)
class Solution {
    public int minimumArea(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int minRow = row;
        int maxRow = -1;
        int minCol = col;
        int maxCol = -1;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 1){
                    minRow = Math.min(i, minRow);
                    maxRow = Math.max(i, maxRow);
                    minCol = Math.min(j, minCol);
                    maxCol = Math.max(j, maxCol);
                }
            }
        }
        return (maxRow - minRow + 1) *(maxCol - minCol + 1);
    }
}
//TC = O(m * m)
//SC = O(1)