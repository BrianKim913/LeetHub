class Solution {
    public int trap(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length-1;
        int leftMax = height[left];
        int rightMax = height[right];

        while (left<right){
            leftMax = Math.max(height[left],leftMax);
            rightMax = Math.max(height[right],rightMax);

            if(leftMax<=rightMax){
                res += leftMax-height[left];
                left++;
            }

            else{
                res += rightMax-height[right];
                right--;
            }
        
        
        }

        return res;
        
    }
}