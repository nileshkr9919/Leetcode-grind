class FoodItemDetails {
    String food;
    String cuisine;
    int rating;

    public FoodItemDetails(String food, String cuisine, int rating) {
        this.food = food;
        this.cuisine = cuisine;
        this.rating = rating;
    }
}

class FoodRatings {
    private HashMap<String, FoodItemDetails> foodDetailsById;
    private HashMap<String, PriorityQueue<FoodItemDetails>> ratingsByCuisine;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foodDetailsById = new HashMap<>();
        this.ratingsByCuisine = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            FoodItemDetails obj = new FoodItemDetails(foods[i], cuisines[i], ratings[i]);
            foodDetailsById.put(foods[i], obj);
            ratingsByCuisine
                    .computeIfAbsent(cuisines[i],
                            k -> new PriorityQueue<>(
                                    Comparator.comparingInt((FoodItemDetails item) -> item.rating).reversed()
                                            .thenComparing(item -> item.food)))
                    .offer(obj);
        }
    }

    public void changeRating(String food, int newRating) {
        FoodItemDetails old = foodDetailsById.get(food);
        FoodItemDetails updated = new FoodItemDetails(food, old.cuisine, newRating);

        foodDetailsById.put(food, updated);
        ratingsByCuisine.get(old.cuisine).offer(updated);
    }

    public String highestRated(String cuisine) {
        return ratingsByCuisine.get(cuisine).peek().food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */