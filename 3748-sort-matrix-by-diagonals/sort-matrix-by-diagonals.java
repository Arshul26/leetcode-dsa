class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        //Filling diagonals
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int key = i-j;
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(grid[i][j]);
            }
        }

        // Step 2: Sort diagonals by rule
        for (int k : map.keySet()) {
            List<Integer> diagonal = map.get(k);
            if (k < 0) {
                Collections.sort(diagonal); // ascending
            } else {
                diagonal.sort(Collections.reverseOrder()); // descending
            }
        }

        // Step 3: Reassign values back into grid
        int[][] res = new int[m][n];
        Map<Integer, Integer> indexMap = new HashMap<>(); // pointer per diagonal

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                int idx = indexMap.getOrDefault(key, 0);
                res[i][j] = map.get(key).get(idx);
                indexMap.put(key, idx + 1); // move pointer
            }
        }

        return res;
    }
}
// Step 2 modifies the map in-place (diagonals get sorted directly).
// Step 3 uses indexMap to remember how far we’ve consumed from each diagonal while filling back into the grid.