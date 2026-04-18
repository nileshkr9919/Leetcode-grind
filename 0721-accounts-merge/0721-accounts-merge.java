class Solution {
    Map<String, String> parent; // email -> parent email
    Map<String, String> owner; // email -> owner

    private void init() {
        this.parent = new HashMap<>();
        this.owner = new HashMap<>();
    }

    private String find(String x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x);
        }
        if (!parent.get(x).equals(x)) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    private boolean union(String email1, String email2) {
        String parent1 = find(email1);
        String parent2 = find(email2);

        if (parent1.equals(parent2)) {
            return false;
        }

        parent.put(parent2, parent1);

        return true;
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        init();
        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);

            for (int i = 1; i < account.size(); i++) {
                union(firstEmail, account.get(i));
                owner.put(account.get(i), name);

            }
        }

        Map<String, List<String>> groups = new HashMap<>();

        for (String key : parent.keySet()) {
            String primaryEmail = find(key);
            if (!groups.containsKey(primaryEmail)) {
                groups.put(primaryEmail, new ArrayList<>());
            }
            groups.get(primaryEmail).add(key);
        }

        List<List<String>> res = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : groups.entrySet()) {
            List<String> item = new ArrayList();
            item.add(owner.get(entry.getKey()));
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            for (String val : emails) {
                item.add(val);
            }
            res.add(item);
        }

        return res;
    }
}