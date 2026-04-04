/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();

        dfs(head, map);

        return map.get(head);
    }

    private void dfs(Node node, HashMap<Node, Node> map) {
        if (node == null) {
            return;
        }

        Node copy = new Node(node.val);
        map.put(node, copy);

        if (node.next != null) {
            if (!map.containsKey(node.next)) {
                dfs(node.next, map);
            }
        }

        if (node.random != null) {
            if (!map.containsKey(node.random)) {
                dfs(node.random, map);
            }
        }

        copy.next = map.get(node.next);
        copy.random = map.get(node.random);
    }
}