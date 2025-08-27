class Solution {
    int[][] grid;
    int rows;
    int cols;
    //1=top left, 2= top right, 3=bottom-right 4=bottom-left
    public int dp(int i, int j){
        int count = 1;
        
        count = Math.max(count, diaSeq(i-1,j-1,1,1,false, 2));
        count = Math.max(count, diaSeq(i-1,j+1,2,1,false, 2));
        count = Math.max(count, diaSeq(i+1,j+1,3,1,false, 2));
        count = Math.max(count, diaSeq(i+1,j-1,4,1,false, 2));
        
        return count;
    }

    public int diaSeq(int i, int j, int d, int c, boolean t, int v){
        if(i<0 || i>=rows || j<0 || j>=cols) return c;
        
        if(grid[i][j] != v) return c;
        
        int count = c + 1;
        int nextVal = (v == 2) ? 0 : 2; 
        
        int result = count;
        
        // 1. 같은 대각 방향으로 진행
        int nextI = i, nextJ = j;
        switch (d){
            case 1: nextI = i-1; nextJ = j-1; break;
            case 2: nextI = i-1; nextJ = j+1; break;
            case 3: nextI = i+1; nextJ = j+1; break;
            case 4: nextI = i+1; nextJ = j-1; break;
        }
        result = Math.max(result, diaSeq(nextI, nextJ, d, count, t, nextVal));
        
        // 2. 시계방향으로 90도 전환
        if(!t) {
            int newDir = (d == 4) ? 1 : d + 1; 
            int turnI = i, turnJ = j;
            switch(newDir){
                case 1: turnI = i-1; turnJ = j-1; break;
                case 2: turnI = i-1; turnJ = j+1; break;
                case 3: turnI = i+1; turnJ = j+1; break;
                case 4: turnI = i+1; turnJ = j-1; break;
            }
            result = Math.max(result, diaSeq(turnI, turnJ, newDir, count, true, nextVal));
        }
        
        return result;
    }

    public int lenOfVDiagonal(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        int res = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    res = Math.max(res,dp(i,j));
                }
            }
        }

        return res;
    }
}