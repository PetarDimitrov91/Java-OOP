package bakery.core;

import bakery.common.ExceptionMessages;
import bakery.common.OutputMessages;
import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.*;

public class ControllerImpl implements Controller {


    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {

    }


    @Override
    public String addFood(String type, String name, double price) {
        //TODO:
        return null;
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        //TODO:
        return null;
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        //TODO:
        return null;
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        //TODO:
        return null;
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        //TODO:
        return null;
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        //TODO:
        return null;

    }

    @Override
    public String leaveTable(int tableNumber) {
        //TODO:
        return null;
    }

    @Override
    public String getFreeTablesInfo() {
        //TODO:
        return null;
    }

    @Override
    public String getTotalIncome() {
        //TODO:
        return null;
    }
}
