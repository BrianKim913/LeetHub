class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiag = 0;
        int maxArea = 0;
        
        for(int i = 0; i < dimensions.length; i++) {
            double diag = Math.sqrt(Math.pow(dimensions[i][0], 2) + Math.pow(dimensions[i][1], 2));
            int area = dimensions[i][0] * dimensions[i][1];
            
            if(diag >= maxDiag) {
                if(diag==maxDiag){
                    maxArea = Math.max(maxArea, area);
                    maxDiag=diag;
                    continue;
                }
                maxDiag = diag;
                maxArea = area;
            }
        }
        
        return maxArea;
    }
}