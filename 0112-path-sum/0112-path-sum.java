/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int target;
    private boolean getSum(TreeNode node, int sum){
        if(node==null) return false;
        sum = sum + node.val;
        if(node.left==null && node.right==null){
            return sum==target;
        }
        
        return (getSum(node.left, sum)|| getSum(node.right, sum)); 
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        this.target = targetSum;
        if(root.left==null && root.right!=null) return getSum(root.right, root.val);
        if(root.right==null && root.left!=null) return getSum(root.left, root.val);
        return getSum(root, 0);
    }
}


