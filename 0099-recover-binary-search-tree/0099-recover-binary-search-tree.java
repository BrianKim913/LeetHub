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
    TreeNode prev = null;
    TreeNode firstNode = null;   
    TreeNode secondNode = null;
    
    private void swap(TreeNode node1, TreeNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        
        if (prev != null && root.val < prev.val) {
            if (firstNode == null) {
                firstNode = prev;   
                secondNode = root;  
            } else {
                secondNode = root;    
            }
        }
        prev = root;
        
        dfs(root.right);
    }

    public void recoverTree(TreeNode root) {
        dfs(root);
        if (firstNode != null && secondNode != null) {
            swap(firstNode, secondNode);
        }
    }
}
