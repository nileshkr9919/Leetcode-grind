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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res, k);
        return res.get(k - 1);
    }

    private void inOrder(TreeNode node, List<Integer> res, int k) {
        if (node == null || res.size() >= k)
            return;
        inOrder(node.left, res, k);
        if (res.size() >= k)
            return;

        res.add(node.val);
        inOrder(node.right, res, k);
    }
}
