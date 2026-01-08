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
    public int maxLevelSum(TreeNode root) {
        Deque<List<TreeNode>> queue = new ArrayDeque<>();
        TreeNode current = root;
        List<TreeNode> firstLevel = new ArrayList<>();
        firstLevel.add(root);
        queue.offer(firstLevel);

        long maxSum = Long.MIN_VALUE;
        int level = 0, maxSumLevel = 0;
        while (queue.size() > 0) {
            level++;
            List<TreeNode> levelNodes = queue.pollFirst();
            List<TreeNode> nextLevel = new ArrayList<>();
            Long sum = 0L;

            for (TreeNode node : levelNodes) {
                sum += node.val;

                if (node.left != null)
                    nextLevel.add(node.left);
                if (node.right != null)
                    nextLevel.add(node.right);
            }
            if (nextLevel.size() > 0)
                queue.offer(nextLevel);

            System.out.println(sum + " " + maxSum);
            if (sum > maxSum) {
                maxSum = sum;
                maxSumLevel = level;
            }
        }

        return maxSumLevel;
    }
}