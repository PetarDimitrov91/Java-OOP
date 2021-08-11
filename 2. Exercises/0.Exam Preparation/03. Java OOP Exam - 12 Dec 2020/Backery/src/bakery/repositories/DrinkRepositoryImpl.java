package bakery.repositories;

import bakery.entities.drinks.interfaces.Drink;
import bakery.repositories.interfaces.DrinkRepository;

import java.util.Collection;

public class DrinkRepositoryImpl extends RepositoryImpl<Drink> implements DrinkRepository<Drink> {

    public DrinkRepositoryImpl() {
        super();
    }

    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        return null;
    }

    @Override
    public Collection<Drink> getAll() {
        return null;
    }

    @Override
    public void add(Drink drink) {

    }
}
