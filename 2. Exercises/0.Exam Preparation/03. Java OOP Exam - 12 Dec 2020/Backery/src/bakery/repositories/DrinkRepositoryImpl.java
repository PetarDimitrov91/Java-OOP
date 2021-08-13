package bakery.repositories;

import bakery.entities.drinks.interfaces.Drink;
import bakery.repositories.interfaces.DrinkRepository;

public class DrinkRepositoryImpl<BaseDrink> extends RepositoryImpl<Drink> implements DrinkRepository<Drink> {

    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        return getAll().stream()
                .filter(e -> e.getName().equals(drinkName) && e.getBrand().equals(drinkBrand))
                .findFirst()
                .orElse(null);
    }


}
