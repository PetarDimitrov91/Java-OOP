package bakery.core;

import bakery.common.ExceptionMessages;
import bakery.common.OutputMessages;
import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.Bread;
import bakery.entities.bakedFoods.Cake;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.Tea;
import bakery.entities.drinks.Water;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.InsideTable;
import bakery.entities.tables.OutsideTable;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.*;

import static bakery.common.ExceptionMessages.*;
import static bakery.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Repository<BakedFood> foodRepository;
    private Repository<Drink> drinkRepository;
    private Repository<Table> tableRepository;
    private double totalIncome;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {
        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
        this.totalIncome = 0;
    }

    @Override
    public String addFood(String type, String name, double price) {
        for (BakedFood bakedFood : foodRepository.getAll()) {
            if (bakedFood.getName().equals(name)) {
                throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
            }
        }

        BakedFood food;
        switch (type) {
            case "Bread":
                food = new Bread(name, price);
                this.foodRepository.add(food);
                break;
            case "Cake":
                food = new Cake(name, price);
                this.foodRepository.add(food);
        }
        return String.format(FOOD_ADDED, name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        for (Drink drink : drinkRepository.getAll()) {
            if (drink.getName().equals(name)) {
                throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
            }
        }

        Drink drink;
        switch (type) {
            case "Tea":
                drink = new Tea(name, portion, brand);
                this.drinkRepository.add(drink);
                break;
            case "Water":
                drink = new Water(name, portion, brand);
                this.drinkRepository.add(drink);
                break;
        }
        return String.format(DRINK_ADDED, name, brand);
    }


    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        for (Table table : tableRepository.getAll()) {
            if (table.getTableNumber() == tableNumber) {
                throw new IllegalArgumentException(String.format(TABLE_EXIST, tableNumber));
            }
        }

        Table table;
        switch (type) {
            case "InsideTable":
                table = new InsideTable(tableNumber, capacity);
                tableRepository.add(table);
                break;
            case "OutsideTable":
                table = new OutsideTable(tableNumber, capacity);
                tableRepository.add(table);
                break;
        }

        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        for (Table table : tableRepository.getAll()) {
            if (table.getCapacity() >= numberOfPeople && !table.isReserved()) {
                table.reserve(numberOfPeople);
                return String.format(TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
            }
        }

        return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        Table table = tableExist(tableNumber);
        BakedFood food = foodExist(foodName);

        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        if (food == null) {
            return String.format(NONE_EXISTENT_FOOD, foodName);
        }

        for (Table table1 : tableRepository.getAll()) {
            if (table1.getTableNumber() == table.getTableNumber()) {
                table1.orderFood(food);
            }
        }

        return String.format(FOOD_ORDER_SUCCESSFUL, tableNumber, foodName);
    }

    private Table tableExist(int tableNumber) {
        for (Table table : tableRepository.getAll()) {
            if (table.getTableNumber() == tableNumber) {
                return table;
            }
        }
        return null;
    }

    private BakedFood foodExist(String foodName) {
        for (BakedFood bakedFood : foodRepository.getAll()) {
            if (bakedFood.getName().equals(foodName)) {
                return bakedFood;
            }
        }
        return null;
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        Table table = tableExist(tableNumber);
        Drink drink = drinkExist(drinkName, drinkBrand);

        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        if (drink == null) {
            return String.format(NON_EXISTENT_DRINK, drinkName, drinkBrand);
        }

        for (Table table1 : tableRepository.getAll()) {
            if (table1.getTableNumber() == tableNumber) {
                table1.orderDrink(drink);
            }
        }

        return String.format(DRINK_ORDER_SUCCESSFUL, tableNumber, drinkName, drinkBrand);
    }

    private Drink drinkExist(String drinkName, String drinkBrand) {
        for (Drink drink : drinkRepository.getAll()) {
            if (drink.getName().equals(drinkName) && drink.getBrand().equals(drinkBrand)) {
                return drink;
            }
        }
        return null;
    }

    @Override
    public String leaveTable(int tableNumber) {
        double bill = 0;

        for (Table table : tableRepository.getAll()) {
            if (table.getTableNumber() == tableNumber) {
                bill = table.getBill();
                table.clear();
            }
        }
        totalIncome += bill;
        return String.format(BILL, tableNumber, bill);
    }

    @Override
    public String getFreeTablesInfo() {
        StringBuilder sb = new StringBuilder();
        for (Table table : tableRepository.getAll()) {
            if (!table.isReserved()) {
                sb.append(table.getFreeTableInfo()).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String getTotalIncome() {
        return String.format(TOTAL_INCOME, totalIncome);
    }
}
