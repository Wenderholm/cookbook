public class Recipe {
    private Integer id;
    private String title;
    private String description;
    private String ingredients;
    private int prepTime;

    public Recipe(String title, String description, String ingredients, int prepTime) {
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
        this.prepTime = prepTime;
    }

    public Recipe(Integer id, String title, String description, String ingredients, int prepTime) {
        this(title,description, ingredients, prepTime);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    @Override
    public String toString() {
        return title +
                ",\n - składniki: " + ingredients  +
                ",\n - czas przygotowania: " + prepTime + "(min)" +
                ",\n - sposób przygotowania: " + description;
    }
}
