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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList();
        traversal(list, root);
        return list;
    }
    public void traversal(List<Integer> list, TreeNode node) {
        if(node == null) {
            return;
        }
        traversal(list, node.left);
        list.add(node.val);
        traversal(list, node.right);
    }
}