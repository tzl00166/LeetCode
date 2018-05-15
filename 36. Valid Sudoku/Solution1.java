 class Solution {
    public boolean isValidSudoku(char[][] board) {
               
        //Each column must contain the digits 1-9 without repetition
        for (int i = 0; i < 9; i++){
            char[] block = board[i];
            boolean result = check(block);
            if (result == false)
                return false;
        }
        
        //Each row must contain the digits 1-9 without repetition
        char[][] reve = new char[9][9];
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                reve[i][j] = board[j][i];
            }
        }
        for (int i = 0; i < 9; i++){
            char[] block = reve[i];
            boolean result = check(block);
            if (result == false)
                return false;
        }
        
        //Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition
        
        return true;
    }
    
    public boolean check(char[] block){
        Set<Character> store = new HashSet<>();
        for (int i = 0; i < block.length; i++){
            if (!store.add(block[i]) && (block[i] != '.'))
                return false;
        }
        return true;
    }
}