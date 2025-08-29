class Solution {
    int[] colors;
    int[][] mem;
    public int find(int idx, int iter, int target){
        int right = idx+iter;
        int left  = idx-iter;

        if(right>=colors.length && left<0){
            return -1;
        }

        if(left>=0 && right<colors.length){
            if(colors[left]==target || colors[right]==target){
                mem[idx][target]=iter;
                return iter;
            }
        }

        if(right>=colors.length){
            if(colors[left]==target){
                mem[idx][target]=iter;
                return iter;
            }
        }

        if(left<0){
            if(colors[right]==target){
                mem[idx][target]=iter;
                return iter;
            }
        }

        iter++;
        return find(idx, iter, target);
    }
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        this.colors=colors;
        this.mem = new int[colors.length][4];
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i<queries.length; i++){
            if(mem[queries[i][0]][queries[i][1]]!=0){
                res.add(mem[queries[i][0]][queries[i][1]]);
                continue;
            } 
            res.add(find(queries[i][0],0,queries[i][1]));
        }
        


        return res;
    }
}