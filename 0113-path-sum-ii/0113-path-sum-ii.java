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
    List<List<Integer>> res = new ArrayList<>();
    int target;

    public void dfs(TreeNode node, int sum, List<Integer> path) {
        if (node == null) return;
        
        List<Integer> newPath = new ArrayList<>(path);
        newPath.add(node.val);
        sum += node.val;
        
        if (node.left == null && node.right == null) {
            if (sum == target) {
                res.add(newPath);
            }
            return;
        }
        
        dfs(node.left, sum, newPath);
        dfs(node.right, sum, newPath);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        if(root==null)return res;
        dfs(root, 0, new ArrayList<Integer>());
        return res;
    }
}