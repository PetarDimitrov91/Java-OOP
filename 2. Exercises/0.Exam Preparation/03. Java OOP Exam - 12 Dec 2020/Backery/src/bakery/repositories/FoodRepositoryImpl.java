package bakery.repositories;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.repositories.interfaces.FoodRepository;

public class FoodRepositoryImpl<bakedFood> extends RepositoryImpl<bakedFood> implements FoodRepository<bakedFood> {

    @Override
    public bakedFood getByName(String name) {
        return null;
    }

}
