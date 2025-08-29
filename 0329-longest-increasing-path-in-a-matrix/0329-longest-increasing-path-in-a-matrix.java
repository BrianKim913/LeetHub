class Solution {
    int[][]mem;
    int[][]grid;
    int ROWS;
    int COLS;
    
    public int dfs(int row, int col){
        
        if(row<0 || row>ROWS-1 || col<0 || col>COLS-1){
            return 0; 
        }
        
        if(mem[row][col] > 0) return mem[row][col];
        
        int maxPath = 1;
        int curr = grid[row][col];
        

        if(row-1 >= 0 && grid[row-1][col] > curr) {
            maxPath = Math.max(maxPath, 1 + dfs(row-1, col));
        }
        if(col+1 < COLS && grid[row][col+1] > curr) {
            maxPath = Math.max(maxPath, 1 + dfs(row, col+1));
        }
        if(row+1 < ROWS && grid[row+1][col] > curr) {
            maxPath = Math.max(maxPath, 1 + dfs(row+1, col));
        }
        if(col-1 >= 0 && grid[row][col-1] > curr) {
            maxPath = Math.max(maxPath, 1 + dfs(row, col-1));
        }
        
        mem[row][col] = maxPath;
        return maxPath;
    }

    public int longestIncreasingPath(int[][] mat) {
        this.ROWS = mat.length;
        this.COLS = mat[0].length;
        this.mem = new int[ROWS][COLS];
        this.grid = mat;
        int res = 0;
        
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                int output = dfs(i, j);
                res = Math.max(res, output);
            }
        }
        return res;
    }
}