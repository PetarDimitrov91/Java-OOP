package restaurant.core;

import restaurant.core.interfaces.Controller;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.*;

public class ControllerImpl implements Controller {


    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {

    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        //TODO:
        return null;
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name){
        //TODO:
        return null;
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        //TODO:
        return null;
    }

    @Override
    public String reserve(int numberOfPeople) {
        //TODO:
        return null;
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        //TODO:
        return null;
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        //TODO:
        return null;
    }

    @Override
    public String closedBill(int tableNumber) {
        //TODO:
        return null;
    }


    @Override
    public String totalMoney() {
        //TODO:
        return null;
    }
}
