//Approach-2 (One iteration using hashmap and indexing boxes)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> st = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                String row = board[i][j] + "_row_" + i;
                String col = board[i][j] + "_col_" + j;
                String box = board[i][j] + "_box_" + (i / 3) + "_" + (j / 3);

                if (st.contains(row) || st.contains(col) || st.contains(box)) {
                    return false;
                }

                st.add(row);
                st.add(col);
                st.add(box);
            }
        }

        return true;
    }
}


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
