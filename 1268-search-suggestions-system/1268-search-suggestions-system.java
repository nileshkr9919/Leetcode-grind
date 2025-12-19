class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        List<String> sortedProducts = new ArrayList<>();

        for (int i = 0; i < products.length; i++) {
            String product = products[i].toLowerCase();
            if (product.startsWith(searchWord.substring(0,1))) {
                sortedProducts.add(product);
            }
        }
        Collections.sort(sortedProducts);

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