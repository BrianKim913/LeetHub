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

    public boolean bfs(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        TreeNode leftRoot = left;
        TreeNode rightRoot = right;

        TreeNode leftL = leftRoot.left;
        TreeNode leftR = leftRoot.right;
        TreeNode rightL = rightRoot.left;
        TreeNode rightR = rightRoot.right;
        return bfs(leftL, rightR) && bfs(leftR, rightL);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        if(root.left==null && root.right==null) return true;
        if(root.left==null || root.right==null) return false;

        TreeNode left = root.left;
        TreeNode right = root.right;

        if(left==null && right==null)  return true; 
        if(left==null || right== null) return false;

        return bfs(left,right);
    }
}