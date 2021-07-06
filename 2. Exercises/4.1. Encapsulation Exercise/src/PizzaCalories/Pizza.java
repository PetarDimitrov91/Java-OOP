package PizzaCalories;

import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings){

    }

    private void setToppings(int numberOfToppings){

    }

    private void setName (String name){

    }

    public void setDough(Dough dough){

    }

    public String getName (){
        return this.name;
    }

    public void addTopping(Topping topping){
        toppings.add(topping);
    }

    public double getOverallCalories(){
        return 0.0;
    }

}
