class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] != '.'){
                    char c = board[i][j];
                    String row = c +"in row" + i;
                    String col = c +"in col" + j;
                    String box = c +"in box" + i/3 +"-"+j/3;
                
                if(!seen.add(row) || !seen.add(col) ||!seen.add(box)){
                    return false;
                }
                }
            }
        }
        return true;
    }
}
