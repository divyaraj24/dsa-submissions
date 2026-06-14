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

public class Solution {

    public int dfs(TreeNode root, int[] d) {
        if (root == null) return 0;

        int left = dfs(root.left, d);
        int right = dfs(root.right, d);

        d[0] = Math.max(d[0], left + right);

        return 1 + Math.max(left, right);

    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] d = new int[1];
        dfs(root, d);
        return d[0];
    }
}