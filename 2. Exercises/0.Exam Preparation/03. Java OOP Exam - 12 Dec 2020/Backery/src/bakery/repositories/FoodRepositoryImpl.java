package bakery.repositories;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.repositories.interfaces.FoodRepository;

public class FoodRepositoryImpl<BaseFood> extends RepositoryImpl<BakedFood> implements FoodRepository<BakedFood> {

    @Override
    public BakedFood getByName(String name) {
        return getAll().stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

}
