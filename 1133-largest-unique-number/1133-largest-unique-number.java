class Solution {
    public int largestUniqueNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
            
        }
        int res = -1;
        for(int key : map.keySet()){
            if(map.get(key)==1){
                res = Math.max(res, key);
            }
        }
        return res;
    }
}