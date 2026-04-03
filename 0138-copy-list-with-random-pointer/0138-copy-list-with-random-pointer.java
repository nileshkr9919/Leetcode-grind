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
        if (head == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        bfs(head, map);
        return map.get(head);
    }

    // DFS Approach
    // private void dfs(Node node, HashMap<Node, Node> map) {
    //     if (node == null)
    //         return;
    //     map.put(node, new Node(node.val));

    //     for (Node neighbour : node.neighbors) {
    //         if (!map.containsKey(neighbour)) {
    //             dfs(neighbour, map);
    //         }
    //         map.get(node).neighbors.add(map.get(neighbour));
    //     }
    // }

    // BFS Approach
    private void bfs(Node node, HashMap<Node, Node> map) {
        Deque<Node> queue = new LinkedList<>();
        map.put(node, new Node(node.val));
        queue.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr == null)
                return;

            if (curr.next != null && !map.containsKey(curr.next)) {
                map.put(curr.next, new Node(curr.next.val));
                queue.add(curr.next);
            }

            if (curr.random != null && !map.containsKey(curr.random)) {
                map.put(curr.random, new Node(curr.random.val));
                queue.add(curr.random);
            }
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
        }

    }
}