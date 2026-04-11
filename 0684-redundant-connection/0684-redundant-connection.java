class Solution {
    int[] parent;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        init(edges.length + 1);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (!union(u, v)) {
                return edge;
            }
        }

        return new int[] {};
    }

    public void init(int n) {
        this.parent = new int[n];
        this.rank = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);

        return parent[x];
    }

    public boolean union(int u, int v) {
        int px = find(u);
        int py = find(v);
        if (px == py) {
            return false;
        }
        if (rank[px] < rank[py]) {
            int t = px;
            px = py;
            py = t;
        }
        parent[py] = px;
        if (rank[px] == rank[py])
            rank[px]++;
        return true;
    }
}