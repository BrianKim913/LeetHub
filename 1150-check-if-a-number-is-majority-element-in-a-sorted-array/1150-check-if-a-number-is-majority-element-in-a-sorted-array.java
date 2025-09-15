class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int cnt = 0;
        for(int num : nums){
            if(num == target){
                cnt++;
                if(cnt>nums.length/2) return true;
            }
        }

        return false;
        
    }
}