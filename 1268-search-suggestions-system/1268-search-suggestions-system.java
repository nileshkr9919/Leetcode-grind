class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products);
        String queryString = searchWord.toLowerCase();

        for (int i = 1; i <= queryString.length(); i++) {
            String query = queryString.substring(0, i);
            List<String> resultForTempQuery = new ArrayList<>();

            for (String product : products) {
                if (product.startsWith(query) && resultForTempQuery.size() < 3) {
                    resultForTempQuery.add(product);
                }
            }

            result.add(resultForTempQuery);
        }

        return result;
    }
}