package bakery.entities.tables;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.*;

public abstract class BaseTable implements Table {
    private Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        setTableNumber(tableNumber);
        setCapacity(capacity);
        setPricePerPerson(pricePerPerson);
        this.isReserved = false;
        this.price = 0;
        this.drinkOrders = new ArrayList<>();
        this.foodOrders = new ArrayList<>();
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    public void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return tableNumber;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        isReserved = true;
    }

    @Override
    public void orderFood(BakedFood food) {
        foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        double sumOfFoods = foodOrders.stream()
                .map(BakedFood::getPrice)
                .mapToDouble(e -> e)
                .sum();

        double sumOfDrinks = drinkOrders.stream()
                .map(Drink::getPrice)
                .mapToDouble(e -> e)
                .sum();

        return sumOfDrinks + sumOfFoods + (numberOfPeople * pricePerPerson);
    }

    @Override
    public void clear() {
        drinkOrders.clear();
        foodOrders.clear();
        setPrice(0);
        numberOfPeople = 0;
        setReserved(false);
    }

    protected abstract String getType();

    @Override
    public String getFreeTableInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Table: %d", getTableNumber())).append(System.lineSeparator());
        sb.append(String.format("Type: %s", getType())).append(System.lineSeparator());
        sb.append(String.format("Capacity: %d", getCapacity())).append(System.lineSeparator());
        sb.append(String.format("Price per Person: %.2f", getPricePerPerson()));
        return sb.toString().trim();
    }
}
