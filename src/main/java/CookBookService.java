import exception.NoSuchOptionException;

import javax.swing.text.html.Option;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Function;

public class CookBookService {
    private Scanner sc = new Scanner(System.in);
    private static final RecipeDao DAO = new RecipeDao();


    void controlLoop() {
        Option option;

        do {
            printOptions();
            option = getOption();
            switch (option) {
                case ADD_RECIPE:
                    create();
                    break;
                case DELETE_RECIPE:
//                    addMagazine();
                    break;
                case UPDATE_RECIPE:
//                    printBooks();
                    break;
                case PRINT_RECIPE:
//                    printMagazines();
                    break;
                case FIND_RECIPE:
                    read();
                    break;
                case EXIT:
                    System.out.println(("Koniec programu, papa!"));
                    break;
                default:
                    System.out.println("Nie ma takiej opcji, wprowadź ponownie: ".toUpperCase());
            }
        } while (option != Option.EXIT);
    }
    private void printOptions() {
        System.out.println("Wybierz opcję: ");
        for (Option option : Option.values()) {
            System.out.println(option.toString());
        }
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk) {
            try {
                option = Option.createFromInt(getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                System.out.println((e.getMessage()));
            } catch (InputMismatchException e) {
                System.out.println(("wprowadzono wartość, która nie jest liczbą. podaj ponownie"));
            }
        }
        return option;
    }

    public int getInt() {
        try {
            return sc.nextInt();
        } finally {
            sc.nextLine();
        }
    }

    private enum Option {
        EXIT(0, "wyjście z programu"),
        ADD_RECIPE(1, "dodanie nowego przepisu"),
        DELETE_RECIPE(2, "usunięcie przepisu"),
        UPDATE_RECIPE(3, "aktualizacja przepisu"),
        PRINT_RECIPE(4, "wyswietlenie przepisu"),
        FIND_RECIPE(5, "wyszukanie przepisu po nazwie");

        private final int value;
        private final String description;


        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        static Option createFromInt(int option) throws NoSuchOptionException {
            try {
                return Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("Brak opcji o id " + option + ". Proszę wybrać inna z powyższej listy");
            }

        }
    }


    public void create() {
        System.out.println("podaj nazwę przepisu: ");
        String title = sc.nextLine();
        System.out.println("dodaj opis przepisu: ");
        String description = sc.nextLine();
        System.out.println("dodaj składniki: ");
        String ingredients = sc.nextLine();
        System.out.println("podaj czas przygotowania: ");
        int prepTime = getInt();

        Recipe recipe = new Recipe(title, description, ingredients, prepTime);
        System.out.println("Zapisuję przepis na: " + title);
        DAO.save(recipe);
        System.out.println("Przepis zapisany, jego id to: " + recipe.getId());
    }

    public void read() {
        System.out.println("podaj dokladna nazwe przepisu do wyszukania: ");
        String title = sc.nextLine();
        DAO.findByTitle(title).ifPresentOrElse(
                recipe -> System.out.println("Szukany przepis:\n" + recipe),
                () -> System.out.println("Brak przepisu o takiej nazwie")
        );
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
