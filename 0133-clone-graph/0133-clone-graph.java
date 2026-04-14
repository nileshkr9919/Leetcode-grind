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

    // private void dfs(Node node, HashMap<Node, Node> map) {
    //     if (node == null || map.containsKey(node)) {
    //         return;
    //     }

    //     Node copy = new Node(node.val);
    //     map.put(node, copy);

    //     for (Node nei : node.neighbors) {
    //         if (!map.containsKey(nei)) {
    //             dfs(nei, map);
    //         }
    //         map.get(node).neighbors.add(map.get(nei));
    //     }
    // }

    private void bfs(Node node, HashMap<Node, Node> map) {
        if (node == null) {
            return;
        }

        Deque<Node> queue = new LinkedList<>();

        Node copy = new Node(node.val);
        map.put(node, copy);

        queue.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (Node nei : curr.neighbors) {
                if (!map.containsKey(nei)) {
                    Node neicopy = new Node(nei.val);
                    map.put(nei, neicopy);
                    queue.add(nei);
                }
                map.get(curr).neighbors.add(map.get(nei));
            }
        }
    }
}