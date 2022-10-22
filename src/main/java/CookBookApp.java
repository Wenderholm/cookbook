
import java.util.function.Function;

class CookBookApp {
    private static final RecipeDao DAO = new RecipeDao();

    public static void main(String[] args) {
        CookBookService cbs = new CookBookService();
        cbs.controlLoop();
        DAO.close();
    }

}