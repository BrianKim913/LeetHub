class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxs = new HashSet[9];


        for(int i =0; i<9; i++){
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            boxs[i] = new HashSet<Character>();
        }
        for(int i = 0; i<9; i++){
            for(int j=0; j<9; j++){
                char val = board[i][j];
                if(board[i][j]=='.')continue;
                if(rows[i].contains(val)) return false;
                rows[i].add(val);
                if(cols[j].contains(val)) return false;
                cols[j].add(val);
                int grid = (i/3) * 3 + j/3;
                if(boxs[grid].contains(val)) return false;
                boxs[grid].add(val);
            }
        }
        return true;

    }
}