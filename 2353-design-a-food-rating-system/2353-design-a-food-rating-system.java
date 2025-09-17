class FoodRatings {
    private HashMap<String, Integer> foodToIndex;
    private HashMap<String, TreeSet<Food>> cuisineToFoods;
    private String[] foods;
    private String[] cuisines; 
    private int[] ratings;
    
    class Food implements Comparable<Food> {
        String name;
        int rating;
        
        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
        
        @Override
        public int compareTo(Food other) {
            if (this.rating != other.rating) {
                return Integer.compare(other.rating, this.rating);
            }
            return this.name.compareTo(other.name);
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Food food = (Food) obj;
            return rating == food.rating && Objects.equals(name, food.name);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(name, rating);
        }
    }
    
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;
        
        foodToIndex = new HashMap<>();
        cuisineToFoods = new HashMap<>();
        
        for (int i = 0; i < foods.length; i++) {
            foodToIndex.put(foods[i], i);
            
            if (!cuisineToFoods.containsKey(cuisines[i])) {
                cuisineToFoods.put(cuisines[i], new TreeSet<>());
            }
            
            cuisineToFoods.get(cuisines[i]).add(new Food(foods[i], ratings[i]));
        }
    }
    
    public void changeRating(String food, int newRating) {
        int index = foodToIndex.get(food);
        int oldRating = ratings[index];
        String cuisine = cuisines[index];
        
        cuisineToFoods.get(cuisine).remove(new Food(food, oldRating));
        
        ratings[index] = newRating;
        
        cuisineToFoods.get(cuisine).add(new Food(food, newRating));
    }
    
    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).first().name;
    }
}