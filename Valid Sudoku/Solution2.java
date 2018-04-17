class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> collection = new HashSet<>();
        for (int i = 0; i < 9; i ++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.'){
                    if ((!collection.add(board[i][j] + " in row " + j)) || 
                       (!collection.add(board[i][j] + " in column " + i)) ||
                       (!collection.add(board[i][j] + " in block " + i/3 + j/3)))
                        return false;
                }
            }
        }
        
        return true;
    }
}