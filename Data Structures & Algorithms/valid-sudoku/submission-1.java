//bitmasking > HashMapping
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] subMatrix = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.'){ // Blank cells '.'
                    continue;
                }
                // Convert the char character to its actual numeric value (1 to 9)
                int val = board[i][j] - 0;
                int pos = 1 << (val - 1);
                // Check rows, update row mask
                if((rows[i] & pos) > 0) // bitwise AND - Check
                    return false;
                rows[i] |= pos; // bitwise OR - Record
                // Check cols, update column mask
                if ((cols[j] & pos) > 0)
                    return false;
                cols[j] |= pos;
                // Determine the 3x3 subgrid index
                int index = (i / 3) * 3 + j / 3;
                // Check and update the subgrid mask
                if ((subMatrix[index] & pos) > 0){
                    return false;
                }
                subMatrix[index] |= pos;
            }
        }
        return true;
    }
}
