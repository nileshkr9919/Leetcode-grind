class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        String[] sortedProducts = new String[products.length];

        for (int i = 0; i < products.length; i++) {
            sortedProducts[i] = products[i].toLowerCase();
        }
        Arrays.sort(sortedProducts);

        for (int i = 1; i <= searchWord.length(); i++) {
            String query = searchWord.substring(0, i);
            List<String> resultForTempQuery = new ArrayList<>();

            for (String product : sortedProducts) {
                if (product.startsWith(query.toLowerCase()) && resultForTempQuery.size() < 3) {
                    resultForTempQuery.add(product);
                }
            }

            result.add(resultForTempQuery);
        }

        return result;
    }
}