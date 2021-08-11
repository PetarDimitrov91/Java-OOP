package bakery.repositories;

import bakery.repositories.interfaces.DrinkRepository;

public class DrinkRepositoryImpl<Drink> extends RepositoryImpl<Drink> implements DrinkRepository<Drink> {

    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        return null;
    }


}
