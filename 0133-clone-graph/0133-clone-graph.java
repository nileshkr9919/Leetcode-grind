/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        dfs(node, map);
        return map.get(node);
    }

    private void dfs(Node node, HashMap<Node, Node> map) {
        if (node == null)
            return;
        map.put(node, new Node(node.val));

        Node copy = new Node(node.val);
        for (Node neighbour : node.neighbors) {
            if (!map.containsKey(neighbour)) {
                dfs(neighbour, map);
            }
            map.get(node).neighbors.add(map.get(neighbour));
        }
    }
}