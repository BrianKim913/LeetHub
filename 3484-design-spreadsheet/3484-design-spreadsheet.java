class Spreadsheet {
    int[][] grid;;
    Map<Character, Integer> map = new HashMap<>();
    public Spreadsheet(int rows) {
        this.grid = new int[rows][26];
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i <alphabet.length(); i++){
            map.put(alphabet.charAt(i),i);
        }
    }
    
    public void setCell(String cell, int value) {
        char col = cell.charAt(0);
        int row = Integer.valueOf(cell.substring(1))-1;

        grid[row][map.get(col)]=value;
    }
    
    public void resetCell(String cell) {
        char col = cell.charAt(0);
        int row = Integer.valueOf(cell.substring(1))-1;

        grid[row][map.get(col)]=0;
    }
    
    public int getValue(String formula) {
        int idx = 0;
        for(char c : formula.toCharArray()){
            if(c=='+') break;
            idx++;
        }
        int X =-1;
        int Y =-1;

        if(!map.containsKey(formula.charAt(1))){
            X = Integer.valueOf(formula.substring(1,idx));
        }
        if(!map.containsKey(formula.charAt(idx+1))){
            Y = Integer.valueOf(formula.substring(idx+1));
        }
        X = (X!=-1) ? X:grid[Integer.valueOf(formula.substring(2,idx))-1][map.get(formula.charAt(1))];
        Y = (Y!=-1) ? Y:grid[Integer.valueOf(formula.substring(idx+2))-1][map.get(formula.charAt(idx+1))];
        return X+Y;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */