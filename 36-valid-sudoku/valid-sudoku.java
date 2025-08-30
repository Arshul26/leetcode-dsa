// Approach-3 (using 3 boolean arrays: rows[9][9], cols[9][9], boxes[9][9]), which gives O(1) space without HashSet overhead
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                int num = board[i][j] - '1';  // convert '1'..'9' → 0..8
                int boxIndex = (i / 3) * 3 + (j / 3);

                if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                    return false; // duplicate found
                }

                rows[i][num] = true;
                cols[j][num] = true;
                boxes[boxIndex][num] = true;
            }
        }
        return true;
    }
}

// | Approach                       | TC    | SC                      | Remarks                         |
// | ------------------------------ | ----- | ----------------------- | ------------------------------- |
// | **1 (3 passes)**               | O(N²) | O(N)                    | Simple, 3 iterations            |
// | **2 (HashSet, 1 pass)**        | O(N²) | O(N²)                   | Clever but heavier space        |
// | **3 (Boolean arrays, 1 pass)** | O(N²) | O(N²) but tiny constant | Fastest & most memory-efficient |




// //Approach-2 (One iteration using hashmap and indexing boxes)
// class Solution {
//     public boolean isValidSudoku(char[][] board) {
//         Set<String> st = new HashSet<>();

//         for (int i = 0; i < 9; i++) {
//             for (int j = 0; j < 9; j++) {
//                 if (board[i][j] == '.') continue;

//                 String row = board[i][j] + "_row_" + i;
//                 String col = board[i][j] + "_col_" + j;
//                 String box = board[i][j] + "_box_" + (i / 3) + "_" + (j / 3);

//                 if (st.contains(row) || st.contains(col) || st.contains(box)) {
//                     return false;
//                 }

//                 st.add(row);
//                 st.add(col);
//                 st.add(box);
//             }
//         }

//         return true;
//     }
// }


// //Approach-1 (Naive and simplest using 3 iterations of the sudoku)
// class Solution {

//     // helper to validate a 3x3 sub-box
//     private boolean validSub(char[][] board, int sr, int er, int sc, int ec) {
//         Set<Character> st = new HashSet<>();
//         for (int row = sr; row <= er; row++) {
//             for (int col = sc; col <= ec; col++) {
//                 char ch = board[row][col];
//                 if (ch == '.') continue;
//                 if (st.contains(ch)) return false;
//                 st.add(ch);
//             }
//         }
//         return true;
//     }

//     public boolean isValidSudoku(char[][] board) {
//         // validate rows
//         for (int row = 0; row < 9; row++) {
//             Set<Character> st = new HashSet<>();
//             for (int col = 0; col < 9; col++) {
//                 char ch = board[row][col];
//                 if (ch == '.') continue;
//                 if (st.contains(ch)) return false;
//                 st.add(ch);
//             }
//         }

//         // validate columns
//         for (int col = 0; col < 9; col++) {
//             Set<Character> st = new HashSet<>();
//             for (int row = 0; row < 9; row++) {
//                 char ch = board[row][col];
//                 if (ch == '.') continue;
//                 if (st.contains(ch)) return false;
//                 st.add(ch);
//             }
//         }

//         // validate each 3x3 box
//         for (int sr = 0; sr < 9; sr += 3) {
//             int er = sr + 2;
//             for (int sc = 0; sc < 9; sc += 3) {
//                 int ec = sc + 2;
//                 if (!validSub(board, sr, er, sc, ec)) {
//                     return false;
//                 }
//             }
//         }

//         return true;
//     }
// }
