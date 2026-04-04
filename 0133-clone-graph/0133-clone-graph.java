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
        bfs(node, map);
        return map.get(node);
    }

    // DFS Approach
    // private void dfs(Node node, HashMap<Node, Node> map) {
    //     if (node == null || map.containsKey(node))
    //         return;

    //     Node copy = new Node(node.val);
    //     map.put(node, copy);

    //     for (Node neighbor : node.neighbors) {
    //         if (!map.containsKey(neighbor)) {
    //             dfs(neighbor, map);
    //         }
    //         map.get(node).neighbors.add(map.get(neighbor));
    //     }
    // }

    // BFS Approach
    private void bfs(Node node, HashMap<Node, Node> map) {
        if (node == null)
            return;
        Deque<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (!map.containsKey(curr)) {
                Node copy = new Node(curr.val);
                map.put(curr, copy);
            }

            for (Node neighbor : curr.neighbors) {
                if (neighbor != null && !map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }
    }
}