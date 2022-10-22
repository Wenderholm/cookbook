
import java.util.function.Function;

class CookBookApp {
    private static final RecipeDao DAO = new RecipeDao();

    public static void main(String[] args) {
        CookBookService cbs = new CookBookService();
        cbs.controlLoop();
//        create();
//        read();
//        update();
//        delete();
        DAO.close();
    }


    private static void update() {
        Function<Recipe, Recipe> updateRecipePrepTime = recipe -> {
            recipe.setPrepTime(60);
            return recipe;
        };
        DAO.findByTitle("Kurczak z frytkami")
                .map(updateRecipePrepTime)
                .map(recipe -> DAO.update(recipe))
                .filter(b -> b)
                .ifPresent(updated -> System.out.println("Czas przygotowania został zaktualizowany"));
    }

    private static void delete() {
        System.out.println("Usuwam przepis na rosół");
        DAO.findByTitle("Rosół")
                .map(recipe -> recipe.getId())
                .map(id -> DAO.delete(id))
                .ifPresentOrElse(removed -> System.out.println("Przepis został usunięty"),
                        () -> System.out.println("W bazie nie ma przepisu do usunięcia"));
    }
}