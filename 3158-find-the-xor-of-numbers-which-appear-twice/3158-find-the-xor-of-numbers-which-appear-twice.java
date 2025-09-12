class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            if(map.containsKey(num)) map.put(num,map.get(num)+1);
            else map.put(num,1);
        }
        int res = 0;
        if(map.keySet().size()==1 && map.values().contains(2)) return (int)map.keySet().iterator().next();
        for(int key : map.keySet()){
            if(map.get(key)==2){
                res^=key;
            }
        }
        return res;
    }
}