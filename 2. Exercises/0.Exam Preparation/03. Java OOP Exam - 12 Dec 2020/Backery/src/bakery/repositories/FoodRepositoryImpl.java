package bakery.repositories;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.repositories.interfaces.FoodRepository;

public class FoodRepositoryImpl extends RepositoryImpl<BakedFood> implements FoodRepository<BakedFood> {
    public FoodRepositoryImpl() {
        super();
    }

    @Override
    public BakedFood getByName(String name) {
        return null;
    }

}
