package bakery;

import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;

import bakery.repositories.interfaces.*;

public class Main {
    public static void main(String[] args) {

        String a = " ";
        int a1 = a.length();
        FoodRepository<BakedFood> foodRepository; // TODO:  new FoodRepositoryImpl<>();
        DrinkRepository<Drink> drinkRepository;  // TODO:  new DrinkRepositoryImpl<>();
        TableRepository<Table> tableRepository; // TODO:  new TableRepositoryImpl<>();

        Controller controller; // TODO: new ControllerImpl(foodRepository, drinkRepository, tableRepository);

        // TODO:OPTIONAL
//        ConsoleReader reader = new ConsoleReader();
//        ConsoleWriter writer = new ConsoleWriter();
//        EngineImpl engine = new EngineImpl(reader, writer, controller);
//        engine.run();
    }
}
