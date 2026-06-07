/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap();
        Set<Integer> set = new HashSet();

        for (int i = 0; i < descriptions.length; i++) {
            TreeNode parent = map.getOrDefault(descriptions[i][0], new TreeNode(descriptions[i][0]));
            TreeNode child = map.getOrDefault(descriptions[i][1], new TreeNode(descriptions[i][1]));

            boolean isLeft = descriptions[i][2] == 1;

            if(isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            map.put(parent.val, parent);
            map.put(child.val, child);
            set.add(child.val);

        }

        TreeNode root = null;
        for(int val: map.keySet()) {
            if(!set.contains(val)) {
                root = map.get(val);
                break;
            }
        }

        return root;
    }
}