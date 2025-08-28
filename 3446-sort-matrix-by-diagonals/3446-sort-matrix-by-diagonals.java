class Solution {
    public int[][] sortMatrix(int[][] grid) {
        if(grid.length==1) return grid;

        int col = grid[0].length;
        int row = grid.length;

        int i = row-1;
        int j = 0;

        int iter = 0;

        for(int k = 0; k<row; k++){
            List<Integer> list = new ArrayList<>(); 

            for(int l = 0; l<iter+1; l++){
                list.add(grid[i+l][j+l]);
            }

            Collections.sort(list, Collections.reverseOrder());
            for(int l = 0; l<iter+1; l++){
                grid[i+l][j+l]=list.get(l);
            }
            
            iter++;
            i--;
        }


        iter = col - 2;
        i=0;
        j=1;
        for(int k = 0; k<col-1; k++){
            List<Integer> list = new ArrayList<>(); 

            for(int l = 0; l<iter+1; l++){
                list.add(grid[i+l][j+l]);
            }

            Collections.sort(list);
            for(int l = 0; l<iter+1; l++){
                grid[i+l][j+l]=list.get(l);
            }
            iter--;
            j++;
        }

        return grid;
    }
}