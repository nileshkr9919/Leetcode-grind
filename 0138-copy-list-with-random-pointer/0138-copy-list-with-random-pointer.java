class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        map.put(head, new Node(head.val));
        queue.add(head);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.next != null) {
                if (!map.containsKey(curr.next)) {
                    map.put(curr.next, new Node(curr.next.val));
                    queue.add(curr.next);
                }
                map.get(curr).next = map.get(curr.next);
            }

            if (curr.random != null) {
                if (!map.containsKey(curr.random)) {
                    map.put(curr.random, new Node(curr.random.val));
                    queue.add(curr.random);
                }
                map.get(curr).random = map.get(curr.random);
            }
        }

        return map.get(head);
    }
}