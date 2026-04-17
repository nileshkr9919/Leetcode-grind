class Solution {
    private Map<String, String> parent; // email -> parent email
    private Map<String, String> owner; // email -> account name

    public void init() {
        this.parent = new HashMap<>();
        this.owner = new HashMap<>();
    }

    public String find(String email) {
        if (!parent.containsKey(email))
            parent.put(email, email);
        if (!parent.get(email).equals(email))
            parent.put(email, find(parent.get(email)));
        return parent.get(email);
    }

    public boolean union(String u, String v) {
        String px = find(u);
        String py = find(v);
        if (px.equals(py)) {
            return false;
        }
        parent.put(px, py);
        return true;
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        init();
        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                this.owner.put(account.get(i), name);

                if (!parent.containsKey(email))
                    parent.put(email, email);

                union(firstEmail, email);
            }
        }

        Map<String, List<String>> groups = new HashMap<>();

        for (String email : parent.keySet()) {
            String root = find(email);
            groups.computeIfAbsent(root, x -> new ArrayList<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : groups.entrySet()) {
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            emails.add(0, owner.get(entry.getKey()));
            result.add(emails);
        }

        return result;
    }
}