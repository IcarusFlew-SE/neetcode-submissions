class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] subMatrix = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.'){
                    continue;
                }
                int val = board[i][j] - 0;
                int pos = 1 << (val - 1);

                if((rows[i] & pos) > 0)
                    return false;
                rows[i] |= pos;

                if ((cols[j] & pos) > 0)
                    return false;
                cols[j] |= pos;

                int index = (i / 3) * 3 + j / 3;

                if ((subMatrix[index] & pos) > 0){
                    return false;
                }
                subMatrix[index] |= pos;
            }
        }
        return true;
    }
}
