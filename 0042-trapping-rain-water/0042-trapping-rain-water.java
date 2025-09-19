class Solution {
    public int trap(int[] height) {
        
        int left =0;
        int right = height.length-1;
        int leftMax = height[left];
        int rightMax = height[right];

        int res = 0;

        while(left<right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(rightMax>=leftMax){
                res += leftMax-height[left];
                left++;
                continue;
            }
            else{
                res+= rightMax-height[right];
                right--;
                continue;
            }
        } 

        return res;
    }
}