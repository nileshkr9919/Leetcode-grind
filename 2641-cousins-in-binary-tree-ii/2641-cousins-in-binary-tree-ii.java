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
    public TreeNode replaceValueInTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Long> levelSums = new ArrayList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            List<TreeNode> nodes = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                nodes.add(node);
                sum += node.val;

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            levelSums.add(sum);
        }

        queue.offer(root);
        root.val = 0;
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode parent = queue.poll();
                long siblingSum = 0;
                if (parent.left != null)
                    siblingSum += parent.left.val;
                if (parent.right != null)
                    siblingSum += parent.right.val;

                if (parent.left != null) {
                    parent.left.val = (int) (levelSums.get(level) - siblingSum);
                    queue.offer(parent.left);
                }
                if (parent.right != null) {
                    parent.right.val = (int) (levelSums.get(level) - siblingSum);
                    queue.offer(parent.right);
                }
            }
            level++;
        }

        return root;
    }
}